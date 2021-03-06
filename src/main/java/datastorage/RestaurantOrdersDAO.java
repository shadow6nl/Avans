/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.datastorage;

import main.java.businessentity.RestaurantOrder;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;


/**
 *
 * @author 23IVP4A2
 */
public class RestaurantOrdersDAO {

    public RestaurantOrdersDAO() {

    }

    public ArrayList<RestaurantOrder> getAllRestaurantOrders(RestaurantOrder openrestaurantorders) {
        ArrayList<RestaurantOrder> getAllRestaurantOrders = new ArrayList<>();

        if (true) {
            // First open a database connnection
            DatabaseConnection connection = new DatabaseConnection();
            if (connection.openConnection()) {
                // If a connection was successfully setup, execute the SELECT statement.
                ResultSet resultset = connection.executeSQLSelectStatement(
                        "SELECT `restaurantorder`.`id`, `tableNumber`, `orderDate`, `statusId`, `statusName`"
                        + "FROM `restaurantorder`, `status`"
                        + "WHERE `restaurantorder`.`statusId` = `status`.`id` AND `status`.`id` = 5;"
                );

                if (resultset != null) {
                    try {
                        while (resultset.next()) {
                            // The value for the CopyID in the row is ignored
                            // for this POC: no Copy objects are loaded. Having the
                            // Loan objects without the Copy objects will do fine
                            // to determine whether the owning Member can be removed.
                            int restaurantOrderId = resultset.getInt("restaurantorder.id");
                            int statusId = resultset.getInt("statusId");
                            int tableNr = resultset.getInt("tableNumber");
                            String statusName = resultset.getString("statusName");
                            Date orderDate = resultset.getDate("orderDate");
                            Time orderTime = resultset.getTime("orderDate");


                            RestaurantOrder newRestaurantOrder = new RestaurantOrder(restaurantOrderId, tableNr, statusId, statusName, orderDate, orderTime);
                            getAllRestaurantOrders.add(newRestaurantOrder);
                            // print
                            // OpenBarOrder[] array = new OpenBarOrder[] {newOpenBarOrder};
                            //System.out.println(Arrays.toString(array));
                        }
                    } catch (SQLException e) {
                        System.out.println(e);
                        getAllRestaurantOrders.clear();
                    }
                }
                // else an error occurred leave array list empty.

                // We had a database connection opened. Since we're finished,
                // we need to close it.
                connection.closeConnection();

            }

        }
        return getAllRestaurantOrders;
    }

}