#include<stdio.h>
//#include<conio.h>
int main()
{
 int p[10];
 int a[10];
 int tt[10];
 int wt[10];
 int n,b[10],i,j;
 int sumn,sumu;
 printf("Enter no. of processes");
 scanf("%d",&n);
 for(i=0;i<n;i++)
 {
 printf("P:");
  scanf("%d",&p[i]); printf("a:");
  scanf("%d",&a[i]); printf("b:");
  scanf("%d",&b[i]);
  }
  /*printf("%d",p[0]);
  printf("%d",p[1]);*/
  for(i=0;i<n;i++)
   {
    printf("PROCESS ORDER : %d\n",p[i]);
    }
  for(i=0;i<n-1;i++)
  {
   for(j=0;j<n-i-1;j++)
   {
    if(a[j]>a[j+1])
    {
     int t= a[j];
      a[j] = a[j+1];
      a[j+1] =t;
      
      int t1= b[j];
      b[j] = b[j+1];
      b[j+1] =t1;
      
      int t2= p[j];
      p[j] = p[j+1];
      p[j+1] =t2;
      
      
     }
    }
   }
   /*for(i=0;i<n;i++)
   {
    printf("PROCESS ORDER : %d\n",p[i]);
    }*/
   sumu=0;
  sumn=b[0]+a[0];
  wt[0]=0;
  tt[0] = b[0];
  
  printf("process : %dwaiting time : %d tt: %d: ", p[0],wt[0],tt[0]);
  for(i=1;i<n;i++)
  {
   sumu = sumn;
int   d= a[i] - sumu;
 if(d<0)
 d=0;
   sumn = sumu + b[i] +d;
   if(sumu < a[i])
   {
    //sumu = 0;
    wt[i] =0;
    
    //printf("HI");
    }
   else{ 
   wt[i]=sumu - a[i];}
   //if(sumn>a[i])
   tt[i]=sumn - a[i];
   //else
   //tt[i] = a[i] - sumn;
   printf("\nprocess %d waiting time %d tt %d :",p[i],wt[i],tt[i]);   
  }
  }
