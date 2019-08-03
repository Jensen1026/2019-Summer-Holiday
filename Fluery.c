#include<stdio.h>

int stk[20];
int top;
int mp[6][6] = { {0,4,5,0,1,0},{4,0,1,0,2,0},{5,1,0,2,0,4},{0,0,2,0,3,3},{1,2,0,3,0,6},{0,0,4,3,6,0} };//初始化矩阵，记录各点之间的距离权值
int nu[6][6] = { {0,1,1,0,2,0},{1,0,1,0,2,0},{1,1,0,1,0,1},{0,0,1,0,1,2},{2,2,0,1,0,1},{0,0,1,2,1,0} };//初始化矩阵，记录各点之间路径条数


void dfs(int x) {
	stk[top++] = x;
	for (int i = 0; i <= 6; ++i) {
		if (mp[x][i]) {
			nu[x][i]--;
			nu[i][x]--;
			if (nu[x][i] == 0) {
				mp[x][i] = 0;
				mp[i][x] = 0;//删除此边
			}
			dfs(i);
			break;
		}
	}
}
void fleury(int ss) {
	int brige;
	top = 0;
	stk[top++] = ss; // 将起点放入Euler路径中
	while (top > 0) {
		brige = 1;
		for (int i = 0; i <= 6; ++i) { // 试图搜索一条边不是割边（桥） 
			if (mp[stk[top - 1]][i] && nu[stk[top - 1]][i]) {
				brige = 0;
				break;
			}
		}
		if (brige) { // 如果没有点可以扩展，输出并出栈
			printf("%d ", stk[--top] + 1);
		}
		else { // 否则继续搜索欧拉路径
			dfs(stk[--top]);
		}
	}
}

int main() {

	fleury(0);
	getchar();
	getchar();
	return 0;
}
