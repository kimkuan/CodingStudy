package mon06.day11.로또의_최고순위와_최저순위;

public class 로또의_최고순위와_최저순위 {

	static int[] lottos = {45, 4, 35, 20, 3, 9};
	static int[] win_nums = {20, 9, 3, 45, 4, 35};
	static boolean[] checkWin = new boolean[46];
	
	public static void main(String[] args) {
		for(int i = 0; i < win_nums.length; i++) {
			checkWin[win_nums[i]] = true;
		}
		
		int count = 0;
		int zero = 0;
		for(int i = 0; i < lottos.length; i++) {
			if(lottos[i] == 0) zero++;
			else if(checkWin[lottos[i]]) count++;
		}
		System.out.println(myScore(count+zero));
		System.out.println(myScore(count));
	}
	
	private static int myScore(int count) {
		switch(count) {
		case 6: return 1;
		case 5: return 2;
		case 4: return 3;
		case 3: return 4;
		case 2: return 5;
		}
		return 6;
	}
}
