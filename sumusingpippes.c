#include<unistd.h>
#include<stdio.h>
#include<sys/types.h>
#include<sys/wait.h>
#include<stdlib.h>
int main()
{
int fd1[2],val=0,fd2[2];
pid_t pid,pid2;
pipe(fd);
pid = fork();

 if(pid==0)
 {

  
  close(fd1[1]);
   read(fd1[0],&val,sizeof(val));
   val = val + 3+4;
  
    
  
  pid2=fork();
  if(pid2==0)
  {
    printf("%d\n",val);
    close(fd2[1]);
   read(fd2[0],&val,sizeof(val));
   val=val+5 +6;
   printf("%d\n",val);
   }
   else{
   
   close(fd2[0]);
   write(fd2[1],&val,sizeof(val));
   }
  }
  else{
  wait(0);
  close(fd1[0]);
  val=1+2;
  write(fd1[1],&val,sizeof(val));
   
  }
  
  printf("%d",val);
  return 0;
  }
