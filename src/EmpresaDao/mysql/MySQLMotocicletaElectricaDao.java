
package EmpresaDao.mysql;

import EmpresaDao.DAOException;
import EmpresaDao.MotocicletaElectricaDao;
import Modelo.MotocicletaElectrica;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MySQLMotocicletaElectricaDao implements MotocicletaElectricaDao {
    
    private String INSERT= "INSERT INTO MotocicletaElectrica (id_fabrica,id_Proveedor,PrecioUnitario,Autonomia)VALUES (?,?,?,?)";
    private String UPDATE = "UPDATE MotocicletaElectrica SET id_Fabrica=?,id_Proveedor=?,PrecioUnitario=?,Autonomia=? WHERE id = ?";
    private String DELETE = "DELETE FROM MotocicletaElectrica WHERE id =  ?";
    private String GETALL = "SELECT id ,id_Fabrica,id_Proveedor,PrecioUnitario,Autonomia from MotocicletaElectrica";
    private String GETONE = "SELECT id FROM MotocicletaElectrica WHERE id =?";
    
    private Connection conn;
    
    public MySQLMotocicletaElectricaDao(Connection conn){
        this.conn=conn;
    }

    @Override
    public void insertar(MotocicletaElectrica a)throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            
            stat.setLong(1, a.getId_Fabrica());
            stat.setLong(2, a.getId_Proveedor());
            stat.setInt(3, a.getPrecioUnitario());
            stat.setInt(4, a.getAutonomia());
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
    public void modificar(MotocicletaElectrica a) throws DAOException {
        PreparedStatement stat = null;
        
        try {
           stat= conn.prepareStatement(UPDATE);
           stat.setLong(1, a.getId_Fabrica());
           stat.setLong(2, a.getId_Proveedor());
           stat.setInt(3, a.getPrecioUnitario());
           stat.setInt(4, a.getAutonomia());
           stat.setLong(5, a.getId());
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
    public void eliminar(MotocicletaElectrica a) throws DAOException {
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
    
    private MotocicletaElectrica convertir(ResultSet rs)throws SQLException{
        Long id_Fabrica = rs.getLong("id_Fabrica");
        Long id_Proveedor = rs.getLong("id_proveedor");
        int PrecioUnitario=rs.getInt("PrecioUnitario");
        int Autonomia = rs.getInt("Autonomia");
        MotocicletaElectrica moto=new MotocicletaElectrica(id_Fabrica,id_Proveedor,PrecioUnitario,Autonomia);
        moto.setId(rs.getLong("id"));
        return moto;
    }

    @Override
    public List<MotocicletaElectrica> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
       ResultSet rs = null;
       List<MotocicletaElectrica> moto = new ArrayList<>();
        try {
           stat = conn.prepareStatement(GETALL);
           rs = stat.executeQuery();
           while(rs.next()){
               moto.add(convertir(rs));
           }
           
        } catch(SQLException ex) {
            throw new DAOException("Error en SQL",ex);
        }finally{
            cerrarResultSet(rs);
           cerrarStatement(stat);
        }
        return moto;
    }

    @Override
    public MotocicletaElectrica obtener(Long id) throws DAOException {
        PreparedStatement stat = null;
       ResultSet rs = null;
       MotocicletaElectrica m =null;
        try {
           stat = conn.prepareStatement(GETONE);
           stat.setLong(1, id);
           rs = stat.executeQuery();
           if(rs.next()){
               m=convertir(rs);
           }else{
               throw new DAOException("No se ha encontrado el registro");
           }
        } catch(SQLException ex) {
            throw new DAOException("Error en SQL",ex);
        }finally{
            cerrarResultSet(rs);
           cerrarStatement(stat);
        }
        return m;
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
