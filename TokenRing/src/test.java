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

    public void initInfoScheme(){

        init();
    }
    public void initProxyScheme(){


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




        /************for graph visualization**************/


        edgeCounter=0;
        graph   =   new DirectedOrderedSparseMultigraph<TokenNode, Number>();

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

    }

    public void initReplicationScheme(){


        MobilSupportServer mss1=new MobilSupportServer("MSS_1");
        MobilSupportServer mss2=new MobilSupportServer("MSS_2");
        MobilSupportServer mss3=new MobilSupportServer("MSS_3");
        MobilSupportServer mss4=new MobilSupportServer("MSS_4");
        MobilSupportServer mss5=new MobilSupportServer("MSS_5");
        MobilSupportServer mss6=new MobilSupportServer("MSS_6");
        MobilSupportServer mss7=new MobilSupportServer("MSS_7");
        MobilSupportServer mss8=new MobilSupportServer("MSS_8");


        nodeList=new ArrayList<TokenNode>();
        nodeList.add(mss1);
        nodeList.add(mss2);
        nodeList.add(mss3);
        nodeList.add(mss4);
        nodeList.add(mss5);
        nodeList.add(mss6);
        nodeList.add(mss7);
        nodeList.add(mss8);

        initLocalListOfMSS(nodeList);


        mss1.successor=mss2;
        mss2.successor=mss3;
        mss3.successor=mss4;
        mss4.successor=mss5;
        mss5.successor=mss6;
        mss6.successor=mss7;
        mss7.successor=mss8;
        mss8.successor=mss1;

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

        mh1.moveTo(mss1);
        mh2.moveTo(mss1);
        mh3.moveTo(mss2);
        mh4.moveTo(mss2);
        mh5.moveTo(mss3);
        mh6.moveTo(mss3);
        mh7.moveTo(mss4);
        mh8.moveTo(mss4);
        mh9.moveTo(mss5);
        mh10.moveTo(mss5);
        mh11.moveTo(mss6);
        mh12.moveTo(mss6);
        mh13.moveTo(mss7);
        mh14.moveTo(mss7);
        mh15.moveTo(mss8);
        mh16.moveTo(mss8);

        tk=new Token(mss1);
        mss1.addToken(tk);



        /************************ Code for graph visualization******************/

        edgeCounter =   0;
        graph   =   new DirectedOrderedSparseMultigraph<TokenNode, Number>();

        graph.addVertex(mss1);
        graph.addVertex(mss2);
        graph.addVertex(mss3);
        graph.addVertex(mss4);
        graph.addVertex(mss5);
        graph.addVertex(mss6);
        graph.addVertex(mss7);
        graph.addVertex(mss8);


        graph.addEdge(edgeCounter++,mss1,mss2);
        graph.addEdge(edgeCounter++,mss2,mss3);
        graph.addEdge(edgeCounter++,mss3,mss4);
        graph.addEdge(edgeCounter++,mss4,mss5);
        graph.addEdge(edgeCounter++,mss5,mss6);
        graph.addEdge(edgeCounter++,mss6,mss7);
        graph.addEdge(edgeCounter++,mss7,mss8);
        graph.addEdge(edgeCounter++,mss8,mss1);


        if (graphVisualizer!=null){
            graphVisualizer.close();
        }
        graphVisualizer=new GraphPanel(graph);


    }


    private void init(){

        MobilSupportServer mss1=new MobilSupportServer("MSS_1");
        MobilSupportServer mss2=new MobilSupportServer("MSS_2");
        MobilSupportServer mss3=new MobilSupportServer("MSS_3");
        MobilSupportServer mss4=new MobilSupportServer("MSS_4");
        MobilSupportServer mss5=new MobilSupportServer("MSS_5");
        MobilSupportServer mss6=new MobilSupportServer("MSS_6");
        MobilSupportServer mss7=new MobilSupportServer("MSS_7");
        MobilSupportServer mss8=new MobilSupportServer("MSS_8");

        nodeList=new ArrayList<TokenNode>();
        nodeList.add(mss1);
        nodeList.add(mss2);
        nodeList.add(mss3);
        nodeList.add(mss4);
        nodeList.add(mss5);
        nodeList.add(mss6);
        nodeList.add(mss7);
        nodeList.add(mss8);

        mss1.successor=mss2;
        mss2.successor=mss3;
        mss3.successor=mss4;
        mss4.successor=mss5;
        mss5.successor=mss6;
        mss6.successor=mss7;
        mss7.successor=mss8;
        mss8.successor=mss1;

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

        mh1.moveTo(mss1);
        mh2.moveTo(mss1);
        mh3.moveTo(mss2);
        mh4.moveTo(mss2);
        mh5.moveTo(mss3);
        mh6.moveTo(mss3);
        mh7.moveTo(mss4);
        mh8.moveTo(mss4);
        mh9.moveTo(mss5);
        mh10.moveTo(mss5);
        mh11.moveTo(mss6);
        mh12.moveTo(mss6);
        mh13.moveTo(mss7);
        mh14.moveTo(mss7);
        mh15.moveTo(mss8);
        mh16.moveTo(mss8);

        tk=new Token(mss1);
        mss1.addToken(tk);


        /***************** Code for Graph visualization****************/


        edgeCounter =   0;
        graph   =   new DirectedOrderedSparseMultigraph<TokenNode, Number>();

        graph.addVertex(mss1);
        graph.addVertex(mss2);
        graph.addVertex(mss3);
        graph.addVertex(mss4);
        graph.addVertex(mss5);
        graph.addVertex(mss6);
        graph.addVertex(mss7);
        graph.addVertex(mss8);


        graph.addEdge(edgeCounter++,mss1,mss2);
        graph.addEdge(edgeCounter++,mss2,mss3);
        graph.addEdge(edgeCounter++,mss3,mss4);
        graph.addEdge(edgeCounter++,mss4,mss5);
        graph.addEdge(edgeCounter++,mss5,mss6);
        graph.addEdge(edgeCounter++,mss6,mss7);
        graph.addEdge(edgeCounter++,mss7,mss8);
        graph.addEdge(edgeCounter++,mss8,mss1);


        if (graphVisualizer!=null){
            graphVisualizer.close();
        }
        graphVisualizer=new GraphPanel(graph);


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
