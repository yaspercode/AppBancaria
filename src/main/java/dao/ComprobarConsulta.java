package dao;
import dao.CuentaDAO;
import java.util.List;
import model.Cuenta;

/**
 *
 * @author HP
 */
public class ComprobarConsulta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String numeroCuenta = "1059385321587439"; // un número de cuenta válido para probar
    CuentaDAO cuentaDAO = new CuentaDAO();
    int idCliente = cuentaDAO.buscarIdCliente(numeroCuenta);
    System.out.println("El ID de cliente asociado con la cuenta " + numeroCuenta + " es: " + idCliente);
        
        
        
//        CuentaDAO cuentaDAO = new CuentaDAO();
//        String numCuenta = "1059385321587439";
//        Cuenta cuenta = cuentaDAO.getOne(numCuenta);
//        if(cuenta != null){
//            System.out.println("Cuenta encontrada: "+ cuenta.getId()+ " " + cuenta.getNumero_cuenta() + " " + cuenta.getTipo_cuenta() + " " + cuenta.getMonto());
//        }else{
//            System.out.println("Cuenta no encontrada");
//        }
        
        
//    CuentaDAO cuentaDAO = new CuentaDAO();
//        List<Cuenta> listaCuentas = cuentaDAO.listar(1); // Cambia el valor de "id" según tus necesidades
//    for (Cuenta cuenta : listaCuentas) {
//        System.out.println("Tipo de cuenta: " + cuenta.getTipo_cuenta());
//        System.out.println("Número de cuenta: " + cuenta.getNumero_cuenta());
//        System.out.println("Monto: " + cuenta.getMonto());
//        System.out.println("--------");
//    }
    
    }
    
}
