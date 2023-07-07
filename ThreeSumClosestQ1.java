package in.ineuron.assignmnet3;

import java.util.Arrays;

public class ThreeSumClosestQ1 {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int closestSum = nums[0] + nums[1] + nums[2];
		int n = nums.length;

		for (int i = 0; i < n - 2; i++) {
			int left = i + 1;
			int right = n - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];

				if (sum == target) {
					return target; // Found exact sum, return target
				}

				if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
					closestSum = sum;
				}

				if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
		}

		return closestSum;
	}

	public static void main(String[] args) {
		// Question 1
		int[] nums = { -1, 2, 1, -4 };
		int target = 1;

		ThreeSumClosestQ1 solution = new ThreeSumClosestQ1();
		int closestSum = solution.threeSumClosest(nums, target);

		System.out.println("Output: " + closestSum);

	}

}
