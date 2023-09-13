public class Laboratorio {
    private String[] horarioLaboratorio;
    private int capacidadLaboratorio;

    // Constructor
    public Laboratorio(String[] horarioLaboratorio, int capacidadLaboratorio) {
        this.horarioLaboratorio = horarioLaboratorio;
        this.capacidadLaboratorio = capacidadLaboratorio;
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
}
