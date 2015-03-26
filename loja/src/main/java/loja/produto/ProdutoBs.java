package loja.produto;

import java.sql.PreparedStatement;

import loja.bancodedados.Conexao;

/**
 * Classe que contém as operações de inclusão e leitura 
 * de produto no banco de dados
 * @author fabricio.reis
 *
 */
public class ProdutoBs {
	
	//cria o objeto de coneção com banco de dados
	private Conexao conexao;

	public ProdutoBs() {
		//instância o objeto de conexão do banco de dados
		this.conexao = Conexao.getInstancia();
	}

	/**
	 * Método utilizado para salvar um produto
	 * @param produto
	 * @return
	 */
	public boolean salvar(Produto produto){
		try {
			//criar o query que sera utilizado para salvar o produto no banco de dados
			String query = "INSERT INTO produto( descricao, preco, imagem) VALUES (?, ?, ?)";
			//chama o método save da classe conexão passando a query para para criar o PreparedStatement
			PreparedStatement ps = conexao.save(query);
			//define as propriedades para o preparedStatement
			ps.setString(1, produto.getDescricao());
			ps.setDouble(2, produto.getPreco());
			ps.setString(3, produto.getImagem());
			//executa a query no banco de dados
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
