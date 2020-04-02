import java.rmi.*;  
import java.rmi.registry.*;  
public class RMIServer{
    public static void main(String args[]){
        try{
            Decryptor stub = new DecryptorRemote();
            Naming.rebind("rmi://localhost:5000/parallel", stub);
        }catch(Exception e){e.printStackTrace();}
    }
}