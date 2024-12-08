import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {

    private final SimpleDateFormat timeFormat;
    private final SimpleDateFormat dateFormat;
    private final SimpleDateFormat dayFormat;
    private final JLabel timeLabel;
    private final JLabel dateLabel;
    private final JLabel dayLabel;

    public MyFrame() {
        // Set modern Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Frame setup
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Fliqlo Style Clock");
        this.setUndecorated(true); // No title bar for fullscreen aesthetic
        this.setSize(600, 400); // Compact size
        this.getContentPane().setBackground(Color.BLACK); // Fully black background
        this.setLayout(new GridBagLayout());
        this.setResizable(false);

        // Formats for time, date, and day
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        dayFormat = new SimpleDateFormat("EEEE");

        // Time Label
        timeLabel = new JLabel();
        timeLabel.setFont(loadDigitalFont(120)); // Large, digital-style font for time
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Date Label
        dateLabel = new JLabel();
        dateLabel.setFont(loadDigitalFont(30)); // Medium font for date
        dateLabel.setForeground(Color.LIGHT_GRAY);
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Day Label
        dayLabel = new JLabel();
        dayLabel.setFont(loadDigitalFont(35)); // Medium font for day
        dayLabel.setForeground(Color.LIGHT_GRAY);
        dayLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add labels to the frame
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Spacing between components

        gbc.gridy = 0;
        this.add(dayLabel, gbc);

        gbc.gridy = 1;
        this.add(timeLabel, gbc);

        gbc.gridy = 2;
        this.add(dateLabel, gbc);

        // Make frame visible
        this.setVisible(true);

        // Start updating time, day, and date
        updateTime();
    }

    private void updateTime() {
        // Background thread for updating time, date, and day
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

    private Font loadDigitalFont(float size) {
        try {
            // Load a custom font
            Font digitalFont = Font.createFont(Font.TRUETYPE_FONT,
                    getClass().getResourceAsStream("/digital-7.ttf")); // Add your digital font file
            return digitalFont.deriveFont(size);
        } catch (Exception e) {
            e.printStackTrace();
            return new Font("Verdana", Font.BOLD, (int) size); // Fallback font
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyFrame::new);
    }
}
