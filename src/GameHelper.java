import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    // Alternativily
    // private int [][] grid = new int [gridLength][gridLength];

    private int comCount = 0;

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException : " + e);
        }
        return inputLine.toLowerCase();                     // 2차원 보드이기 때문에 2글자를 입력 받아야 한다
        // 좌표 입력을 알파벳으로 받기 때문에 모두 소문자로 변환
    }

    // comSize 만큼의 연속된 셀 찾기
    public ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphaCells = new ArrayList<String>();

        int[] coords = new int[comSize];
        int attempts = 0;
        boolean success = false;
        int location = 0;

        comCount++;
        int incr = ((comCount % 2) == 1) ? gridLength : 1;  // 가로방향 좌표증가 : +1, 세로방향 좌표증가 : +7

        while (!success && attempts++ < 200) {               // 무한정 반복하지 않게 최대 횟수 정하기
            location = (int) (Math.random() * gridSize);     // 일단 랜덤 선택
            int x = 0;

            success = true;                                 // x == comSize 이면 while 탈출
            while (success) {
                if (grid[location] == 0) {                    // 첫 번째 셀이 비어있는지 확인
                    coords[x++] = location;
                    if (x == comSize) break;                   // 핑료한 개수(3개) 만큼 찾았으면 break;
                    location += incr;                       // 가로 또는 세로 방향으로 증가

                    if (location >= gridSize ||              // 맨 마지막칸인 경우
                            (incr == 1 && (location % gridLength == 0))) {       // 가로 증가시 맨 오른쪽 칸인 경우
                        success = false;
                    }
                } else {
                    success = false;
                }
            }
        }

        int x = 0;
        while (x < comSize) {
            grid[coords[x]] = 1;                            // 선택한 위치에 배치 (숫자 1 == 배치되어 있음)
            int row = coords[x] / gridLength;
            int column = coords[x] % gridLength;
            String temp = String.valueOf(alphabet.charAt(row));

            alphaCells.add(temp.concat(Integer.toString(column)));
            x++;
        }

        return alphaCells;
    }
}
