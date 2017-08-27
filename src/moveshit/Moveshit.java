package moveshit;
import java.awt.Polygon;
public class Moveshit extends Polygon{

    
    int[] sx={11,22,45,66};
    int[] sy={77,55,44,33};

    
    
    int uxleft;
    int uyleft;
    
    int xdir=5;
    int ydir=5;
    
    public Moveshit(int[] x,int[] y,int a){
    
    super(x,y,4);
    
    
    
    
    }
    
    public void move(){
    
    int uxleft=super.xpoints[0];
    int uyleft=super.ypoints[0];
    
    
    if(uxleft<0||(uxleft+25)>300)
        this.xdir=-xdir;
    if(uyleft<0||(uyleft+50)>400)
        this.ydir=-ydir;
    
    
    for(int i=0;i<super.xpoints.length;i++){
    super.xpoints[i]+=xdir;
    super.ypoints[i]+=ydir;
    
    }
    
    
    
    
    
    
    }
    
    
    public int[] getx(int x){
    
    int[] tempx = this.sx;
    
    for(int i=0;i<tempx.length;i++){

        tempx[i]+=x;
    
    }
    
    return tempx;
    }
    
    
     public int[] gety(int y){
    
    int[] tempy = this.sy;
    
    for(int i=0;i<tempy.length;i++){

        tempy[i]+=y;
    
    }
    
    return tempy;
    }
    
    
}
