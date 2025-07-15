package y2021.mon09.day01.prog_타겟넘버;

public class prog_타겟넘버 {

	
	static int[] numbers = {1, 3, 3, 6, 4, 2}; 
	static int target = 3;
	static int answer = 0;
	
	public static void main(String[] args) {

		combination(0, 0);
		System.out.println(answer);
	}

	
	private static void combination(int sum, int next) {
		if(next == numbers.length) {
			if(sum == target) answer++;
			return;
		}
		
		combination(sum-numbers[next], next+1);
		combination(sum+numbers[next], next+1);
	}
}
