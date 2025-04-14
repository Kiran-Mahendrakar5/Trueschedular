package com.codingcult.purchasedetails.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stock_monitor")
public class StockMonitorDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String itemName;
    private String stockSymbol;
    private double price;
    private int quantityAvailable;
    private double alertRange;
    private boolean alertEnabled = false;
    private boolean isActive = true;

    public StockMonitorDto() {}

    public StockMonitorDto(int id, String itemName, String stockSymbol, double price, int quantityAvailable, double alertRange, boolean alertEnabled, boolean isActive) {
        this.id = id;
        this.itemName = itemName;
        this.stockSymbol = stockSymbol;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
        this.alertRange = alertRange;
        this.alertEnabled = alertEnabled;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "StockMonitorDto{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", stockSymbol='" + stockSymbol + '\'' +
                ", price=" + price +
                ", quantityAvailable=" + quantityAvailable +
                ", alertRange=" + alertRange +
                ", alertEnabled=" + alertEnabled +
                ", isActive=" + isActive +
                '}';
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getStockSymbol() { return stockSymbol; }
    public void setStockSymbol(String stockSymbol) { this.stockSymbol = stockSymbol; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantityAvailable() { return quantityAvailable; }
    public void setQuantityAvailable(int quantityAvailable) { this.quantityAvailable = quantityAvailable; }

    public double getAlertRange() { return alertRange; }
    public void setAlertRange(double alertRange) { this.alertRange = alertRange; }

    public boolean isAlertEnabled() { return alertEnabled; }
    public void setAlertEnabled(boolean alertEnabled) { this.alertEnabled = alertEnabled; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean isActive) { this.isActive = isActive; }
}