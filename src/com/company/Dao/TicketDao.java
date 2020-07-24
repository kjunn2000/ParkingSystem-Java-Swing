package com.company.Dao;

import com.company.Model.Customer;
import com.company.Model.Ticket;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TicketDao {
    public static ArrayList<Ticket> ticketList = new ArrayList<Ticket>();

    public static void getTicketFromDB(){
        Scanner scanner ;
        try {

            scanner = new Scanner(new File("ticket.txt"));
            while(scanner.hasNext()){
                int a = Integer.parseInt(scanner.nextLine());
                int b = Integer.parseInt(scanner.nextLine());
                int c = Integer.parseInt(scanner.nextLine());
                String d = scanner.nextLine();
                scanner.nextLine();
                Customer x = null;
                for(int i=0 ; i<CustomerDao.customerList.size() ; i++){
                    Customer y = CustomerDao.customerList.get(i);
                    if(d.equals(y.getName())){
                        x=y;
                        break;
                    }
                }
                Ticket t = new Ticket(a,b,c,x);
                ticketList.add(t);
                x.getMyTicket().add(t);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Ticket> getTicketList() {
        return ticketList;
    }
}
