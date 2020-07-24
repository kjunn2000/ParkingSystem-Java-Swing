package com.company.View;

import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentPage extends JFrame{

    private Label amountLabel;
    private TextField textField ;
    private int amount ;
    public PaymentPage(){
        setSize(300,100);
        setLocation(900,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        amountLabel = new Label("You need to pay RM???");
        Font f = new Font(Font.SANS_SERIF,Font.BOLD,16);
        amountLabel.setFont(f);
        add(amountLabel);
        textField = new TextField(20);
        add(textField);
        setVisible(true );
    }

    public Label getAmountLabel() {
        return amountLabel;
    }

    public void setAmountLabel(Label amountLabel) {
        this.amountLabel = amountLabel;
    }

    public TextField getTextField() {
        return textField;
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
