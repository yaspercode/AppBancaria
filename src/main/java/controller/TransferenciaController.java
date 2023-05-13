package controller;

import dao.TransferenciaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import model.Cuenta;
import model.DatosFormulario;
import model.Transferencia;
import view.frmMenu;
import view.frmTransferencias;
import view.frmTransferenciasEntreCuentas;
import view.frmTransferenciasTerceros;

/**
 *
 * @author HP
 */
public class TransferenciaController implements ActionListener{
    private frmTransferencias formularioTransferencias;
    private frmTransferenciasEntreCuentas formularioTransferenciasEntreCuentas;
    private frmTransferenciasTerceros formularioTransferenciasTerceros;
    private frmMenu formularioMenu;
    private DatosFormulario datosFormulario;

    public TransferenciaController(frmTransferencias formularioTransferencias) {
        this.formularioTransferencias = formularioTransferencias;
        this.formularioTransferencias.setResizable(false);//Desabilirar el cambio de tamaño
        this.formularioTransferencias.setLocationRelativeTo(null);//Establecer en el centro
        this.formularioTransferencias.btnTransacionesEntreCuentas.addActionListener(this);
        this.formularioTransferencias.btnTransacionesTerceros.addActionListener(this);
        this.formularioTransferencias.btnInicio.addActionListener(this);
        this.datosFormulario = DatosFormulario.getInstance();
    }

    
    //Método para realizar la transferencia
//    public void realizarTransferencia(String tipoTransferencia, String fecha,Cuenta cuentaOrigen, double monto, Cuenta cuentaDestino, String descripcion) throws SQLException {
//        // Obtener tasa de cambio según tipo de moneda de origen y destino
//        double tasaCambio = Transferencia.obtenerTasaCambio(cuentaOrigen.getTipo(), cuentaDestino.getTipo());
//        // Calcular comisión según el monto a depositar
//        double comision = Transferencia.calcularComision(monto);
//
//        // Calcular el total de la transferencia
//        double total = monto * tasaCambio + comision;
//        
//        // Verificar si el saldo depositado es mayor que el total de la transferencia
//        if (monto >= total) {
//            System.out.println("Saldo depositado mayor al total de la transferencia.");
//            return;
//        }
//        
//        // Actualizar el saldo de la cuenta de origen
//        double nuevoSaldoOrigen = cuentaOrigen.getSaldo() - total;
//        cuentaOrigen.setSaldo(nuevoSaldoOrigen);
//        transferenciaDAO.actualizarSaldo(cuentaOrigen, nuevoSaldoOrigen);
//
//        // Actualizar el saldo de la cuenta de destino
//        double nuevoSaldoDestino = cuentaDestino.getSaldo() + monto;
//        cuentaDestino.setSaldo(nuevoSaldoDestino);
//        transferenciaDAO.actualizarSaldo(cuentaDestino, nuevoSaldoDestino);
//
//        // Crear una nueva instancia de Transferencia
//        Transferencia transferencia = new Transferencia();
//        transferencia.setTipoTransferencia(tipoTransferencia);
//        transferencia.setCuentaOrigen(cuentaOrigen);
//        transferencia.setCuentaDestino(cuentaDestino);
//        transferencia.setTotal(monto);
//        transferencia.setTotal(total);
//        transferencia.setFecha(fecha);
//        transferencia.setDescripcion(descripcion);
//
//        // Agregar la transferencia a la base de datos
//        transferenciaDAO.agregarTransferencia(transferencia);
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(formularioTransferencias.btnTransacionesEntreCuentas)) {
            formularioTransferenciasEntreCuentas = new frmTransferenciasEntreCuentas();
            formularioTransferenciasEntreCuentas.setVisible(true);
            datosFormulario.setNombreFormulario("Transferencia entre cuenteas");
            this.formularioTransferencias.dispose();
        }
        if (e.getSource().equals(formularioTransferencias.btnTransacionesTerceros)) {
            formularioTransferenciasTerceros = new frmTransferenciasTerceros();
            formularioTransferenciasTerceros.setVisible(true);
            datosFormulario.setNombreFormulario("Transferencia a terceros");
            this.formularioTransferencias.dispose();
        }
        if (e.getSource().equals(formularioTransferencias.btnInicio)) {
            formularioMenu = new frmMenu();
            formularioMenu.setVisible(true);
            this.formularioTransferencias.dispose();
        }
    }
}
