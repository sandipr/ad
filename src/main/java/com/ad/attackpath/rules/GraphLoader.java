
    import com.fasterxml.jackson.databind.ObjectMapper;
    import java.io.File;

    public class GraphLoader {
        public static Graph loadGraph(String filePath) throws Exception {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(filePath), Graph.class);
        }
    }
    