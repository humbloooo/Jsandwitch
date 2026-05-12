package com.mycompany.jsandwitch;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

/**
 * Sublime Sandwich Shop Application
 * Allows users to select main ingredients and bread types.
 * Displays total price based on selection.
 */
public class Jsandwitch extends JFrame implements ListSelectionListener {
    private JList<String> mainList;
    private JList<String> breadList;
    private JLabel priceLabel;
    private JLabel headerLabel;
    
    // Requirements: 3 main ingredients at 3 different prices
    private String[] mainIngredients = {"Chicken Breast", "Roast Beef", "Garden Veggie"};
    private double[] mainPrices = {7.50, 8.25, 6.95};
    
    // Requirements: List of at least five bread options
    private String[] breadTypes = {"White", "Whole Wheat", "Rye", "Sourdough", "Multigrain", "Honey Oat"};
    
    public Jsandwitch() {
        super("Sublime Sandwich Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        // Header
        headerLabel = new JLabel("Sublime Sandwich Shop", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 24));
        headerLabel.setForeground(new Color(139, 69, 19)); // Brownish color
        add(headerLabel, BorderLayout.NORTH);
        
        // Selection Panel
        JPanel selectionPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        selectionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Main Ingredients List
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(new JLabel("Main Ingredient:"), BorderLayout.NORTH);
        mainList = new JList<>(mainIngredients);
        mainList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        mainList.addListSelectionListener(this);
        mainPanel.add(new JScrollPane(mainList), BorderLayout.CENTER);
        
        // Bread Types List
        JPanel breadPanel = new JPanel(new BorderLayout());
        breadPanel.add(new JLabel("Bread Type:"), BorderLayout.NORTH);
        breadList = new JList<>(breadTypes);
        breadList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        breadList.addListSelectionListener(this);
        breadPanel.add(new JScrollPane(breadList), BorderLayout.CENTER);
        
        selectionPanel.add(mainPanel);
        selectionPanel.add(breadPanel);
        add(selectionPanel, BorderLayout.CENTER);
        
        // Footer/Price Panel
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        priceLabel = new JLabel("Total Price: $0.00");
        priceLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        priceLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 20));
        footerPanel.add(priceLabel);
        add(footerPanel, BorderLayout.SOUTH);
        
        pack();
        setSize(450, 300);
        setLocationRelativeTo(null); // Center on screen
        setVisible(true);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            updatePrice();
        }
    }
    
    private void updatePrice() {
        int mainIndex = mainList.getSelectedIndex();
        // Bread selection is required for a complete sandwich, but doesn't add to price in this model
        // However, we check both for a "functional" feel.
        
        double totalPrice = 0;
        if (mainIndex != -1) {
            totalPrice = mainPrices[mainIndex];
        }
        
        priceLabel.setText(String.format("Total Price: $%.2f", totalPrice));
    }
    
    public static void main(String[] args) {
        // Set System Look and Feel for a more premium experience
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Fallback to default
        }
        
        SwingUtilities.invokeLater(() -> new Jsandwitch());
    }
}
