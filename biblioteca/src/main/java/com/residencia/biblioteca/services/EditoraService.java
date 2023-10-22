package com.residencia.biblioteca.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.residencia.biblioteca.dto.EditoraDTO;
import com.residencia.biblioteca.dto.ReceitaWsDTO;
import com.residencia.biblioteca.entities.Editora;
import com.residencia.biblioteca.repositories.EditoraRepository;

import io.jsonwebtoken.io.IOException;

@Service
public class EditoraService {
	@Autowired
	EditoraRepository EditoraRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//Entity to DTO
	private EditoraDTO convertToDTO(Editora editora) {
		return modelMapper.map(editora, EditoraDTO.class);
	}
	
	//DTO to Entity
	private Editora convertToEntity(EditoraDTO editoraDTO) {
		return modelMapper.map(editoraDTO, Editora.class);
	}
	
	public EditoraDTO salvarEditoraDTO(EditoraDTO editoraDTO) {
	    Editora editora = convertToEntity(editoraDTO);
	    return convertToDTO(EditoraRepo.save(editora));
	}
	
	public List<Editora> listarEditoras() {
		return EditoraRepo.findAll();
	}

	public Editora buscarEditoraPorId(Integer id) {
		return EditoraRepo.findById(id).orElse(null);
	}

	public Editora salvarEditora(Editora editora) {
		return EditoraRepo.save(editora);
	}
	
	
	public Editora atualizarEditora(Editora editora) {
		return EditoraRepo.save(editora);
	}

	public Boolean deletarEditora(Editora editora) {
		if (editora == null) {
			return false;
		}
		Editora editoraExistente = buscarEditoraPorId(editora.getCodigoEditora());

		if (editoraExistente == null) {
			return false;
		}

		EditoraRepo.delete(editora);

		Editora editoraContinuaExistindo = buscarEditoraPorId(editora.getCodigoEditora());

		if (editoraContinuaExistindo == null) {
			return true;
		}

		return false;

	}
	
	public ReceitaWsDTO consultaCnpj(String cnpj) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://receitaws.com.br/v1/cnpj/{cnpj}";
		
		Map<String,String> params = new HashMap<String,String>();
		
		params.put("cnpj", cnpj);
		
		ReceitaWsDTO receitaDto = restTemplate.getForObject(uri, ReceitaWsDTO.class, params);
		
		return receitaDto;
	}
	
	public Editora salvarEditoraComFoto(String strEditora, 
										MultipartFile arqImg
			) throws JsonMappingException, JsonProcessingException {
		Editora editora = new Editora();
		
		try {
			ObjectMapper objMp = new ObjectMapper()
					.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
			editora = objMp.readValue(strEditora, Editora.class);
		}catch(IOException e) {
			System.out.println("Erro ao converter a string Editora: " + e.toString());
		}
		
		//editora.setImagemFileName(arqImg.getBytes());
		
		return EditoraRepo.save(editora);
	}
}
