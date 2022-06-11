package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;

public class Conexao {
	public static Connection getConnection(int x){
		String url = "";
		Connection con= null;
		//Properties props = null;
		
		try{
			switch(x){
			case 1://postgre
                Class.forName("org.postgresql.Driver");
                url = "jdbc:postgresql://ec2-34-236-94-53.compute-1.amazonaws.com:5432/d2ptbarav3192v";
                con = DriverManager.getConnection(url, "eonitservjnjhf", "4ca3b3a814793ab64a5a6cc945fb44b30af1e98a99ab525c6839606ee9f22f2a");
                /*url = "jdbc:postgresql://ec2-34-236-94-53.compute-1.amazonaws.com:5432/d2ptbarav3192v";
                props = new Properties();
                props.setProperty("user","eonitservjnjhf");
                props.setProperty("password","4ca3b3a814793ab64a5a6cc945fb44b30af1e98a99ab525c6839606ee9f22f2a");
                //props.setProperty("ssl","true");
                con = DriverManager.getConnection(url, props);*/
                System.out.println("Driver de Conexão ao Postgre");
                break;
			case 2://sqlserver
				Class.forName("net.sourceforge.jtds.jdbc.Driver");
				url = "jdbc:jtds:sqlserver://localhost:1433/VITAL";
				con = DriverManager.getConnection(url, "VictonCarlos", "medeirossouza");
				System.out.println("Driver de Conexão ao SQL Server");
				break;
			case 3://mysql
				Class.forName("com.mysql.jdbc.Driver");
				//con= DriverManager.getConnection("jdbc:mysql://sql3.freesqldatabase.com:3306/sql349353", "sql349353","iN4*yA3%");
				//con= DriverManager.getConnection("jdbc:mysql://192.168.0.3:3306/dbsisnutri", "root","1234");
				//con= DriverManager.getConnection("jdbc:mysql://192.168.43.177:3306/projetomarcos", "teste","Sql1234@");
				con= DriverManager.getConnection("jdbc:mysql://10.6.255.125:3306/bdteste", "root","root");
				System.out.println("Conectado com sucesso ao banco:");				
			}
		}catch(ClassNotFoundException cnfe){
			System.out.println("Driver não encontrado.");
			System.out.println(cnfe.getMessage());
		}catch(SQLException e){
			System.out.println("Não foi possível obter uma conexão.");
			System.out.println(e.getMessage());
		}
		//retorna o driver e a string de conexão com o banco escolhido
		return con;
	}
}
