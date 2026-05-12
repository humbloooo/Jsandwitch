package com.mycompany.jsandwitch;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class Jsandwitch extends JFrame implements ListSelectionListener {
    // List boxes for choices
    JList mainList;
    JList breadList;
    
    // Labels to show info
    JLabel label1 = new JLabel("Select Main Ingredient:");
    JLabel label2 = new JLabel("Select Bread Type:");
    JLabel priceLabel = new JLabel("Total Price: $0.00");
    
    // Data for ingredients and prices
    String[] mainIngredients = {"Chicken", "Beef", "Veggie"};
    double[] mainPrices = {7.00, 8.00, 6.00};
    
    // Data for bread and prices (at least 5 options)
    String[] breadTypes = {"White", "Wheat", "Rye", "Sourdough", "Oat"};
    double[] breadPrices = {0.50, 0.75, 1.00, 1.25, 1.10};
    
    public Jsandwitch() {
        super("Sublime Sandwich Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        // Initialize lists
        mainList = new JList(mainIngredients);
        breadList = new JList(breadTypes);
        
        // Add listeners
        mainList.addListSelectionListener(this);
        breadList.addListSelectionListener(this);
        
        // Add components to frame
        add(label1);
        add(new JScrollPane(mainList));
        add(label2);
        add(new JScrollPane(breadList));
        
        // Style and add price label
        priceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(priceLabel);
        
        setSize(250, 350);
        setVisible(true);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        // Get selected indexes
        int mIndex = mainList.getSelectedIndex();
        int bIndex = breadList.getSelectedIndex();
        
        double total = 0;
        
        // Add price of main ingredient if selected
        if (mIndex != -1) {
            total = total + mainPrices[mIndex];
        }
        
        // Add price of bread if selected
        if (bIndex != -1) {
            total = total + breadPrices[bIndex];
        }
        
        // Update the label
        priceLabel.setText("Total Price: $" + String.format("%.2f", total));
    }
    
    public static void main(String[] args) {
        new Jsandwitch();
    }
}
