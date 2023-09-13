import java.util.Arrays;
import java.util.Scanner;

public class SistemaAsignacionSalones {
    private Curso[][] horarioCursos;
    private Laboratorio laboratorio;

    

    // Constructor
    public SistemaAsignacionSalones(int filas, int columnas, String[] horarioLaboratorio, int capacidadLaboratorio) {
        this.horarioCursos = new Curso[filas][columnas];
        this.laboratorio = new Laboratorio(horarioLaboratorio, capacidadLaboratorio);

    
    }

    

    // Método principal
    public static void main(String[] args) {
        // horario del lab 
        String[]  horarioLaboratorio = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
        // Capacidad del lab
        int capacidadLaboratorio = 30;
        SistemaAsignacionSalones sistema = new SistemaAsignacionSalones(5, 7, horarioLaboratorio, capacidadLaboratorio);
        Scanner scanner = new Scanner(System.in);
        
        int opcion;
        Curso curso = null; // Declara la variable curso fuera del switch

        do {
            System.out.println("Bienvenido al Sistema de Asignación de Salones");
            System.out.println("1. Asignar un curso al horario del salón");
            System.out.println("2. Visualizar información de un curso en un horario");
            System.out.println("3. Eliminar un curso de un período de tiempo");
            System.out.println("4. Mostrar mensaje si hay más estudiantes inscritos que la capacidad del laboratorio");
            System.out.println("5. Cambiar horario de un curso");
            System.out.println("6. Poner disponible el laboratorio para un nuevo semestre");
            System.out.println("7. Mostrar profesor en un día y horario");
            System.out.println("8. Mostrar días en que un profesor está al frente del laboratorio");
            System.out.println("9. Mostrar cuántas veces un profesor está al frente del laboratorio");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    // Implementar la asignación de un curso al horario del salón
                    System.out.println("Asignación de Curso al Horario del Salón");
                    System.out.print("Ingrese el código del curso: ");
                    String codigoCurso = scanner.next();
                    System.out.print("Ingrese el nombre del curso: ");
                    String nombreCurso = scanner.next();
                    System.out.print("Ingrese la cantidad de períodos del curso (número de horas): ");
                    int cantidadPeriodos = scanner.nextInt();

                    System.out.print("Ingrese los días de la semana en que se imparte el curso (ejemplo: Lunes, Martes): ");
                    String inputDiasCurso = scanner.nextLine();
                    String[] diasCurso = inputDiasCurso.split(","); 
                    
                    System.out.print("Ingrese el horario en que se imparte el curso (formato HH:mm am/pm): ");
                    String horarioCurso = scanner.next();
                    System.out.print("Ingrese la cantidad de estudiantes asignados al curso: ");
                    int estudiantesAsignados = scanner.nextInt();
                    System.out.print("Ingrese el nombre completo del profesor que imparte el curso: ");
                    String nombreProfesor = scanner.next();
                    System.out.print("Ingrese el carné del profesor: ");
                    String carneProfesor = scanner.next();
                    System.out.print("Ingrese el correo electrónico del profesor: ");
                    String correoProfesor = scanner.next();
                    System.out.print("Ingrese el teléfono del profesor: ");
                    String telefonoProfesor = scanner.next();
            
                    // Ahora que tenemos todos los datos, creamos una instancia de Profesor
                    Profesor profesor = new Profesor(nombreProfesor, carneProfesor, correoProfesor, telefonoProfesor);

                    // Luego, creamos una instancia de Curso con los datos recopilados
                    curso = new Curso(codigoCurso, nombreCurso, cantidadPeriodos, diasCurso, horarioCurso, estudiantesAsignados, profesor);

                    // Verificamos la disponibilidad del laboratorio

                    // Ahora, necesitas preguntar al usuario el día y horario en el que desea asignar el curso
                    System.out.print("Ingrese el día (Lunes, Martes, Miércoles, Jueves, Viernes): ");
                    String dia = scanner.next();
                    System.out.print("Ingrese el horario (formato HH:mm am/pm): ");
                    String horario = scanner.next();
            
                    if (sistema.laboratorio.verificarDisponibilidad(dia, horario)) {
                        // Verificar si el horarioCurso está dentro de los límites permitidos del laboratorio
                        // Debes implementar esta verificación usando el horario y capacidad del laboratorio
                        
                        // Si el horario del curso es válido, asignar el curso al horario del salón
                        boolean asignado = false;
                        for (int fila = 0; fila < sistema.horarioCursos.length; fila++) {
                            for (int columna = 0; columna < sistema.horarioCursos[fila].length; columna++) {
                                if (sistema.horarioCursos[fila][columna] == null) {
                                    // Si la casilla está vacía, asignar el curso aquí
                                    sistema.horarioCursos[fila][columna] = curso;
                                    asignado = true;
                                    break;
                                }
                            }
                            if (asignado) {
                                break;
                            }
                        }
                    
                        if (asignado) {
                            System.out.println("El curso se ha asignado exitosamente al horario del salón.");
                        } else {
                            System.out.println("No hay espacio disponible en el horario del salón para este curso.");
                        }
                    } else {
                        System.out.println("El laboratorio no está disponible en ese día y horario.");
                    }
                    break;
            
                case 2:
                    // Implementar la visualización de información de un curso en un horario
                    System.out.println("Visualización de Información de un Curso en un Horario");
                    System.out.print("Ingrese el día (Lunes, Martes, Miércoles, Jueves, Viernes): ");
                    String diaConsulta = scanner.next();
                    System.out.print("Ingrese el horario (formato HH:mm am/pm): ");
                    String horaConsulta = scanner.next();
                
                    // Verifica si curso no es nulo antes de llamar a obtenerDetallesCurso
                    if (curso != null) {
                        // Llama al método obtenerDetallesCurso en la instancia de Curso
                        String detallesCurso = curso.obtenerDetallesCurso(diaConsulta, horaConsulta);
                    
                        // Imprime los detalles del curso o el mensaje de error si no se encuentra
                        System.out.println(detallesCurso);
                    } else {
                        System.out.println("No hay cursos asignados en el horario del salón.");
                    }
                    break;
                
                case 3:
                    // Implementar la eliminación de un curso de un período de tiempo
                    System.out.println("Eliminación de un Curso de un Período de Tiempo");
                    System.out.print("Ingrese el día (Lunes, Martes, Miércoles, Jueves, Viernes): ");
                    String diaEliminacion = scanner.next();
                    System.out.print("Ingrese el horario (formato HH:mm am/pm): ");
                    String horaEliminacion = scanner.next();
                    // Verifica si curso no es nulo antes de intentar eliminarlo
                       if (curso != null) {
                            boolean eliminado = false;
                            for (int fila = 0; fila < sistema.horarioCursos.length; fila++) {
                                for (int columna = 0; columna < sistema.horarioCursos[fila].length; columna++) {
                                    Curso cursoActual = sistema.horarioCursos[fila][columna];
                                    if (cursoActual != null && cursoActual.getHorario().equals(horaEliminacion) && Arrays.asList(cursoActual.getDiasSemana()).contains(diaEliminacion)) {
                                        // Si se encuentra un curso con el mismo día y horario, eliminarlo
                                        sistema.horarioCursos[fila][columna] = null;
                                        eliminado = true;
                                        break;
                                    }
                                }
                                if (eliminado) {
                                     break;
                                }
                            }
                            if (eliminado) {
                                System.out.println("El curso se ha eliminado exitosamente del período de tiempo.");
                            } else {
                                System.out.println("No se encontró ningún curso en ese día y horario para eliminar.");
                            }
                        } else {
                            System.out.println("No hay cursos asignados en el horario del salón.");
                        }
                        break;
                case 4:
                    // Implementar la verificación de estudiantes inscritos y mostrar mensaje
                    break;
                case 5:
                    // Implementar el cambio de horario de un curso
                    break;
                case 6:
                    // Implementar la puesta disponible del laboratorio para un nuevo semestre
                    break;
                case 7:
                    // Implementar la muestra del profesor en un día y horario
                    break;
                case 8:
                    // Implementar la muestra de días en que un profesor está al frente del laboratorio
                    break;
                case 9:
                    // Implementar la muestra de cuántas veces un profesor está al frente del laboratorio
                    break;
                case 0:
                    System.out.println("¡Gracias por usar el Sistema de Asignación de Salones!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
            
        } while (opcion != 0);
        
        scanner.close();
    }

    // Otros métodos según necesidades

    // Agrega aquí tus comentarios y documentación
}
