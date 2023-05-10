package controller;

import dao.MovimientosDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Cuenta;
import view.frmMovimientos;
import model.Movimiento;
import view.frmLogin;
import view.frmMenu;

/**
 *
 * @author HP
 */
public class MoviminetosController implements ActionListener{
    private frmMovimientos formularioMovimientos;
    private frmMenu formularioMenu;
    Movimiento movimiento=new Movimiento();

    public MoviminetosController(frmMovimientos formularioMovimientos) {
        this.formularioMovimientos = formularioMovimientos;
        this.formularioMovimientos.btnInicio.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(formularioMovimientos.btnInicio)) {
            formularioMovimientos.setVisible(false);
            
        }
    }

}
    