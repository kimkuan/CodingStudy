package y2021.mon10.day09.boj_인구이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_인구이동 {

	static class Country{
		int x;
		int y;
		
		public Country(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Union {
		int totalCount; // �� ������
		int totalPerson; // �� �α���
		
		public Union(int totalCount , int totalPerson) {
			this.totalCount = totalCount;
			this.totalPerson = totalPerson;
		}

		@Override
		public String toString() {
			return "Union [totalCount=" + totalCount + ", totalPerson=" + totalPerson + "]";
		}
		
	}
	
	static int N, L, R;
	static int[][] map; // �α� ��
	static int[] parent; // ������ ��ȣ (r,c) -> r*N + c
	static boolean[][] visited;
	static HashMap<Integer, Union> sumOfUnion = new HashMap<Integer, Union>();
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		parent = new int[N*N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				parent[i*N+j] = i*N + j; // ������ ��ȣ
			}
		}
		
		// 1. BFS�� ���鼭 ������ ã�´�.
		// 2. �� ������ �α������ ���ϱ� = �α��̵�
		int day = 0;
		boolean exit = true;
		while(exit) {
			exit = bfs();
			
			if(!exit) // ������ ��������� �ʾ����� BREAK
				break;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					parent[i*N+j] = find(i*N+j); // 1�� �� ����
					
					if(sumOfUnion.containsKey(parent[i*N+j])) {
						Union union = sumOfUnion.get(parent[i*N+j]); // ������ ���տ���
						sumOfUnion.put(parent[i*N+j], new Union(union.totalCount+1, union.totalPerson+map[i][j]));
					}
					else
						sumOfUnion.put(parent[i*N+j], new Union(1, map[i][j]));
				}
			}
			
			move();	
			day += 1;
			sumOfUnion.clear();
		}
		System.out.println(day);
	}
	
	private static void move() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Union union = sumOfUnion.get(parent[i*N+j]);
				map[i][j] = union.totalPerson / union.totalCount;
				
				parent[i*N+j] = i*N+j; // ���չ�ȣ �ʱ�ȭ
			}
		}
	}


	private static boolean bfs() {
		ArrayDeque<Country> q = new ArrayDeque<>();
		boolean moved = false; // ���漱�� ��������, ������ �ʴ���
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j]) continue;
				
				q.add(new Country(i, j));
				visited[i][j] = true;
				
				while(!q.isEmpty()) {
					Country con = q.poll();
					
					for (int d = 0; d < 4; d++) {
						int nx = con.x + dx[d];
						int ny = con.y + dy[d];
						
						if(nx < 0 || nx >= N | ny < 0 || ny >= N || visited[nx][ny]) continue;

						int gap = Math.abs(map[nx][ny] - map[con.x][con.y]); // ������ �� ������ �α� ��
						if(gap < L || gap > R) continue; // ���漱�� ������ �ʴ´�.
						
						int num1 = con.x*N + con.y; // ���� ������ȣ
						int num2 = nx*N + ny; // ������ ������ȣ
						
						findUnion(num1, num2);
						q.add(new Country(nx, ny));
						visited[nx][ny] = true;
						moved = true;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) 
			 Arrays.fill(visited[i], false);
				
		return moved;
	}
	
	private static void findUnion(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
	
	private static int find(int x) {
		if(x == parent[x])
			return x;
		return x = find(parent[x]);
	}

}

// �� ������ �α����̰� L�� �̻�, R�� ������ �� ���漱�� ������
// ���ǿ� ���� ���漱�� ��� ������ �α��̵� ����

// ������ ĭ�� ���� �̵������ϸ� �� �������� �Ϸ絿�� ������ �δ´�.
// ������ �̷�� �ִ� �� ĭ�� �α��� = (������ �α���) / (������ �̷�� ĭ�� ����  -> �Ҽ����� ������
// ������ ��ü�ϰ� ��� ���漱�� �ݴ´�.
