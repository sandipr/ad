
    import java.util.List;

    public class Rule {
        public String ruleId;
        public String description;
        public NodeCondition startNode;
        public NodeCondition endNode;
        public List<EdgeCondition> allowedEdges;
        public String traversalAlgorithm;
        public int maxDepth;
    }
    