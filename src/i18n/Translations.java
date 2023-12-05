package i18n;

import java.util.HashMap;



import config.Environments;

public class Translations {

    public HashMap<String, HashMap<String, String>> language = new HashMap<>(); 
    public Translations() {
        HashMap<String, String> en = new HashMap<>();
        en.put(TextCodes.titleText, "Main windows");
        en.put(TextCodes.userNameTextField, "User name");
        en.put(TextCodes.promptText, "We helped in all");
        en.put(TextCodes.registerText, "Register your personal information");
        en.put(TextCodes.notificationText, "do you want to receive notifications");
        en.put(TextCodes.lastNameTextField, "Last name");
        en.put(TextCodes.adminText, "Admin");
        en.put(TextCodes.clientText, "Client");
        en.put(TextCodes.cashierText, "Cashier");
        en.put(TextCodes.enterText, "Register");
        en.put(TextCodes.emailTextField, "Email");
        en.put(TextCodes.phone, "Phone");

		//For main
        en.put(TextCodes.registerProductText, "Register your Product");
		en.put(TextCodes.productNameTextField, "Name Product");
		en.put(TextCodes.productDescriptionTextField, "Description");
		en.put(TextCodes.productTypeTextField, "type");
		en.put(TextCodes.productPriceTextField, "price");

        en.put(TextCodes.registerUserNav, "Register User");
        en.put(TextCodes.registerUserMainNav, "Main List");

		//for mi 
		en.put(TextCodes.registerProductNav, "Register Product");
        en.put(TextCodes.registerProductMainNav, "List Product");

        


        HashMap<String, String> es = new HashMap<>();
        es.put(TextCodes.titleText, "Ventana principal");
        es.put(TextCodes.userNameTextField, "Nombre de Usuario");
        es.put(TextCodes.promptText, "Te ayudamos en todo");
        es.put(TextCodes.registerText, "Registra tus datos");
        es.put(TextCodes.notificationText, "quieres recibir notificaciones");
        es.put(TextCodes.lastNameTextField, "Apellido");
        
        es.put(TextCodes.adminText, "Administrador");
        es.put(TextCodes.clientText, "Cliente");
        es.put(TextCodes.cashierText, "Cajero");
        es.put(TextCodes.enterText, "Entrar");
        es.put(TextCodes.emailTextField, "Correo electronico");
        es.put(TextCodes.phone, "Telefono");
        es.put(TextCodes.registerUserNav, "REGISTRAR USUARIO");
        es.put(TextCodes.registerUserMainNav, "LISTA PRINCIPAL");
		//for mi
 		es.put(TextCodes.registerUserNav, "REGISTRAR PRODUCTO");
        es.put(TextCodes.registerUserMainNav, "LISTA PRODUCTO");

        es.put(TextCodes.productNameTextField, "Nombre");
        es.put(TextCodes.productDescriptionTextField, "Descripciin");
        es.put(TextCodes.productTypeTextField, "Tipo");

        
        language.put("en", en);
        language.put("es", es);
    }
    public String getI18nText(String key) {
        return language.get(Environments.lag).get(key);
    }
}
