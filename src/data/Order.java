package src.data;

public class Order {
    private final String productName;
    private final String unit;
    private final int quantity;
    private final double unitPrice;
    private final double total;

    public Order(final String productName, final String unit, final int quantity, final double unitPrice) {
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

    @Override
    public String toString() {
        return  "\n품명 : " + productName +
                " 단위 : " + unit +
                " 수량 : " + quantity +
                " 단가 : " + unitPrice +
                " 총 금액 : " + total;
    }
}
