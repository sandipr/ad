
    import com.fasterxml.jackson.databind.ObjectMapper;
    import java.io.File;
    import java.util.List;

    public class RuleParser {
        public static List<Rule> parseRules(String filePath) throws Exception {
            ObjectMapper mapper = new ObjectMapper();
            return List.of(mapper.readValue(new File(filePath), Rule[].class));
        }
    }
    