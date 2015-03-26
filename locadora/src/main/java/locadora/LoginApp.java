package locadora;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginApp extends Application {

	private static final String KEY_USER = "curso";
	private static final String KEY_PASS = "curso";

	@Override
	public void start(Stage stage) throws Exception {
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(400, 300);
		pane.setStyle("-fx-background-color: linear-gradient(to right bottom, #F0F0F0 29%, #3180F7 100%);");

		TextField txLogin = new TextField();
		txLogin.setPromptText("Digite aqui seu login");

		PasswordField txSenha = new PasswordField();
		txSenha.setPromptText("Digite aqui sua senha");

		Button btEntrar = new Button("Entrar");
		btEntrar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				validateAccess(txLogin.getText(), txSenha.getText());
			}
		});

		Button btSair = new Button("Sair");
		btSair.setOnAction(new QuandoAlguemClicar());

		pane.getChildren().addAll(txLogin, txSenha, btEntrar, btSair);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();

		txLogin.setLayoutX((pane.getWidth() - txLogin.getWidth()) / 2);
		txLogin.setLayoutY(50);
		txSenha.setLayoutX((pane.getWidth() - txSenha.getWidth()) / 2);
		txSenha.setLayoutY(100);
		btEntrar.setLayoutX((pane.getWidth() - btEntrar.getWidth()) / 2);
		btEntrar.setLayoutY(150);
		btSair.setLayoutX((pane.getWidth() - btSair.getWidth()) / 2);
		btSair.setLayoutY(200);
	}

	protected void validateAccess(String user, String pass) {
		if (user == null || pass == null) {

		} else if (KEY_USER.equals(user) && KEY_PASS.equals(pass)) {

		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	class QuandoAlguemClicar implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
		}

	}
}
