package controller;

import com.formdev.flatlaf.FlatLightLaf;
import dao.CuentaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import view.frmLogin;
import model.Cuenta;
import view.frmMenu;

public class LoginController implements ActionListener{
    private frmLogin formularioLogin;
    private frmMenu formularioMenu;
    private CuentaDAO cuentaDAO;
    MenuController menuController;
    String numeroCuenta="";

    public LoginController(frmLogin formularioLogin) {
        //Look and feel Mejora la Apariencia de la aplicación
        FlatLightLaf.setup();
        this.formularioLogin = formularioLogin;
        this.formularioLogin.setResizable(false);//Desabilirar el cambio de tamaño
        this.formularioLogin.setLocationRelativeTo(null);//Establecer en el centro
        this.formularioLogin.btnLogin.addActionListener(this);
        //Inicializamos el controlador del Menú
//        formularioLogin=new frmLogin();
        formularioMenu=new frmMenu();
//        menuController = new MenuController(formularioMenu);
        menuController = new MenuController(formularioMenu);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(formularioLogin.btnLogin)){
            //Obtener datos del formualario
            numeroCuenta = formularioLogin.txtNumeroCuenta.getText().trim();
            String clave = formularioLogin.txtClave.getText().trim();
            //Validar que la clave no este vacía o contenga caracteres especiales
            if(clave.isEmpty() || !clave.matches("\\d+")){
                JOptionPane.showMessageDialog(formularioLogin, "Ingrese una clave válida");
                return; //Terminar si la clave es invalida
            }
            //Crear una instancia del dao y cuenta
            cuentaDAO=new CuentaDAO();
            Cuenta cuentaModel=new Cuenta();
            //Almacenar en la instancia cuenta
            cuentaModel.setNumero_cuenta(numeroCuenta);
            cuentaModel.setClave(Integer.parseInt(clave));
            //validar las credenciales
            boolean esValida=cuentaDAO.validarCuenta(cuentaModel);
            //Mostrar el resultado
            if(esValida){
                frmMenu formularioMenu=new frmMenu();
//                menuController = new MenuController(formularioMenu);
                formularioMenu.setVisible(true);
                menuController.obtenerIdCuenta(numeroCuenta);
                this.formularioLogin.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(formularioLogin, "Credenciales Invalidas");
            }
        }
    }
}
