package src.data;

public class Item {
    private final String productName;
    private final String unit;
    private int quantity;
    private double unitPrice;
    private double unitTotalPrice;

    public Item(final String productName, final String unit, final int quantity, final double unitPrice) {
        this.productName = productName;
        this.unit = unit;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.unitTotalPrice = quantity * unitPrice;
    }

    public void updateQuantity(int newQuantity) {
        this.quantity = newQuantity;
        this.unitTotalPrice = quantity * unitPrice;
    }

    public void updateUnitPrice(double newUnitPrice) {
        this.unitPrice = newUnitPrice;
        this.unitTotalPrice = quantity * unitPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getUnitTotalPrice() {
        return unitTotalPrice;
    }

    @Override
    public String toString() {
        return " productName : " + productName +
                ", quantity : " + quantity +
                ", unitPrice : " + unitPrice +
                ", unitTotalPrice : " + unitTotalPrice + unit + "\n";
    }
}
