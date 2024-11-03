package POO.Intro.ActividadIntegradora.modelos;

import java.util.Arrays;

public class Empleado {
  private String nombre;
  private int edad;
  private double salario;
  private String departamento;
  public static int contadorEmpleados = 0;

  public Empleado(String nombre, int edad, double salario, String departamento) {
    this.nombre = nombre;
    this.edad = edad;
    this.salario = salario;
    this.departamento = departamento;
    contadorEmpleados++;
  }

  public Empleado(){
    contadorEmpleados++;
  }

  public static void mostrarTodos(Empleado[] empleados){
    if (contadorEmpleados > 0){
      String encabezado = "# | Nombre                    | Edad | Salario | Departamento";
      System.out.println(encabezado);
      char[] linea = new char[encabezado.length()];
      Arrays.fill(linea, '-');
      System.out.println(new String(linea));

      for (int i = 0; i < contadorEmpleados; i++) {
        Empleado e = empleados[i];
        if (e == null){
          break;
        }
        String fila = "%d | %s | %s | %s | %s ";
        fila = String.format(fila,
          i + 1,
          llenarCelda(e.getNombre(), 1),
          llenarCelda(Integer.toString(e.getEdad()), 2),
          llenarCelda(Double.toString(e.getSalario()), 3),
          llenarCelda(e.getDepartamento(), 4)
        );
        System.out.println(fila);
      }

      System.out.println(new String(linea));
    } else {
      System.out.println("No hay empleados");
    }
  }

  private static String llenarCelda(String valor, int col) {
    int anchoCol;
    switch (col) {
      case 1 -> anchoCol = 25;
      case 2 -> anchoCol = 4;
      case 3 -> anchoCol = 7;
      case 4 -> anchoCol = 12;
      default -> anchoCol = 0;
    }

    int n = anchoCol - valor.length();
    char[] espacios = new char[n];
    Arrays.fill(espacios, ' ');
    String espaciosString = new String(espacios);
    String nuevo = valor + espaciosString;
    return nuevo;
  }

  public static Empleado[] filtrarEmpleados(Empleado[] empleados, String atributo, String filtroString) {
    // Stream<Empleado> stream = Arrays.stream(empleados);
    Empleado[] filtrado = new Empleado[empleados.length];
    switch (atributo) {
      case "nombre" -> {
        int fi = 0;
        for (int i = 0; i < empleados.length; i++) {
          Empleado e = empleados[i];
          if (e == null){
            break;
          }
          if (e.getNombre().contains(filtroString)){
            filtrado[fi] = e;
            fi++;
          }
        }
      }
      case "departamento" -> {
        int fi = 0;
        for (int i = 0; i < empleados.length; i++) {
          Empleado e = empleados[i];
          if (e == null){
            break;
          }
          if (e.getDepartamento().contains(filtroString)){
            filtrado[fi] = e;
            fi++;
          }
        }
      }
      default -> {
        throw new IllegalArgumentException("Error: Atributo desconocido");
      }
    }
     
    return filtrado;
  }

  public static Empleado[] filtrarEmpleados(Empleado[] empleados, String atributo, int filtroMin, int filtroMax) {
    Empleado[] filtrado = new Empleado[empleados.length];
    switch (atributo) {
      case "edad" -> {
        int fi = 0;
        for (int i = 0; i < empleados.length; i++) {
          Empleado e = empleados[i];
          if (e == null){
            break;
          }
          if (e.getEdad() >= filtroMin && e.getEdad() <= filtroMax){
            filtrado[fi] = e;
            fi++;
          }
        }
      }
      case "salario" -> {
        int fi = 0;
        for (int i = 0; i < empleados.length; i++) {
          Empleado e = empleados[i];
          if (e == null){
            break;
          }
          if (e.getSalario() >= filtroMin && e.getSalario() <= filtroMax){
            filtrado[fi] = e;
            fi++;
          }
        }
      }
      default -> {
        throw new IllegalArgumentException("Error: Atributo desconocido");
      }
    }
    return filtrado;
  }

  public static Empleado[] ordenarEmpleados(Empleado[] empleados, int atr){
    int n = empleados.length;
    for (int i = 0; i < n - 1; i++) {
      if (empleados[i] == null){
        break;
      }
      for (int j = 0; j < n - i - 1; j++) {
        if (empleados[j] == null || empleados[j + 1] == null){
          break;
        }
        boolean comparar = compararEmpleados(empleados[j], empleados[j + 1], atr);
        if (comparar) {
          Empleado temp = empleados[j];
          empleados[j] = empleados[j + 1];
          empleados[j + 1] = temp;
        }
      }
    }
    return empleados;
  }

  private static boolean compararEmpleados(Empleado e1, Empleado e2, int atributo){
    boolean primeroMayor;
    switch (atributo) {
      case 1 -> primeroMayor = e1.getNombre().compareTo(e2.getNombre()) > 0;
      case 2 -> primeroMayor = e1.getEdad() > e2.getEdad();
      case 3 -> primeroMayor = e1.getSalario() > e2.getSalario();
      case 4 -> primeroMayor = e1.getDepartamento().compareTo(e2.getDepartamento()) > 0;
      default -> throw new IllegalArgumentException("Error: Atributo desconocido");
    }

    return primeroMayor;
  }

  public static Empleado buscarPorNombre(Empleado[] empleados, String nombre){
    for (Empleado e : empleados) {
      if (e == null){
        break;
      }
      if (e.getNombre().equals(nombre)){
        return e;
      }
    }

    return null;
  }

  public static Empleado incrementarSalario(Empleado em, double porcentaje){
    double aumento = 1 + (porcentaje / 100);
    double nuevoSalario = em.getSalario() * aumento;
    em.setSalario(nuevoSalario);
    System.out.println("Nuevo salario: " + nuevoSalario);
    return em;
  }

  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public int getEdad() {
    return edad;
  }
  public void setEdad(int edad) {
    this.edad = edad;
  }
  public double getSalario() {
    return salario;
  }
  public void setSalario(double salario) {
    this.salario = salario;
  }
  public String getDepartamento() {
    return departamento;
  }
  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }
  
}
