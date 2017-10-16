#! /bin/bash
declare -a arr
k=10;
l=2;
k=0;
for i in $(seq 1 10);
do 
a[i]=i;
done
 i=1;
for i in $(seq 2 $k)
do
l=$((a[$i]));
m=$((a[$i +1]));
if [ $($m % $l) -eq 0 ];
then
for j in $(seq i $k)
do
a[i]=$((a[$i+1]));
done
k=$($k -1);
fi;
done
for i in $(seq 1 $k);
do
echo $((a[$i]));
done


