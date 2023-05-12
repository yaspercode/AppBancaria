package model;

/**
 *
 * @author HP
 */
public class Movimiento {
    private int id;
    private String tipo_trasnferencia; //Entre mis cuentas o a otra persona del mismo banco
    private double monto;
    private double comision;
    private double tasaCambio;
    private String descripcion;
    private String fecha;
    private Cuenta cuenta;

    public Movimiento() {
    }

    public Movimiento(int id, String tipo_trasnferencia, double monto, double comision, double tasaCambio, String descripcion, String fecha, Cuenta cuenta) {
        this.id = id;
        this.tipo_trasnferencia = tipo_trasnferencia;
        this.monto = monto;
        this.comision = comision;
        this.tasaCambio = tasaCambio;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.cuenta = cuenta;
    }

    
    public void convertir(String tipoMoneda, String monedaDestino) {
        double tasaCambio;
        if (tipoMoneda.equals("USD") && monedaDestino.equals("PEN")) {
            tasaCambio = 3.71;
        } else if (tipoMoneda.equals("PEN") && monedaDestino.equals("USD")) {
            tasaCambio = 0.27;
        } else {
            tasaCambio = 1;
        }
        monto = monto * tasaCambio;
        tipoMoneda = monedaDestino;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_trasnferencia() {
        return tipo_trasnferencia;
    }

    public void setTipo_trasnferencia(String tipo_trasnferencia) {
        this.tipo_trasnferencia = tipo_trasnferencia;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public double getTasaCambio() {
        return tasaCambio;
    }

    public void setTasaCambio(double tasaCambio) {
        this.tasaCambio = tasaCambio;
    }
    
    

    @Override
    public String toString() {
        return "Movimiento{" + "id=" + id + ", tipo_trasnferencia=" + tipo_trasnferencia + ", monto=" + monto + ", comision=" + comision + ", descripcion=" + descripcion + ", fecha=" + fecha + ", cuenta=" + cuenta + '}';
    }
    
    
}
