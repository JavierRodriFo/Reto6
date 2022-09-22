/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmpresaDao.mysql;

import EmpresaDao.ClienteDao;
import EmpresaDao.DAOException;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author usuario
 */
public class MySQLClienteDao implements ClienteDao {

    private String INSERT= "INSERT INTO Cliente (Alias,Nombre_c,Apellido,Email,Celular,Contraseña,fechaNacimiento)VALUES (?,?,?,?,?,?,?)";
    private String UPDATE = "UPDATE Cliente SET Alias=?,nombre_c=?,Apellido=?,Email=?,Celular=?,Contraseña=?,fechaNacimiento=? WHERE id = ?";
    private String DELETE = "DELETE FROM Cliente WHERE id =  ?";
    private String GETALL = "SELECT id ,Alias,nombre_c,Apellido,Email,Celular,Contraseña,fechaNacimiento from Cliente";
    private String GETONE = "SELECT id FROM Cliente WHERE id =?";
    
    private Connection conn;
    
    public MySQLClienteDao(Connection conn){
        this.conn=conn;
    }

    @Override
    public void insertar(Cliente a)throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
           
            stat.setString(1, a.getAlias());
            stat.setString(2, a.getNombre_c());
            stat.setString(3, a.getApellido());
            stat.setString(4, a.getEmail());
            stat.setString(5, a.getCelular());
            stat.setInt(6, a.getContraseña());
            stat.setString(7, a.getFechaNacimiento());
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
    public void modificar(Cliente a) throws DAOException {
        PreparedStatement stat = null;
        
        try {
           stat= conn.prepareStatement(UPDATE);
           stat.setString(1, a.getAlias());
           stat.setString(2, a.getNombre_c());
           stat.setString(3, a.getApellido());
           stat.setString(4, a.getEmail());
           stat.setString(5, a.getCelular());
           stat.setInt(6,a.getContraseña());
           stat.setString(7, a.getFechaNacimiento());
           stat.setLong(8, a.getId());
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
    public void eliminar(Cliente a) throws DAOException {
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
    
     private Cliente convertir(ResultSet rs)throws SQLException{
        String Alias = rs.getString("Alias");
        String Nombre = rs.getString("Nombre_c");
        String Apellido = rs.getString("Apellido");
        String Email = rs.getString("Email");
        String Celular = rs.getString("Celular");
        int contraseña=rs.getInt("contraseña");
        String fechaNacimiento = rs.getString("fechaNacimiento");
        Cliente cliente=new Cliente(Alias,Nombre,Apellido,Email,Celular,contraseña,fechaNacimiento);
        cliente.setId(rs.getLong("id"));
        return cliente;
     }    

    @Override
    public List<Cliente> obtenerTodos() throws DAOException {
       PreparedStatement stat = null;
       ResultSet rs = null;
       List<Cliente> cliente = new ArrayList<>();
        try {
           stat = conn.prepareStatement(GETALL);
           rs = stat.executeQuery();
           while(rs.next()){
               cliente.add(convertir(rs));
           }
           
        } catch(SQLException ex) {
            throw new DAOException("Error en SQL",ex);
        }finally{
             cerrarResultSet(rs);
            cerrarStatement(stat);
        }
        return cliente;
    }

    @Override
    public Cliente obtener(Long id) throws DAOException {
        PreparedStatement stat = null;
       ResultSet rs = null;
       Cliente c =null;
        try {
           stat = conn.prepareStatement(GETONE);
           stat.setLong(1, id);
           rs = stat.executeQuery();
           if(rs.next()){
               c=convertir(rs);
           }else{
               throw new DAOException("No se ha encontrado el registro");
           }
        } catch(SQLException ex) {
            throw new DAOException("Error en SQL",ex);
        }finally{
             cerrarResultSet(rs);
            cerrarStatement(stat);
        }
        return c;
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
