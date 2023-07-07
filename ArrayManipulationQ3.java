package in.ineuron.assignmnet3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayManipulationQ3 {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int closestSum = nums[0] + nums[1] + nums[2];
		int n = nums.length;

		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					int sum = nums[i] + nums[j] + nums[k];
					if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
						closestSum = sum;
					}
				}
			}
		}

		return closestSum;
	}

	// Question 2: Find unique quadruplets whose sum is equal to the target
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
							right--; // Skip duplicates
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

	// Question 3: Find the next permutation of the given array
	public void nextPermutation(int[] nums) {
		int n = nums.length;
		int i = n - 2;

		// Find the first decreasing element from the right
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}

		if (i >= 0) {
			int j = n - 1;

			// Find the element just greater than nums[i] from the right
			while (j >= 0 && nums[j] <= nums[i]) {
				j--;
			}

			// Swap nums[i] and nums[j]
			swap(nums, i, j);
		}

		// Reverse the suffix starting from i + 1
		reverse(nums, i + 1);
	}

	// Helper method to swap elements at indices i and j in the array
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	// Helper method to reverse the sub array starting from the given index
	private void reverse(int[] nums, int start) {
		int left = start;
		int right = nums.length - 1;

		while (left < right) {
			swap(nums, left, right);
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { -1, 2, 1, -4 };
		int target1 = 1;

		int[] nums2 = { 1, 0, -1, 0, -2, 2 };
		int target2 = 0;

		int[] nums3 = { 1, 2, 3 };

		ArrayManipulationQ3 solution = new ArrayManipulationQ3();

		// Question 1: Find three integers whose sum is closest to the target
		int closestSum = solution.threeSumClosest(nums1, target1);
		System.out.println("Closest Sum: " + closestSum);

		// Question 2: Find unique quadruplets whose sum is equal to the target
		List<List<Integer>> quadruplets = solution.fourSum(nums2, target2);
		System.out.println("Quadruplets: " + quadruplets);

		// Question 3: Find the next permutation of the given array
		solution.nextPermutation(nums3);
		System.out.println("Next Permutation: " + Arrays.toString(nums3));

	}

}
