
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static int maxEndTime = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int meetingCount = sc.nextInt();

        int minStartTime = Integer.MAX_VALUE;

        Meeting[] meetings = new Meeting[meetingCount];
        for (int i = 0; i < meetingCount; i++) {
            int startTime = sc.nextInt();
            int endTime = sc.nextInt();
            meetings[i] = new Meeting(startTime, endTime);

            minStartTime = Math.min(startTime, minStartTime);
            maxEndTime = Math.max(startTime, maxEndTime);
        }

        List<Meeting> meetingList = new ArrayList<>(Arrays.asList(meetings));

        List<Meeting> sortedMeetingList = meetingList.stream().sorted(
                Comparator.comparing(Meeting::getEndTime)
                        .thenComparing(Meeting::getStartTime))
                .collect(Collectors.toList());

        int maxCount = calculateMaxMeetingCount(sortedMeetingList, minStartTime);
        System.out.println(maxCount);
    }

    public static int calculateMaxMeetingCount(List<Meeting> meetings, int currStartTime) {
        int index = 0;
        int meetingsCount = 0;

        int meetingsSize = meetings.size();
        while (currStartTime <= maxEndTime && index < meetingsSize) {
            Meeting meeting = meetings.get(index);
            if (meeting.startTime < currStartTime) {
                index++;
                continue;
            }

            currStartTime = meeting.endTime;
            meetingsCount++;
            index++;
        }

        return meetingsCount;
    }

    public static class Meeting {
        int startTime;
        int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }
}
