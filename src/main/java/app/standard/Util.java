package app.standard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Util {
    public static class File {

        public static void test() {
            System.out.println("파일 유틸 테스트");
        }

        public static void createFile(String pathValue) {
            write(pathValue, "");
        }

        public static String readAsString(String file) {

            Path filePath = Paths.get(file);

            try {
                return Files.readString(filePath);
            } catch (IOException e) {
                System.out.println("파일 읽기 실패");
                e.printStackTrace();
            }

            return "";
        }

        public static void write(String file, String content) {

            Path filePath = Paths.get(file);

            try {
                Files.writeString(filePath, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException e) {
                System.out.println("파일 쓰기 실패");
                e.printStackTrace();
            }
        }

        public static void delete(String file) {
            Path filePath = Paths.get(file);

            try {
                if (Files.isDirectory(filePath)) {
                    // 디렉토리라면 내부 파일 및 서브 디렉토리 삭제
                    Files.walk(filePath)
                            .sorted((p1, p2) -> p2.compareTo(p1)) // 하위 경로부터 삭제
                            .forEach(path -> {
                                try {
                                    Files.delete(path);
                                } catch (IOException e) {
                                    System.out.println("파일/디렉토리 삭제 실패: " + path);
                                    e.printStackTrace();
                                }
                            });
                } else {
                    // 파일 삭제
                    Files.delete(filePath);
                }
            } catch (IOException e) {
                System.out.println("파일/디렉토리 삭제 실패");
                e.printStackTrace();
            }
        }
    }
}