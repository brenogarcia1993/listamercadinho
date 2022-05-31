package listamercadinho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import listamercadinho.Conecta;



public class Produtos {
	
	
	
	public static String id;
	public String descricao;
	public int quantidade;
	public double preco;
	
	public String getId() {
		return id;   
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void CreateProduto (int id, String descricao, int quantidade, double preco) throws Exception {
		
		try {
			Connection con = Conecta.criarConexao();
			String sql = "INSERT INTO \"Produtos\" (id, descricao, quantidade, preco) VALUES (?, ?, ?, ?);";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, descricao);
			ps.setInt(3, quantidade);
			ps.setDouble(4, preco);
			
			

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			//Conecta.closeConnection();
		}
		
}
		
		public void ApagaProduto (int id) throws Exception {
			
			try {
				Connection con = Conecta.criarConexao();
				String sql = "DELETE FROM \"Produtos\" WHERE (id) = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				

				ps.executeUpdate();

			} catch (SQLException e) {

				e.printStackTrace();

			} finally {

				//Conecta.closeConnection();
			}
		}
		
		public void AtualizaProduto (int id, String descricao, int quantidade, double preco) throws Exception {
			
			try {
				Connection con = Conecta.criarConexao();
				String sql = "UPDATE \"Produtos\" SET descricao = ?, quantidade = ?, preco = ? WHERE (id) = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(4, id);
				ps.setString(1, descricao);
				ps.setInt(2, quantidade);
				ps.setDouble(3, preco);
				
				

				ps.executeUpdate();

			} catch (SQLException e) {

				e.printStackTrace();

			} finally {

				//Conecta.closeConnection();
			}
			
			
		}
		
		public ResultSet ListaProdutos(int id) throws SQLException, ClassNotFoundException{
		    Connection con = Conecta.criarConexao();

		    String query = "SELECT * FROM \"Produtos\"";

		    PreparedStatement pst = con.prepareStatement(query);
		    ResultSet rs = pst.executeQuery();

		    
		    
		    return rs;
		}
		
		/*
		 * try { Connection con = Conecta.criarConexao(); String sql =
		 * "INSERT INTO \"Produtos\" (id, descricao, quantidade, preco) VALUES (?, ?, ?, ?);"
		 * ; PreparedStatement ps = con.prepareStatement(sql); ps.setInt(1, id);
		 * ps.setString(2, descricao); ps.setInt(3, quantidade); ps.setDouble(4, preco);
		 * 
		 * 
		 * 
		 * ps.executeUpdate();
		 * 
		 * } catch (SQLException e) {
		 * 
		 * e.printStackTrace();
		 * 
		 * } finally {
		 * 
		 * //Conecta.closeConnection(); }
		 */


		}
