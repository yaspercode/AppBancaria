    package model;

/**
 *
 * @author HP
 */
public class Transferencia {
    private int idTransferencia;
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;
    private double total;
    private String fecha;
    private Double comision;
    private Double tasaCambio;
    private String descripcion;
    private String tipoTransferencia;

    public Transferencia() {
    }

    public Transferencia(Cuenta cuentaOrigen, Cuenta cuentaDestino, double total, String fecha, Double comision, Double tasaCambio, String descripcion, String tipoTransferencia) {
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.total = total;
        this.fecha = fecha;
        this.comision = comision;
        this.tasaCambio = tasaCambio;
        this.descripcion = descripcion;
        this.tipoTransferencia = tipoTransferencia;
    }


//    public double calcularTotal(){
        // Lógica para calcular el total de la transferencia
        // utilizando la tasa de cambio, la comisión y el monto a transferir
//    }
    
    // Método para calcular la comisión según el monto a depositar
    public static double calcularComision(double monto) {
        if (monto <= 1000) {
            return 3.0;
        } else if (monto <= 5000) {
            return 6.0;
        } else if (monto <= 10000) {
            return 8.0;
        } else {
            return 10.0;
        }
    }
    
    // Método para obtener la tasa de cambio según el tipo de moneda de origen y destino
    public static double obtenerTasaCambio(String tipoMonedaOrigen, String tipoMonedaDestino) {
        if (tipoMonedaOrigen.equals("USD") && tipoMonedaDestino.equals("PEN")) {
            return 3.71;
        } else if (tipoMonedaOrigen.equals("PEN") && tipoMonedaDestino.equals("USD")) {
            return 0.27;
        } else {
            return 1.0;
        }
    }
    
    public void realizarTransferencias(double monto){
        // Lógica para realizar la transferencia de fondos
        // Actualizar saldos de las cuentas de origen y destino
        // Registrar la transferencia en la base de datos, etc.
        
    }

    public int getIdTransferencia() {
        return idTransferencia;
    }
    
    public void setIdTransferencia(int idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    public String getTipoTransferencia() {
        return tipoTransferencia;
    }

    public void setTipoTransferencia(String tipoTransferencia) {
        this.tipoTransferencia = tipoTransferencia;
    }
    
    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(Cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public Double getTasaCambio() {
        return tasaCambio;
    }

    public void setTasaCambio(Double tasaCambio) {
        this.tasaCambio = tasaCambio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "idTransferencia=" + idTransferencia + ", cuentaOrigen=" + cuentaOrigen + ", cuentaDestino=" + cuentaDestino + ", total=" + total + ", fecha=" + fecha + ", comision=" + comision + ", tasaCambio=" + tasaCambio + ", descripcion=" + descripcion + '}';
    }

    
    
}
