package moveshit;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import javax.swing.JComponent;

public class gboard extends JFrame{
    
    static int width=1000;
    static int height=800;
    //spaceship key
   static boolean keyheld=false;
    static int keycode;
    spaceship theship = new spaceship();
    
    //beam
   public static ArrayList<beam> beamlist = new ArrayList<beam>();
    
    
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
            
            if(e.getKeyCode()==87){
                System.out.println("forward");
                keycode=e.getKeyCode();
            keyheld=true;
            }
            if(e.getKeyCode()==65){
                keycode=e.getKeyCode();
               keyheld=true;
               System.out.println("anti-clockwise");
            }
            
            if(e.getKeyCode()==68){
                keycode=e.getKeyCode();
               keyheld=true;
               System.out.println("clockwise");
            }
            
            if(e.getKeyCode()==KeyEvent.VK_SPACE){keycode=e.getKeyCode();
            keyheld=true;
            System.out.println("shoot");
            beamlist.add(new beam(gpanel.ship.getshipxnose(),gpanel.ship.getshipynose(),gpanel.ship.getrangle()));
            
            
            
            }
            
            
            
            
            
            
            
            
            
            
            
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
              keyheld=false;
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
 
static spaceship ship =new spaceship() ;  
makingshit list = new makingshit();    
public void paint(Graphics g){
    //for the ship
 Graphics2D gr = (Graphics2D)g;    
  AffineTransform identity = new AffineTransform();   
 
g.fillRect(0,0,1000,800);
g.setColor(Color.WHITE);
for(Moveshit shit:list.arrayshit){
    if(shit.onscreen){
shit.move(ship,gboard.beamlist);
g.drawPolygon(shit);
g.fillPolygon(shit);
    }
}

if(gboard.keycode==87 && gboard.keyheld==true){
ship.setmangle(ship.getrangle());
ship.decxvel(ship.shipxmangle(ship.getrangle())*10);
ship.decyvel(ship.shipymangle(ship.getrangle())*10);
System.out.println(ship.getrangle());

}

if(gboard.keycode==65 && gboard.keyheld==true){
ship.decrangle();

}

if(gboard.keycode==68 && gboard.keyheld==true){
ship.incrangle();
}

gr.setTransform(identity);
ship.move();
gr.translate(ship.getxCenter(),ship.getyCenter());
gr.rotate(ship.getrangle());
gr.setColor(Color.red);
gr.fillPolygon(ship);
gr.draw(ship);

//paint beam

for(beam thebeam:gboard.beamlist){

thebeam.move();
if(thebeam.onscreen){
gr.setTransform(identity);
gr.translate(thebeam.xcent,thebeam.ycent);
gr.drawPolygon(thebeam);
gr.fillPolygon(thebeam);
gr.setColor(Color.YELLOW);

    
}//if

}//for


}//paint


}//gpanel




class makingshit extends JComponent{


public  ArrayList<Moveshit> arrayshit =new ArrayList<Moveshit>();

public makingshit(){

for(int i=0;i<50;i++){
int randx=(int)(Math.random()*80);
int randy=(int)(Math.random()*100);

arrayshit.add(new Moveshit(Moveshit.getx(randx),Moveshit.gety(randy),4));
Moveshit.arrayshit=arrayshit;    

}


}

}