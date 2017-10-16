a=[2,0,1,1;0,1,0,0;1,0,1,1;1,1,0,1];
need = [3,1,1,1;0,2,1,2;1,0,0,0;1,0,0,0];
al = sum(a);
t=[0,0,0,0];
total = [5,2,4,3];
av= total - al;
disp(av);
for j=1:4
x=ones(4,4);
x=x.*av;
x
v=find(all(transpose(need<=x)))
disp("HI");
for i=1:length(v)
g=v(i);
if(t(g)==0)
 
  t(g)=-1;
  av=av + a(g,:);
  disp(av);
end
end
end
disp("AT THE END");
disp(av);
if(length(v)==0)
disp("DEADLOCK");
else
disp("NOT DEADLOCK");
end

 
 
 
