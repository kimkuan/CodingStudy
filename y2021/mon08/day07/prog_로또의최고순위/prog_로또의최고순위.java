package y2021.mon08.day07.prog_로또의최고순위;

public class prog_로또의최고순위 {

	static int[] lottos  = {44, 1, 0, 0, 31, 25};
	static int[] win_nums = {31, 10, 45, 1, 6, 19};
	static boolean[] lotto_nums = new boolean[46];
			
	public static void main(String[] args) {
		
		for (int i = 0; i < win_nums.length; i++) {
			lotto_nums[win_nums[i]] = true;
		}
		
		int collectCount = 0;
		int zeroCount = 0;
		for (int i = 0; i < lottos.length; i++) {
			if(lottos[i] == 0)
				zeroCount++;
			
			if(lotto_nums[lottos[i]] == true) {
				collectCount++;
			}
		}
		
		System.out.println(getRank(collectCount+zeroCount));
		System.out.println(getRank(collectCount));
	}
	
	private static int getRank(int collectCount) {
		if(collectCount < 2)
			return 6;
		return 7-collectCount;
	}

}
