#include<stdio.h>
#include<string.h>
#include<pthread.h>
#include<stdlib.h>
#include<unistd.h>
int counter;
int p[1][16];
int q[16][1]; // p transpose
int sum=0;
pthread_mutex_t lock;

void* func(void *y)
{
   int tsum =0;	
	int l = (int)y;
   
  int i;
  for( i=0;i<4;i++)
  {
  	tsum = tsum + p[0][l+i]*q[l+i][0];
  }
     
      pthread_mutex_lock(&lock);
      sum = sum +tsum;
    pthread_mutex_unlock(&lock);
     printf("TSUM IS : %d",tsum);
    printf("SUM IS : %d",sum);

}

int main()
{
    int i = 0;
    int j=0;
    pthread_t th[4];
    pthread_mutex_init(&lock, NULL);
    for(i=0;i<16;i++)
    {
    
    	p[0][i]=i;
    	q[i][0]=i;
	}
   

   for(i=0;i<4;i++)
    {
	
        pthread_create(&(th[i]), NULL, func, (void*)j);
        j=j+4;
    }
  for(i=0;i<4;i++)
  {
  	pthread_join(th[i], NULL);
  }
    
   
    pthread_mutex_destroy(&lock);
printf("SUM FINALLY IS: %d",sum);
    return 0;
}
