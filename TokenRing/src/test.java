import edu.uci.ics.jung.graph.DirectedOrderedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;

import java.util.ArrayList;

/**
 * Created by xc9pd on 3/9/2016.
 */

public class test {

    public ArrayList<TokenNode> nodeList;
    public Token tk;
    public GraphPanel graphVisualizer;
    Graph<TokenNode, Number> graph;
    public Integer edgeCounter=0;

    public static void main(String[] arg){




        ProjectConstants.CURRENT_SCHEME=ProjectConstants.SCHEME_INFORM;
        test obj= new test();

        obj.init();



        ControlUI controlUI= new ControlUI(obj);
        controlUI.setVisible(true);
    }


    private void init(){



        if (graphVisualizer!=null){
            graphVisualizer.close();
        }

        edgeCounter=0;

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

        mh1.moveTo(mss1);
        mh2.moveTo(mss2);
        mh3.moveTo(mss3);
        mh4.moveTo(mss4);
        mh5.moveTo(mss5);

        tk=new Token(mss1);

        mss1.addToken(tk);


        //for graph visualization


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
        edgeCounter=0;

        /*

        Proxy p1=new Proxy("proxy_1");
        Proxy p2=new Proxy("proxy_2");
        MobilSupportServer mss1=new MobilSupportServer("MSS_1");
        MobilSupportServer mss2=new MobilSupportServer("MSS_2");
        MobilSupportServer mss3=new MobilSupportServer("MSS_3");
        MobilSupportServer mss4=new MobilSupportServer("MSS_4");
        MobilSupportServer mss5=new MobilSupportServer("MSS_5");

        nodeList=new ArrayList<TokenNode>();

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

        tk=new Token(p1);
        p1.addToken(tk);


*/





        graph   =   new DirectedOrderedSparseMultigraph<TokenNode, Number>();

        Proxy vertex1 = new Proxy("P_1");
        Proxy vertex2 = new Proxy("P_2");
        Proxy vertex3 = new Proxy("P_3");
        Proxy vertex4 = new Proxy("P_4");

        MobilSupportServer vertex5 = new MobilSupportServer("MSS_1");
        MobilSupportServer vertex6 = new MobilSupportServer("MSS_2");
        MobilSupportServer vertex7 = new MobilSupportServer("MSS_3");
        MobilSupportServer vertex8 = new MobilSupportServer("MSS_4");
        MobilSupportServer vertex9 = new MobilSupportServer("MSS_5");
        MobilSupportServer vertex10 = new MobilSupportServer("MSS_6");
        MobilSupportServer vertex11 = new MobilSupportServer("MSS_7");
        MobilSupportServer vertex12 = new MobilSupportServer("MSS_8");



        //for logical part
        nodeList=new ArrayList<TokenNode>();
        nodeList.add(vertex1);
        nodeList.add(vertex2);
        nodeList.add(vertex3);
        nodeList.add(vertex4);

        vertex5.addToProxy(vertex1);
        vertex6.addToProxy(vertex1);
        vertex7.addToProxy(vertex2);
        vertex8.addToProxy(vertex2);
        vertex9.addToProxy(vertex3);
        vertex10.addToProxy(vertex3);
        vertex11.addToProxy(vertex4);
        vertex12.addToProxy(vertex4);

        vertex1.successor=vertex2;
        vertex2.successor=vertex3;
        vertex3.successor=vertex4;
        vertex4.successor = vertex1;


        MobilHost mh1=new MobilHost("MH_1");
        MobilHost mh2=new MobilHost("MH_2");
        MobilHost mh3=new MobilHost("MH_3");
        MobilHost mh4=new MobilHost("MH_4");
        MobilHost mh5=new MobilHost("MH_5");
        MobilHost mh6=new MobilHost("MH_6");
        MobilHost mh7=new MobilHost("MH_7");
        MobilHost mh8=new MobilHost("MH_8");
        MobilHost mh9=new MobilHost("MH_9");
        MobilHost mh10=new MobilHost("MH_10");
        MobilHost mh11=new MobilHost("MH_11");
        MobilHost mh12=new MobilHost("MH_12");
        MobilHost mh13=new MobilHost("MH_13");
        MobilHost mh14=new MobilHost("MH_14");
        MobilHost mh15=new MobilHost("MH_15");
        MobilHost mh16=new MobilHost("MH_16");

        mh1.moveTo_Proxy(vertex5);
        mh2.moveTo_Proxy(vertex5);
        mh3.moveTo_Proxy(vertex6);
        mh4.moveTo_Proxy(vertex6);
        mh5.moveTo_Proxy(vertex7);
        mh6.moveTo_Proxy(vertex7);
        mh7.moveTo_Proxy(vertex8);
        mh8.moveTo_Proxy(vertex8);
        mh9.moveTo_Proxy(vertex9);
        mh10.moveTo_Proxy(vertex9);
        mh11.moveTo_Proxy(vertex10);
        mh12.moveTo_Proxy(vertex10);
        mh13.moveTo_Proxy(vertex11);
        mh14.moveTo_Proxy(vertex11);
        mh15.moveTo_Proxy(vertex12);
        mh16.moveTo_Proxy(vertex12);

        tk=new Token(vertex1);
        vertex1.addToken(tk);



        /*
        final TokenNode vertex13 = new MobilSupportServer("13");
        final TokenNode vertex14 = new TokenNode("14",1);
        final TokenNode vertex15 = new TokenNode("15",1);
        final TokenNode vertex16 = new TokenNode("16",1);
        final TokenNode vertex17 = new TokenNode("17",1);
        final TokenNode vertex18 = new TokenNode("18",1);
        final TokenNode vertex19 = new TokenNode("19",1);
        final TokenNode vertex20 = new TokenNode("20",1);
        /*
        final String vertex6 = "6";
        final String vertex7 = "7";
        final String vertex8 = "8";
        final String vertex9 = "9";


*/
        /************for graph visualization**************/

        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);
        graph.addVertex(vertex6);
        graph.addVertex(vertex7);
        graph.addVertex(vertex8);
        graph.addVertex(vertex9);
        graph.addVertex(vertex10);
        graph.addVertex(vertex11);
        graph.addVertex(vertex12);

        /*
        graph.addVertex(vertex13);
        graph.addVertex(vertex14);
        graph.addVertex(vertex15);
        graph.addVertex(vertex16);
        graph.addVertex(vertex17);
        graph.addVertex(vertex18);
        graph.addVertex(vertex19);
        graph.addVertex(vertex20);
    */

        //proxy
        graph.addEdge(edgeCounter++, vertex1, vertex2);
        graph.addEdge(edgeCounter++, vertex2, vertex3);
        graph.addEdge(edgeCounter++, vertex3, vertex4);
        graph.addEdge(edgeCounter++, vertex4, vertex1);

        //mss

        graph.addEdge(edgeCounter++, vertex5, vertex1);
        graph.addEdge(edgeCounter++, vertex6, vertex1);
        graph.addEdge(edgeCounter++, vertex7, vertex2);
        graph.addEdge(edgeCounter++, vertex8, vertex2);
        graph.addEdge(edgeCounter++, vertex9, vertex3);
        graph.addEdge(edgeCounter++, vertex10, vertex3);
        graph.addEdge(edgeCounter++, vertex11, vertex4);
        graph.addEdge(edgeCounter++, vertex12, vertex4);


        if (graphVisualizer!=null){
            graphVisualizer.close();
        }

        graphVisualizer=new GraphPanel(graph);



        /*
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
         */

    }

    public void initReplicationScheme(){



        edgeCounter=0;
        if (graphVisualizer!=null){
            graphVisualizer.close();
        }

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


        mh1.moveTo(mss1);
        mh2.moveTo(mss2);
        mh3.moveTo(mss3);
        mh4.moveTo(mss4);
        mh5.moveTo(mss5);

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
