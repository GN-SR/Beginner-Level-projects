import javax.swing.*;
import java.awt.*;
import java.beans.Customizer;

public class Hangman extends JFrame {

    private int incorrectGuesses;

    private String[] wordChallenge;

    private final WordDB wordDB;
    private JLabel hangmanImage, categoryLabel;

    public Hangman(){
        super("Hangman Game");
        setSize(CommonConstants.FRAME_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        wordDB = new WordDB();
        wordChallenge = wordDB.loadChallenge();

        addGuiComponents();
    }

    private void addGuiComponents(){
        hangmanImage = CustomTools.loadImage(CommonConstants.IMAGE_PATH);
        hangmanImage.setBounds(0, 0, hangmanImage.getPreferredSize().width, hangmanImage.getPreferredSize().height);

        categoryLabel = new JLabel(wordChallenge[0]);
        categoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
        categoryLabel.setOpaque(true);
        categoryLabel.setForeground(Color.WHITE);
        categoryLabel.setBackground(CommonConstants.SECONDARY_COLOR);
        categoryLabel.setBorder(BorderFactory.createLineBorder(CommonConstants.SECONDARY_COLOR));
        categoryLabel.setBounds(
                0,
                    hangmanImage.getPreferredSize().height - 28,
                    CommonConstants.FRAME_SIZE.width,
                    categoryLabel.getPreferredSize().height
        );

        getContentPane().add(categoryLabel);
        getContentPane().add(hangmanImage);

    }
}
