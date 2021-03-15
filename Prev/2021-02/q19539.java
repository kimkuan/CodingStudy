import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* [S1] 사과나무  */

public class q19539 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[n]; // 1~n까지
		int sum = 0, sum2 = 0;
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i]; // 목표 길이의 합
			sum2 += arr[i]/2; // 2만큼 줄 수 있는 횟수의 합 = 물 주는 횟수
		}
		
		if(sum % 3 == 0) { 
			if(sum2 >= (sum/3)) 
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		else
			System.out.println("NO");
	}
}

/*
	[ 참조 풀이 ]
	
	- 2과 1을 주는 횟수는 동일하다
	- 모든 길이의 합은 3의 배수가 되어야 한다 (3 or (2+1))
	- sum / 3 => 목표  길이 달성을 위해 걸리는 일수
	- sum2 => n개의 나무에 물을 2만큼 부울 수 있는 횟수 
	
*/