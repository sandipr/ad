
    public class Main {
        public static void main(String[] args) {
            System.out.println("Starting Production Attack Path Engine...");
            RuleEngine engine = new RuleEngine();
            engine.loadRules("rules.json");
            engine.loadGraph("graph.json");
            engine.run();
        }
    }
    