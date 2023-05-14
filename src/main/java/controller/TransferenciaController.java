package controller;

import dao.CuentaDAO;
import dao.TransferenciaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
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
    private CuentaDAO cuentaDAO = new CuentaDAO();

    public TransferenciaController(frmTransferencias formularioTransferencias) {
        this.formularioTransferencias = formularioTransferencias;
        this.formularioTransferencias.setResizable(false);//Desabilirar el cambio de tamaño
        this.formularioTransferencias.setLocationRelativeTo(null);//Establecer en el centro
        this.formularioTransferencias.btnTransacionesEntreCuentas.addActionListener(this);
        this.formularioTransferencias.btnTransacionesTerceros.addActionListener(this);
        this.formularioTransferencias.btnInicio.addActionListener(this);
        this.datosFormulario = DatosFormulario.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(formularioTransferencias.btnTransacionesEntreCuentas)) {
            //Comprobar si tiene más de 2 cuentas
            int idCliente = datosFormulario.getIdCliente();
            int cantidadCuentas = cuentaDAO.cantidadCuentas(idCliente);
            if(cantidadCuentas >= 2){
                this.formularioTransferencias.btnTransacionesEntreCuentas.setEnabled(true);
                formularioTransferenciasEntreCuentas = new frmTransferenciasEntreCuentas();
                formularioTransferenciasEntreCuentas.setVisible(true);
                datosFormulario.setNombreFormulario("Transferencia entre cuenteas");
                this.formularioTransferencias.dispose();
            }else{
                this.formularioTransferencias.btnTransacionesEntreCuentas.setEnabled(false);
                JOptionPane.showMessageDialog(null, "El cliente no tiene suficientes cuentas para realizar una transferencia", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
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
