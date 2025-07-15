package y2021.mon04.day07.boj_가르침;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_가르침_이상현 {

	static int N, K; // 단어 개수, 글자 수
	static int answer = 0;
	static boolean[] alpha;
	static String[] words;
	
	public static void main(String[] args) throws IOException {
		input();
		if(K < 5) { // anta - tica를 가르칠 수 없다면
			System.out.println(0);
			return;
		}
		else if(K == 26) { // 모든 알파벳을 배울 수있으면
			System.out.println(N);
			return;
		}
		solve(0, 0);
		System.out.println(answer);
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		alpha = new boolean[27]; // a ~ z -> 0 ~ 26까지
		words = new String[N];
		
		for(int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		// 기존에 필수로 필요한 것들은 2로 설정
		alpha['a'-'a'] = true;
		alpha['t'-'a'] = true;
		alpha['n'-'a'] = true;
		alpha['i'-'a'] = true;
		alpha['c'-'a'] = true;
	}
	
	// cnt : 담을 수 있는 글자의 수 
	// idx : 현재 만들 수 있는 지 확인하고자 하는 문자열
	public static void solve(int start, int cnt) {
	
		// 다 가르쳤다면
		if(cnt == K-5) { // 모든 문자열을 다 확인하기
			int word = 0; // 가르칠 수 있는 단어
			for(int i = 0; i < N; i++) {
				boolean available = true;
				for(int j = 4; j < words[i].length()-4; j++) {
					if(alpha[words[i].charAt(j) - 'a'] == false) {
						available = false;
						break;
					}
				}
				if(available) word++;
			}
			answer = Math.max(word, answer);
			return;
		}

		for(int i = start; i < 26; i++) {
			if(alpha[i] == true) continue;
			alpha[i] = true;
			solve(i+1, cnt+1);
			alpha[i] = false;
		}
	}
}
