package com.meuprincipe.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * @author limemers Classe de conexao com Banco de Dados Abrir e Fechar Conexoes
 */

public class ConnectionFactory {

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USUARIO = "postgres";
	private static final String SENHA = USUARIO;

	public Connection criarConexao() {
		Connection conexao = null;
		try {
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

		} catch (Exception e) {
			System.out.println("Erro de abrir conexao");
			e.printStackTrace();
		}

		System.out.println("Sucesso conexao");
		return conexao;
	}

	public void fecharConexao(Connection conexao, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (conexao != null) {
				conexao.close();
				System.out.println("Connection Fechada");
			}
			if (pstmt != null) {
				pstmt.close();
				System.out.println("PreparedStatement Fechada");
			}
			if (rs != null) {
				rs.close();
				System.out.println("ResultSet Fechada");
			}

		} catch (Exception e) {
			System.out.println("Erro de fechar conexao");
			e.printStackTrace();
		}

	}

	public void fecharConexao(Connection conexao, PreparedStatement pstmt) {
		try {
			if (conexao != null) {
				conexao.close();
				System.out.println("Connection Fechada");
			}
			if (pstmt != null) {
				pstmt.close();
				System.out.println("PreparedStatement Fechada");
			}

		} catch (Exception e) {
			System.out.println("Erro de fechar conexao");
			e.printStackTrace();
		}

	}
}
