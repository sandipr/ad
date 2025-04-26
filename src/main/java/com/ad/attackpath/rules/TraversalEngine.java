
    import java.util.*;

    public class TraversalEngine {
        public static List<List<String>> bfs(Graph graph, Rule rule) {
            List<List<String>> paths = new ArrayList<>();
            for (GraphNode startNode : graph.nodes.values()) {
                if (!RuleEngine.nodeMatches(startNode, rule.startNode)) continue;
                Queue<List<String>> queue = new LinkedList<>();
                queue.add(List.of(startNode.id));
                while (!queue.isEmpty()) {
                    List<String> path = queue.poll();
                    String lastNodeId = path.get(path.size() - 1);
                    GraphNode lastNode = graph.nodes.get(lastNodeId);
                    if (RuleEngine.nodeMatches(lastNode, rule.endNode)) {
                        paths.add(new ArrayList<>(path));
                        continue;
                    }
                    if (path.size() > rule.maxDepth) continue;
                    for (GraphEdge edge : graph.edges) {
                        if (edge.fromNodeId.equals(lastNodeId) &&
                            RuleEngine.edgeMatches(edge, rule.allowedEdges)) {
                            List<String> newPath = new ArrayList<>(path);
                            newPath.add(edge.toNodeId);
                            queue.add(newPath);
                        }
                    }
                }
            }
            return paths;
        }
    }
    