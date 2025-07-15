package mon10.day24.boj_단어맞추기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_단어맞추기 {
	
	static int[] alpha = new int[26]; // A ~ Z까지 사용할 수 있는 알파벳의 개수
	static char[] word; // 시작 단어

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String str = br.readLine();
			word = str.toCharArray();
			nextWord();
			sb.append(String.valueOf(word) + "\n");
		}
		System.out.print(sb.toString());
	}
	
	private static void nextWord() {
		int i = word.length - 1;

		// 다음 사전순 단어 찾으면서 현재 알파벳 지우기
		for (; i >= 0; i--) {
			int index = word[i] - 'A';
			
			// 현재 알파벳 지우기
			alpha[index]++;
			
			// 현재 위치에 넣을 수 있는 알파벳이 있는지
			int nextAlpha = chooseAlpha(index);
			if(nextAlpha >= 0)
				break;
		}
		
		// 현재 단어가 가장 사전순으로 마지막 단어라면
		if(i == -1) 
			return;
		
		// 다음 사전순 단어 찾으면서 현재 위치에 다음 알파벳 넣기
		boolean start = true;
		for(; i < word.length; i++) {
			int index = word[i] - 'A';
			int nextAlpha;
			
			if(start) { // 첫번째는 이전 알파벳의 다음으로 큰 알파벳만 올 수 있고
				nextAlpha = chooseAlpha(index); 
				start = false;
			}
			else { // 나머지는 가능한 알파벳들을 사전순으로 가져오기
				nextAlpha = chooseAlpha(-1);
			}
			
			word[i] = (char)(nextAlpha + 'A');
			alpha[nextAlpha]--;
		}
	}
	
	private static int chooseAlpha(int start) {
		int index = -1; // 사용할 수 있는 알파벳이 없으면 -1
		
		// start가 0이 아니면 그 다음 알파벳 부터 찾아야함
		for (int i = start+1; i < alpha.length; i++) {
			if(alpha[i] > 0) {
				index = i;
				break;
			}
		}
		return index;
	}

}

// 1. 맨 마지막 알파벳 부터 접근 (얘는 무조건 지우기)
// 2. 두 번째 알파벳도 지우고 
// 2-1. 현재 쓸 수 있는 알파벳이 지운 알파벳보다 이후면 사용 O
// 2-2. 현재 쓸 수 있는 알파벳이 지운 알파벳보다 이전이면 사용 X -> 세번째 알파벳도 지움
// 3. 알파벳을 지웠다면 사전순으로 알파벳들을 사용.