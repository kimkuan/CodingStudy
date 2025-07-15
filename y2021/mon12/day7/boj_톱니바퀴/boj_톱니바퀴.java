package y2021.mon12.day7.boj_톱니바퀴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_톱니바퀴 {

	static int N = 4, M = 8;	// 4���� ��Ϲ���, 8���� ���
	static int R;
	static int[][] gears;		// ��Ϲ����� ����
	static int[] topIndex;		// �� ��Ϲ����� 12�� ������ ����Ű�� �ε���
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		gears = new int[N][M];
		topIndex = new int[N];
		
		for (int i = 0; i < N; i++) {
			String gearInfo = br.readLine();
			for (int j = 0; j < M; j++) {
				gears[i][j] = gearInfo.charAt(j) - '0';
			}
		}
		
		// ��Ϲ��� ȸ��
		R = Integer.parseInt(br.readLine());
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken())-1;	// ȸ����ų ��Ϲ��� (0������ ����)
			int dir = Integer.parseInt(st.nextToken());		// ȸ�� ����

			int currentNum = num;
			int currentDir = dir;
			int currentLeft = gears[num][calculateIndex(topIndex[num], -2)];	// ���� ��Ϲ����� ���� �ε���
			int currentRight = gears[num][calculateIndex(topIndex[num], +2)]; // ���� ��Ϲ����� ������ �ε���		
			int nextLeft, nextRight;
			
			// ���� Ž��
			while(currentNum > 0) {
				nextRight = gears[currentNum-1][calculateIndex(topIndex[currentNum-1], +2)]; 	// ���� ��Ϲ����� ������ �ε���
			
				// �´���ִ� �κ��� ���� ������ STOP
				if(currentLeft == nextRight)
					break;
				
				currentLeft = gears[currentNum-1][calculateIndex(topIndex[currentNum-1], -2)]; // ���� ��Ϲ����� ���� �ε���		
				
				rotate(currentDir*(-1), currentNum-1);  // ���� ��Ϲ����� ȸ�� ��Ŵ
				currentNum--;							// ���� ��Ϲ����� ���� ��Ϲ����� ��
				currentDir = currentDir * (-1); 		// ���� ȸ���� ������ �ݴ�� 
			}
			
			// ���� ��Ϲ��� ��ȣ�� ���� �ʱ�ȭ
			currentNum = num;
			currentDir = dir;
		
			// ������ Ž��
			while(currentNum < N-1) {
				nextLeft = gears[currentNum+1][calculateIndex(topIndex[currentNum+1], -2)]; 	// ������ ��Ϲ����� ���� �ε���
				
				// �´���ִ� �κ��� ���� ������ STOP
				if(currentRight == nextLeft)
					break;
				
				currentRight = gears[currentNum+1][calculateIndex(topIndex[currentNum+1], +2)]; // ������ ��Ϲ����� ������ �ε���		
				
				rotate(currentDir*(-1), currentNum+1); 	// ������ ��Ϲ����� ȸ�� ��Ŵ
				currentNum++;							// ������ ��Ϲ����� ���� ��Ϲ����� ��
				currentDir = currentDir * (-1); 		// ���� ȸ���� ������ �ݴ�� 
			}
			
			rotate(dir, num); // ���� ��Ϲ����� ȸ�� ��Ŵ
		}
		
		System.out.println(getResult());
	}
	
	// �� ������ ����ϴ� �޼ҵ�
	private static int getResult() {
		int result = 0;
		for (int i = 0; i < N; i++) {
			if(gears[i][topIndex[i]] > 0) 
				result += Math.pow(2, i);
		}
		return result;
	}
	
	// ���������� index ���� ����ϴ� �޼ҵ�
	private static int calculateIndex(int topIndex, int move) {
		if(move > 0)
			return topIndex+move >= M ? topIndex-M+move : topIndex+move;
		else
			return topIndex+move < 0 ? topIndex+M+move : topIndex+move; 
	}
	
	// ������ ȸ������ topIndex ���� �����ϴ� �޼ҵ�
	private static void rotate(int dir, int num) {		
		// �ð�������� ȸ��
		if(dir == 1)
			topIndex[num] = calculateIndex(topIndex[num], -1);
		// �ݽð�������� ȸ��
		else
			topIndex[num] = calculateIndex(topIndex[num], +1);
	}
}
