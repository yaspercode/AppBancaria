package model;

/**
 *
 * @author HP
 */
public class Transferencia {
    private int id;
    private String fecha;
    private Cuenta cuenta_origen;
    private Cuenta cuenta_destino;
    private double monto;

    public Transferencia(int id, String fecha, Cuenta cuenta_origen, Cuenta cuenta_destino, double monto) {
        this.id = id;
        this.fecha = fecha;
        this.cuenta_origen = cuenta_origen;
        this.cuenta_destino = cuenta_destino;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cuenta getCuenta_origen() {
        return cuenta_origen;
    }

    public void setCuenta_origen(Cuenta cuenta_origen) {
        this.cuenta_origen = cuenta_origen;
    }

    public Cuenta getCuenta_destino() {
        return cuenta_destino;
    }

    public void setCuenta_destino(Cuenta cuenta_destino) {
        this.cuenta_destino = cuenta_destino;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
}
