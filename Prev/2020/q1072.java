import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1072 {

	static int getWinPercent(long x, long y) {
		// return (int)((double)y/x * 100); // y/x*100 -> 29/50 => 57 
		return (int)(100*y/x);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] arr = str.split(" ");
		long x = Integer.parseInt(arr[0]);
		long y = Integer.parseInt(arr[1]);
		int ans = -1, mid, val;
		
		int now = getWinPercent(x, y);
		System.out.println("now : " + now);
//		System.out.println("(double)y/x * 100 : " + (double)y/x * 100);
//		System.out.println("y*100/x : " + y*100/x);
		
		
		if(now >= 99) {
			System.out.print(ans);
			return;
		}
		
		// ÀÌºĞ Å½»ö
		int l = 1, r = 1000000000;
		while(l <= r) {
			mid = (l + r)/2;
			val = getWinPercent(x + mid, y + mid);
			System.out.println("mid : " + mid + "  value : " + val);
			
			if(now < val) {
				r = mid - 1;
				ans = mid;
			}
			else
				l = mid + 1;
			
			//System.out.println("l : " + l + "  r : " + r);
		}

		System.out.print(ans);
	}
}
