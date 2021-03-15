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
		
		// 종이에 적혀있는 값만큼 이동 (단, 양수 : 오른쪽, 음수 : 왼쪽)
		while(true) {
			
			Balloon bal = list.pollFirst(); // 풍선 터뜨림 
			int val = bal.value;
			
			System.out.print(bal.index + " ");
			
			if(list.isEmpty())
				break;
			
			if(val > 0) { 
				for(int i = 0; i < val-1; i++) 
					list.addLast(list.pollFirst()); // 맨 앞의 풍선을 뒤로 옮김
			}
			else {
				for(int i = 0; i < Math.abs(val); i++) 
					list.addFirst(list.pollLast()); // 맨 뒤의 풍선을 앞으로 옮김
			}
		}
	}
}

/*
 * LinkedList를 이용하면 메모리를 많이 잡아 먹는다
 * 대신 ArrayDeque를 사용하자
 * 
 * 장점1) ArrayDeque는 LinkedList와 다르게 다음 노드로의 추가적 참조가 필요하지 않으므로 메모리가 효율적이다
 * 장점2) 양쪽 끝을 추가/제거 해야하는 경우 각 요소에 접근하기위해서는 O(1)만 소요되니까 더 좋다
 * */
