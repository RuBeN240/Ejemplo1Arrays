package tarearefuerzoarrays;

import javax.swing.JOptionPane;

public class Ejercicio1 {
	    public static void main(String[] args) {
	        final int MAX_CONTACTOS = 10;
	        String[] nombres = new String[MAX_CONTACTOS];
	        String[][] telefonos = new String[MAX_CONTACTOS][];
	        int contadorContactos = 0;

	        while (true) {
	            // Menú de opciones
	            String[] opciones = {"Dar de alta un contacto", "Consultar todos los contactos", "Consultar teléfonos de un contacto", "Salir"};
	            int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Agenda Telefónica", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

	            switch (opcion) {
	                case 0:
	                    if (contadorContactos < MAX_CONTACTOS) {
	                        altaContacto(nombres, telefonos, contadorContactos);
	                        contadorContactos++;
	                    } else {
	                        JOptionPane.showMessageDialog(null, "La agenda está llena. No se pueden añadir más contactos.");
	                    }
	                    break;
	                case 1:
	                    consultarTodos(nombres, telefonos, contadorContactos);
	                    break;
	                case 2:
	                    consultarTelefono(nombres, telefonos, contadorContactos);
	                    break;
	                case 3:
	                    JOptionPane.showMessageDialog(null, "Saliendo del programa. ¡Hasta luego!");
	                    System.exit(0);
	                default:
	                    JOptionPane.showMessageDialog(null, "Opción no válida");
	            }
	        }
	    }

	    // Método para dar de alta un contacto
	    public static void altaContacto(String[] nombres, String[][] telefonos, int indice) {
	        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del contacto:");
	        if (nombre != null && !nombre.isEmpty()) {
	            int numTelefonos = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos teléfonos tiene " + nombre + "?"));
	            String[] listaTelefonos = new String[numTelefonos];
	            for (int i = 0; i < numTelefonos; i++) {
	                String telefono = JOptionPane.showInputDialog("Ingrese el teléfono " + (i + 1) + " de " + nombre + ":");
	                listaTelefonos[i] = telefono;
	            }
	            nombres[indice] = nombre;
	            telefonos[indice] = listaTelefonos;
	            JOptionPane.showMessageDialog(null, "Contacto " + nombre + " dado de alta exitosamente.");
	        } else {
	            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre válido.");
	        }
	    }

	    // Método para consultar todos los contactos
	    public static void consultarTodos(String[] nombres, String[][] telefonos, int contadorContactos) {
	        StringBuilder mensaje = new StringBuilder("Lista de contactos:\n");
	        for (int i = 0; i < contadorContactos; i++) {
	            mensaje.append(nombres[i]).append(": ");
	            for (String telefono : telefonos[i]) {
	                mensaje.append(telefono).append(", ");
	            }
	            mensaje.delete(mensaje.length() - 2, mensaje.length()); // Eliminar la coma y el espacio final
	            mensaje.append("\n");
	        }
	        JOptionPane.showMessageDialog(null, mensaje.toString());
	    }

	    // Método para consultar los teléfonos de un contacto específico
	    public static void consultarTelefono(String[] nombres, String[][] telefonos, int contadorContactos) {
	        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del contacto:");
	        boolean encontrado = false;
	        for (int i = 0; i < contadorContactos; i++) {
	            if (nombre.equals(nombres[i])) {
	                encontrado = true;
	                StringBuilder mensaje = new StringBuilder("Teléfonos de " + nombre + ":\n");
	                for (String telefono : telefonos[i]) {
	                    mensaje.append(telefono).append("\n");
	                }
	                JOptionPane.showMessageDialog(null, mensaje.toString());
	                break;
	            }
	        }
	        if (!encontrado) {
	            JOptionPane.showMessageDialog(null, "El contacto " + nombre + " no existe.");
	        }
	    }
	}

