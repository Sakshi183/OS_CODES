/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author shivanshsharma
 */
public class Optimal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
               Scanner scan = new Scanner(System.in);
        int total,n;
        int e=0,i,y;
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        
         System.out.println("ENTER TOTAL  NO. OF FRAMES IN MEMORY: ");
         n = scan.nextInt();
         int f[] = new int [n];
         int check[]= new int[n];
         System.out.println("ENTER THE  TOTAL NO. OF PAGES IN SEQUENCE:");
          e = scan.nextInt();
         System.out.println("Enter page no.");
         for(i=0;i<e;i++)
         {
           y = scan.nextInt();  
            list1.add(y);
         }
            for(i=0;i<n;i++)
            check[i]=e+2;             // initialize the position at 12 
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
             
             if(t==0)           //if there is an unoccupied frame
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
             int min=0;
               if(u==0&&t==0)
               {
                   for(int j=i+1;j<e;j++)       // if all  frames used
                   {
                       for(int d =0;d<n;d++)
                       {
                           if((f[d]==list1.get(j))&&check[d]==e+2)
                               check[d]=j+1;
                       }
                   
                   }
                   
                 
                 
                   for(int d=0;d<n;d++)    // finding the optimal page 
                   {
                    
                        if(check[d]>check[min])
                            min =d;
                      
                   }
                   System.out.println("THE PAGE TO BE REPLACED HAS NO.:"+f[min]);
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
                     check[d]=e+2;
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
