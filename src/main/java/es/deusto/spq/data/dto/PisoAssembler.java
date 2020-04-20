package es.deusto.spq.data.dto;

import es.deusto.spq.data.Piso;

public class PisoAssembler {

	public PisoDTO assemble (Piso piso) {
		
		if(piso == null) return null;
		
		PisoDTO pisoDTO = new PisoDTO();
		
		pisoDTO.setCoste(piso.getCoste());
		pisoDTO.setDesc(piso.getDesc());
		pisoDTO.setLocalizacion(piso.getLocalizacion());
		pisoDTO.setnHab(piso.getnHab());
		pisoDTO.setNombre(piso.getNombre());
		pisoDTO.setNumeroInquilinos(piso.getNumeroInquilinos());
		pisoDTO.setValoracion(piso.getValoracion());
		
		return pisoDTO;
		
	}
	
}
