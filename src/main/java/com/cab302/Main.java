package com.cab302;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Create a Gson instance
        Gson gson = new Gson();

        try (Reader reader = new FileReader("data.json")) {
            // Define the type for the list of Donut objects
            // This is necessary for Gson to correctly deserialize a generic List
            Type donutListType = new TypeToken<List<Donut>>() {}.getType();

            // Read the JSON file and map it to a List of Donut objects
            List<Donut> donuts = gson.fromJson(reader, donutListType);

            System.out.println("Successfully parsed JSON data using Gson!");

            // Iterate through the list of donuts and print some information
            for (Donut donut : donuts) {
                System.out.println("\n--- Donut ---");
                System.out.println("ID: " + donut.getId());
                System.out.println("Name: " + donut.getName());
                System.out.println("Type: " + donut.getType());
                System.out.println("PPU: " + donut.getPpu());

                // Access batters
                if (donut.getBatters() != null && donut.getBatters().getBatter() != null) {
                    System.out.println("  Batters:");
                    for (Batter batter : donut.getBatters().getBatter()) {
                        System.out.println("    - ID: " + batter.getId() + ", Type: " + batter.getType());
                    }
                }

                // Access toppings
                if (donut.getTopping() != null) {
                    System.out.println("  Toppings:");
                    for (Topping topping : donut.getTopping()) {
                        System.out.println("    - ID: " + topping.getId() + ", Type: " + topping.getType());
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading or parsing JSON file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}