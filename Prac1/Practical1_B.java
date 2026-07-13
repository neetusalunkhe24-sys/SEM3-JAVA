package javaprac1_b;

class Vehicle{
    void show(){
        System.out.println("This is a Vehicle");
    }
}

class Car extends Vehicle{
    
    @Override
    void show(){
        System.out.println("This is a Car");
    }
}

public class Practical1_B{
    public static void main(String[] args)
    {
        Vehicle v = new Vehicle();
        Car c = new Car();
        
        System.out.println("Parent Class Output: ");
        v.show();
        
        System.out.println();
        System.out.println("Child Class Output: ");
        c.show();
    }
}
