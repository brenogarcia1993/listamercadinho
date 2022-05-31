package listamercadinho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Clientes {

	private String nome;
	private int id;

	public Clientes() {

	}

	public String getNome() {
		return nome;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		Clientes outro = (Clientes) obj;
		return this.nome.equals(outro.nome);
	}

	@Override
	public int hashCode() {
		return this.nome.hashCode();
	}

	@Override
	public String toString() {
		return "[O cliente: " + this.nome + ", Identificação: " + this.id + "]";
	}

	public void CreateCliente(int id, String nome) throws ClassNotFoundException {

		try {
			Connection con = Conecta.criarConexao();
			String sql = "INSERT INTO \"Clientes\" (id, nome) VALUES (?, ?);";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, nome);

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

		}
	}

	public void ApagaCliente(int id) throws Exception {

		try {
			Connection con = Conecta.criarConexao();
			String sql = "DELETE FROM \"Clientes\" WHERE (id) = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

		}
	}

public void AtualizaCliente (int id, String nome) throws Exception {
	
	try {
		Connection con = Conecta.criarConexao();
		String sql = "UPDATE \"Clientes\" SET nome = ? WHERE (id) = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, nome);
		ps.setInt(2, id);
		
		

		ps.executeUpdate();

	} catch (SQLException e) {

		e.printStackTrace();

	} finally {

		
	}

	public ResultSet ListaClientes(int id) throws SQLException, ClassNotFoundException {
		Connection con = Conecta.criarConexao();

		String query = "SELECT * FROM \"Clientes\"";

		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();

		return rs;
	}
}
