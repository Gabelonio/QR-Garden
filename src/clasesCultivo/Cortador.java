package clasesCultivo;
/*
 * This class contains the information 
 * of a cutter, including its setters and getters.
 */
public class Cortador {
	
	/*
	 * Attributes
	 */
	private String nombres,apellidos,ID;

	/*
	 * Setters and Getters
	 */
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
}
