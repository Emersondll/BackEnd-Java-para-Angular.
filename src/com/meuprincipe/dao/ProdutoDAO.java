package com.meuprincipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.meuprincipe.factory.ConnectionFactory;
import com.meuprincipe.model.Produto;

public class ProdutoDAO extends ConnectionFactory {

	private static ProdutoDAO instance;

	public static ProdutoDAO getInstance() {
		if (instance == null) {
			instance = new ProdutoDAO();

		}
		return instance;
	}

	public ArrayList<Produto> listarTodos() {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conexao = criarConexao();

		ArrayList<Produto> produtos = null;
		produtos = new ArrayList<Produto>();

		try {
			pstmt = conexao
					.prepareStatement("SELECT produto_id, produto_nome, produto_quantidade, produto_valor_venda, \r\n"
							+ "       produto_valor_custo, produto_valor_promocao, produto_licenciado, \r\n"
							+ "       produto_marca, produto_codigo, produto_grade, produto_estacao, \r\n"
							+ "       produto_tipo, produto_categoria\r\n" + "  FROM tb_produto order by produto_id;");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setProdutoId(rs.getInt("produto_id"));
				produto.setProdutoNome(rs.getString("produto_nome"));
				produto.setProdutoQuantidade(rs.getInt("produto_quantidade"));
				produto.setProdutoValor(rs.getFloat("produto_valor_venda"));
				produto.setProdutoCusto(rs.getFloat("produto_valor_custo"));
				produto.setProdutoPromocao(rs.getFloat("produto_valor_promocao"));
				produto.setProdutoLicenciado(rs.getString("produto_licenciado"));
				produto.setProdutoMarca(rs.getString("produto_marca"));
				produto.setProdutoCodigo(rs.getString("produto_codigo"));
				produto.setProdutoGrade(rs.getString("produto_grade"));
				produto.setProdutoEstacao(rs.getString("produto_estacao"));
				produto.setProdutoTipo(rs.getString("produto_tipo"));
				produto.setProdutoCategoria(rs.getString("produto_categoria"));
				produtos.add(produto);

			}
		} catch (Exception e) {
			System.out.println("Erro ao retornar todos os dados de produtos");
			e.toString();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return produtos;

	}

	public ArrayList<Produto> listarEspecifico(Produto p) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conexao = criarConexao();

		ArrayList<Produto> produtos = null;
		produtos = new ArrayList<Produto>();

		try {
			String nomeProduto = p.getProdutoNome();
			pstmt = conexao.prepareStatement(
					"SELECT * FROM tb_produto where produto_nome like '%" + nomeProduto + "%' order by produto_id;");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setProdutoId(rs.getInt("produto_id"));
				produto.setProdutoNome(rs.getString("produto_nome"));
				produto.setProdutoQuantidade(rs.getInt("produto_quantidade"));
				produto.setProdutoValor(rs.getFloat("produto_valor_venda"));
				produto.setProdutoValor(rs.getFloat("produto_valor_custo"));
				produto.setProdutoValor(rs.getFloat("produto_valor_promocao"));
				produto.setProdutoLicenciado(rs.getString("produto_licenciado"));
				produto.setProdutoMarca(rs.getString("produto_marca"));
				produto.setProdutoCodigo(rs.getString("produto_codigo"));
				produto.setProdutoGrade(rs.getString("produto_grade"));
				produto.setProdutoGrade(rs.getString("produto_estacao"));
				produto.setProdutoGrade(rs.getString("produto_tipo"));
				produto.setProdutoGrade(rs.getString("produto_categoria"));
				produtos.add(produto);

			}
		} catch (Exception e) {
			System.out.println("Erro ao retornar todos os dados de produtos Especificos");
			e.toString();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return produtos;
	}

	public boolean inserirProduto(Produto p) {

		Connection conexao = null;
		PreparedStatement pstmt = null;
		conexao = criarConexao();

		try {
			pstmt = conexao.prepareStatement("INSERT INTO tb_produto(\r\n"
					+ "            produto_nome, produto_quantidade, produto_valor_venda, \r\n"
					+ "            produto_valor_custo, produto_valor_promocao, produto_licenciado, \r\n"
					+ "            produto_marca, produto_codigo, produto_grade, produto_estacao, \r\n"
					+ "            produto_tipo, produto_categoria)\r\n"
					+ "    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			pstmt.setString(1, p.getProdutoNome());
			pstmt.setInt(2, p.getProdutoQuantidade());
			pstmt.setFloat(3, p.getProdutoValor());
			pstmt.setFloat(4, p.getProdutoCusto());
			pstmt.setFloat(5, p.getProdutoPromocao());
			pstmt.setString(6, p.getProdutoLicenciado());
			pstmt.setString(7, p.getProdutoMarca());
			pstmt.setString(8, p.getProdutoCodigo());
			pstmt.setString(9, p.getProdutoGrade());
			pstmt.setString(10, p.getProdutoEstacao());
			pstmt.setString(11, p.getProdutoTipo());
			pstmt.setString(12, p.getProdutoCategoria());
			pstmt.execute();

			return true;
		} catch (Exception e) {
			System.out.println("Erro ao inserir os dados de produtos");
			e.toString();
		} finally {
			fecharConexao(conexao, pstmt);
		}
		return false;
	}

	public boolean removerProduto(Produto p) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		conexao = criarConexao();

		try {
			pstmt = conexao.prepareStatement(
					"DELETE FROM tb_produto WHERE produto_nome = ? AND produto_id = ? and produto_codigo= ? ");
			pstmt.setString(1, p.getProdutoNome());
			pstmt.setInt(2, p.getProdutoId());
			pstmt.setString(3, p.getProdutoCodigo());
			pstmt.execute();

			return true;
		} catch (Exception e) {
			System.out.println("Erro ao Remover os dados de produtos");
			e.toString();
		} finally {
			fecharConexao(conexao, pstmt);
		}
		return false;
	}

	@SuppressWarnings("resource")
	public boolean atualizarProduto(Produto po) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		conexao = criarConexao();
		System.out.println("Conexao aberta");
		if ((po.getProdutoValor() == 0 && po.getProdutoPromocao() == 0) && po.getProdutoQuantidade()!=0) {
			
			try {
				
				pstmt = conexao.prepareStatement(
						"UPDATE tb_produto SET produto_quantidade=? WHERE produto_id=? ;");
				
				pstmt.setInt(1, po.getProdutoQuantidade());
				pstmt.setInt(2, po.getProdutoId());
				pstmt.execute();

			} catch (Exception e) {
				System.out.println("Erro ao Atualizar Produto - return false");
				e.printStackTrace();
				return false;
			}
			
		}
		if ((po.getProdutoValor() == 0 && po.getProdutoQuantidade() == 0) && po.getProdutoPromocao()!=0) {
			
			try {
				
				pstmt = conexao.prepareStatement(
						"UPDATE tb_produto SET produto_valor_promocao=? WHERE produto_id=? ;");
				
				pstmt.setFloat(1, po.getProdutoPromocao());
				pstmt.setInt(2, po.getProdutoId());
				pstmt.execute();

			} catch (Exception e) {
				System.out.println("Erro ao Atualizar Produto - return false");
				e.printStackTrace();
				return false;
			}
			
		}
		if ((po.getProdutoPromocao() == 0 && po.getProdutoQuantidade() == 0) && po.getProdutoValor()!=0) {
			
			try {
				
				pstmt = conexao.prepareStatement(
						"UPDATE tb_produto SET produto_valor_venda=? WHERE produto_id=? ;");				
				pstmt.setFloat(1, po.getProdutoValor());
				pstmt.setInt(2, po.getProdutoId());
				pstmt.execute();

			} catch (Exception e) {
				System.out.println("Erro ao Atualizar Produto - return false");
				e.printStackTrace();
				return false;
			}
			
		}
		if (po.getProdutoPromocao() != 0 && po.getProdutoQuantidade() != 0 && po.getProdutoValor()!=0) {
		try {
			
			pstmt = conexao.prepareStatement(
					"UPDATE tb_produto SET produto_quantidade=?, produto_valor_venda=?, produto_valor_promocao=? WHERE produto_id=? ;");
			
			pstmt.setInt(1, po.getProdutoQuantidade());
			pstmt.setFloat(2, po.getProdutoValor());
			pstmt.setFloat(3, po.getProdutoPromocao());
			pstmt.setInt(4, po.getProdutoId());
			pstmt.execute();

		} catch (Exception e) {
			System.out.println("Erro ao Atualizar Produto - return false");
			e.printStackTrace();
			return false;
		} finally {
			fecharConexao(conexao, pstmt);
		}
		}
		return true;

	}

}
