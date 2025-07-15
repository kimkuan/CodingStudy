package mon11.day29.boj_K물류창고;

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
		priorityCount = new int[M+1]; // 1~M까지의 우선순위를 가진 컨테이너의 개수 저장
		
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

			// 현재 뽑고자 하는 우선순위가 맞는지 확인 (낮은 우선순위부터 적재)
			if(container.prior == targetPriority) { 
				priorityCount[container.prior]--;
			}
			else {
				q.addLast(container);
				cost += container.weight;
				continue;
			}

			// 우선순위가 같은 컨테이너끼리 무게가 가벼운게 위로 올라가게 컨테이너를 뺌
			while(!stack.isEmpty() 	
					 && stack.peek().prior == targetPriority 	
					 && stack.peek().weight < container.weight) {
				 
				 Container temp = stack.pop();
				 tempStack.push(temp);
				 cost += temp.weight;
			}
			
			// 현재 컨테이너를 적재
			stack.push(container);
			cost += container.weight;
			 
			// 가벼운 컨테이너를 다시 적재
			while(!tempStack.isEmpty()) {
				 Container temp = tempStack.pop();
				 stack.push(temp);
				 cost += temp.weight;
			}
					 
			// 다음 우선순위의 컨테이너 탐색
			 if(!isRemain(targetPriority))
				 targetPriority--;
		}
		
		return cost;
	}
	
	// 현재 우선순위의 컨테이너가 레일안에 더 존재하는 지 체크
	private static boolean isRemain(int prior) {
		return priorityCount[prior] > 0 ? true : false;
	}

}
