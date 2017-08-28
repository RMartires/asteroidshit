package moveshit;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class spaceship extends Polygon{

int uxleft=500;
int uyleft=400;

int xdir;
int ydir;

static int[] x={500,527,500,508,500};    
static int[] y={400,415,430,415,400};

public spaceship(){

    
super(x,y,5);



}
    
    
public void move(){

uxleft=super.xpoints[0];
uyleft=super.ypoints[0];



if(uxleft<0||(uxleft+25)>1000)
           xdir=-xdir;
    if(uyleft<0||(uyleft+50)>800)
            ydir=-ydir;
    
    
    for(int i=0;i<super.xpoints.length;i++){
    super.xpoints[i]+=xdir;
    super.ypoints[i]+=ydir;
    



}






    
    
    
    

}
}