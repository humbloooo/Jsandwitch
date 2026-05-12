package com.mycompany.jsandwitch;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class Jsandwitch extends JFrame implements ListSelectionListener {
    // UI components
    JList mainList;
    JList breadList;
    
    JLabel headerLabel = new JLabel("Sublime Sandwich Shop");
    JLabel label1 = new JLabel("Select Main Ingredient:");
    JLabel label2 = new JLabel("Select Bread Type:");
    JLabel priceLabel = new JLabel("Total Price: $0.00");
    
    // Data for ingredients
    String[] mainIngredients = {"Chicken", "Beef", "Veggie"};
    double[] mainPrices = {7.00, 8.00, 6.00};
    
    // Data for bread types
    String[] breadTypes = {"Albany", "Banana bread", "Sasko", "Ritebrand", "Blue Ribbon"};
    double[] breadPrices = {1.50, 2.00, 1.40, 0.90, 1.45};
    
    public Jsandwitch() {
        super("Sublime Sandwich Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // Using BorderLayout for a cleaner look
        
        // Header styling
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(headerLabel, BorderLayout.NORTH);
        
        // Selection panel in the center
        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new BoxLayout(selectionPanel, BoxLayout.Y_AXIS));
        selectionPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
        
        mainList = new JList(mainIngredients);
        breadList = new JList(breadTypes);
        mainList.addListSelectionListener(this);
        breadList.addListSelectionListener(this);
        
        selectionPanel.add(label1);
        selectionPanel.add(new JScrollPane(mainList));
        selectionPanel.add(Box.createVerticalStrut(10)); // Space between lists
        selectionPanel.add(label2);
        selectionPanel.add(new JScrollPane(breadList));
        
        add(selectionPanel, BorderLayout.CENTER);
        
        // Price label at the bottom
        priceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        priceLabel.setHorizontalAlignment(JLabel.CENTER);
        priceLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        add(priceLabel, BorderLayout.SOUTH);
        
        setSize(350, 450);
        setLocationRelativeTo(null); // Center on screen
        setVisible(true);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int mIndex = mainList.getSelectedIndex();
        int bIndex = breadList.getSelectedIndex();
        
        double total = 0;
        
        if (mIndex != -1) {
            total = total + mainPrices[mIndex];
        }
        
        if (bIndex != -1) {
            total = total + breadPrices[bIndex];
        }
        
        priceLabel.setText("Total Price: $" + String.format("%.2f", total));
    }
    
    public static void main(String[] args) {
        new Jsandwitch();
    }
}
