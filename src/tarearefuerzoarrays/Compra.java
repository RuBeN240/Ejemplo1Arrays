package tarearefuerzoarrays;

public class Compra {
// Clase para representar una compra
	    private String referencia;
	    private String nombreProducto;

	    // Constructor
	    public Compra(String referencia, String nombreProducto) {
	        this.referencia = referencia;
	        this.nombreProducto = nombreProducto;
	    }

	    // Método para obtener la referencia del producto
	    public String getReferencia() {
	        return referencia;
	    }

	    // Método para obtener el nombre del producto
	    public String getNombreProducto() {
	        return nombreProducto;
	    }
	}

