#! /bin/bash
declare -a arr
echo "enter n";
read n;
for i in $(seq 1 $(($n)));
do
echo "Enter value";
read a[i];
done
for i in $(seq 1 $(($n)));
do
for j in $(seq 1 $(($n -$i)));
do
if [ $((a[$j])) -gt $((a[$j +1])) ]; then
t=$((a[$j]));
a[j]=$((a[$j + 1]));
a[j + 1]=$t;
fi
done
done
for i in $(seq 1 $(($n)));
do
echo $((a[$i]));
done
