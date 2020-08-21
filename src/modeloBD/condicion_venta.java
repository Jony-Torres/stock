package modeloBD;

/**
 *
 * @author JONY
 */
public class condicion_venta {
    int cod_condicion;
    String descripcion;
    int numero_cuota;
    int dia_inicial;
    int plazo;
    String estado;
    public condicion_venta() {
     cod_condicion=0;
     descripcion="";
     numero_cuota=0;
     dia_inicial=0;
     plazo=0;
     estado=""; 
     
    }

    public int getCod_condicion() {
        return cod_condicion;
    }

    public void setCod_condicion(int cod_condicion) {
        this.cod_condicion = cod_condicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumero_cuota() {
        return numero_cuota;
    }

    public void setNumero_cuota(int numero_cuota) {
        this.numero_cuota = numero_cuota;
    }

    public int getDia_inicial() {
        return dia_inicial;
    }

    public void setDia_inicial(int dia_inicial) {
        this.dia_inicial = dia_inicial;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
