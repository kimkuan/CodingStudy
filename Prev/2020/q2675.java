import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2675 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
			
		while(testcase-- > 0) {
			String[] arr = br.readLine().split(" ");
			StringBuilder sb = new StringBuilder();
			
			int r = Integer.parseInt(arr[0]);

			for(int i=0 ; i < arr[1].length(); i++) {
				for(int j=0 ; j < r; j++) {
					sb.append(arr[1].charAt(i));
				}
			}
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}
}
