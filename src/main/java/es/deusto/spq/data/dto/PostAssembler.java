package es.deusto.spq.data.dto;

import es.deusto.spq.data.Post;

public class PostAssembler {

	public PostDTO assemble(Post post) {
		
		if(post == null) return null;
		
		PostDTO postDTO = new PostDTO();
		
		postDTO.setAutor(post.getAutor());
		postDTO.setContenido(post.getContenido());
		postDTO.setFecha(post.getFecha());		
		postDTO.setLikes(post.getLikes());
		postDTO.setTitulo(post.getTitulo());
		
		return postDTO;
		
	}
}
