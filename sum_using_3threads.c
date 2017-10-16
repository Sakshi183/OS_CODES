#include<pthread.h>
#include<stdio.h>
int x=0; int a[9];
void*func(void *l1)
 {  int l =(int)l1;
 	int j,k=0;
 	for(j=l;k<3;j++,k++)
 	{
 		x = x+a[j];
	 }
	 printf("hi......%d\n",a[j]);
 	pthread_exit(NULL);
 
 
 }
void main()
{
int i , low=0;
   
	for( i =0;i<9;i++)
	{
		a[i]=i+1;
	}
	
 pthread_t th[3];
 for(i=0;i<3;i++)
 {
 
  int r = pthread_create(&th[i],NULL,func,(void*)low);
 

 printf("once %d",x);
 low=low+3;
 //high=high+3;
}
 
 /*pthread_create(&th1,NULL,func(low,high),NULL);
 
 pthread_join(th1,NULL);
 
 printf("twice %d",x);
 low=low+3;
 high=high+3;
 
 pthread_create(&th2,NULL,func(low,high),NULL);
 
 pthread_join(th2,NULL);
 
 printf("thrice %d",x);
 */
 pthread_exit(NULL);
 
 
 }
 
