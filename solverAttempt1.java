import java.util.Timer;




public class tTest1 {
     private double x;
     private double y;
     private double h;
     private double xv;
     private double yv;
     private double zv;

     private double g;
     private double uk;
     private double G;
     private double stepSize = 0.01;
     //private Timer t1 = new Timer();





    public static void main(String[]args){

    }

    public  int[] newState(double xv, double yv, double zv){


    }

    public  double accelerationX ( double deltaH, double deltaX,double KineticFriction ){
        double accX = (-1)*(deltaH/deltaX) - (KineticFriction*g*xv)/Math.sqrt(xv*xv+yv*yv);
        return accX;
    }

    public  double accelerationY (double deltaH, double deltaY,double KineticFriction){
        double accY = (-1)*(deltaH/deltaY) - (KineticFriction*g*yv)/Math.sqrt(xv*xv+yv*yv);
        return accY;
    }






}
