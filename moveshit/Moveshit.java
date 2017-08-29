package moveshit;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;
public class Moveshit extends Polygon{

    
    boolean onscreen=true;
    
    static int[] sx={10,17,26,34,27,36,26,14,8,1,5,1,10};
    static int[] sy={0,5,1,8,13,20,31,28,31,22,16,7,0};

    int sheight=31;
    int sweidth=26;
    
    static ArrayList<Moveshit> arrayshit =new ArrayList<Moveshit>();
    
    int uxleft;
    int uyleft;
    
    int xdir=1;
    int ydir=1;
    
    public Moveshit(int[] x,int[] y,int a){
    
    super(x,y,13);
    
    this.xdir=(int)(Math.random()*7);
    this.ydir=(int)(Math.random()*7);
    }
    
    public Rectangle getBounds(){
    
    return new Rectangle(super.xpoints[0],super.ypoints[0],sweidth,sheight);
    
    }
    
    
    public void move(spaceship ship,ArrayList<beam> thebeam){

       Rectangle shittocheck= this.getBounds();
       Rectangle shipcheck=ship.getbounds();
        if(this.onscreen){
        for(Moveshit shit:arrayshit){
        
            Rectangle currentshit=shit.getBounds();
        
            if(shit!=this && currentshit.intersects(shittocheck))
            {
            int tempxdir=this.xdir;
            int tempydir=this.ydir;
            
            this.xdir=shit.xdir;
            this.ydir=shit.ydir;
            
            shit.xdir=tempxdir;
            shit.ydir=tempydir;
            
            }
        
            if(currentshit.intersects(shipcheck)){ship.setxCenter(ship.gbwidth/2);
            ship.setyCenter(ship.gbheight/2);
            ship.setxvel(0);
            ship.setyvel(0);
            }
            
            for(beam beams:thebeam){
            if(beams.onscreen){
            Rectangle beamcheck=beams.getbounds();
            if(beamcheck.intersects(currentshit)){
            shit.onscreen=false;
            beams.onscreen=false;
            }
            }
            }
            
        }
        
        }
        
    int uxleft=super.xpoints[0];
    int uyleft=super.ypoints[0];
    
    
    if(uxleft<0||(uxleft+25)>1000)
           xdir=-xdir;
    if(uyleft<0||(uyleft+50)>800)
            ydir=-ydir;
    
    
    for(int i=0;i<super.xpoints.length;i++){
    super.xpoints[i]+=xdir;
    super.ypoints[i]+=ydir;
    
    }
    
    
    
    
    
    }
    
    
    public static int[] getx(int randx){
    
    int[] tempx = sx;
    
    for(int i=0;i<tempx.length;i++){

        tempx[i]+=randx;
    
    }
    
    return tempx;
    }
    
    
    public static int[] gety(int randy){
    
    int[] tempy = sy;
    
    for(int i=0;i<tempy.length;i++){

        tempy[i]+=randy;
    
    }
    
    return tempy;
    }
    
    
}
