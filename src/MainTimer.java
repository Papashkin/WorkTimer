public class MainTimer {

    public static void main(String args[]) {
        TimerGUI mainScreen = new TimerGUI();
        mainScreen.setTitle("Work timer");
        mainScreen.prepare();
        mainScreen.pack();
        mainScreen.setSize(200,180);
        mainScreen.setVisible(true);
        mainScreen.setResizable(false);
        mainScreen.setDefaultCloseOperation(mainScreen.EXIT_ON_CLOSE);
    }
}