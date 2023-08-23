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

        // TODO : 추후 Stream 으로 작성해보기. "캡슐화"의 목적도 있음
//        final double total =
//                this.items.stream()
//                .mapToDouble(Item::getUnitTotalPrice)
//                .sum();
        return total;
    }

    @Override
    public String toString() {
        return " " + items;
    }
}
