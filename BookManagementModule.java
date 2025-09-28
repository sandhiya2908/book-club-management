import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BookManagementModule extends JFrame {
    private JTextField titleField, authorField;
    private JButton addButton, viewButton;
    private ArrayList<String> bookList;

    public BookManagementModule() {
        bookList = new ArrayList<>();

        setTitle("Book Management Module");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Book Title:"));
        titleField = new JTextField();
        add(titleField);

        add(new JLabel("Author:"));
        authorField = new JTextField();
        add(authorField);

        addButton = new JButton("Add Book");
        viewButton = new JButton("View Books");
        add(addButton);
        add(viewButton);

        addButton.addActionListener(e -> {
            String book = titleField.getText() + " by " + authorField.getText();
            if(titleField.getText().isEmpty() || authorField.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Enter Book and Author");
            } else {
                bookList.add(book);
                JOptionPane.showMessageDialog(this, "Book Added!");
                titleField.setText("");
                authorField.setText("");
            }
        });

        viewButton.addActionListener(e -> {
            if(bookList.isEmpty()){
                JOptionPane.showMessageDialog(this, "No Books Added Yet");
            } else {
                StringBuilder books = new StringBuilder();
                for(String b : bookList){
                    books.append(b).append("\n");
                }
                JOptionPane.showMessageDialog(this, books.toString());
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
