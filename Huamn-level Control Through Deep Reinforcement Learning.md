
# Huamn-level Control Through Deep Reinforcement Learning

`published:25 Febrary 2015`

---

[toc]

---

深度Q网络：能够将强化学习与一类称为深度神经网络的人工神经网络相结合。

深度神经网络的最新进展使得人工神经网络可以直接从原始传感数据中学习诸如对象类别之类的概念，其中使用若干层节点来逐渐建立数据的抽象表示。

**卷积神经网络(Convolutional Neural Network,CNN)**：它使用层叠的平铺卷积滤波器层来模拟感受域的影响。

>卷积神经网络是一种前馈神经网络，它的人工神经元可以响应一部分覆盖范围内的周围单元，对于大型图像处理有出色表现。它包括卷积层(convolutional layer)和池化层(pooling layer)。  卷积神经网络组成：输入层、卷积层、激活函数、池化层、全连接层


>**对比：全连接神经网络**
![](https://upload-images.jianshu.io/upload_images/4824974-0ad8a5321a879d8b.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1000)
>全连接神经网络组成：输入层、激活函数、全连接层(输入层、输出层、隐藏层)
>同一层的神经元之间没有连接
>每个连接都有一个权值
![](https://upload-images.jianshu.io/upload_images/4824974-5c61110c06202d8b.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1000)
>一个神经元组成为：
**输入**：n维向量X
**线性加权**：w是权值，b是偏置项
![](https://upload-images.jianshu.io/upload_images/4824974-eabb74fb1e86e0db.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/470)
**激活函数**：H(x)，要求非线性，容易求导数
**输出**：a
神经网络的训练：(1)一个神经网络的每个连接上的权值；(2)神经网络就是一个模型，这些权值就是模型的参数（即模型要学习的东西）；(3)对于这个神经网络的连接方式、网络层数、每层的节点个数，这些是我们实现设置的，成为超参数。




