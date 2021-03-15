import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11728 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] first = new int[n]; // 정렬된 상태로 존재
		int[] second = new int[m];
		int[] arr = new int [n+m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			first[i] =Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			second[i] =Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		int idxF = 0, idxS = 0;
		for(int i = 0; i < n+m; i++) {
			if(idxF == n) {
				arr[i] = second[idxS];
				idxS++;
			}
			else if(idxS == m) {
				arr[i] = first[idxF];
				idxF++;
			}
			else if(first[idxF] > second[idxS]) {
				arr[i] = second[idxS];
				idxS++;
			}
			else {
				arr[i] = first[idxF];
				idxF++;
			}
			sb.append(arr[i] + " ");
		}
		System.out.print(sb);
	}
}
