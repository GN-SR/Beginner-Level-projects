import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {

    private final SimpleDateFormat timeFormat;
    private final SimpleDateFormat dayFormat;
    private final SimpleDateFormat dateFormat;
    private final JLabel timeLabel;
    private final JLabel dayLabel;
    private final JLabel dateLabel;

    public MyFrame() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Frame setup
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Modern Java Clock");
        this.setSize(400, 250);
        this.setLayout(new GridLayout(3, 1)); // Use GridLayout for clean alignment
        this.getContentPane().setBackground(new Color(30, 30, 30)); // Dark modern background
        this.setResizable(true);

        // Initialize formats
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");

        // Time Label
        timeLabel = new JLabel("", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Verdana", Font.BOLD, 40));
        timeLabel.setForeground(new Color(0, 200, 255));
        timeLabel.setOpaque(true);
        timeLabel.setBackground(new Color(50, 50, 50));

        // Day Label
        dayLabel = new JLabel("", SwingConstants.CENTER);
        dayLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        dayLabel.setForeground(new Color(0, 255, 150));
        dayLabel.setOpaque(true);
        dayLabel.setBackground(new Color(50, 50, 50));

        // Date Label
        dateLabel = new JLabel("", SwingConstants.CENTER);
        dateLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
        dateLabel.setForeground(new Color(255, 200, 0));
        dateLabel.setOpaque(true);
        dateLabel.setBackground(new Color(50, 50, 50));

        // Add labels to the frame
        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        // Start time update in a separate thread
        updateTime();
    }

    private void updateTime() {
        // Background thread for updating time
        new Thread(() -> {
            while (true) {
                try {
                    // Update time
                    String time = timeFormat.format(Calendar.getInstance().getTime());
                    timeLabel.setText(time);

                    // Update day
                    String day = dayFormat.format(Calendar.getInstance().getTime());
                    dayLabel.setText(day);

                    // Update date
                    String date = dateFormat.format(Calendar.getInstance().getTime());
                    dateLabel.setText(date);

                    // Sleep for 1 second
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
