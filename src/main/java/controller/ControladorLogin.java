package controller;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.ImageIcon;
import view.frmLogin;

/**
 *
 * @author HP
 */
public class ControladorLogin{
    private frmLogin vistaLogin;

    public ControladorLogin(frmLogin vistaLogin) {
        this.vistaLogin = vistaLogin;
        this.vistaLogin.setResizable(false);
        this.vistaLogin.setLocationRelativeTo(null);
        
        //Imagen de login
        ImageIcon img1=new ImageIcon("src/main/java/view/bank.png");
        ImageIcon img2=new ImageIcon("src/main/java/view/credit-card.png");
        ImageIcon img3=new ImageIcon("src/main/java/view/password.png");
        frmLogin.lbImagen1.setIcon(img1);
        frmLogin.lbImagen2.setIcon(img2);
        frmLogin.lbImagen3.setIcon(img3);
        
        //Look and feel Mejora la Apariencia de la aplicación
        FlatLightLaf.setup();
    }
    
}
