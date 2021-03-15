import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q13301 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long arr[] = new long[2];
		
		arr[0] = 1; // n¿∫ 1 ∫Œ≈Õ
		arr[1] = 1;
		
		for(int i = 3; i <= n; i++) {
			long tmp = arr[0] + arr[1];
			arr[0] = arr[1];
			arr[1] = tmp;
		}
		
		if(n == 1)
			System.out.println(4);
		else
			System.out.println((arr[0] + arr[1])*2 + arr[1]*2);
	}
}
