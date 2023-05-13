package controller;

import dao.CuentaDAO;
import dao.TransferenciaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cuenta;
import model.Transferencia;
import view.frmMovimientos;
import view.frmLogin;
import view.frmMenu;

/**
 *
 * @author HP
 */
public class MoviminetosController implements ActionListener{
    private frmMovimientos formularioMovimientos;
    private frmMenu formularioMenu;
   

    public MoviminetosController(frmMovimientos formularioMovimientos) {
        this.formularioMovimientos = formularioMovimientos;
        this.formularioMovimientos.setResizable(false);//Desabilirar el cambio de tamaño
        this.formularioMovimientos.setLocationRelativeTo(null);//Establecer en el centro
        this.formularioMovimientos.btnInicio.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(formularioMovimientos.btnInicio)){
            formularioMenu = new frmMenu();
            formularioMenu.setVisible(true);
            this.formularioMovimientos.dispose();
        }
    }

}
    