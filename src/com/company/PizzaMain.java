package com.company;

import com.company.businessProcess.Store;
import com.company.domain.Ingredients;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

public class PizzaMain {

    private static final String COMMA_DELIMITER = ",";
    private static List<Ingredients> records = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Scanner path = new Scanner(System.in);  // Create a Scanner object
        String pathName;
        File ingredients = null;
        if (args == null || args.length == 0) {
            System.out.println("You will need to supply an ingredients list");
            System.out.println("Enter path to ingredients csv:");
            pathName = path.nextLine();
            ingredients = new File(pathName);// Read user input
        } else {
            ingredients = new File(args[0]);
        }
        List<Ingredients> list = initIngredients(ingredients);


        JSONObject jsonObject = new JSONObject(list.stream().collect(Collectors.toMap(Ingredients::getIngredient, item -> item.getQuantity())));
        System.out.println(jsonObject.toString());
        // Step2: Now pass JSON File Data to REST Service
        try {
            URL url = new URL("http://localhost:8080/pizza/ingredients");
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write(jsonObject.toString());
            out.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            while (in.readLine() != null) {
            }
            System.out.println("\nREST Service Invoked Successfully..");
            in.close();
        } catch (Exception e) {
            System.out.println("\nError while calling REST Service");
            System.out.println(e);
        }


    //TODO send ingredients list to web service
    // when pizzas get made they will validate the ingredients against the web service

    Store store = new Store();
		store.startStore(1);

//		store.closeStore();
}

    private static List<Ingredients> initIngredients(File file) {

        try (Scanner scanner = new Scanner(new File(file.getPath()));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return records;
    }

    private static Ingredients getRecordFromLine(String line) {
        Ingredients item = new Ingredients();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {

                item.setIngredient(rowScanner.next());
                item.setQuantity(Integer.parseInt(rowScanner.next()));

            }
        }
        return item;
    }
}
