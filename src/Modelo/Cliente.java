
package Modelo;

import java.util.Date;
import java.util.Objects;


public class Cliente {
    private Long id;
    private String Alias;
    private String nombre_c;
    private String Apellido;
    private String Email;
    private String Celular;
    private int contraseña;
    private String fechaNacimiento;

    public Cliente(Long id) {
        this.id = id;
    }

    public Cliente(Long id, String Alias, String nombre_c, String Apellido, String Email, String Celular, int contraseña, String fechaNacimiento) {
        this.id = id;
        this.Alias = Alias;
        this.nombre_c = nombre_c;
        this.Apellido = Apellido;
        this.Email = Email;
        this.Celular = Celular;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente(String Alias, String nombre_c, String Apellido, String Email, String Celular, int contraseña, String fechaNacimiento) {
        this.Alias = Alias;
        this.nombre_c = nombre_c;
        this.Apellido = Apellido;
        this.Email = Email;
        this.Celular = Celular;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return Alias;
    }

    public void setAlias(String Alias) {
        this.Alias = Alias;
    }

    public String getNombre_c() {
        return nombre_c;
    }

    public void setNombre_c(String nombre_c) {
        this.nombre_c = nombre_c;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public int getContraseña() {
        return contraseña;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFecha_Nacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", Alias=" + Alias + ", nombre_c=" + nombre_c + ", Apellido=" + Apellido + ", Email=" + Email + ", Celular=" + Celular + ", contrase\u00f1a=" + contraseña + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.Alias);
        hash = 73 * hash + Objects.hashCode(this.nombre_c);
        hash = 73 * hash + Objects.hashCode(this.Apellido);
        hash = 73 * hash + Objects.hashCode(this.Email);
        hash = 73 * hash + Objects.hashCode(this.Celular);
        hash = 73 * hash + this.contraseña;
        hash = 73 * hash + Objects.hashCode(this.fechaNacimiento);
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
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.contraseña != other.contraseña) {
            return false;
        }
        if (!Objects.equals(this.Alias, other.Alias)) {
            return false;
        }
        if (!Objects.equals(this.nombre_c, other.nombre_c)) {
            return false;
        }
        if (!Objects.equals(this.Apellido, other.Apellido)) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        if (!Objects.equals(this.Celular, other.Celular)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        return true;
    }

   

}