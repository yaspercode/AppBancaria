package controller;

import dao.CuentaDAO;
import dao.TransferenciaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cuenta;
import model.DatosFormulario;
import model.Transferencia;
import view.frmConfirmarClave;
import view.frmTransferencias;
import view.frmTransferenciasTerceros;

/**
 *
 * @author HP
 */
public class TransfeTercerosController implements ActionListener{
    private frmTransferenciasTerceros formularioTransferenciasTerceros;
    private frmTransferencias formularioTransferencias;
    private frmConfirmarClave formularioConfirmarClave;
    private DatosFormulario datosFormulario;
    private Transferencia transferencia;
    private CuentaDAO cuentaDao = new CuentaDAO();
    private TransferenciaDAO transferenciaDAO = new TransferenciaDAO();
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;

    public TransfeTercerosController(frmTransferenciasTerceros formularioTransferenciasTerceros) {
        this.formularioTransferenciasTerceros = formularioTransferenciasTerceros;
        this.formularioTransferenciasTerceros.setResizable(false);//Desabilirar el cambio de tamaño
        this.formularioTransferenciasTerceros.setLocationRelativeTo(null);//Establecer en el centro
        this.formularioTransferenciasTerceros.btnInicio.addActionListener(this);
        this.formularioTransferenciasTerceros.btnSiguiente.addActionListener(this);
        this.formularioTransferenciasTerceros.cbCuentaOrigen.addActionListener(this);
        this.datosFormulario = DatosFormulario.getInstance();
        listadoCbCuentaOrigen();
    }
    
    public void listadoCbCuentaOrigen() {
        //Obtener el idCleinte almacenado
        int idCliente = datosFormulario.getIdCliente();
        formularioTransferenciasTerceros.cbCuentaOrigen.removeAllItems();
        // Obtener la lista de cuentas del cliente
        ArrayList<Cuenta> cuentas = (ArrayList<Cuenta>) cuentaDao.listar(idCliente);
        //Agregar en el combobox
        for (Cuenta x : cuentas) {
            formularioTransferenciasTerceros.cbCuentaOrigen.addItem(x.getNumeroCuenta()+" - "+x.getTipo());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(formularioTransferenciasTerceros.btnInicio)){
            formularioTransferencias = new frmTransferencias();
            formularioTransferencias.setVisible(true);
            this.formularioTransferenciasTerceros.dispose();
        }
        if(e.getSource().equals(formularioTransferenciasTerceros.btnSiguiente)){
            //Almacenar datos en memoria
            String cuentaOrigenSeleccionada = formularioTransferenciasTerceros.cbCuentaOrigen.getSelectedItem().toString().substring(0, 16);
            //Obtener el monto que no este vacio y solo acepte número
            String textMonto = formularioTransferenciasTerceros.txtMonto.getText();
            String textNumeroCuentaDestinio = formularioTransferenciasTerceros.txtNumeroCuentaDestino.getText();
            if(!textMonto.isEmpty() && textMonto.matches("[0-9]+")){
                if(!textNumeroCuentaDestinio.isEmpty() && textNumeroCuentaDestinio.matches("[0-9]+")){
                    //Convertir monto
                    double monto = Double.parseDouble(textMonto);
                    //Obtener el id de la cuenta de origen y destino
                    cuentaOrigen = cuentaDao.getOne(cuentaOrigenSeleccionada);
                    cuentaDestino = cuentaDao.getOne(textNumeroCuentaDestinio);
                    //Almacenar el id de la cuenta
                    datosFormulario.setIdCuentaOrigen(cuentaOrigen.getIdCuenta());
                    datosFormulario.setIdCuentaDestino(cuentaDestino.getIdCuenta());
                    //Almacenar el saldo
                    datosFormulario.setSaldoOrigen(cuentaOrigen.getSaldo());
                    datosFormulario.setSaldoDestino(cuentaDestino.getSaldo());
                    //Almacenar el número de cuenta
                    datosFormulario.setNumeroCuentaOrigen(cuentaOrigenSeleccionada);
                    datosFormulario.setNumeroCuentaDestino(textNumeroCuentaDestinio);
                    //Almacenar monto a depositar
                    datosFormulario.setMonto(monto);
                    //Almacenar el tipo de moneda
                    datosFormulario.setTipoMonedaCuentaOrigen(cuentaOrigen.getMoneda());
                    datosFormulario.setTipoMonedaCuentaDestino(cuentaDestino.getMoneda());
                    //Mostrar el formulario confirmar clave
                    formularioConfirmarClave = new frmConfirmarClave();
                    formularioConfirmarClave.setVisible(true);
                    this.formularioTransferenciasTerceros.dispose();
                }else{
                    JOptionPane.showMessageDialog(formularioTransferencias, "Número de cuenta de destino invalido");
                }
            }else{
                //Mostrar mensaje de error
                JOptionPane.showMessageDialog(formularioTransferencias, "Monto invalido");
            }
        }
    }
}