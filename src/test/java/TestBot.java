import org.example.App;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TestBot {

    // 자바 시간에 객체는 static를 지양.
    // static은 공유하는 건데, 객체는 각자의 개성을 표현해야 해서 앵간하면 지양...
    // but 여기는 왜 static?
    // 객체 -> 데이터 X (상태 없음) -> static 사용 가능

    // 중복되는 부분 따로 처리
    public static String run(String input) {
        Scanner sc = new Scanner(input + "\n");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        App app = new App();
        app.run();

        return out.toString();
    }
}
