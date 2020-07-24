package com.company.Controller;

import com.company.Main;
import com.company.View.HomePage;
import com.company.View.PaymentPage;

import javax.naming.InitialContext;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentController implements ActionListener {
    PaymentPage paymentPage;
    public PaymentController(){
        paymentPage = new PaymentPage();
        initActionListener();
    }
    public void initActionListener(){
       paymentPage.getTextField().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int input = Integer.parseInt(paymentPage.getTextField().getText());
        paymentPage.getTextField().setText("");
        if(input<paymentPage.getAmount()){
            paymentPage.setAmount( paymentPage.getAmount() - input) ;
            JOptionPane.showMessageDialog(paymentPage,"You still need to pay RM" +paymentPage.getAmount());
            paymentPage.getAmountLabel().setText("You need to pay RM" +paymentPage.getAmount());
        }else {
            Main.currentUser = null;
            Main.payment = null ;
            JOptionPane.showMessageDialog(paymentPage,"Your change is RM"
                    +(input-paymentPage.getAmount()));
            paymentPage.setVisible(false);
            HomeController homeController = new HomeController();
        }
    }
}
