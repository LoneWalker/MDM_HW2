/**
 * Created by xc9pd on 2/26/2016.
 */
public class MobilHost extends TokenNode{
    public MobilSupportServer currentServer;
    public MobilSupportServer prevousServer;
    private boolean availableForSubmit;
    private boolean isHoldingToken;
    private boolean tk;

    public String name;
    public MobilHost(String name){
        this.name=name;
        this.availableForSubmit=true;
        this.isHoldingToken=false;
        this.tk=false;
        currentServer=null;
        prevousServer=null;

    }

    public void submitRequest(String criticalArea){

        if(availableForSubmit) {
            Quest q=new Quest(this,this.currentServer,criticalArea);

            this.currentServer.addRequest(q);
            this.availableForSubmit = false;

            System.out.println("User "+this.name+" is submitting request to the server "+this.currentServer.toString());
        }
    }

    public void moveTo(MobilSupportServer mss){
        if(!isHoldingToken) {
            this.prevousServer = this.currentServer;
            this.currentServer = mss;
            if (prevousServer != null) {
                this.prevousServer.map.put(this, currentServer);

                this.prevousServer.userList.remove(this);
            }
            if (currentServer != null) {
                this.currentServer.map.put(this, currentServer);
                this.currentServer.userList.add(this);
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

    public void forwardToken(Token token){
        token.destination=token.from;
        token.from=this;
        token.isRequestToken=true;
        this.tk=false;
        this.isHoldingToken=false;
        token.destination.addToken(token);

    }


    public String toString(){
        return this.name;
    }



}
