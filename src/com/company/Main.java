package com.company;
import com.company.Controller.HomeController;
import com.company.Dao.CustomerDao;
import com.company.Dao.TicketDao;
import com.company.Model.Customer;
import com.company.Model.Ticket;
import com.company.View.HomePage;
import com.company.View.PaymentPage;
import com.company.View.UserPage;

public class Main {

    public static Ticket payment = null ;
    public static Customer currentUser = null ;
    public static void main(String[] args) {

        CustomerDao.getCustomerFromDB();
        TicketDao.getTicketFromDB();
        HomeController homeController = new HomeController();

    }
}
