
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * ESMAEEIL ENANI
 */
public class Main {

    static String Command = "";
    static String[] Line;
    static Refrigerator ref;
    static Food food;

    public static void main(String[] args) throws FileNotFoundException {
        run();
    }

    public static void run() throws FileNotFoundException {
//----------------------Read From File------------------------------------        
        File input = new File("input.txt");
        if (!input.exists()) {
            System.out.println("File Not Exists");
            System.exit(0);
        }
        Scanner in = new Scanner(input);
//-------------------------------------------------------------------------
        System.out.println("################################################\n"
                + "############ Refrigerator App v.1 ##############\n"
                + "################################################\n");
//-------------------------------------------------------------------------        
        while (in.hasNext()) {
            Command = in.nextLine();
            Line = Command.split(":|,");

            if (Command.contains("create_refrigerator")) {
                create_refrigerator();

            } else if (Command.contains("add")) {
                add();
            } else if (Command.contains("plug_refrigerator")) {
                plug_refrigerator();

            } else if (Command.contains("count_items_refrigerator")) {
                count_items_refrigerator();

            } else if (Command.contains("display_refrigerator")) {
                display_refrigerator();

            } else if (Command.contains("sort_refrigerators")) {

                for (int i = 0; i < Refrigerator.getAllRefrigerators().size(); i++) {
                    Refrigerator.getAllRefrigerators().get(i).sort();
                }
            }
        }

    }

    public static void create_refrigerator() {
        System.out.println("- Command: " + Line[0]);
        System.out.println("- Arguments- ID: " + Line[1] + ", Capacity: " + Line[2] + ", Volt: " + Line[3] + " ");
        System.out.println(new Refrigerator(Integer.parseInt(Line[1]), Integer.parseInt(Line[2]), Integer.parseInt(Line[3])).toString() + "\n");;
    }

    public static void add() {
        System.out.println("- Command: " + Line[0]);
        int id = Integer.parseInt(Line[2]);
        ref = Refrigerator.find(id);

        System.out.println("- Arguments- Type: " + Line[1] + ", Refrigerator: #" + id + ", Name: " + Line[3] + ", Size: " + Line[4] + " ");
        if (ref != null) {
            try {
                switch (Line[1]) {
                    case "MilkChocolate":
                        food = new MilkChocolate(Line[3], Double.parseDouble(Line[4]));
                        break;
                    case "DietCoke":
                        food = new DietCoke(Line[3], Double.parseDouble(Line[4]));
                        break;
                    case "Cheeseburger":
                        food = new Cheeseburger(Line[3], Double.parseDouble(Line[4]));
                        break;
                    case "CheeseCake":
                        food = new CheeseCake(Line[3], Double.parseDouble(Line[4]));
                        break;
                    case "IceCream":
                        food = new IceCream(Line[3], Double.parseDouble(Line[4]));
                        break;
                    default:
                        System.out.println("The type (" + Line[0] + ") doesn't exist.\n");
                        return;

                }
                ref.addItem(food);
                System.out.println(food.toString() + "\n");
            } catch (RefrigeratorCapacityException | NumberFormatException e) {
                System.out.println(e + "\n");
            }

        } else {
            System.out.println("The refrigerator ID (" + id + ") dosn't exist. \n");
        }

    }

    public static void plug_refrigerator() {
        System.out.println("- Command: " + Line[0]);
        System.out.println("- Arguments- Refrigerator: #" + Line[1] + ", Volt: " + Line[2] + " ");
        int id = Integer.parseInt(Line[1]);
        ref = Refrigerator.find(id);
        if (ref != null) {

            try {
                ref.plug(Integer.parseInt(Line[2]));
                System.out.println("Done. Everything is good.\n");
            } catch (ElectricalOutletException | NumberFormatException e) {
                System.out.println(e + "\n");
            }

        } else {
            System.out.println("The refrigerator ID (" + id + ") dosn't exist. \n");
        }
    }

    public static void count_items_refrigerator() {
        System.out.println("- Command: " + Line[0]);
        System.out.println("- Arguments- Refrigerator: #" + Line[1] + " ");
        int id = Integer.parseInt(Line[1]);
        ref = Refrigerator.find(id);
        int[] count = new int[2];
        if (ref != null) {

            for (int i = 0; i < ref.getItems().size(); i++) {

                food = (Food) ref.getItems().get(i);

                if (food instanceof Drinkable) {
                    count[0]++;
                } else {
                    count[1]++;
                }
            }

            System.out.println("+ Drinkable Items: " + count[0] + "\n"
                    + "+ Eatable Items: " + count[1] + "\n"
                    + "= Total Items: " + ref.getItems().size() + "\n");

        } else {
            System.out.println("The refrigerator ID (" + id + ") dosn't exist. \n");
        }

    }

    public static void display_refrigerator() {
        System.out.println("- Command: " + Line[0]);
        System.out.println("- Arguments- Refrigerator: #" + Line[1] + " ");
        int id = Integer.parseInt(Line[1]);
        ref = Refrigerator.find(id);
        String type = "";
        if (ref != null) {
            System.out.println("---------------------------------------------------------------------------\n"
                    + "Type                	Name                	Size      	Calories  \n"
                    + "---------------------------------------------------------------------------");

            for (int i = 0; i < ref.getItems().size(); i++) {
                food = (Food) ref.getItems().get(i);

                if (food instanceof Eatable && food instanceof Drinkable) {
                    type = "Drinkable,Eatable";

                } else if (food instanceof Eatable) {
                    type = "Eatable";

                } else {
                    type = "Drinkable";

                }
                System.out.printf("%-20s %-25s %-18.2f %-12.2f\n\n", type, food.getName(), food.getSize(), food.getCalories());
            }
        } else {
            System.out.println("The refrigerator ID (" + id + ") dosn't exist. \n");

        }
        System.out.println("");
    }

}
