#include<stdio.h>
#include<pthread.h>
#include<semaphore.h>
int arr[100 ];
pthread_mutex_t lock;
sem_t c;
struct t
{
int low , high;
} l3;

//TWO THREADS ARE LOCALLY CREATED AND JOINED EACH TIME SORT IS CALLED.
// to ensure four threads are working at a time a semaphore is used

void * sort(void *b)
{ pthread_t th0,th1;
//printf("IN SORT"); 
int low,high;
	 struct t *y1= (struct t *) b;
  	low = y1->low;
  	high = y1->high;
  	struct t l2,l1;
  	 if(low<high)
   {
   	 pthread_t th0,th1; 
   int mid=(low+high)/2;
   int valuel;
   	
    pthread_mutex_lock(&lock);            //global mutex lock
    sem_getvalue(&c, &valuel);             //finding no. of threads being used
    l1.low = low;
    l1.high = mid;
    l2.low = mid +1;
    l2.high = high;
   // printf("VALUE L IS:% d",valuel);
      if(valuel>=2)                      //if two or more threads are available then only breaking will occur
      { 
	   
	    sem_wait(&c);                   // decrement value of semaphore
        sem_wait(&c);
      	pthread_create(&(th0), NULL, sort, (void*)&l1);            //  dividing and calling by two threads
      	pthread_create(&(th1), NULL, sort, (void*)&l2);
      sem_post(&c);                                    // increment value of semaphore
      sem_post(&c);
	  }
     
     pthread_mutex_unlock(&lock);              // global mutex unlock
      pthread_join(th0, NULL);
       pthread_join(th1, NULL);
       
      merge(low,high);	
   
      

    }
 
}



void merge (int l1 ,int h)
{
	 int low,high,mid;
  int i2;
  low =l1;
high =h;

 
  	mid=(low+high)/2;
   int k,m,x,y,sizel=0,sizer=0,j;
   int n;
   int l[5];
   int r[5];
 
   for(k=low,x=1;k<=mid;k++,x++)
   {
	  l[x]=arr[k];
	
	  sizel++;
   }   
  
   for(n=mid+1,y=1;n<=high;n++,y++)
   {
	  r[y]=arr[n];
	 
	  sizer++;
   }  
   i2=1;j=1;
   k=low;
   

  while((i2<=sizel)&&(j<=sizer))
  {
	  if(l[i2]>=r[j])
	  {
		
		  arr[k]=r[j];
		  
		  j++;
		  k++;
	  }
	  else
	  {
		  arr[k]=l[i2];
		
		  i2++;
		  k++;
	  }
  }	  
  
  if(i2<=sizel)
  {
	  while(i2<=sizel)
	  {
		  arr[k]=l[i2];
		 
	      k++;
		  i2++;
	  }
  }
   
   if(j<=sizer)
  {
	  while(j<=sizer)
	  {
		  arr[k]=r[j];
		
		  k++;
		  j++;
	  }
  }
   
}
int main()
{
int i1,i;
 pthread_t t; 
 int n1,n=2;
printf("Enter n to sort 2^n elements");
scanf("%d",&n1);
for(i=1;i<n1;i++)
n=n*2;
printf("Enter elements of array to sort:");
	 for(i1=1;i1<=n;i1++)
   {
    scanf("%d", &arr[i1]);

   }
  
     for(i1=1;i1<n+1;i1++)
 printf(" %d    ", arr[i1]);

  pthread_mutex_init(&lock, NULL);
  sem_init(&c,0,4);
  l3.low=1;
  l3.high = n+1;
  
  pthread_create(&(t), NULL, sort, &l3);
  pthread_join(t,NULL);
   printf("\n FINALLY SORTED ARRAY :");
    for(i1=1;i1<n+1;i1++)
 printf(" %d    ", arr[i1]);
	
	return 0;	
}


