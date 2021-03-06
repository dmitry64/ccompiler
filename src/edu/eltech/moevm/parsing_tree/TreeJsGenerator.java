package edu.eltech.moevm.parsing_tree;

import edu.eltech.moevm.autogen.Parser;
import edu.eltech.moevm.autogen.TokenNotFoundException;
import edu.eltech.moevm.common.Nonterminals;

import java.util.ArrayList;

/**
 * Created by lazorg on 11/3/15.
 */
public class TreeJsGenerator implements PTCallback {
    public ArrayList<String> nodes;
    public ArrayList<String> branches;

    public TreeJsGenerator() {
        nodes = new ArrayList<String>();
        branches = new ArrayList<String>();
    }

    @Override
    public void processElement(PTElement e, int level) {


        if (e != null)
            if (e instanceof PTLeaf) {
                PTLeaf cur = ((PTLeaf) e);
                String name = null;
                try {
                    name = Parser.getTokenName(((PTLeaf) e).getToken());
                } catch (TokenNotFoundException e1) {
                    System.out.println("Unknown token!");
                    e1.printStackTrace();
                }
                int hc = cur.hashCode();
                nodes.add(new String("g.setNode(" + hc + ",  { label: \"" + name + "\",\t class: \"type-TK\"});"));
            } else if (e instanceof PTNode) {
                PTNode cur = ((PTNode) e);
                String name = cur.getNonterminal().name();
                int hc = cur.hashCode();
                if (((PTNode) e).getNonterminal() == Nonterminals.ROOT)
                    hc = 0;
                nodes.add(new String("g.setNode(" + hc + ",  { label: \"" + name + "\",\t class: \"type-NT\"});"));
                if (e instanceof PTNode) {
                    for (PTElement node : e.getElements()) {
                        //if(node instanceof PTNode)
                        branches.add(new String("g.setEdge(" + hc + ", " + node.hashCode() + ",{ lineInterpolate: 'basis' });"));
                    }
                }
            }
    }

    public String genTree() {
        String result = new String();

        result += "<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\">\n" +
                "<title>Parsing tree visualisation</title>\n" +
                "\n" +
                "<link rel=\"stylesheet\" href=\"css/demo.css\">\n" +
                "<script src=\"js/d3.v3.min.js\" charset=\"utf-8\"></script>\n" +
                "<script src=\"js/dagre-d3.js\"></script>\n" +
                "\n" +
                "<style id=\"css\">\n" +
                "body {\n" +
                "  margin: 0px;\n" +
                "  padding: 0px;\n" +
                "  overflow: hidden;\n" +
                "}\n" +
                "g.type-TK > rect {\n" +
                "  fill: #00ffd0;\n" +
                "}\n" +
                "\n" +
                "text {\n" +
                "  font-weight: 300;\n" +
                "  font-family: \"Helvetica Neue\", Helvetica, Arial, sans-serf;\n" +
                "  font-size: 14px;\n" +
                "}\n" +
                "\n" +
                ".node rect {\n" +
                "  stroke: #999;\n" +
                "  fill: #fff;\n" +
                "  stroke-width: 2.5px;\n" +
                "}\n" +
                "\n" +
                ".edgePath path {\n" +
                "  stroke: #333;\n" +
                "  stroke-width: 1.5px;\n" +
                "}\n" +
                "</style>\n" +
                "</head><body>\n" +
                "<script type=\"text/javascript\">" +
                "    var w = window,  d = document, e = d.documentElement,  g = d.getElementsByTagName('body')[0],  x = w.innerWidth || e.clientWidth || g.clientWidth,  y = w.innerHeight|| e.clientHeight|| g.clientHeight;" +
                "    document.write(\"<svg id=\\\"svg-canvas\\\" width=\\\"\"+x+\"\\\" height=\\\"\"+y+\"\\\"></svg>\");" +
                "</script>\n" +
                "<script type=\"text/javascript\" id=\"js\">\n" +
                "var g = new dagreD3.graphlib.Graph()\n" +
                "  .setGraph({})\n" +
                "  .setDefaultEdgeLabel(function() { return {}; });\n";
        for (String str : nodes)
            result += str + "\n";

        result += "g.nodes().forEach(function(v) {\n" +
                "  var node = g.node(v);\n" +
                "  node.rx = node.ry = 5;\n" +
                "});\n";

        for (String str : branches)
            result += str + "\n";

        result += "var render = new dagreD3.render();\n" +
                "\n" +
                "var svg = d3.select(\"svg\"),\n" +
                "    svgGroup = svg.append(\"g\");\n" +
                "    \n" +
                "render(d3.select(\"svg g\"), g);\n" +
                "var svg2 = d3.select(\"svg\"),\n" +
                "    inner = d3.select(\"svg g\"),\n" +
                "    zoom = d3.behavior.zoom().on(\"zoom\", function() {\n" +
                "      inner.attr(\"transform\", \"translate(\" + d3.event.translate + \")\" +\n" +
                "                                  \"scale(\" + d3.event.scale + \")\");\n" +
                "    });\n" +
                "svg2.call(zoom);\n" +
                "\n" +
                "var xCenterOffset = (svg.attr(\"width\") - g.graph().width) / 2;\n" +
                "svgGroup.attr(\"transform\", \"translate(\" + xCenterOffset + \", 20)\");\n" +
                "</script>\n" +
                "</body></html>\n";


        return result;
    }
}
