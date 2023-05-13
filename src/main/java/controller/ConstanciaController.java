package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.frmConstancia;
import view.frmMenu;

/**
 *
 * @author HP
 */
public class ConstanciaController implements ActionListener{
    private frmConstancia formularioConstancia;
    private frmMenu formularioMenu;

    public ConstanciaController(frmConstancia formularioConstancia) {
        this.formularioConstancia = formularioConstancia;
        this.formularioConstancia.setResizable(false);//Desabilirar el cambio de tamaño
        this.formularioConstancia.setLocationRelativeTo(null);//Establece en el centro
        this.formularioConstancia.btnInicio.addActionListener(this);
        this.formularioConstancia.btnUltimoMovimiento.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(formularioConstancia.btnInicio)){
            formularioMenu = new frmMenu();
            formularioMenu.setVisible(true);
            this.formularioConstancia.dispose();
        }
        if(e.getSource().equals(formularioConstancia.btnUltimoMovimiento)){
            
        }
    }
    
    
}
