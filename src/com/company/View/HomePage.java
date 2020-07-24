package com.company.View;

import com.company.Dao.CustomerDao;
import com.company.Dao.TicketDao;
import com.company.Main;
import com.company.Model.Customer;
import com.company.Model.Ticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static com.company.Main.currentUser;

public class HomePage extends JFrame{
    private Button registerButton, loginButton, stopButton;


    public HomePage() {
        setSize(300,100);
        setLocation(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerButton = new Button("Register");
        loginButton = new Button("Login");
        stopButton = new Button ("Stop");
        setLayout(new FlowLayout());
        add(registerButton);
        add(loginButton);
        add(stopButton);

        setVisible(true);
    }

    public Button getRegisterButton() {
        return registerButton;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public Button getStopButton() {
        return stopButton;
    }
}
