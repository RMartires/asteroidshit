package moveshit;
import java.awt.Polygon;
import java.awt.Rectangle;


public class beam extends Polygon{
    
static int[] polyx={-3,3,3,-3,-3};
static int[] polyy={-3,-3,3,3,-3};
    
public double xvel=0;
public double yvel=0;

public int width=gboard.width;
public int height=gboard.height;


public double xcent=0;
public double ycent=0;
    
public int beamwidth=6;
public int beamheight=6;

boolean onscreen=true;

public double mangle=0;

public beam(double cx,double cy,double mangle){

super(polyx,polyy,5);

this.xcent=cx;
this.ycent=cy;
this.mangle=mangle;


this.xvel=beamxangle(mangle);
this.yvel=beamyangle(mangle);

}


public double beamxangle(double angle){
return 10*(double)(Math.cos((angle)+Math.PI/180));

}


public double beamyangle(double angle){
return 10*(double)(Math.sin((angle)+Math.PI/180));
}

public void changexpos(double incamt){this.xcent+=(incamt);}
public void changeypos(double incamt){this.ycent+=(incamt);}
    
Rectangle getbounds(){
return new Rectangle((int)this.xcent-6,(int)this.ycent-6,this.beamwidth,this.beamheight);
}
        
        
        
public void move(){
if(this.onscreen){
this.changexpos(this.xvel);

}
if(this.xcent<0)
    this.onscreen=false;
if(this.xcent>width)
    this.onscreen=false;

if(this.onscreen){
this.changeypos(this.yvel);
if(this.ycent<0)
    this.onscreen=false;
if(this.ycent>height)
    this.onscreen=false;



}
}


}
