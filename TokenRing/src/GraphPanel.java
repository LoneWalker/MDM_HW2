
/**
 * Created by azhar on 2/10/16.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.uci.ics.jung.algorithms.layout.*;
import edu.uci.ics.jung.graph.*;
import edu.uci.ics.jung.graph.util.EdgeType;
import org.apache.commons.collections15.Transformer;
import org.apache.commons.collections15.functors.ConstantTransformer;

import edu.uci.ics.jung.algorithms.shortestpath.MinimumSpanningForest2;
import edu.uci.ics.jung.graph.util.TestGraphs;
import edu.uci.ics.jung.visualization.DefaultVisualizationModel;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.VisualizationModel;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.CrossoverScalingControl;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ScalingControl;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.decorators.PickableEdgePaintTransformer;
import edu.uci.ics.jung.visualization.decorators.PickableVertexPaintTransformer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.picking.MultiPickedState;
import edu.uci.ics.jung.visualization.picking.PickedState;
import edu.uci.ics.jung.visualization.renderers.Renderer;
import edu.uci.ics.jung.visualization.transform.MutableTransformer;

public class GraphPanel {


    Graph<TokenNode,Number> graph;
    VisualizationViewer<TokenNode,Number> graphViewer;

    JFrame frame;

    GraphPanel(Graph<TokenNode,Number> graph){
        this.graph=graph;
        VisualizationViewer<TokenNode,Number> vv2;
        VisualizationViewer<TokenNode,Number> vv0;



        Dimension preferredSize = new Dimension(1500,800);
        Dimension preferredLayoutSize = new Dimension(1500,800);
        Dimension preferredSizeRect = new Dimension(1500,800);

        /*
        Dimension preferredSize = new Dimension(300,300);
        Dimension preferredLayoutSize = new Dimension(400,400);
        Dimension preferredSizeRect = new Dimension(500,250);

        */

        /*
        MinimumSpanningForest2<String,Number> prim =
                new MinimumSpanningForest2<String,Number>(graph,
                        new DelegateForest<String,Number>(), DelegateTree.<String,Number>getFactory(),
                        new ConstantTransformer(1.0));


        tree = prim.getForest();
*/
        // create two layouts for the one graph, one layout for each model


        Layout<TokenNode,Number> layout0 = new KKLayout<TokenNode,Number>(graph);
        layout0.setSize(preferredLayoutSize);
        // Layout<String,Number> layout1 = new TreeLayout<String, Number>(tree,150,150);
        //Layout<String,Number> layout2 = new StaticLayout<String,Number>(graph, layout1);
        Layout<TokenNode,Number> layout2 = new StaticLayout<TokenNode,Number>(graph, layout0);


        VisualizationModel<TokenNode,Number> vm0 =
                new DefaultVisualizationModel<TokenNode,Number>(layout0, preferredSize);
        VisualizationModel<TokenNode,Number> vm2 = new DefaultVisualizationModel<TokenNode,Number>(layout2, preferredSizeRect);


        // adding transformer for fixing vertex size

        Transformer<TokenNode,Shape> vertexSize = new Transformer<TokenNode,Shape>(){
            public Shape transform(TokenNode i){
                Ellipse2D circle = new Ellipse2D.Double(-15, -15, 30, 30);
                // in this case, the vertex is twice as large


                if (i.vertexType==ProjectConstants.VERTEX_TYPE_PROXY){
                    return AffineTransform.getScaleInstance(3, 3).createTransformedShape(circle);
                }else if (i.vertexType==ProjectConstants.VERTEX_TYPE_MSS){
                    return AffineTransform.getScaleInstance(2.5, 2.5).createTransformedShape(circle);
                }else {
                    return AffineTransform.getScaleInstance(2, 2).createTransformedShape(circle);
                }


                //else return circle;
            }
        };

        Transformer<TokenNode,Paint> vertexColor = new Transformer<TokenNode,Paint>() {
            public Paint transform(TokenNode h) {

                if (h.changeColor){
                    return Color.CYAN;

                }else {
                    if(h.vertexType==ProjectConstants.VERTEX_TYPE_PROXY)
                        return Color.BLUE;
                    else if (h.vertexType==ProjectConstants.VERTEX_TYPE_MSS)
                        return Color.YELLOW;
                    else
                        return Color.RED;

                }


            }
        };



        vv0 = new VisualizationViewer<TokenNode,Number>(vm0, preferredSize);
        vv2 = new VisualizationViewer<TokenNode,Number>(vm2, preferredSizeRect);

        graphViewer=vv2;


        vv2.getRenderContext().setVertexFillPaintTransformer(vertexColor);
        vv2.getRenderContext().setMultiLayerTransformer(vv0.getRenderContext().getMultiLayerTransformer());
        vv2.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line());
        vv2.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv2.getRenderContext().setVertexShapeTransformer(vertexSize);

        Color back = Color.decode("0xffffbb");

        vv2.setBackground(back);

        vv2.getRenderer().getVertexLabelRenderer().setPosition(Renderer.VertexLabel.Position.CNTR);
        //vv2.setForeground(Color.darkGray);


        vv2.setLayout(new BorderLayout());


        frame = new JFrame("Simple Graph View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv2);
        frame.pack();
        frame.setVisible(true);




    }
    public void close(){
        frame.setVisible(false);
        frame.dispose();
    }



    private static Graph<TokenNode, Number> createGraph() {
        Graph<TokenNode, Number> graph =   new DirectedOrderedSparseMultigraph<TokenNode, Number>();
        //Graph<String, Number> graph =   new UndirectedOrderedSparseMultigraph<String, Number>();

        //Graph<String, Number> graph =   new DirectedSparseGraph<String, Number>();


        TokenNode vertex1 = new TokenNode("1",0);
        TokenNode vertex2 = new TokenNode("2",0);
        final TokenNode vertex3 = new TokenNode("3",0);
        final TokenNode vertex4 = new TokenNode("4",0);
        final TokenNode vertex5 = new TokenNode("5",1);
        final TokenNode vertex6 = new TokenNode("6",1);
        final TokenNode vertex7 = new TokenNode("7",1);
        final TokenNode vertex8 = new TokenNode("8",1);
        final TokenNode vertex9 = new TokenNode("9",1);
        final TokenNode vertex10 = new TokenNode("10",1);
        final TokenNode vertex11 = new TokenNode("11",1);
        final TokenNode vertex12 = new TokenNode("12",1);
        final TokenNode vertex13 = new TokenNode("13",1);

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
        graph.addEdge(1, vertex1, vertex2);
        graph.addEdge(2, vertex2, vertex3);
        graph.addEdge(3, vertex3, vertex4);
        graph.addEdge(4, vertex4, vertex1);

        //mss

        graph.addEdge(5, vertex5, vertex1);
        graph.addEdge(6, vertex6, vertex1);
        graph.addEdge(7, vertex7, vertex2);
        graph.addEdge(8, vertex8, vertex2);
        graph.addEdge(9, vertex9, vertex3);
        graph.addEdge(10, vertex10, vertex3);
        graph.addEdge(11, vertex11, vertex4);
        graph.addEdge(12, vertex12, vertex4);

        //mh
        //graph.addEdge(13, vertex13, vertex9);
        //graph.addEdge(14, vertex14, vertex1);



        /*
        graph.addEdge(6, vertex3, vertex2, EdgeType.DIRECTED);
        graph.addEdge(7, vertex2, vertex4, EdgeType.DIRECTED);
        graph.addEdge(1, vertex1, vertex2, EdgeType.DIRECTED);
        graph.addEdge(2, vertex2, vertex3, EdgeType.DIRECTED);
        graph.addEdge(3, vertex3, vertex5, EdgeType.DIRECTED);
        graph.addEdge(4, vertex1, vertex4, EdgeType.DIRECTED);
        graph.addEdge(5, vertex4, vertex5, EdgeType.DIRECTED);
        */

        return graph;
    }


}
