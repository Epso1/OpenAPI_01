package OpenAPI_01;

import java.nio.file.Path;
import java.util.List;

public class App {

    public static void main(String[] args) {

        System.out.println("Creating List from JSON URL:");
        List<Fruit> fruits = Utilities.getListFromJsonURL("https://www.fruityvice.com/api/fruit/all");
        System.out.println();

        System.out.println("Showing List elements:");
        fruits.forEach(System.out::println);
        System.out.println();

        System.out.println("Creating Json from the List:");
        Utilities.createJsonFromList(fruits, Path.of(".", "fruits2.json"));

        System.out.println("Searching the name 'Mel' in the List:");
        if (Utilities.getListSearchFruitByName("Mel", fruits).size() > 0) {
            System.out.println("Showing results:");
            Utilities.getListSearchFruitByName("Mel", fruits).forEach(System.out::println);
        } else {
            System.out.println("Fruit not found.");
        }
        System.out.println();

        System.out.println("Showing list elements grouped by family:");
        Utilities.getMapGroupedByFamily(fruits).entrySet()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ":\n" + entry.getValue() + "\n");
                });
        System.out.println("");

        System.out.println("Showing fruits by alphabetical order:");
        Utilities.getListByAlphaOrder(fruits).forEach(System.out::println);
        System.out.println("");

        System.out.println("Showing nutritions for search 'Mel':");

        if (Utilities.showFruitNutritions("Mel", fruits).size() > 0) {
            Utilities.showFruitNutritions("Mel", fruits).entrySet().
                    forEach(entry -> {
                        System.out.println(entry.getKey() + "" + entry.getValue());
                    });
        } else {
            System.out.println("Fruit not found.");
        }

    }
}
