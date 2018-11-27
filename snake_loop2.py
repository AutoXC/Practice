import numpy as np

num=int(input("input n = "))
a=np.zeros([num,num])
a=a.astype(int)
n=1
flag=0#代表不同的生长方向，初始为0，取值为0，1，2，3

if num%2 == 1:#输入为奇数
    for i in range(2*num-1):#第i次循环
        flag = flag % 4
        if (num-2*(int(i/4))-1) == 0:#num为奇数时最后一次循环range为空
            a[int((num-1)/2),int((num-1)/2)] = n
            break
        else:
            for j in range(num-2*(int(i/4))-1):#第i次循环中有j个量需要赋值
                if flag == 0:
                    a[int(i/4),int(i/4)+j] = n
                    n += 1
                elif flag == 1:
                    a[int(i/4)+j,num-1-int(i/4)] = n
                    n += 1
                elif flag == 2:
                    a[num-1-int(i/4),num-1-int(i/4)-j] = n
                    n += 1
                else:
                    a[num-1-int(i/4)-j,int(i/4)] = n
                    n += 1
        flag += 1
else:#输入为偶数
    for i in range(2*num):
        flag = flag % 4
        for j in range(num-2*(int(i/4))-1):
            if flag == 0:
                a[int(i/4),int(i/4)+j] = n
                n += 1
            elif flag == 1:
                a[int(i/4)+j,num-1-int(i/4)] = n
                n += 1
            elif flag == 2:
                a[num-1-int(i/4),num-1-int(i/4)-j] = n
                n += 1
            else:
                a[num-1-int(i/4)-j,int(i/4)] = n
                n += 1
        flag += 1
    
for n in range(num):
    for i in a[n,:]:
        print(i,end='  ')
    print('\n')