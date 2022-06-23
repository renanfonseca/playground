package br.com.renanfonseca.java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "admin");

		System.out.println("Fechando conexão!");
		
		String sql = "SELECT * FROM PRODUTO";
		
		
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.execute();
		ResultSet rst = ps.getResultSet();
		
		while (rst.next()) {
			Integer id = rst.getInt("ID");
			System.out.println(id);
			String nome = rst.getString("nome");
			System.out.println(nome);
			String desc = rst.getString("descricao");
			System.out.println(desc);
			
		}

		connection.close();
	}
}
