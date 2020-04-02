import java.rmi.*;  
public class RMIClient{  
    public static void main(String args[]){  
        try{  
            Decryptor stub=(Decryptor)Naming.lookup("rmi://localhost:5000/parallel");
            String x = new String("This is a test");
            byte [] encrypted = stub.encrypt(x.getBytes());
            byte [] decrypted = stub.decrypt(encrypted);
        }catch(Exception e){}  
    }  
}