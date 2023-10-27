package OpenAPI_01;

import java.util.Map;



public class Fruit {
    private String name;
    private int id;
    private String family;
    private String order;
    private String genus;
    private Map<String, Float> nutritions;

    public Fruit(String name, int id, String family, String order, String genus, Map<String, Float> nutritions) {
        this.name = name;
        this.id = id;
        this.family = family;
        this.order = order;
        this.genus = genus;
        this.nutritions = nutritions;
    }

    public Fruit() {
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getFamily() {
        return family;
    }

    public String getOrder() {
        return order;
    }

    public String getGenus() {
        return genus;
    }

    public Map<String, Float> getNutritions() {
        return nutritions;
    }
    
    
    

    @Override
    public String toString(){
        return "{Fruit: " +
                "- Name: " + name +
                " - Id: " + id +
                " - Family: " + family +
                " - Order: " + order+
                " - Genus: " + genus+
                " -  Nutritions: " + nutritions + "}";

    }
}
