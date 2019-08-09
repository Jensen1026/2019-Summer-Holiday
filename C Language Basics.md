
---
# C语言程序设计基础
---
[toc]

## 关于字符串

1. char类型数组字符串，末尾必须要有'\0'结束符；

2. 初始化有两种方式，数组形式或者直接字符串；

3. 常用函数：strcmp(A,B)、strcpy(A,B)、strlen()、strcat()

## 指针

1. 格式
   int a=10;
   int *p=&a;
   printf("%d",*p);

2. 指针运算：求地址&、取内容*、赋值=、++、--、==(关系运算)
   
3. 指针运算必须注意指针的当前值
   
4. 指向指针的指针
   
## 文件

## 链表

1. 格式
   T *ptr;
   ptr=(T*)malloc(sizeof(T));//int,double,struct date...
   ......
   free(ptr);
2. 关于链表的操作：创建链表、遍历链表、在链表上检索、插入、删除、交换链表中两项位置
   
   **<span style="color:red">注意：while循环时一定要小心循环控制变量的更新！</span>**









