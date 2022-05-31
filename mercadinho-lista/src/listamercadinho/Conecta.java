package listamercadinho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Conecta {

	static final String URL = "jdbc:postgresql://localhost:5432/mercadinho"; // incica o caminho do banco de dados
	static final String USER = "postgres"; // aqui vai o nome usuario que vc quer acessar
	static final String PASS = "banco123"; // aqui a senha do seu banco

	public static Connection criarConexao() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection conecta = DriverManager.getConnection(URL, USER, PASS);
		if (conecta != null) {
			System.out.print("Conexão efetuada com sucesso...");
			return conecta;
		}
		return null;
		

	}

	
	    
	    
		
}

	
	
