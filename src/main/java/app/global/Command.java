package app.global;

public class Command {

    /** 쪼개기 작업
     * 1. 액션 네임 제공
     * 2. id 파라미터 제공
     */

    String actionName;

    public Command(String cmd) {
        // split에서 만약 자를게 없으면 자기 자신이 나옴. 그래서 배열의 0번째로 반환.
        // 따라서 0번째에 값이 없을 수 없음
        String[] cmdBits = cmd.split("\\?");
        actionName = cmdBits[0];
    }

    public String getActionName() {
        return actionName;
    }
}
