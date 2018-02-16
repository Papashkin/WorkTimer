import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import static java.lang.String.format;

public class TimerGUI extends JFrame {
    private JPanel panel;
    private JButton bStart;
    private JButton bAgain;
    private JButton bPause;
    private JLabel lTimer;
    private long hour, min, sec;
    JOptionPane finishMsg = new JOptionPane();
    private String str;
    private Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            sec -= 1;
            if (sec == -1) sec = 59;
            if (sec == 59) {
                min -= 1;
                if (min == -1) min = 59;
                if (min == 59) hour -= 1;
            }

            if (hour == -1) {
                timer.stop();
                finishMsg.showMessageDialog(null, "Work day is finished", "Finish!", JOptionPane.INFORMATION_MESSAGE);
                prepare();
            }
            update();
        }
    });

    public TimerGUI() {
        this.getContentPane().add(panel);
        bStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
            timer.start();
        }
        });

        bPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){ timer.stop(); }
        });

        bAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                timer.stop();
                prepare();
            }
        });
    }

    public void prepare() {
        hour = 8;
        min = 0;
        sec = 0;
        str = format("%02d : %02d : %02d", hour, min, sec);
        lTimer.setText(str);
    }

    public void update(){
        str = format("%02d : %02d : %02d", hour, min, sec);
        lTimer.setText(str);
    }
}
