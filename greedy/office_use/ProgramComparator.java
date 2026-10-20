package greedy.office_use;

import java.util.Comparator;

public class ProgramComparator implements Comparator<Program>{

    @Override
    public int compare(Program o1, Program o2) {
        return o1.end - o2.end;
    }
    
}
