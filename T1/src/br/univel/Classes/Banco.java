package br.univel.Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco {
	
	Connection con;
	Statement st;
	ResultSet rs;
	boolean resultado;
	
	public Banco() {
		
		try {
			createTable();
//			select();
//			insert();
//			delete();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	static Connection getConnection() throws SQLException { //Conecta no banco
		Connection con = DriverManager.
				getConnection("jdbc:postgresql://localhost:5432/tb", "postgres", "123");
		return con;
	}	

	private void createTable() throws SQLException {
		con = Banco.getConnection();
		st = con.createStatement();
		resultado = st.execute("CREATE TABLE teste (id SERIAL PRIMARY KEY, nome VARCHAR(255))");
		System.out.println(resultado);
	}

	private void select() throws SQLException {
		con = Banco.getConnection();
		st = con.createStatement();
		resultado = st.execute("SELECT * FROM aluno");
		System.out.println(resultado);
		rs = st.getResultSet();
		while(rs.next()) { 
			String nome = rs.getString("nome");
			int ra = rs.getInt("ra");
			System.out.println("Nome: " + nome + ", ra: " + ra);
		}
		rs.close();
		st.close();
		con.close();
	}

	private void insert() throws SQLException {
		con = Banco.getConnection();	
		st = con.createStatement();
		resultado = st.execute("INSERT INTO aluno (nome, ra) VALUES ('Solange', 1234)",
				Statement.RETURN_GENERATED_KEYS);
		System.out.println(resultado);
		rs = st.getGeneratedKeys();
		while(rs.next()) {
			String id = rs.getString("id");
			System.out.println("id " + id);
		}
		st.close();
		con.close();
	}

	private void delete() throws SQLException {
		con = Banco.getConnection();
		st = con.createStatement();
		st.execute("DELETE FROM aluno WHERE id > 0");
		int count = st.getUpdateCount();
		System.out.println(count);
		con.close();
	}
	
	public static void main (String [] args) {
		new Banco();
	}
}
