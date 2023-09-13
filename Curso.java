public class Curso {
    private String codigoCurso;
    private String nombreCurso;
    private int periodosPorSemana;
    private String[] diasSemana;
    private String horario;
    private int estudiantesInscritos;
    private Profesor profesorAsignado;

    public Curso(String codigoCurso, String nombreCurso, int periodosPorSemana, String[] diasSemana, String horario, int estudiantesInscritos, Profesor profesorAsignado) {
        this.codigoCurso = codigoCurso;
        this.nombreCurso = nombreCurso;
        this.periodosPorSemana = periodosPorSemana;
        this.diasSemana = diasSemana;
        this.horario = horario;
        this.estudiantesInscritos = estudiantesInscritos;
        this.profesorAsignado = profesorAsignado;
    }

    public String obtenerDetallesCurso(String dia, String hora) {
        // Itera sobre los cursos en el horario y busca el que coincide con el día y la hora
        for (int i = 0; i < diasSemana.length; i++) {
            if (diasSemana[i].equals(dia) && horario.equals(hora)) {
                // Si coincide, devuelve los detalles del curso
                return "Código del curso: " + codigoCurso +
                        "\nNombre del curso: " + nombreCurso +
                        "\nDía: " + dia +
                        "\nHora: " + hora +
                        "\nEstudiantes inscritos: " + estudiantesInscritos +
                        "\nProfesor: " + profesorAsignado.getNombreCompleto();
            }
        }
        // Si no se encuentra un curso en ese horario, devuelve un mensaje de error
        return "No se encontró ningún curso en el día " + dia + " y hora " + hora;
    }
    
    // Getters y setters para atributos
    
    // Método para asignar el curso a un horario específico
    public void asignarCurso(String dia, String hora) {
        // Implementa la lógica aquí
    }

    // Método para cambiar el horario del curso
    public void cambiarHorario(String nuevoDia, String nuevaHora) {
        // Implementa la lógica aquí
    }

    // Método para calcular si hay más estudiantes de lo permitido en el laboratorio
    public boolean calcularEstudiantesSobrantes(int capacidadLaboratorio) {
        // Implementa la lógica aquí
        return false;
    }

    // estos son los getters que genere con el ctrl . xd

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getPeriodosPorSemana() {
        return periodosPorSemana;
    }

    public void setPeriodosPorSemana(int periodosPorSemana) {
        this.periodosPorSemana = periodosPorSemana;
    }

    public String[] getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(String[] diasSemana) {
        this.diasSemana = diasSemana;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getEstudiantesInscritos() {
        return estudiantesInscritos;
    }

    public void setEstudiantesInscritos(int estudiantesInscritos) {
        this.estudiantesInscritos = estudiantesInscritos;
    }

    public Profesor getProfesorAsignado() {
        return profesorAsignado;
    }

    public void setProfesorAsignado(Profesor profesorAsignado) {
        this.profesorAsignado = profesorAsignado;
    }
    
    // Otros métodos según necesidades

    // Agrega aquí tus comentarios y documentación
}
