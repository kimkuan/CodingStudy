import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class TrafficLight{
	int D;
	int R;
	int G;
	public TrafficLight(int D, int R, int G) {
		this.D = D;
		this.R = R;
		this.G = G;
	}
}

public class q2980 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<TrafficLight> list = new ArrayList<>();
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int sec = 0, dis = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int D = Integer.parseInt(st.nextToken()); // 거리 순으로 주어짐
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			list.add(new TrafficLight(D, R, G));
		}
		
		while(dis != L) {                        
			if(list.size() > 0) {
				TrafficLight tl = list.get(0);
				
				if(dis == tl.D) {
					if(sec % (tl.R + tl.G) < tl.R) 
						sec += tl.R - sec % (tl.R + tl.G);
					else
						list.remove(0);
				}else {
					sec++;
					dis++;
				}
			}
			else {
				sec++;
				dis++;
			}
		}
		System.out.println("sec : " + sec);
	}
}
