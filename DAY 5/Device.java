class Device {
   //instance block {
    {
        System.out.println("from instance block");
    }
    

    static {
    System.out.println("from static block");
    }

    static void Device(){
        System.out.println("From constructor");
    }

   
}

// order of execution: 1. static block, 2. instatnce block, 3. constructor,

// instance block is called on creation of object
// on class loader execution static block is executed 

