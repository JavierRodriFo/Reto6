
package EmpresaDao.mysql;

import EmpresaDao.DAOException;
import EmpresaDao.IntencionCompraDao;
import Modelo.IntencionCompra;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MySQLIntencionCompraDao implements IntencionCompraDao {

    
    private String INSERT= "INSERT INTO IntencionCompra (idCliente,Nombre,Fabricante,fechaCotizacion)VALUES (?,?,?,?)";
    private String UPDATE = "UPDATE IntencionCompra SET idCliente=?,Nombre=?,Fabricante=?,idBicicleta=?,idMoto=?,fechaCotizacion=?, WHERE id = ?";
    private String DELETE = "DELETE FROM IntencionCompra WHERE id =  ?";
    private String GETALL = "SELECT * from IntencionCompra";
    private String GETONE = "SELECT id FROM IntencionCompra WHERE id =?";
    
    private Connection conn;
    
    public MySQLIntencionCompraDao(Connection conn){
        this.conn=conn;
    }

    @Override
    public void insertar(IntencionCompra a)throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            
            stat.setLong(1, a.getIdCliente());
            stat.setString(2, a.getNombre());
            stat.setString(3, a.getFabricante());
           // stat.setInt(4, a.getIdBicicleta());
           // stat.setInt(5, a.getIdMoto());
            stat.setString(4, a.getFechaCotizacion());
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
    public void modificar(IntencionCompra a) throws DAOException {
        PreparedStatement stat=null;
        try {
            stat = conn.prepareStatement(INSERT);
            
            stat.setLong(1, a.getIdCliente());
            stat.setString(2, a.getNombre());
            stat.setString(3, a.getFabricante());
//            stat.setInt(4, a.getIdBicicleta());
//            stat.setInt(5, a.getIdMoto());
            stat.setString(4, a.getFechaCotizacion());
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
    public void eliminar(IntencionCompra a) throws DAOException {
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
    
    private IntencionCompra convertir(ResultSet rs)throws SQLException{
        Long idCliente = rs.getLong("idCliente");
        String Nombre = rs.getString("Nombre");
        String Fabricante = rs.getString("Fabricante");
//        int idBicicleta = rs.getInt("idBicicleta");
//        int idMoto = rs.getInt("idMoto");
        String fechaCotizacion=rs.getString("fechaCotizacion");
        IntencionCompra intencion=new IntencionCompra(idCliente,Nombre,Fabricante,fechaCotizacion);
        intencion.setId(rs.getLong("id"));
        return intencion;
     }  

    @Override
    public List<IntencionCompra> obtenerTodos() throws DAOException {
       
       PreparedStatement stat = null;
       ResultSet rs = null;
       List<IntencionCompra> intencion = new ArrayList<>();
        try {
           stat = conn.prepareStatement(GETALL);
           rs = stat.executeQuery();
           while(rs.next()){
               intencion.add(convertir(rs));
           }
           
        } catch(SQLException ex) {
            throw new DAOException("Error en SQL",ex);
        }finally{
            cerrarResultSet(rs);
            cerrarStatement(stat);
        }
        return intencion;
    }

    @Override
    public IntencionCompra obtener(Long id) throws DAOException {
         PreparedStatement stat = null;
       ResultSet rs = null;
       IntencionCompra i =null;
        try {
           stat = conn.prepareStatement(GETONE);
           stat.setLong(1, id);
           rs = stat.executeQuery();
           if(rs.next()){
               i=convertir(rs);
           }else{
               throw new DAOException("No se ha encontrado el registro");
           }
        } catch(SQLException ex) {
            throw new DAOException("Error en SQL",ex);
        }finally{
             cerrarResultSet(rs);
            cerrarStatement(stat);
        }
        return i;
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


