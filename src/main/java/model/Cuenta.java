package model;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Cuenta {
    private int id;
    private String numero_cuenta; //número de la cuenta 
    private int clave; //clave de 6 digitos
    private String fecha_creacion;
    private String tipo_cuenta; //Ahorro o Corriente 
    private String tipoMoneda; //PEN o USD    
    private double monto;
    private Cliente cliente;
    private List<Transferencia> transferencia;
    private List<Movimiento> movimientos;

    public Cuenta() {
    }

    public Cuenta(int id, String numero_cuenta, int clave, String fecha_creacion, String tipo_cuenta, String tipoMoneda, double monto, Cliente cliente) {
        this.id = id;
        this.numero_cuenta = numero_cuenta;
        this.clave = clave;
        this.fecha_creacion = fecha_creacion;
        this.tipo_cuenta = tipo_cuenta;
        this.tipoMoneda = tipoMoneda;
        this.monto = monto;
        this.cliente = cliente;
        this.transferencia = new ArrayList<>();
        this.movimientos = new ArrayList<>();
    }
    
    
    //Obtener tasa de cambio dependiendo del tipo de moneda
    public double obtenerTasaCambio(String tipoMonedaOrigen, String tipoMonedaDestino) {
        double tasaCambio;
        if (tipoMonedaOrigen.equals("USD") && tipoMonedaDestino.equals("PEN")) {
            tasaCambio = 3.71;
        } else if (tipoMonedaOrigen.equals("PEN") && tipoMonedaDestino.equals("USD")) {
            tasaCambio = 0.27;
        } else {
            tasaCambio = 1;
        }
        return tasaCambio;
    }
    
    //Calcular la comisión dependiendo del monto a depositar
    public double calcularComision(double monto) {
        double comision;
        if (monto <= 1000) {
            comision = 3.0;
        } else if (monto <= 5000) {
            comision = 6.0;
        } else if (monto <= 10000) {
            comision = 8.0;
        } else {
            comision = 10.0;
        }
        return comision;
    }
    
    public double calcularTotalTransferencia(double monto, Cuenta cuentaDestino) {
        double tasaCambio = obtenerTasaCambio(this.tipoMoneda, cuentaDestino.tipoMoneda);
        double montoConvertido = monto * tasaCambio;
        double comision = calcularComision(montoConvertido);
        double montoTotal = montoConvertido + comision;
        System.out.println("monto convertido: "+montoConvertido);
        return montoTotal;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }


    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Transferencia> getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(List<Transferencia> transferencia) {
        this.transferencia = transferencia;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "id=" + id + '}';
    }

    


    
}
