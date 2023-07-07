package in.ineuron.assignmnet3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumQ2 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> quadruplets = new ArrayList<>();
		Arrays.sort(nums);
		int n = nums.length;

		for (int i = 0; i < n - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			for (int j = i + 1; j < n - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}

				int left = j + 1;
				int right = n - 1;

				while (left < right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];

					if (sum == target) {
						quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

						while (left < right && nums[left] == nums[left + 1]) {
							left++; // Skip duplicates
						}
						while (left < right && nums[right] == nums[right - 1]) {
							right--;
						}

						left++;
						right--;
					} else if (sum < target) {
						left++;
					} else {
						right--;
					}
				}
			}
		}

		return quadruplets;
	}

	public static void main(String[] args) {
		// Question 2
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		int target = 0;

		FourSumQ2 solution = new FourSumQ2();
		List<List<Integer>> quadruplets = solution.fourSum(nums, target);

		System.out.println("Output is --->: " + quadruplets);

	}

}
