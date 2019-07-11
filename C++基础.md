
---
# C++程序设计基础
---
[toc]

## STL标准模板类库

### vecor
 
1. 可以容纳许多其它类型的相同实体，称为容器。不能下标访问
2. 使用时要先添加头文件#include< vector>
3. 四种定义方式
   * vector< int>a(10);
   * vector< int>b(10,1);
   * vector< int>c(b);
   * vector< int>d(b.begin(),b.begin()+3);
4. 输出向量中的所有元素
   * for(int i=0; i< **<span style="color:red">a.size()</span>**; ++i)
  	  cout<< a[i];
   * for (**<span style="color:red">vector< int>::iterator it=a.begin();        it!=a.end();++it</span>**)
      cout<<*it;
    **注释：
         vector< int>::iterator，迭代器，是指向容器元素的指针**
5. vector常用成员函数
   * a.clear();//清空a
   * a.push_back();//向最后插入一个元素
   * a.pop_back();//删除最后一个元素
   * a.resize(10,2);//元素个数调整为10个，值为2

### array
   * 使用时需添加头文件#include< array>
   * 声明：template < class T,size_t N> class array;//数组类是固定大小的序列容器，包含以严格线性序列排序的特定数量的元素。
     **eg:** std::array< int,N> arr;
   * 容器属性：
     1. 元素按照严格线性排序，各个元素按其顺序访问它们的位置。
     2. 元素存储在连续的存储器位置，允许元素随机访问，可以用偏移元素的指针来访问。
     3. 容器使用隐式构造函数和析构函数静态分配所需的空间。它们的大小是编译时常量。没有内存或时间开销。
   * Iterator(迭代器)供遍历使用
     begin();end();
    <span style="color:red">eg:
     for (auto it = arr.begin(); it != arr.end(); ++it) {
        std::cout << *it << " ";
    }</span>
   * array数组的容量时固定的。可以通过sizeof()**//求字节数**、size()**//求元素数量**、max_size()、empty()等函数进行检测
   * 元素访问：
     1. 下标[]
     2. at();
     3. front();
     4. last();
     5. data();//返回第一个元素的内存地址
     6. get< n>();//获取容器第n各元素
   * 修改
     1. fill();//将数组各元素全部初始化为指定的值
     2. swap();//将两个数组的元素进行交换
   * 比较
    <、>、<=、>=、==、!=

### stack
   * 使用时需添加头文件#include< stack>
   * empty();//堆栈为空则返回真
   * push(x);//在栈顶增加元素
   * pop();//移除栈顶元素
   * size();//返回栈中元素个数
   * top();//返回栈顶元素
  
### queue
   * 使用时需添加头文件#include< queue>
   * empty();//队列为空则返回真
   * push(x);//将元素添加到队列末端   
   * pop();//弹出队列第一个元素
   * size();//返回队列元素个数
   * front();//返回队列第一个元素
   * back();//返回队列最后一个元素

## string类
   * 使用时需添加头文件#include< string>
   * 常用函数
     1. length();size();//求长度
     2. 可以下标访问[i]
     3. 加法'+'做字符串连接
     4. 比较符号(>、<、>=、<=、==、!=)做字符串比较
     5. begin();//返回第一个字符的下标
     6. end();//返回最后一个字符的下标
     7. reverse(start,end);//翻转字符串
     8. find(T x);find(T x,int begin);//查找串，char、string
     9. rfind(T x,int end);//从指定位置向前查找串
     10. 数字转为字符串：to_string(T);//int、long、double

## 组合类
   * 类中嵌有类，大类中不可以访问子类的成员
   * 初始化时，每个类只负责初始化它自己的对象。即：先初始化子类成员，再初始化自身。析构函数的调用顺序与构造函数严格相反
   * 怎么写好初始化函数？
     初始化列表(冒号语法，指定先后调用顺序)
     让编译器明白对象中的成员对象是如何初始化的
     解决办法：通过组合类的构造函数的初始化列表
     1. TuotrPairs(int i,int j,string str):teacher(p),student(j){
        noMeetings=i;
        }
     2. TuotrPairs(int i,int j,string str):teacher(p),student(j),noMeetings(i){}(后面没有分号)
     3. Date():year(1990),month(1),day(1){}
     4. Date(Date &d):year(d.year),month(d.month),day(d.day){}
     5. Date::Date(int y,int m,int d):year(1990),month(1),day(1){
        year=y;month=m;day=d;
        }

