
public abstract class Food implements CaloriesCalculable, Comparable<Food> {

    private String name;
    private double size;

    public Food(String name, double size) {

        this.name = name;
        this.size = size;
    }

    public String getName() {

        return this.name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public double getSize() {

        return this.size;
    }

    public void setSize(double size) {

        this.size = size;
    }

    @Override
    public int compareTo(Food t) {

        if (this.name.charAt(0) > t.name.charAt(0)) {
            return 1;
        } else if (this.name.charAt(0) < t.name.charAt(0)) {
            return -1;
        }
        return 0;
    }

    public static <E extends Food> double calculateCalories(double caloriesPer100Grams, E food) {
        return caloriesPer100Grams * (food.getSize() / 100);
    }

    public abstract boolean doesItContainSugar();

    public abstract boolean doesItContainMilk();

    @Override
    public String toString() {

        return "name=" + name + ", size=" + size + " grams, Calories: " + getCalories() + " kcal";
    }

}
