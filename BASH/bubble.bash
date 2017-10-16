#! /bin/bash
declare -a arr
echo "enter n";
read n;
for i in $(seq 0 $($n - 1));
do
echo "Enter value";
read {a[$i]};
done
for i in $(seq 0 $($n - 1));
do
for j in $(seq 0 $($n - 1 -$i));
do
if [ $ {a[$j + 1]} -ge {a[$j] ];
t=${a[$i]};
{a[$i]} = ${a[j]};
{a[$j]} = $t;
fi
done
done
for i in $(seq 0 $($n - 1));
echo {a[$i]};

