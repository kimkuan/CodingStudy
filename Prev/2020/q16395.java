import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class q16395 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		if(k > n/2)
			System.out.print(search(n, n-k+1));
		else
			System.out.print(search(n, k));
		/*
		 n-1이 짝수일 때는 대칭이지만, 홀수 일 때는 가운데값이 다르다
		*/
	}
	
	public static int search(int n, int k) {
		int[][] arr = new int[n+1][k+1];
		
		for(int i = 0; i < n; i++) {
			System.out.print(i + " : ");
			for(int j = 0; j <= Math.min(i,k); j++) { 
				if(j == 0 || j == i)
					arr[i][j] = 1;
				else
					arr[i][j] = (arr[i-1][j-1] + arr[i-1][j]);
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		return(arr[n-1][k-1]);
	}
}
