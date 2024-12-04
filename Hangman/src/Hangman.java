import javax.swing.*;

public class Hangman extends JFrame {

    private final WordDB wordDB;

    private int incorrectGuesses;

    public Hangman(){
        super("Hangman Game");
        setSize(CommonConstants.FRAME_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        wordDB = new WordDB()

        addGuiComponents();
    }

    private void addGuiComponents(){

    }
}
