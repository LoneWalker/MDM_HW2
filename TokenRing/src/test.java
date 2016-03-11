import java.util.ArrayList;

/**
 * Created by xc9pd on 3/9/2016.
 */
public class test {

    public ArrayList<TokenNode> nodeList;
    public Token tk;

    public static void main(String[] arg){




        ProjectConstants.CURRENT_SCHEME=ProjectConstants.SCHEME_INFORM;
        test obj= new test();
        obj.initReplicationScheme();


        ControlUI controlUI= new ControlUI(obj);
        controlUI.setVisible(true);
    }


    private void init(){

        MobilSupportServer mss1=new MobilSupportServer("MSS_1");
        MobilSupportServer mss2=new MobilSupportServer("MSS_2");
        MobilSupportServer mss3=new MobilSupportServer("MSS_3");
        MobilSupportServer mss4=new MobilSupportServer("MSS_4");
        MobilSupportServer mss5=new MobilSupportServer("MSS_5");

        nodeList=new ArrayList<TokenNode>();
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

        tk=new Token(mss1);

        mss1.addToken(tk);


        /*
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
         */

    }

    public void initInfoScheme(){

        init();
    }
    public void initProxyScheme(){

    }
    public void initReplicationScheme(){
        MobilSupportServer mss1=new MobilSupportServer("MSS_1");
        MobilSupportServer mss2=new MobilSupportServer("MSS_2");
        MobilSupportServer mss3=new MobilSupportServer("MSS_3");
        MobilSupportServer mss4=new MobilSupportServer("MSS_4");
        MobilSupportServer mss5=new MobilSupportServer("MSS_5");

        nodeList=new ArrayList<TokenNode>();
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

        tk=new Token(mss1);
        mss1.addToken(tk);

        /*
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
         */


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
