package modelo;

public class Escuderia {
    //Variables
    private String id;
    private String nombre;
    private String sede;
    private String pais;
    private String jefeEscuderia;
    private String jefeTecnico;
    private String chasis;
    private String motor;
    private String titulos;
    private String fotoEscuderia;

    //Constructores
    public Escuderia() {
    }

    public Escuderia(String nombre, String sede, String pais, String jefeEscuderia, String jefeTecnico, String chasis, String motor, String titulos, String fotoEscuderia) {
        this.nombre = nombre;
        this.sede = sede;
        this.pais = pais;
        this.jefeEscuderia = jefeEscuderia;
        this.jefeTecnico = jefeTecnico;
        this.chasis = chasis;
        this.motor = motor;
        this.titulos = titulos;
        this.fotoEscuderia = fotoEscuderia;
    }

    public Escuderia(String id, String nombre, String sede, String pais, String jefeEscuderia, String jefeTecnico, String chasis, String motor, String titulos, String fotoEscuderia) {
        this.id = id;
        this.nombre = nombre;
        this.sede = sede;
        this.pais = pais;
        this.jefeEscuderia = jefeEscuderia;
        this.jefeTecnico = jefeTecnico;
        this.chasis = chasis;
        this.motor = motor;
        this.titulos = titulos;
        this.fotoEscuderia = fotoEscuderia;
    }

    //Metodos Getter y Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getJefeEscuderia() {
        return jefeEscuderia;
    }

    public void setJefeEscuderia(String jefeEscuderia) {
        this.jefeEscuderia = jefeEscuderia;
    }

    public String getJefeTecnico() {
        return jefeTecnico;
    }

    public void setJefeTecnico(String jefeTecnico) {
        this.jefeTecnico = jefeTecnico;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getTitulos() {
        return titulos;
    }

    public void setTitulos(String titulos) {
        this.titulos = titulos;
    }

    public String getFotoEscuderia() {
        return fotoEscuderia;
    }

    public void setFotoEscuderia(String fotoEscuderia) {
        this.fotoEscuderia = fotoEscuderia;
    }
}
