package br.com.renanfonseca.java_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection conn = factory.recurarConexao();
		
		PreparedStatement stm = conn.prepareStatement("DELETE FROM PRODUTO WHERE ID > 1");
		stm.execute();
		
		
	}
}
