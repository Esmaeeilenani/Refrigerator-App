
public class Cheeseburger extends Food implements Eatable {

    public Cheeseburger(String name, double size) {
        super(name, size);
    }

    @Override
    public boolean doesItContainSugar() {
        return false;
    }

    @Override
    public boolean doesItContainMilk() {
        return true;
    }

    @Override
    public double getCalories() {
        return calculateCalories(303, this);
    }

    public boolean doesItContainEggs() {
        return false;
    }

    public boolean isItSweet() {
        return false;
    }

    @Override
    public String toString() {

        String format = "Cheeseburger{%s, DoesContainSugar: %s, DoesContainMilk: %s, DoesItContainEggs: %s, isItSweet: %s}";
        return String.format(format, super.toString(), doesItContainSugar(), doesItContainMilk(), doesItContainEggs(), isItSweet());
    }

}
