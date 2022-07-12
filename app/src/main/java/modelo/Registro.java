package modelo;

public class Registro {
    //Variables
    private String id;
    private String email;
    private String nomUsuario;
    private String contraseña;

    //Constructores
    public Registro(String id, String email, String nomUsuario, String contraseña) {
        this.id = id;
        this.email = email;
        this.nomUsuario = nomUsuario;
        this.contraseña = contraseña;
    }

    //Metodos Getter y Setter
    public Registro(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
