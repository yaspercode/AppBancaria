package controller;

import dao.TransferenciaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Cuenta;
import model.DatosFormulario;
import model.Transferencia;
import view.frmConfirmarClave;
import view.frmConstancia;
import view.frmTransferencias;
import view.frmTransferenciasEntreCuentas;
import view.frmTransferenciasTerceros;

/**
 *
 * @author HP
 */
public class ConfirmarClaveController implements ActionListener{
    private frmConfirmarClave formularioConfirmarClave;
    private frmConstancia formularioConstancia;
    private frmTransferenciasEntreCuentas formularioEntreCuentas;
    private frmTransferencias formularioTransferencias;
    private frmTransferenciasTerceros formularioTerceros;
    private DatosFormulario datosFormulario;
    private Transferencia transferencia;
    private TransferenciaDAO transferenciaDAO = new TransferenciaDAO();
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;

    public ConfirmarClaveController(frmConfirmarClave formularioConfirmarClave) {
        this.formularioConfirmarClave = formularioConfirmarClave;
        this.formularioConfirmarClave.setResizable(false);//Desabilirar el cambio de tamaño
        this.formularioConfirmarClave.setLocationRelativeTo(null);//Establecer en el centro
        this.formularioConfirmarClave.btnCancelar.addActionListener(this);
        this.formularioConfirmarClave.btnPagar.addActionListener(this);
        this.datosFormulario = DatosFormulario.getInstance();
        
        ImageIcon img1=new ImageIcon("src/main/java/view/money-transfer.png");
        this.formularioConfirmarClave.lbMoneyTransfer.setIcon(img1);
    }
    
    public void realizarTransferencia(Cuenta cuentaOrigen, double monto, Cuenta cuentaDestino, String descripcion, String tipoTransferencia) throws SQLException{
        //Obtener tasa de cambio según el tipo de moneda de origen y destino
        double tasaCambio = transferencia.obtenerTasaCambio(cuentaOrigen.getMoneda(), cuentaDestino.getMoneda());
        System.out.println("Tasa de cambio: "+tasaCambio);
        //Calcular el total de la transferencia
        double total = monto * tasaCambio;
            
        //Actualizar el saldo de la cuenta de origen
        double nuevoSaldoOrigen = cuentaOrigen.getSaldo() - monto;
        cuentaOrigen.setSaldo(nuevoSaldoOrigen);
        transferenciaDAO.actualizarSaldo(cuentaOrigen, nuevoSaldoOrigen);
        
        //Actualizar el saldo de la cuenta de destino
        double nuevoSaldoDestino = cuentaDestino.getSaldo() + total;
        cuentaDestino.setSaldo(nuevoSaldoDestino);
        transferenciaDAO.actualizarSaldo(cuentaDestino, nuevoSaldoDestino);
        
        // Obtener la fecha y hora actual
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        // Definir el formato deseado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Formatear la fecha y hora como una cadena
        String fechaHoraFormateada = fechaHoraActual.format(formato);
        
        //Crear una instancia de transfernecia 
        transferencia = new Transferencia();
        transferencia.setCuentaOrigen(cuentaOrigen);
        transferencia.setCuentaDestino(cuentaDestino);
        transferencia.setTotal(total);
        transferencia.setFecha(fechaHoraFormateada);
        transferencia.setTasaCambio(tasaCambio);
        transferencia.setDescripcion(descripcion);
        transferencia.setTipoTransferencia(tipoTransferencia);
        
        //Agregar la transferencia
        transferenciaDAO.agregarTransferencia(transferencia);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(formularioConfirmarClave.btnCancelar)){
            String nombreFormulario = datosFormulario.getNombreFormulario();
            if("Transferencia entre cuenteas".equals(nombreFormulario)){
                formularioEntreCuentas = new frmTransferenciasEntreCuentas();
                formularioEntreCuentas.setVisible(true);
                this.formularioConfirmarClave.dispose();
            }else{
                formularioTerceros = new frmTransferenciasTerceros();
                formularioTerceros.setVisible(true);
                this.formularioConfirmarClave.dispose();
            }
        }
        if(e.getSource().equals(formularioConfirmarClave.btnPagar)){
            //Obtener la clave de la menoria
            String clave = datosFormulario.getClave();
            //Obtener la clave digitada
            String claveDigitada = formularioConfirmarClave.txtClave.getText();
            //Comparar que sean iguales
            if(clave.equals(claveDigitada)){
                cuentaOrigen = new Cuenta();
            cuentaDestino = new Cuenta();
            //id cuenta y id destino
            int idCuentaOrigen = datosFormulario.getIdCuentaOrigen();
            int idCuentaDestino = datosFormulario.getIdCuentaDestino();
            cuentaOrigen.setIdCuenta(idCuentaOrigen);
            cuentaDestino.setIdCuenta(idCuentaDestino);
            //Tipo de moneda
            cuentaOrigen.setMoneda(datosFormulario.getTipoMonedaCuentaOrigen());
                System.out.println("tipo de moneda de origen: "+cuentaOrigen.getTipo());
            cuentaDestino.setMoneda(datosFormulario.getTipoMonedaCuentaDestino());
            System.out.println("tipo de moneda de destino: "+cuentaDestino.getTipo());
            //Saldo de origen
            cuentaOrigen.setSaldo(datosFormulario.getSaldoOrigen());
            cuentaDestino.setSaldo(datosFormulario.getSaldoDestino());
            //monto a depositar
            double monto = datosFormulario.getMonto();
            try {
                String descripcion = "";
                String tipoTransferencia="";
                String nombreFormulario = datosFormulario.getNombreFormulario();
                if("Transferencia entre cuenteas".equals(nombreFormulario)){
                    descripcion = "Envío de dinero";
                    tipoTransferencia = "Transferencia Interna";
                }else{
                    descripcion = formularioTerceros.txtDescripcion.getText();
                    tipoTransferencia = "Transferencia Externa";
                }
                realizarTransferencia(cuentaOrigen, monto, cuentaDestino, descripcion, tipoTransferencia);
            } catch (SQLException ex) {
                Logger.getLogger(ConfirmarClaveController.class.getName()).log(Level.SEVERE, null, ex);
            }
            formularioConstancia = new frmConstancia();
            formularioConstancia.setVisible(true);
            this.formularioConfirmarClave.dispose();
            }else{
                JOptionPane.showMessageDialog(formularioTerceros, "Clave invalida");
            }
            
        }
    }
    
    
}
