#! /bin/bash
s=1;
i=1;
echo "enter n";
read n;
for i in $(seq 1 $n); 
do
s=$(( $s * $i ))
done
echo $s;
