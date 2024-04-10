package tarearefuerzoarrays;

import java.util.Scanner;

public class ComprasCliente {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        final int MAX_CLIENTES = 10;
	        final int MAX_COMPRAS = 5;

	        String[] nombresClientes = new String[MAX_CLIENTES];
	        Compra[][] comprasClientes = new Compra[MAX_CLIENTES][MAX_COMPRAS];
	        int[] contadorCompras = new int[MAX_CLIENTES];

	        while (true) {
	            // Menú de opciones
	            System.out.println("Menú:");
	            System.out.println("1. Dar de alta una compra");
	            System.out.println("2. Salir");
	            System.out.print("Seleccione una opción: ");
	            int opcion = scanner.nextInt();
	            scanner.nextLine(); // Consumir la nueva línea

	            switch (opcion) {
	                case 1:
	                    altaCompra(nombresClientes, comprasClientes, contadorCompras);
	                    break;
	                case 2:
	                    System.out.println("Saliendo del programa. ¡Hasta luego!");
	                    return;
	                default:
	                    System.out.println("Opción no válida.");
	            }
	        }
	    }

	    // Método para dar de alta una compra
	    public static void altaCompra(String[] nombresClientes, Compra[][] comprasClientes, int[] contadorCompras) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Ingrese el nombre del cliente: ");
	        String nombreCliente = scanner.nextLine();

	        // Buscar si el cliente ya existe
	        int indiceCliente = -1;
	        for (int i = 0; i < nombresClientes.length; i++) {
	            if (nombresClientes[i] != null && nombresClientes[i].equals(nombreCliente)) {
	                indiceCliente = i;
	                break;
	            }
	        }

	        // Si el cliente no existe, darlo de alta
	        if (indiceCliente == -1) {
	            for (int i = 0; i < nombresClientes.length; i++) {
	                if (nombresClientes[i] == null) {
	                    nombresClientes[i] = nombreCliente;
	                    indiceCliente = i;
	                    break;
	                }
	            }
	        }

	        // Pedir los datos de la compra
	        System.out.print("Ingrese la referencia del producto: ");
	        String referencia = scanner.nextLine();
	        System.out.print("Ingrese el nombre del producto: ");
	        String nombreProducto = scanner.nextLine();

	        // Crear el objeto Compra
	        Compra compra = new Compra(nombreProducto, nombreProducto);

	        // Añadir la compra al array bidimensional en la fila correspondiente al cliente
	        int contador = contadorCompras[indiceCliente];
	        comprasClientes[indiceCliente][contador] = compra;
	        contadorCompras[indiceCliente]++;

	        System.out.println("Compra registrada correctamente para el cliente " + nombreCliente + ".");
	    }
}


