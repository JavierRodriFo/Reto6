
package Modelo;

import java.util.Objects;

public class MotocicletaElectrica {
    
    private Long id = null ;
    private Long id_Fabrica;
    private Long id_Proveedor;
    private int PrecioUnitario;
    private int Autonomia;

    public MotocicletaElectrica(Long id) {
        this.id = id;
    }
    
    

    public MotocicletaElectrica(Long id, Long id_Fabrica, Long id_Proveedor, int PrecioUnitario, int Autonomia) {
        this.id = id;
        this.id_Fabrica = id_Fabrica;
        this.id_Proveedor = id_Proveedor;
        this.PrecioUnitario = PrecioUnitario;
        this.Autonomia = Autonomia;
    }

    public MotocicletaElectrica(Long id_Fabrica, Long id_Proveedor, int PrecioUnitario, int Autonomia) {
        this.id_Fabrica = id_Fabrica;
        this.id_Proveedor = id_Proveedor;
        this.PrecioUnitario = PrecioUnitario;
        this.Autonomia = Autonomia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_Fabrica() {
        return id_Fabrica;
    }

    public void setId_Fabrica(Long id_Fabrica) {
        this.id_Fabrica = id_Fabrica;
    }

    public Long getId_Proveedor() {
        return id_Proveedor;
    }

    public void setId_Proveedor(Long id_Proveedor) {
        this.id_Proveedor = id_Proveedor;
    }

    public int getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(int PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public int getAutonomia() {
        return Autonomia;
    }

    public void setAutonomia(int Autonomia) {
        this.Autonomia = Autonomia;
    }

    @Override
    public String toString() {
        return "MotocicletaElectrica{" + "id=" + id + ", id_Fabrica=" + id_Fabrica + ", id_Proveedor=" + id_Proveedor + ", PrecioUnitario=" + PrecioUnitario + ", Autonomia=" + Autonomia + '}';
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.id_Fabrica);
        hash = 13 * hash + Objects.hashCode(this.id_Proveedor);
        hash = 13 * hash + this.PrecioUnitario;
        hash = 13 * hash + this.Autonomia;
        return hash;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MotocicletaElectrica other = (MotocicletaElectrica) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_Fabrica != other.id_Fabrica) {
            return false;
        }
        if (this.id_Proveedor != other.id_Proveedor) {
            return false;
        }
        if (this.PrecioUnitario != other.PrecioUnitario) {
            return false;
        }
        if (this.Autonomia != other.Autonomia) {
            return false;
        }
        return true;
    }

      
    
    
    
}
