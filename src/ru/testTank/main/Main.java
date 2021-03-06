
package ru.testTank.main;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Timer;
import ru.testTank.display.Display;

public class Main {
    public static void main(String[] args) {
        Display.create(800, 600, "8 Bit Tanks", 0xff00ff00);
        
        Timer t = new Timer(1000 / 60, new AbstractAction() { /*будет заускать нашу функцию примерно 60 раз  в секунду*/
            @Override
            public void actionPerformed(ActionEvent e) {
             Display.clear();
             Display.render();
             Display.swapBuffers();
            }
        });
        t.setRepeats(true);
        t.start();
}
}
