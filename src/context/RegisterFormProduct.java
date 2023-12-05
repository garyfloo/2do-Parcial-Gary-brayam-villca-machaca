package context;


import java.awt.Dimension;


import data.models.Product;
import i18n.TextCodes;
import i18n.Translations;
import ui.custom.BaseWindow;
import ui.custom.ButtonComponent;
import ui.custom.PanelBox;
import ui.custom.TextFieldComponent;

public class RegisterFormProduct extends BaseWindow{
    private TextFieldComponent product_nameField;
    private TextFieldComponent product_descriptionField;
    private TextFieldComponent type_of_typeField;
    private  TextFieldComponent price_of_priceField;
    private ButtonComponent registerButton;
    private Translations lang;
    private PanelBox panel;
    public RegisterFormProduct(Translations lang, String title) {
        super(title);
        this.lang = lang;
        this.setSize(new Dimension(350, 400));
        
        createForm();
    }
    public void createForm() {
        panel = new PanelBox();
        panel.setSize(new Dimension(350, 400));
        panel.roundedBorder(20);
        panel.setLayout(null);
        
        product_nameField = new TextFieldComponent(lang.getI18nText(TextCodes.productNameTextField), this.panel);
        product_nameField.setPosition(40);
        product_nameField.setSize(new Dimension(260, 40));
        product_nameField.setPlaceHolder(lang.getI18nText(TextCodes.productNameTextField));
        this.panel.add(product_nameField);

        product_descriptionField = new TextFieldComponent(lang.getI18nText(TextCodes.productDescriptionTextField), this.panel);
        product_descriptionField.setPosition(80);
        product_descriptionField.setSize(new Dimension(260, 40));
        product_descriptionField.setPlaceHolder(lang.getI18nText(TextCodes.productDescriptionTextField));
        this.panel.add(product_descriptionField);

        type_of_typeField = new TextFieldComponent(lang.getI18nText(TextCodes.productTypeTextField), this.panel);
        type_of_typeField.setPosition(120);
        type_of_typeField.setSize(new Dimension(260, 40));
		type_of_typeField.setPlaceHolder(lang.getI18nText(TextCodes.productTypeTextField));
        this.panel.add(type_of_typeField);

        price_of_priceField = new TextFieldComponent(lang.getI18nText(TextCodes.productPriceTextField), this.panel);
        price_of_priceField.setPosition(160);
        price_of_priceField.setSize(new Dimension(260, 40));
        price_of_priceField.setPlaceHolder(lang.getI18nText(TextCodes.productPriceTextField));
        this.panel.add(price_of_priceField);

        registerButton = new ButtonComponent(lang.getI18nText(TextCodes.registerProductText), this.panel);
        registerButton.setPosition(200);
        registerButton.setSize(new Dimension(260, 40));
        registerButton.addActionListener((event) -> {
			//System.out.println("Button clicked!");
			//double price = Double.parseDouble(this.priceField.getText());
            Product product = new Product(this.product_nameField.getText(), this.product_descriptionField.getText(), this.type_of_typeField.getText(), this.price_of_priceField.getText());
			System.out.println("Button");
			System.out.println(product);
           this.getListener().onEvent("click-register-product", product); 
		   System.out.println("clicked!");
        });
        this.panel.add(registerButton);
        this.add(this.panel);
    }
}
