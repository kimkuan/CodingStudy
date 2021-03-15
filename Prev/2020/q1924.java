import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1924 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int day = y;
		
		for(int i = 1; i < x; i++) {
			day += month[i-1];
		}
		
		switch(day % 7) {
		case 0 : // ÀÏ
			System.out.print("SUN");
			break;
		case 1 : // ¿ù
			System.out.print("MON");
			break;
		case 2 : 
			System.out.print("TUE");
			break;	
		case 3 : 
			System.out.print("WED");
			break;
		case 4 : 
			System.out.print("THU");
			break;
		case 5 : 
			System.out.print("FRI");
			break;
		case 6 : 
			System.out.print("SAT");
			break;
		}
	}

}
