/**
 * Created by xc9pd on 2/26/2016.
 */
public class MobilHost {
    public MobilSupportServer currentServer;
    public MobilSupportServer prevousServer;
    private boolean availableForSubmit;
    private boolean isHoldingToken;
    private Token tk;

    public String name;
    public MobilHost(String name){
        this.name=name;
        this.availableForSubmit=true;
        this.isHoldingToken=false;
        this.tk=null;
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
        this.prevousServer=this.currentServer;
        this.currentServer=mss;
        if(prevousServer!=null) {
            this.prevousServer.map.put(this, currentServer);

            this.prevousServer.userList.remove(this);
        }
        if(currentServer!=null) {
            this.currentServer.map.put(this, currentServer);
            this.currentServer.userList.add(this);
        }
    }


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

    }


    public String toString(){
        return this.name;
    }



}
