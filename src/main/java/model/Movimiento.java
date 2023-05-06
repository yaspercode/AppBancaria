package model;

/**
 *
 * @author HP
 */
public class Movimiento {
    private int id;
    private String tipo_operacion; //deposito, retiro o transferencia
    private String fecha;
    private String descripcion;
    private double monto;
    private double tasa_cambio;
    private double comision;
    private Cuenta cuenta;

    public Movimiento() {
    }

    public Movimiento(int id, String tipo_operacion, String fecha, String descripcion, double monto, double tasa_cambio, double comision, Cuenta cuenta) {
        this.id = id;
        this.tipo_operacion = tipo_operacion;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.monto = monto;
        this.tasa_cambio = tasa_cambio;
        this.comision = comision;
        this.cuenta = cuenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_operacion() {
        return tipo_operacion;
    }

    public void setTipo_operacion(String tipo_operacion) {
        this.tipo_operacion = tipo_operacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getTasa_cambio() {
        return tasa_cambio;
    }

    public void setTasa_cambio(double tasa_cambio) {
        this.tasa_cambio = tasa_cambio;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "id=" + id + ", tipo_operacion=" + tipo_operacion + ", fecha=" + fecha + ", descripcion=" + descripcion + ", monto=" + monto + ", tasa_cambio=" + tasa_cambio + ", comision=" + comision + ", cuenta=" + cuenta + '}';
    }
    
    
    
}
