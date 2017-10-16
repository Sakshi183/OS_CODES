/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lru;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author shivanshsharma
 */
public class Lru {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int total,n;
        int e=0,i,y;
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        
         System.out.println("ENTER TOTAL  NO. OF FRAMES IN MEMORY: ");
         n = scan.nextInt();
         int f[] = new int [n];                       //main memory divided into frame
         int check[]= new int[n];
        System.out.println("ENTER THE  TOTAL NO. OF PAGES IN SEQUENCE:"); 
          e = scan.nextInt();
         System.out.println("Enter page no.");
         for(i=0;i<e;i++)
         {
           y = scan.nextInt();  
            list1.add(y);
         }
         int u=0,t=0;
         for(i=0;i<e;i++)
         {
             u=0;
             t=0;
             for(int k=0;k<n;k++)   //if it is already present in memory
              {
              
               if(f[k]==list1.get(i))
               t=1;
              }
                                            //if there is an unoccupied frame
             {
              for(int k=0;k<n;k++)
               {
                if(f[k]==0)
                {f[k]=list1.get(i);
                 u=1;
                 break;
                }
               }
             }
               if(u==0&&t==0)
               {
                   for(int j=i-1;j>=0;j--)      // if all  frames used
                   {
                       for(int d =0;d<n;d++)         //finding the position of each page which is in frame
                       {
                           if((f[d]==list1.get(j))&&check[d]==0)
                               check[d]=j+1;
                       }
                   
                   }
                   
                 
                 int min =0;
                   for(int d=0;d<n;d++)              
                   {
                      
                        if(check[d]<check[min])        //finding lru
                            min =d;
                      
                   }
                   System.out.println("PAGE TO BE REPLACED HAS NO.:"+f[min]);
                   f[min]=list1.get(i);
                   
                   
                   
               }
               
             
               System.out.println("NOW FRAMES HAVE:");
               System.out.println("FRAME NO. PAGE NO.");
               for(int q = 0;q<n;q++)
               {
                   System.out.println(q+"  :  "+f[q]);
               }
      
           
                 for(int d=0;d<n;d++)
                 {
                     check[d]=0;              //initialize the position by default 0
                 }
         }
      
         System.out.println("FRAMES FINALLY HAVE:");
         System.out.println("FRAME NO. PAGE NO.");
               for(int q = 0;q<n;q++)
               {
                   System.out.println(q+"  :  "+f[q]);
               }
         
         
    }
    
}
