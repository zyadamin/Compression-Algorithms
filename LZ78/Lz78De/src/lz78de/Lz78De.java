/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lz78de;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Manaz
 */
public class Lz78De {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
         FileReader tag=new FileReader("tags.txt");
           FileWriter newfile= new FileWriter("lz78de.txt");
         FileReader table=new FileReader("tableFile.txt");
             Scanner input =new Scanner(table);
             Scanner out =new Scanner(tag);
             ArrayList<String>table1=new ArrayList<>();
         while(input.hasNextLine()){
             table1.add(input.nextLine());
         }
           while(out.hasNextLine()){
               
            String x=out.nextLine();
                 
             if(x.charAt(1)=='0'){
            
             if(x.charAt(3)=='\\'){newfile.write('\n');}
             
             else{newfile.write(x.charAt(3));}
        
            }
         else{
                      
                        String window = null,l=null;
               
                for(int k=0;k<x.length();k++){
                if(x.charAt(k)==','){window=x.substring(1, k);
                l=x.substring(k+1,x.length()-1);
                break;
                }
                }
                      
                int back=Integer.parseInt(window);    
                      
                  String word=table1.get(back)+l;
              
               String replace = word.replace('\\','\n' );
                   newfile.write(replace);   
                      
 
                      
                      }     
                   
       
                   
         }
         
       tag.close();
       newfile.close();
       table.close();
         
         
    }
    
}
