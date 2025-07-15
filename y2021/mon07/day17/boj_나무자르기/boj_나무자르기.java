package y2021.mon07.day17.boj_나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_나무자르기 {

	static int N, M;
	static int[] tree;
	static long maxHeight = Long.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // ������ ����
		M = Integer.parseInt(st.nextToken()); // �ʿ��� ������ ����
		tree = new int[N];
	
		st = new StringTokenizer(br.readLine());
		
		long max = Integer.MIN_VALUE; // �־��� �������� ���� ū ������ ����
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]);
		}		
		binarySearch(0, max);
		System.out.println(maxHeight);
	}
	
	private static void binarySearch(long start, long end) {
		
		while(start <= end) {
			long mid = (start+end)/2; // mid = ���� ������ ���� H
			long count = 0;
			// ��� ������ ������ ��, ������ ������ ���� ���
			for(int i = 0; i < N; i++) {
				if(tree[i] <= mid) continue; // ������ ���̰� �������� ������ PASS
				count += tree[i]-mid;
			}
			if(count >= M) { // ��� M���� ũ�ų� ������ -> ���̸� �������Ѻ���
				maxHeight = Math.max(mid, maxHeight);
				start = mid+1;
			}
			else { // ���� M���� ������ -> ���̸� ���ҽ��Ѻ���
				end = mid-1;
			}
		}
	}
}
