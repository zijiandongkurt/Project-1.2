import java.util.Timer;




public class solverAttempt1 {
    private double x; //current x
     private double y; //curent y
     private double h; // height
     private double xv; //velocity x 
     private double yv; // velocity y
     

     private double g; //gravity
     private double uk; //kinetic friction
     private double stepSize;
     private double accX; // acceleration x
     private double accY; //acceleration y
     private double [] outputArray;

     //private Timer t1 = new Timer();
public solverAttempt1( double kineticFriction, double stepSize, double initialX, double initialY,  double initialVX, double inititialVY){
    this.uk = kineticFriction;
    this.stepSize = stepSize;
    this.x= initialX;
    this.y= initialY;
    
    this.xv= initialVX;
    this.yv = inititialVY;
    double [] outputArray  = {x,y,xv,yv};

}

    


    public static void main(String[]args){
        solverAttempt1 solver = new solverAttempt1(0.06, 0.1, 0, 0, 1, 0);
        

    }

    public  double [] newState(double x, double y, double xv, double yv, double deltaH){
        double aX = x;
        double aY = y;
        x = x+ stepSize* xv;
        y = y + stepSize * yv;
        xv= xv + stepSize * accX; //to do: initial acceleration
        yv= yv + stepSize * accY;
        this.x=x;
        this.y = y;
        this.xv = xv;
        this.yv = yv;
        accX = accelerationX (deltaH, aX-outputArray[0] );
        accY = accelerationY (deltaH, aY- outputArray[1]);
        outputArray[0] = x;
        outputArray[1]=y;
        outputArray [2] = xv;
        outputArray [3]= yv;
        return outputArray;



    }

    public  double accelerationX ( double deltaH, double deltaX){
        double accX = (-1)*(deltaH/deltaX) - (uk*g*xv)/Math.sqrt(xv*xv+yv*yv);
        return accX;
    }

    public  double accelerationY (double deltaH, double deltaY){
        double accY = (-1)*(deltaH/deltaY) - (uk*g*yv)/Math.sqrt(xv*xv+yv*yv);
        return accY;
    }






}
