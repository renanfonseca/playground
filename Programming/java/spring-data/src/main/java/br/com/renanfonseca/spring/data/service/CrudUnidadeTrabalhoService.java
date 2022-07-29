package br.com.renanfonseca.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.renanfonseca.spring.data.repository.UnidadeTrabalhoRepository;

@Service
public class CrudUnidadeTrabalhoService {

	@SuppressWarnings("unused")
	private Boolean system = true;
	@SuppressWarnings("unused")
	private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;

	public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
		this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
	}

	public void init(Scanner scanner) {

	}

}
