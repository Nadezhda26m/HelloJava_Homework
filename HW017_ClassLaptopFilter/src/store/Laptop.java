package store;

import java.util.Objects;

public class Laptop {
    protected String manufacturer, model, operSystem;
    protected int ram, storageSSD, cores, price;
    protected float weigth, displaySize;
    protected boolean touchscreen;

    // public Laptop(String manufacturer){
    //     this.manufacturer = manufacturer;
    // }

    public Laptop(String manufacturer, String model, int price, String operSystem, float displaySize, int ram,
                  int storageSSD, int cores, float weigth, boolean touchscreen) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.operSystem = operSystem;
        this.displaySize = displaySize;
        this.ram = ram;
        this.storageSSD = storageSSD;
        this.cores = cores;
        this.weigth = weigth;
        this.touchscreen = touchscreen;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "Бренд:" + manufacturer +
                ", Серия:" + model +
                ", Цена:" + price + " руб." +
                ", Диагональ:" + displaySize + "\"" +
                ", ОС:" + operSystem +
                ", RAM:" + ram + "GB" +
                ", SSD:" + storageSSD + "GB" +
                ", Кол.ядер:" + cores +
                ", Вес:" + weigth + " кг" +
                ", Сенс.экран:" + (touchscreen ? "Да" : "Нет") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return ram == laptop.ram
                && storageSSD == laptop.storageSSD
                && cores == laptop.cores
                && price == laptop.price
                && Float.compare(laptop.weigth, weigth) == 0
                && Float.compare(laptop.displaySize, displaySize) == 0
                && touchscreen == laptop.touchscreen
                && Objects.equals(manufacturer, laptop.manufacturer)
                && Objects.equals(model, laptop.model)
                && Objects.equals(operSystem, laptop.operSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, model, operSystem, ram, storageSSD, cores, price, weigth, displaySize, touchscreen);
    }

}
