package loja.produto;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

public class CadastroProduto extends Application {

	private @FXML TextField descricao;
	private @FXML TextField preco;
	private @FXML TextField imagem;

	@Override
	public void start(Stage primaryStage) throws Exception {

		// carrega o arquivo fxml
		FXMLLoader fxmlLoader = new FXMLLoader(
				CadastroProduto.class.getResource("CadastroProduto.fxml"));
		// define a classe atual como controller do arquivo fxml
		fxmlLoader.setController(this);
		// faz o bind do arquivo fxml a classe java
		AnchorPane page = fxmlLoader.load();

		Scene scene = new Scene(page);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Cadastro de Produto");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void handlerSalvar(ActionEvent event) {

		if (validar()){
			showMessage("Informe os dados obrigatório!");
		}else{
			Produto produto = new Produto();
			produto.setDescricao(descricao.getText());
			produto.setPreco(Double.parseDouble(preco.getText()));
			produto.setImagem(imagem.getText());
	
			ProdutoBs bs = new ProdutoBs();
			if(bs.salvar(produto)){
				showMessage("Produto cadastro com sucesso.");
				limparCampos();
				descricao.setFocusTraversable(true);
			}else{
				showMessage("Ocorreu um erro ao salvar o produto!");
			}
		}
	}

	private void showMessage(String str) {
		JOptionPane.showMessageDialog(null, str);
	}

	private boolean validar() {
		if (descricao.getText().isEmpty())
			return true;
		if (preco.getText().isEmpty())
			return true;
		if (imagem.getText().isEmpty())
			return true;
		return false;
	}

	public void handlerLimpar(ActionEvent event) {
		limparCampos();
	}

	private void limparCampos() {
		descricao.clear();
		preco.clear();
		imagem.clear();
	}

}
