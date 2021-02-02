package com.company.businessProcess;

import com.company.domain.Ingredients;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.stream.Collectors;

public class IngredientsService {

    public static void initializeRemoteDatabasewithSupplies(List<Ingredients> list) {
        JSONObject jsonObject = new JSONObject(list.stream().collect(Collectors.toMap(Ingredients::getIngredient, item -> item.getQuantity())));
        System.out.println(jsonObject.toString());
        makeServiceCall(jsonObject, "ingredients");
    }

    private static void makeServiceCall(JSONObject jsonObject, String endpoint) {
        // Step2: Now pass JSON File Data to REST Service
        try {
            URL url = new URL("http://localhost:8080/pizza/" + endpoint);
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
    }

}
