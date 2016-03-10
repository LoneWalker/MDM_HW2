/**
 * Created by xc9pd on 2/26/2016.
 */
public class Token {

<<<<<<< HEAD
    public TokenNode from;
    public TokenNode destination;
=======
    public Object from;
    public Object destination;
>>>>>>> 91a9c29ef51d0fbc7086b9c0ecb796bec57291b8
    public Quest q;
    public boolean isRequestToken;
    public MobilSupportServer initialMSS;
    public int round;
<<<<<<< HEAD
    public TokenNode currentLocation;
=======
>>>>>>> 91a9c29ef51d0fbc7086b9c0ecb796bec57291b8




    public Token(MobilSupportServer mss){
        this.isRequestToken=false;
        this.initialMSS=mss;
        this.round=0;
        this.from=null;
        this.destination=null;
        this.q=null;
<<<<<<< HEAD
        this.currentLocation=mss;
=======
>>>>>>> 91a9c29ef51d0fbc7086b9c0ecb796bec57291b8

    }

    public Token(Token tk){
        this.isRequestToken=tk.isRequestToken;
        this.from=tk.from;
        this.destination=tk.destination;
        this.q=tk.q;
        this.round=tk.round;
        this.initialMSS=tk.initialMSS;
<<<<<<< HEAD
        this.currentLocation=tk.currentLocation;
=======
>>>>>>> 91a9c29ef51d0fbc7086b9c0ecb796bec57291b8

    }

    public void addRound(MobilSupportServer mss){
        if(initialMSS.equals(mss))
        this.round++;
    }

<<<<<<< HEAD
    public void executeToken(){
        System.out.println(" ");
        System.out.println("Excuting token, the token is current in "+currentLocation.toString());
        System.out.println(" ");
        this.currentLocation.executeToken(this);
    }

=======
>>>>>>> 91a9c29ef51d0fbc7086b9c0ecb796bec57291b8




}
