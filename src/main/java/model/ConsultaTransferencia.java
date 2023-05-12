package model;
import model.*;
/**
 *
 * @author HP
 */
public class ConsultaTransferencia {

    public static void main(String[] args) {
        // Crear un cliente
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setApellido("Perez");
        
        // Crear una cuenta
        Cuenta cuenta = new Cuenta(1, "1234567890", 123456, "2021-01-01", "Ahorro", "USD", 1000, cliente);
        System.out.println("monto de orige: "+1000);
        // Calcular la tasa de cambio
        double tasaCambio = cuenta.obtenerTasaCambio("USD", "PEN");
        System.out.println("Tasa de cambio: " + tasaCambio);
        
        // Calcular la comisión
        double comision = cuenta.calcularComision(500);
        System.out.println("Comisión: " + comision);
        
        // Calcular el total de una transferencia
        Cuenta cuentaDestino = new Cuenta(2, "0987654321", 654321, "2021-01-01", "Ahorro", "PEN", 0, cliente);
        double montoTotal = cuenta.calcularTotalTransferencia(500, cuentaDestino);
        System.out.println("Monto total de la transferencia: " + montoTotal);
    }
    
}
