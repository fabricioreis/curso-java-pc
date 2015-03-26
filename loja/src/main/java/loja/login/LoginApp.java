package loja.login;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

public class LoginApp extends Application {

	private static final String LOGIN = "admin";
	private static final String PASSWORD = "admin";

	protected @FXML TextField txtLogin;
	protected @FXML TextField txtPassword;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(LoginApp.class.getResource("LoginApp.fxml"));
			fxmlLoader.setController(this);
			AnchorPane page = fxmlLoader.load();
			Scene scene = new Scene(page);
			primaryStage.setScene(scene);
			primaryStage.setTitle("FXML is Simple");
			primaryStage.show();
		} catch (Exception ex) {
			Logger.getLogger(LoginApp.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}

	@FXML
	public void onClickLogin(ActionEvent event) {
		if (authenticate()) {

		} else {
			JOptionPane.showMessageDialog(null, "Dados incorretos!");
		}
	}

	@FXML
	public void onClickLogout(ActionEvent event) {
		Platform.exit();
	}

	private boolean authenticate() {
		String loginText = txtLogin.getText();
		String passwordText = txtPassword.getText();
		// os campos preenchidos
		boolean fieldsOk = notEmpty(loginText) && notEmpty(passwordText);
		// usuário e senha ok
		boolean authenticated = LOGIN.equals(loginText)
				&& PASSWORD.equals(passwordText);
		return fieldsOk && authenticated;
	}

	private boolean notEmpty(String s) {
		return s != null && !s.isEmpty();
	}
}
