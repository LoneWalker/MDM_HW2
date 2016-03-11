/**
 * Created by xc9pd on 2/26/2016.
 */

public class MobilHost extends TokenNode{
    public MobilSupportServer currentServer;
    public MobilSupportServer prevousServer;
    private boolean availableForSubmit;
    private boolean isHoldingToken;
    private boolean tk;

    //replication approach
    public int h_count;

    public String name;
    public MobilHost(String name){
        this.name=name;
        this.availableForSubmit=true;
        this.isHoldingToken=false;
        this.tk=false;
        currentServer=null;
        prevousServer=null;

        //3
        this.h_count=0;

    }

    public void submitRequest(String criticalArea){

        if(availableForSubmit) {
            Quest q=new Quest(this,this.currentServer,criticalArea);

            this.currentServer.addRequest(q);
            this.availableForSubmit = false;

            System.out.println("User "+this.name+" is submitting request to the server "+this.currentServer.toString());




        }
    }

    //3
    public void request(String criticalArea){

        //3
        if(this.availableForSubmit) {
            this.h_count++;
            Quest q = new Quest(this, this.currentServer, criticalArea);
            PriorityQuest pq = new PriorityQuest(q, this.h_count);
            this.currentServer.addPendingRequest(pq);
            System.out.println("User "+this.name+" is submitting request to the server "+this.currentServer.toString());
        }
    }


    public void execute_3(Token token){
        System.out.println("MobilHost "+this.name+" Just received a token from "+token.from.toString());
        System.out.println("         After access critical area "+token.q.criticalArea+", Token is going back to "+ token.from.toString());

        this.availableForSubmit=true;

        forwardToken(token);
    }

//222222222222
    public void executeProxy(Token token){
        System.out.println("MobilHost "+this.name+" Just received a token");
        System.out.println("         After access critical area "+token.q.criticalArea+", Token is going back to "+ token.from.toString());

        this.availableForSubmit=true;

        forwardToken(token);
    }


    public void submitRequest_proxy(String criticalArea){

        if(availableForSubmit) {
            Quest q=new Quest(this,this.currentServer,criticalArea);

            this.currentServer.proxy.addRequest(q);
            this.availableForSubmit = false;

            System.out.println("User "+this.name+" is submitting request to the proxy "+this.currentServer.proxy.toString());




        }
    }

    public void moveTo_Proxy(MobilSupportServer mss){
        if(!isHoldingToken) {
            this.prevousServer = this.currentServer;
            this.currentServer = mss;
            if (prevousServer != null) {
                this.prevousServer.proxy.map.put(this, currentServer);

                this.prevousServer.deleteUser(this);
                this.prevousServer.map.remove(this);
            }
            if (currentServer != null) {
                this.currentServer.map.put(this, currentServer);
                this.currentServer.proxy.map.put(this,currentServer);
                this.currentServer.addUser(this);
            }
        }else{
            System.out.println("Failed to move to the server "+mss.toString()+". Because the user is holding a token.");

        }
    }


    public void moveTo(MobilSupportServer mss){
        if(!isHoldingToken) {
            this.prevousServer = this.currentServer;
            this.currentServer = mss;
            if (prevousServer != null) {
                this.prevousServer.map.put(this, currentServer);

                this.prevousServer.deleteUser(this);
            }
            if (currentServer != null) {
                this.currentServer.map.put(this, currentServer);
                this.currentServer.addUser(this);
            }
        }else{
            System.out.println("Failed to move to the server "+mss.toString()+". Because the user is holding a token.");

        }
    }



    public void addToken(Token token){
        this.tk=true;
        this.isHoldingToken=true;
        this.availableForSubmit=false;
        token.currentLocation=this;

        //executeToken(token);
    }

    public void executeToken(Token token){
        System.out.println("MobilHost "+this.name+" Just received a token from "+token.from);
        System.out.println("         After access critical area "+token.q.criticalArea+", Token is going back to "+ token.from);

        this.availableForSubmit=true;
        forwardToken(token);


    }



    public void forwardToken(Token token) {
        token.destination = token.from;
        token.from = this;
        token.isRequestToken = true;
        this.tk = false;
        this.isHoldingToken = false;
        System.out.println("Return token from "+this.name+" to "+token.destination.toString());
        token.destination.addToken(token);
    }




    public String toString(){
        return this.name;
    }



}
