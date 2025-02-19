package FinalProject;

public class ProductInformation {

	private String productName;
    private int productNumber;
    private int quantity;
    private float price;

    public ProductInformation(String productName, int productNumber, int quantity, float price) {
        this.productName = productName;
        this.productNumber = productNumber;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }
}