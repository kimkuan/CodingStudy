import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

/* [S2] 후보 추천하기 */

class Candidate{
	int like; // 추천 수
	int time;  // 게시된 시간
	public Candidate(int time) {
		like = 1;
		this.time = time;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
}

public class q1713 {
	
	static int n, m;
	static HashMap<Integer, Candidate> map = new HashMap<>();
	
	public static int removeWho() {
		int num = 0;
		int minLike = Integer.MAX_VALUE;
		int	minTime = Integer.MAX_VALUE;
		
		for(Entry<Integer, Candidate> s : map.entrySet()) {
			// System.out.println("num : " + s.getKey() + " time, like "  + s.getValue().time +", "+ s.getValue().like);
			if(minLike > s.getValue().like) { // 좋아요가 적은 순
				minLike = s.getValue().like;
				minTime = s.getValue().time;
				num = s.getKey();
			}
			else if(minLike == s.getValue().like) {// 좋아요가 같으면 오래 게시된 순
				if(minTime > s.getValue().time){
					minTime = s.getValue().time;
					num = s.getKey();
				}
			}
		}
		return num;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 사진의 개수
		m = Integer.parseInt(br.readLine()); // 총 추천 횟수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			Candidate temp = map.get(num);
			
			if(temp == null) {
				Candidate newCan = new Candidate(i); // time 설정				
				if(map.size() == n) map.remove(removeWho());
				map.put(num, newCan);
			}
			else
				temp.setLike(temp.getLike() + 1); // 휫수 증가
		}
		
		Object[] key = map.keySet().toArray(); // or TreeMap 사용
		Arrays.sort(key);
		
		for(Object i : key) {
			System.out.print(i + " ");
		}
	}
}
