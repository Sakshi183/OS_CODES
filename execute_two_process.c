#include<unistd.h>
#include<stdio.h>
#include<sys/types.h>
#include<sys/wait.h>
#include<stdlib.h>
int main()
{
pid_t pid;
pid=fork();

if(pid==0)
{
printf("ls runs");
char * arg[]={"ls","-l"};
execpv("ls",arg); 
}
else
{
printf("ps runs");
char* ar[]={"ps","-aux"};
execpv("ps",ar);
}
return 0;
}
