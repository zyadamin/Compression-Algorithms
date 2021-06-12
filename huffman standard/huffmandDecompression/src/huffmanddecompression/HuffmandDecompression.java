/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmanddecompression;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author zezo
 */
public class HuffmandDecompression {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
   
   FileWriter write = new FileWriter("text.txt");  
    FileReader code=new FileReader("code.txt"); 
     Scanner readCode =new Scanner(code); 
     
   FileReader tableFile=new FileReader("tableFile.txt");
       Scanner readTable =new Scanner(tableFile); 
       
  ArrayList<Character>theCode=new ArrayList<>();
       while(readCode.hasNext()){
  String y=(readCode.nextLine());
    
  for(int i=0;i<y.length();i++){  
  theCode.add(y.charAt(i));
   }
  }   

    ArrayList<String>nowCode=new ArrayList<>();
    ArrayList<String>nowChar=new ArrayList<>();

       while(readTable.hasNext()){
     String y=(readTable.nextLine());
    
  
  nowChar.add(String.valueOf(y.charAt(0)));
  nowCode.add(y.substring(2));
   }
       /*
       for(int i=0;i<nowChar.size();i++){
           System.out.println(nowCode.get(i));}
       */
    
   String x="";
    int exist=-2;
   for(int i=0;i<theCode.size();i++){
     
    if(exist==-2){x=String.valueOf(theCode.get(i));}
    else{x+=String.valueOf(theCode.get(i));}
       //System.out.println(x);
       exist=nowCode.indexOf(x);
           //System.out.println(exist);

 
    if(exist>-1){
                  // System.out.println("hee");
    if(nowChar.get(exist).equals("\\")){ write.write("\n");exist=-2;}
    
    else{write.write(nowChar.get(exist));exist=-2;}
    
    }
    
    }
                  

          
          
       
   
   write.close();
   
  }  
}
