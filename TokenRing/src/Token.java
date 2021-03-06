import java.util.ArrayList;

/**
 * Created by xc9pd on 2/26/2016.
 */
public class Token {


    public TokenNode from;
    public TokenNode destination;


    public Quest q;
    public boolean isRequestToken;
    public TokenNode initialMSS;
    public int round;
    public TokenNode currentLocation;

    public ArrayList pendingRequest;




    public Token(MobilSupportServer mss){
        this.isRequestToken=false;
        this.initialMSS=mss;
        this.round=0;
        this.from=null;
        this.destination=null;
        this.q=null;
        this.currentLocation=mss;
        this.pendingRequest=new ArrayList();

    }

    public Token(Proxy mss){
        this.isRequestToken=false;
        this.initialMSS=mss;
        this.round=0;
        this.from=null;
        this.destination=null;
        this.q=null;
        this.currentLocation=mss;
        this.pendingRequest=new ArrayList();

    }

    public Token(Token tk){
        this.isRequestToken=tk.isRequestToken;
        this.from=tk.from;
        this.destination=tk.destination;
        this.q=tk.q;
        this.round=tk.round;
        this.initialMSS=tk.initialMSS;
        this.currentLocation=tk.currentLocation;
        this.pendingRequest=tk.pendingRequest;

    }

    public void addRound(MobilSupportServer mss){
        if(initialMSS.equals(mss))
        this.round++;
    }

    public TokenNode executeToken(){
        TokenNode prev_tokenNode=currentLocation;
        System.out.println(" ");
        System.out.println("Excuting token, the token is current in "+currentLocation.toString());
        System.out.println(" ");
        this.currentLocation.executeToken(this);
        return prev_tokenNode;
    }

    public TokenNode execute_3(){
        TokenNode prev_tokenNode=currentLocation;
        System.out.println(" ");
        System.out.println("Excuting token, the token is current in "+currentLocation.toString());
        System.out.println(" ");
        this.currentLocation.execute_3(this);
        return prev_tokenNode;
    }

    public TokenNode executeProxy(){
        TokenNode prev_tokenNode=currentLocation;
        System.out.println(" ");
        System.out.println("Excuting token, the token is current in "+currentLocation.toString());
        System.out.println(" ");
        this.currentLocation.executeProxy(this);
        return prev_tokenNode;
    }



}
