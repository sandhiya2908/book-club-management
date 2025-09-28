import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MeetingSchedulingModule extends JFrame {
    private JTextField dateField, topicField;
    private JButton scheduleButton, viewButton;
    private ArrayList<String> meetingList;

    public MeetingSchedulingModule() {
        meetingList = new ArrayList<>();

        setTitle("Meeting Scheduling Module");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Meeting Date:"));
        dateField = new JTextField();
        add(dateField);

        add(new JLabel("Topic:"));
        topicField = new JTextField();
        add(topicField);

        scheduleButton = new JButton("Schedule");
        viewButton = new JButton("View Meetings");
        add(scheduleButton);
        add(viewButton);

        scheduleButton.addActionListener(e -> {
            String meeting = dateField.getText() + " - " + topicField.getText();
            if(dateField.getText().isEmpty() || topicField.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Fill all fields");
            } else {
                meetingList.add(meeting);
                JOptionPane.showMessageDialog(this, "Meeting Scheduled!");
                dateField.setText("");
                topicField.setText("");
            }
        });

        viewButton.addActionListener(e -> {
            if(meetingList.isEmpty()){
                JOptionPane.showMessageDialog(this, "No Meetings Scheduled");
            } else {
                StringBuilder meetings = new StringBuilder();
                for(String m : meetingList){
                    meetings.append(m).append("\n");
                }
                JOptionPane.showMessageDialog(this, meetings.toString());
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
