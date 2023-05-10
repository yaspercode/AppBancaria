package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cuenta;
import model.Movimiento;

public class MovimientosDAO {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    List<Movimiento> lista;
    Movimiento m;
    
    //Listado de todos los movimientos del cliente
    public List<Movimiento> listar(int id){
        lista = new ArrayList<>();
        try{
            con = MYSQLConexion.getConexion();
            if(con == null){
                JOptionPane.showMessageDialog(null, "No se puedo establecer la conexión con la base de datos");
                return lista;
            }
            String sql = "select m.fecha, m.tipo_transferencia, m.monto\n" +
            "from cuenta c JOIN movimiento m ON(c.id=m.cuenta_id)\n" +
            "where c.cliente_id="+id;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                m = new Movimiento();
                m.setFecha(rs.getString(1));
                m.setTipo_trasnferencia(rs.getString(2));
                m.setMonto(rs.getDouble(3));
                lista.add(m);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
}
