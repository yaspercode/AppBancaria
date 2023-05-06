package model;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Cuenta {
    private int id;
    private String tipo_cuenta; //cuenta de ahorros o cuenta corriente
    private int numero_cuenta; //número de la cuenta 
    private int clave; //clave de digitos de la cuenta 
    private String tipo_nomneda; //PEN o USD
    private String fecha_apertura;
    private double saldo;
    private Cliente cliente;
    private List<Movimiento> movimientos;

    public Cuenta(int id, String tipo_cuenta, int numero_cuenta, int clave, String tipo_nomneda, String fecha_apertura, double saldo, Cliente cliente) {
        this.id = id;
        this.tipo_cuenta = tipo_cuenta;
        this.numero_cuenta = numero_cuenta;
        this.clave = clave;
        this.tipo_nomneda = tipo_nomneda;
        this.fecha_apertura = fecha_apertura;
        this.saldo = saldo;
        this.cliente = cliente;
        this.movimientos = new ArrayList<>();
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public int getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }
    
    public String getTipo_nomneda() {
        return tipo_nomneda;
    }

    public void setTipo_nomneda(String tipo_nomneda) {
        this.tipo_nomneda = tipo_nomneda;
    }

    public String getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(String fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    
    
}
