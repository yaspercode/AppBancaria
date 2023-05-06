package controller;
import model.Cliente;
import view.frmLogin;
/**
 *
 * @author HP
 */
public class CuentaController {
    private CuentaController cuentaModel;
    private frmLogin formularioLogin;

    public CuentaController(CuentaController cuentaModel, frmLogin formularioLogin) {
        this.cuentaModel = cuentaModel;
        this.formularioLogin = formularioLogin;
    }

    public void setNumero_cuenta(int numero_cuenta) {
        cuentaModel.setNumero_cuenta(numero_cuenta);
    }
    public int getNumero_cuenta() {
        return cuentaModel.getNumero_cuenta();
    }
    public void setClave(int clave) {
        cuentaModel.setClave(clave);
    }
    public int getClave() {
        return cuentaModel.getClave();
    }
    public void verificarCuenta(){
        // Obtener el número de cuenta y la clave ingresados por el usuario
        int numeroCuenta = Integer.parseInt(formularioLogin.txtNumeroCuenta.getText());
        int clave = Integer.parseInt(formularioLogin.txtClave.getText());

        // Obtener la cuenta correspondiente al número de cuenta ingresado
//        CuentaDAO cuentaDAO = new CuentaDAO();
//        Cuenta cuenta = cuentaDAO.buscarPorNumeroCuenta(numeroCuenta);

        // Verificar si se encontró la cuenta y si la clave ingresada coincide con la clave de la cuenta
//        if(cuenta != null && cuenta.getClave() == clave){
            // La cuenta y la clave son válidas, mostrar el menú principal de la aplicación
//            formularioLogin.mostrarMenuPrincipal();
//        } else {
            // La cuenta o la clave son inválidas, mostrar un mensaje de error
//            formularioLogin.mostrarMensajeError("Número de cuenta o clave inválidos");
//        }
    }
}
