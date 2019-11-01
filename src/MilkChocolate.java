
public class MilkChocolate extends Food implements Drinkable {

    public MilkChocolate(String name, double size) {
        super(name, size);
    }

    @Override
    public String toString() {

        String format = "MilkChocolate{%s, DoesContainSugar: %s, DoesContainMilk: %s, DoesContainCarbonatedWater: %s}";
        return String.format(format, super.toString(), doesItContainSugar(), doesItContainMilk(), doesItContainCarbonatedWater());
    }

    @Override
    public boolean doesItContainSugar() {
        return true;
    }

    @Override
    public boolean doesItContainMilk() {
        return true;
    }

    @Override
    public double getCalories() {
        return Food.calculateCalories(535, this);
    }

    @Override
    public boolean doesItContainCarbonatedWater() {
        return false;
    }

}
