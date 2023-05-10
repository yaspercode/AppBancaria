package controller;

import dao.CuentaDAO;
import dao.MovimientosDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.frmMenu;
import model.Cuenta;
import model.Movimiento;
import view.frmLogin;
import view.frmMovimientos;
import controller.MoviminetosController;

/**
 *
 * @author HP
 */
public class MenuController implements ActionListener{
    private frmMenu formularioMenu;
    private frmLogin formularioLogin;
    private frmMovimientos formularioMovimientos;
    CuentaDAO cuentaDAO = new CuentaDAO();
    MovimientosDAO movimientosDAO = new MovimientosDAO();
    Movimiento movimiento= new Movimiento();
    Cuenta cuenta=new Cuenta();
    private String numeroCuenta="";
    int id=0;
    
    public MenuController(frmMenu formularioMenu) {
        this.formularioMenu = formularioMenu;
//        this.formularioMenu.setResizable(false);//Desabilirar el cambio de tamaño
//        this.formularioMenu.setLocationRelativeTo(null);//Establecer en el centro
        this.formularioMenu.btnTransferencia.addActionListener(this);
        this.formularioMenu.btnMovimiento.addActionListener(this);
        this.formularioMenu.btnCerrarSesion.addActionListener(this);
        //Inicializamos el controlador del movimineto
        formularioMovimientos=new frmMovimientos();
        
//        moviminetosController = new MoviminetosController(formularioMovimientos);
        obtenerIdCuenta(numeroCuenta);
//        ListarTablaMovimientos(id);
        ListarTablaCuenta();
    }
    
    public void obtenerIdCuenta(String numeroCuenta){
        id=cuentaDAO.buscarIdCliente(numeroCuenta);
        ListarTablaCuenta();
//        frmMovimientos formularioMovimientos=new frmMovimientos();
        formularioMovimientos.lbNumeroCuenta.setText(numeroCuenta);
        MoviminetosController moviminetosController= new MoviminetosController(formularioMovimientos);
        moviminetosController.setNumeroCuenta(numeroCuenta);
//        ListarTablaMovimientos(id);
    }
    
    
//    public void ListarTablaMovimientos(int id){
////        frmMovimientos formularioMovimientos=new frmMovimientos();
//    DefaultTableModel modelo = (DefaultTableModel) formularioMovimientos.tablaMovimientos.getModel();
//    modelo.setRowCount(0);
//    List<Movimiento> lista = movimientosDAO.listar(id);
//    for (int i = 0; i < lista.size(); i++) {
//        Object o[] = {lista.get(i).getFecha(), lista.get(i).getTipo_trasnferencia(), lista.get(i).getMonto()};
//        modelo.addRow(o);
//    }
//    modelo.fireTableDataChanged();//cualquier cambio se refleje
//    }
    
    
    public void ListarTablaCuenta(){
    DefaultTableModel modelo = (DefaultTableModel) formularioMenu.tablaCuenta.getModel();
    modelo.setRowCount(0);
    List<Cuenta> lista = cuentaDAO.listar(id);
    for (int i = 0; i < lista.size(); i++) {
        Object o[] = {lista.get(i).getTipo_cuenta(), lista.get(i).getNumero_cuenta(), lista.get(i).getMonto()};
        modelo.addRow(o);
    }
    modelo.fireTableDataChanged();//cualquier cambio se refleje
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(formularioMenu.btnCerrarSesion)) {
//            formularioLogin=new frmLogin();
//            formularioMenu=new frmMenu();
//            formularioLogin.setVisible(true);
//            formularioMenu.setVisible(false);
        }
        if (e.getSource().equals(formularioMenu.btnTransferencia)) {
        }
        if (e.getSource().equals(formularioMenu.btnMovimiento)) {
            formularioMovimientos.setVisible(true);
            formularioMovimientos.setResizable(false);//Desabilirar el cambio de tamaño
            formularioMovimientos.setLocationRelativeTo(null);//Establecer en el centro
//            this.formularioMenu.setVisible(false);
        }
    }

    
}
