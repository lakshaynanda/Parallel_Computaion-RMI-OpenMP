import java.rmi.*;  
import java.rmi.server.*;  
public class DecryptorRemote extends UnicastRemoteObject implements Decryptor{
    DES des;
    byte [] raw;
    DecryptorRemote()throws RemoteException{  
        super();
        des = new DES();
        raw = des.raw;
    }
    public byte[] encrypt(byte [] b) throws RemoteException{
        System.out.println(des);
        byte[] encryptedString = null;
        try{
            encryptedString = des.encrypt(raw, b);
            System.out.println("Encrypted String: " + new String(encryptedString));
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            return encryptedString;
        }
    }
    public byte[] decrypt(byte [] b)throws RemoteException{
        byte[] decryptedString = null;
        try{
            decryptedString = des.decrypt(raw, b);
            System.out.println("Decrypted String: " + new String(decryptedString));
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            return decryptedString;
        }
    }
}