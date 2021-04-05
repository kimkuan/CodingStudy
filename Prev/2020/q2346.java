import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Balloon{
	int value;
	int index;
	
	public Balloon(int value, int index){
		this.value = value;
		this.index = index;
	}
}

public class q2346 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		// LinkedList<Balloon> list = new LinkedList<>(); 
		ArrayDeque<Balloon> list = new ArrayDeque<>();
		
		for(int i = 0; i < n; i++) {
			list.add(new Balloon(Integer.parseInt(st.nextToken()), i+1));
		}
		
		// ���̿� �����ִ� ����ŭ �̵� (��, ��� : ������, ���� : ����)
		while(true) {
			
			Balloon bal = list.pollFirst(); // ǳ�� �Ͷ߸� 
			int val = bal.value;
			
			System.out.print(bal.index + " ");
			
			if(list.isEmpty())
				break;
			
			if(val > 0) { 
				for(int i = 0; i < val-1; i++) 
					list.addLast(list.pollFirst()); // �� ���� ǳ���� �ڷ� �ű�
			}
			else {
				for(int i = 0; i < Math.abs(val); i++) 
					list.addFirst(list.pollLast()); // �� ���� ǳ���� ������ �ű�
			}
		}
	}
}

/*
 * LinkedList�� �̿��ϸ� �޸𸮸� ���� ��� �Դ´�
 * ��� ArrayDeque�� �������
 * 
 * ����1) ArrayDeque�� LinkedList�� �ٸ��� ���� ������ �߰��� ������ �ʿ����� �����Ƿ� �޸𸮰� ȿ�����̴�
 * ����2) ���� ���� �߰�/���� �ؾ��ϴ� ��� �� ��ҿ� �����ϱ����ؼ��� O(1)�� �ҿ�Ǵϱ� �� ����
 * */
