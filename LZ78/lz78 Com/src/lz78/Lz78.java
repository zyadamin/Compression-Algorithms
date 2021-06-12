/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lz78;

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
public class Lz78 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
   FileReader read= new FileReader("lz78.txt");
    Scanner out =new Scanner(read);
   FileWriter tag=new FileWriter("tags.txt");
   FileWriter tableFile=new FileWriter("tableFile.txt");
          
  ArrayList<Character>x=new ArrayList<>();
  ArrayList<String>table=new ArrayList<>();
  
  table.add("---");
  
  while(out.hasNext()){
  String y=(out.nextLine());
    
  for(int i=0;i<y.length();i++){  
  x.add(y.charAt(i));
   }
  x.add('\\');
  }

    int key=0,c=0;
    
 String s=null;
 
 for(int i=0;i<x.size();i++){
    
     if(key==0){s=String.valueOf(x.get(i));}
    
    else{s=s+x.get(i);
      c=0;
    }
      
    for(int k=0;k<table.size();k++){
    if(s.equals(table.get(k))){
    key=k;
    c++; 
   }
}
  
if(c==0){
    
      tag.write("<"+key+","+x.get(i)+">\n");
      table.add(s);
       key=0;
}
    
    if(i==x.size()-1){
    tag.write("<"+key+","+" "+">\n");
    }  
    
    }

for(int i=0;i<table.size();i++){

    tableFile.write(table.get(i));
          tableFile.write("\n");
}

  tag.close();
  read.close();
  tableFile.close();

    
    }
    
}
