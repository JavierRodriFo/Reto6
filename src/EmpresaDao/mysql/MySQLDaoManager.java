
package EmpresaDao.mysql;

import EmpresaDao.BicicletaDao;
import EmpresaDao.ClienteDao;
import EmpresaDao.DAOException;
import EmpresaDao.DaoManager;
import EmpresaDao.FabricanteDao;
import EmpresaDao.IntencionCompraDao;
import EmpresaDao.MotocicletaElectricaDao;
import EmpresaDao.ProveedorDao;
import Modelo.Fabricante;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MySQLDaoManager implements DaoManager {
    
    private Connection conn;
    
    private FabricanteDao fabricante=null;
    private BicicletaDao bicicleta =null;
    private ProveedorDao proveedor= null;
    private MotocicletaElectricaDao moto=null;
    private ClienteDao cliente = null;
    private IntencionCompraDao compra = null;
    
    
    public MySQLDaoManager(String host,String database,String username,String password)throws SQLException{
        conn= DriverManager.getConnection("jdbc:mysql://"+ host+ "/" + database, username, password);
    
    }

    @Override
    public FabricanteDao getFabricanteDao() {
        if (fabricante ==null){
            fabricante = new MySQLFabricanteDao(conn);
        }
        return fabricante;
    }

    @Override
    public BicicletaDao getBicicletaDao() {
        if(bicicleta ==null){
            bicicleta= new MySQLBicicletaDao(conn);
        }
        return bicicleta;
    }

    @Override
    public ProveedorDao getProveedorDao() {
        if(proveedor==null){
            proveedor=new MySQLProveedorDao(conn);
        }
            return proveedor;
    }

    @Override
    public MotocicletaElectricaDao getMotocicletaElectricaDao() {
        
        if(moto == null){
            moto = new MySQLMotocicletaElectricaDao(conn);
        }
        return moto;
    }

    @Override
    public ClienteDao getClienteDao() {
        if(cliente == null){
            cliente = new MySQLClienteDao(conn);
        }
        return cliente;
    }

    @Override
    public IntencionCompraDao getIntencionCompraDao() {
        if (compra == null){
            compra = new MySQLIntencionCompraDao(conn);
        }
        return compra;
    }
    
    public static void main(String[] args) throws SQLException,DAOException {
        MySQLDaoManager man = new MySQLDaoManager("localhost:3306", "ecodosruedas_ltda", "root", "123456");
//        List<Fabricante> fabricante = man.getFabricanteDao().obtenerTodos();
//        System.out.println(fabricante);
////        
        
//        Fabricante f=new Fabricante("EMILI");
//          man.getFabricanteDao().insertar(f);
//          
//         Fabricante f=new Fabricante(33,"VICTORIA");
//         man.getFabricanteDao().modificar(f);

//            Fabricante f=new Fabricante(43);
//            man.getFabricanteDao().eliminar(f);
//           
    }
    
}
