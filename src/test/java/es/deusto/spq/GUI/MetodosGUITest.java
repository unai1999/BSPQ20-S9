package es.deusto.spq.GUI;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.Piso;
import es.deusto.spq.data.Post;

public class MetodosGUITest {

	MetodosGUI mGUI;
	
	
	
	@Before
	public void setUp() {
		mGUI = new MetodosGUI();
	}
	
	@Test
	public void validarNombreTest() { //Falta algo
		assertTrue(mGUI.validarNombre("Eneko"));
		assertFalse(mGUI.validarNombre(""));
	}
	
	@Test
	public void validarUsuarioTest() {
		assertTrue(mGUI.validarUsuario("eneko98"));
		assertTrue(mGUI.validarUsuario(""));
	}
	
	@Test
	public void validarContrasenyaTest() { //falta algo
		assertTrue(mGUI.validarContrasenya("12345678"));
		assertFalse(mGUI.validarContrasenya("a123dg"));
	}
	
	@Test 
	public void validarConfContrasenyaTest() {
		assertTrue(mGUI.validarConfContrasenya("12345678", "12345678"));
		assertFalse(mGUI.validarConfContrasenya("asd12334", "12345678"));
	}
	
	@Test
	public void validarEmailTest() {
		assertTrue(mGUI.validarEmail("enekovalero@gmail.com"));
		assertFalse(mGUI.validarEmail("eneko"));
	}
	
	@Test
	public void validarBuscarPisos() {
		JTextField texto = new JTextField();
		texto.setText("Bilbao");
		JTextField texto2 = new JTextField();
		texto2.setText("Sevilla");
		JTextField texto3 = new JTextField();
		texto3.setText("Barcelona");
		JTextField texto4 = new JTextField();
		texto4.setText("Bilbao");
		
		Piso p1 = new Piso("AAA", 2.0);
		Piso p2 = new Piso("BBB", 3.0);
		Piso p3 = new Piso("CCC", 4.0);
		p1.setLocalizacion("Bilbao");
		p2.setLocalizacion("Sevilla");
		p3.setLocalizacion("Bilbao");
		List<Piso> pisos = new ArrayList<Piso>();
		pisos.add(p1);
		pisos.add(p2);
		pisos.add(p3);
		
		assertTrue(mGUI.buscarPisos(texto, pisos).size() == 2);
		assertTrue(mGUI.buscarPisos(texto2, pisos).size() == 1);
		assertTrue(mGUI.buscarPisos(texto3, pisos).size() == 0);
		assertTrue(mGUI.buscarPisos(texto4, pisos).size() == 2);
		
	}
	
	@Test
	public void validarBuscarPosts() {
		JTextField texto = new JTextField();
		texto.setText("Aitor");
		JTextField texto2 = new JTextField();
		texto2.setText("Ander");
		JTextField texto3 = new JTextField();
		texto3.setText("Iñigo");
		
		Post p1 = new Post("AAA", "Aitor", "AAAAA");
		Post p2 = new Post("CCC", "Aitor", "CCCCC");
		Post p3 = new Post("DDD", "Ander", "DDDDD");

		List<Post> posts = new ArrayList<Post>();
		posts.add(p1);
		posts.add(p2);
		posts.add(p3);
		
		assertTrue(mGUI.buscarPosts(texto, posts).size() == 2);
		assertTrue(mGUI.buscarPosts(texto2, posts).size() == 1);
		assertTrue(mGUI.buscarPosts(texto3, posts).size() == 0);
	}
	
	@Test
	public void validarObtenerPiso() { 
		
		Piso p1 = new Piso("AAA", 2.0);
		Piso p2 = new Piso("BBB", 3.0);
		Piso p3 = new Piso("CCC", 4.0);
		
		p1.setLocalizacion("Bilbao");
		p2.setLocalizacion("Sevilla");
		p3.setLocalizacion("Bilbao");
		List<Piso> pisos = new ArrayList<Piso>();
		pisos.add(p1);
		pisos.add(p2);
		pisos.add(p3);
		
		assertTrue(mGUI.obtenerPiso("piso:AAA", pisos).getNombre() == "AAA");
		assertTrue(mGUI.obtenerPiso("Precio:AAA", pisos).getNombre() == "AAA");
		assertTrue(mGUI.obtenerPiso("Valora:AAA", pisos).getNombre() == "AAA");
	}
	
	@Test
	public void validarObtenerPost() {
		Post p1 = new Post("AAA", "BBB", "CCC");
		Post p2 = new Post ("EEE", "DDD", "FFF");
		List<Post> posts = new ArrayList<Post>();
		posts.add(p1);
		posts.add(p2);
		
		assertTrue(mGUI.obtenerPost("Titulo: AAA", posts).getTitulo() == "AAA" );
		assertTrue(mGUI.obtenerPost("Descripción: AAA", posts).getTitulo() == "AAA" );
		assertTrue(mGUI.obtenerPost("Dutor: AAA", posts).getTitulo() == "AAA" );
		assertTrue(mGUI.obtenerPost("Likes: AAA", posts).getTitulo() == "AAA" );
	}
	
//	@Test
//	public void validarGetPisos() {
//		
//	}
	
	
}
