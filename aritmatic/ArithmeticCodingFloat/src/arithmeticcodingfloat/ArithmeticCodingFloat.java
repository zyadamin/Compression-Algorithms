/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmeticcodingfloat;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Manaz
 */
public class ArithmeticCodingFloat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
               FileReader read= new FileReader("float.txt");
            Scanner out =new Scanner(read);
        //FileWriter writer=new FileWriter("number.txt",true);
         RandomAccessFile writer=new RandomAccessFile("number.txt", "rw");
        int count=0;
       ArrayList<Character>x=new ArrayList<>();
      HashMap<Character, Integer> map = new HashMap<Character, Integer>();
      ArrayList<Float>low=new ArrayList<>();
      ArrayList<Float>high=new ArrayList<>();
      ArrayList<Character>c=new ArrayList<>();
     writer.seek(0);
  while(out.hasNext()){
  String y=(out.nextLine());
    for(int i=0;i<y.length();i++){
      
  x.add(y.charAt(i));
    if (map.containsKey(y.charAt(i))){
            map.put(y.charAt(i), map.get(y.charAt(i)) + 1);
         }else{
            map.put(y.charAt(i), 1);
         }
  
   }
  }

     

     count=x.size();
     int i=0;
       float d = 0;
      for (Map.Entry mapElement : map.entrySet()) {
       
   
          if(i==0){
                char key = (char)mapElement.getKey(); 
                 float   value = (int)mapElement.getValue();
                   
               d=value;
                  float w=0;
                  low.add(w);
                  w=value/count;
                  high.add(w);
                  c.add(key);
          
          }else{
            char key = (char)mapElement.getKey(); 
         
          float a=d/count;
          low.add(a);
             float value= (int)mapElement.getValue();
            d+=value;
            a=d/count;
           high.add(a);
         
                c.add(key);
             
          
        }
      
         i++;
      }
     
     
 
     
    for(int q=0;q<c.size();q++){
    
   // System.out.println(c.get(q)+ " "+low.get(q)+" "+high.get(q));
    } 
 
        float lower = 0;
        float upper = 0;
//abac
     for(int w=0;w<x.size();w++){
     for(int r=0;r<c.size();r++){
     if(x.get(w).equals( c.get(r))){
         if(w==0){
             lower=low.get(r);
            upper=high.get(r);
         }else{
      float l= lower;
      float u= upper;
   lower = l+ (u-l) * low.get(r);
   upper= l+(u-l)* high.get(r);

         }
              }
          
          }
     
    }
   float s=(lower+upper)/2;
   
     writer.writeFloat(s);
        System.out.println(s);
        System.out.println(count);
    // writer.write("\n");
     writer.write( count);
     //writer.write("\n");
     for(int r=0;r<c.size();r++){
          writer.writeChar(c.get(r));
         System.out.println(c.get(r)+" "+low.get(r)+" "+high.get(r));
          float w=low.get(r);
          writer.writeFloat(w);
           float ww=high.get(r);
           writer.writeFloat(ww );
     } 
       
     writer.close();
     read.close();
     
    }
    
}
