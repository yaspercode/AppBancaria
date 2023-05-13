package controller;

import dao.CuentaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import view.frmMenu;
import model.Cuenta;
import model.Transferencia;
import view.frmLogin;
import view.frmMovimientos;
import dao.TransferenciaDAO;
import javax.swing.JOptionPane;
import model.DatosFormulario;
import view.frmTransferencias;

/**
 *
 * @author HP
 */
public class MenuController implements ActionListener{
    private frmMenu formularioMenu;
    private frmMovimientos formularioMovimientos;
    private frmTransferencias formularioTransferencias;
    private frmLogin formularioLogin;
    private DatosFormulario datosFormulario;
    private CuentaDAO cuentaDAO = new CuentaDAO();
    private TransferenciaDAO transferenciaDAO = new TransferenciaDAO();
    
    
    public MenuController(frmMenu formularioMenu) {
        this.formularioMenu = formularioMenu;
        this.formularioMenu.setResizable(false);//Desabilirar el cambio de tamaño
        this.formularioMenu.setLocationRelativeTo(null);//Establecer en el centro
        this.formularioMenu.btnMovimiento.addActionListener(this);
        this.formularioMenu.btnTransferencia.addActionListener(this);
        this.formularioMenu.btnCerrarSesion.addActionListener(this);
        this.datosFormulario = DatosFormulario.getInstance();
        ListarTablaCuenta();
        NombreCliente();
    }
    
    public void NombreCliente(){
        String nombre = datosFormulario.getNombreCliente();
        formularioMenu.lbNombreCompleto.setText(nombre);
    }
    public void ListarTablaCuenta(){
        int idCliente = datosFormulario.getIdCliente();
        DefaultTableModel modelo = (DefaultTableModel) formularioMenu.tablaCuenta.getModel();
        modelo.setRowCount(0);
        List<Cuenta> lista = cuentaDAO.listar(idCliente);
        for (int i = 0; i < lista.size(); i++) {
            Object o[] = {lista.get(i).getTipo(), lista.get(i).getNumeroCuenta(), lista.get(i).getSaldo()};
            modelo.addRow(o);
        }
        modelo.fireTableDataChanged();//cualquier cambio se refleje
    }
    
    public void ListarTablaMovimientos(){
        String numeroCuenta = datosFormulario.getNumeroCuenta();
        DefaultTableModel modelo = (DefaultTableModel) formularioMovimientos.tabla.getModel();
        modelo.setRowCount(0);
        List<Transferencia> lista = transferenciaDAO.listar(numeroCuenta);
        for (int i = 0; i < lista.size(); i++) {
            Object o[] = {lista.get(i).getFecha(), lista.get(i).getTipoTransferencia(), lista.get(i).getTotal()};
            modelo.addRow(o);
        }
        modelo.fireTableDataChanged();//cualquier cambio se refleje
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(formularioMenu.btnCerrarSesion)) {
            formularioLogin = new frmLogin();
            formularioLogin.setVisible(true);
            formularioMenu.dispose();
        }
        if (e.getSource().equals(formularioMenu.btnTransferencia)) {
            formularioTransferencias = new frmTransferencias();
            formularioTransferencias.setVisible(true);
            formularioMenu.dispose();
        }
        if (e.getSource().equals(formularioMenu.btnMovimiento)) {
            //Recuperar datos de menoria
            String numeroCuenta = datosFormulario.getNumeroCuenta();
            int idCliente = datosFormulario.getIdCliente();
            //Descubrimos la fila selecionada
            int filaSeleccionada = formularioMenu.tablaCuenta.getSelectedRow();
            System.out.println("Fila selecionada: "+filaSeleccionada);
            if(filaSeleccionada != -1){
                String numCuenta = formularioMenu.tablaCuenta.getValueAt(filaSeleccionada, 1).toString();
                String monto = formularioMenu.tablaCuenta.getValueAt(filaSeleccionada, 2).toString();
                formularioMovimientos = new frmMovimientos();
                formularioMovimientos.lbNumeroCuenta.setText(numCuenta);
                formularioMovimientos.lbMonto.setText(monto);
                ListarTablaMovimientos();
                formularioMovimientos.setVisible(true);
                this.formularioMenu.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Debes seleccionar una fila de la tabla número de cuenta");
            }
        }
    }

}
