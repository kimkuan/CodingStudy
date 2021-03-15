import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* [B3] 아이 러브 크로아티아  */

public class q9517 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int bomb = Integer.parseInt(br.readLine()); // 폭탄을 들고있는 사람 (1~8)
		int n = Integer.parseInt(br.readLine()); // 질문의 개수
		StringTokenizer st; 
		int time = 0; // 3분30초 -> 210초
		
		for(int i = 0 ; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int ansTime = Integer.parseInt(st.nextToken());
			char ans = st.nextToken().charAt(0);
			
			time += ansTime; // 시간

			if(time >= 210) // 타임아웃!
				break;
			
			if(ans == 'T' && i < n-1) { // 넘겨줄 질문이 있을 때
				bomb++; // 다음 사람에게 넘기기
				if(bomb == 9) bomb = 1;// 만약 8이 넘어가면 1로 바꾸기
			}
		}
		System.out.println(bomb);
	}
}
