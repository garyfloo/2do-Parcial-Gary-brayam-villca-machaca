package ui.custom.grid.table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import data.models.Product;

public class ProductTableModel extends AbstractTableModel{
    private ArrayList<Product> products;
    private String[] columns = {"Name", "Description", "Type", "Price"};
    public ProductTableModel(ArrayList<Product> products) {
        this.products = products;
    }
    public void addRow(Product product) {
        this.products.add(product);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return this.products.size();
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = this.products.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return product.getproduct_name();
            case 1:
                return product.getproduct_description();
            case 2:
                return product.gettype_of_product();
            case 3:
                return product.getprice();
            default:
                return null;
        }
    }
    
}
