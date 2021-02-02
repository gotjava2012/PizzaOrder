package com.company;

import com.company.businessProcess.IngredientsService;
import com.company.businessProcess.Store;
import com.company.domain.Ingredients;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.company.businessProcess.IngredientsService.*;


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

        IngredientsService.initializeRemoteDatabasewithSupplies(list);

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
