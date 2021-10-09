package mon10.day09.boj_�����ڳ����ֱ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_�����ڳ����ֱ� {

	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] arr;
	static int[] operation; // ����, ����, ����, �������� ����
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		operation = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operation[i] = Integer.parseInt(st.nextToken());
		}
		
		getMinAndMax(0, arr[0]);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	// depth�� ������ ������ �������� �Ѵ�. (0���� ����)
	private static void getMinAndMax(int depth, int result) {
		if(depth == N-1) {
			min = Math.min(result, min);
			max = Math.max(result, max);
			return ;
		}
		
		for (int i = 0; i < 4; i++) {
			if(operation[i] > 0) {
				operation[i]--;
				getMinAndMax(depth+1, calculate(i, result, arr[depth+1]));
				operation[i]++;
			}
		}
	}
	
	// ������ ������ ������
	private static int calculate(int operIndex, int prev, int next) {
		switch(operIndex) {
		case 0: 
			return prev+next;
		case 1:
			return prev-next;
		case 2:
			return prev*next;
		case 3:
			return prev/next;
		default:
			return 0;
		}
	}

}
