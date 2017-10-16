#include<pthread.h>
#include<stdio.h>
 int a[3],b[3],x[3];
void*func(void *l)
 {  int j =(int)l;
 
   // printf("%d   %d",a[j],b[j]);
 	
 	x[j]=a[j]*b[j];
 	printf("%d \n in func:",x[j]);
 	pthread_exit(NULL);
 
 
 }
void main()
{
int i;
   
	for( i =0;i<3;i++)
	{
		a[i]=i+1;
	}
	
	for( i =0;i<3;i++)
	{
		b[i]=i+2;
	}
 pthread_t th[3];
 for(i=0;i<3;i++)
 {
 
  int r = pthread_create(&th[i],NULL,func,(void*)i);
 

 printf("in main: %d",x[i]);
 
 
}
 
 pthread_exit(NULL);
 
 
 }
 
