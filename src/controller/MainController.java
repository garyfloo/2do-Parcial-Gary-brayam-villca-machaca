package controller;
import i18n.Translations;
import context.Login;
import context.RegisterForm;
import context.RegisterFormProduct;
import data.UserManager;
import data.models.User;
import context.DashBoard;
import java.lang.Object;

//for mi
import data.ProductManager;
import data.models.Product;

import config.Environments;
// this is the main controller of all flow of the application
public class MainController {
    UserManager userManager = new UserManager(Environments.pathFile);
    ProductManager productManager = new ProductManager(Environments.pathFile1);
    Translations translations;
    Login login;
    DashBoard dashBoard;
	//DashBoard dashBoard1;
    RegisterForm   registerForm;
	RegisterFormProduct registerFormProdu;
    public MainController() {
        System.out.println("MainController");
        translations = new Translations();
        login = new Login(translations, translations.getI18nText("title-text"));
        dashBoard = new DashBoard(translations, translations.getI18nText("DashBoard"));
		//dashBoard1 = new DashBoard(translations, translations.getI18nText("DashBoard"));
        registerForm = new RegisterForm(translations, translations.getI18nText("title-text"));
		registerFormProdu = new RegisterFormProduct(translations, translations.getI18nText( "title-text"));
        //dashBoard.setData(userManager.getUsers());
		dashBoard.setData1(productManager.getProducts());
		login.addEventListener((String actionEvent, Object data) -> {
			if (actionEvent.equals("click-login")) {
				login.hideWindow();
				dashBoard.showWindow();
			}

		});

		dashBoard.addEventListener((String actionEvent, Object data) -> {
			if (actionEvent.equals("click-register")) {
				registerForm.showWindow(); // Muestra el formulario para registrar usuarios
			} else if (actionEvent.equals("click-register-product")) {
				registerFormProdu.showWindow(); // Muestra el formulario para registrar productos
			}
		});

		registerForm.addEventListener((String actionEvent, Object data) -> {
			User user = (User) data;
			if (actionEvent.equals("click-register")) {
				userManager.saveUser(user);
				dashBoard.refresh(user);
			}
		});
		registerFormProdu.addEventListener((String actionEvent, Object data) -> {
			Product product = (Product) data;
			if (actionEvent.equals("click-register-product")) {
				productManager.saveProduct(product);
				System.out.println("Esta en");
				dashBoard.refresh1(product);
			}
		});
        login.showWindow();
    }
}
