package es.deusto.spq.data.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nickname;  		//La usamos como primaryKey
	
	private String nombre;	
	private String apellidos;		//Apellido1 + " " + Apellido2
	
	private String email;
	
	
	private String pw1;				
	private String pw2;
	
	private boolean tienePiso;

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

	public String getPw1() {
		return pw1;
	}

	public void setPw1(String pw1) {
		this.pw1 = pw1;
	}

	public String getPw2() {
		return pw2;
	}

	public void setPw2(String pw2) {
		this.pw2 = pw2;
	}

	public boolean isTienePiso() {
		return tienePiso;
	}

	public void setTienePiso(boolean tienePiso) {
		this.tienePiso = tienePiso;
	}
	
	
	
}
