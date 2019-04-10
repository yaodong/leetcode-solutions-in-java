package readme;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadmeTest {

    private String templateFilePath = Paths.get(System.getProperty("user.dir"), "resources", "README.md").toString();

    @Test
    public void resourceTest() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(readTemplate());

        String dataFilePath = Paths.get(System.getProperty("user.dir"), "resources", "leetcode.yml").toString();
        String readmeFilePath = Paths.get(System.getProperty("user.dir"), "README.md").toString();

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            Problem[] problems = mapper.readValue(new File(dataFilePath), Problem[].class);
            for (Problem problem : problems) {
                if (hasSolution(problem)) {
                    sb.append(composeTableRow(problem));
                }
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(readmeFilePath));
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("unable to parse problem.yml");
        }
    }

    private boolean hasSolution(Problem problem) {
        Path path = Paths.get(System.getProperty("user.dir"), "java", "leetcode", String.format("q%03d", problem.getId()));
        boolean isf = path.toFile().isDirectory();
        return isf;
    }

    private String readTemplate() {
        StringBuilder content = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(templateFilePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> content.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    private String composeTableRow(Problem problem) {
        return String.format("| %03d | [%s](%s) | %s |\n",
                problem.getId(), problem.getTitle(), problem.getUrl(), composeFilePath(problem));
    }

    private String composeFilePath(Problem problem) {
        return String.format("[Solution](./java/q%03d/Solution.java)", problem.getId());
    }


}
