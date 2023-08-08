package src.data;

public class Order {
    private final String productName;
    private final String unit;
    private final int quantity;
    private final double unitPrice;
    private final double total;

    public Order(String productName, String unit, int quantity, double unitPrice) {
        this.productName = productName;
        this.unit = unit;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.total = quantity * unitPrice;
    }

    public String getProductName() {
        return productName;
    }

    public String getUnit() {
        return unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getTotal() {
        return total;
    }
}
