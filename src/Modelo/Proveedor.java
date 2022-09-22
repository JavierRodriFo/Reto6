
package Modelo;

import java.util.Objects;


public class Proveedor {
    private Long id = null;
    private String Nombre;
    private String Dirreccion;
    private String Telefono;

    public Proveedor(Long id, String Nombre, String Dirreccion, String Telefono) {
        this.id = id;
        this.Nombre = Nombre;
        this.Dirreccion = Dirreccion;
        this.Telefono = Telefono;
    }

    public Proveedor(Long id) {
        this.id = id;
    }

    public Proveedor(String Nombre, String Dirreccion, String Telefono) {
        this.Nombre = Nombre;
        this.Dirreccion = Dirreccion;
        this.Telefono = Telefono;
    }

    public Proveedor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getDirreccion() {
        return Dirreccion;
    }

    public void setDirreccion(String Dirreccion) {
        this.Dirreccion = Dirreccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id=" + id + ", Nombre=" + Nombre + ", Dirreccion=" + Dirreccion + ", Telefono=" + Telefono + '}';
    }



    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.Nombre);
        hash = 79 * hash + Objects.hashCode(this.Dirreccion);
        hash = 79 * hash + Objects.hashCode(this.Telefono);
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
        final Proveedor other = (Proveedor) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Dirreccion, other.Dirreccion)) {
            return false;
        }
        if (!Objects.equals(this.Telefono, other.Telefono)) {
            return false;
        }
        return true;
    }

    public void requestFocus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    

}