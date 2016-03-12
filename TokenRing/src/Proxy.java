import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by azhar on 3/9/16.
 */
public class Proxy extends TokenNode {
    private ArrayDeque request;
    private ArrayDeque grantQueue;
    private boolean waitingRingReturn;

    public HashMap<TokenNode,TokenNode> map;
    public boolean tk;
    public Proxy successor;
    public ArrayList<MobilSupportServer> mssList;

    public Proxy(String name){
        super(name,ProjectConstants.VERTEX_TYPE_PROXY);

        this.mssList=new ArrayList<MobilSupportServer>();
        this.name=name;
        this.waitingRingReturn=false;
        this.successor=null;
        this.request=new ArrayDeque<Quest>();
        this.grantQueue=new ArrayDeque<Quest>();
        this.map=new HashMap<TokenNode, TokenNode>();


    }


    public void addUser(MobilSupportServer mh){
        this.mssList.add(mh);
    }
    public void deleteUser(MobilSupportServer mh){
        this.mssList.remove(mh);
    }

    public void executeProxy(Token token){
        if(this.tk) {

            if (token.isRequestToken) {
                System.out.print(" The token is a return token from MobilHost " + token.from.toString());
                excuteQueue(token);

            }else{

                if (token.from != null) {
                    System.out.println(" The token is from the parent parent " + token.from.toString() + ". Now puting request queue to Grant queue");
                } else {
                    System.out.println(" Start process the initial token, Now puting request queue to Grant queue");
                }
                putToGrantQueue(token);
            }


        }
        else {
            System.out.println("There is no token in the proxy");
        }
    }

    public void addRequest(Quest q){

        this.request.add(q);
    }

    public void putToGrantQueue(Token tk){

        while(!this.request.isEmpty()){
            this.grantQueue.add(this.request.poll());
        }
        if(!this.grantQueue.isEmpty()){
            //System.out.println("Start executing the granted queue");
            excuteQueue(tk);
        }
        else{
            tk.q=null;
            tk.from=this;
            tk.destination=this.successor;
            tk.isRequestToken=false;
            forwardToken(tk);
        }
    }

    public void forwardToken(Token token){
        this.tk=false;

        if(token.isRequestToken){

            if(this.equals(((MobilSupportServer)(this.map.get(token.destination))).proxy)){

                System.out.println("The mobilHost is in current proxy "+this.name+", So directly send token to the mobilhost's server "+(this.map.get(token.destination)).toString());

                (this.map.get(token.destination)).addToken(token);
                //((MobilHost)token.destination).executeToken();

            }else{
                System.out.println("The mobilHost is not in current proxy "+this.name+", So forward token to the proxy "+((MobilSupportServer)(this.map.get(token.destination))).proxy.toString());

                ((MobilSupportServer)(this.map.get(token.destination))).proxy.addToken(token);
                ((MobilSupportServer)(this.map.get(token.destination))).proxy.forwardToken(token);
            }
        }else{
            System.out.println("There is no more requests in the Grant queue and is going to pass the token to the successor proxy"+this.successor.toString());
            this.successor.addToken(token);

        }

    }

    public void addToken(Token token){
        this.tk=true;
        token.currentLocation=this;
        if(token.from!=null) {
            System.out.print("Server " + this.name + " Just receive a token from " + token.from.toString());


        }
        else {
            System.out.println("Initial the token for MSS " + this.name);
        }
        //executeToken();
    }

    public void excuteQueue(Token tk){

        if(!this.grantQueue.isEmpty()){

            Quest q=(Quest)this.grantQueue.poll();
            tk.q=q;
            tk.from=this;
            tk.destination=q.questSource;
            tk.isRequestToken=true;

            System.out.println("Excuting Grant queue, processing request from user "+q.questSource+" the critical area is "+q.criticalArea);


            forwardToken(tk);

        }else {
            if(!tk.destination.equals(this)){
                System.out.println("");
                forwardToken(tk);
            }
            else{
                System.out.println(". All request in the queue are excuted");
                tk.isRequestToken=false;
                tk.destination=this.successor;
                tk.from=this;
                tk.q=null;
                forwardToken(tk);
            }

        }
    }

    public String toString(){
        return this.name;
    }















}


