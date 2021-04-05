import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class q1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase;
		int n, m; // n : 문서의 개수, m : 몇 번째로 인쇄되었는지 궁금한 문서의 index 
	
		testcase = Integer.parseInt(br.readLine());
		
		while(testcase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// Queue<Pair> q = new LinkedList<>();
			ArrayList<Integer> arr = new ArrayList<>();
			int cnt = 0, ans = 0; // 같거나 큰 index 갯수
			int idx = -1; // 큰 우선순위 index
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				int prior = Integer.parseInt(st.nextToken());
				arr.add(prior);
			}
			
			for(int i = m+1; i < n; i++) { // m 뒤에 나오는 애들 중 우선순위가 더 큰 애가 있는지 
				if(arr.get(i) >= arr.get(m)) {
					cnt++;
					if(arr.get(i) > arr.get(m)) {
						idx = i;
						break;
					}
				}
			}
			if(idx >= 0) 
				ans = n - idx + 1;
			else
				ans = m + 1;
			
			System.out.println(ans);
		}	
	}
}
/*
 * m보다 우선순위가 큰 index까지 차이 
 */
 

