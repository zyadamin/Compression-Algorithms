/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lz77;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Home
 */
public class Lz77 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        ArrayList<Integer> index=new ArrayList();
        ArrayList<Integer> keys=new ArrayList();

        FileReader read= new FileReader("lz.txt");
            Scanner out =new Scanner(read);

        
   ArrayList<Character>x=new ArrayList<>();

  while(out.hasNext()){
  String y=(out.nextLine());
    for(int i=0;i<y.length();i++){  
    x.add(y.charAt(i));
   }
    x.add('\\');
  }

        

            FileWriter fout = null;
      
         fout = new FileWriter("lz77.txt");
    
        int count=0,same=0;
        for(int i=0;i<x.size();i++){
        
            if(i==0){      
              fout.write("<"+0+","+0+","+x.get(i)+">\n");
              continue;
            }
         
        for(int j=i-1;j>=0;j--){
        
            if(x.get(i)==x.get(j)){index.add(j);}
               count++;
            if(count==256){break;}    
        }
   
        
         if(index.isEmpty()){fout.write("<"+0+","+0+","+x.get(i)+">\n");}

        else{
             
        for(int j=0;j<index.size();j++){
            for(int k=1;i+k<x.size();k++){
             if(index.get(j)+k==i||same==255){break;}
             if(x.get(index.get(j)+k)==x.get(i+k)){same++;}
         
             else{break;}   
             }
  
             keys.add(same);
             same=0;
            }
          
       int max=0,num=0; 
       for(int m=0;m<keys.size();m++){
       if(max<keys.get(m)){
       max=keys.get(m);
       num=m;
       }
       }
       
       char next=' ';       
       if(i+max+1<x.size()){
       next=x.get(i+max+1);
       
       }
    
        
            fout.append("<"+(i-index.get(num))+","+(max+1)+","+next+">\n");
                  
             i=i+max+1;
             
                
        keys.clear();
        index.clear();
        count=0;
        same=0;
        }
        
       
    }
        
           fout.close();
         
    }
       
}
   /*  ABAABABAABBBBBBBBBBBBA  */ 