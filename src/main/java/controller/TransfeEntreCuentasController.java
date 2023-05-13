package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public TransfeEntreCuentasController(frmTransferenciasEntreCuentas formularioTransferenciasEntreCuentas) {
        this.formularioTransferenciasEntreCuentas = formularioTransferenciasEntreCuentas;
        this.formularioTransferenciasEntreCuentas.setResizable(false);//Desabilirar el cambio de tamaño
        this.formularioTransferenciasEntreCuentas.setLocationRelativeTo(null);//Establecer en el centro
        this.formularioTransferenciasEntreCuentas.btnInicio.addActionListener(this);
        this.formularioTransferenciasEntreCuentas.btnSiguiente.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(formularioTransferenciasEntreCuentas.btnInicio)){
            formularioTransferencias = new frmTransferencias();
            formularioTransferencias.setVisible(true);
            this.formularioTransferenciasEntreCuentas.dispose();
        }
        if(e.getSource().equals(formularioTransferenciasEntreCuentas.btnSiguiente)){
            formularioConfirmarClave = new frmConfirmarClave();
            formularioConfirmarClave.setVisible(true);
            this.formularioTransferenciasEntreCuentas.dispose();
        }
    }
    
    
}
