package pe.hazael.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pe.hazael.models.UserDAO;

public class LoginController {
	@FXML TextField txtUsername;
	@FXML TextField txtPassword;
	@FXML Button btnLogin;
	
	@FXML protected void goLogin(ActionEvent event) throws IOException {
		String username = txtUsername.getText().toString(),
				password = txtPassword.getText().toString();
		
		UserDAO dao = new UserDAO();
		try {
			if (dao.login(username, password)) {
				Node source = (Node) event.getSource();
				Stage stage = (Stage) source.getScene().getWindow();
				stage.close();
				Scene scene = new Scene(FXMLLoader.load(getClass().getResource("MainWindow.fxml")));
				stage.setScene(scene);
				stage.setMaximized(true);
				stage.show();
			} else {
				System.out.println("nada");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
