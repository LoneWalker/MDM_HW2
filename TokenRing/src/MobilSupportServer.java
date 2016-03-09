import java.util.ArrayDeque;

/**
 * Created by xc9pd on 2/26/2016.
 */
public class MobilSupportServer extends TokenNode {

    private ArrayDeque request;
    private ArrayDeque grantQueue;
    private boolean waitingRingReturn;

    public MobilSupportServer successor;

    public MobilSupportServer(){

        this.waitingRingReturn=false;
        this.successor=null;
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

    public void executeToken(){

    }

    public void addRequest(Quest q){

    }

    public void putToGrantQueue(){

    }

    public void forwardToken(){

    }

    public void excuteQueue(){

    }

    public boolean newMobilHostArrive(){


        return true;
    }







}
