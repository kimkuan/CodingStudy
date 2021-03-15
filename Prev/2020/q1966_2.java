import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pair{
	int pos;
	int prior;
	
	public Pair(int pos, int prior) {
		this.pos = pos;
		this.prior = prior;
	}
	public int getPos() { return pos; }
	public int getPrior() {return prior;}
}

public class q1966_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase;
		int n, m; // n : 문서의 개수, m : 몇 번째로 인쇄되었는지 궁금한 문서의 index 
	
		testcase = Integer.parseInt(br.readLine());
		
		while(testcase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Pair> q = new ArrayList<>();
			int ans = 1;
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				int prior = Integer.parseInt(st.nextToken());
				q.add(new Pair(i, prior));
			}

			while(!q.isEmpty()) {
				Pair mp = q.get(0); // 맨 앞에 있는 원소
				boolean flag = false; // 우선순위가 높은 원소가 있는지
								
				for(int i = 1; i < q.size(); i++) {
					if(q.get(i).getPrior() > mp.getPrior()) { // 더 높은 우선순위가 있다면
						flag = true;
						break;
					}
				}
				
				if(flag) { // 현재보다 더 높은 우선순위가 있다면
					q.remove(0);
					q.add(mp); // 뒤로 옮김
				}
				else {
					if(mp.getPos() == m) { // 맨 앞에 있는게 내가 찾는 문서이면
						System.out.println(ans);
						break;
					}
					else
						ans++;
					
					q.remove(0); // 현재보다 우선순위가 높은 애 먼저 뽑기
				}

			}

		}	
	
	}

}
