import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    private static final String BYTE_FILE_SRC="byte_file_src.txt";
    private static final String BYTE_FILE_DST="byte_file_dst.txt";
    private static final String CHAR_FILE_SRC="char_file_src.txt";
    private static final String CHAR_FILE_DST="char_file_dst.txt";
    private static final String LARGE_FILE_SRC="large_file_src.txt";
    private static final String LARGE_FILE_DST="large_file_dst.txt";
    public static void main(String[] args) {
        createDummyFiles();
        copyFileBytes(BYTE_FILE_SRC,BYTE_FILE_DST);
        copyFileChar(CHAR_FILE_SRC,CHAR_FILE_DST);
        copyFileBuffered(LARGE_FILE_SRC,LARGE_FILE_DST);
    }

    private static void copyFileBuffered(String largeFileSrc, String largeFileDst) {
        try (BufferedReader br=new BufferedReader(new FileReader(largeFileSrc));
             BufferedWriter bw=new BufferedWriter(new FileWriter(largeFileDst))){
            String line;
            while ((line=br.readLine())!=null){
                bw.write(line+"\n");
            }
        }catch (IOException e) {
            System.err.println("io error "+e.getMessage());
        }
    }

    private static void createDummyFiles() {
        try (FileOutputStream fos=new FileOutputStream(BYTE_FILE_SRC);
             FileWriter fw=new FileWriter(CHAR_FILE_SRC);
             FileWriter fwLarge=new FileWriter(LARGE_FILE_SRC);
        ){
            fos.write("Hello World! I am writing to a file".getBytes(StandardCharsets.UTF_8));
            fw.write("Hello World! I am writing to a file using FileWriter");
            for (int i = 0; i < 100000; i++) {
                fwLarge.write("Hello World! I am writing to a file using FileWriter. Line no:"+ i + "\n");
            }
        }catch (IOException e) {
            System.err.println("io error"+e.getMessage());
        }
    }

    private static void copyFileChar(String charFileSrc, String charFileDst) {
        try (FileReader fr=new FileReader(charFileSrc);
             FileWriter fw=new FileWriter(charFileDst)){
            int charRead;
            while((charRead=fr.read())!=-1){
                fw.write(charRead);
            }
        }catch (IOException e) {
            System.err.println("io error "+e.getMessage());
        }
    }

    private static void copyFileBytes(String byteFileSrc, String byteFileDest) {
        try (FileInputStream fis=new FileInputStream(byteFileSrc);
             FileOutputStream fos=new FileOutputStream(byteFileDest)){
            int byteRead;
            while ((byteRead=fis.read())!=-1){
                fos.write(byteRead);
            }
        }catch (IOException e) {
            System.err.println("io error"+e.getMessage());
        }
    }
}