#! /bin/bash
echo "enter n";
read n;
a=1;
b=0;
c=-1;
for i in $(seq 1 $n); 
do
c=$(( $a + $b));
a=$b;
b=$c;
done
echo $c;

