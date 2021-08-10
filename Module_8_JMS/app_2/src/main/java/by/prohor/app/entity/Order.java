package by.prohor.app.entity;

/**
 * Created by Artsiom Prokharau 09.08.2021
 */

public class Order {

    private String name;
    private String type;
    private String volume;
    private String count;

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
