package in.ineuron.assignmnet3;

import java.util.Arrays;

public class MeetingRoomsQ8 {

	public boolean canAttendMeetings(int[][] intervals) {
		// Sort the intervals based on the start time
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		// Check for any overlapping intervals
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < intervals[i - 1][1]) {
				return false;
			}
		}

		return true; // No overlapping intervals found
	}

	public static void main(String[] args) {
		// Question 8
		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };

		MeetingRoomsQ8 solution = new MeetingRoomsQ8();
		boolean canAttendAllMeetings = solution.canAttendMeetings(intervals);

		System.out.println("Output is ---> : " + canAttendAllMeetings);

	}

}
