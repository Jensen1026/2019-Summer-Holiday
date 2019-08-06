
---

# Java程序设计基础

---
[toc]

## 位操作符和位移操作符

   * `~`按位取反
   * `&`与运算
   * `|`或运算
   * `^`异或运算
   * `a<<b`对a左移b位，低位用0填充
   * `a>>b`对a右移b位，高位用符号为重复
   * `a>>>b`对a右移b位，高位用0填充

## String类、StringBuffer类、StringBuilder类

### String类
   
   * String类是不可变字符
   * 常用函数
     1. length();//返回字符串的长度
	 2. charAt(int index);//返回索引处的char值
     3. indexOf(String str);//返回字符第一次出现的索引
	 4. substring(int begin);substring(int begin,int end);//生成子字符串
	 5. toUpperCase();toLowerCase();//大小写转换
	 6. trim();//去掉字符串两端的空格
	 7. startsWith(String prefix);endsWith(String suffix);//是否开始或者结束于某一字符串
	 8. ValueOf();//将其他类型转换成字符串
	 9. split();//将一个字符串按照一个分隔符进行分隔，返回分隔后的字符串数组

### StringBuffer类

   * 多线程的，线程安全级别

### StringBuilder类

   * 单线程的。如果可能，优先使用StringBuilder类。
   * 常用函数
     1. append();//追加参数(多种类型)中的内容到字符串中
     2. insert();//将任意参数的字符串形式插入到原有字符串指定的位置
     3. delete(int start,int end);//删除从start到end-1为止的一段字符串序列
     4. reverse();//将字符序列逆序

## 对象的容纳

### 数组

   * 数组中有一个整型只读成员length，记录数组中元素的个数
   * 数组的工具类Arrays
     1. copyOf(src,src.length);//将一个数组的值复制到一个新数组中，需要指定源数组和复制长度
     2. sort();//将数组排序，默认为升序
     3. equals();//判断两数组是否相等
     4. asList();//将数组重构为集合
     5. binarySearch();//在已排好序的数组中查找特定值，对应的是二分查找

### 容器

#### List
   * 常用函数
     * add();//在指定位置处插入元素
     * remove();//在指定位置处删除元素
     * get(int);//获取指定位置的元素
     * indexOf();获取指定元素的位置
     * lastIndexOf();获取指定元素最后一次出现的位置
  
   * ArrayList
   * LinkedList
     * addFirst();  getFirst();  removeFirst(); 
     * addLast();  getLast();  removeLast(); 
  
#### 泛型

#### Set

#### Map
   * 示例：Map<Integer,String>map=mew HashMap<Integer,String>();
   * 常用函数
     * **put(K,V);**//将指定键与指定值相关联，如果此键以存在，将值替换
     * **get(Object);**//返回指定键对应的值
     * putAll(Map);
     * clear();//删除Map所有键值对
     * remove(Object);//删除指定键值对
     * **size();**//返回键值对个数
     * isEmpty();//判断Map是否为空
     * **KeySet();**//遍历键
     * values();//遍历值
     * entrySet();//遍历键值对
     * **containsKey(Object);**//判断Map是否存在指定键
     * containsValue(Value);//判断Map是否存在指定值
   * HsahMap(散列映射)
     * put();
     * equals();
     * hashCode();
