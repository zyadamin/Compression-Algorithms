/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

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
public class Huffman {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
      
   FileReader read= new FileReader("text.txt");
    Scanner out =new Scanner(read); 
    FileWriter code=new FileWriter("code.txt"); 
   FileWriter tableFile=new FileWriter("tableFile.txt");
        
  ArrayList<Character>text=new ArrayList<>();
       while(out.hasNext()){
  String y=(out.nextLine());
    
  for(int i=0;i<y.length();i++){  
    text.add(y.charAt(i));
   }
  text.add('\\');
  }   
        
        ArrayList<String> strings= new ArrayList<>();
        ArrayList<Integer> intgers= new ArrayList<>();

        
   for(int i=0;i<text.size();i++){
       
     String textHelper=String.valueOf(text.get(i));
     int find=strings.indexOf(textHelper);
       
     
     if(find==-1){
       strings.add(textHelper);
       intgers.add(1);
       }
     
    else{
         
   int add=intgers.get(find);
     strings.remove(find);
     intgers.remove(find);
     
     strings.add(textHelper);
     intgers.add(add+1);
     
     }
   
  }

//a+b++c

 String first="",second="";
 int countFirst=0,countSecond=0;
 ArrayList<Integer>countPlus= new ArrayList<>();
 int sumInt = 0,count=0;
   while(true){
      
    if(intgers.size()==2&&sumInt==0){break;}
       
     count++;  
     
    int min=1000000000,num = 0;
    for(int i=0;i<strings.size();i++){
    if(min>intgers.get(i)){
        min=intgers.get(i);
        num=i;
    } 
    }
  
    sumInt+=intgers.get(num); 
    if(count==1){first=strings.get(num);}
    
    else if(count==2){second=strings.get(num);}
    
    strings.remove(num);
    intgers.remove(num);
    
    if(count==2){
        
     for(int i=0;i<first.length();i++){
    if(first.charAt(i)=='+'){
        countFirst++;
    if(first.charAt(i+1)!='+'){countPlus.add(countFirst);countFirst=0;}
    }
    }
    
    for(int i=0;i<second.length();i++){
    if(second.charAt(i)=='+'){
        countSecond++;
    if(second.charAt(i+1)!='+'){countPlus.add(countSecond);countSecond=0;}
    
    }
    
    }
    
    int max=0;
    for(int j=0;j<countPlus.size();j++){
    if(countPlus.get(j)>max){max=countPlus.get(j);}
    }
    String space="";
    
    for(int i=0;i<max+1;i++){
    space+='+';
    }
    
    intgers.add(sumInt);
    strings.add(first+space+second);
    first=second="";
    sumInt=0;
    count=0;
    countPlus.clear();
    
    
    }
   }
   

        ArrayList<String> coode=new ArrayList<>();
 
        
        divide(strings.get(0),coode,"0",strings);
        
        divide(strings.get(1),coode,"1",strings);
        
        strings.remove(0);
        strings.remove(0);
        

        
       for(int i=0;i<strings.size();i++){
       tableFile.write(strings.get(i)+" "+coode.get(i)+"\n");
   }
       for(int i=0;i<text.size();i++){
       int num=strings.indexOf(String.valueOf(text.get(i)));
         
       code.write(coode.get(num));
       } 
       
       
        code.close();
       tableFile.close();
        }
     
 public static void divide(String x,ArrayList<String> codes,String code,ArrayList<String> charachr){ 
 
 int count=0;
 ArrayList<Integer>countPlus= new ArrayList<>();
 ArrayList<Integer>index= new ArrayList<>();
 for(int i=0;i<x.length();i++){
 if(x.charAt(i)=='+'){count++;
 if(x.charAt(i+1)!='+'){countPlus.add(count);count=0;index.add(i);}
 }
 }
 int max=0,num=0;
 for(int i=0;i<countPlus.size();i++){
 
 if(countPlus.get(i)>max){max=countPlus.get(i);num=index.get(i);}
 
 }
 if(max>0){
     divide(x.substring(0, num-max+1), codes,code+"0",charachr);
     divide(x.substring(num+1,x.length()), codes,code+"1",charachr);
 }
 
 else{codes.add(code);charachr.add(x);}
 }
    
    
}
