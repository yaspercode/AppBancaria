package controller;

import dao.CuentaDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.frmMenu;
import model.Cuenta;

/**
 *
 * @author HP
 */
public class MenuController {
    private frmMenu formularioMenu;
    CuentaDAO cuentaDAO = new CuentaDAO();
    Cuenta cuenta=new Cuenta();
    int id=0;
    public MenuController(frmMenu formularioMenu) {
        this.formularioMenu = formularioMenu;
        this.formularioMenu.setResizable(false);//Desabilirar el cambio de tamaño
        this.formularioMenu.setLocationRelativeTo(null);//Establecer en el centro
    }
    
    public int obtenerNumCuenta(String numeroCuenta){
        id=cuentaDAO.buscarIdCliente(numeroCuenta);
        ListarTablaCuenta();
        return id;
    }
    
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






    
}
