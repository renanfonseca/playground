package br.com.renanfonseca.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.renanfonseca.spring.data.service.CrudCargoService;
import br.com.renanfonseca.spring.data.service.RelatoriosService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Boolean system = true;
	
	private final CrudCargoService cargoService;
	private final RelatoriosService relatoriosService;
	
	public SpringDataApplication(CrudCargoService cargoService, RelatoriosService relatoriosService) {
		this.cargoService = cargoService;
		this.relatoriosService = relatoriosService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		while (system) {

			System.out.println("Qual ação você quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Relatorios");
			
			int action = scanner.nextInt();
			if(action == 1) {
				cargoService.init(scanner);
			} else {
				system = false;
			}
			
			if(action == 2) {
				relatoriosService.init(scanner);
			}else {
				system = false;
			}
			
		}
		
	}

}
