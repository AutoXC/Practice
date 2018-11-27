import numpy as np
i = 1
#print("input n = ",end='')
num=int(input("input n = "))
a=np.zeros([num,num])
a=a.astype(int)
a_max=num-1
j=0 #角标和

while (j<num):
    for k in range(j+1):   #角标和为j时需要填充k个数字
        if (j%2 == 1):
            a[j-k,k] = i
            i += 1
        else:
            a[k,j-k] = i
            i += 1
    j += 1

while (j < 2*(num-1)+1):
    for k in range(2*num-1-j):
        if (j%2 == 1):
            a[a_max-k,j-a_max+k] = i
            i += 1
        else:
            a[j-a_max+k,a_max-k] = i
            i += 1
    j += 1
    
for n in range(num):
    for i in a[n]:
        print(i,end=' ')
    print('\n')