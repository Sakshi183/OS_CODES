#include<unistd.h>
#include<stdio.h>
#include<sys/types.h>
#include<sys/wait.h>
#include<stdlib.h>

int main()
{
pid_t pid;
pid=fork();
int s;
int e;
int t,status;
int sum;
int sum1=0;
int * sum1n;
int sum2=0;
int sum3=0;

if(pid==0)
{

 printf("%d\nsum1:",sum2);
 s = 3;
  e = 4;
  t = s;
  while(t<=e)
  {
   sum2 = sum2 + t;
   t++;
  }
  printf("%d\nsum1:",sum2);
   exit(sum2);
 
}
else
{
  s = 1;
  e = 2;
  
  wait(&status);
 int ty= WEXITSTATUS(status);
  sum1 = s + ty;
  while(t<=e)
  {
   sum1 = sum1 + t;
   t++;
  }
  printf("%d sum:\n",sum1);
  sum1n = &sum1;
  
}
return 0;
}

