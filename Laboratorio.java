public class Laboratorio {
    private String[] horarioLaboratorio;
    private int capacidadLaboratorio;

    // Constructor
    public Laboratorio(String[] horarioLaboratorio, int capacidadLaboratorio) {
        this.horarioLaboratorio = horarioLaboratorio;
        this.capacidadLaboratorio = capacidadLaboratorio;
    }

    public int getCapacidadLaboratorio() {
        return this.capacidadLaboratorio;
    }
    

    // Método para configurar un nuevo semestre
    public void configurarNuevoSemestre() {
        // Implementa la lógica aquí
    }

    // Método para verificar la disponibilidad del laboratorio en un día y hora específicos
    public boolean verificarDisponibilidad(String dia, String hora) {
        // Implementa la lógica aquí
        return false;
    }

    // Método para mostrar la información del laboratorio (por ejemplo, horario y capacidad)
    public void mostrarInformacionLaboratorio() {
        // Implementa la lógica aquí para mostrar la información del laboratorio
        System.out.println("Horario del laboratorio:");
        for (String dia : horarioLaboratorio) {
            System.out.print(dia + " ");
        }
        System.out.println("\nCapacidad del laboratorio: " + capacidadLaboratorio + " estudiantes");
    }

    public void ponerDisponibleParaNuevoSemestre(Curso[][] horarioCursos) {
        // Aquí implementaremos la lógica necesaria para poner el laboratorio disponible
        // para un nuevo semestre. Esto incluirá la eliminación de los cursos asignados.
    
        // Itera a través del horario de cursos y establece todas las casillas como nulas para eliminar los cursos asignados
        for (int fila = 0; fila < horarioCursos.length; fila++) {
            for (int columna = 0; columna < horarioCursos[fila].length; columna++) {
                horarioCursos[fila][columna] = null;
            }
        }
    
        // También puedes realizar cualquier otra configuración necesaria para el nuevo semestre aquí.
        // Por ejemplo, podrías reiniciar la capacidad del laboratorio o configurar otros datos relevantes.
    }
    
    
    
}
