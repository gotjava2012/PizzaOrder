package com.company;

import com.company.businessProcess.Store;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PizzaMain
{

	private static final String COMMA_DELIMITER = ",";
	private static List<List<String>> records = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException
	{
		File ingredients = new File(args[0]);
		initIngredients(ingredients);

		Store store = new Store();
		store.startStore(1);

//		store.closeStore();
	}

	private static List initIngredients(File file) {

		try (Scanner scanner = new Scanner(new File(file.getPath()));) {
			while (scanner.hasNextLine()) {
				records.add(getRecordFromLine(scanner.nextLine()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return records;
	}
	private static List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}
		}
		return values;
	}
}
