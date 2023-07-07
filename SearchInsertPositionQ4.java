package in.ineuron.assignmnet3;

public class SearchInsertPositionQ4 {
	public int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				return mid; // Found the target value
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		// The target value is not found, return the index where it would be inserted
		return left;
	}

	public static void main(String[] args) {
		// Question 4
		int[] nums = { 1, 3, 5, 6 };
		int target = 5;

		SearchInsertPositionQ4 solution = new SearchInsertPositionQ4();
		int index = solution.searchInsert(nums, target);

		System.out.println("Output: " + index);

	}

}
