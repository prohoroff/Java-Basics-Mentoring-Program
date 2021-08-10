package by.prohor.app.entity;

/**
 * Created by Artsiom Prokharau 05.08.2021
 */

public class Order {
    private final String name;
    private final String type;
    private final String volume;
    private final String count;

    public Order(String name, String type, String volume, String count) {
        this.name = name;
        this.type = type;
        this.volume = volume;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getVolume() {
        return volume;
    }

    public String getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", choise='" + type + '\'' +
                ", volume=" + volume +
                ", count=" + count +
                '}';
    }
}
