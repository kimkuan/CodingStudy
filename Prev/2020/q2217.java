import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q2217 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] res = new int[n];
		int len = n;
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr); // 오름차순
		
		for(int i = 0; i < n; i++) {
			res[i] = arr[i] * len; // 제일 최솟값
			len--;
			System.out.println(res[i]);
		}
		Arrays.sort(res); // 오름차순
		System.out.println(res[n-1]);
	}
}