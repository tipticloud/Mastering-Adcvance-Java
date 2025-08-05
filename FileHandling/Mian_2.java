
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;

    public class Mian_2 {

        private static void copyFileNIO(String nioFileSrc, String nioFileDest) {
            Path srcPath = Paths.get(nioFileSrc);
            Path dstPath = Paths.get(nioFileDest);
            System.out.println("File copying started");

            try (FileChannel sourceChannel = FileChannel.open(srcPath, StandardOpenOption.READ);
                 FileChannel destinationChannel = FileChannel.open(dstPath, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {

                ByteBuffer buffer = ByteBuffer.allocate(1024); // allocate a buffer
                while (sourceChannel.read(buffer) != -1) {
                    buffer.flip();
                    destinationChannel.write(buffer);
                    buffer.clear();
                }

                System.out.println("File copied successfully");
            } catch (IOException e) {
                System.err.println("IO error = " + e.getMessage());
            }
        }
    }
