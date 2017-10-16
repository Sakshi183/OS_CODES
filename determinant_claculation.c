#include<stdio.h>
#include<pthread.h>
int a[8][8];
int n;
struct t
{
	int row;
	int column;
	int elements;
	int n;
	int b1[8][8];
} r1;

int * func(void * y1)
{	 struct t *y= (struct t *) y1;
	int r = y->row;
	int c= y->column;
	int e = y->n;
	int b[8][8] ;
	int c[7][7];
	int i1,j1;
	
	
	for(i1=0;i1<8;i1++)
	{
		for(j1=0;j1<8;j1++)
		{
			b[i][j]=y->b1[i][j];
		}
	}
	int sum;
	
	if(e==2)
	{
	  sum =	a[r][c]*a[r+1]c[j+1] + a[r][c+1]*a[r+1][c];
	
	}
	else
	{int h=0,k=0;
		 
		 for(int p=0,i=r+1;p<elements/2;p++)
    {
    	
     for(q=0,j=c;q<elements/2;q++)
   {
  	if(j!=i)
  	c[h][k]=b[i][j];
  	j++; k++;
   }
  h++;
	i++;
	sum  = pow(-1,r*i)* a[r][i]* (b,e-1)
  }
		
	
}
