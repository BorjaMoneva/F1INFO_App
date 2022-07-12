package modelo;

public class Circuito {
    //Variables
    private String id;
    private String fechaGp;
    private String nombreGp;
    private String paisGp;
    private String longitud;
    private String vueltas;
    private String distancia;
    private String primerGp;
    private String fotoGp;

    //Constructores
    public Circuito() {
    }

    public Circuito(String id, String fechaGp, String nombreGp, String paisGp, String longitud, String vueltas, String distancia, String primerGp, String fotoGp) {
        this.id = id;
        this.fechaGp = fechaGp;
        this.nombreGp = nombreGp;
        this.paisGp = paisGp;
        this.longitud = longitud;
        this.vueltas = vueltas;
        this.distancia = distancia;
        this.primerGp = primerGp;
        this.fotoGp = fotoGp;
    }

    //Metodos Getter y Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getVueltas() {
        return vueltas;
    }

    public void setVueltas(String vueltas) {
        this.vueltas = vueltas;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getPrimerGp() {
        return primerGp;
    }

    public void setPrimerGp(String primerGp) {
        this.primerGp = primerGp;
    }

    public String getPaisGp() {
        return paisGp;
    }

    public void setPaisGp(String paisGp) {
        this.paisGp = paisGp;
    }

    public String getNombreGp() {
        return nombreGp;
    }

    public void setNombreGp(String nombreGp) {
        nombreGp = nombreGp;
    }

    public String getFechaGp() {
        return fechaGp;
    }

    public void setFechaGp(String fechaGp) {
        this.fechaGp = fechaGp;
    }

    public String getFotoGp() {
        return fotoGp;
    }

    public void setFotoGp(String fotoGp) {
        this.fotoGp = fotoGp;
    }
}
