/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lz77.de;

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
public class LZ77De {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        FileWriter newfile= new FileWriter("lz77de.txt");
        FileReader file=new FileReader("lz77.txt");
     
        Scanner input =new Scanner(file);
        ArrayList<Character> word= new  ArrayList<>();
        while(input.hasNextLine()){
        
        String x=input.nextLine();
   
         
            if(x.charAt(1)=='0'&&x.charAt(3)=='0'){
              
                if(x.charAt(5)=='\\'){ newfile.write('\n');}  
                else{newfile.write(x.charAt(5));}
            
            
            word.add(x.charAt(5));
            }
            
            else{
                String window = null,length=null;
                int num=-1;
                for(int k=0;k<x.length();k++){
                if(x.charAt(k)==','){window=x.substring(1, k);
                break;
                }
                }
                
                for(int k=0;k<x.length();k++){
                if(x.charAt(k)==','&&num==-1){num=k;}
                else if(x.charAt(k)==','){length=x.substring(num+1,k);
                break;
                }
                
                }

        int back=Integer.parseInt(window);
        int forward=Integer.parseInt(length);

          int   indexBack=word.size()-back;
          
          for(int j=indexBack;forward>0;j++){
              forward--;
          word.add(word.get(j));
          if(word.get(j)=='\\'){newfile.write('\n');}
          else{newfile.write(word.get(j));}
          

          }
          word.add(x.charAt(x.length()-2));
          if(x.charAt(x.length()-2)=='\\'){newfile.write('\n');}
          else{newfile.write(x.charAt(x.length()-2));}

            }
        
        }

file.close();
newfile.close();


    }
    
}
