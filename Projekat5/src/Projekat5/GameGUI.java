package Projekat5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GameGUI extends JFrame {
    private JTextField nameField, healthField, xField, yField;
    private JComboBox<String> shapeCombo;
    private JTextArea resultArea;
    private Game game;
    
    public GameGUI() {
        setTitle("Projekat 5 - Igra");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Ime igrača:"));
        nameField = new JTextField("");
        inputPanel.add(nameField);
        
        inputPanel.add(new JLabel("Health (0-100):"));
        healthField = new JTextField("");
        inputPanel.add(healthField);
        
        inputPanel.add(new JLabel("Pozicija X:"));
        xField = new JTextField("");
        inputPanel.add(xField);
        
        inputPanel.add(new JLabel("Pozicija Y:"));
        yField = new JTextField("");
        inputPanel.add(yField);
        
        inputPanel.add(new JLabel("Oblik:"));
        shapeCombo = new JComboBox<>(new String[]{"Pravougaonik", "Krug"});
        inputPanel.add(shapeCombo);
        
        JButton startButton = new JButton("Pokreni igru");
        startButton.addActionListener(new StartListener());
        inputPanel.add(startButton);
        
        add(inputPanel, BorderLayout.NORTH);
        
        
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
        
        pack();
        setLocationRelativeTo(null);
    }
    
    private class StartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String name = nameField.getText();
                int health = Integer.parseInt(healthField.getText());
                int x = Integer.parseInt(xField.getText());
                int y = Integer.parseInt(yField.getText());
                String shape = (String) shapeCombo.getSelectedItem();
                
                Collidable collider;
                if (shape.equals("rectangle")) {
                    collider = new RectangleCollider(x, y, 32, 32);
                } else {
                    collider = new CircleCollider(x, y, 16);
                }
                
                Player player = new Player(name, health, x, y, collider);
                game = new Game(player);
                
                
                ArrayList<Enemy> enemies = Game.loadEnemiesFromCSV("enemies.csv");
                for (Enemy enemy : enemies) {
                    game.addEnemy(enemy);
                }
                
                
                game.resolveCollisions();
                
                
                resultArea.setText(game.getGameStatus());
                
                if (game.isGameOver()) {
                    JOptionPane.showMessageDialog(GameGUI.this, "Igrač je poražen!");
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(GameGUI.this, "Greška: " + ex.getMessage());
            }
        }
    }
}

