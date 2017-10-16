#include<stdio.h>
#include<pthread.h>
#include<stdlib.h>
#include<unistd.h>
#include<semaphore.h>
sem_t sema;
int n=-1;
void * func(void *t)
{   int y = (int)t;
    int value; 
     // sem_getvalue(&sema, &value); 
     // printf("The value of the semaphors is %d\n", value);


    printf("PROCESS TRIES TO ENTER: %d",y);
	sem_wait(&sema);
	//CRITICAL SECTION
	n=y;
	
	printf("\nPROCESS ACESSING RIGHT NOW IS: %d",n);
	sem_getvalue(&sema, &value); 
      printf("The value of the semaphors is %d\n", value);
	//EXIT CRITICAL SECTION 
	sem_post(&sema);
	//sem_getvalue(&sema, &value); 
    //printf("The value of the semaphors is %d\n", value);
}

int main()
{   int i;
	 pthread_t th[4];
	sem_init(&sema,0,2);
	
	for(i=0;i<4;i++)
    {
	
        pthread_create(&(th[i]), NULL, func, (void*)i);
      
    }
  for(i=0;i<4;i++)
  {
  	pthread_join(th[i], NULL);
  }
    
   return 0;
}
