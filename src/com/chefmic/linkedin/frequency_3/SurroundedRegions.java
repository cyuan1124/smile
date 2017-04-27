package com.chefmic.linkedin.frequency_3;

import java.util.LinkedList;
import java.util.Queue;

import javax.management.loading.PrivateClassLoader;
//Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
//
//A region is captured by flipping all 'O's into 'X's in that surrounded region.
//
//For example,
//
//X X X X         xxxx
//X O O X         x  x
//X X O X         xx x  
//X O X X         x xx     ��һ���Ƿ������ 
//
//After running your function, the board should be:
//
//X X X X
//X X X X
//X X X X
//X O X X

public class SurroundedRegions {
//	 �κ�һ��O�����û�б�X��Χ����ô��һ����������ı߽��ĳ��O����ͨ�ġ�
//	��������Ҳ���ǿ��Դ��������ǲ����е�O��ʼ�ù����������û�б���Χ��O��
	//��ɨ�������� Ȼ�� ����O ���ȸĳ�'I' ��bfsɨ����������(��ֹbfs��Ϊû��O�ظ�ɨ��)
	//��queue Ȼ��  Ȼ��ѱ�O���������Ҳ�һ�� ����O���ȸĳ�'I' ��bfsɨ����������
    //Ȼ��ڶ��� ��ɨ��MATRIX �� O��� x ��I���O
	
	//ΪʲôҪ�ȸ� i��bfs
//	NY-Kazami  17:08:07
//	��Ϊ��bfs �ٸ����� ��һ�������Ϊ4 �����ж��·�� �����������poll��ʱ��û���жϵĻ� �����ظ������������bfs
//	����Ϊʲô��һ��ʼ˵��Poll��ʱ��Ҫ�ж�
//	è  17:14:04
//	�ȷ�˵�и��м�� ��0 �������������Ҷ���0 Ȼ����bfs���鵽����ʱ�� ���bfs ����������Ȼ����չ���е��ϡ����¡����ң����� ���Ծͻ��ظ���

	
	public void solve(char[][] board) {
	if(board==null||board.length==0){
		return;
	}
	//�����ߺ��ұ� 
	for(int i=0;i<board.length;i++){
		if(board[i][0]=='O'){
		    board[i][0]='I';
			BFSReplace(board, i, 0);
	}
	if(board[i][board[0].length-1]=='O'){
	    board[i][board[0].length-1]='I';
		BFSReplace(board, i, board[0].length-1);
	}
}
	//����ϱߺ��±�  �ĸ��ǲ����ظ���2��
		for(int i=1;i<board[0].length-1;i++){
		if(board[0][i]=='O'){
		    board[0][i]='I';
			BFSReplace(board, 0, i);
		}
		if(board[board.length-1][i]=='O'){
		    board[board.length-1][i]='I';
			BFSReplace(board, board.length-1, i);
		}
	}
	
	//bfs����Ϻ� ��O�����X ��I�����O
	for (int i = 0; i < board.length; i++) {
		for(int j=0;j<board[0].length;j++){
			if(board[i][j]=='O'){
				board[i][j]='X';
			}else if(board[i][j]=='I'){
				board[i][j]='O';
			}
		}
	}
	
	
	
	}
	//�ҵ����ϵ�o��bfs������
 private void BFSReplace(char[][] board,int x,int y){
	 Queue<Integer> queue= new LinkedList<Integer>();
	 int length=board[0].length;
    queue.add(x*length+y);// ����һ�� ������ļ�¼�Ѿ�֤�����¼��һ��int��ķ���
    //����ѹ�� ��ʱ�� ��x=cur/length  y=cur%length;
    while(queue.size()!=0){
    	int cur=queue.poll();
    	x=cur/length;
    	y=cur%length;
    	//��ѹ��x y�����  ��������bfsȥ������� 0 ����queue
    	if(x-1>=0&&board[x-1][y]=='O'){
    	    board[x-1][y]='I';
    		queue.add(length*(x-1)+y);
    	}
    	if(y-1>=0&&board[x][y-1]=='O'){
    	   board[x][y-1]='I';
    	queue.add(length*x+(y-1));
    	}
    	if(x+1<board.length&&board[x+1][y]=='O'){
    	    board[x+1][y]='I';
    		queue.add(length*(x+1)+y);
    	}
    	if(y+1<board[x].length&&board[x][y+1]=='O'){
    	    	  board[x][y+1]='I';
    	 	queue.add(length*x+(y+1));
    	}
        }    
  } 
 }
