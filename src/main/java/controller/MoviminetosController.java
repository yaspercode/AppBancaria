package controller;

import dao.CuentaDAO;
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
    MovimientosDAO movimientosDAO;
    DefaultTableModel modelo = new DefaultTableModel();
    CuentaDAO cuentaDAO;
    private String numeroCuenta="";
    int id=0;

    public MoviminetosController(frmMovimientos formularioMovimientos) {
        this.formularioMovimientos = formularioMovimientos;
        this.formularioMovimientos.btnInicio.addActionListener(this);
        this.cuentaDAO = new CuentaDAO();
        this.movimientosDAO = new MovimientosDAO();
        ListarTablaMovimientos();
    }
    
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        formularioMovimientos.lbNumeroCuenta.setText(numeroCuenta);
//        ListarTablaMovimientos();
    }

    
    public void ListarTablaMovimientos(){
        id=cuentaDAO.buscarIdCliente(numeroCuenta);
        if(id!=0 && id!=-1){
            modelo.getDataVector().removeAllElements();
        formularioMovimientos.tablaMovimientos.updateUI();
//        System.out.println("id: "+id);  
//        modelo.setRowCount(0);
        List<Movimiento> lista = movimientosDAO.listar(1);
        for (int i = 0; i < lista.size(); i++) {
            Object o[] = {lista.get(i).getFecha(), lista.get(i).getTipo_trasnferencia(), lista.get(i).getMonto()};
            modelo.addRow(o);
        }
//        modelo.fireTableDataChanged();//cualquier cambio se refleje
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(formularioMovimientos.btnInicio)) {
            formularioMovimientos.setVisible(false);
            
        }
    }

}
    