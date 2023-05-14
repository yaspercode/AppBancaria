package model;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Cuenta {
    private int idCuenta;
    private String numeroCuenta; //número de la cuenta de 16 dígitos
    private int clave; //clave de 6 dígitos
    private String fecha_creacion;
    private String tipo; //Tipo de Cuenta: Ahorro o Corriente 
    private String moneda; //Tipo de moneda: PEN o USD    
    private Cliente cliente;
    private double saldo;

    public Cuenta() {
    }

    public Cuenta(int idCuenta, String numeroCuenta, String tipo, String moneda, double saldo) {
        this.idCuenta = idCuenta;
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.moneda = moneda;
        this.saldo = saldo;
    }

    public Cuenta(int idCuenta, String numeroCuenta, int clave, String fecha_creacion, String tipo, String moneda, Cliente cliente, double saldo) {
        this.idCuenta = idCuenta;
        this.numeroCuenta = numeroCuenta;
        this.clave = clave;
        this.fecha_creacion = fecha_creacion;
        this.tipo = tipo;
        this.moneda = moneda;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    
    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
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
    
    
}
