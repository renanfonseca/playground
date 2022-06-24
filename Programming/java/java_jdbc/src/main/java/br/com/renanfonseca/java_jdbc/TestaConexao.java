package br.com.renanfonseca.java_jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recurarConexao();

		System.out.println("Fechando conexão!");

		connection.close();

	}

}
