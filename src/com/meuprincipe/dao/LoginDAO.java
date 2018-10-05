package com.meuprincipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.meuprincipe.factory.ConnectionFactory;
import com.meuprincipe.model.Login;

/**
 * 
 * @author limemers Classe que extends a conexao e reposnsavel para as acoes
 *         especificas da classe Login A classe contem os metodos de CRUD
 */
public class LoginDAO extends ConnectionFactory {
	private static LoginDAO instance;

	public static LoginDAO getInstance() {
		if (instance == null) {
			instance = new LoginDAO();

		}
		return instance;
	}

	public ArrayList<Login> listarTodos() {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conexao = criarConexao();

		ArrayList<Login> logins = null;
		logins = new ArrayList<Login>();

		try {
			pstmt = conexao.prepareStatement("SELECT login_id, login_nome, login_senha FROM tb_login order by login_id,login_nome");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Login login = new Login();
				login.setId(rs.getInt("login_id"));
				login.setNome(rs.getString("login_nome"));
				login.setSenha(rs.getString("login_senha"));
				logins.add(login);

			}
		} catch (Exception e) {
			System.out.println("Erro ao retornar todos os dados de login");
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return logins;

	}

	public ArrayList<Login> listarEspecifico(Login i) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conexao = criarConexao();

		ArrayList<Login> logins = null;
		logins = new ArrayList<Login>();

		try {
			pstmt = conexao.prepareStatement(
					"SELECT login_id, login_nome, login_senha FROM tb_login where login_nome= ? and login_senha = ? order by login_id,login_nome");
			pstmt.setString(1, i.getNome());
			pstmt.setString(2, i.getSenha());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Login login = new Login();
				login.setId(rs.getInt("login_id"));
				login.setNome(rs.getString("login_nome"));
				login.setSenha(rs.getString("login_senha"));
				logins.add(login);

			}
		} catch (Exception e) {
			System.out.println("Dados de login não encontrados");
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return logins;

	}

	public boolean inserirLogin(Login i) throws SQLException {

		Connection conexao = null;
		PreparedStatement pstmt = null;
		conexao = criarConexao();
		System.out.println("Conexao aberta");
		try {

			pstmt = conexao.prepareStatement("INSERT INTO tb_login( login_nome, login_senha) VALUES (?, ?);");

			pstmt.setString(1, i.getNome());
			pstmt.setString(2, i.getSenha());
			pstmt.execute();

		} catch (Exception e) {
			System.out.println("Erro de login ao Inserir - return false");
			e.printStackTrace();
			return false;
		} finally {
			fecharConexao(conexao, pstmt);
		}

		return true;
	}

	public boolean removerLogin(Login i) throws SQLException {

		Connection conexao = null;
		PreparedStatement pstmt = null;
		conexao = criarConexao();
		System.out.println("Conexao aberta");
		try {

			pstmt = conexao.prepareStatement("DELETE FROM tb_login where login_nome= ? and login_senha = ?;");
			pstmt.setString(1, i.getNome());
			pstmt.setString(2, i.getSenha());
			pstmt.execute();

		} catch (Exception e) {
			System.out.println("Erro ao Deletar Login - return false");
			e.printStackTrace();
			return false;
		} finally {
			fecharConexao(conexao, pstmt);
		}

		return true;
	}

	public boolean atualizarLogin(Login io, Login in) throws SQLException {// login original e login novo io/ in

		Connection conexao = null;
		PreparedStatement pstmt = null;
		conexao = criarConexao();
		System.out.println("Conexao aberta");
		try {

			pstmt = conexao.prepareStatement(
					"UPDATE tb_login SET login_nome=?, login_senha=? where login_nome= ? and login_senha = ?;");
			pstmt.setString(1, in.getNome());
			pstmt.setString(2, in.getSenha());
			pstmt.setString(3, io.getNome());
			pstmt.setString(4, io.getSenha());
			pstmt.execute();

		} catch (Exception e) {
			System.out.println("Erro ao Deletar Login - return false");
			e.printStackTrace();
			return false;
		} finally {
			fecharConexao(conexao, pstmt);
		}

		return true;
	}

}
