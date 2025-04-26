
    import java.util.List;

    public class RuleEngine {
        private List<Rule> rules;
        private Graph graph;

        public void loadRules(String filePath) {
            try {
                this.rules = RuleParser.parseRules(filePath);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public void loadGraph(String filePath) {
            try {
                this.graph = GraphLoader.loadGraph(filePath);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public void run() {
            for (Rule rule : rules) {
                System.out.println("Applying rule: " + rule.ruleId);
                List<List<String>> paths = TraversalEngine.bfs(graph, rule);
                for (List<String> path : paths) {
                    System.out.println("Detected Path: " + path);
                }
            }
        }

        public static boolean nodeMatches(GraphNode node, NodeCondition cond) {
            if (!node.type.equals(cond.type)) return false;
            for (String condition : cond.conditions) {
                String[] parts = condition.split("==|!=");
                String key = parts[0].trim();
                String value = parts[1].trim().replace(""", "");
                if (condition.contains("==") && !node.properties.getOrDefault(key, "").equals(value)) return false;
                if (condition.contains("!=") && node.properties.getOrDefault(key, "").equals(value)) return false;
            }
            return true;
        }

        public static boolean edgeMatches(GraphEdge edge, List<EdgeCondition> conds) {
            for (EdgeCondition cond : conds) {
                if (edge.type.equals(cond.type)) return true;
            }
            return false;
        }
    }
    