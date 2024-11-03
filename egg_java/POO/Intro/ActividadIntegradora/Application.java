package POO.Intro.ActividadIntegradora;

import java.util.Scanner;

import POO.Intro.ActividadIntegradora.modelos.Empleado;

public class Application {
  static Scanner sc = new Scanner(System.in);
  static boolean filtrado = false;
  static int maxEmpleados = 5;
  static String mensajeFiltro = "";

  public static void main(String[] args) {
    Empleado[] emTodos = new Empleado[maxEmpleados];
    Empleado[] emMostrar = new Empleado[maxEmpleados];

    boolean salir = false;
    while (!salir){
      imprimirMenu();
      int op = sc.nextInt();
      sc.nextLine();
      switch (op) {
        case 1 -> mostrar(emMostrar);
        case 2 -> {
          emMostrar = emTodos;
          filtrado = false;
          System.out.println("Filtros limpiados");
          crearEmpleado(emTodos);
        }
        case 3 -> emMostrar = filtrar(emTodos);
        case 4 -> emMostrar = ordenar(emMostrar);
        case 5 -> {
          emMostrar = emTodos;
          filtrado = false;
          System.out.println("Filtros limpiados");
          incrementarSalario(emTodos);
        }
        case 6 ->  {
          emMostrar = emTodos;
          filtrado = false;
          System.out.println("Filtros limpiados");
        }
        case 7 -> salir = true;
        case 8 -> emMostrar = popularArray(emTodos);
        default -> System.out.println("Opción inválida.");
      }
    }

    sc.close();
  }

  private static void incrementarSalario(Empleado[] todos) {
    System.out.print("Ingrese el nombre del empleado para aumentar su salario: ");
    String nombre = sc.nextLine();
    Empleado e = Empleado.buscarPorNombre(todos, nombre);
    if (e == null){
      System.out.println("Ese empleado no fue encontrado");
    } else {
      System.out.println("Empleado encontrado");
      System.out.print("Ingrese el porcentaje de aumento del salario: ");
      double porcentaje = sc.nextDouble();
      Empleado.incrementarSalario(e, porcentaje);
    }

  }

  private static Empleado[] ordenar(Empleado[] emMostrar) {
    System.out.print("""
      Ingrese el atributo por el cual ordenar:
      1. Nombre
      2. Edad
      3. Salario
      4. Departamento
      """);
    System.out.print("Elije una opción: ");
    int atr = sc.nextInt();
    Empleado[] ordenado = Empleado.ordenarEmpleados(emMostrar, atr);
    Empleado.mostrarTodos(ordenado);
    return ordenado;
  }

  private static void mostrar(Empleado[] emMostrar) {
    if (filtrado){
      System.out.println(mensajeFiltro);
    }
    Empleado.mostrarTodos(emMostrar);
  }

  private static Empleado[] popularArray(Empleado[] todos) {
    todos[0] = new Empleado("Juan", 21, 2300, "Ventas");
    todos[1] = new Empleado("Alonso", 24, 1200, "Sistemas");
    todos[2] = new Empleado("Samuel", 25, 2200, "Ventas");
    todos[3] = new Empleado("Paul", 25, 3200, "Sistemas");
    return todos;
  }

  private static Empleado[] filtrar(Empleado[] emArray) {
    System.out.print("""
      Ingrese el atributo a filtrar:
      1. Nombre
      2. Edad
      3. Salario
      4. Departamento
      """);
    System.out.print("Elije una opción: ");
    int a = sc.nextInt();
    sc.nextLine();
    switch (a) {
      case 1 -> {
        System.out.print("Ingrese el valor del filtro de nombre: ");
        String valor = sc.nextLine();
        emArray = Empleado.filtrarEmpleados(emArray, "nombre", valor);
        setMensajeFiltro("Empleados filtrados por nombre: " + valor);
        Empleado.mostrarTodos(emArray);
      }
      case 2 -> {
        System.out.print("Ingrese la edad minima para el filtro: ");
        int min = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese la edad maxima para el filtro: ");
        int max = sc.nextInt();
        sc.nextLine();

        emArray = Empleado.filtrarEmpleados(emArray, "edad", min, max);
        setMensajeFiltro("Empleados filtrados por edad: " + min + "-" + max);
        Empleado.mostrarTodos(emArray);
      }
      case 3 -> {
        System.out.print("Ingrese el salario minimo para el filtro: ");
        int min = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el salario maximo para el filtro: ");
        int max = sc.nextInt();
        sc.nextLine();

        emArray = Empleado.filtrarEmpleados(emArray, "salario", min, max);
        setMensajeFiltro("Empleados filtrados por salario: " + min + "-" + max);
        Empleado.mostrarTodos(emArray);
      }
      case 4 -> {
        System.out.print("Ingrese el valor del filtro de departamento: ");
        String valor = sc.nextLine();
        emArray = Empleado.filtrarEmpleados(emArray, "departamento", valor);
        setMensajeFiltro("Empleados filtrados por departamento: " + valor);
        Empleado.mostrarTodos(emArray);
      }
    
      default -> throw new IllegalArgumentException("Error: Opción inválida.");
    }

    filtrado = true;
    return emArray;
  }

  public static void setMensajeFiltro(String mensajeFiltro) {
    Application.mensajeFiltro = mensajeFiltro;
    System.out.println(mensajeFiltro);
  }

  private static void crearEmpleado(Empleado[] emArray) {
    if (Empleado.contadorEmpleados < emArray.length){
      System.out.println("Creando empleado...");
      Empleado e = new Empleado();
      System.out.print("Ingrese su nombre: ");
      String nombre = sc.nextLine();
      Empleado encontrado = Empleado.buscarPorNombre(emArray, nombre);
      if (encontrado == null){
        e.setNombre(nombre);
        System.out.print("Ingrese su edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        e.setEdad(edad);
        System.out.print("Ingrese su salario: ");
        double salario = sc.nextDouble();
        sc.nextLine();
        e.setSalario(salario);
        System.out.print("Ingrese su departamento: ");
        String dep = sc.nextLine();
        e.setDepartamento(dep);
        emArray[Empleado.contadorEmpleados - 1] = e;
        System.out.println("Empleado creado.");
      } else {
        System.out.println("Ya existe un empleado con ese nombre");
      }
    } else {
      System.out.println("No hay espacio para crear un empleado");
    }
  }

  private static void imprimirMenu() {
    System.out.println("""
      Menu:
      1. Mostrar empleados
      2. Crear empleado
      3. Filtrar empleados
      4. Ordenar empleados
      5. Incrementar salario
      6. Limpiar filtros
      7. Salir""");
    System.out.print("Elije una opción: ");
  }
}
