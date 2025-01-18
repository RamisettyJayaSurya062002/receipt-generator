package com.example.ReceiptGenerator.service;

import com.example.ReceiptGenerator.model.Receipt;
import com.example.ReceiptGenerator.util.PointsCalculator;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ReceiptService {

    private final Map<String, Integer> receiptStore = new HashMap<>();

    public String processReceipt(Receipt receipt)
    {
        String id = UUID.randomUUID().toString();
        int points = PointsCalculator.calculatePoints(receipt);
        receiptStore.put(id, points);
        return id;
    }

    public Integer getPoints(String id)
    {
        return receiptStore.get(id);
    }
}
