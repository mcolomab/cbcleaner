package pe.hazael.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class MainWindowController {
	@FXML BorderPane mainWindow;
	
	@FXML protected void showAbout(ActionEvent event) throws IOException {
		mainWindow.setCenter(FXMLLoader.load(getClass().getResource("About.fxml")));
	}
	
	@FXML protected void showProducts(ActionEvent event) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource("Products.fxml"));
		//mainWindow.getChildren().remove(mainWindow.getCenter());
		mainWindow.setCenter(pane);
	}
	
	@FXML protected void showCustomers(ActionEvent event) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource("Customers.fxml"));
		//mainWindow.getChildren().remove(mainWindow.getCenter());
		mainWindow.setCenter(pane);
	}
}
