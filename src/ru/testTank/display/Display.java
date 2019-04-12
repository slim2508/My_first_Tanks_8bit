package ru.testTank.display;


import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;


public class Display {
    private static boolean create = false;
    private static JFrame window;
    private static Canvas content;
    
    public static void create (int width, int hight, String title){
        if (create)         /*проверка, если окно уже создано, то делаем ретёрн*/
            return;
        
        window = new JFrame(title);         /*тначе создаем окно с именем window*/
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content = new Canvas();             /*создаем поле с именем content*/
        
        Dimension size = new Dimension(width, hight);           /*создаем объект для указания размеров поля*/   
        content.setPreferredSize(size);                         /*функция применяющая размеры к полю контент*/
        
        window.setResizable(false);                             /*запрещаем изменение размера окна*/
        window.getContentPane().add(content);                   /*помещаем контент в окно и задаем контент по размеру окна*/
        window.pack();  
        window.setLocationRelativeTo(null);
        window.setVisible(true);                                /*делаем окно видимым*/
        
        System.out.println("bla bla bla");
        
    }
}
