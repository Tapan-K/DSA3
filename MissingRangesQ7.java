package in.ineuron.assignmnet3;

import java.util.ArrayList;
import java.util.List;

public class MissingRangesQ7 {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> missingRanges = new ArrayList<>();

		// Find the missing ranges before the first element
		if (lower < nums[0]) {
			missingRanges.add(getRange(lower, nums[0] - 1));
		}

		// Find the missing ranges between elements
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1] + 1) {
				missingRanges.add(getRange(nums[i - 1] + 1, nums[i] - 1));
			}
		}

		// Find the missing range after the last element
		if (upper > nums[nums.length - 1]) {
			missingRanges.add(getRange(nums[nums.length - 1] + 1, upper));
		}

		return missingRanges;
	}

	private String getRange(int start, int end) {
		return start == end ? String.valueOf(start) : start + "->" + end;
	}

	public static void main(String[] args) {
		// Question 7

		int[] nums = { 0, 1, 3, 50, 75 };
		int lower = 0;
		int upper = 99;

		MissingRangesQ7 solution = new MissingRangesQ7();
		List<String> missingRanges = solution.findMissingRanges(nums, lower, upper);

		System.out.println("Output: " + missingRanges);

	}

}
