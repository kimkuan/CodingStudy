package y2022.mon01.day07.boj_팩토리얼0의개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_팩토리얼0의개수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
	
		System.out.println(binarySearch(M));
	}
	
	private static int binarySearch(int m) {
		int left = 1, right = 1000000000;
		int ans = -1;
		
		while(left <= right) {
			
			int mid = (left + right) / 2;
			int cnt = getZeroCount(mid);
						
			if(m < cnt) {
				right = mid - 1;
			}
			else if(m == cnt) {
				ans = mid;
				right = mid - 1; // 가장 작은 n을 찾기 위해 break하지 않는다.
			}
			else {
				left = mid + 1;
			}
		}
		return ans;
	}
	
	// num!의 0의 개수를 반환하는 메소드 (0의 개수 = 5의 개수)
	private static int getZeroCount(int num) {
		int count = 0;
		
		while(num >= 5) {
			count += num / 5;
			num = num / 5;
		}
		
		return count;
	}

}
