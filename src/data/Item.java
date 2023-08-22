package src.data;

public class Item {
    private final String productName;
    private final String unit;
    private final int quantity;
    private final double unitPrice;
    private final double unitTotalPrice;

    public Item(final String productName, final String unit, final int quantity, final double unitPrice) {
        this.productName = productName;
        this.unit = unit;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.unitTotalPrice = quantity * unitPrice;
    }

    public double getUnitTotalPrice() {
        return unitTotalPrice;
    }

    @Override
    public String toString() {
        return "\nproductName : " + productName +
                ", quantity : " + quantity +
                ", unitPrice : " + unitPrice +
                ", unitTotalPrice : " + unitTotalPrice + unit + "\n";
    }
}
