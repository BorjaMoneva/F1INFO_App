package modelo;

public class SistemaPuntos {
    //Variables
    private String id;
    private String posicion;
    private String puntosPosicion;

    //Constructores
    public SistemaPuntos(String id, String posicion, String puntosPosicion) {
        this.id = id;
        this.posicion = posicion;
        this.puntosPosicion = puntosPosicion;
    }

    public SistemaPuntos() {
    }

    //Metodos Getter y Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getPuntosRepartir() {
        return puntosPosicion;
    }

    public void setPuntosRepartir(String puntosPosicion) {
        this.puntosPosicion = puntosPosicion;
    }
}
