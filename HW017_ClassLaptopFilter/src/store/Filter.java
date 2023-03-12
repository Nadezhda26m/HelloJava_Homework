package store;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Scanner;

public class Filter {
    protected Map<Integer, String> filter;
    protected Set<Laptop> shop, filterSet;

    public Filter(LaptopShop<Laptop> laptopShop) {
        this.filter = laptopFilter();
        this.shop = laptopShop.shop;
    }

    public Map<Integer, String> laptopFilter() {
        this.filter = new TreeMap<>();
        // filter.put(1, "Бренд");
        filter.put(2, "Цена");
        filter.put(3, "Диагональ");
        // filter.put(4, "ОС");
        filter.put(5, "RAM");
        filter.put(6, "SSD");
        filter.put(7, "Кол.ядер");
        // filter.put(8, "Вес");
        // filter.put(9, "Сенс.экран");
        return this.filter;
    }


    public String showFilter() {
        StringBuilder sb = new StringBuilder();
        for (var item : filter.entrySet()) {
            sb.append(item.getKey()).append(" - ").append(item.getValue()).append("\n");
        }
        return sb.toString();
    }

    public void filterManufacturer(String manufact) {
        this.filterSet = new HashSet<>();
        for (Laptop item : shop) {
            if (item.manufacturer.equals(manufact)) {
                filterSet.add(item);
            }
        }
    }

    public void filterPrice(float priceMin, float priceMax) {
        this.filterSet = new HashSet<>();
        for (Laptop item : shop) {
            if (item.price >= priceMin && item.price <= priceMax) {
                filterSet.add(item);
            }
        }
    }

    public void filterPrice(float priceMin) {
        this.filterSet = new HashSet<>();
        for (Laptop item : shop) {
            if (item.price >= priceMin) {
                filterSet.add(item);
            }
        }
    }

    public void filterDisplaySize(float displaySize) {
        this.filterSet = new HashSet<>();
        for (Laptop item : shop) {
            if (item.displaySize == displaySize) {
                filterSet.add(item);
            }
        }
    }

    public void filterOperSystem(String operSystem) {
        this.filterSet = new HashSet<>();
        for (Laptop item : shop) {
            if (item.operSystem.contains(operSystem)) {
                filterSet.add(item);
            }
        }
    }

    public void filterRam(float ram) {
        this.filterSet = new HashSet<>();
        for (Laptop item : shop) {
            if (item.ram == ram) {
                filterSet.add(item);
            }
        }
    }

    public void filterStorageSSD(float storageSSD) {
        this.filterSet = new HashSet<>();
        for (Laptop item : shop) {
            if (item.storageSSD == storageSSD) {
                filterSet.add(item);
            }
        }
    }

    public void filterCores(float cores) {
        this.filterSet = new HashSet<>();
        for (Laptop item : shop) {
            if (item.cores == cores) {
                filterSet.add(item);
            }
        }
    }

    @Override
    public String toString() {
        if (filterSet.isEmpty()) return "Подходящий товар отсутствует";
        else {
            StringBuilder res = new StringBuilder();
            for (Laptop item : filterSet) {
                res.append(item).append("\n");
            }
            return res.toString();
        }
    }

    public Map<Integer, String> getFilter() {
        return filter;
    }

    public float chooseValue() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите значение: ");
        float value = scan.nextFloat();
        if (value < 0) {
            System.out.println("Неверные данные");
            return chooseValue();
        }
        return value;
    }
}
