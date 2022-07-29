package br.com.renanfonseca.spring.data.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.renanfonseca.spring.data.orm.CargoProjecao;
import br.com.renanfonseca.spring.data.repository.CargoRepository;

@Service
public class RelatoriosService {
	
	private CargoRepository cargoRepository;
	
	
	public RelatoriosService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	public void init(Scanner scanner) {
		boolean system = true;
		while (system ) {
			System.out.println("Qual ação de relatorio deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo Descrição");

			int action = scanner.nextInt();
			switch (action) {
			case 1:
				cargoDescricao();
				break;
			default:
				system = false;
				break;
			}
		}
	}
	
	private void cargoDescricao() {
		List<CargoProjecao> lista = cargoRepository.findCargoDescricao();
		lista.forEach(c -> System.out.println("Cargo: " + c.getDescricao()));
	}

}
