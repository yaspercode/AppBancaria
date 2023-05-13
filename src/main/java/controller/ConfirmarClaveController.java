package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.DatosFormulario;
import view.frmConfirmarClave;
import view.frmConstancia;
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
    private frmTransferenciasTerceros formularioTerceros;
    private DatosFormulario datosFormulario;

    public ConfirmarClaveController(frmConfirmarClave formularioConfirmarClave) {
        this.formularioConfirmarClave = formularioConfirmarClave;
        this.formularioConfirmarClave.setResizable(false);//Desabilirar el cambio de tamaño
        this.formularioConfirmarClave.setLocationRelativeTo(null);//Establecer en el centro
        this.formularioConfirmarClave.btnCancelar.addActionListener(this);
        this.formularioConfirmarClave.btnPagar.addActionListener(this);
        this.datosFormulario = DatosFormulario.getInstance();
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
            formularioConstancia = new frmConstancia();
            formularioConstancia.setVisible(true);
            this.formularioConfirmarClave.dispose();
        }
    }
    
    
}
