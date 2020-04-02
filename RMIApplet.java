import java.rmi.*;
import java.awt.event.*;
import javax.swing.*;
public class RMIApplet{
    public static void main(String[] args)throws Exception{
        JFrame f=new JFrame("Button Example");
        final JTextField tf=new JTextField();
        tf.setBounds(125,50,150,20);
        JButton b=new JButton("Serial Execution");
        JButton b1=new JButton("Parallel Execution");
        b.setBounds(50,100,150,30);
        b1.setBounds(200,100,150,30);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    DES des = new DES();
                    long startTime = System.nanoTime();
                    String s = "This is a test";
                    String s1 = des.bruteForce(s.getBytes());
                    System.out.println(s1);
                    long difference = System.nanoTime() - startTime;
                    tf.setText(difference / 1000000 + "ms");
                } catch(Exception e1){}
            }
        });
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    long startTime = System.nanoTime();
                    Decryptor stub=(Decryptor)Naming.lookup("rmi://localhost:5000/parallel");
                    String x = new String("This is a test");
                    byte [] encrypted = stub.encrypt(x.getBytes());
                    byte [] decrypted = stub.decrypt(encrypted);
                    long difference = System.nanoTime() - startTime;
                    tf.setText(difference / 1000000 + "ms");
                } catch(Exception e1){}
            }
        });
        f.add(b);f.add(tf);f.add(b1);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }  
}