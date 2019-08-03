#include<stdio.h>

int stk[20];
int top;
int mp[6][6] = { {0,4,5,0,1,0},{4,0,1,0,2,0},{5,1,0,2,0,4},{0,0,2,0,3,3},{1,2,0,3,0,6},{0,0,4,3,6,0} };//��ʼ�����󣬼�¼����֮��ľ���Ȩֵ
int nu[6][6] = { {0,1,1,0,2,0},{1,0,1,0,2,0},{1,1,0,1,0,1},{0,0,1,0,1,2},{2,2,0,1,0,1},{0,0,1,2,1,0} };//��ʼ�����󣬼�¼����֮��·������


void dfs(int x) {
	stk[top++] = x;
	for (int i = 0; i <= 6; ++i) {
		if (mp[x][i]) {
			nu[x][i]--;
			nu[i][x]--;
			if (nu[x][i] == 0) {
				mp[x][i] = 0;
				mp[i][x] = 0;//ɾ���˱�
			}
			dfs(i);
			break;
		}
	}
}
void fleury(int ss) {
	int brige;
	top = 0;
	stk[top++] = ss; // ��������Euler·����
	while (top > 0) {
		brige = 1;
		for (int i = 0; i <= 6; ++i) { // ��ͼ����һ���߲��Ǹ�ߣ��ţ� 
			if (mp[stk[top - 1]][i] && nu[stk[top - 1]][i]) {
				brige = 0;
				break;
			}
		}
		if (brige) { // ���û�е������չ���������ջ
			printf("%d ", stk[--top] + 1);
		}
		else { // �����������ŷ��·��
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
