package readme;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class ReadmeTest {

    @Test
    public void resourceTest() throws Exception {
        StringBuilder sb = newTable();
        String dataFilePath = Paths.get(System.getProperty("user.dir"), "resources", "problems.yml").toString();
        String readmeFilePath = Paths.get(System.getProperty("user.dir"), "README.md").toString();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            Problem[] problems = mapper.readValue(new File(dataFilePath), Problem[].class);
            for (Problem problem : problems) {
                sb.append(composeTableRow(problem));
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(readmeFilePath));
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("unable to parse problem.yml");
        }


    }

    private String composeTableRow(Problem problem) {
        return String.format("| %03d | [%s](%s) | %s |\n",
                problem.getId(), problem.getTitle(), problem.getUrl(), composeFilePath(problem));
    }

    private String composeFilePath(Problem problem) {
        return String.format("[Solution](./java/q%03d/Solution.java)", problem.getId());
    }

    private StringBuilder newTable() {
        StringBuilder sb = new StringBuilder();
        sb.append("| ID | TITLE  | SOLUTION  |\n");
        sb.append("|----|--------|-----------|\n");
        return sb;
    }

}
