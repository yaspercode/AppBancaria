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
            ps.setString(1, c.getNumero_cuenta());
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
            String sql = "select c.tipo_cuenta, c.numero_cuenta, c.monto\n" +
                "from cuenta c\n" +
                "where c.cliente_id="+id;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new Cuenta();
                c.setTipo_cuenta(rs.getString(1));
                c.setNumero_cuenta(rs.getString(2));
                c.setMonto(rs.getDouble(3));
                lista.add(c);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public Cuenta getOne(String num_cuenta) {
        c =null; 
        try {
            con=MYSQLConexion.getConexion();
        String sql="select c.cliente_id, c.tipo_cuenta, c.numero_cuenta, c.monto from cuenta c where c.numero_cuenta='"+num_cuenta+"'";
         ps=con.prepareStatement(sql);
         rs=ps.executeQuery();
         while(rs.next()){
         c= new Cuenta();
         c.setId(rs.getInt(1));
         c.setTipo_cuenta(rs.getString(2));
         c.setNumero_cuenta(rs.getString(3));
         c.setMonto(rs.getDouble(4));
         }
     } catch (SQLException e) {
             e.printStackTrace();
     }
        return c;
    }
    
    //buscar el id del cliente pasándole el número de cuenta 
    public int buscarIdCliente(String numeroCuenta) {
    int idCuenta = -1;
    try {
        con = MYSQLConexion.getConexion();
        if (con == null) {
            JOptionPane.showMessageDialog(null, "No se puedo establecer la conexión con la base de datos");
            return idCuenta;
        }
        String sql = "SELECT c.cliente_id FROM cuenta c WHERE numero_cuenta=?";
        ps = con.prepareStatement(sql);
        ps.setString(1, numeroCuenta);
        rs = ps.executeQuery();
        if (rs.next()) {
            idCuenta = rs.getInt("cliente_id");
        }
        rs.close();
        ps.close();
        con.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return idCuenta;
}

}
