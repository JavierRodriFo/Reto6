
package crud.frames.Fabricante;


import EmpresaDao.DAOException;
import EmpresaDao.FabricanteDao;
import Modelo.Fabricante;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class FabricanteTableModel  extends AbstractTableModel {
    
  private FabricanteDao fabricante;
  
  private List<Fabricante> datos = new ArrayList<>();
  
  public FabricanteTableModel(FabricanteDao fabricante){
      this.fabricante= fabricante;
      
  }
  
  public void updateModel() throws DAOException{
      datos=fabricante.obtenerTodos();
  }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0: return "Id";
            case 1: return "Nombre";
            default: return "[no]";
        }
        
    }

     @Override
    public int getRowCount() {
        return  datos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Fabricante preguntado = datos.get(rowIndex);
       switch(columnIndex){
           case 0:return preguntado.getId();
           case 1:return preguntado.getNombre();
           default:
               return "";
       }
        
    }

}
