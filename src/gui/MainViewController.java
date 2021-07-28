package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {
	/*
	 * ********Cria��o de itens de Menu de tela, controller************
	 * 
	 * */
	
	//Menu, onde o nome da variavel � de acordo com o nome do Menu exemplo menuItemNomedoObjeto
	@FXML
	private MenuItem menuItemSeller; //Variavel do Item vendedor
	
	@FXML
	private MenuItem menuItemdepartment; //Variavel do Item departamento
	
	@FXML
	private MenuItem menuItemAbout; //Variavel do item sobre
	
	/*
	 * Declara��o de metodos para tratar a��es do item de menu
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
		System.out.println("onMenuItemAboutAction");
	}
	
	
	@Override 
	public void initialize(URL uri, ResourceBundle rb) {
		
	}

}
