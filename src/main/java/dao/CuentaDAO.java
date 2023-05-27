package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cuenta;

/**
 *
 * @author HP
 */
public class CuentaDAO {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    List<Cuenta> lista;
    Cuenta c;
    
    //Si la credencial es valida me va a retornar true, si no false
    public boolean validarCuenta(Cuenta c){
        boolean esValida = false;
        try{
            con = MYSQLConexion.getConexion();
            if(con == null){
                JOptionPane.showMessageDialog(null, "No se puedo establecer la conexión con la base de datos");
                return false;
            }
            String sql = "SELECT COUNT(*) AS Cantidad FROM cuenta WHERE numero_cuenta=? AND clave=?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNumeroCuenta());
            ps.setInt(2, c.getClave());
            rs = ps.executeQuery();
            while (rs.next()) {
                int cantidad = rs.getInt("Cantidad");
                esValida= cantidad == 1;
            }
            rs.close();
            ps.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return esValida;
    }
    
    //Listado de todas las cuentas
    public List<Cuenta> listar(int id){
        lista = new ArrayList<>();
        try{
            con = MYSQLConexion.getConexion();
            if(con == null){
                JOptionPane.showMessageDialog(null, "No se puedo establecer la conexión con la base de datos");
                return lista;
            }
            String sql = "select c.tipo, c.numero_cuenta, c.saldo\n" +
                "from cuenta c\n" +
                "where c.id_cliente="+id;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new Cuenta();
                c.setTipo(rs.getString(1));
                c.setNumeroCuenta(rs.getString(2));
                c.setSaldo(rs.getDouble(3));
                lista.add(c);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public String obtenerNombreCliente(int idCliente) {
        c =null; 
        String nombreCompleto="";
        try {
            con=MYSQLConexion.getConexion();
        String sql="SELECT CONCAT(c.nombre, ' ', c.apellido) AS nombre_completo\n" +
        "FROM cliente c\n" +
        "INNER JOIN cuenta cu ON c.id_cliente = cu.id_cliente\n" +
        "WHERE cu.id_cliente ="+idCliente+";";
         ps=con.prepareStatement(sql);
         rs=ps.executeQuery();
         while(rs.next()){
         nombreCompleto = rs.getString("nombre_completo");
         }
     } catch (SQLException e) {
             e.printStackTrace();
     }
        return nombreCompleto;
    }
    
    //buscar el id del cliente pasándole el número de cuenta 
    public int buscarIdCliente(String numeroCuenta) {
    int idCliente = -1;
    try {
        con = MYSQLConexion.getConexion();
        if (con == null) {
            JOptionPane.showMessageDialog(null, "No se puedo establecer la conexión con la base de datos");
            return idCliente;
        }
        String sql = "SELECT c.id_cliente FROM cuenta c WHERE c.numero_cuenta=?";
        ps = con.prepareStatement(sql);
        ps.setString(1, numeroCuenta);
        rs = ps.executeQuery();
        if (rs.next()) {
            idCliente = rs.getInt("id_cliente");
        }
        rs.close();
        ps.close();
        con.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return idCliente;
}
    
    //Ver la cantidad de cuentas
    public int cantidadCuentas(int id_cliente) {
        int idCliente = -1;
        try {
            con = MYSQLConexion.getConexion();
            if (con == null) {
                JOptionPane.showMessageDialog(null, "No se puedo establecer la conexión con la base de datos");
                return idCliente;
            }
            String sql = "select COUNT(c.numero_cuenta) AS cantidad \n" +
            "from cuenta c\n" +
            "where c.id_cliente=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_cliente);
            rs = ps.executeQuery();
            if (rs.next()) {
                idCliente = rs.getInt("cantidad");
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idCliente;
    }
    
    public Cuenta getOne(String numeroCuenta) {
        Cuenta c =null; 
        try {
        String sql="select c.id_cuenta, c.moneda, c.saldo, c.clave\n" +
        "from cuenta c\n" +
        "where c.numero_cuenta='"+numeroCuenta+"'";
          con=MYSQLConexion.getConexion();
         ps=con.prepareStatement(sql);
         rs=ps.executeQuery();
         while(rs.next()){
         c= new Cuenta();
         c.setIdCuenta(rs.getInt(1));
         c.setMoneda(rs.getString(2));
         c.setSaldo(rs.getDouble(3));
         c.setClave(rs.getInt(4));
         }
     } catch (SQLException ex) {
               ex.getMessage();
     }
        return c;
    }

}
