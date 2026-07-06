class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // Sort by start ascending; if starts are equal, longer interval first.
        Arrays.sort(intervals, (a, b) ->
            a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]
        );

        int remaining = 0;
        int maxEnd = 0;

        for (int[] interval : intervals) {
            // A larger end means this interval is not covered.
            if (interval[1] > maxEnd) {
                remaining++;
                maxEnd = interval[1];
            }
        }

        return remaining;
    }
}
