package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

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
import model.services.DepartmentService;

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
		loadView("/gui/DepartmentList.fxml", (DepartmentListController controller) -> {
			controller.setDepartmentService(new DepartmentService());
			controller.updateTableView();
		});
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml", x -> {});
	}
	
	
	
	@Override 
	public void initialize(URL uri, ResourceBundle rb) {
		
	}
	
	//Função para abrir uma outra tela
	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
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
			
			T controller = loader.getController();
			initializingAction.accept(controller);
			
			
		}catch(IOException e) {
			Alerts.showAlert("IO Excption", "Error loading view", e.getMessage(), AlertType.ERROR);
			
		}
	}
	
	

}
