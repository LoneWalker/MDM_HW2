import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by xc9pd on 2/26/2016.
 */
public class MobilSupportServer extends TokenNode {

    private ArrayDeque request;
    private ArrayDeque grantQueue;
    private boolean waitingRingReturn;
<<<<<<< HEAD
    public HashMap<TokenNode,TokenNode> map;
    public boolean tk;
=======
    public HashMap<MobilHost,MobilSupportServer> map;
    public Token tk;
>>>>>>> 91a9c29ef51d0fbc7086b9c0ecb796bec57291b8
    public MobilSupportServer successor;
    public ArrayList<MobilHost> userList;


    public MobilSupportServer(String name){
        this.userList=new ArrayList<MobilHost>();
        this.name=name;
        this.waitingRingReturn=false;
        this.successor=null;
        this.request=new ArrayDeque<Quest>();
        this.grantQueue=new ArrayDeque<Quest>();
<<<<<<< HEAD
        this.map=new HashMap<TokenNode, TokenNode>();
=======
        this.map=new HashMap<MobilHost, MobilSupportServer>();
>>>>>>> 91a9c29ef51d0fbc7086b9c0ecb796bec57291b8
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

<<<<<<< HEAD
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
=======
    public void executeToken(){

        if(this.tk!=null) {
            Token ntk = new Token(this.tk);

            //if the token is from MH like a return token after a request, the MSS will do the excuteQueue again.
            if (ntk.isRequestToken) {
                System.out.print("The token is a return token from MobilHost " + ntk.from.toString());
                excuteQueue(ntk);
            }
            //if the token is a token pass from the parent MSS, the current MSS will put request to grant queue;
            else {
                if (ntk.from != null) {
                    System.out.println("The token is from the parent MSS " + ntk.from.toString() + ". Now puting request queue to Grant queue");
                } else {
                    System.out.println("Start process the initial token, Now puting request queue to Grant queue");
                }
                ntk.addRound(this);
                putToGrantQueue(ntk);
>>>>>>> 91a9c29ef51d0fbc7086b9c0ecb796bec57291b8
            }
        }
        else {
            System.out.println("There is no token in the server");
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

<<<<<<< HEAD
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
            System.out.println("There is no more requests in the grant queue and is going to pass the token to the successor "+this.successor.toString());
            this.successor.addToken(token);
=======
    public void forwardToken(Token tk){
        this.tk=null;
        Token ntk=new Token(tk);
        if(ntk.isRequestToken){

            if(this.equals(this.map.get(ntk.destination))){

                System.out.println("The mobilHost is in current server "+this.name+", So directly send token to the mobilhost "+ntk.destination.toString());

                ((MobilHost)ntk.destination).addToken(ntk);
                ((MobilHost)ntk.destination).executeToken();

            }else{
                System.out.println("The mobilHost is not in current MSS "+this.name+", So forward token to the MSS "+this.map.get(ntk.destination).toString());

                this.map.get(ntk.destination).addToken(ntk);
                this.map.get(ntk.destination).forwardToken(ntk);
            }
        }else{
            System.out.println("Finished all the request and is going to pass the token to the successor "+this.successor.toString());
            this.successor.addToken(ntk);
>>>>>>> 91a9c29ef51d0fbc7086b9c0ecb796bec57291b8
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

<<<<<<< HEAD
    public void addToken(Token token){
        this.tk=true;
        token.currentLocation=this;
        if(token.from!=null) {
            System.out.print("Server " + this.name + " Just receive a token from " + token.from.toString());
=======
    public void addToken(Token tk){
        this.tk=new Token(tk);
        if(tk.from!=null) {
            System.out.print("Server " + this.name + " Just receive a token from " + tk.from.toString());
>>>>>>> 91a9c29ef51d0fbc7086b9c0ecb796bec57291b8

        }
        else {
            System.out.println("Initial the token for MSS " + this.name);
        }
        //executeToken();
    }







}
