package context;

import ui.custom.BaseWindow;
import ui.custom.ButtonComponent;
import ui.custom.PanelBox;
import ui.custom.grid.GridTable;
import ui.custom.grid.table.UserTableModel;

//for mi 
import ui.custom.grid.table.ProductTableModel;
import data.models.Product;

import utils.Palette;

import java.awt.Dimension;
import java.util.ArrayList;

import data.models.User;
import i18n.TextCodes;
import i18n.Translations;

public class DashBoard extends BaseWindow {
    private PanelBox leftBox;
    private PanelBox middle;
    private PanelBox rightBox;
    private Translations lang;
    private UserTableModel model;
	private ProductTableModel model1;
    private ArrayList<String> navList;
    public DashBoard(Translations lang, String title) {
        super(title);
        this.lang = lang;
        navList = new ArrayList<>();
        navList.add(this.lang.getI18nText(TextCodes.registerUserNav));
        navList.add(this.lang.getI18nText(TextCodes.registerUserMainNav));
		navList.add(this.lang.getI18nText(TextCodes.registerProductNav));
		navList.add(this.lang.getI18nText(TextCodes.registerProductMainNav));
        
        
        createPanels();
        createGrid();
        createMenu();
    }
    public void setData(ArrayList<User> users) {
        for (User user : users) {
            model.addRow(user);
        }
    }
	public void setData1(ArrayList<Product> products) {
        for (Product product : products) {
            model1.addRow(product);
        }
    }
    public void refresh(User user) {
        model.addRow(user);
        model.fireTableDataChanged();
    }
	public void refresh1(Product product) {
        model1.addRow(product);
        model1.fireTableDataChanged();
    }
    private void createMenu() {
        Integer bottomMargin = 10;
        for (String item : this.navList) {
            ButtonComponent button = new ButtonComponent(item, this.leftBox);
            button.setActionCommand(item);
            button.setSize(new Dimension(200, 40));
            Integer y = button.getHeight() * this.navList.indexOf(item) + bottomMargin;
            button.setPosition(y);
            button.addActionListener((event) -> {
                if (event.getActionCommand().equals(this.lang.getI18nText(TextCodes.registerUserNav))) {
                    this.getListener().onEvent("click-register", event);
					System.out.println("Button clicked!"); 
                    // RegisterForm registerForm = new RegisterForm(this.lang, this.lang.getI18nText(TextCodes.registerUserNav));
                    // registerForm.showWindow();
                }
				
            });
            this.leftBox.add(button);

			ButtonComponent productButton = new ButtonComponent(this.lang.getI18nText(TextCodes.registerProductNav), this.leftBox);
			productButton.setActionCommand(this.lang.getI18nText(TextCodes.registerProductNav));
			productButton.setSize(new Dimension(200, 40));
			Integer yProduct = productButton.getHeight() * this.navList.indexOf(this.lang.getI18nText(TextCodes.registerProductNav)) + bottomMargin;
			productButton.setPosition(yProduct);
			productButton.addActionListener((event) -> {
				if (event.getActionCommand().equals(this.lang.getI18nText(TextCodes.registerProductNav))) {
					this.getListener().onEvent("click-register-product", event);
					System.out.println("Register Product button clicked!"); 
					//RegisterFormProduct registerForm = new RegisterFormProduct(this.lang, this.lang.getI18nText(TextCodes.registerProductNav));
					//registerForm.showWindow();

				}
			});
			this.leftBox.add(productButton);
        }
    }
    private void createGrid() {
        ArrayList<User> users = new ArrayList<User>();
        model = new UserTableModel(users);
        GridTable grid = new GridTable(model);
        this.middle.add(grid.getScrollPane());
		ArrayList<Product> products = new ArrayList<Product>();
        model1 = new ProductTableModel(products);
        GridTable grid1 = new GridTable(model1);
        this.middle.add(grid1.getScrollPane());

    }
    public void createPanels() {
        this.leftBox = new PanelBox();
        leftBox.roundedBorder(20);
        leftBox.setSize(new Dimension(300, 670));
        leftBox.setLocation(10, 10);
        leftBox.setBackground(Palette.secondary);
        leftBox.setLayout(null);
        this.add(leftBox);

        this.middle = new PanelBox();
        middle.roundedBorder(20);
        middle.setSize(new Dimension(600, 670));
        middle.setLocation(320, 10);
        middle.setBackground(Palette.primary);
        middle.setLayout(null);
        this.add(middle);

        this.rightBox = new PanelBox();
        rightBox.roundedBorder(20);
        rightBox.setSize(new Dimension(250, 670));
        rightBox.setLocation(930, 10);
        rightBox.setBackground(Palette.third);
        rightBox.setLayout(null);
        this.add(rightBox);

    }
    
}
