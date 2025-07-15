package y2021.mon09.day19.boj_경사로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_경사로 {

	static int N, L;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		// Ž��
		for (int i = 0; i < 2; i++) { // ���� or ����
			for (int j = 0; j < N; j++) {
				if(checkLoad(j, i)) 
					answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	// i : ���° �� �Ǵ� �� ����
	// d : ���� = 0, ���� = 1
	public static boolean checkLoad(int i, int d) {
		
		boolean[] runway = new boolean[N]; 
		boolean needRunway = false;
		
		// ���� Ž��
		if(d == 0) {	
			// ����->������ 1�� Ž��
			for (int j = 1; j < N; j++) {
				// ���� ���� 2 �̻��̸� 
				int heightGab = map[i][j-1] - map[i][j]; // ������
				
				if(heightGab > 1) 
					return false;
				else if(heightGab == 1) 
					needRunway = true;
				
				// ���θ� ����� ���� ��
				if(needRunway) {
					for(int k = j; k < j + L; k++) {
						if(k < 0 || k >= N) // ������ ����� false
							return false;
						if(map[i][k] !=  map[i][j]) // ���� ���̰� L�� ������ ������ false
							return false;
						if(runway[k]) // �̹� ���ΰ� ������������� false
							return false;
						
						runway[k] = true;
					}
					needRunway = false;
				}
			}
			
			
			// ������->���� 2�� Ž��
			for (int j = N-2; j >= 0; j--) {
				// ���� ���� 2 �̻��̸� 
				int heightGab = map[i][j+1] - map[i][j];
				
				if(heightGab > 1) 
					return false;
				else if(heightGab == 1) 
					needRunway = true;
				
				// ���θ� ����� ���� ��
				if(needRunway) {
					for(int k = j; k > j - L; k--) {
						if(k < 0 || k > N) // ������ ����� false
							return false;
						if(map[i][k] !=  map[i][j]) // ���� ���̰� L�� ������ ������ false
							return false;
						if(runway[k]) // �̹� ���ΰ� ������������� false
							return false;
						
						runway[k] = true;
					}
					needRunway = false;
				}
			}
			
		}
		// ���� Ž��
		else {
			// ����->�Ʒ��� 1�� Ž��
			for (int j = 1; j < N; j++) {
				// ���� ���� 2 �̻��̸� 
				int heightGab = map[j-1][i] - map[j][i]; // ������
				
				if(heightGab > 1) 
					return false;
				else if(heightGab == 1) 
					needRunway = true;
				
				// ���θ� ����� ���� ��
				if(needRunway) {
					for(int k = j; k < j + L; k++) {
						if(k < 0 || k >= N) // ������ ����� false
							return false;
						if(map[k][i] !=  map[j][i]) // ���� ���̰� L�� ������ ������ false
							return false;
						if(runway[k]) // �̹� ���ΰ� ������������� false
							return false;
						
						runway[k] = true;
					}
					needRunway = false;
				}
			}
			
			// ������->���� 2�� Ž��
			for (int j = N-2; j >= 0; j--) {
				// ���� ���� 2 �̻��̸� 
				int heightGab = map[j+1][i] - map[j][i];
				
				if(heightGab > 1) 
					return false;
				else if(heightGab == 1) 
					needRunway = true;
				
				// ���θ� ����� ���� ��
				if(needRunway) {
					for(int k = j; k > j - L; k--) {
						if(k < 0 || k > N) // ������ ����� false
							return false;
						if(map[k][i] !=  map[j][i]) // ���� ���̰� L�� ������ ������ false
							return false;
						if(runway[k]) // �̹� ���ΰ� ������������� false
							return false;
						
						runway[k] = true;
					}
					needRunway = false;
				}
			}
		}
		
		return true;
	}

}

// ���� (��->����) �������� Ž���ϸ鼭 
// 1. ���ΰ� �ʿ��� �� check
// 	-> 1-1. ���� ĭ�� ���� ĭ�� ���̰� 1����
// 2. ���ΰ� �ʿ��ϴٸ� ���θ� ���� ����� ������ �ִ��� check
// 	-> 2-1. ���θ� ���� ���� ���� ������ ĭ�� L�� ���ӵǾ� �ִ���.
//	-> 2-2. ������ �Ѿ�� �ʴ� ��

// flag�� �ξ ���ΰ� ���۵� �� ���� ���� ���̸� count
// ���ΰ� ��������� �ش� 


// �� ������ (���� -> ��) �������� Ž���ϸ鼭
// 
