package model;

/**
 *
 * @author HP
 */
public class DatosFormulario {
    private String numeroCuenta;
    private int idCliente;
    private String nombreCliente;
    private String nombreFormulario;
    
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
    
    

}
