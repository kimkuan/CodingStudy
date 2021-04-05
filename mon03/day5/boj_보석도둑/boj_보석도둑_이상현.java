package mon03.day5.boj_보석도둑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_보석도둑_이상현 {
	
	static int N, K;
	static long ans = 0;
	static int[] bag;
	static int[][] jewelry;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		jewelry = new int[N][2]; // (무게,가격)
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			jewelry[i][0] = w;
			jewelry[i][1] = v;
		}
		
		bag = new int[K];
		for(int i=0; i<K; i++) 
			bag[i] = Integer.parseInt(br.readLine());
		
		// 정렬
		Arrays.sort(jewelry, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
		Arrays.sort(bag); // 가방 오름차순
		steel();
		System.out.println(ans);
	}

	private static void steel() {
		int cnt = 0; 
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder()); // 가격이 높은 순으로
		
		for(int i = 0; i < K; i++) {
			while(cnt < N){
				if(jewelry[cnt][0] > bag[i])  // 무게가 더 크면 못 담음
					break;
				
				pq.add(jewelry[cnt][1]); // 현재 보석의 가격을 add
				cnt++;
			}
			if(!pq.isEmpty()) 
				ans += pq.poll(); // 그럼 현재가방 보다 무게가 적은 보석 중 가장 가격이 높은 애를 선택
		}
	}
}
