package src.data;

import java.util.ArrayList;
import java.util.List;

public class Order extends OrderLists {
    private final List<Item> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(final Item item) {
        items.add(item);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Item item : items) {
            total += item.getUnitTotalPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return " " + items;
    }
}
