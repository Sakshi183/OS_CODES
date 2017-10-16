#include<pthread.h>
#include<stdio.h>
 int a[2][3],b[3][4],x[2][4];
void*func (void *y)
 { 
     int k = (int) y; //gives sum of row and column of c matrix
    int l,r=-1,c=0,j,e,i;//
    int n=k;
    int f= n+1;
    int t=0;
    while(k!=f)
	{
	    
	    if(k==0)
        r=0;c=0;
     for(i=0;i<2&&k!=0;i++)
       {     r++;k--;
 	   for(j=0;j<4&&k!=0;j++)
 	   { 
 	     c++;
 	     k--;
	   }
       }   
       printf("row %d , column %d",r,c);
 	  	 for(e=0;e<3;e++)
 	  	 {
 	  	 	x[r][c]=a[r][e]*b[e][c] + x[r][c];   //matrix multiplication
 	  		
		 }

		 n++;
		 
		 
		 
     }
  
 
 }
void main()
{
int i,k;
   int *y,j;
	for( i =0;i<2;i++)
	{
	
	
	
	for( k =0;k<3;k++)
	{
		a[i][k]=1;
	}
}

for( i =0;i<3;i++)
	{
	
	
	
	for( k =0;k<4;k++)
	{
		b[i][k]=0;
	}
  }
k=0;
 pthread_t th[2];
 
   pthread_create(&th[0],NULL,func,(void*)k); //send sum of row and column of c matrix
   
   k=k+3;
   pthread_create(&th[0],NULL,func,(void*)k);
   pthread_join(th[0],NULL);
   pthread_join(th[1],NULL);
 
 for(i=0;i<2;i++)
 {
 	for(j=0;j<4;j++)
 	{
 		printf("%d  ", x[i][j]);
	 }
	 printf("\n");
 }

 

 
 
 }
 
