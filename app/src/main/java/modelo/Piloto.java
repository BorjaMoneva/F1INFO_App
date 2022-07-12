package modelo;

public class Piloto {
    //Variables
    private String id;
    private String nombre;
    private String apellido;
    private String pais;
    private String nPodios;
    private String nVictorias;
    private String gpDisputados;
    private String cumpleaños;
    private String nVueltasRapidas;
    private String titulos;
    private String fotoPiloto;
    private String idEscuderia;

    //Constructores
    public Piloto() {
    }


    public Piloto(String nombre, String apellido, String pais, String nPodios, String nVictorias, String gpDisputados, String cumpleaños, String nVueltasRapidas, String titulos, String fotoPiloto, String idEscuderia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
        this.nPodios = nPodios;
        this.nVictorias = nVictorias;
        this.gpDisputados = gpDisputados;
        this.cumpleaños = cumpleaños;
        this.nVueltasRapidas = nVueltasRapidas;
        this.titulos = titulos;
        this.fotoPiloto = fotoPiloto;
        this.idEscuderia = idEscuderia;
    }

    public Piloto(String id, String nombre, String apellido, String pais, String nPodios, String nVictorias, String gpDisputados, String cumpleaños, String nVueltasRapidas, String titulos, String fotoPiloto, String idEscuderia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
        this.nPodios = nPodios;
        this.nVictorias = nVictorias;
        this.gpDisputados = gpDisputados;
        this.cumpleaños = cumpleaños;
        this.nVueltasRapidas = nVueltasRapidas;
        this.titulos = titulos;
        this.fotoPiloto = fotoPiloto;
        this.idEscuderia = idEscuderia;
    }

    //Metodos Getter y Setter
    public String getId() {return id;}
    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getnPodios() {
        return nPodios;
    }

    public void setnPodios(String nPodios) {
        this.nPodios = nPodios;
    }

    public String getnVictorias() {
        return nVictorias;
    }

    public void setnVictorias(String nVictorias) {
        this.nVictorias = nVictorias;
    }

    public String getGpDisputados() {
        return gpDisputados;
    }

    public void setGpDisputados(String gpDisputados) {
        this.gpDisputados = gpDisputados;
    }

    public String getCumpleaños() {
        return cumpleaños;
    }

    public void setCumpleaños(String cumpleaños) {
        this.cumpleaños = cumpleaños;
    }

    public String getnVueltasRapidas() {
        return nVueltasRapidas;
    }

    public void setnVueltasRapidas(String nVueltasRapidas) {
        this.nVueltasRapidas = nVueltasRapidas;
    }

    public String getTitulos() {
        return titulos;
    }

    public void setTitulos(String titulos) {
        this.titulos = titulos;
    }

    public String getFotoPiloto() {
        return fotoPiloto;
    }

    public void setFotoPiloto(String fotoPiloto) {
        this.fotoPiloto = fotoPiloto;
    }

    public String getIdEscuderia() {
        return idEscuderia;
    }

    public void setIdEscuderia(String idEscuderia) {
        this.idEscuderia = idEscuderia;
    }
}
