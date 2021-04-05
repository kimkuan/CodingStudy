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
		int n, m; // n : ������ ����, m : �� ��°�� �μ�Ǿ����� �ñ��� ������ index 
	
		testcase = Integer.parseInt(br.readLine());
		
		while(testcase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// Queue<Pair> q = new LinkedList<>();
			ArrayList<Integer> arr = new ArrayList<>();
			int cnt = 0, ans = 0; // ���ų� ū index ����
			int idx = -1; // ū �켱���� index
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				int prior = Integer.parseInt(st.nextToken());
				arr.add(prior);
			}
			
			for(int i = m+1; i < n; i++) { // m �ڿ� ������ �ֵ� �� �켱������ �� ū �ְ� �ִ��� 
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
 * m���� �켱������ ū index���� ���� 
 */
 

