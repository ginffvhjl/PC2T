package pc2t.cv11;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {

    public static void main(String[] args) {
        // Objects of GUI
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        // Buttons
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton equals = new JButton("=");
        // Field with answers
        JLabel label = new JLabel(" ");

        // Buttons for numbers
        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            // Add new action for a button
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String labelText = label.getText();
                    label.setText(labelText + button.getText());
                }
            });
            // Add button into panel
            panel.add(button);
        }

        // Input and output field
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(new BasicBorders.ButtonBorder(Color.GRAY, Color.BLACK, Color.GRAY, Color.BLACK));
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(label, BorderLayout.NORTH);
        // Screen size
        frame.setSize(300, 200);
        // Title
        frame.setTitle("Calculator");
        // Button layout
        panel.setLayout(new GridLayout(3, 4));

        // Equals
        equals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ScriptEngineManager manager = new ScriptEngineManager();
                ScriptEngine engine = manager.getEngineByName("graal.js");
                try {
                    label.setText(String.valueOf(engine.eval(label.getText())));
                } catch (ScriptException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        plus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String labelText = label.getText();
                label.setText(labelText + "+");
            }
        });

        minus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String labelText = label.getText();
                label.setText(labelText + "-");
            }
        });

        // Add buttons
        frame.add(equals, BorderLayout.SOUTH);
        panel.add(plus);
        panel.add(minus);

        frame.getContentPane().add(panel);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
