/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessentity;

import datastorage.OpenBarOrdersDAO;
import java.util.List;

/**
 *
 * @author 23IVP4A2
 */


public class OpenBarOrder {

    public int status;
    private String drinkName;
    private int tableNr;
    private int quantity;
    private int barOrderId;
    private String statusName;

    public OpenBarOrder(int barOrderId, int status, String drinkName, int quantity, int tableNr, String statusName) {
        this.barOrderId = barOrderId;
        this.status = status;
        this.drinkName = drinkName;
        this.tableNr = tableNr;
        this.quantity = quantity;
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return ("Status: " + this.getStatus() + ", "
                + " Drink: " + this.getDrinkName() + ", "
                + " Table Number: " + this.getTableNr() + ", "
                + " Quantity: " + this.getQuantity());
    }

    public int getStatus() {
        return status;
    }

    public int getTableNr() {
        return tableNr;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDrinkName() {
        return drinkName;
    }
    
    public int getBarOrderId() {
        return barOrderId;
    }
    
    public String getStatusName() {
        return statusName;
    }


}
