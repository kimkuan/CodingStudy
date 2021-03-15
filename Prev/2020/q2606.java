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
		int[] check = new int[n+1]; // ����Ʈ : 0
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		Queue<Integer> q = new LinkedList(); // Queue �������̽��� ����ü�� LinkedList ���
		check[1] = 1; // 1�� ��ǻ�� �湮
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
 BFS�� ���� 1�� ��ǻ�͸� ���� �� ���̷����� �ɸ��ԵǴ� ��ǻ�� ���� Ž�� 
*/

