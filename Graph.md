
# 图

## 一、图的基本概念

1. 无向图

```
定义及常用术语：
    顶点集、边集
    环、平行边

常见特殊图：
    简单图：无环且无重边
    完全图：任何两点之间都有边的简单图
    偶图(二部图)
    完全偶图

顶点的度：
    奇顶点、偶顶点
    推论：图的所有顶点的度数之和等于其边数的二倍
        任何图中的奇顶点的个数为偶数

子图：
    生成子图、顶点导出子图、边导出子图

图的矩阵表示
```

2. 有向图

3. 无向赋权图

4. 有向赋权图

## 二、最短路问题

```
固定起点的最短路：Dijkstra算法

每对顶点之间的最短路：Floyd算法
```

## 三、最小生成树问题

```
生成树：包含图的所有顶点的子树

最小生成树：所有边权值之和最小的生成树

两种算法：
        Prim算法：(顶点扩充法、生长方法)
        Kruskal算法：(避圈法)
```

## 四、图的遍历性问题

**中国邮递员问题**

```
欧拉图等价命题：图G无奇顶点、G的边集能划分为圈的不并交

设G是非平凡连通图，则G有欧拉路的充要条件是G最多只有两个奇顶点

欧拉回路、欧拉路径

求解欧拉图的欧拉路：Fleury算法
```

**旅行商问题**

```
哈密顿路、哈密顿圈
哈密顿图：含哈密顿圈的图
```

## 五、最大流问题

```
Ford-Fulkerson标号算法
```

##  六、最小费用最大流问题

**本问题较为复杂**

## 七、指派问题
