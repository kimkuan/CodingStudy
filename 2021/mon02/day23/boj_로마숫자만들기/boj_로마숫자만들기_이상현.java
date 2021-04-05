package mon02.day23.boj_로마숫자만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class boj_로마숫자만들기_이상현 {
	
	static int N;
	static int[] arr = {1, 5, 10, 50};
	static HashSet<Integer> set = new HashSet<Integer>(); // 만들 수 있는 수 중복 방지
	
	public static void roma(int cnt, int sum, int start) {
		
		if(cnt == N) {
			set.add(sum);
			return;
		}
		
		for(int i = start; i < 4; i++) {
			roma(cnt+1, sum+arr[i], i);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		roma(0, 0, 0);
		System.out.println(set.size());
	}
}

// 1+1 = 2
// 1+5 = 6
// 1+10 = 11
// 1+50 = 51

// 5+5 = 10
// 5+10 = 15
// 5+50 = 55

// 10+10 = 20
// 10+50 = 60

// 50+50 = 100