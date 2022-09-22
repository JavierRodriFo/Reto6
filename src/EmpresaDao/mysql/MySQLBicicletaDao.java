
package EmpresaDao.mysql;

import EmpresaDao.BicicletaDao;
import EmpresaDao.DAOException;
import Modelo.Bicicleta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MySQLBicicletaDao implements BicicletaDao {
    
    private String INSERT= "INSERT INTO bicicleta (id_Fabrica,Precio_Unitario,Año)VALUES (?,?,?)";
    private String UPDATE = "UPDATE bicicleta SET id_Fabrica=?,Precio_Unitario=?,Año=? WHERE id = ?";
    private String DELETE = "DELETE FROM bicicleta WHERE id =  ?";
    private String GETALL = "SELECT * from bicicleta";
    private String GETONE = "SELECT id,id_Fabrica,Precio_Unitario,Año FROM bicicleta WHERE id =?";
    
    private Connection conn;
    
    public MySQLBicicletaDao(Connection conn){
        this.conn=conn;
    }

    @Override
    public void insertar(Bicicleta a)throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setLong(1, a.getId_Fabrica());
            stat.setInt(2, a.getPrecioUnitario());
            stat.setString(3, a.getAño());
            if(stat.executeUpdate()==0){
                throw new DAOException("Puede que no se halla guardado");
            }
        }catch(SQLException ex){
            throw new DAOException("error en SQL",ex);
        
        } finally  {
            cerrarStatement(stat);
        }
    }

    @Override
    public void modificar(Bicicleta a)throws DAOException {
        PreparedStatement stat = null;
        
        try {
           stat= conn.prepareStatement(UPDATE);
           stat.setLong(1, a.getId_Fabrica());
           stat.setInt(2, a.getPrecioUnitario());
           stat.setString(3, a.getAño());
           stat.setLong(4, a.getId());
           if(stat.executeUpdate()==0){
               throw new DAOException("Puede que no se halla modificado");
           }
        } catch (SQLException ex) {
            throw new DAOException("Error de SQL",ex);
        }finally{
            cerrarStatement(stat);
        }
    }

    @Override
    public void eliminar(Bicicleta a) throws DAOException {
       PreparedStatement stat = null;
        try {
            stat=conn.prepareStatement(DELETE);
            stat.setLong(1, a.getId());
            if(stat.executeUpdate()==0){
                throw new DAOException("Puede que la bicicleta no se halla eliminado");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error de SQL",ex);
        }finally{
            cerrarStatement(stat);
        }
    }
    
     private Bicicleta convertir(ResultSet rs)throws SQLException{
        Long id_Fabrica = rs.getLong("id_Fabrica");
        int PrecioUnitario=rs.getInt("Precio_Unitario");
        String Año = rs.getString("Año");
        Bicicleta bicicleta=new Bicicleta(id_Fabrica,PrecioUnitario,Año);
        bicicleta.setId(rs.getLong("id"));
        return bicicleta;
    }

    @Override
    public List<Bicicleta> obtenerTodos() throws DAOException {
       PreparedStatement stat = null;
       ResultSet rs = null;
       List<Bicicleta> bicicleta = new ArrayList<>();
        try {
           stat = conn.prepareStatement(GETALL);
           rs = stat.executeQuery();
           while(rs.next()){
               bicicleta.add(convertir(rs));
           }
           
        } catch(SQLException ex) {
            throw new DAOException("Error en SQL",ex);
        }finally{
               cerrarResultSet(rs);
            cerrarStatement(stat);
        }
        return bicicleta;
    }

    @Override
    public Bicicleta obtener(Long id) throws DAOException {
       PreparedStatement stat = null;
       ResultSet rs = null;
       Bicicleta b =null;
        try {
           stat = conn.prepareStatement(GETONE);
           stat.setLong(1, id);
           rs = stat.executeQuery();
           if(rs.next()){
               b=convertir(rs);
           }else{
               throw new DAOException("No se ha encontrado el registro");
           }
        } catch(SQLException ex) {
            throw new DAOException("Error en SQL",ex);
        }finally{
              cerrarResultSet(rs);
            cerrarStatement(stat);
        }
        return b;
    }
    
    
      private void cerrarStatement(PreparedStatement stat) throws DAOException{
        if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL: ", e);
                }
            }
        
        
    }
     
     private void cerrarResultSet(ResultSet rs) throws DAOException{
        if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL: ", e);
                }
        }
        
      
    
   
        
    }
    
}
