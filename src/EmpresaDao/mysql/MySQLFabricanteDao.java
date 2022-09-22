
package EmpresaDao.mysql;

import EmpresaDao.DAO;
import EmpresaDao.DAOException;
import EmpresaDao.FabricanteDao;
import Modelo.Fabricante;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MySQLFabricanteDao implements FabricanteDao{
    
    private String INSERT= "INSERT INTO fabricante (Nombre) VALUES (?)";
    private String UPDATE = "UPDATE fabricante SET Nombre = ? WHERE Id = ?";
    private String DELETE = "DELETE FROM fabricante WHERE Id = ?";
    private String GETALL = "SELECT * FROM Fabricante";
    private String GETONE = "SELECT id ,Nombre FROM fabricante WHERE id =?";
    
    private Connection conn;
    
    public MySQLFabricanteDao(Connection conn){
        this.conn=conn;
    }


     @Override
    public void insertar(Fabricante a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, a.getNombre());
            
            if (stat.executeUpdate() == 0) {
                throw new DAOException("No se guardo en la base de datos..");
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL: ", e);
        } finally {
           cerrarStatement(stat);
        }
    }

    @Override
    public void modificar(Fabricante a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, a.getNombre());
            stat.setLong(2, a.getId());
           
            if(stat.executeUpdate()==0){
                throw new DAOException("Puede que no se halla modificado");
              }
            } catch (SQLException e) {
               throw new DAOException("Error en SQL: ", e);
            } finally {
               cerrarStatement(stat);
        }
       
       
    }

    @Override
    public void eliminar(Fabricante a) throws DAOException {
        PreparedStatement stat = null;
       
        try {
            stat= conn.prepareStatement(DELETE);
            stat.setLong(1, a.getId());
            
            if(stat.executeUpdate()==0){
                throw new DAOException("puede que el fabricante no se haya borrado");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error de SQL",ex);
        }finally{
             cerrarStatement(stat);
        }
        
    }
    
    
   

    @Override
    public List<Fabricante> obtenerTodos() throws DAOException {
       PreparedStatement stat = null;
       ResultSet rs = null;
       List<Fabricante> fabricante = new ArrayList<>();
        try {
           stat = conn.prepareStatement(GETALL);
           rs = stat.executeQuery();
           while(rs.next()){
               fabricante.add(convertir(rs));
           }
           
        } catch(SQLException ex) {
            throw new DAOException("Error en SQL",ex);
         } finally {
            cerrarResultSet(rs);
            cerrarStatement(stat);
        }
        return fabricante;
    }

    @Override
    public Fabricante obtener(Long Id) throws DAOException{
       PreparedStatement stat = null;
       ResultSet rs = null;
       Fabricante f =null;
        try {
           stat = conn.prepareStatement(GETONE);
           stat.setLong(1, Id);
           rs = stat.executeQuery();
           if(rs.next()){
               f=convertir(rs);
           }else{
               throw new DAOException("No se ha encontrado el registro");
           }
        } catch(SQLException ex) {
            throw new DAOException("Error en SQL",ex);
        }finally{
           cerrarResultSet(rs);
           cerrarStatement(stat);
        }
        return f;
    }
    
     private Fabricante convertir(ResultSet rs)throws SQLException{
        String nombre = rs.getString("nombre");
        Fabricante fabricante=new Fabricante(nombre);
        fabricante.setId(rs.getLong("Id"));
        return fabricante;
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
    
    
        
        
      
        
    
    
     
    

