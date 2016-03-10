/**
 * Created by xc9pd on 3/10/2016.
 */
import java.util.Comparator;
public class PriorityComparator implements Comparator<PriorityQuest>{
    public int compare(PriorityQuest q1,PriorityQuest q2){
        if(q1.priority<q2.priority)return -1;
        if(q1.priority>q2.priority)return 1;
        return 0;
    }




}
