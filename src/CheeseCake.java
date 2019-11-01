
public class CheeseCake extends Food implements Eatable {

    public CheeseCake(String name, double size) {
        super(name, size);
    }

    @Override
    public String toString() {

        String format = "CheeseCake{%s, DoesContainSugar: %s, DoesContainMilk: %s, DoesItContainEggs: %s, isItSweet: %s}";
        return String.format(format, super.toString(), doesItContainSugar(), doesItContainMilk(), doesItContainEggs(), isItSweet());
    }

    @Override
    public boolean doesItContainSugar() {
        return false;
    }

    public boolean doesItContainMilk() {
        return true;
    }

    public double getCalories() {
        return Food.calculateCalories(321, this);
    }

    public boolean doesItContainEggs() {
        return false;
    }

    public boolean isItSweet() {
        return false;
    }

}
