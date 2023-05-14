package model;

/**
 *
 * @author HP
 */
public class DatosFormulario {
    private String numeroCuenta;
    private String clave;
    private int idCliente;
    private String nombreCliente;
    private String nombreFormulario;
    private int idCuentaOrigen;
    private int idCuentaDestino;
    private String numeroCuentaOrigen;
    private String numeroCuentaDestino;
    private String tipoMonedaCuentaOrigen;
    private String tipoMonedaCuentaDestino;
    private double monto;
    private double saldoOrigen;
    private double saldoDestino;
    
    private static DatosFormulario instance;

    private DatosFormulario() {
        //Evitar la creación de directas de instancias
    }
    
    //Proporcionar un punto de acceso global a esat instancia
    public static DatosFormulario getInstance() {
        if (instance == null) {
            instance = new DatosFormulario();
        }
        return instance;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreFormulario() {
        return nombreFormulario;
    }

    public void setNombreFormulario(String nombreFormulario) {
        this.nombreFormulario = nombreFormulario;
    }

    public int getIdCuentaOrigen() {
        return idCuentaOrigen;
    }

    public void setIdCuentaOrigen(int idCuentaOrigen) {
        this.idCuentaOrigen = idCuentaOrigen;
    }

    public int getIdCuentaDestino() {
        return idCuentaDestino;
    }

    public void setIdCuentaDestino(int idCuentaDestino) {
        this.idCuentaDestino = idCuentaDestino;
    }

    public String getNumeroCuentaOrigen() {
        return numeroCuentaOrigen;
    }

    public void setNumeroCuentaOrigen(String numeroCuentaOrigen) {
        this.numeroCuentaOrigen = numeroCuentaOrigen;
    }

    public String getNumeroCuentaDestino() {
        return numeroCuentaDestino;
    }

    public void setNumeroCuentaDestino(String numeroCuentaDestino) {
        this.numeroCuentaDestino = numeroCuentaDestino;
    }

    public String getTipoMonedaCuentaOrigen() {
        return tipoMonedaCuentaOrigen;
    }

    public void setTipoMonedaCuentaOrigen(String tipoMonedaCuentaOrigen) {
        this.tipoMonedaCuentaOrigen = tipoMonedaCuentaOrigen;
    }

    public String getTipoMonedaCuentaDestino() {
        return tipoMonedaCuentaDestino;
    }

    public void setTipoMonedaCuentaDestino(String tipoMonedaCuentaDestino) {
        this.tipoMonedaCuentaDestino = tipoMonedaCuentaDestino;
    }

    
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getSaldoOrigen() {
        return saldoOrigen;
    }

    public void setSaldoOrigen(double saldoOrigen) {
        this.saldoOrigen = saldoOrigen;
    }

    public double getSaldoDestino() {
        return saldoDestino;
    }

    public void setSaldoDestino(double saldoDestino) {
        this.saldoDestino = saldoDestino;
    }
    
    
}
