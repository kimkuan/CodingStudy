package y2021.mon11.day29.boj_K물류창고;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_K물류창고 {
	
	static int N, M;
	static int[] priorityCount;
	static ArrayDeque<Container> q = new ArrayDeque<Container>();
	
	static class Container{
		int prior;
		int weight;
		
		public Container(int prior, int weight) {
			this.prior = prior;
			this.weight = weight;
		}
	}
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		priorityCount = new int[M+1]; // 1~M������ �켱������ ���� �����̳��� ���� ����
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int prior = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			q.add(new Container(prior, weight));
			priorityCount[prior]++;
		}
		
		System.out.println(calculateCost());
	}


	private static int calculateCost() {
		int cost = 0;
		int targetPriority = M;
		Stack<Container> stack = new Stack<Container>();
		Stack<Container> tempStack = new Stack<Container>();
		
		while(!q.isEmpty()) {
			Container container = q.pollFirst();

			// ���� �̰��� �ϴ� �켱������ �´��� Ȯ�� (���� �켱�������� ����)
			if(container.prior == targetPriority) { 
				priorityCount[container.prior]--;
			}
			else {
				q.addLast(container);
				cost += container.weight;
				continue;
			}

			// �켱������ ���� �����̳ʳ��� ���԰� ������� ���� �ö󰡰� �����̳ʸ� ��
			while(!stack.isEmpty() 	
					 && stack.peek().prior == targetPriority 	
					 && stack.peek().weight < container.weight) {
				 
				 Container temp = stack.pop();
				 tempStack.push(temp);
				 cost += temp.weight;
			}
			
			// ���� �����̳ʸ� ����
			stack.push(container);
			cost += container.weight;
			 
			// ������ �����̳ʸ� �ٽ� ����
			while(!tempStack.isEmpty()) {
				 Container temp = tempStack.pop();
				 stack.push(temp);
				 cost += temp.weight;
			}
					 
			// ���� �켱������ �����̳� Ž��
			 if(!isRemain(targetPriority))
				 targetPriority--;
		}
		
		return cost;
	}
	
	// ���� �켱������ �����̳ʰ� ���Ͼȿ� �� �����ϴ� �� üũ
	private static boolean isRemain(int prior) {
		return priorityCount[prior] > 0 ? true : false;
	}

}
