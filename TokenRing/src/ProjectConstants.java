import java.io.File;

/**
 * Created by azhar on 3/10/16.
 */
public class ProjectConstants {

    public static String SCHEME_INFORM="Inform Scheme";
    public static String SCHEME_PROXY="Proxy Scheme";
    public static String SCHEME_REPLICATION="Replication Scheme";

    public static String CURRENT_SCHEME;

    //for node coloring
    public static int NODE_COLOR_DEFAULT=0;
    public static int NODE_COLOR_DELETED=1;
    public static int NODE_COLOR_UPDATED=2;
    public static int NODE_COLOR_CALLTRACE=3;

    public static Integer requestCounter=0;


    public static int VERTEX_TYPE_PROXY=0;
    public static int VERTEX_TYPE_MSS=1;
    public static int VERTEX_TYPE_MH=2;


}
