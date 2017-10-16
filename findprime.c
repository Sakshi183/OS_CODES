#include<pthread.h>
#include<stdio.h>
int x=0; int a[100];
int p [3];
void*func(void *l1)
 {  int l =(int)l1;
 	int j,k=0;
 	int h,i;
 	if(l!=66)
 	h=l + 33;
 	else
 	{
	 h=99;
	 }
 	p[x]=1;
 	for(j=l;j<=h;j++)
 	{
 		for(i=1;i<j;i++)
 		{
 			if((a[j]%i)==0)
 			{
			 a[j]=-1;
 			 printf("yes%d",j);}
		  }
	 }
	 //printf("hi......%d\n",p[x]);
 //	pthread_exit(NULL);
 
 
 }
void main()
{
int i , low=0;
   
	for( i =0;i<99;i++)
	{
		a[i]=i+1;
	}
	
 pthread_t th[3];
 for(i=0;i<3;i++)
 {
 
  int r = pthread_create(&th[i],NULL,func,(void*)low);
 

 //printf("once %d",x);
 low=low+34;
 //high=high+3;
}
for(i=0;i<3;i++)
{
	pthread_join(th[i],NULL);
	
}

//printf("%d",z);
}
 
