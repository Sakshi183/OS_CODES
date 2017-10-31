import java.io.*;
import java.util.*;
class t{
public static void main(String args[])
{ int q,min,r;
Scanner scan = new Scanner(System.in);
 LinkedList <Integer> qu = new LinkedList<Integer>();//to store process
 int a[]=new int[10];//arrival time
 
  int b[]=new int[10];//burst time
  int tt[]=new int[10];//turn around time
  int jn[] = new int[10];//used to calculate waiting time
 int w[]=new int[10];//waiting time
 
 int f[]=new int[10];//to judge whethter object has come in queue

 int p[]=new int[10];// process id

 int i,j;
 int n,t1,t2,sumn,t3,s=0;
 System.out.println("enter pno.of processes");
 n=scan.nextInt();
       for(i=0;i<n;i++)
	{ System.out.println("Enter process id:");
	   p[i]=scan.nextInt();
	   System.out.println("enter arrival time:");
	   a[i]=scan.nextInt();
	   System.out.println("enter burst time:");
	   b[i]=scan.nextInt();  
	   f[i]=-1; 
	   jn[i]=-1;
	}
	for(i=0;i<n;i++)
	{
	 for(j=0;j<n;j++)
	 {
	if(a[i]<a[j])
	{t1=p[i];
	p[i]=p[j];
	  p[j]=t1;
	t2=a[i];
	a[i]=a[j];
	a[j]=t2;
	t3=b[i];
	b[i]=b[j];
	b[j]=t3;
    }
  }
 }
 int e=0;//total process completed
sumn=a[0];
q=0;
qu.add(0);   //add first process
int slice = 3;
int flag = 0;
while(e!=n)
{


	//l=qu.size();
	if(qu.size()>0)
	{
	q = qu.pollFirst();
	}

	else 
	{
		if(flag!=0)     //nothing in queue but will not execute in very first proccess
		{   int small = a[0];
		for(i=0;i<n;i++)
		{
			if(a[i]>small&&f[i]==-1)
			{
				q=i;
				break;
			}
		}
 //System.out.println("sum now when elle is:"+sumn);  
   
  //qu.addLast(q);
  //q=qu.pollFirst();
  sumn= a[q];
  w[q]=a[q]-sumn;
  jn[q]=0;
  f[q]=0;
		}
	}
 
 
 //System.out.println("sum now after elle is:"+sumn);  
 
 flag =1; //t orespond that queue to first  is not empty due to first one

	if(jn[q]==-1)    //process comes first time
	{
	f[q]=0;
	jn[q]=0;
	w[q]=sumn- a[q];
	}
   
 

if(b[q]<=slice&&f[q]==0)  //if burst time is less then slice
{
sumn = sumn + b[q] ;
f[q]=1;
tt[q]=sumn - a[q];
 b[q]=0;
 System.out.print("process completed");
  e++;
}
else if(b[q]>slice&&f[q]==0)   //if burst time is more then slice
{
  b[q]=b[q]-slice;
  sumn = sumn+ slice ;
}



for(i=0;i<n;i++)                     // adding processes in queue
{
   if(a[i]<=sumn&&f[i]==-1)
   {
    qu.addLast(i);
	f[i]=0;
	
	w[i]=sumn- a[i];
   }
}


if(f[q]!=1)
qu.addLast(q);                           //if proccess not complete add further

      for(i=0;i<n;i++)
	  { s=0;  
        if(f[i]==1)
        {  s=1;    }
	   }
}
    
   for(i=0;i<n;i++)
   {
     System.out.println("process id: "+p[i]);
     System.out.println("waiting time:"+w[i]);
	 
     System.out.println(" tt:"+tt[i]);
    } 
}
	 
	 }
