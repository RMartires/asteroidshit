package moveshit;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import javax.swing.JComponent;

public class gboard extends JFrame{
    
    public static void main(String[] args){
    
    new gboard();
    
    
    }
    
    public gboard(){
    
    this.setSize(1000,800);
    this.setTitle("test moving shit");
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    this.addKeyListener(new KeyListener(){
        @Override
        public void keyTyped(KeyEvent e) {
            
            }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
         
            if(e.getKeyCode()==87)
                System.out.println("forward");
            if(e.getKeyCode()==83)
                System.out.println("backward");
            
            
        }
    
    
    
    });
    
    gpanel panel = new gpanel();
    this.add(panel);
    
    ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);
    executor.scheduleAtFixedRate(new repaintboard(this),0L,20L,TimeUnit.MILLISECONDS);
    

    }
    
}


class repaintboard implements Runnable{

     gboard board;    
    
    public repaintboard(gboard board){
    
    this.board=board;
    
    
    }
    
    
    @Override
    public void run() {
        board.repaint();
    }


}







class gpanel extends JPanel{
 
spaceship ship = new spaceship();    
makingshit list = new makingshit();    
public void paint(Graphics g){
g.fillRect(0,0,1000,800);
g.setColor(Color.red);
for(Moveshit shit:list.arrayshit){
shit.move();
g.drawPolygon(shit);
    
}
ship.move();
g.drawPolygon(ship);

}


}




class makingshit extends JComponent{


public  ArrayList<Moveshit> arrayshit =new ArrayList<Moveshit>();

public makingshit(){

for(int i=0;i<50;i++){
int randx=(int)(Math.random()*80);
int randy=(int)(Math.random()*100);

arrayshit.add(new Moveshit(Moveshit.getx(randx),Moveshit.gety(randy),4));
Moveshit.arrayshit=arrayshit;    
System.out.printf("%d\t%d",randx,randy);
System.out.printf("\n");
}


}

}