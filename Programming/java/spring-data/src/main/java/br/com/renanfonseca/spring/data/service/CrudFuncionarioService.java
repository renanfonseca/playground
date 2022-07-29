package br.com.renanfonseca.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;


import br.com.renanfonseca.spring.data.repository.FuncionarioRepository;

@Service
public class CrudFuncionarioService {

	@SuppressWarnings("unused")
	private Boolean system = true;
	@SuppressWarnings("unused")
	private final FuncionarioRepository funcionarioRepository;

	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void init(Scanner scanner) {
		
	}
	
	


}
