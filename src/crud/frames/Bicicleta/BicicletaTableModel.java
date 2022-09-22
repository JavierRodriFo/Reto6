
package crud.frames.Bicicleta;

import EmpresaDao.BicicletaDao;
import EmpresaDao.DAOException;
import Modelo.Bicicleta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class BicicletaTableModel extends AbstractTableModel {
    
    
    private BicicletaDao bicicleta;
      
    private List<Bicicleta> datos = new ArrayList<>();
    
  
    
    public BicicletaTableModel(BicicletaDao bicicleta){
        this.bicicleta = bicicleta;
    }
    public void updateModel() throws DAOException {
       datos=bicicleta.obtenerTodos();
    }
    
     @Override
    public String getColumnName(int column){
        switch(column){
            case 0:return "Id";
            case 1: return "Id_Fabrica";
            case 2: return "PrecioUnitario";
            case 3: return "Año";
            default:return "[no]";
        }
    }
    

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Bicicleta preguntado = datos.get(rowIndex);
        switch(columnIndex){
           case 0:return preguntado.getId();
           case 1:return preguntado.getId_Fabrica();
           case 2:return  preguntado.getPrecioUnitario();
           case 3 :return preguntado.getAño();
           default:
               return "";
        }
        
        
    }
    
   
    
}
