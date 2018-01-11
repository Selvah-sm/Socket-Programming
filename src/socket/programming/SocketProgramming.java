/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket.programming;
import java.net.*;
import java.io.*;
import static java.lang.Double.sum;
import static java.lang.Math.pow;
import java.util.Scanner;
import javafx.beans.binding.Bindings;


/**
 *
 * @author Selvah
 */
//Java file for server side 
//simple client and server model to identify the armstrong or not
public class SocketProgramming {

    /**
     * @param args 
     * @throws java.io.IOException 
     */
    
  
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket ss = new ServerSocket(3333);
            Socket s = ss.accept();
            
            Scanner scan = new Scanner(s.getInputStream());
            int num = scan.nextInt();
            int length;
            length = size(num);
            int i =0, sum =0, tmp = num;
            while(i<length){
                int rem = num %10;
                num/=10;
                sum = (int) (sum + pow(rem,length));
                i++;
            }
            
            System.out.println("Clients Input : " +tmp);
            OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
            PrintWriter pw = new PrintWriter(out);
            if ( sum == tmp) {
                System.out.println("The Client's input is an armstrong number");
                pw.println("It is an Armstrong number");
                
            }
            else {
                System.out.println("The Client's input is not an armstrong number");
                pw.println("It is Not an Armstrong number");
            }
            out.flush(); 
            s.close();
            ss.close();
            scan.close();
           
            
        }
                    
        catch(IOException e)   {
            e.printStackTrace();
        }
    }
    public static int size(int number) {
        int count =0;
        while(number>0){
            number/=10;
            count++;
        }
        return count;
        
    }
    }

