package com.chefmic.linkedin.frequency_3;

import java.util.Set;
 
//cc 8.2 ԭ�� �õݹ����leetcode�ﳬʱ���ݹ�д�������
//���
public class UniquePaths2 {
	 public int uniquePathsWithObstacles(int[][] obstacleGrid) {
  int m= obstacleGrid.length;
  int n=obstacleGrid[0].length;
  
  //������Ԥ���� cnt ���matrix ���ǿ���obstacle����� 
  int[][] cnt=new int[m][n];
  //���� [0][0] �ĳ�ʼ����
  if(obstacleGrid[0][0]==1){
	  cnt[0][0]=0;   
  }else{
	  cnt[0][0]=1;
  }
  
  //�߼�case ������һ������obstacle�Ļ�û�취����
  if(obstacleGrid[m-1][n-1]==1){
	  return 0;
  }
                            //cnt��һ����    11111111111111111000000000
  for(int i=1;i<m;i++){
	                    //����ھ���ı�����һ����0 ��ô ��Ϊ���ϼ�����ֻ������ ���Ա�obstacle�������Щ�㶼�������� 
	  if(obstacleGrid[i][0]!=0&&cnt[i-0][0]!=0){
		  cnt[i][0]=1;
	  }
  }
  
 for(int i=1;i<n;i++){
	 if(obstacleGrid[0][i]!=1&&cnt[0][i-1]!=0){
		 cnt[0][i]=1;
	 }
 } 

 
 //�����һ����ʵһ�� ���Ǹ��Լ�������·��path��������·��path 
 //���������/����obstacle�Ļ��Ͳ��ܼ� ����Ҫ����if��֤
	 for(int i=1;i<m;i++){
		 for(int j=1;j<n;j++){
			 if(obstacleGrid[i-1][j]!=1){
				 //��û�и�ֵǰ cnt[i][j]��0 
				 cnt[i][j]=cnt[i][j]+cnt[i-1][j];
			 }
			 if(obstacleGrid[i][j-1]!=1){
				 //���Լ��� 2�������Լ� ��ô�� 0+ cnt[i-1][j]+0+cnt[i][j-1]
				 cnt[i][j]=cnt[i][j]+cnt[i][j-1];
				 
			 }
		 }
	 }
	 
	 return cnt[m-1][n-1];
	 }
}

// �ݹ�˼·д�� ������ ���ǻᳬʱ
//public class Solution {
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int x=obstacleGrid.length-1;
//		 int y=obstacleGrid[0].length-1;
//	
//			return uniquePathsWithObstacles(x,y,obstacleGrid);
//			}
//	    
//	
//	 int uniquePathsWithObstacles(int x,int y,int[][] obstacleGrid){
//			if(obstacleGrid[x][y]==1){   
//			 
//				return 0;
//			}else{
//				if(x==0||y==0){return 1;}
//			return uniquePathsWithObstacles(x,y-1,obstacleGrid)+uniquePathsWithObstacles(x-1,y,obstacleGrid);
//			}
//		}	
//    
//}