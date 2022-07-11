package db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoDb {
	static Connection con;  // Conexao ao Banco de Dados
	PreparedStatement pst; // Acessa a Tabela ( insert, update, delete , select)
	ResultSet rs; // Consulta a Tabela( select )
	CallableStatement call; // Procedures e Function

	//	public ConexaoDB() {
	//		super();
	// TODO Auto-generated constructor stub
	//	}
	public Connection entrar() throws ClassNotFoundException {
		//Connection con;
		String url="jdbc:mysql://localhost:3306/cruduser"; //caminho do servidor do BD
		String user="root";								  //cadastro";
		String password="Luka.2017";					 //sua senha de acesso
		String driver="com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			if(con!=null) {
				System.out.println("Conexão bem sucedida com o Banco CRUDUSER");
			}else {
				System.err.println("Conexão não realizada, verifique as informações de entrada");
			}
			return con;
		} catch (SQLException e) {
			System.out.println(e);

		}
		return con;
	}
	public static void close() throws Exception{		
		con.close();


	}

}
