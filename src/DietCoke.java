
public class DietCoke extends Food implements Drinkable {

    public DietCoke(String name, double size) {
        super(name, size);
    }

    @Override
    public boolean doesItContainSugar() {
        return false;
    }

    @Override
    public boolean doesItContainMilk() {
        return false;
    }

    @Override
    public double getCalories() {
        return calculateCalories(1, this);
    }

    @Override
    public boolean doesItContainCarbonatedWater() {
        return true;
    }

    @Override
    public String toString() {

        String format = "DietCoke{%s, DoesContainSugar: %s, DoesContainMilk: %s, DoesContainCarbonatedWater: %s}";
        return String.format(format, super.toString(), doesItContainSugar(), doesItContainMilk(), doesItContainCarbonatedWater());
    }
}
