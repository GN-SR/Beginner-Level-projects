import javax.swing.*;
import java.beans.Customizer;

public class Hangman extends JFrame {

    private int incorrectGuesses;

    private String[] wordChallenge;

    private final WordDB wordDB;
    private JLabel hangmanImage;

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
        hangmanImage = CustomTools.loadImage();
    }
}
