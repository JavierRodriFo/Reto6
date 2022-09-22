
package EmpresaDao.mysql;

import EmpresaDao.DAOException;
import EmpresaDao.ProveedorDao;
import Modelo.Proveedor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MySQLProveedorDao implements ProveedorDao {

    private String INSERT= "INSERT INTO Proveedor (id,Nombre,direccion,telefono)VALUES (?,?,?,?)";
    private String UPDATE = "UPDATE Proveedor SET  Nombre=?,direccion=?,telefono=? WHERE id = ?";
    private String DELETE = "DELETE FROM Proveedor WHERE id =  ?";
    private String GETALL = "SELECT id ,Nombre,direccion,telefono from Proveedor";
    private String GETONE = "SELECT id FROM Proveedor WHERE id =?";
    
    private Connection conn;
    
    public MySQLProveedorDao(Connection conn){
        this.conn=conn;
    }

    @Override
    public void insertar(Proveedor a)throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setLong(1, a.getId());
            stat.setString(2, a.getNombre());
            stat.setString(3, a.getDirreccion());
            stat.setString(4, a.getTelefono());
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
    public void modificar(Proveedor a) throws DAOException {
        PreparedStatement stat = null;
        
        try {
           stat= conn.prepareStatement(UPDATE);
           
           stat.setString(1, a.getNombre());
           stat.setString(2, a.getDirreccion());
           stat.setString(3, a.getTelefono());
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
    public void eliminar(Proveedor a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat=conn.prepareStatement(DELETE);
            stat.setLong(1, a.getId());
            if(stat.executeUpdate()==0){
                throw new DAOException("Puede que el proveedor no se halla eliminado");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error de SQL",ex);
        }finally{
           cerrarStatement(stat);
        }
    }
    
    private Proveedor convertir(ResultSet rs)throws SQLException{
        String Nombre = rs.getString("Nombre");
        String Direccion = rs.getString("Direccion");
        String Telefono = rs.getString("Telefono");
        Proveedor proveedor=new Proveedor(Nombre,Direccion,Telefono);
        proveedor.setId(rs.getLong("id"));
        return proveedor;
    }

    @Override
    public List<Proveedor> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
       ResultSet rs = null;
       List<Proveedor> proveedor = new ArrayList<>();
        try {
           stat = conn.prepareStatement(GETALL);
           rs = stat.executeQuery();
           while(rs.next()){
               proveedor.add(convertir(rs));
           }
           
        } catch(SQLException ex) {
            throw new DAOException("Error en SQL",ex);
        }finally{
           cerrarResultSet(rs);
           cerrarStatement(stat);
       }
        return proveedor;
    }    

    @Override
    public Proveedor obtener(Long id) throws DAOException{
       PreparedStatement stat = null;
       ResultSet rs = null;
       Proveedor p =null;
        try {
           stat = conn.prepareStatement(GETONE);
           stat.setLong(1, id);
           rs = stat.executeQuery();
           if(rs.next()){
               p=convertir(rs);
           }else{
               throw new DAOException("No se ha encontrado el registro");
           }
        } catch(SQLException ex) {
            throw new DAOException("Error en SQL",ex);
        }finally{
            cerrarResultSet(rs);
            cerrarStatement(stat);
        }
        return p; 
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
