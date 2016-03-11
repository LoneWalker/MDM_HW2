/**
 * Created by xc9pd on 3/10/2016.
 */
public class PriorityQuest {
    public Quest q;
    public boolean deliverable;
    public int count;
    public long priority;

    public PriorityQuest(Quest q,int c){
        this.q=q;
        this.deliverable=false;
        this.count=c;
        this.priority=0;
    }

}
