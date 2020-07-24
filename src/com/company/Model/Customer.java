package com.company.Model;

import java.util.ArrayList;

public class Customer {

    private String name ;
    private int  password ;
    private ArrayList<Ticket> myTicket ;

    public Customer(String name, int password) {
        this.name = name;
        this.password = password;
        myTicket=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public ArrayList<Ticket> getMyTicket() {
        return myTicket;
    }

    public void addTicket(Ticket t) {
        myTicket.add(t);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", password=" + password +
                ", myTicket=" + myTicket +
                '}';
    }
}
