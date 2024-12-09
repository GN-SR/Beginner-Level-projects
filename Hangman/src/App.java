import javax.swing.*;

public class App {
    public static void main(String[] args) {

        //method to call all the classes needed
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Hangman().setVisible(true);
            }
        });

    }
}
