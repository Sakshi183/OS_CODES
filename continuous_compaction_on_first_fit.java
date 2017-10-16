/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author shivanshsharma
 */
public class JavaApplication13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
              // TODO code application logic here
        int i;
int j,k;
int t=0;
int u=0;

//PROCESS ID :0 IMPLIES THAT MEMORY BLOCK IS FREE
Scanner scan = new Scanner(System.in);
System.out.println("Enter the no. of processes:");
int n = scan.nextInt();
int r[] = new int[n];
int flag[] = new int[n];   //for a process flag =0  memory not allocated, flag =1 memory  allocated
int flag2[]=new int[n];

System.out.println("Enter no. of Blocks:");
int l = scan.nextInt();
ArrayList<Integer> list1 = new ArrayList<Integer>();   //Memory map 
ArrayList<Integer> occupy = new ArrayList<Integer>();  //signify whether place is occupied or not, occuppy=1,unoccupied =0
ArrayList<Integer> list2 = new ArrayList<Integer>();   //Memory map 
ArrayList<Integer> occupy2 = new ArrayList<Integer>();  //signify whether place is occupied or not, occuppy=1,unoccupied =0
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

System.out.println("PLEASE NOTE THAT PROCESS ID :0 IMPLIES THAT MEMORY BLOCK IS FREE");
for(j=0;j<n;j++)
{ flag[j] =0;
  System.out.println("NOW MEMORY MAP  HAS:");
  System.out.println("MEMORY SEGMENT   PROCESS ID:");
   for(k=0;k<list1.size();k++)
   {
       System.out.print(list1.get(k));           //display each block
       System.out.println("                " +occupy.get(k));  // occupied =pid, unoccupied=0
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

System.out.println(" MEMORY MAP  ON DOING FIRST FIT :");
 System.out.println("MEMORY SEGMENT   PROCESS ID:");
   for(k=0;k<list1.size();k++)
   {
       System.out.print(list1.get(k));           //display each block
       System.out.println("                " +occupy.get(k));  // occupied =pid, unoccupied=0
       list2.add(k,list1.get(k));
       occupy2.add(k,occupy.get(k));
   } 
  for(j=0;j<n;j++)
      flag2[j]=flag[j];
   
   
   
   //CONTINUOUS COMPACTION
   System.out.println("CONTINUOUS COMPACTION :");
 for(i=0;i<list1.size();i++)               
 {
     if(occupy.get(i)==0)
     {
         u=u+list1.get(i);
         list1.remove(i);
         occupy.remove(i);
         i--;
     }
     
 }
 
 list1.add(list1.size(),u);
 occupy.add(occupy.size() ,0);
 
 System.out.println("AFTER  DOING  COMPACTION ");
  System.out.println("MEMORY SEGMENT   PROCESS ID:");
   for(k=0;k<list1.size();k++)
   {
       System.out.print(list1.get(k));           //display each block
       System.out.println("                " +occupy.get(k));  // occupied =pid, unoccupied=0
   } 
 
 
 System.out.println("NOW APPLYING FIRST FIT AGAIN: ");
 
for(j=0;j<n;j++)
{ 
  System.out.println("NOW MEMORY MAP  HAS:");
  System.out.println("MEMORY SEGMENT   PROCESS ID:");    
for(k=0;k<list1.size();k++)
   {
       System.out.print(list1.get(k));           //display each block
       System.out.println("                " +occupy.get(k));  // occupied =pid, unoccupied=0
   } 
     t=list1.get((list1.size()-1));
    
     if(r[j]<list1.get((list1.size()-1))&&occupy.get(list1.size()-1)==0&&flag[j]==0)            // fragment with size less than required by 
    {
           occupy.remove((list1.size()-1));                               //updates occupy 
         occupy.add((list1.size()-1),0);
        list1.remove((list1.size()-1));
                                     //fragments memory into 2 parts - 1.occupied 2.leftover
        list1.add((list1.size()-1),t-r[j]);
        list1.add((list1.size()-1),r[j]); 
        occupy.add((list1.size()-1),j+1);
       
        flag[j] =1;                                      //memory allocated
        break;
    }
     if(r[j]==list1.get((list1.size()-1))&&occupy.get(list1.size()-1)==0&&flag[j]==0)              
    {
        occupy.remove((list1.size()-1));                           //updates occupy 
        occupy.add((list1.size()-1),j+1); 
        flag[j]=1;                                     //memory allocated
        break;
        
    }
   

if(flag[j]==0)                                             //if no memory allocated
System.out.println("PROCESS"+(j+1)+" COULD NOT BE ALLOCATED MEMORY EVEN AFTER COMPACTION ");
}
System.out.println(" MEMORY MAP AFTER CONTINUOUS COMPACTION HAS :");
 System.out.println("MEMORY SEGMENT   PROCESS ID:");
   for(k=0;k<list1.size();k++)
   {
       System.out.print(list1.get(k));           //display each block
       System.out.println("                " +occupy.get(k));  // occupied =pid, unoccupied=0
   } 

   
   


//ADJACENT COMPACTION
   System.out.println("ADJACENT COMPACTION:");
   System.out.println(" MEMORY MAP FINALLY HAS :");
 System.out.println("MEMORY SEGMENT   PROCESS ID:");
   for(k=0;k<list2.size();k++)
   {
       System.out.print(list2.get(k));           //display each block
       System.out.println("                " +occupy2.get(k));  // occupied =pid, unoccupied=0
   } 
  
  
   int chance =0;
   j=0;
 for(i=0;i<list2.size();i++)                         //compaction
 {
     if(occupy2.get(i)==0)
     {
         if(i==0)
         {  
             chance++;}
         else
         {
             
            if(occupy2.get(i)==0)
            {chance++; 
            
            }
         }
         }
        
     
   
     if(occupy2.get(i)!=0||(i==(list2.size()-1)))
     {   u=0;
         if(chance>1&&(i!=(list2.size()-1)))
         {  
             for(k=i-1;k>=i-chance;k--)
             {
              
               u=u+list2.get(k);
               list2.remove(k);
               occupy2.remove(k);
               
             }
             i=i-chance+1;
             list2.add(k+1,u);
             occupy2.add(k+1,0);
             
         }
         if(i==(list2.size()-1))
         {
           
             if(occupy2.get(i)==0&&chance>1)
             { 
                 for(k=i;k>i-chance;k--)
                { 
                  u=u+list2.get(k);
                  list2.remove(k);
                  occupy2.remove(k);
               
                 }
             list2.add(k+1,u);
             occupy2.add(k+1,0);
             chance=0;
             }
             i=list2.size()-1;
              if((occupy2.get(i)!=0)&&chance>1)
              { 
                  for(k=i-1;k>=i-chance;k--)
                  { 
                     u=u+list2.get(k);
                     list2.remove(k);
                      occupy2.remove(k);
               
                   }
                 list2.add(k+1,u);
                 occupy2.add(k+1,0);
              }
         }
         
       
         chance=0;
     }
     
 }
  

System.out.println(" Memory Map On compaction  has :");
 System.out.println("MEMORY SEGMENT   PROCESS ID:");
   for(k=0;k<list2.size();k++)
   {
       System.out.print(list2.get(k));           //display each block
       System.out.println("                " +occupy2.get(k));  // occupied =pid, unoccupied=0
   } 

 
   for(j=0;j<n;j++)
{  
  System.out.println("NOW MEMORY MAP  HAS:");
  System.out.println("MEMORY SEGMENT   PROCESS ID:");
   for(k=0;k<list2.size();k++)
   {
       System.out.print(list2.get(k));           //display each block
       System.out.println("                " +occupy2.get(k));  // occupied =pid, unoccupied=0
   } 
  if(flag2[j]==0)
  {
 for(i=0;i<list2.size();i++)
 {
     t=list2.get(i);
    
     if(r[j]<list2.get(i)&&occupy2.get(i)==0)            // fragment with size less than required by 
    {
        occupy2.remove(i);                               //updates occupy 
         occupy2.add(i,0);
        list2.remove(i);
                                     //fragments memory into 2 parts - 1.occupied 2.leftover
        list2.add(i,t-r[j]);
        list2.add(i,r[j]); 
        occupy2.add(i,j+1);
       
        flag2[j] =1;                                       //memory allocated
        break;
    }
    if(r[j]==list2.get(i)&&occupy2.get(i)==0)               
    {
        occupy2.remove(i);                           //updates occupy 
        occupy2.add(i,j+1); 
        flag2[j]=1;                                     //memory allocated
        break;
        
    }
   
}
}
if(flag2[j]==0)                                             //if no memory allocated
System.out.println("PROCESS"+(j+1)+" COULD NOT BE ALLOCATED MEMORY");
}
   
   System.out.println("AT THE END AFTER ADJACENT COMPACTION  MEMORY MAP HAS:");
  System.out.println("MEMORY SEGMENT   PROCESS ID:");
   for(k=0;k<list2.size();k++)
   {
       System.out.print(list2.get(k));           //display each block
       System.out.println("                " +occupy2.get(k));  // occupied =pid , unoccupied=0
   } 
   


    }
    
    
}