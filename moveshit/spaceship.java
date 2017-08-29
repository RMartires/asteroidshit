package moveshit;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class spaceship extends Polygon{

    private double xvel=0,yvel=0;
    
    int gbwidth=gboard.width;
    int gbheight=gboard.height;
    
    private double centerx=gbwidth/2,centery=gbheight/2;
    
    public static int[] polyx={-13,14,-13,-5,-13};
    public static int[] polyy={-15,0,15,0,-15};
    
    private int shipwidth=27,shipheight=30;
    
    public double uleftxpos=getxCenter()+this.polyx[0];
    public double uleftypos=getyCenter()+this.polyy[0];
    
    
    static public double rangle=0,mangle=0;
    
    public spaceship(){
    
    super(polyx,polyy,5);
    
    
    }
    
    //center
    public double getxCenter(){return centerx;}
    public double getyCenter(){return centery;}
    
    public void setxCenter(double xcent){this.centerx=xcent;}
    public void setyCenter(double ycent){this.centery=ycent;}
    
    //incerese xpos
    
    public void incxpos(double incamt){this.centerx+=incamt;}
    public void incypos(double incamt){this.centery+=incamt;}
    
    //uleftpos
    
    public double getxpos(){return uleftxpos;}
    public double getypos(){return uleftypos;}
    
    public void setxpos(double pos){this.uleftxpos=pos;}
    public void setypos(double pos){this.uleftypos=pos;}
    
    //ship weidth and height
    
    public int getswidth(){return shipwidth;}
    public int getsheight(){return shipheight;}
    
    //vel
    public double getxvel(){return xvel;}
    public double getyvel(){return yvel;}
    
    public void setxvel(double x){this.xvel=x;}
    public void setyvel(double y){this.yvel=y;}
    
    
    public void incxvel(double x){this.xvel+=x;}
    public void incyvel(double y){this.yvel+=y;}
    
    public void decxvel(double x){this.xvel-=x;}
    public void decyvel(double y){this.yvel-=y;}
    
   //mangle
    
    public void setmangle(double angle){this.mangle=angle;}
     public double getmangle(){return mangle;}
    public void incmangle(double angle){this.mangle+=angle;}
    
    public double shipxmangle(double angle){return (double)(Math.cos(angle+Math.PI)/180);}
    public double shipymangle(double angle){return (double)(Math.sin(angle+Math.PI)/180);}
    
    //rangle
    
    public double getrangle(){return this.rangle;}
    
    public void incrangle(){
    if(getrangle() >= 365){rangle=0;}
    else{rangle+=0.1;}
    
    }
    
     public void decrangle(){
    if(getrangle() < 0){rangle=365;}
    else{rangle-=0.1;}
    }
    
    
    public Rectangle getbounds(){
    
    return new Rectangle((int)this.getxCenter()-14,(int)this.getyCenter()-15,getswidth(),getsheight());
    
    }
    
    public double getshipxnose(){
    return (this.getxCenter())+(Math.cos(rangle)*14);
    }
    
    
    public double getshipynose(){
    return this.getyCenter()+(Math.sin(rangle)*14);
    }
    
    //move
    public void move(){
    
    
    this.incxpos(this.getxvel());
    
    if(this.getxCenter()<0){
    this.setxCenter(gbwidth);
    }else if(this.getxCenter()>gbwidth){this.setxCenter(0);}
    
    this.incypos(this.getyvel());
    
    if(this.getyCenter()<0){
    this.setyCenter(gbheight);
    }else if(this.getyCenter()>gbheight){this.setyCenter(0);}
    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
}