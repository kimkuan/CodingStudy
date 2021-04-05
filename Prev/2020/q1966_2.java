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
		int n, m; // n : ������ ����, m : �� ��°�� �μ�Ǿ����� �ñ��� ������ index 
	
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
				Pair mp = q.get(0); // �� �տ� �ִ� ����
				boolean flag = false; // �켱������ ���� ���Ұ� �ִ���
								
				for(int i = 1; i < q.size(); i++) {
					if(q.get(i).getPrior() > mp.getPrior()) { // �� ���� �켱������ �ִٸ�
						flag = true;
						break;
					}
				}
				
				if(flag) { // ���纸�� �� ���� �켱������ �ִٸ�
					q.remove(0);
					q.add(mp); // �ڷ� �ű�
				}
				else {
					if(mp.getPos() == m) { // �� �տ� �ִ°� ���� ã�� �����̸�
						System.out.println(ans);
						break;
					}
					else
						ans++;
					
					q.remove(0); // ���纸�� �켱������ ���� �� ���� �̱�
				}

			}

		}	
	
	}

}
