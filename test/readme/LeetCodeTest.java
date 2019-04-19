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
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class LeetCodeTest {

    private String templateFilePath = Paths.get(System.getProperty("user.dir"), "resources", "README.md").toString();

    @Test
    public void resourceTest() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(readTemplate());

        String userDir = System.getProperty("user.dir");

        String dataFilePath = Paths.get(userDir, "resources", "leetcode.yml").toString();
        String readmeFilePath = Paths.get(userDir, "README.md").toString();

        Map<Integer, String> solutions = listSolutions(userDir);

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            Problem[] problemList = mapper.readValue(new File(dataFilePath), Problem[].class);
            for (Problem problem : problemList) {
                Integer problemId = problem.getId();
                if (solutions.containsKey(problemId)) {
                    sb.append(composeTableRow(problem, solutions.get(problemId)));
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

    private Map<Integer, String> listSolutions(String userDir) {
        File solutionFolder = Paths.get(userDir, "java", "leetcode").toFile();
        String[] subFolders = solutionFolder.list();

        if (subFolders == null) {
            return new HashMap<>();
        }

        Map<Integer, String> problems = new HashMap<>();

        for (String name : subFolders) {
            if (!name.startsWith("Q") || !name.contains("_")) continue;
            String[] parts = name.substring(1).split("_");
            problems.put(Integer.valueOf(parts[0]), name);
        }

        return problems;
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

    private String composeTableRow(Problem problem, String folderName) {
        return String.format("| %03d | [%s](%s) | %s |\n",
                problem.getId(), problem.getTitle(), problem.getUrl(), composeFilePath(folderName));
    }

    private String composeFilePath(String folderName) {
        return String.format("[Solution](./java/%s/Solution.java)", folderName);
    }


}
