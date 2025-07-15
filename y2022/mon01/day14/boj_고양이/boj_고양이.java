package y2022.mon01.day14.boj_고양이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class boj_고양이 {

	static boolean[] alpha = new boolean[26]; // 사용여부 체크
	static ArrayList<Alpha> startList = new ArrayList<Alpha>();
	
	static class Alpha {
		char alpha;
		int index;
		
		public Alpha(char alpha, int index) {
			this.alpha = alpha;
			this.index = index;
		}
		
		@Override
		public String toString() {
			return "alpha : " + alpha + " index : " + index;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		int len = input.length;
		
		int kind = 0;
		for(int i = 0; i < len; i++) {
			int index = input[i] - 'a';
			
			// 사용한 적없는 알파벳이 나오는 경우
			if(!alpha[index]) {
				alpha[index] = true;				
				kind++;
			}
			
			if(i == 0)
				startList.add(new Alpha(input[i], i));
			else if(input[i-1] != input[i]) {
				startList.add(new Alpha(input[i], i));
			}
		}
		startList.add(new Alpha('-', input.length));
		
		System.out.println(kind <= N ? input.length : getMaxLength(input, N));
	}

	private static int getMaxLength(char[] input, int N) {
		int maxLen = 0;
		int size = startList.size()-1;

		boolean[] usedAlpha = new boolean[26]; // 사용여부 체크
		
		for(int left = 0; left < size; left++) {
			int right = left;
			int used = 0;
			
			// 오른쪽 기준
			while(right < size && used <= N) {
				
				int index = startList.get(right).alpha - 'a';
				
				// 사용한 적 없는 알파벳일 때
				if(!usedAlpha[index]) {		
					// 새로운 알파벳을 사용할 수 있으면 OK
					if(used < N) {
						usedAlpha[index] = true;
						used++;
					}
					// 더이상 새로운 알파벳을 사용할 수 없다면 BREAK
					else 
						break;
				}	
				right++;
			}
			
			if(right <= size) {
				int len = startList.get(right).index - startList.get(left).index;
				maxLen = Math.max(maxLen, len);
			}
			
			Arrays.fill(usedAlpha, false);
		}
		
		return maxLen;
	}

}

// 1. 전체 문자열에서 사용된 알파벳의 종류 <= N 이면 문자열의 길이 반환
// 2. Two-Pointer 이용해서 최대 문자열 찾기
