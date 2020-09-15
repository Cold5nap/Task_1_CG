import javax.swing.*;
import java.awt.*;

public class Start {

    public static void main(String[] args) {
        /* Задание заголовка окна*/
        JFrame w=new JFrame("DrawPicture");
        w.setSize(500, 600);
        w.setLocation((1366-500)/2,(768-600)/2);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*	Менеджер определяет
         *  каким образом в окне расположены объекты.*/
        w.setLayout(new BorderLayout(1,1));

        Canvas canvas =new Canvas();
        w.add(canvas);
        w.setVisible(true);
    }
}
