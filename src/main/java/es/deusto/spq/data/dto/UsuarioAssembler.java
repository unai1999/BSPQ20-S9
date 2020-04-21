package es.deusto.spq.data.dto;

import es.deusto.spq.data.Usuario;

public class UsuarioAssembler {

	public UsuarioDTO assemble(Usuario usuario) {
		
		if(usuario == null) return null;
		
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		
		usuarioDTO.setApellidos(usuario.getApellidos());
		usuarioDTO.setEmail(usuario.getEmail());
		usuarioDTO.setNickname(usuario.getNickname());
		usuarioDTO.setNombre(usuario.getNombre());
		usuarioDTO.setPw1(usuario.getPw1());
		usuarioDTO.setTienePiso(usuario.isTienePiso());
		
		return usuarioDTO;
		
	}
}
