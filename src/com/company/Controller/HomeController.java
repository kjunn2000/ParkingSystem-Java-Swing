package com.company.Controller;

import com.company.Dao.CustomerDao;
import com.company.Dao.TicketDao;
import com.company.Main;
import com.company.Model.Customer;
import com.company.Model.Ticket;
import com.company.View.HomePage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static com.company.Main.currentUser;

public class HomeController implements ActionListener {
    HomePage homePage  ;
    public HomeController(){
        homePage = new HomePage();
        initActionListener();
    }
    public void initActionListener(){
        homePage.getLoginButton().addActionListener(this);
        homePage.getRegisterButton().addActionListener(this);
        homePage.getStopButton().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==homePage.getRegisterButton()) {
            String a = JOptionPane.showInputDialog("Name:");
            int b = Integer.parseInt(JOptionPane.showInputDialog("Password:"));
            Customer c = new Customer(a,b);
            CustomerDao.getCustomerList().add(c);
        } else if (homePage.getLoginButton().equals(e.getSource())){
            String a = JOptionPane.showInputDialog("Username:");
            for(int i = 0 ; i< CustomerDao.getCustomerList().size(); i++){
                Customer c = CustomerDao.getCustomerList().get(i);
                if(c.getName().equals(a)){
                    currentUser=c;
                    break;
                }
            }
            if(currentUser != null){
                int b = Integer.parseInt(JOptionPane.showInputDialog("Password:"));
                if(b==currentUser.getPassword()){
                    homePage.setVisible(false);
                    System.out.println(currentUser);
                    UserController userController = new UserController() ;
                }else{
                    JOptionPane.showMessageDialog(homePage.getLoginButton(),"Wrong Password");
                    currentUser = null ;
                }
            }else{
                JOptionPane.showMessageDialog(null,"Username not found.");
            }
        }else if(e.getSource()==homePage.getStopButton()){
            try {
                PrintWriter p = new PrintWriter("customer.txt");
                for(int i = 0; i< CustomerDao.getCustomerList().size() ; i++){
                    Customer c= CustomerDao.getCustomerList().get(i);
                    p.println(c.getName());
                    p.println(c.getPassword());
                    p.println();
                }
                p.close();
                PrintWriter q = new PrintWriter("ticket.txt");
                System.out.println(TicketDao.ticketList);
                for(int i = 0; i< TicketDao.ticketList.size(); i++ ){
                    Ticket t = TicketDao.ticketList.get(i);
                    q.println(t.getNumber());
                    q.println(t.getEnter());
                    q.println(t.getCharge());
                    q.println(t.getOwner().getName());
                    q.println();
                }
                q.close();
                System.exit(0);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
    }
}
