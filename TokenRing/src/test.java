import java.util.ArrayList;

/**
 * Created by xc9pd on 3/9/2016.
 */
public class test {

    public ArrayList<TokenNode> nodeList;


    public static void main(String[] arg){




        ProjectConstants.CURRENT_SCHEME=ProjectConstants.SCHEME_INFORM;
        test obj= new test();
        obj.nodeList=new ArrayList<TokenNode>();
        obj.initProxyScheme();


        ControlUI controlUI= new ControlUI(obj);
    }


    public void init(){


        MobilSupportServer mss1=new MobilSupportServer("MSS_1");
        MobilSupportServer mss2=new MobilSupportServer("MSS_2");
        MobilSupportServer mss3=new MobilSupportServer("MSS_3");
        MobilSupportServer mss4=new MobilSupportServer("MSS_4");
        MobilSupportServer mss5=new MobilSupportServer("MSS_5");

        nodeList.add(mss1);
        nodeList.add(mss2);
        nodeList.add(mss3);
        nodeList.add(mss4);
        nodeList.add(mss5);

        mss1.successor=mss2;
        mss2.successor=mss3;
        mss3.successor=mss4;
        mss4.successor=mss5;
        mss5.successor=mss1;
        MobilHost mh1=new MobilHost("MH_1");
        MobilHost mh2=new MobilHost("MH_2");
        MobilHost mh3=new MobilHost("MH_3");
        MobilHost mh4=new MobilHost("MH_4");
        MobilHost mh5=new MobilHost("MH_5");
        mh1.moveTo(mss1);
        mh2.moveTo(mss2);
        mh3.moveTo(mss3);
        mh4.moveTo(mss4);
        mh5.moveTo(mss5);

        Token tk=new Token(mss1);

        mh1.submitRequest("a");
        mh2.submitRequest("b");
        mh3.submitRequest("c");
        mh4.submitRequest("d");
        mh5.submitRequest("e");

        mss1.addToken(tk);
        tk.executeToken();
        tk.executeToken();
        mh2.moveTo(mss3);
        tk.executeToken();
        tk.executeToken();
        tk.executeToken();
        tk.executeToken();
        tk.executeToken();
        tk.executeToken();
        System.out.println("end?");

    }

    public void initInfoScheme(){

        init();
    }
    public void initProxyScheme(){

        Proxy p1=new Proxy("proxy_1");
        Proxy p2=new Proxy("proxy_2");
        MobilSupportServer mss1=new MobilSupportServer("MSS_1");
        MobilSupportServer mss2=new MobilSupportServer("MSS_2");
        MobilSupportServer mss3=new MobilSupportServer("MSS_3");
        MobilSupportServer mss4=new MobilSupportServer("MSS_4");
        MobilSupportServer mss5=new MobilSupportServer("MSS_5");

        nodeList.add(p1);
        nodeList.add(p2);

        mss1.addToProxy(p1);
        mss2.addToProxy(p1);
        mss3.addToProxy(p1);
        mss4.addToProxy(p2);
        mss5.addToProxy(p2);

        p1.successor=p2;
        p2.successor=p1;

        MobilHost mh1=new MobilHost("MH_1");
        MobilHost mh2=new MobilHost("MH_2");
        MobilHost mh3=new MobilHost("MH_3");
        MobilHost mh4=new MobilHost("MH_4");
        MobilHost mh5=new MobilHost("MH_5");

        mh1.moveTo_Proxy(mss1);
        mh2.moveTo_Proxy(mss2);
        mh3.moveTo_Proxy(mss3);
        mh4.moveTo_Proxy(mss4);
        mh5.moveTo_Proxy(mss5);

        Token tk=new Token(p1);

        mh1.submitRequest_proxy("a");
        mh2.submitRequest_proxy("b");
        mh3.submitRequest_proxy("c");
        mh4.submitRequest_proxy("d");
        mh5.submitRequest_proxy("e");

        p1.addToken(tk);
        tk.executeProxy();
        tk.executeProxy();
        mh3.moveTo_Proxy(mss4);
        tk.executeProxy();
        tk.executeProxy();
        tk.executeProxy();
        tk.executeProxy();
        tk.executeProxy();
        tk.executeProxy();
        tk.executeProxy();
        tk.executeProxy();
        tk.executeProxy();
        tk.executeProxy();
        tk.executeProxy();
        tk.executeProxy();
        tk.executeProxy();
        tk.executeProxy();
        tk.executeProxy();
        tk.executeProxy();
        tk.executeProxy();
        tk.executeProxy();

    }

    public void initReplicationScheme(){
        MobilSupportServer mss1=new MobilSupportServer("MSS_1");
        MobilSupportServer mss2=new MobilSupportServer("MSS_2");
        MobilSupportServer mss3=new MobilSupportServer("MSS_3");
        MobilSupportServer mss4=new MobilSupportServer("MSS_4");
        MobilSupportServer mss5=new MobilSupportServer("MSS_5");

        nodeList.add(mss1);
        nodeList.add(mss2);
        nodeList.add(mss3);
        nodeList.add(mss4);
        nodeList.add(mss5);

        initLocalListOfMSS(nodeList);

        mss1.successor=mss2;
        mss2.successor=mss3;
        mss3.successor=mss4;
        mss4.successor=mss5;
        mss5.successor=mss1;
        MobilHost mh1=new MobilHost("MH_1");
        MobilHost mh2=new MobilHost("MH_2");
        MobilHost mh3=new MobilHost("MH_3");
        MobilHost mh4=new MobilHost("MH_4");
        MobilHost mh5=new MobilHost("MH_5");
        mh1.moveTo(mss1);
        mh2.moveTo(mss2);
        mh3.moveTo(mss3);
        mh4.moveTo(mss4);
        mh5.moveTo(mss5);

        Token tk=new Token(mss1);
        mh1.request("a");
        mh2.request("b");
        mh3.request("c");
        mh4.request("d");
        mh5.request("e");

        mss1.addToken(tk);
        tk.execute_3();
        tk.execute_3();
        mh3.moveTo(mss2);
        tk.execute_3();
        tk.execute_3();
        tk.execute_3();
        tk.execute_3();
        tk.execute_3();
        tk.execute_3();
        tk.execute_3();
        tk.execute_3();
        tk.execute_3();
        tk.execute_3();
        tk.execute_3();
        tk.execute_3();
        System.out.println("end?");







    }

    public void initLocalListOfMSS(ArrayList<TokenNode> msslist){

        for(TokenNode mss:msslist){
            for (TokenNode mss2:msslist){
                if(!mss.equals(mss2)) {
                    ((MobilSupportServer) mss).mssList.add((MobilSupportServer)mss2);

                }
            }
        }
    }



}
