import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkingDirectoryTree {

    public static void main(String[] args) throws IOException {

        System.out.println("New Directory Stream...");
        try {
            Path dir = Paths.get(".");
            DirectoryStream<Path> stream =
                    Files.newDirectoryStream(dir, "*.java");
            for (Path entry : stream) {
                System.out.println(entry.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Walk file tree...");

        Path startingDir =
                Paths.get(".");
        Files.walkFileTree(startingDir, new FindJavaVisitor());


    }

    private static class FindJavaVisitor
            extends SimpleFileVisitor<Path> {
        public FindJavaVisitor() {
        }

        ;

        public FileVisitResult
        visitFile(Path file, BasicFileAttributes attrs) {
            if ((file != null) && (attrs != null)) {
                if (file.getFileName().toString().endsWith(".java")) {
                    System.out.println(file.getFileName().toString());
                }
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
