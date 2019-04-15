package ru.testTank.display;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;
import javax.swing.JFrame;


public class Display {
    private static boolean create = false;
    private static JFrame window;
    private static Canvas content;
    
    private static BufferedImage buffer;
    private static int[] bufferData;
    private static Graphics bufferGraphics;
    private static int clearColor;
    
    //temp
    private static float delta = 0;
    
    //temp end
    
    public static void create (int width, int hight, String title, int _clearColor){
        if (create)         /*проверка, если окно уже создано, то делаем ретёрн*/
            return;
        
        window = new JFrame(title);         /*тначе создаем окно с именем window*/
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content = new Canvas();                                 /*создаем поле с именем content*/
        
        Dimension size = new Dimension(width, hight);           /*создаем объект для указания размеров поля*/   
        content.setPreferredSize(size);                         /*функция применяющая размеры к полю контент*/
        
        window.setResizable(false);                             /*запрещаем изменение размера окна*/
        window.getContentPane().add(content);                   /*помещаем контент в окно и задаем контент по размеру окна*/
        window.pack();  
        window.setLocationRelativeTo(null);
        window.setVisible(true);                                /*делаем окно видимым*/
        
        buffer = new BufferedImage(width, hight, BufferedImage.TYPE_INT_ARGB);
        bufferData = ((DataBufferInt)buffer.getRaster().getDataBuffer()).getData();
        bufferGraphics = buffer.getGraphics();
        clearColor = _clearColor;
        create = true;
        
    }
    public static void clear(){
        Arrays.fill(bufferData, clearColor);
    }
    
    public static void render(){
        bufferGraphics.setColor(new Color (0xff0000ff));
        bufferGraphics.fillOval((int)(350 + (Math.sin(delta)*200)), 250 + ((int)(Math.cos(delta)*100)), 100, 100);
        delta +=0.02f;
    }
    
    public static void swapBuffers(){
        Graphics g = content.getGraphics();
        g.drawImage(buffer, 0, 0, null);
    }
}
