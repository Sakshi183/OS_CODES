/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifo;
import java.util.*;

/**
 *
 * @author shivanshsharma
 */
public class Fifo {

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
         int f[] = new int [n];   // main memory divided into frames 
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
             for(int k=0;k<n;k++)
              {
              
               if(f[k]==list1.get(i))      //if it is already present in memory
               t=1;
              }
             
             if(t!=1) 
             {
             for(int k=0;k<n;k++)        //if there is an unoccupied frame
              {
               if(f[k]==0)
               {f[k]=list1.get(i);
               u=1;
               break;
               }
              }
               if(u==0)
               {
                   for(int j=0;j<n-1;j++)     //if it is full then remove the first one and add at last
                   {
                       f[j]=f[j+1];
                   }
                   f[n-1]=list1.get(i);
                   
               }
             }
               System.out.println("NOW FRAMES HAVE:");
               System.out.println("FRAME NO. PAGE NO.");
               for(int q = 0;q<n;q++)
               {
                   System.out.println(q+"  :  "+f[q]);
               }
      
                 
         }
         System.out.println("FRAMES FINALLY HAVE:");
         System.out.println("FRAME NO.  PAGE NO.");
         for(int q = 0;q<n;q++)
               {
                   System.out.println(q+"  :  "+f[q]);
               }
      
         
         
         
         
         
    }
    
}
