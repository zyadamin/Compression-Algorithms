/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryde;

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
public class BInaryDe {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader read= new FileReader("C:\\Users\\zezoa\\Desktop\\floatingBinary\\code.txt");
        FileWriter write= new FileWriter("text.txt");

          Scanner input= new Scanner(read);
          
          int count=input.nextInt();     //number of chars in original  text
          
          int numberOfLines=input.nextInt();   // number of lines take from file
          
      ArrayList<Character> chars= new ArrayList<>();  
      
      ArrayList<Float>lowRange=new ArrayList<>();
      ArrayList<Float>highRange=new ArrayList<>();
      
      ArrayList<Float>upper=new ArrayList<>();
      ArrayList<Float>lower=new ArrayList<>();
      
    

     for(int i=0;i<numberOfLines;i++){
       String  x;
       x=input.next();
       chars.add(x.charAt(0));
 
       float y=input.nextFloat();
       lowRange.add(y);
       
      float za=input.nextFloat();
      highRange.add(za);
      }
        
        
     String code=input.next();
     
     for(int i=0;i<chars.size();i++){
     
       System.out.println(chars.get(i)+"  "+lowRange.get(i)+"  "+highRange.get(i));
     }

     
   float min=1000;
   for(int i=0;i<chars.size();i++){
   
   float u=highRange.get(i)-lowRange.get(i);
   if(u<min){min=u;}
   }
   
   
   int k=0;
   while(1/Math.pow(2, k)>=min){
   k++;
   }
   
        System.out.println("K "+k );
   int limit=0;
   float L,U;
  // System.out.println("code  "+code);
   for(int i=0;i<count;i++){
       
   String mycode=code.substring(limit, limit+k);
     System.out.println("mycode "+mycode);
   
   float decimal=Integer.parseInt(mycode,2);   // convert to float 
   
   decimal=(float) (decimal/(Math.pow(2, k)));

   if(i>=1){
   decimal=((decimal-lower.get(i-1))/(upper.get(i-1)-lower.get(i-1)));
   }       
   
    System.out.println("decimal "+decimal);
   int j=0;
   for(;j<chars.size();j++){
   if(decimal>=lowRange.get(j)&&decimal<=highRange.get(j)){
   break;
   }
   }
   

      System.out.println("char "+chars.get(j));
   write.write(chars.get(j));
   
   
   
  if(i>=1){
     L=lower.get(i-1)+((upper.get(i-1)-lower.get(i-1)))*lowRange.get(j);
     U=lower.get(i-1)+((upper.get(i-1)-lower.get(i-1)))*highRange.get(j);
  
  }
  else{
      L=lowRange.get(j);
      U=highRange.get(j);
  }
  
  
  while(true){
      if(U>=0.5&&L>=0.5){
     System.out.println("second");   
        limit++;
         U=(U-0.5f)*2;
         L=(L-0.5f)*2;
      }
      else if(U<=0.5f&&L<=0.5f){
       limit++; 
       U*=2;
       L*=2;
     System.out.println("first");   

      
      }
      else{break;}
      
  }
  
  lower.add(L);
  upper.add(U);
  
    //   System.out.println("lower "+L);
  //     System.out.println("upper "+U);
       
  
  }



write.close();
   

    }
    
}


/*
         for(int i=0;i<chars.size();i++){
             System.out.println(chars.get(i)+"  "+lowRange.get(i)+"    "+highRange.get(i));
  
    }
*/