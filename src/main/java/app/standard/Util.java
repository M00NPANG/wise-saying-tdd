package app.standard;

import java.nio.file.*;

public class Util {
    public static class File {

        public static void test() {
            System.out.println("파일 유틸 테스트");
        }

        public static void createFile(String fileValue) {

            Path filePath = Paths.get(fileValue);

            try{
                File.createFile(filePath);
            } catch (Exception e) {
                System.out.println("파일 생성 중 실패");
                return e;
            }

        }

        public static void writeFile(String file, String content) {
        }
    }
}
