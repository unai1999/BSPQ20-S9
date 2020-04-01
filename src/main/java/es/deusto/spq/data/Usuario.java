package es.deusto.spq.data;

public class Usuario {
	
	private String nickname;  		//La usamos como primaryKey
	
	private String nombre;	
	private String apellidos;		//Apellido1 + " " + Apellido2
	
	private String email;
	
	
	private String pw;				//TODO encriptar pw.
	
	private Piso piso;				//Si el usuario solo puede tener un piso alquilado.
	private boolean tienePiso;		
	
	public Piso getPiso() {
		return piso;
	}



	public void setPiso(Piso piso) {
		this.piso = piso;
	}



	public boolean isTienePiso() {
		return tienePiso;
	}



	public void setTienePiso(boolean tienePiso) {
		this.tienePiso = tienePiso;
	}



	/** Constructor de la clase Usuario
	 * @param nickname 
	 * @param nombre
	 * @param apellidos
	 * @param email
	 * @param pw
	 */
	public Usuario(String nickname, String nombre, String apellidos, String email, String pw) {
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
}
