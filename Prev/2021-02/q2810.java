import java.io.BufferedReader;
import java.io.InputStreamReader;

/* [B2] 컵홀더  */

public class q2810 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 좌석개수
		char[] seats = br.readLine().toCharArray();
		int ans = 0;
		
		for(int i = 0; i < n; i++) {
			if(seats[i] == 'L') // L일 때
				i++; // 2칸 넘어가기
			ans++;
		}
		ans = ans+1; // 마지막 좌석의 오른쪽 컵홀더 추가 
		
		if(n < ans) // 사람의 수가 최대 사용가능한 컵홀더 수 보다 작으면 사람의 수 출력
			ans = n;
		
		System.out.println(ans);
	}
}
/*
	출력하는 것은 컵홀더 수가 아니라 컵홀더를 사용하는 사람의 수!!
*/