/**
 * Created by xc9pd on 2/26/2016.
 */
public class MobilHost {
    public MobilSupportServer currentServer;
    public MobilSupportServer prevousServer;
    private boolean availableForSubmit;
    private boolean isHoldingToken;

    public MobilHost(){
        this.availableForSubmit=true;
    }

    public void submitRequest(MobilHost targetMH){


        this.availableForSubmit=false;
    }

    public void connectToServer(MobilSupportServer mss){




    }

    public void leavingCurrentServer(){


    }



}
