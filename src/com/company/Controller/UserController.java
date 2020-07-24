package com.company.Controller;

import com.company.Dao.TicketDao;
import com.company.Main;
import com.company.Model.Ticket;
import com.company.View.HomePage;
import com.company.View.UserPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserController implements ActionListener {

    UserPage userPage;
    public UserController(){
        userPage = new UserPage();
        initActionListener();
    }
    public void initActionListener(){
        userPage.getEnterButton().addActionListener(this);
        userPage.getExitButton().addActionListener(this);
        userPage.getLogOutButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == userPage.getLogOutButton()){
            Main.currentUser = null ;
            userPage.setVisible(false);
            HomeController homeController = new HomeController();
        } else if(e.getSource() == userPage.getEnterButton()){
            System.out.println(TicketDao.ticketList);
            boolean flag = true;
            for(int i = 0 ; i< Main.currentUser.getMyTicket().size();i++){
                Ticket t = Main.currentUser.getMyTicket().get(i);
                if(t.getCharge()==0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                int number = 10001;
                int size = TicketDao.ticketList.size();
                if(size>0) {
                    number = TicketDao.ticketList.get(size - 1).getNumber() + 1;
                }
                String x = JOptionPane.showInputDialog("Number is "+number+".\nKey in enter time:");
                Ticket t = new Ticket(number,Integer.parseInt(x),0,Main.currentUser);
                TicketDao.ticketList.add(t);
                System.out.println(TicketDao.ticketList);
                Main.currentUser.getMyTicket().add(t);
            }else{
                JOptionPane.showMessageDialog(userPage.getEnterButton(),"You have unpaid ticket!");
            }
        } else if(e.getSource() == userPage.getExitButton()){
            boolean flag = false;
            for(int i = 0 ; i < Main.currentUser.getMyTicket().size(); i++){
                Ticket ticket = Main.currentUser.getMyTicket().get(i);
                if(ticket.getCharge()==0){
                    flag = true ;
                    break;
                }
            }
            if(flag){
                int ticketNum = Integer.parseInt(JOptionPane.showInputDialog("Number:"));
                for(int i = 0 ; i < Main.currentUser.getMyTicket().size() ; i++){
                    Ticket ticket  = Main.currentUser.getMyTicket().get(i);
                    if(ticket.getNumber()== ticketNum && ticket.getCharge() == 0){
                        Main.payment = ticket ;
                        break;
                    }
                }
                if(Main.payment != null){
                    int time = Integer.parseInt(JOptionPane.showInputDialog("Time:"));
                    if(time > Main.payment.getEnter()){
                        int charge = time - Main.payment.getEnter();
                        Main.payment.setCharge(charge);
                        userPage.setVisible(false);
                        PaymentController paymentController = new PaymentController();
                        paymentController.paymentPage.getAmountLabel().setText("You need to pay RM"+charge);
                        paymentController.paymentPage.setAmount(charge);
                    }else {
                        JOptionPane.showMessageDialog(userPage.getExitButton(),"Wrong time!");
                    }
                }else {
                    JOptionPane.showMessageDialog(userPage.getExitButton(), "Wrong number!");
                }
            }else{
                JOptionPane.showMessageDialog(userPage.getExitButton(),"You don't have unpaid tickets!");
            }
        }
    }
}
