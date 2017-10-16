/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compact;

import java.util.*;
import java.io.*;

/**
 *
 * @author shivanshsharma
 */
public class Compact {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i;
int j,k;
int t=0;
int u=0;
 //flag =0  memory not allocated, flag =1 memory not allocated
Scanner scan = new Scanner(System.in);
System.out.println("Enter the no. of processes:");
int n = scan.nextInt();
int r[] = new int[n];
int flag[] = new int[n];  
System.out.println("Enter no. of Blocks:");
int l = scan.nextInt();
ArrayList<Integer> list1 = new ArrayList<Integer>();   //Memory map 
ArrayList<Integer> occupy = new ArrayList<Integer>();  //signify whether place is occupied or not, occuppy=1,unoccupied =0
System.out.println("Enter requirement of each process:");
for(i=0;i<n;i++)
{
 System.out.println("Enter requirement of process:"+(i+1));
r[i]=scan.nextInt();
}
System.out.println("Enter Size of each block");
for(i=0;i<l;i++)
{
    
 j = scan.nextInt(); 
 list1.add(j);
 occupy.add(0);
}


for(j=0;j<n;j++)
{ flag[j] =0;
  System.out.println("NOW MEMORY MAP  HAS:");
  System.out.println("MEMORY SEGMENT   PROCESS ID:");
   for(k=0;k<list1.size();k++)
   {
       System.out.print(list1.get(k));           //display each block
       System.out.println("                " +occupy.get(k));  // occupied =1, unoccupied=0
   } 
     
for(i=0;i<list1.size();i++)
{
     t=list1.get(i);
    
     if(r[j]<list1.get(i)&&occupy.get(i)==0)            // fragment with size less than required by 
    {
        occupy.remove(i);                               //updates occupy 
         occupy.add(i,0);
        list1.remove(i);
                                     //fragments memory into 2 parts - 1.occupied 2.leftover
        list1.add(i,t-r[j]);
        list1.add(i,r[j]); 
        occupy.add(i,j+1);
       
        flag[j] =1;                                       //memory allocated
        break;
    }
    if(r[j]==list1.get(i)&&occupy.get(i)==0)               
    {
        occupy.remove(i);                           //updates occupy 
        occupy.add(i,j+1); 
        flag[j]=1;                                     //memory allocated
        break;
        
    }
   
}
if(flag[j]==0)                                             //if no memory allocated
System.out.println("PROCESS"+(j+1)+" COULD NOT BE ALLOCATED MEMORY");
}

System.out.println(" MEMORY MAP FINALLY HAS :");
 System.out.println("MEMORY SEGMENT   PROCESS ID:");
   for(k=0;k<list1.size();k++)
   {
       System.out.print(list1.get(k));           //display each block
       System.out.println("                " +occupy.get(k));  // occupied =1, unoccupied=0
   } 
  
   System.out.println("DOING COMPACTION:");
   int chance =0;
   j=0;
 for(i=0;i<list1.size();i++)
 {
     
     //System.out.println("  occupy:" +occupy.get(i)); 
     //System.out.println("VALUE OF J:"+j);
     if(occupy.get(i)==0)
     {
         if(i==0)
         {  //System.out.println("CASE 1");
             chance++;}
         else
         {
             
            if(occupy.get(i)==0)
            {chance++; //System.out.println("CASE 2");
            
            }
         }
         }
        
     
     //System.out.println("VALUE OF CHANCE IS:"+chance);
     if(occupy.get(i)!=0||(i==(list1.size()-1)))
     {   u=0;
         if(chance>1&&(i!=(list1.size()-1)))
         {  //System.out.println("IN CAXE X");
             for(k=i-1;k>=i-chance;k--)
             {
                 //System.out.println("VALUE OF K IS:"+k);
               u=u+list1.get(k);
               list1.remove(k);
               occupy.remove(k);
               
             }
             i=i-chance+1;
             list1.add(k+1,u);
             occupy.add(k+1,0);
             
         }
         if(i==(list1.size()-1))
         {
            // System.out.println("IN CASE Y:");
             if(occupy.get(i)==0&&chance>1)
             { //System.out.println("LAST PLACE IS UNOCCUPIED");
                 for(k=i;k>i-chance;k--)
                { //System.out.println("VALUE OF K IS:"+k);
                  u=u+list1.get(k);
                  list1.remove(k);
                  occupy.remove(k);
               
                 }
             list1.add(k+1,u);
             occupy.add(k+1,0);
             chance=0;
             }
             i=list1.size()-1;
              if((occupy.get(i)!=0)&&chance>1)
              {  // System.out.println("LAST PLACE IS OCCUPIED");
                  for(k=i-1;k>=i-chance;k--)
                  { //System.out.println("VALUE OF K IS:"+k);
                     u=u+list1.get(k);
                     list1.remove(k);
                      occupy.remove(k);
               
                   }
                 list1.add(k+1,u);
                 occupy.add(k+1,0);
              }
         }
         
       
         chance=0;
     }
     
 }
  

System.out.println(" MEMORY MAP On segmentation has :");
 System.out.println("MEMORY SEGMENT   PROCESS ID:");
   for(k=0;k<list1.size();k++)
   {
       System.out.print(list1.get(k));           //display each block
       System.out.println("                " +occupy.get(k));  // occupied =1, unoccupied=0
   } 

 
   for(j=0;j<n;j++)
{  
  System.out.println("NOW MEMORY MAP  HAS:");
  System.out.println("MEMORY SEGMENT   PROCESS ID:");
   for(k=0;k<list1.size();k++)
   {
       System.out.print(list1.get(k));           //display each block
       System.out.println("                " +occupy.get(k));  // occupied =1, unoccupied=0
   } 
  if(flag[j]==0)
  {
 for(i=0;i<list1.size();i++)
 {
     t=list1.get(i);
    
     if(r[j]<list1.get(i)&&occupy.get(i)==0)            // fragment with size less than required by 
    {
        occupy.remove(i);                               //updates occupy 
         occupy.add(i,0);
        list1.remove(i);
                                     //fragments memory into 2 parts - 1.occupied 2.leftover
        list1.add(i,t-r[j]);
        list1.add(i,r[j]); 
        occupy.add(i,j+1);
       
        flag[j] =1;                                       //memory allocated
        break;
    }
    if(r[j]==list1.get(i)&&occupy.get(i)==0)               
    {
        occupy.remove(i);                           //updates occupy 
        occupy.add(i,j+1); 
        flag[j]=1;                                     //memory allocated
        break;
        
    }
   
}
}
if(flag[j]==0)                                             //if no memory allocated
System.out.println("PROCESS"+(j+1)+" COULD NOT BE ALLOCATED MEMORY");
}
   
   System.out.println("AT THE END MEMORY MAP HAS:");
  System.out.println("MEMORY SEGMENT   PROCESS ID:");
   for(k=0;k<list1.size();k++)
   {
       System.out.print(list1.get(k));           //display each block
       System.out.println("                " +occupy.get(k));  // occupied =1, unoccupied=0
   } 
   


    }
    
    
}
