/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket.programming;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter; 
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Selvah
 */
public class Clent {
    public static void main(String[] args) throws IOException {
        try{
        Socket s=new Socket("localhost",3333);  
        System.out.println("Enter an number to ask the server");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
        PrintWriter    pt = new PrintWriter(out);
        pt.println(number);
        out.flush();
        Scanner scann = new Scanner(s.getInputStream());
        String strr = scann.nextLine();
        System.out.println("The Server Says : "+strr);
        scan.close();
        scann.close();
        
        s.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
 }
