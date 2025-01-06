package app.global;

import java.util.HashMap;

public class Command {

    /** 쪼개기 작업
     * 1. 액션 네임 제공
     * 2. id 파라미터 제공
     */

    String actionName;
    HashMap<String, String>  paramMap;

    public Command(String cmd) {

        paramMap = new HashMap<>();

        // 삭제?id=1
        // 이름 = 문권이 (Key-Value)
        String[] cmdBits = cmd.split("\\?");    // [삭제, id=1]
        // split에서 만약 자를게 없으면 자기 자신이 나옴. 그래서 배열의 0번째로 반환.
        // 따라서 0번째에 값이 없을 수 없음
        actionName = cmdBits[0];

        if(cmdBits.length < 2) {
            return;
        }
        // key1=value1&key2=value2
        String queryString = cmdBits[1];
        String[] params = queryString.split("&");

        for(String param : params) {
            // limit은 조각의 최대 개수
            String[] paramBits = param.split("=",2);

            if(paramBits.length < 2) {
                continue;
            }

            paramMap.put(paramBits[0], paramBits[1]);
        }


    }

    public String getActionName() {
        return actionName;
    }

    public String getParam(String key) {

        return paramMap.get(key);
    }
}
