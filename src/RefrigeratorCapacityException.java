
public class RefrigeratorCapacityException extends Exception {

    private Refrigerator<? extends Food> refrigerator;

    public <E extends Food> RefrigeratorCapacityException(Refrigerator<E> refrigerator) {

        this.refrigerator = refrigerator;
    }

    @Override
    public String getMessage() {
        String format = "The max capacity of the refrigerator is %d items.";
        return String.format(format, refrigerator.getMaxCapacity());

    }

    @Override
    public String toString() {
        return "RefrigeratorCapacityException: " + getMessage();
    }
}
