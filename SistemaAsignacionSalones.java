import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SistemaAsignacionSalones {
    private static HashMap<String, Integer> contadorProfesoresFrenteLaboratorio = new HashMap<>();
    private Curso[][] horarioCursos;
    private Laboratorio laboratorio;
    // Constructor
    public SistemaAsignacionSalones(int filas, int columnas, String[] horarioLaboratorio, int capacidadLaboratorio) {
        this.horarioCursos = new Curso[filas][columnas];
        this.laboratorio = new Laboratorio(horarioLaboratorio, capacidadLaboratorio);
    }

    // Método para buscar un curso por su código
    public Curso buscarCursoPorCodigo(String codigoCurso) {
        for (int fila = 0; fila < horarioCursos.length; fila++) {
            for (int columna = 0; columna < horarioCursos[fila].length; columna++) {
                Curso cursoActual = horarioCursos[fila][columna];
                if (cursoActual != null && cursoActual.getCodigo().equals(codigoCurso)) {
                    return cursoActual; // Devuelve el curso si se encuentra
                }
            }
        }
        return null; // Devuelve null si no se encuentra el curso
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
        //int capacidadLaboratorio; // Declaración fuera del bucle

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
                    System.out.println("Verificación de Estudiantes Inscritos en un Curso");
                    System.out.print("Ingrese el día (Lunes, Martes, Miércoles, Jueves, Viernes): ");
                    String diaVerificacion = scanner.next();
                    System.out.print("Ingrese el horario (formato HH:mm am/pm): ");
                    String horaVerificacion = scanner.next();
                
                    // Buscar el curso en el horario del salón en ese día y hora
                    Curso cursoVerificacion = null;
                    for (int fila = 0; fila < sistema.horarioCursos.length; fila++) {
                        for (int columna = 0; columna < sistema.horarioCursos[fila].length; columna++) {
                            Curso cursoActual = sistema.horarioCursos[fila][columna];
                            if (cursoActual != null && cursoActual.getHorario().equals(horaVerificacion) && Arrays.asList(cursoActual.getDiasSemana()).contains(diaVerificacion)) {
                                cursoVerificacion = cursoActual;
                                break;
                            }
                        }
                        if (cursoVerificacion != null) {
                            break;
                        }   
                    }
                
                    // Verificar si se encontró un curso en ese horario y día
                    if (cursoVerificacion != null) {
                        // No necesitas declarar nuevamente capacidadLaboratorio aquí
                        // Obtener la capacidad del laboratorio
                        // capacidadLaboratorio = sistema.laboratorio.getCapacidadLaboratorio(); // No es necesario declararla nuevamente
                
                        // Verificar si hay más estudiantes inscritos que la capacidad del laboratorio
                        int estudiantesInscritos = cursoVerificacion.getEstudiantesInscritos();
                
                        if (estudiantesInscritos > capacidadLaboratorio) {
                            System.out.println("¡Alerta! Hay más estudiantes inscritos en el curso de lo que permite la capacidad del laboratorio.");
                        } else {
                            System.out.println("Los estudiantes inscritos en el curso cumplen con la capacidad del laboratorio.");
                        }
                    } else {
                        System.out.println("No se encontró ningún curso en ese día y horario.");
                    }
                    break;
                                
                case 5:
                    // Implementar el cambio de horario de un curso
                    System.out.println("Cambio de Horario de un Curso");
                    System.out.print("Ingrese el código del curso que desea cambiar de horario: ");
                    String codigoCursoCambio = scanner.next();
                
                    // Buscar el curso por su código (debes implementar esta búsqueda en tu código)
                    Curso cursoCambio = sistema.buscarCursoPorCodigo(codigoCursoCambio); 
                
                    if (cursoCambio != null) {
                        System.out.print("Ingrese el nuevo día (Lunes, Martes, Miércoles, Jueves, Viernes): ");
                        String nuevoDia = scanner.next();
                        System.out.print("Ingrese el nuevo horario (formato HH:mm am/pm): ");
                        String nuevoHorario = scanner.next();
                
                        // Llama al método cambiarHorario del curso
                        cursoCambio.cambiarHorario(nuevoDia, nuevoHorario);
                        System.out.println("El horario del curso ha sido cambiado exitosamente.");
                    } else {
                        System.out.println("No se encontró ningún curso con el código ingresado.");
                    }
                    break;
                
                case 6:
                    // Implementar la puesta disponible del laboratorio para un nuevo semestre
                    System.out.println("Puesta Disponible del Laboratorio para un Nuevo Semestre");
                    sistema.laboratorio.ponerDisponibleParaNuevoSemestre(sistema.horarioCursos);
                    System.out.println("El laboratorio se ha puesto disponible para un nuevo semestre.");
                    break;
                
                case 7:
                    // Implementar la muestra del profesor en un día y horario
                    System.out.println("Mostrar Profesor en un Día y Horario");
                    System.out.print("Ingrese el día (Lunes, Martes, Miércoles, Jueves, Viernes): ");
                    String diaProfesor = scanner.next();
                    System.out.print("Ingrese el horario (formato HH:mm am/pm): ");
                    String horarioProfesor = scanner.next();

                    // Buscar el curso en el horario del salón en ese día y hora
                    Curso cursoProfesor = null;
                    for (int fila = 0; fila < sistema.horarioCursos.length; fila++) {
                        for (int columna = 0; columna < sistema.horarioCursos[fila].length; columna++) {
                            Curso cursoActual = sistema.horarioCursos[fila][columna];
                            if (cursoActual != null && cursoActual.getHorario().equals(horarioProfesor) && Arrays.asList(cursoActual.getDiasSemana()).contains(diaProfesor)) {
                                cursoProfesor = cursoActual;
                                break;
                            }
                        }
                        if (cursoProfesor != null) {
                            break;
                        }
                    }

                    // Verificar si se encontró un curso en ese horario y día
                    if (cursoProfesor != null) {
                        // Obtener el profesor asignado al curso
                        Profesor profesorAsignado = cursoProfesor.getProfesor();

                        // Mostrar la información del profesor
                        System.out.println("El profesor asignado en el día " + diaProfesor + " a las " + horarioProfesor + " es:");
                        System.out.println("Nombre del profesor: " + profesorAsignado.getNombreCompleto());
                        System.out.println("Carné del profesor: " + profesorAsignado.getCarne());
                        System.out.println("Correo electrónico del profesor: " + profesorAsignado.getCorreoElectronico());
                        System.out.println("Teléfono del profesor: " + profesorAsignado.getTelefono());
                    } else {
                        System.out.println("No se encontró ningún curso en ese día y horario.");
                    }
                    break;

                case 8:
                    // Implementar la muestra de días en que un profesor está al frente del laboratorio
                    System.out.println("Mostrar Días en que un Profesor está al Frente del Laboratorio");
                    System.out.print("Ingrese el nombre completo del profesor: ");
                    String nombreProfesorConsulta = scanner.nextLine();
                    
                    // Variable para mantener un registro de los días encontrados
                    StringBuilder diasEncontrados = new StringBuilder();
                    
                    // Recorre todo el horario del salón
                    for (int fila = 0; fila < sistema.horarioCursos.length; fila++) {
                        for (int columna = 0; columna < sistema.horarioCursos[fila].length; columna++) {
                            Curso cursoActual = sistema.horarioCursos[fila][columna];
                            if (cursoActual != null) {
                                // Verifica si el profesor asignado coincide con el profesor de consulta
                                if (cursoActual.getProfesorAsignado().getNombreCompleto().equals(nombreProfesorConsulta)) {
                                    // Agrega el día del curso encontrado a la lista de días
                                    String[] diasCursoEncontrado = cursoActual.getDiasSemana();
                                    for (String diaEncontrado : diasCursoEncontrado) {
                                        diasEncontrados.append(diaEncontrado).append(", ");
                                    }
                                }
                            }
                        }
                    }
                    
                    // Verifica si se encontraron días para el profesor y muestra la información
                    if (diasEncontrados.length() > 0) {
                        String dias = diasEncontrados.toString().substring(0, diasEncontrados.length() - 2); // Elimina la última coma y espacio
                        System.out.println("El profesor " + nombreProfesorConsulta + " está al frente del laboratorio en los siguientes días: " + dias);
                    } else {
                        System.out.println("El profesor " + nombreProfesorConsulta + " no está al frente del laboratorio en ningún día.");
                    }
                    break;

                case 9:
                    // Implementar la muestra de cuántas veces un profesor está al frente del laboratorio
                    System.out.println("Mostrar Cuántas Veces un Profesor está al Frente del Laboratorio");
                    // Recorre todo el horario del salón
                    for (int fila = 0; fila < sistema.horarioCursos.length; fila++) {
                        for (int columna = 0; columna < sistema.horarioCursos[fila].length; columna++) {
                            Curso cursoActual = sistema.horarioCursos[fila][columna];
                            if (cursoActual != null) {
                                // Verifica si el profesor asignado coincide con el profesor de consulta
                                String nombreProfesorConsultapc = cursoActual.getProfesorAsignado().getNombreCompleto(); // Elimina esta línea
                                // Actualiza el contador del profesor
                                contadorProfesoresFrenteLaboratorio.put(nombreProfesorConsultapc, contadorProfesoresFrenteLaboratorio.getOrDefault(nombreProfesorConsultapc, 0) + 1);
                            }
                        }
                    }
                
                    // Muestra el resultado
                    if (!contadorProfesoresFrenteLaboratorio.isEmpty()) {
                        System.out.println("Contador de veces que los profesores están al frente del laboratorio:");
                        for (String nombreProfesorpn : contadorProfesoresFrenteLaboratorio.keySet()) {
                            int vecesFrenteLaboratorio = contadorProfesoresFrenteLaboratorio.get(nombreProfesorpn);
                            System.out.println(nombreProfesorpn + ": " + vecesFrenteLaboratorio + " veces");
                        }
                    } else {
                        System.out.println("No se encontraron registros de profesores al frente del laboratorio.");
                    }
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
