package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Laba5 extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton button;

    private final JTextArea textArea;

    public Laba5() {
        panel = new JPanel();
        panel.setBounds(100, 100, 100, 100);
        panel.setBackground(Color.gray);

        button = new JButton("Click here to write");
        button.addActionListener(this);
        panel.add(button);

        textArea = new JTextArea();
        textArea.setBackground(Color.white);
        panel.add(textArea);
        add(panel);


        setSize(400, 200);
        setBackground(Color.BLACK);
        setTitle("Laba5");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("file.txt"));
            String line;
            while ((line = in.readLine()) != null) {
                textArea.setText(line);
            }
        } catch (FileNotFoundException ex) {
            textArea.setText("Ошибка чтения файла");
        } catch (SecurityException ex) {
            textArea.setText("Нет разрешения к доступу к файлу");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.setProperty("java.security.policy", "Security.policy");
        System.setSecurityManager(new SecurityManager());
        new Laba5();

    }


}
