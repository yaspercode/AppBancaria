package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public TransfeTercerosController(frmTransferenciasTerceros formularioTransferenciasTerceros) {
        this.formularioTransferenciasTerceros = formularioTransferenciasTerceros;
        this.formularioTransferenciasTerceros.setResizable(false);//Desabilirar el cambio de tamaño
        this.formularioTransferenciasTerceros.setLocationRelativeTo(null);//Establecer en el centro
        this.formularioTransferenciasTerceros.btnInicio.addActionListener(this);
        this.formularioTransferenciasTerceros.btnSiguiente.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(formularioTransferenciasTerceros.btnInicio)){
            formularioTransferencias = new frmTransferencias();
            formularioTransferencias.setVisible(true);
            this.formularioTransferenciasTerceros.dispose();
        }
        if(e.getSource().equals(formularioTransferenciasTerceros.btnSiguiente)){
            formularioConfirmarClave = new frmConfirmarClave();
            formularioConfirmarClave.setVisible(true);
            this.formularioTransferenciasTerceros.dispose();
        }
    }
}
