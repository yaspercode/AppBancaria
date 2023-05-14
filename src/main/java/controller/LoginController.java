package controller;

import com.formdev.flatlaf.FlatLightLaf;
import dao.CuentaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import view.frmLogin;
import model.Cuenta;
import model.DatosFormulario;
import view.frmMenu;

public class LoginController implements ActionListener{
    private frmLogin formularioLogin;
    private frmMenu formularioMenu;
    private DatosFormulario datosFormulario;
    private CuentaDAO cuentaDAO = new CuentaDAO();
    private Cuenta cuenta = new Cuenta();
    
    public LoginController(frmLogin formularioLogin) {
        FlatLightLaf.setup();//Look and feel Mejora la Apariencia de la aplicación
        this.formularioLogin = formularioLogin;
        this.formularioLogin.setResizable(false);//Desabilirar el cambio de tamaño
        this.formularioLogin.setLocationRelativeTo(null);//Establecer en el centro
        this.formularioLogin.btnLogin.addActionListener(this);
        this.datosFormulario = DatosFormulario.getInstance();
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(formularioLogin.btnLogin)){
            //Obtener datos del formualario
            String numeroCuenta = formularioLogin.txtNumeroCuenta.getText().trim();
            String clave = formularioLogin.txtClave.getText().trim();

            //Validar que la clave no este vacía o contenga caracteres especiales
            if(clave.isEmpty() || !clave.matches("\\d+")){
                JOptionPane.showMessageDialog(formularioLogin, "Ingrese una clave válida");
                return; //Terminar si la clave es invalida
            }
            
            //Almacenar los datos en cuenta
            cuenta.setNumeroCuenta(numeroCuenta);
            cuenta.setClave(Integer.parseInt(clave));
            
            //Almacenando los datos necesario en memoria
            datosFormulario.setNumeroCuenta(numeroCuenta);
            datosFormulario.setClave(clave);
            //Obtener el id del cliente
            int id = cuentaDAO.buscarIdCliente(formularioLogin.txtNumeroCuenta.getText());
            datosFormulario.setIdCliente(id);
            
            //validar las credenciales
            boolean esValida=cuentaDAO.validarCuenta(cuenta);
            
            //Mostrar el resultado
            if(esValida){
                formularioMenu = new frmMenu();
                //Mostrar datos en el label nombre completo
                String nombreCompleto = cuentaDAO.obtenerNombreCliente(id);
                datosFormulario.setNombreCliente(nombreCompleto);
                formularioMenu.lbNombreCompleto.setText(datosFormulario.getNombreCliente());
                formularioMenu.setVisible(true);
                this.formularioLogin.dispose();
            }else{
                JOptionPane.showMessageDialog(formularioLogin, "Credenciales Invalidas");
            }
        }
    }
}
