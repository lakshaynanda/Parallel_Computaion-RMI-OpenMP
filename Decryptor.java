import java.rmi.*;  
public interface Decryptor extends Remote{  
    public byte[] decrypt(byte[] m)throws RemoteException;
    public byte[] encrypt(byte[] m)throws RemoteException;
}