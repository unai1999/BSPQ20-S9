package es.deusto.spq.data;

import java.util.List;

public class Propietario {
	private String nickname;  		//La usamos como primaryKey
	
	private String nombre;	
	private String apellidos;		//Apellido1 + " " + Apellido2
	
	private String email;
	
	
	private String pw;				
	
	private List<Piso> pisos;		//Lista de pisos que el propietario tiene para alquilar
	
	/** Constructor de la clase Administrador
	 * @param nickname
	 * @param nombre
	 * @param apellidos
	 * @param email
	 * @param pw
	 */
	public Propietario(String nickname, String nombre, String apellidos, String email, String pw) {
		this.setNickname(nickname);
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setEmail(email);
		this.setPw(pw);		
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public List<Piso> getPisos() {
		return pisos;
	}


	public void setPisos(List<Piso> pisos) {
		this.pisos = pisos;
	}
	
	
	
}
