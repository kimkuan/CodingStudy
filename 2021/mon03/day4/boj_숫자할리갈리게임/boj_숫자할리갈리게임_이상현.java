package mon03.day4.boj_숫자할리갈리게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_숫자할리갈리게임_이상현 {
		
	static int N, M;
	static String winner = "dosu";
	static ArrayDeque<Integer> doCard = new ArrayDeque<Integer>(); 
	static ArrayDeque<Integer> suCard = new ArrayDeque<Integer>(); 
	static ArrayDeque<Integer> doGround = new ArrayDeque<Integer>();
	static ArrayDeque<Integer>suGround = new ArrayDeque<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 도도부터 시작
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			doCard.addFirst(Integer.parseInt(st.nextToken())); // 앞에있는 카드가 위에 있는 카드
			suCard.addFirst(Integer.parseInt(st.nextToken()));
		}
		
		gamestart();
		System.out.println(winner);
	}
	
	private static void win(String winner) {
		if(winner.equals("do")) { // 먼저 냈던 카드들부터 덱의 뒤로 push 
			while(!suGround.isEmpty()) doCard.addLast(suGround.pollLast());
			while(!doGround.isEmpty()) doCard.addLast(doGround.pollLast());
		}
		else {
			while(!doGround.isEmpty()) suCard.addLast(doGround.pollLast());
			while(!suGround.isEmpty()) suCard.addLast(suGround.pollLast());
		}
	}

	private static void gamestart() {
		int cnt = 0;
		while(true) {
			// 도도 먼저
//			System.out.println("[카드현황]");
//			System.out.println(doCard.toString());
//			System.out.println(suCard.toString());
//			System.out.println("[그라운드 현황]");
//			System.out.println(doGround.toString());
//			System.out.println(suGround.toString());
//			System.out.println();
			
			if(cnt % 2 == 0) { // 도도차례
				doGround.addFirst(doCard.pollFirst()); // 상단에 있는 카드
				if(doCard.size() == 0) {// 카드가 0이 되버리면 즉시 상대방 승리 	
					winner = "su";
					break;
				}
				if(doGround.peekFirst() == 5)
					win("do");
			}
			else { // 수연이 차례
				suGround.addFirst(suCard.pollFirst()); // 상단에 있는 카드
				if(suCard.size() == 0) { // 카드가 0이 되버리면 즉시 상대방 승리 
					winner = "do";
					break;
				}
				if(suGround.peekFirst() == 5)
					win("do");
			}

			if(!doGround.isEmpty() && !suGround.isEmpty()) {
				if(doGround.peekFirst() + suGround.peekFirst() == 5)
					win("su");
			}
			
			if(++cnt == M) 
				break; 
		}

		if(doCard.size() > suCard.size())
			winner = "do";
		else if(doCard.size() < suCard.size())
			winner = "su";
	}
}
