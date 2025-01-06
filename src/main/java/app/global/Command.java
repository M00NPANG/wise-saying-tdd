package app.global;

public class Command {

    /** 쪼개기 작업
     * 1. 액션 네임 제공
     * 2. id 파라미터 제공
     */

    String actionName;

    public Command(String cmd) {
        String[] cmdBits = cmd.split("\\?");
        actionName = cmdBits[0];
    }

    public String getActionName() {
        return actionName;
    }
}
