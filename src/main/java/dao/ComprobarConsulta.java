package dao;
import dao.CuentaDAO;
import java.util.List;
import model.Cuenta;
import model.Transferencia;

/**
 *
 * @author HP
 */
public class ComprobarConsulta {

    public static void main(String[] args) {
        Transferencia transferencia = new Transferencia();
        // Ejemplo de prueba de obtenerTasaCambio
        String tipoMonedaOrigen = "PEN";
        String tipoMonedaDestino = "PEN";
        double tasaCambio = transferencia.obtenerTasaCambio(tipoMonedaOrigen, tipoMonedaDestino);
        System.out.println("Tipo de moneda de origen: "+tipoMonedaOrigen);
        System.out.println("Tipo de moneda de destino: "+tipoMonedaDestino);
        System.out.println("tasa de cambio: "+tasaCambio);
    
    }
    
}