package bms.programmers;

import org.junit.jupiter.api.Test;

/*



당신은 동영상 재생기를 만들고 있습니다. 당신의 동영상 재생기는 10초 전으로 이동, 10초 후로 이동, 오프닝 건너뛰기 3가지 기능을 지원합니다.
각 기능이 수행하는 작업은 다음과 같습니다.
    10초 전으로 이동: 사용자가 "prev" 명령을 입력할 경우 동영상의 재생 위치를 현재 위치에서 10초 전으로 이동합니다.
    현재 위치가 10초 미만인 경우 영상의 처음 위치로 이동합니다. 영상의 처음 위치는 0분 0초입니다.
    10초 후로 이동: 사용자가 "next" 명령을 입력할 경우 동영상의 재생 위치를 현재 위치에서 10초 후로 이동합니다.
    동영상의 남은 시간이 10초 미만일 경우 영상의 마지막 위치로 이동합니다. 영상의 마지막 위치는 동영상의 길이와 같습니다.
    오프닝 건너뛰기: 현재 재생 위치가 오프닝 구간(op_start ≤ 현재 재생 위치 ≤ op_end)인 경우 자동으로 오프닝이 끝나는 위치로 이동합니다.
동영상의 길이를 나타내는 문자열 video_len, 기능이 수행되기 직전의 재생위치를 나타내는 문자열 pos, 오프닝 시작 시각을 나타내는 문자열 op_start,
오프닝이 끝나는 시각을 나타내는 문자열 op_end, 사용자의 입력을 나타내는 1차원 문자열 배열 commands가 매개변수로 주어집니다.
이때 사용자의 입력이 모두 끝난 후 동영상의 위치를 "mm:ss" 형식으로 return 하도록 solution 함수를 완성해 주세요.

 */
public class VideoPlayer {

    class Solution {
        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            String answer = "";
            int videoLenInSec = convertMMSS2Sec(video_len);
            int opStartInSec = convertMMSS2Sec(op_start);
            int opEndInSec = convertMMSS2Sec(op_end);
            int posInSec = convertMMSS2Sec(pos);

            for (String command : commands) {
                if (posInSec >= opStartInSec && posInSec <= opEndInSec)
                    posInSec = opEndInSec;
                switch (command) {
                    case "next":
                        posInSec += 10;
                        if (posInSec > videoLenInSec)
                            posInSec = videoLenInSec;
                        break;
                    case "prev":
                        posInSec -= 10;
                        if (posInSec < 0)
                            posInSec = 0;
                        break;
                }
            }
            if (posInSec >= opStartInSec && posInSec <= opEndInSec)
                posInSec = opEndInSec;
            answer = convertSec2MMSS(posInSec);
            return answer;
        }
    }

    public int convertMMSS2Sec(String time) {
        return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
    }

    public String convertSec2MMSS(int seconds) {
        String mmss = "";
        int minute = seconds / 60;
        int second = seconds % 60;
        if (minute < 10) {
            mmss += "0";
        }
        mmss += minute + ":";
        if (second < 10) {
            mmss += "0";
        }
        mmss += second;
        return mmss;
    }

    @Test
    public void checkCase() {

        String videoLen1 = "34:33";
        String pos1 = "13:00";
        String opStart1 = "00:55";
        String opEnd1 = "02:55";
        String[] commands1 = new String[]{"next", "prev"};
        Solution solution = new Solution();
        assert solution.solution(videoLen1, pos1, opStart1, opEnd1, commands1).equals("13:00");

        String videoLen2 = "10:55";
        String pos2 = "00:05";
        String opStart2 = "00:15";
        String opEnd2 = "06:55";
        String[] commands2 = new String[]{"prev", "next", "next"};
        assert solution.solution(videoLen2, pos2, opStart2, opEnd2, commands2).equals("06:55");

        String videoLen3 = "07:22";
        String pos3 = "04:05";
        String opStart3 = "00:15";
        String opEnd3 = "04:07";
        String[] commands3 = new String[]{"next"};
        assert solution.solution(videoLen3, pos3, opStart3, opEnd3, commands3).equals("04:17");



    }

}
