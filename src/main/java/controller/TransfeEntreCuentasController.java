package controller;

import dao.CuentaDAO;
import dao.TransferenciaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cuenta;
import model.DatosFormulario;
import model.Transferencia;
import view.frmConfirmarClave;
import view.frmTransferencias;
import view.frmTransferenciasEntreCuentas;

/**
 *
 * @author HP
 */
public class TransfeEntreCuentasController implements ActionListener{
    private frmTransferenciasEntreCuentas formularioTransferenciasEntreCuentas;
    private frmTransferencias formularioTransferencias;
    private frmConfirmarClave formularioConfirmarClave;
    private CuentaDAO cuentaDao = new CuentaDAO();
    private DatosFormulario datosFormulario;
    private Transferencia transferencia;
    private TransferenciaDAO transferenciaDAO = new TransferenciaDAO();
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;

    public TransfeEntreCuentasController(frmTransferenciasEntreCuentas formularioTransferenciasEntreCuentas) {
        this.formularioTransferenciasEntreCuentas = formularioTransferenciasEntreCuentas;
        this.formularioTransferenciasEntreCuentas.setResizable(false);//Desabilirar el cambio de tamaño
        this.formularioTransferenciasEntreCuentas.setLocationRelativeTo(null);//Establecer en el centro
        this.formularioTransferenciasEntreCuentas.btnInicio.addActionListener(this);
        this.formularioTransferenciasEntreCuentas.btnSiguiente.addActionListener(this);
        this.formularioTransferenciasEntreCuentas.cbCuentaOrigen.addActionListener(this);
        this.formularioTransferenciasEntreCuentas.cbCuentaDestino.addActionListener(this);
        this.datosFormulario = DatosFormulario.getInstance();
        listadoCbCuentaOrigen();
    }
    
    public void listadoCbCuentaOrigen() {
        //Obtener el idCleinte almacenado
        int idCliente = datosFormulario.getIdCliente();
        formularioTransferenciasEntreCuentas.cbCuentaOrigen.removeAllItems();
        // Obtener la lista de cuentas del cliente
        ArrayList<Cuenta> cuentas = (ArrayList<Cuenta>) cuentaDao.listar(idCliente);
        //Agregar en el combobox
        for (Cuenta x : cuentas) {
            formularioTransferenciasEntreCuentas.cbCuentaOrigen.addItem(x.getNumeroCuenta()+" - "+x.getTipo());
        }
    }
    
    public void listadoCbCuentaDestino() {
        //Obtener el idCleinte almacenado
        int idCliente = datosFormulario.getIdCliente();
        formularioTransferenciasEntreCuentas.cbCuentaDestino.removeAllItems();
        // Obtener la lista de cuentas del cliente
        ArrayList<Cuenta> cuentas = (ArrayList<Cuenta>) cuentaDao.listar(idCliente);
        try{
            //obtner el número de cuenta seleccionado de cbNumeroOrigen
            int numcbOrigenSeleccionada = formularioTransferenciasEntreCuentas.cbCuentaOrigen.getSelectedIndex();
            System.out.println("combo selecionada: "+ numcbOrigenSeleccionada);
            //Agregar las cuentas restantes
        int contador=0;    
        for (Cuenta x : cuentas) {
            String numeroCuenta = x.getNumeroCuenta();
            //verificando si la cuenta no es igual a la selecionada
            if(contador != numcbOrigenSeleccionada){
                formularioTransferenciasEntreCuentas.cbCuentaDestino.addItem(x.getNumeroCuenta()+" - "+x.getTipo());
            }
            contador++;
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(formularioTransferenciasEntreCuentas.btnInicio)){
            formularioTransferencias = new frmTransferencias();
            formularioTransferencias.setVisible(true);
            this.formularioTransferenciasEntreCuentas.dispose();
        }
        if(e.getSource().equals(formularioTransferenciasEntreCuentas.btnSiguiente)){
            //Almacenar los datos en memoria
            String cuentaOrigenSeleccionada = formularioTransferenciasEntreCuentas.cbCuentaOrigen.getSelectedItem().toString().substring(0, 16);
            String cuentaDestinoSeleccionada = formularioTransferenciasEntreCuentas.cbCuentaDestino.getSelectedItem().toString().substring(0, 16);
            //Obtener el monto que no este vacio
            String textoMonto = formularioTransferenciasEntreCuentas.txtMonto.getText();
            if (!textoMonto.isEmpty() && textoMonto.matches("[0-9]+(\\.\\d{1,2})?")) {
                double monto = Double.parseDouble(textoMonto);
                //obtener el id de la cuenta origen y destino
                cuentaOrigen = cuentaDao.getOne(cuentaOrigenSeleccionada);
                cuentaDestino = cuentaDao.getOne(cuentaDestinoSeleccionada);
                //validar que le monto minimo sea 1 sol o 0.27 y el máximo sea menor o igual que el saldo de la cuenta
                if((monto >= 1 || monto >= 0.27) && monto <= cuentaOrigen.getSaldo()){
                    datosFormulario.setIdCuentaOrigen(cuentaOrigen.getIdCuenta());
                    datosFormulario.setIdCuentaDestino(cuentaDestino.getIdCuenta());
                    datosFormulario.setNumeroCuentaOrigen(cuentaOrigenSeleccionada);
                    datosFormulario.setNumeroCuentaDestino(cuentaDestinoSeleccionada);
                    datosFormulario.setSaldoOrigen(cuentaOrigen.getSaldo());
                    datosFormulario.setSaldoDestino(cuentaDestino.getSaldo());
                    datosFormulario.setMonto(monto);
                    //Tipo de moneda
                    datosFormulario.setTipoMonedaCuentaOrigen(cuentaOrigen.getMoneda());
                    datosFormulario.setTipoMonedaCuentaDestino(cuentaDestino.getMoneda());
                    //Mostrar el formulario de confirmación
                    formularioConfirmarClave = new frmConfirmarClave();
                    formularioConfirmarClave.setVisible(true);
                    this.formularioTransferenciasEntreCuentas.dispose();
                }else{
                    //Mostrar mensaje de los montos a depositar
                    JOptionPane.showMessageDialog(formularioTransferencias, "Monto mínimo:\n"
                                + "Para soles es de S/. 1\n"
                                + "Para dólares es de $ 0.27");
                }
            } else {
                // Mostrar un mensaje de error o realizar alguna acción en caso de entrada inválida
                JOptionPane.showMessageDialog(formularioTransferencias, "El monto es invalido");
            }
        }
        // Actualizar los JComboBox de cuentas en formularioTransferenciasEntreCuentas
        if (e.getSource().equals(formularioTransferenciasEntreCuentas.cbCuentaOrigen)) {
            listadoCbCuentaDestino();
        }
    }
    
    
}
