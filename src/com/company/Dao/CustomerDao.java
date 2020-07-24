package com.company.Dao;

import com.company.Model.Customer;
import com.company.Model.Ticket;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerDao {

    public static ArrayList<Customer> customerList = new ArrayList<Customer>();

    public static void getCustomerFromDB(){
        Scanner scanner ;
        try {
            scanner = new Scanner(new File("customer.txt"));
            while(scanner.hasNext()) {
                String a = scanner.nextLine();
                int b  = Integer.parseInt(scanner.nextLine());
                scanner.nextLine();
                Customer c = new Customer(a,b);
                customerList.add(c);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Customer> getCustomerList() {
        return customerList;
    }
}
