package greedy.office_use;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        
    }

    // 给定很多个会议，会议的开始和结束时间是确定的，给定最初的开始时间
    // 问怎么确定可以最优安排会议
    public static int bestArrange(Program[] programs, int timePoint) {
        // 按照会议的结束时间来安排，先结束的会议优先安排，与已经安排的会议有时间冲突的会议跳过
        // 按照会议结束时间做排序
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        for(Program program : programs) {
            if (program.start >= timePoint) {
                result++;
                timePoint = program.end;
            }
        }
        return result;
    }
}
