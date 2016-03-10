/**
 * Created by xc9pd on 2/26/2016.
 */
public class Quest {
    public MobilHost questSource;
    public MobilSupportServer questStartServer;
    public String criticalArea;
    public Quest(MobilHost mh,MobilSupportServer mss, String area){
        this.questSource=mh;
        this.questStartServer=mss;
        this.criticalArea=area;
    }

}
