package store;

import java.util.HashSet;
import java.util.Set;

public class LaptopShop<Laptop> {
    protected Set<Laptop> shop;


    public LaptopShop() {
        this.shop = new HashSet<>();
    }

    public void add(Laptop laptop){
        shop.add(laptop);
    }

    // public Set<Laptop> getShop() {
    //     return shop;
    // }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Laptop item : shop) {
            res.append(item).append("\n");
        }
        return res.toString();
    }

    // public void filter()
}
