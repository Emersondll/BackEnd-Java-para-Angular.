package com.meuprincipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.meuprincipe.factory.ConnectionFactory;
import com.meuprincipe.model.Marca;

public class MarcaDAO extends ConnectionFactory {
	private static MarcaDAO instance;

	public static MarcaDAO getInstance() {
		if (instance == null) {
			instance = new MarcaDAO();

		}
		return instance;
	}

	public ArrayList<Marca> listarTodos() {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conexao = criarConexao();

		ArrayList<Marca> marcas = null;
		marcas = new ArrayList<Marca>();

		try {
			pstmt = conexao.prepareStatement("SELECT marca_id, marca_nome FROM tb_marca;");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Marca marca = new Marca();
				marca.setMarcaID(rs.getInt("marca_id"));
				marca.setMarcaNome(rs.getString("marca_nome"));
				marcas.add(marca);
			}
		} catch (Exception e) {
			System.out.println("Erro ao retornar todos os dados de Marcas");
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}

		return marcas;
	}

	public ArrayList<Marca> listarEspecifico(Marca m) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conexao = criarConexao();
		ArrayList<Marca> marcas = null;
		marcas = new ArrayList<Marca>();

		try {
			pstmt = conexao.prepareStatement("SELECT marca_id, marca_nome FROM tb_marca where marca_nome = ?;");
			pstmt.setString(1, m.getMarcaNome());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Marca marca = new Marca();
				marca.setMarcaID(rs.getInt("marca_id"));
				marca.setMarcaNome(rs.getString("marca_nome"));
				marcas.add(marca);
			}

		} catch (Exception e) {
			System.out.println("Erro ao retornar todos os dados de Marcas");
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return marcas;
	}

	public boolean inserirMarca(Marca m) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		conexao = criarConexao();

		try {

			pstmt = conexao.prepareStatement("INSERT INTO tb_marca(marca_nome) VALUES (?);");
			pstmt.setString(1, m.getMarcaNome());
			pstmt.execute();
			return true;

		} catch (Exception e) {
			System.out.println("Erro ao inserir Marcas");
			e.printStackTrace();
			return false;
		} finally {
			fecharConexao(conexao, pstmt);
		}
	}

	public boolean removerMarca(Marca m) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		conexao = criarConexao();

		try {

			pstmt = conexao.prepareStatement("DELETE FROM tb_marca where marca_nome = ?;");
			pstmt.setString(1, m.getMarcaNome());
			pstmt.execute();
			return true;

		} catch (Exception e) {
			System.out.println("Erro ao Remover Marcas");
			e.printStackTrace();
			return false;
		} finally {
			fecharConexao(conexao, pstmt);
		}
	}

	public boolean atualizarMarca(Marca mo, Marca mn) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		conexao = criarConexao();

		try {

			pstmt = conexao.prepareStatement("UPDATE tb_marca SET marca_nome=? where marca_nome = ?;");
			pstmt.setString(1, mn.getMarcaNome());
			pstmt.setString(2, mo.getMarcaNome());
			pstmt.execute();
			return true;

		} catch (Exception e) {
			System.out.println("Erro ao Remover Marcas");
			e.printStackTrace();
			return false;
		} finally {
			fecharConexao(conexao, pstmt);
		}
	}

}
