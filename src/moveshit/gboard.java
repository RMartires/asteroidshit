package moveshit;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
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
    
    this.setSize(this.getWidth(),this.getHeight());
    this.setTitle("test moving shit");
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    makingshit crap = new makingshit();
    this.add(crap);
    
    
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
    
makingshit list = new makingshit();    
    
public void paint(Graphics g){
g.fillRect(0,0,300,400);
g.setColor(Color.red);
for(Moveshit shit:list.arrayshit){
shit.move();
g.drawPolygon(shit);
    
}
}


}




class makingshit extends JComponent{


public  ArrayList<Moveshit> arrayshit =new ArrayList<Moveshit>();
Moveshit s;
public makingshit(){

for(int i=0;i<50;i++){
int randx=(int)(Math.random()*4);
int randy=(int)(Math.random()*4);

arrayshit.add(new Moveshit(s.getx(randx),s.gety(randy),4));
    

}
    

}

}