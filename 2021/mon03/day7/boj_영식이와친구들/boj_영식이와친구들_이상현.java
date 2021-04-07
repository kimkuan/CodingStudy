package mon03.day7.boj_영식이와친구들;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_영식이와친구들_이상현 {
	
	static int[] person;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int idx = 0, cnt = 0;
		person = new int[N]; // default : 0
	
		while(true) {		
			if(++person[idx]== M) // 공을 받은 횟수 증가
				break;
			
			cnt++; // 공을 '던진' 횟수 증가
		
			if(person[idx] % 2 == 1) // 홀수면 시계방향
				idx = (idx+L) % N;
			else
				idx = (idx-L) < 0 ? N-Math.abs(idx-L) :  idx-L;
		}
		System.out.println(cnt);
	}
}
