package y2021.mon04.day05.boj_거짓말;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_거짓말_이상현 {
	
	static int N, M; // 사람의 수, 파티의 수
	static int lieParty = 0; // 거짓말을 할 수 있는 파티의 수
	static int[] parent;
	static int[][] party;
	static HashSet<Integer> peopleKnowTrue = new HashSet<>(); // 진실을 알고있는사람들
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
		System.out.println(lieParty);
	}	
	
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사람의 수
		M = Integer.parseInt(st.nextToken()); // 파티의 수
		parent = new int[N+1]; // 사람의 수
		party = new int[M][]; // 파티의 수
		
		// parent를 자기자신으로 초기화
		for(int i = 1; i <= N; i++) 
			parent[i] = i;
		
		// 진실을 아는 사람의 수
		st = new StringTokenizer(br.readLine());
		int know = Integer.parseInt(st.nextToken());
		for(int i = 0; i < know; i++) 
			peopleKnowTrue.add(Integer.parseInt(st.nextToken())); 
		
		// 파티의 수만큼 for문
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int people = Integer.parseInt(st.nextToken()); // i번 파티에 참가하는 사람 수 (0~50)
			party[i] = new int[people];
			
			for(int j = 0; j < people; j++) 
				party[i][j] = Integer.parseInt(st.nextToken()); // 저장
		}
	}
	
	private static void solve() {
		// 파티의 수만큼 for문
		for(int i = 0; i < M; i++) {
			int people = party[i].length; // 파티에 오는 사람의 수
			
			if(people == 0 || people == 1) // 사람의 수가 0명이거나 1명이면 넘어감
				continue;
			
			int first = party[i][0]; // 첫번째 사람
			for(int j = 1; j < people; j++) 
				union(first, party[i][j]); // 하나의 집합으로 묶기
		}
		
		// 거짓말할 수 잇는 파티인지 확인
		for(int i = 0; i < M; i++) { 
			boolean lie = true;
			for(int j = 0; j < party[i].length; j++) {
				int person = party[i][j];
				if(peopleKnowTrue.contains(find(parent[person]))) // 진실을 알고있는 사람과 함께있는 기회가 있다면
					lie = false; // 거짓말 할 수 없음
			}
			if(lie) lieParty++; // 진실을 모르는 사람들만 있는 파티에서는 거짓말을 할 수 있다
		}
	}
	
	private static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	} 
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		// 진실을 알고 있는 사람
		boolean knowA = peopleKnowTrue.contains(a);
		boolean knowB = peopleKnowTrue.contains(b);

		if(knowA)
			parent[b] = a;
		else if(knowB)
			parent[a] = b;
		else {// 둘 다 알고 있거나 둘 다 모르면
			if(a < b) parent[b] = a; // 더 작은 값을 부모로 선택
			else parent[a] = b;
		}		
	}
}

// Union find해서 같은 집합안에 있는지 확인
// 단, 부모를 갱신할 때 우선수위가
// 1. 진실을 알고 있는 사람
// 2. 둘 다 진실을 알고 있다면 그 중 작은 숫자를 부모로 지정
