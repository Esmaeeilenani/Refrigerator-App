
import java.util.ArrayList;
import java.util.Collections;

public class Refrigerator<E extends Food> extends ElectricalMachine {

    private int id;
    private int maxCapacity;
    private ArrayList<E> items;
    private static ArrayList<Refrigerator> allRefrigerators = new ArrayList<>();

    public static ArrayList<Refrigerator> getAllRefrigerators() {

        return allRefrigerators;
    }

    public Refrigerator() {

        allRefrigerators.add(Refrigerator.this);
    }

    public ArrayList<E> getItems() {

        return this.items;
    }

    public Refrigerator(int id, int maxCapacity, int volt) {
        this();
        this.id = id;
        this.maxCapacity = maxCapacity;
        setVoltage(volt);
        items = new ArrayList<>();
    }

    public static Refrigerator<Food> find(int id) {

        for (int i = 0; i < allRefrigerators.size(); i++) {
            if (allRefrigerators.get(i).getId() == id) {
                return allRefrigerators.get(i);
            }
        }

        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void addItem(E item) throws RefrigeratorCapacityException {

        if (this.items.size() != this.maxCapacity) {
            this.items.add(item);

        } else {

            throw new RefrigeratorCapacityException(this);
        }

    }

    public void sort() {

        Collections.sort(items);
    }

    @Override
    public String toString() {
        return "Refrigerator{" + "id=" + id + ", maxCapacity=" + maxCapacity + ", items size=" + items.size() + ", volt=" + getVoltage() + '}';
    }

}
