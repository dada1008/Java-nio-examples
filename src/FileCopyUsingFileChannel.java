import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class FileCopyUsingFileChannel {

    public static void main(String[] args) throws Exception{

        String thisFile = "./src/FileCopyUsingFileChannel.java";
        FileInputStream source = new FileInputStream(thisFile);
        FileOutputStream destination = new FileOutputStream("Output.java");

        FileChannel sourceFileChannel = source.getChannel();
        FileChannel destinationFileChannel = destination.getChannel();

        long size = sourceFileChannel.size();
        sourceFileChannel.transferTo(0, size, destinationFileChannel);
    }
}