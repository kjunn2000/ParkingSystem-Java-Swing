package com.company.Model;

public class Ticket {
    private int number, enter , charge ;
    private Customer owner;

    public Ticket(int number, int enter, int charge, Customer owner) {
        this.number = number;
        this.enter = enter;
        this.charge = charge;
        this.owner = owner;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getEnter() {
        return enter;
    }

    public void setEnter(int enter) {
        this.enter = enter;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "number=" + number +
                ", enter=" + enter +
                ", charge=" + charge +
                ", owner=" + owner.getName() +
                '}';
    }
}
