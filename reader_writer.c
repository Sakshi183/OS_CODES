#include<stdio.h>
#include<pthread.h>
#include<stdlib.h>
#include<unistd.h>
#include<semaphore.h>
sem_t r,rc,sq;
int resource=-1;
int n=0;
void * func(void *t)
{   int y = (int)t;
    int d;
    printf("\n PROCESS TRIES TO ENTER: %d",y);
    if(y%2==0)
    d=0; 
    else
    d=1;
    

//WRITER
if(d==1)   
{
		//sem_wait(&sema);
		//	sem_post(&sema);
		sem_wait(&sq);
		sem_wait(&r);
		sem_post(&sq);
		//WRITES
		 resource = y;
		 	printf("\n HI THIS IS PROCESS:%d in writing section",y);
		 	printf("\n NOW RESOURCE IS : %d",resource);
		//WRITING DONE
		sem_post(&r);
		
}
//READER 
if(d==0)
{
	sem_wait(&sq);
	sem_wait(&rc);
	if(n==0)
	sem_wait(&r);
	n++;
	sem_post(&sq);
	sem_post(&rc);
	//READ
	printf("\n HI THIS IS PROCESS:%d in reading section",y);
	printf("\nNO. OF PROCESSES READING RIGHT NOW ARE:%d",n);
	printf("\n NOW RESOURCE IS : %d",resource);
	//READING DONE
	sem_wait(&rc);
	n--;
	if(n==0)
    sem_post(&r);
    sem_post(&rc);
	
}

}

int main()
{   int i;
	 pthread_t th[4];
	sem_init(&r,0,1);
	sem_init(&rc,0,1);
	sem_init(&sq,0,1);
	
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
