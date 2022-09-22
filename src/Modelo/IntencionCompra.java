
package Modelo;

import java.util.Date;
import java.util.Objects;


public class IntencionCompra {
    private Long id ;
    private Long idCliente;
    private String Nombre;
    private String Fabricante;
    private Long idBicicleta;
    private Long idMoto;
    private String fechaCotizacion; 

    public IntencionCompra(Long id) {
        this.id = id;
    }

    public IntencionCompra(Long id, Long idCliente, String Nombre, String Fabricante, String fechaCotizacion) {
        this.id = id;
        this.idCliente = idCliente;
        this.Nombre = Nombre;
        this.Fabricante = Fabricante;
        this.fechaCotizacion = fechaCotizacion;
    }

   

    



    public IntencionCompra(Long idCliente, String Nombre, String Fabricante, String fechaCotizacion) {
        this.idCliente = idCliente;
        this.Nombre = Nombre;
        this.Fabricante = Fabricante;
        this.fechaCotizacion = fechaCotizacion;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFabricante() {
        return Fabricante;
    }

    public void setFabricante(String Fabricante) {
        this.Fabricante = Fabricante;
    }

    public Long getIdBicicleta() {
        return idBicicleta;
    }

    public void setIdBicicleta(Long idBicicleta) {
        this.idBicicleta = idBicicleta;
    }

    public Long getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(Long idMoto) {
        this.idMoto = idMoto;
    }

    public String getFechaCotizacion() {
        return fechaCotizacion;
    }

    public void setFechaCotizacion(String fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }

    @Override
    public String toString() {
        return "IntencionCompra{" + "id=" + id + ", idCliente=" + idCliente + ", Nombre=" + Nombre + ", Fabricante=" + Fabricante + ", idBicicleta=" + idBicicleta + ", idMoto=" + idMoto + ", fechaCotizacion=" + fechaCotizacion + '}';
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.idCliente);
        hash = 67 * hash + Objects.hashCode(this.Nombre);
        hash = 67 * hash + Objects.hashCode(this.Fabricante);
        hash = 67 * hash + Objects.hashCode(this.idBicicleta);
        hash = 67 * hash + Objects.hashCode(this.idMoto);
        hash = 67 * hash + Objects.hashCode(this.fechaCotizacion);
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
        final IntencionCompra other = (IntencionCompra) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (this.idBicicleta != other.idBicicleta) {
            return false;
        }
        if (this.idMoto != other.idMoto) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Fabricante, other.Fabricante)) {
            return false;
        }
        if (!Objects.equals(this.fechaCotizacion, other.fechaCotizacion)) {
            return false;
        }
        return true;
    }

     

    

}