package loja.bancodedados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteCadastraProduto {

	public static void main(String[] args) {

		try {
			cadastrarProduto();
			listarProduto();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static void listarProduto() throws SQLException {

		ResultSet rs = Conexao.getInstancia().query("select * from produto");

		while (rs.next()) {
			System.out.println("--------------------------");
			System.out.println("[");
			System.out.println("Produto");
			System.out.println("id: " + rs.getInt("id"));
			System.out.println("descricao: " + rs.getString("descricao"));
			System.out.println("preco: " + rs.getDouble("preco"));
			System.out.println("]");
			System.out.println("--------------------------");
		}
	}

	private static void cadastrarProduto() throws SQLException {
		Prod p = new Prod("Chuteira", 198);
		PreparedStatement ps = Conexao.getInstancia().save(
				"insert into produto(descricao, preco) values (?, ?)");
		ps.setString(1, p.getNome());
		ps.setDouble(2, p.getPreco());
		ps.execute();
	}

	public static class Prod {

		private int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		private String nome;
		private double preco;

		public Prod(String nome, double preco) {
			this.nome = nome;
			this.preco = preco;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public double getPreco() {
			return preco;
		}

		public void setPreco(double preco) {
			this.preco = preco;
		}

	}
}
