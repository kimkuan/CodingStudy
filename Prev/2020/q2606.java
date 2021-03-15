import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q2606 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int cnt = 0;
		
		int[][] arr = new int[n+1][n+1];
		int[] check = new int[n+1]; // 디폴트 : 0
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		Queue<Integer> q = new LinkedList(); // Queue 인터페이스의 구현체인 LinkedList 사용
		check[1] = 1; // 1번 컴퓨터 방문
		q.offer(1); 
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			for(int i=1; i <= n; i++) {
				if(arr[x][i] == 1 && check[i] != 1) {
					q.offer(i);
					check[i] = 1;
					cnt++;
				}
			}
		}
		System.out.print(cnt);
	}
}

/*
 BFS를 통해 1번 컴퓨터를 통해 웜 바이러스에 걸리게되는 컴퓨터 수를 탐색 
*/

