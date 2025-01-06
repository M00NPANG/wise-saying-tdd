package app.standard;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.*;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Paths;

public class FileTest {
    @Test
    @DisplayName("최초의 테스트")
    void t1() {
        Util.File.test();
    }

    @Test
    @DisplayName("파일 생성. 내용이 없는 빈 파일 생성")
    void t2() {
       String file = "test.txt";

       Util.File.createFile(file);

       assertThat(Files.exists(Paths.get(file)))
               .isTrue();
    }

    @Test
    @DisplayName("파일 내용 조회")
    void t3() throws IOException {
        String testContent = "Hello, World!";

        String file = "test.txt";
        String content = Files.readString(Path.of(file));

        assertThat(content)
                .isEqualTo(testContent);
    }

//    @Test
//    @DisplayName("파일 내용 수정")
//    void t4() {
//        String file = "test.txt";
//
//        Util.File.writeFile(file, "Hello, World!");
//
//        String content = Files.readString(Paths.get(file));
//
//        assertThat(Files.exists(Paths.get(file)))
//                .isTrue();
//    }
}
