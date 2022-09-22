
package Modelo;

import java.util.Objects;


public class Fabricante {
    private Long id = null;
    
    private String Nombre;

    public Fabricante(String Nombre,Long id) {
        
        this.Nombre = Nombre;
        this.id = id;
    }
    

    public Fabricante(String Nombre) {
        this.Nombre = Nombre;
    }

    public Fabricante(Long id) {
        this.id = id;
    }

    public Fabricante() {
       this.Nombre = "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return "Fabricante{" + "id=" + id + ", Nombre=" + Nombre + '}';
    }



    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.Nombre);
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
        final Fabricante other = (Fabricante) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        return true;
    }
    
   
    
    }

    

    

