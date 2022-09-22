
package Modelo;

import java.util.Objects;


public class Bicicleta {
    private Long id = null  ;
    private Long id_Fabrica;
    private int PrecioUnitario;
    private String Año;

    public Bicicleta(Long id) {
        this.id = id;
    }

    
    
    

    public Bicicleta(Long id, Long id_Fabrica, int PrecioUnitario, String Año) {
        this.id = id;
        this.id_Fabrica = id_Fabrica;
        this.PrecioUnitario = PrecioUnitario;
        this.Año = Año;
    }
   

    public Bicicleta(Long id_Fabrica, int PrecioUnitario, String Año) {
        this.id_Fabrica = id_Fabrica;
        this.PrecioUnitario = PrecioUnitario;
        this.Año = Año;
    }

    public Bicicleta() {
        
        this.Año="";
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

    public int getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(int PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public String getAño() {
        return Año;
    }

    public void setAño(String Año) {
        this.Año = Año;
    }

    @Override
    public String toString() {
        return "Bicicleta{" + "id=" + id + ", id_Fabrica=" + id_Fabrica + ", PrecioUnitario=" + PrecioUnitario + ", A\u00f1o=" + Año + '}';
    }



    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.id_Fabrica);
        hash = 79 * hash + this.PrecioUnitario;
        hash = 79 * hash + Objects.hashCode(this.Año);
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
        final Bicicleta other = (Bicicleta) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_Fabrica != other.id_Fabrica) {
            return false;
        }
        if (this.PrecioUnitario != other.PrecioUnitario) {
            return false;
        }
        if (!Objects.equals(this.Año, other.Año)) {
            return false;
        }
        return true;
    }

   
    
    
    
}
