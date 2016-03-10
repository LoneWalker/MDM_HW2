/**
 * Created by xc9pd on 2/26/2016.
 */
<<<<<<< HEAD
public class MobilHost extends TokenNode{
=======
public class MobilHost {
>>>>>>> 91a9c29ef51d0fbc7086b9c0ecb796bec57291b8
    public MobilSupportServer currentServer;
    public MobilSupportServer prevousServer;
    private boolean availableForSubmit;
    private boolean isHoldingToken;
<<<<<<< HEAD
    private boolean tk;
=======
    private Token tk;
>>>>>>> 91a9c29ef51d0fbc7086b9c0ecb796bec57291b8

    public String name;
    public MobilHost(String name){
        this.name=name;
        this.availableForSubmit=true;
        this.isHoldingToken=false;
<<<<<<< HEAD
        this.tk=false;
=======
        this.tk=null;
>>>>>>> 91a9c29ef51d0fbc7086b9c0ecb796bec57291b8
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
<<<<<<< HEAD
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
=======
        this.prevousServer=this.currentServer;
        this.currentServer=mss;
        if(prevousServer!=null) {
            this.prevousServer.map.put(this, currentServer);

            this.prevousServer.userList.remove(this);
        }
        if(currentServer!=null) {
            this.currentServer.map.put(this, currentServer);
            this.currentServer.userList.add(this);
>>>>>>> 91a9c29ef51d0fbc7086b9c0ecb796bec57291b8
        }
    }


<<<<<<< HEAD
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
=======
    public void addToken(Token tk){
        this.tk=tk;
        this.isHoldingToken=true;
        this.availableForSubmit=false;

        executeToken();
    }

    public void executeToken(){
        System.out.println("MobilHost "+this.name+" Just received a token from "+this.tk.from);
        System.out.println("         After access critical area "+this.tk.q.criticalArea+", Token is going back to "+ this.tk.from);
        Token ntk=new Token(this.tk);
        ntk.destination=ntk.from;
        ntk.from=this;
        ntk.isRequestToken=true;
        this.tk=null;
        ((MobilSupportServer)ntk.destination).addToken(ntk);
        ((MobilSupportServer)ntk.destination).executeToken();
>>>>>>> 91a9c29ef51d0fbc7086b9c0ecb796bec57291b8

    }


    public String toString(){
        return this.name;
    }



}
