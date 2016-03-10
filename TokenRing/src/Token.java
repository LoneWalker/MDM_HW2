/**
 * Created by xc9pd on 2/26/2016.
 */
public class Token {

    public Object from;
    public Object destination;
    public Quest q;
    public boolean isRequestToken;
    public MobilSupportServer initialMSS;
    public int round;




    public Token(MobilSupportServer mss){
        this.isRequestToken=false;
        this.initialMSS=mss;
        this.round=0;
        this.from=null;
        this.destination=null;
        this.q=null;

    }

    public Token(Token tk){
        this.isRequestToken=tk.isRequestToken;
        this.from=tk.from;
        this.destination=tk.destination;
        this.q=tk.q;
        this.round=tk.round;
        this.initialMSS=tk.initialMSS;

    }

    public void addRound(MobilSupportServer mss){
        if(initialMSS.equals(mss))
        this.round++;
    }





}
