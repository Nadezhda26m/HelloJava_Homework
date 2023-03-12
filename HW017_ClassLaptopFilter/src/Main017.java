
/*
1.	Подумать над структурой класса Ноутбук для магазина техники – выделить поля и методы.
Реализовать в java.
2.	Создать множество ноутбуков.
3.	Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации
и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
Введите цифру, соответствующую необходимому критерию:
•	1 – ОЗУ
•	2 – Объем ЖД
•	3 – Операционная система
•	4 – Цвет …
4.	Далее нужно запросить минимальные значения для указанных критериев – сохранить параметры
фильтрации можно также в Map.
5.	Отфильтровать ноутбуки из первоначального множества и вывести подходящие по условиям.   */

import store.Filter;
import store.LaptopShop;
import store.Laptop;
import store.SuperFilter;

import java.util.Map;

public class Main017 {
    public static void main(String[] args) {
        LaptopShop<Laptop> notebooks = new LaptopShop<>();
        notebooks.add(new Laptop("HUAWEI", "MateBook D 15", 40000, "Windows 11",
                15.6f, 8, 256, 2, 1.56f, false));
        notebooks.add(new Laptop("Acer", "Aspire 5", 55000, "Windows 10 Home",
                15.6f, 8, 512, 6, 1.9f, false));
        notebooks.add(new Laptop("Acer", "Spin 7", 75000, "Windows 10 Home",
                14f, 8, 512, 8, 1.4f, true));
        notebooks.add(new Laptop("Acer", "Spin 7", 75000, "Windows 10 Home",
                14f, 8, 512, 8, 1.4f, true));
        notebooks.add(new Laptop("Lenovo", "IdeaPad 3 15ITL6", 50000, "Windows 11 Home",
                15.6f, 12, 256, 4, 1.65f, true));

        System.out.println("Ассортимент ноутбуков:");
        System.out.println(notebooks);

        Filter filtLapt = new Filter(notebooks);
        System.out.println(filtLapt.showFilter());
        // filtLapt.filterManufacturer("Acer");
        // System.out.println(filtLapt);
        // filtLapt.filterManufacturer("HUAWEI");
        // System.out.println(filtLapt);
        // System.out.println();
        // System.out.println(notebooks);

        // выбор по соответствию
        System.out.println("Выборка по соответствию (искл. цена)");
        int key = FilterValues.chooseKey(filtLapt);
        float value = filtLapt.chooseValue();
        switch (key) {
            // case 1: // Бренд
            //     String manuf = "Acer";
            //     filtLapt.filterManufacturer(manuf);
            //     break;
            case 2: // Цена
                // int priceMin = 50000;
                // int priceMax = 70000;
                // filtLapt.filterPrice(priceMin, priceMax);
                filtLapt.filterPrice(value);
                break;
            case 3: // Диагональ
                // float displaySize = 15.6f;
                filtLapt.filterDisplaySize(value);
                break;
            // case 4: // ОС
            //     String operSystem = "Windows 11";
            //     filtLapt.filterOperSystem(operSystem);
            //     break;
            case 5: // RAM
                // int ram = 8;
                filtLapt.filterRam(value);
                break;
            case 6: // SSD
                // int storageSSD = 256;
                filtLapt.filterStorageSSD(value);
                break;
            case 7: // Кол.ядер
                // int cores = 4;
                filtLapt.filterCores(value);
                break;
            // case 8: // Вес
            //     break;
            // case 9: // Сенс.экран
            //     break;
        }
        System.out.println(filtLapt);

        System.out.println("Множественный выбор");
        SuperFilter superF = new SuperFilter(notebooks);
        Map<Integer, Integer> choose = FilterValues.setMultiselect(superF);

        System.out.println("\nИтог");
        System.out.println(choose);
        System.out.println(superF);
    }
}
