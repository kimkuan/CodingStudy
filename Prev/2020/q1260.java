import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class q1260 {
	static ArrayList<ArrayList<Integer>> node;
	static boolean[] check;
	
	static void dfsRecursive(int now) {
		
		if(check[now] == true)
			return;
		
		else{
			System.out.print(now + " ");
			check[now] = true;
		}
		
		for(int i = 0; i < node.get(now).size() ; i++) { // �����̴ϱ� �ݴ�� ����!
			if(check[node.get(now).get(i)] == false){
				dfsRecursive(node.get(now).get(i));
			}
		}
	}
	
	static void dfs(int start) {
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		
		while(!stack.isEmpty()){ 	
			int now = stack.pop();
			System.out.println("���� : " + now );
			
			if(check[now] == false) { // �ٽ� �ǵ��ƿ;��ϹǷ� �ٽ� üũ! (�߿�)
				System.out.print(now + " ");
				check[now] = true;
			}
			for(int i = node.get(now).size()-1; i >= 0 ; i--) { // �����̴ϱ� �ݴ�� ����!
				if(check[node.get(now).get(i)] == false){
					stack.push(node.get(now).get(i));
				}
			}
		}
	}
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		check[start] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			System.out.print(now + " ");
			
			for(int i = 0; i < node.get(now).size(); i++) {
				if(check[node.get(now).get(i)] == false) {
					q.add(node.get(now).get(i));
					check[node.get(now).get(i)] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		node = new ArrayList<ArrayList<Integer>>();
		check = new boolean[n+1]; // �湮 üũ (false default)
		
		for(int i = 0; i < n+1; i++) {
			node.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			node.get(n1).add(n2);
			node.get(n2).add(n1);
		}
		
		for(int i = 1; i < node.size(); i++) { // ���ڰ� ���� ������ �����ϱ� ����
			Collections.sort(node.get(i));
		}
		/*
		for(int i = 1; i < node.size(); i++) {
			System.out.print("��� : " + i + " => ");
			for(int j = 0; j < node.get(i).size(); j++) {
				System.out.print(node.get(i).get(j) + " ");
			}
			System.out.println();
		}
		*/
		dfsRecursive(start);
		//dfs(start);
		Arrays.fill(check, false);
		System.out.println();
		bfs(start);
	}
}
