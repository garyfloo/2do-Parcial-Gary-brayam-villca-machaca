package data.models;

public class Product {
	private String product_name;
	private String product_description;
	private String type_of_product;
	private String price_of_product;
	public Product (String product_name, String product_description, String type_of_product, String price_of_product) {
		this.product_name = product_name;
		this.product_description = product_description;
		this.type_of_product = type_of_product;
		this.price_of_product = price_of_product;
	}
	public String getproduct_name() {
		return product_name;
	}
	public void setname(String product_name) {
		this.product_name = product_name;
	}
	public String getproduct_description() {
		return product_description;
	}
	public void setdescription(String product_description) {
		this.product_description = product_description;
	}
	public String gettype_of_product() {
		return type_of_product;
	}
	public String getprice() {
		return price_of_product;
	}
	public void setprice(String price_of_product) {
		this.price_of_product = price_of_product;
	}
	@Override
	public String toString() {
		return this.product_name + "," + this.product_description + "," + this.type_of_product + "," + this.price_of_product;
	}
}
