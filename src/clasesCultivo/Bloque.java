package clasesCultivo;
/*
 * This class contains the information 
 * of a block, including its setters and getters.
 */
public class Bloque {

	/*
	 * Attributes
	 */
	int numero;
	char area;
	String variedad;
	
	/*
	 * Setters and Getters
	 */
	public char getArea() {
		return area;
	}
	public void setArea(char area) {
		this.area = area;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getVariedad() {
		return variedad;
	}
	public void setVariedad(String variedad) {
		this.variedad = variedad;
	}
}
