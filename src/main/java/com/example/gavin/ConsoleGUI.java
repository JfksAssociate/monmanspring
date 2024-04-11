package com.example.gavin;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Component

public class ConsoleGUI extends JFrame {
    private JTextArea textArea;

    public ConsoleGUI() {
        setTitle("Console Simulation");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setCaretColor(Color.WHITE);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        redirectSystemStreams();

        setVisible(true);
    }

    private void updateTextArea(final String text) {
        SwingUtilities.invokeLater(() -> {
            textArea.append(text);
            textArea.setCaretPosition(textArea.getDocument().getLength());
        });
    }

    private void redirectSystemStreams() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) {
                updateTextArea(String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) {
                updateTextArea(new String(b, off, len, StandardCharsets.UTF_8));
            }

            @Override
            public void write(byte[] b) {
                write(b, 0, b.length);
            }
        };

        System.setOut(new PrintStream(out, true, StandardCharsets.UTF_8));
        System.setErr(new PrintStream(out, true, StandardCharsets.UTF_8));
    }


    public static void main(String[] args) {
        new ConsoleGUI();
    }
}
