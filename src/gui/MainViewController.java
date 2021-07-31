package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {
	/*
	 * ********Criação de itens de Menu de tela, controller************
	 * 
	 * */
	
	//Menu, onde o nome da variavel é de acordo com o nome do Menu exemplo menuItemNomedoObjeto
	@FXML
	private MenuItem menuItemSeller; //Variavel do Item vendedor
	
	@FXML
	private MenuItem menuItemdepartment; //Variavel do Item departamento
	
	@FXML
	private MenuItem menuItemAbout; //Variavel do item sobre
	
	/*
	 * Declaração de metodos para tratar ações do item de menu
	 * 
	 * */
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction");
	}
	
	@FXML
	public void onMenuItemDepartmentAction() {
		System.out.println("onMenuItemDepartmentAction");
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml");
	}
	
	
	@Override 
	public void initialize(URL uri, ResourceBundle rb) {
		
	}
	
	//Função para abrir uma outra tela
	private synchronized void loadView(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			
			//referencia da variavel mainScene para abrir dentro da janela principal
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			//guardando referencia para o Menu 
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			
		}catch(IOException e) {
			Alerts.showAlert("IO Excption", "Error loading view", e.getMessage(), AlertType.ERROR);
			
		}
	}

}
