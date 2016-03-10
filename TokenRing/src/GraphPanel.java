
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


    public static void main(String arg[]){

        Graph<TokenNode,Number> graph=createGraph();
        Forest<String,Number> tree;

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
                return AffineTransform.getScaleInstance(2, 2).createTransformedShape(circle);
                //else return circle;
            }
        };



        vv0 = new VisualizationViewer<TokenNode,Number>(vm0, preferredSize);
        vv2 = new VisualizationViewer<TokenNode,Number>(vm2, preferredSizeRect);


        vv2.getRenderContext().setMultiLayerTransformer(vv0.getRenderContext().getMultiLayerTransformer());
        vv2.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line());
        vv2.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv2.getRenderContext().setVertexShapeTransformer(vertexSize);

        Color back = Color.decode("0xffffbb");

        vv2.setBackground(back);

        vv2.getRenderer().getVertexLabelRenderer().setPosition(Renderer.VertexLabel.Position.CNTR);
        //vv2.setForeground(Color.darkGray);


        vv2.setLayout(new BorderLayout());

        JFrame frame = new JFrame("Simple Graph View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv2);
        frame.pack();
        frame.setVisible(true);


    }

    private static Graph<TokenNode, Number> createGraph() {
        Graph<TokenNode, Number> graph =   new DirectedOrderedSparseMultigraph<TokenNode, Number>();
        //Graph<String, Number> graph =   new UndirectedOrderedSparseMultigraph<String, Number>();

        //Graph<String, Number> graph =   new DirectedSparseGraph<String, Number>();


        final TokenNode vertex1 = new TokenNode("1");
        final TokenNode vertex2 = new TokenNode("2");
        final TokenNode vertex3 = new TokenNode("3");
        final TokenNode vertex4 = new TokenNode("4");
        final TokenNode vertex5 = new TokenNode("5");
        final TokenNode vertex6 = new TokenNode("6");
        //final TokenNode vertex7 = new TokenNode("7");
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
        //graph.addVertex(vertex7);

        /*
        graph.addVertex(vertex6);
        graph.addVertex(vertex7);
        graph.addVertex(vertex8);
        graph.addVertex(vertex9);

*/
        graph.addEdge(1, vertex1, vertex2);
        graph.addEdge(2, vertex2, vertex3);
        graph.addEdge(3, vertex3, vertex4);
        graph.addEdge(4, vertex4, vertex5);
        graph.addEdge(5, vertex5, vertex6);
        graph.addEdge(6, vertex6, vertex1);
        //graph.addEdge(7, vertex7, vertex4);

        /*
        graph.addEdge(5, vertex5, vertex6);
        graph.addEdge(6, vertex6, vertex7);
        graph.addEdge(7, vertex7, vertex8);
        graph.addEdge(8, vertex8, vertex9);
        graph.addEdge(9, vertex9, vertex1);



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
