/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;
import java.util.*;
import java.io.*;
/**
 *
 * @author shivanshsharma
 */
public class firstfit {
   

    /**
     * @param args the command line arguments
     */public static void main(String[] args) {
        // TODO code application logic here
 int i;
int j;
Scanner scan = new Scanner(System.in);
System.out.println("Enter the no. of processes:");
int n = scan.nextInt();
int r[] = new int[n];
System.out.println("Enter no. of Segments");
int l = scan.nextInt();
ArrayList<Integer> list1 = new ArrayList<Integer>();   //MEMORY LIST 
ArrayList<Integer> occupy = new ArrayList<Integer>();
System.out.println("Enter requirement of each process");
for(i=0;i<n;i++)
{
r[i]=scan.nextInt();
}
System.out.println("ENTER MEMORY MAP");
for(i=0;i<l;i++)
{
 j = scan.nextInt(); 
 list1.add(j);
 occupy.add(0);
}
System.out.println("Size of memory map is:" +list1.size());
int t,k,h;
for(j=0;j<n;j++)
{
for(i=0;i<list1.size();i++)
{
     t=list1.get(i);
    System.out.println("NOW MEMORY MAP  HAS:");
   for(k=0;k<list1.size();k++)
   {
       System.out.print(list1.get(k));
       System.out.println("  " +occupy.get(k));
   }
     
     if(r[j]<list1.get(i)&&occupy.get(i)==0)
    {
        occupy.remove(i);
        occupy.add(i,1);
        list1.remove(i);
        list1.add(i,r[j]);
        list1.add(i,t-r[j]);
        occupy.add(i,0);
        
        break;
    }
    if(r[j]==list1.get(i)&&occupy.get(i)==0)
    {
        occupy.remove(i);
        occupy.add(i,1); 
        break;
    }
   
}
}
System.out.println(" MEMORY MAP FINALLY HAS :");
   for(k=0;k<list1.size();k++)
   {
       System.out.print(list1.get(k));
       System.out.println("  " +occupy.get(k));
   }
    
}
}

   
