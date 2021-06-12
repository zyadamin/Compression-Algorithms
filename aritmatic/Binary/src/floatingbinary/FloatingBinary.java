/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package floatingbinary;

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
public class FloatingBinary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

         ArrayList<Character>text=new ArrayList<>();
      
         ArrayList<Float>lowRange=new ArrayList<>();
         ArrayList<Float>highRange=new ArrayList<>();
      
         ArrayList<Float>upper=new ArrayList<>();
         ArrayList<Float>lower=new ArrayList<>();

         FileWriter write= new FileWriter("code.txt");

         FileReader read= new FileReader("text.txt");
         Scanner input= new Scanner(read);
        
          ArrayList<Integer>code=new ArrayList<>();
    
          
           while(input.hasNext()){
              String y=(input.nextLine());
               for(int i=0;i<y.length();i++){  
                text.add(y.charAt(i));
   }
 // text.add('\\');
  }   

        
        ArrayList<Character> chars= new ArrayList<>();
        ArrayList<Float> count= new ArrayList<>();     
        
              
   for(int i=0;i<text.size();i++){
       
     char textHelper=text.get(i);
     float find=chars.indexOf(textHelper);
       
     
     if(find==-1){
       chars.add(textHelper);
       count.add(1f);
       }
     
    else{
         
   float add=count.get((int)find);
     chars.remove((int)find);
     count.remove((int)find);
     
     chars.add((int)find,textHelper);
     count.add((int)find,add+1);
     
     }
   
  }
   
lowRange.add(0f);
highRange.add(count.get(0)/text.size());
   
   for(int i=1;i<chars.size();i++){
   
   lowRange.add(highRange.get(i-1));
   highRange.add(highRange.get(i-1)+(count.get(i)/text.size()));    
   }
   
   
   float min=1000;
   for(int i=0;i<count.size();i++){
   
   float u=highRange.get(i)-lowRange.get(i);
   if(u<min){min=u;}
   }
   
  // System.out.println("min "+min);
   
   int k=0;
   while(1/Math.pow(2, k)>=min){
   k++;
   }
   
  System.out.println("K "+k);
   
        
   float L,U;

   for(int i=0;i<text.size();i++){
      int find = 0;
       char textHelper=text.get(i);
    find=chars.indexOf(textHelper);
      if(i>=1){

    //  System.out.println("char "+textHelper+"  "+find);
     L=lower.get(i-1)+((upper.get(i-1)-lower.get(i-1)))*lowRange.get(find);
     U=lower.get(i-1)+((upper.get(i-1)-lower.get(i-1)))*highRange.get(find);
  
  }
  else{
  
      
   //   System.out.println("char "+textHelper+"  "+find);
      L=lowRange.get(find);
      U=highRange.get(find);
  }
  
     //  System.out.println("lower "+L);
     //  System.out.println("upper "+ U);

  while(true){
      if(U>=0.5f&&L>=0.5f){
        //second case   
          System.out.println("second");

          
      code.add(1);
          U=(U-0.5f)*2;
          L=(L-0.5f)*2;
    //  System.out.println("lower "+L);
     //  System.out.println("upper "+ U);    
      }
      else if(U<=0.5f&&L<=0.5f){
      code.add(0);
      U*=2;
      L*=2;
          System.out.println("first");
    //System.out.println("lower "+L);
      // System.out.println("upper "+ U);
      
      }
      else{break;}
      
  }
  
  lower.add(L);
  upper.add(U);
  
  }
         write.write(text.size()+"\n");
         write.write(chars.size()+"\n");


  
 for(int i=0;i<chars.size();i++){
 write.write(chars.get(i)+"\n"+lowRange.get(i)+"\n"+highRange.get(i)+"\n");
  
    }
    

   for(int i=0;i<code.size();i++){
       
   write.write(code.get(i)+"");
      
   }
   write.write("1");
   for(int i=0;i<k-1;i++){
   
      write.write("0");

   
   }
        
write.close();


     for(int i=0;i<chars.size();i++){
     
     //    System.out.println(chars.get(i)+"  "+lowRange.get(i)+"  "+highRange.get(i));
       //  System.out.println("mins "+(highRange.get(i)-lowRange.get(i)));
     }

     for(int i=0;i<code.size();i++){
         System.out.print(code.get(i));
     }
     
    }
    
}
