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
    private CuentaDAO cuentaDAO;

    public LoginController(frmLogin formularioLogin) {
        //Look and feel Mejora la Apariencia de la aplicación
        FlatLightLaf.setup();
        this.formularioLogin = formularioLogin;
        this.formularioLogin.setResizable(false);//Desabilirar el cambio de tamaño
        this.formularioLogin.setLocationRelativeTo(null);//Establecer en el centro
        this.formularioLogin.btnLogin.addActionListener(this);
        //Imagen de login
        ImageIcon img1=new ImageIcon("src/main/java/view/bank.png");
        ImageIcon img2=new ImageIcon("src/main/java/view/credit-card.png");
        ImageIcon img3=new ImageIcon("src/main/java/view/password.png");
        frmLogin.lbImagen1.setIcon(img1);
        frmLogin.lbImagen2.setIcon(img2);
        frmLogin.lbImagen3.setIcon(img3);
        
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
                formularioMenu.setVisible(true);
                formularioLogin.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(formularioLogin, "Credenciales Invalidas");
            }
        }
    }
}
