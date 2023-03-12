package store;

import java.util.HashSet;

public class SuperFilter extends Filter {

    public SuperFilter(LaptopShop<Laptop> laptopShop) {
        super(laptopShop);
        super.filterSet = new HashSet<>();
        filterSet.addAll(shop);
    }

    public int filterMultiselect(int key, int minValue) {
        boolean condition = false;
        if (!filterSet.isEmpty()) {
            for (Laptop laptop : shop) {
                if (filterSet.contains(laptop)) {
                    switch (key) {
                        case 2: // price
                            condition = laptop.price < minValue;
                            break;
                        case 3: // displaySize
                            condition = laptop.displaySize < minValue;
                            break;
                        case 5: // ram
                            condition = laptop.ram < minValue;
                            break;
                        case 6: // storageSSD
                            condition = laptop.storageSSD < minValue;
                            break;
                        case 7: // cores
                            condition = laptop.cores < minValue;
                            break;
                    }
                    if (condition) filterSet.remove(laptop);
                }
            }
            System.out.printf("Подходящих товаров: %d\n", filterSet.size());
            System.out.println(this);
        }
        return filterSet.size();
    }
}
