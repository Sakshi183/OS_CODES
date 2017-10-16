#include<stdio.h>
#include<pthread.h>
int turn;
int global = 100;
int flag[2];

void*func (void *l1)
 {  int l =(int)l1;
  
   //int i=(int )y1;
 //int i = (int)y1;
  // int i; 
 // int i = &i1;
    int j = 1-l; 
    int total=0;
    while(total<2)
    {
        flag[l]=1;
        turn=j;
        while(flag[j]==1 && turn==j);
        //CRITICAL SECTION
        global+=100;
        printf("\n CRITICAL SECTION ACCESSED BY thread %d  global: %d",l,global);
        //EXIT SECTION
        flag[l]=0;
        total++;
    }
}
int main()
{
//	int t = random();

	int k=1;
	int l=1-k;
	pthread_t th,th2;
	pthread_create(&th,NULL,func,(void*)k);
  // int r = pthread_create(&th,NULL,func,(void *)k);
    pthread_create(&th2,NULL,func,(void *)l);
    pthread_join(th,NULL);
    pthread_join(th2,NULL);
}



