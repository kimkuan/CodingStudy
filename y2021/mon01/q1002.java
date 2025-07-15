package y2021.mon01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1002 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x1, y1, r1, x2, y2, r2;
			x1 = Double.parseDouble(st.nextToken());
			y1 =  Double.parseDouble(st.nextToken());
			r1 = Double.parseDouble(st.nextToken());
			x2 = Double.parseDouble(st.nextToken());
			y2 = Double.parseDouble(st.nextToken());
			r2 = Double.parseDouble(st.nextToken());
			
			if(x1 == x2 && y1 == y2) { // 중심이 같고
				if(r1 == r2) // 반지름이 같으면
					System.out.println(-1); // 모든 점에서 만남 
				else 
					System.out.println(0);
			}
			else {
				double dis = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
				
				if(r1+r2 == dis || Math.abs(r2-r1) == dis) // 내접
					System.out.println(1); // 한 점에서 만남
				else if(r1+r2 < dis || Math.abs(r2-r1) > dis) // 접점이 없음 (외부/내부에서 겹칠 때)
					System.out.println(0);
				else // 두 점에서 만남
					System.out.println(2);
			}
		}		
	}
}
