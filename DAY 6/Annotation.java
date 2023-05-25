import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.*;
import java.lang.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface CricketPlayer{
    int age() default 34;
    String country() default "India";
}

@CricketPlayer
class Dhoni{

    int runs;
    int innings;

    public void setruns(int runs){
        this.runs = runs;
    }

    public void setinnings(int innings){
        this.innings = innings;
    }

    public void getruns(){
        System.out.println(runs);
    }

    public void getinnings(){
        System.out.println(innings);
    }

}

public class Annotation{
    
    public static void main(String[] args) throws ClassNotFoundException {
        Dhoni d = new Dhoni();
        d.setinnings(40);
        d.setruns(100);
       
        Class c = d.getClass();
    
        CricketPlayer cp = (CricketPlayer) c.getAnnotation(CricketPlayer.class);;
        
        System.out.println(cp.age());
        
      


    }

}
