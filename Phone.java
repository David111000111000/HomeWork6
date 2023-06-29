import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Phone implements Comparable<Phone> {
    private String model;
    private double price;
    private String proizvoditel;

    public Phone(String proizvoditel, String model, double price) {
        this.proizvoditel = proizvoditel;
        this.model = model;
        this.price = price;
    }

    public String getProizvoditel() {
        return proizvoditel;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Phone otherPhone) {
        return Double.compare(this.price, otherPhone.price);
    }
}
class Main {
    public static void main(String[] args) {
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone("Поко", "ПОКО ЭКТСРИМ ПРО УБИЙЦА ДЕМОНОВ", 228.28));
        phones.add(new Phone("Samsung", "Galaxy S21", 899.99));
        phones.add(new Phone("Google", "Pixel 5", 699.99));
        phones.add(new Phone("OnePlus", "8 Pro", 799.99));
        phones.add(new Phone("Apple", "iPhone SE", 399.99));
        phones.add(new Phone("Apple", "iPhone XXL", 399.99));
        String proizvoditelFilter = "Apple";
        List<String> modelsByManufacturer = phones.stream()
                .filter(phone -> phone.getProizvoditel().equals(proizvoditelFilter))
                .map(Phone::getModel)
                .collect(Collectors.toList());

        System.out.println("Модели телефонов производителя " + proizvoditelFilter + ":");
        for (String model : modelsByManufacturer) {
            System.out.println(model);
        }

        System.out.println();
        System.out.println("Сортировка моделей телефонов по стоимости:");
        phones.stream()
                .sorted(Comparator.comparingDouble(Phone::getPrice))
                .forEach(phone -> System.out.println(phone.getModel() + " - " + phone.getPrice()));
    }
}