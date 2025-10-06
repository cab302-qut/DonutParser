package com.cab302;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String json = """
        [
        	{
        		"id": "0001",
        		"type": "donut",
        		"name": "Cake",
        		"ppu": 0.55,
        		"batters":
        			{
        				"batter":
        					[
        						{ "id": "1001", "type": "Regular" },
        						{ "id": "1002", "type": "Chocolate" },
        						{ "id": "1003", "type": "Blueberry" },
        						{ "id": "1004", "type": "Devil's Food" }
        					]
        			},
        		"topping":
        			[
        				{ "id": "5001", "type": "None" },
        				{ "id": "5002", "type": "Glazed" },
        				{ "id": "5005", "type": "Sugar" },
        				{ "id": "5007", "type": "Powdered Sugar" },
        				{ "id": "5006", "type": "Chocolate with Sprinkles" },
        				{ "id": "5003", "type": "Chocolate" },
        				{ "id": "5004", "type": "Maple" }
        			]
        	},
        	{
        		"id": "0002",
        		"type": "donut",
        		"name": "Raised",
        		"ppu": 0.55,
        		"batters":
        			{
        				"batter":
        					[
        						{ "id": "1001", "type": "Regular" }
        					]
        			},
        		"topping":
        			[
        				{ "id": "5001", "type": "None" },
        				{ "id": "5002", "type": "Glazed" },
        				{ "id": "5005", "type": "Sugar" },
        				{ "id": "5003", "type": "Chocolate" },
        				{ "id": "5004", "type": "Maple" }
        			]
        	},
        	{
        		"id": "0003",
        		"type": "donut",
        		"name": "Old Fashioned",
        		"ppu": 0.55,
        		"batters":
        			{
        				"batter":
        					[
        						{ "id": "1001", "type": "Regular" },
        						{ "id": "1002", "type": "Chocolate" }
        					]
        			},
        		"topping":
        			[
        				{ "id": "5001", "type": "None" },
        				{ "id": "5002", "type": "Glazed" },
        				{ "id": "5003", "type": "Chocolate" },
        				{ "id": "5004", "type": "Maple" }
        			]
        	}
        ]
        """;

        //Create GSON Object
        Gson gson = new Gson();
        Type donutListType = new TypeToken<List<Donut>>() {
        }.getType();
        List<Donut> donuts = gson.fromJson(json, donutListType);

        // Print parsed objects

    }
}