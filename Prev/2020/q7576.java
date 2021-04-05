import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato{
	int x;
	int y;
	int day;
	
	public Tomato(int x, int y, int day) {
		this.x = x;
		this.y = y;
		this.day = day;
	}
}

public class q7576 {
	static int m, n; // ���� & ����
	static int min_day = -1;
	static boolean[][] check;
	static int[][] tomato;
	static Queue<Tomato> q;
	
	static int[] xx = {0, 1, 0, -1}; // ������, �Ʒ�, ����, ��
	static int[] yy= {1, 0, -1, 0};
	
	static boolean checkRange(int x, int y) {
		if(x >= 0 && x < n && y >= 0 && y < m) 
			return true;
		return false;
	}
	
	static boolean checkTomato(){
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(tomato[i][j] == 0) 
					return false;
			}
		}
		return true; // �� ����
	}
	
	static void bfs() {
		
		while(!q.isEmpty()) {
			Tomato tm =  q.poll();
			int x = tm.x;
			int y = tm.y;
			int day = tm.day;
			
			if(check[x][y] == true) // �̹� �湮�� ��� continue�� �Ѿ�� (�̺κ� �����ߴ��� �޸� �ʰ� ���)
				continue;
			
			check[x][y] = true; // �湮�Ϸ�
			tomato[x][y] = 1; // ���� �丶��� ����
			
			for(int i = 0; i < 4; i++) {
				int nx = x + xx[i];
				int ny = y + yy[i];
				
				// �丶�䰡 ���� ���� ���°�, ���� �湮���� �ʾҴٸ�
				if(checkRange(nx, ny) && tomato[nx][ny] == 0 && check[nx][ny] == false)
					q.add(new Tomato(nx, ny, day+1)); 
			}
			
			min_day = min_day < day ? day : min_day ; 
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		check = new boolean[n][m];
		tomato = new int[n][m];
		q = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				
				if(tomato[i][j] == 1) 
					q.add(new Tomato(i, j, 0)); // �������� �̸� add�� �ؾ� �� (���� 3 ����)
			}
		}
		
		if(checkTomato()){ // �̹� �丶�䰡 ��� ���� �����̸�
			System.out.println("0"); // 0 ���
			return;
		}
		
		bfs();
		
		// ��� ������ ��, ������ ���� ���� �丶�䰡 ������ -1 return
		if(checkTomato() == false) 
			System.out.println("-1");
		else
			System.out.println(min_day);	
	}
}

/*
	1 : ���� �丶��
	0 : ���� ���� �丶��
	-1 : �丶�䰡 ������� ���� ĭ
	
	�Է� : �丶�䰡 �ϳ� �̻� �ִ� ��� 
	
	���� ���ϴ� ��� : -1���� �ѷ�����.
*/