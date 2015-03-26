package loja.bancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

	private Connection c;
	private String driverjdbc;

	private static Conexao CONEXAO;

	public static Conexao getInstancia() {
		if (CONEXAO == null) {
			return new Conexao("localhost", "5432", "loja", "postgres", "postgres");
		}
		return CONEXAO;
	}

	private Conexao(String endereco, String porta, String nomeBanco, String usuario, String senha) {
		setDriverjdbc("org.postgresql.Driver");
		conect("jdbc:postgresql://" + endereco + ":" + porta + "/" + nomeBanco, usuario, senha);
	}

	private void conect(String url, String usuario, String senha) {
		try {
			Class.forName(getDriverjdbc());
			c = DriverManager.getConnection(url, usuario, senha);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void disconect() {
		try {
			getC().close();
		} catch (SQLException ex) {
			System.err.println(ex);
			ex.printStackTrace();
		}
	}

	public ResultSet query(String query) {
		try {
			return getC().createStatement().executeQuery(query);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public PreparedStatement save(String upInsert) {
		try {
			return getC().prepareStatement(upInsert);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Connection getC() {
		return c;
	}

	public String getDriverjdbc() {
		return driverjdbc;
	}

	public void setDriverjdbc(String driverjdbc) {
		this.driverjdbc = driverjdbc;
	}
}