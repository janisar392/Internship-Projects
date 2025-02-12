package com.janisar;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type Currency to convert from (e.g., USD): ");
        String convertFrom = scanner.nextLine().trim().toUpperCase();

        System.out.print("Type Currency to convert to (e.g., INR): ");
        String convertTo = scanner.nextLine().trim().toUpperCase();

        System.out.print("Type Quantity to convert: ");
        BigDecimal quantity = scanner.nextBigDecimal();

        // API URL (ExchangeRate-API)
        String urlString = "https://open.er-api.com/v6/latest/" + convertFrom;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(urlString).get().build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            System.out.println("Failed to fetch exchange rate. HTTP error: " + response.code());
            return;
        }

        String stringResponse = response.body().string();
        JSONObject jsonObject = new JSONObject(stringResponse);

        // Check if "rates" and target currency exist
        if (!jsonObject.has("rates") || !jsonObject.getJSONObject("rates").has(convertTo)) {
            System.out.println("Invalid currency conversion request. API might not have data for " + convertFrom + " to " + convertTo);
            return;
        }

        // Extract conversion rate
        BigDecimal rate = jsonObject.getJSONObject("rates").getBigDecimal(convertTo);
        BigDecimal result = rate.multiply(quantity);

        // Print output
        System.out.println(quantity + " " + convertFrom + " = " + result.setScale(2, BigDecimal.ROUND_HALF_UP) + " " + convertTo);
    }
}
