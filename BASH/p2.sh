#! /bin/bash
declare -a arr
k=10;
l=2;

for i in $(seq 1 10);
do 
a[i]=i;

done
 i=1;
for i in $(seq 2 $k);
do
l=$((a[$i]));
for j in $(seq $(($i + 1)) $k);
do 
m=$((a[$j]));
t=$(($m % $l));
if [ $t -eq 0 ];
then
for j in $(seq i $k);
do
a[i]=$((a[$i+1]));
done
k=$(($k -1));
echo $k;
fi;

done
done
echo "hi";
for i in $(seq 1 $k);
do
echo $((a[$i]));
done
echo "hi";
