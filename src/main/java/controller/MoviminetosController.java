package controller;

import dao.CuentaDAO;
import dao.MovimientosDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
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
    private MovimientosDAO movimientosDAO;
    private DefaultTableModel modelo;
    private CuentaDAO cuentaDAO;
    private String numeroCuenta="";

    public MoviminetosController(frmMovimientos formularioMovimientos) {
        this.formularioMovimientos = formularioMovimientos;
        this.modelo= new DefaultTableModel();
        this.cuentaDAO = new CuentaDAO();
        this.movimientosDAO = new MovimientosDAO();
        this.formularioMovimientos.btnInicio.addActionListener(this);
//        iniciar();
//        listar();
    }
    
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        formularioMovimientos.lbNumeroCuenta.setText(numeroCuenta);
//        listar();
    }
    
//    public void iniciar() {
//        modelo.addColumn("Fecha");
//        modelo.addColumn("Tipo de transación");
//        modelo.addColumn("Monto");
//        formularioMovimientos.tabla.setModel(modelo);
//    }
    
//    public void listar() {
//        try{
//            String numCuenta=formularioMovimientos.lbNumeroCuenta.getText();
//            int id=cuentaDAO.buscarIdCliente(numCuenta);
//            formularioMovimientos.tabla.setModel(modelo);
//        modelo.setRowCount(0); // Elimina todas las filas existentes del modelo
//        List<Movimiento> list = movimientosDAO.listar(id);
//        for (Movimiento m : list) {
//            Object[] row = {
//            m.getFecha(),
//            m.getTipo_trasnferencia(),
//            m.getMonto()
//        };
//            modelo.addRow(row);
//        }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(formularioMovimientos.btnInicio)) {
            formularioMovimientos.setVisible(false);
        }
    }

}
    