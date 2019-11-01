
public class IceCream extends Food implements Eatable, Drinkable {

    public IceCream(String name, double size) {
        super(name, size);
    }

    @Override
    public String toString() {

        String format = "IceCream{%s, DoesContainSugar: %s, DoesContainMilk: %s, DoesItContainEggs: %s, isItSweet: %s, DoesContainCarbonatedWater: %s}";
        return String.format(format, super.toString(), doesItContainSugar(), doesItContainMilk(), doesItContainEggs(), isItSweet(), doesItContainCarbonatedWater());
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
        return Food.calculateCalories(207, this);
    }

    @Override
    public boolean doesItContainEggs() {
        return false;
    }

    @Override
    public boolean isItSweet() {
        return true;
    }

    @Override
    public boolean doesItContainCarbonatedWater() {
        return false;
    }

}
