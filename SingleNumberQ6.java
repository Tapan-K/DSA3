package in.ineuron.assignmnet3;

public class SingleNumberQ6 {
	public int singleNumber(int[] nums) {
		int result = 0;

		// XOR operation cancels out duplicates
		for (int num : nums) {
			result ^= num;
		}

		return result;
	}

	public static void main(String[] args) {
		// Question 6
		int[] nums = { 2, 2, 1 };

		SingleNumberQ6 solution = new SingleNumberQ6();
		int single = solution.singleNumber(nums);

		System.out.println("Output: " + single);

	}

}
