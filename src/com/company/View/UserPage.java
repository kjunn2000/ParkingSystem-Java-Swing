package com.company.View;

import com.company.Dao.TicketDao;
import com.company.Main;
import com.company.Model.Ticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPage extends JFrame {
    private Button enterButton, exitButton, logOutButton;

    public UserPage(){
        setSize(300,100);
        setLocation(600,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        enterButton = new Button("Enter");
        exitButton = new Button("Exit");
        logOutButton = new Button("Logout");
        setLayout(new FlowLayout());
        add(enterButton);
        add(exitButton);
        add(logOutButton);
        setVisible(true);
    }

    public Button getEnterButton() {
        return enterButton;
    }

    public Button getExitButton() {
        return exitButton;
    }

    public Button getLogOutButton() {
        return logOutButton;
    }
}
