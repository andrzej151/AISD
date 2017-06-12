package Anim;
import java.util.Random;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;

class MultiThreadedTimerAnim 
    extends JPanel 
    implements ActionListener
{
    public static void main(String[] args){
        JFrame frame = new JFrame("MultiThreadedTimerAnim");
        final MultiThreadedTimerAnim anim  = new MultiThreadedTimerAnim();
        frame.getContentPane().add(anim);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.show();
        
        int delay;  // odswiezanie
        int count;  // liczba obiektow
        try {        
        delay = Integer.parseInt(args[0]);
        count = Integer.parseInt(args[1]);
        }
        catch(Exception e){
            delay = 70;
            count = 30;
        }
        anim.startAnimation(delay, count);
    }

    public Dimension getPreferredSize(){
        return new Dimension(300, 300);
    }
    
        // bufor
    Image image;
        // wykreslacz ekranowy
    Graphics2D device;
        // wykreslacz bufora
    Graphics2D buffer;
    
        // przygotowanie wykreslaczy
        // uruchomienie watkow animacyjnych i zegara
    void startAnimation(int delay, int count){
        int width = getWidth();
        int height = getHeight();
        
        image = createImage(width, height);
        buffer = (Graphics2D)image.getGraphics();
        buffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                                RenderingHints.VALUE_ANTIALIAS_ON);
        device = (Graphics2D)getGraphics();
        device.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                                RenderingHints.VALUE_ANTIALIAS_ON);
        Timer timer = new Timer(delay, this);
            
        for(int i = 0; i < count; i++){
            Sprite spr = new Sprite(buffer, delay, width, height);
            timer.addActionListener(spr);
            new Thread(spr).start();
        }
        timer.start();
    }
    
        // przeniesienie bufora na ekran i wyczyszczenie go
    public void actionPerformed(ActionEvent evt){
        device.drawImage(image, 0, 0, null);
        buffer.clearRect(0, 0, getWidth(), getHeight());
    }
}

    // animowane obiekty
    // moga byc dowolnymi obiektami typu Shape
    // ale tu sa kwadratami
class Sprite implements Runnable, ActionListener {
        
        // wspolny bufor
    private Graphics2D buffer;
        // rozmiary pulpitu
    private int width, height;
    private int delay;    

    private Color clr;
        // do transformacji
    private Area area;
        // do wykreslania
    private Shape shape;
        // przeksztalcenie obiektu
    private AffineTransform aft;
        
        // przesuniecie
    private int dx, dy;
        // rozciaganie
    private double sf;
        // kat obrotu
    private double an;
        // ziarno dla generatora liczb losowych
    static private int seed = 0;

    public Sprite(Graphics2D buf, int del, int w, int h){
        delay = del;
        buffer = buf;
        width = w;
        height = h;
        
        Random rand = new Random(seed++);
        dx = 1+rand.nextInt(5);
        dy = 1+rand.nextInt(5);
        sf = 1+0.05*rand.nextDouble();
        an = 0.1*rand.nextDouble();
        
        clr = new Color(rand.nextInt(255), 
                        rand.nextInt(255), 
                        rand.nextInt(255), 
                        rand.nextInt(255));        
        shape = new Rectangle2D.Float(0, 0, 10, 10);
        aft = new AffineTransform();                                  
        area = new Area(shape);
    }

    public void run(){
            // przesuniecie na srodek
        aft.translate(100, 100);
        area.transform(aft);
        shape = area;
        
        while(true){
            // przygotowanie nastepnego kadru
            shape = nextFrame();
            try{
                Thread.sleep(delay);
            }
            catch(InterruptedException e){
            }
        }
    }

    protected Shape nextFrame(){
            // zapamietanie na zmiennej tymczasowej
            // aby nie przeszkadzalo w wykreslaniu
        area = new Area(area);
        aft = new AffineTransform();                                  
        Rectangle bounds = area.getBounds();
        int cx = bounds.x + bounds.width/2;
        int cy = bounds.y + bounds.height/2;
            // odbicie
        if(cx < 0 || cx > width)
            dx = -dx;
        if(cy < 0 || cy > height)
            dy = -dy;
            // zwiekszenie lub zmniejszenie
        if(bounds.height > height/3 || bounds.height < 10)
            sf = 1/sf;
            // konstrukcja przeksztalcenia
        aft.translate(cx, cy);
        aft.scale(sf, sf);
        aft.rotate(an);
        aft.translate(-cx, -cy);
        aft.translate(dx, dy);
            // przeksztalcenie obiektu
        area.transform(aft);
        return area;
    }
    
    public void actionPerformed(ActionEvent evt){
            // wypelnienie obiektu
        buffer.setColor(clr);
        buffer.fill(shape);
            // wykreslenie ramki
        buffer.setColor(clr.darker());
        buffer.draw(shape);
    }
} 