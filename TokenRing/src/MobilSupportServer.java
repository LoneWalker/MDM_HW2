import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by xc9pd on 2/26/2016.
 */
public class MobilSupportServer extends TokenNode {

    private ArrayDeque request;
    private ArrayDeque grantQueue;
    private boolean waitingRingReturn;

    public HashMap<TokenNode,TokenNode> map;
    public boolean tk;
    public MobilSupportServer successor;
    public ArrayList<MobilHost> userList;

    //replication based protocol
    public PriorityQueue deliveryQueue;
    public ArrayList<MobilSupportServer> mssList;
    public ArrayDeque bufQueue;

    //proxy approach
    public Proxy proxy;




    public MobilSupportServer(String name){
        this.userList=new ArrayList<MobilHost>();
        this.name=name;
        this.waitingRingReturn=false;
        this.successor=null;
        this.request=new ArrayDeque<Quest>();
        this.grantQueue=new ArrayDeque<Quest>();
        this.map=new HashMap<TokenNode, TokenNode>();


this.proxy=null;

        //replication protocol
        this.deliveryQueue=new PriorityQueue<PriorityQuest>(100,new PriorityComparator() );
        this.bufQueue=new ArrayDeque<PriorityQuest>();
        this.mssList=new ArrayList<MobilSupportServer>();
    }

    public void addUser(MobilHost mh){
        this.userList.add(mh);
    }
    public void deleteUser(MobilHost mh){
        this.userList.remove(mh);
    }
    public void insertSuccessor(MobilSupportServer successor){
        if(this.successor==null){
            this.successor=successor;

        }else{
            successor.successor=this.successor;
            this.successor=successor;
        }
    }

    public boolean deleteSuccessor(){
        if(this.successor==null){
            return false;
        }else{
            this.successor=null;
            return true;
        }
    }

    //proxy
    public void addToProxy(Proxy p){
        this.proxy=p;
        p.mssList.add(this);
    }

    public void executeProxy(Token token){
        if(this.tk){
            System.out.println("The token is in the server "+this.name);
            System.out.println("Trying to forward the token to "+token.destination);
            this.tk=false;
            token.destination.addToken(token);

        }
        else{
            System.out.println("There is no token in the server");
        }
    }







    public void executeToken(Token token){

        if(this.tk) {


            //if the token is from MH like a return token after a request, the MSS will do the excuteQueue again.
            if (token.isRequestToken) {
                System.out.print(" The token is a return token from MobilHost " + token.from.toString());
                excuteQueue(token);
            }
            //if the token is a token pass from the parent MSS, the current MSS will put request to grant queue;
            else {
                if (token.from != null) {
                    System.out.println(" The token is from the parent MSS " + token.from.toString() + ". Now puting request queue to Grant queue");
                } else {
                    System.out.println(" Start process the initial token, Now puting request queue to Grant queue");
                }
                token.addRound(this);
                System.out.println("Current token round is "+token.round);
                putToGrantQueue(token);

            }
        }
        else {
            System.out.println("There is no token in the server");
        }

    }

    //333333333333333333333333333
    public void addPendingRequest(PriorityQuest pq){

        long priority=findLargestPriority();
        pq.priority=priority+10;
        pq.deliverable=true;
        this.deliveryQueue.add(pq);

        replicateToAllMSS(pq);
    }

    public void replicateToAllMSS(PriorityQuest pq){

        for(MobilSupportServer mss:mssList){
            mss.deliveryQueue.add(pq);
        }

    }

    public void deleteToAllMSS(PriorityQuest pq){
        this.deliveryQueue.remove(pq);
        for(MobilSupportServer mss:mssList){
            mss.deliveryQueue.remove(pq);
        }

    }


    public long findLargestPriority(){
        long max=0;
        for(MobilSupportServer mss:mssList){
            if(mss.deliveryQueue.peek()!=null){
                if(((PriorityQuest)mss.deliveryQueue.peek()).priority>max)max=((PriorityQuest)mss.deliveryQueue.peek()).priority;
            }
        }
        return max;
    }

    public void execute_3(Token token){
        if(this.tk) {
            //if the token is from MH like a return token after a request, the MSS will do the excuteQueue again.
            if (token.isRequestToken) {
                System.out.print(" The token is a return token from MobilHost " + token.from.toString());
                excuteQueue_3(token);
            }
            //if the token is a token pass from the parent MSS, the current MSS will put request to grant queue;
            else {

                if (token.from != null) {
                    System.out.println(" The token is from the parent MSS " + token.from.toString());
                } else {
                    System.out.println(" Start process the initial token");
                }
                token.addRound(this);
                System.out.println("Current token round is "+token.round);
                excuteQueue_3(token);


            }

        }else{
            System.out.println("There is no token in the server");
        }

    }

    public void release(PriorityQuest pq){
        for(MobilSupportServer mss:mssList){
            mss.deliveryQueue.remove(pq);
        }
    }
    public void excuteQueue_3(Token tk){
        if (this.deliveryQueue.peek() != null) {
            PriorityQuest pq = (PriorityQuest) this.deliveryQueue.peek();
            if (pq.deliverable && this.userList.contains(pq.q.questSource)) {
                pq=(PriorityQuest) this.deliveryQueue.poll();
                System.out.println("########The priority is "+pq.priority+" #########");
                tk.q=pq.q;
                tk.from=this;
                tk.destination=tk.q.questSource;
                tk.isRequestToken=true;
                release(pq);

                System.out.println("Excuting delivery queue, processing request from MobilHost "+tk.q.questSource+" the critical area is "+tk.q.criticalArea);
                forwardToken(tk);

            } else {
                this.bufQueue.add(this.deliveryQueue.poll());
                excuteQueue_3(tk);

            }
        }else{
            while(this.bufQueue.peek()!=null){
                this.deliveryQueue.add((PriorityQuest)this.bufQueue.poll());
            }
            System.out.println(". All request in the queue are excuted");
            tk.isRequestToken=false;
            tk.destination=this.successor;
            tk.from=this;
            tk.q=null;
            forwardToken(tk);
        }
    }




//111111111111111111111
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

            if(this.equals(this.map.get(token.destination))){

                System.out.println("The mobilHost is in current server "+this.name+", So directly send token to the mobilhost "+token.destination.toString());

                token.destination.addToken(token);
                //((MobilHost)token.destination).executeToken();

            }else{
                System.out.println("The mobilHost is not in current MSS "+this.name+", So forward token to the MSS "+this.map.get(token.destination).toString());

                this.map.get(token.destination).addToken(token);
                this.map.get(token.destination).forwardToken(token);
            }
        }else{
            System.out.println("There is no more requests in the queue and is going to pass the token to the successor "+this.successor.toString());
            this.successor.addToken(token);

        }


    }

    public void excuteQueue(Token tk){

        if(!this.grantQueue.isEmpty()){

            Quest q=(Quest)this.grantQueue.poll();
            tk.q=q;
            tk.from=this;
            tk.destination=q.questSource;
            tk.isRequestToken=true;

            System.out.println("Excuting Grant queue, processing request from MobilHost "+q.questSource+" the critical area is "+q.criticalArea);


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

    public boolean newMobilHostArrive(){


        return true;
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







}
