public class Profesor {
    private String nombreCompleto;
    private String carne;
    private String correoElectronico;
    private String telefono;

    // Constructor
    public Profesor(String nombreCompleto, String carne, String correoElectronico, String telefono) {
        this.nombreCompleto = nombreCompleto;
        this.carne = carne;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
    }
    // Getters y setters para atributos
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Agrega aquí tus comentarios y documentación
}
