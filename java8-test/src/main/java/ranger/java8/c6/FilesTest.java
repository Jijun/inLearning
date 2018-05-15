package ranger.java8.c6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesTest {
	public static void main(String[] args) throws IOException {
		try (Stream<Path> stream = Files.list(Paths.get(""))) {
			String joined = stream.map(String::valueOf).filter(path -> !path.startsWith(".")).sorted()
					.collect(Collectors.joining(";"));
			System.out.println(joined);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Path start = Paths.get("");
		int maxDepth = 5;
		try (Stream<Path> stream = Files.find(start, maxDepth, (a, b) -> String.valueOf(a).endsWith(".js"))) {
			String joined = stream.sorted().map(String::valueOf).collect(Collectors.joining("; "));
			System.out.println("Found: " + joined);
		}
		//全部读入内存，低效率
		List<String> lines = Files.readAllLines(Paths.get("/tmp/a.txt"));
		lines.add("printjs");
		Files.write(Paths.get("/tmp/b.txt"), lines);
		Stream<String> stream = Files.lines(Paths.get("/tmp/b.xt"));
		stream.filter(line-> line.contains("print")).map(String::trim).forEach(System.out::println);
		
		
		
	}
}
