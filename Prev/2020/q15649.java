import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q15649 {

	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static boolean[] check; // 1~9����
	static int[] answer;
	
	static void dfs(boolean[] checked, int cnt) { // cnt : ������� ������ ������ ����		
		if(cnt == m) {
			for(int i = 0; i < m; i++) 
				sb.append(answer[i]).append(' ');
			sb.append('\n');
		}
		
		for(int i = 1; i <= n; i++) {
			if(checked[i] == false) { // ���� : �湮���� �ʾ��� ��츸
				answer[cnt] = i; 
				checked[i] = true; // �߿�! 
				dfs(checked, cnt+1);
				checked[i] = false; // �߿�! 
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		check = new boolean[n+1];
		answer = new int[n+1];
		
		dfs(check, 0);
		System.out.print(sb);
	}
}

/*
 * ��Ʈ��ŷ (Backtracking)
 * : ������ ������ ����, ��� ������ ���� ���Ǵ� ��  
 * : �ظ� ã�ư��� ����, ���� ��ΰ� �ذ� �� �� ���� ������ �� ��θ� ���̻� ���� �ʰ� �ǵ��ƿ��� ��
 * 
 * => �Ϲ������� DFS�� ���Ͽ� �����Ѵ�. (BFS�� ��� ��������� ���� �޸𸮰� �ʿ��ϱ� ������)
 *
*/