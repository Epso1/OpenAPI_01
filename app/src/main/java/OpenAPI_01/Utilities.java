package OpenAPI_01;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utilities {

    public static List<Fruit> getListFromJsonURL(String url) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(new URL(url ), new TypeReference<>() {
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createJsonFromList(List<Fruit> fruits, Path ruta) {
        try {
            Files.deleteIfExists(ruta);
            ObjectMapper jsonMapper = new ObjectMapper();
            jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
            jsonMapper.writeValue(ruta.toFile(), fruits);
            System.out.println("Json file created successfully.\n");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Json file could not be created.\n");
        }
    }

    public static List<Fruit> getListSearchFruitByName(String fruitName, List<Fruit> fruits){
            String fruitNameCaps = fruitName.toUpperCase();
            return fruits.stream().filter(f -> f.getName().toUpperCase().contains(fruitNameCaps)).toList();
    }

    public static Map<String, List<Fruit>> getMapGroupedByFamily(List<Fruit> fruits){
        return fruits.stream().collect(Collectors.groupingBy(Fruit::getFamily));
    }
    
    public static List<Fruit> getListByAlphaOrder(List<Fruit> fruits){
        return fruits.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).toList();
    }
    
    public static Map<String, Map<String, Float>> showFruitNutritions(String fruitName, List<Fruit> fruits){
        List<Fruit> list = getListSearchFruitByName(fruitName, fruits);
        
        return list.stream().collect(Collectors.toMap(Fruit::getName, Fruit::getNutritions));
    }
    
}
