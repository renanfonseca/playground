package br.com.renanfonseca.java_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recurarConexao();
		
		
		String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES ('Mouse', 'Mouse sem fio')";
		
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.execute();
		
		
	}

}
