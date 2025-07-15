package y2021.mon12.day30.prog_피로도;

/*
 * 풀이 시간 : 20분
 * 시간복잡도 : O(N^2)
 * IDE 사용 : X
*/

public class prog_피로도 {
	
    static int N; // 주어진 던전의 개수
    static int maxCount; // 유저가 탐헐할 수 있는 최대 던전 수
    static boolean[] visited; // 던전 방문여부를 체크할 배열
    
    static int k = 80;
    static int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

	public static void main(String[] args) {
		int answer = -1;
        
        N = dungeons.length;
        visited = new boolean[N];
        
        explore(dungeons, 0, 0, k);
        
        answer = maxCount;
        System.out.println(answer);
	}
	
	// DFS (num, count, hp)
    // num : 방문한 던전의 수 (탐험이 가능한 경우 + 불가능한 경우 모두 합산)
    // count : 유저가 탐험한 던전의 수
    // hp : 현재 피로도      
    private static void explore(int[][] dungeons, int num, int count, int hp){
        if(num == N){
            maxCount = Math.max(maxCount, count);
            return;
        }    
        
        for(int i = 0; i < N; i++) {
            if(visited[i])
                continue;
            
            visited[i] = true;
            
            // 현재 피로도로 던전을 탐험할 수 있다면
            if(dungeons[i][0] <= hp)
                explore(dungeons, num+1, count+1, hp-dungeons[i][1]);
            else
                explore(dungeons, num+1, count, hp);

            visited[i] = false;
        }
    }
}
