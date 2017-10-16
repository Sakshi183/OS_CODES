#include<stdio.h>
#include<pthread.h>
 int x[4][4],y[4][4],r[4][4];
 struct t
{
	int a[2][2],b[2][2],c[2][2],d[2][2],sum[2][2];
} t1,t2,t3,t4 ;
 void*func (void *y2) 
 { 
     struct t *y1= (struct t *) y2;
    
	 int i,j,k;
     for (i = 0; i<2 ; i++)
     {
	  for (j = 0; j<2; j++)
        {
        	for(k=0;k<2;k++)
        	{
        		 printf("\n HELLO k is: %d",k);
        		y1->sum[i][j]= ( y1->a[i][k]*y1->b[k][j] ) +y1->sum[i][j] + (y1->c[i][k]*y1->d[k][j] );
        	//	printf("value at sum[1][1]%d",y1->sum[i][j]);
			}
	   //y1->a[i][j] = 2;
	
		}
	}
	printf("SUM IS :");
 /* for(i=0;i<2;i++)
  {
  	for(k=0;k<2;k++)
  	{
  		printf("%d   .....",y1->sum[i][k]);
	  }
	  printf("\n");
  }*/
 
 
 }

int main()
{
	int b,i,k;
	for( i =0;i<4;i++)
	{	
	for( k =0;k<4;k++)
	{
		x[i][k]=i;
		y[i][k]=i+1;
	}
    }
for(i=0;i<2;i++)
{
	for(k=0;k<2;k++)
	{
		t1.a[i][k]=x[i][k];  //A
		t1.b[i][k]=y[i][k];   //E
		t1.c[i][k]=x[i][k+2];  //B
		t1.d[i][k]=y[i+2][k]; //G
		
	  
	
		t2.a[i][k]=x[i][k];  //A
		t2.b[i][k]=y[i][k+2]; //F
		t2.c[i][k]=x[i][k+2];  //B
		t2.d[i][k]=y[i+2][k+2]; //H
		
		t3.a[i][k]=x[i+2][k]; //C
		t3.b[i][k]=y[i][k]; //E
		t3.c[i][k]=x[i+2][k+2]; //D
		t3.d[i][k]=y[i+2][k];  //G
		
		t4.a[i][k]=x[i+2][k]; //C
		t4.b[i][k]=y[i][k+2]; //F
		t4.c[i][k]=x[i+2][k+2]; //D
		t4.d[i][k]=y[i+2][k+2]; //H
		
	}
	
}    

	

	pthread_t th[4];
	pthread_create(&th[0],NULL,func,(void*)&t1);
	
		pthread_create(&th[1],NULL,func,(void*)&t2);
			pthread_create(&th[2],NULL,func,(void*)&t3);
				pthread_create(&th[3],NULL,func,(void*)&t4);
				
				
	pthread_join(th[0],NULL);
    pthread_join(th[1],NULL);
	pthread_join(th[2],NULL);
	pthread_join(th[3],NULL);
	
	for(i=0;i<2;i++)
	{
		for(k=0;k<2;k++)
		{
			r[i][k]=t1.sum[i][k];
			r[i][k+2]=t2.sum[i][k];
			r[i+2][k]=t3.sum[i][k];
			r[i+2][k+2]=t4.sum[i][k];
		}
	}
	
	for(i=0;i<4;i++)
	{
		for(k=0;k<4;k++)
		{
		printf("  %d ",r[i][k]);
	}
	printf("\n");
	}
	return 0;
}
