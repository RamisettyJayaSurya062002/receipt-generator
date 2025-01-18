package com.example.ReceiptGenerator.util;

import com.example.ReceiptGenerator.model.Item;
import com.example.ReceiptGenerator.model.Receipt;

import java.math.BigDecimal;

public class PointsCalculator {
    public static int calculatePoints(Receipt receipt) {
        int points = 0;


        points += receipt.getRetailer().replaceAll("[^a-zA-Z0-9]", "").length();


        BigDecimal total = new BigDecimal(receipt.getTotal());
        if (total.stripTrailingZeros().scale() == 0) {
            points += 50;
        }


        if (total.remainder(new BigDecimal("0.25")).compareTo(BigDecimal.ZERO) == 0) {
            points += 25;
        }


        points += (receipt.getItems().size() / 2) * 5;


        for (Item item : receipt.getItems()) {
            String description = item.getShortDescription().trim();
            if (description.length() % 3 == 0) {
                BigDecimal price = new BigDecimal(item.getPrice());
                BigDecimal pointsForItem = price.multiply(new BigDecimal("0.2"))
                        .setScale(0, BigDecimal.ROUND_CEILING);
                points += pointsForItem.intValue();
            }
        }

        return points;
    }
}
