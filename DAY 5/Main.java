import java.lang.reflect.Method;

class Apple{

    private void Repair( int x){
        System.out.println("Repairing..."+ x);
    }

}

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        
        Class c = Class.forName("Apple"); // getting class name 
      
        Apple apple = (Apple) c.newInstance(); //creating object
        Method m = c.getDeclaredField("repair", int.class); //accessing private methods 
        m.setAccessible(true); // setting accessibility for the private method 
        m.invoke(apple, 50); // calling the private method

        
    }
}
