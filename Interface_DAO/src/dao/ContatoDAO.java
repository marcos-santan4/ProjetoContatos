package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContatoDAO {
	
	private Connection connection;
	
	public ContatoDAO() {
		this.connection = Conexao.getConnection(1);//1 = Postgre, 2 = SQL Server, 3 = MySql
	}

	public void adiciona(Contato contato) throws SQLException{
		int codigo = 0;
		//pega o max ID
		String sql = "SELECT MAX(codigo) codigo FROM \"Contatos\"";
		PreparedStatement preparedStatement = this.connection.prepareStatement(sql);				
		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()){
			codigo = rs.getInt("codigo");
		}
		rs.close();
		preparedStatement.close();
		
		//Max ID +1
		codigo = codigo +1;
		contato.imprime();
		
		//INSERT
		String sql1 = "INSERT INTO \"Contatos\" (codigo,nome,email,celular) VALUES(?,?,?,?)";
		PreparedStatement preparedStatement1 = this.connection.prepareStatement(sql1);
		
		//seta os valores
		contato.setCodigo(codigo);
		preparedStatement1.setLong(1,contato.getCodigo());
		preparedStatement1.setString(2,contato.getNome());
		preparedStatement1.setString(3,contato.getEmail());
		preparedStatement1.setString(4,contato.getCelular());

		//executa
		preparedStatement1.execute();
		System.out.println("");
		System.out.println("Contato Inserido com Sucesso");
		contato.imprime();
		preparedStatement1.close();
	}
	
	public void remove(int codigo) throws SQLException{
		//DELETE
		String sql = "DELETE FROM \"Contatos\" WHERE codigo=?";
		PreparedStatement preparedStatement = 
				this.connection.prepareStatement(sql);
		
		//seta os valores
		preparedStatement.setLong(1,codigo);

		//executa
		preparedStatement.execute();
		System.out.println("");
		System.out.println("Contato " + codigo + " deletado com Sucesso");
		preparedStatement.close();
	}
	
	public void altera(Contato contato) throws SQLException{
		//UPDATE
		String sql = "UPDATE \"Contatos\" ";
        sql += " SET nome=?,email=?,celular=? ";
        sql += " WHERE codigo=?";
		PreparedStatement preparedStatement = 
				this.connection.prepareStatement(sql);
		
		//seta os valores
		preparedStatement.setString(1,contato.getNome());
		preparedStatement.setString(2,contato.getEmail());
		preparedStatement.setString(3,contato.getCelular());
		preparedStatement.setLong(4,contato.getCodigo());

		//executa
		preparedStatement.execute();
		System.out.println("");
		System.out.println("Contato alterado com Sucesso");
		System.out.println(contato.imprime());

		preparedStatement.close();
	}
	
	public void listagem() throws SQLException{
		//SELECT
		String sql = "SELECT * FROM Contatos ORDER BY nome";
		PreparedStatement preparedStatement = this.connection.prepareStatement(sql);				
		//preparedStatement.setString(1,"10");
		//preparedStatement.setString(2,"20");
		//preparedStatement.setInt(1,0);
		//preparedStatement.setInt(2,20);
		ResultSet rs = preparedStatement.executeQuery();
		
		System.out.println("");				
		String s = "codigo - nome - email - celular";
		System.out.println(s);
		while(rs.next()){
			s="";
			s += rs.getString("codigo") + " - " + rs.getString("nome") + " - " + rs.getString("email") + " - " + rs.getString("celular");
			System.out.println(s);
		}
		rs.close();
		preparedStatement.close();
	}
}