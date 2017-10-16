#include<iostream.h>
#include<conio.h>
void main()
{ int t=0,q,min,r;
 int a[10],b[10],tt[10],w[10],i,j,f[10];
 int n,p[10],t1,t2,sumu,sumn,t3,s,c[10];
 cout<<"enter pno.of processes";
 cin>>n;
       for(i=0;i<n;i++)
	{ cout<<"enter pid";
	cin>>p[i]; cout<<"enter arrival time:";
	cin>>a[i]; cout<<"Enter burst time";
	cin>>b[i]; f[i]=0;
	}
	for(i=0;i<n;i++)
	{
	 for(j=0;j<n-i;j++)
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
 } cout<<"process:"<<p[0]<<"has waitnig time 0 and tt"<<b[0];
 sumn=a[0]+b[0]; sumu = a[0]+b[0];
 int k = 0;f[0]=1;
 for(j=1;j<n;j++)
 {         t=0; k=0;
   for(i=1;i<n;i++)
 {
    if(a[i]<sumu&&f[i]==0)
    {
     c[k]=i;
    k++; t=1;
    }
 }     if(t==0) q=j; if(k==1&&t==1) q=c[0];
  if(k>1&&t==1)
  { q= c[0]; min = b[q];
   for(s=1;s<k;s++)
   {   r = c[s];
     if(b[r]<min)
     {
       min = b[r];
       q=r;
     }    if(b[r]==min){if(a[q]>a[r]) q=r;}
   }
  }
  sumu = sumn;
  f[q] = 1;
  int d = a[q] - sumu;
  if(d<0)
  d=0;
  sumn = sumu +b[q]+d;
  if(sumu<a[q])
  {
   w[q]=0;
   }
   else
   {
    w[q] = sumu - a[q];
   }
   tt[q]=sumn - a[q];
   cout<<"process is:"<<p[q]<<"w"<<w[q]<<"ttt"<<tt[q];
   }     getch();
   }