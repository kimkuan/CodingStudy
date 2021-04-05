package mon02.day25.boj_직사각형을만드는방법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_직사각형을만드는방법_이상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		for(int i = 1; i <= N; i++)  // 
			ans += getCount(i);

		System.out.println(ans);
	}
	
	public static int getCount(int n) {
		int sum = 0;
		for(int i = 1; i <= Math.sqrt(n); i++) {
			if(n % i == 0) // n = 12 -> (1,12) (2,6) (3,4)
				sum++;
		}
		return sum;
	}
}

// n = 1 -> 1
// n = 2 -> 1
// n = 3 -> 1
// n = 4 -> 2
// n = 5 -> 1
// n = 6 -> 2
// n = 7 -> 1
// n = 8 -> 2
// n = 9 -> 2
