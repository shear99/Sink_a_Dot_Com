import java.util.*;

public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    // 게임 설정
    public void setUpGame() {
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        for (DotCom dotComToSet : dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);      // 3칸 넣을 수 있는 공간을 찾아주는 메소드
            dotComToSet.setLocationCells(newLocation);                  // 배치 메소드
        }
    }

    // 게임 진행
    public void startPlaying() {
        while (!dotComsList.isEmpty()) {                                  // 모든 DotCom 파괴될 때까지 진행
            String userGuess = helper.getUserInput("Enter a guess");    // 게이머에게 input 받기
            this.checkUserGuess(userGuess);                             // 입력받은 userGuess 가지고 추리
        }
        this.finishGame();
    }

    // userGuess 받은거 가지고 list 안에 들어있는거 대조 후 Hit 여부 파악
    public void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "";
        for (int x = 0; x < dotComsList.size(); x++) {
            result = dotComsList.get(x).checkYourself(userGuess);       // x 자리의 객체 꺼내오기
            if (result.equals("hit")) {
                break;
            } else if (result.equals("kill")) {
                dotComsList.remove(x);
                break;
            }
        }
        System.out.println(result);
    }

    // 모든 DotCom 격파됨
    private void finishGame() {
        System.out.println("All Dot Coms are dead!");
        if (numOfGuesses <= 18) {                                        // 총 추리횟수가 18번 이하이면 칭찬해주기
            System.out.println(
                    "It only took you " + numOfGuesses + "guesses.");
        } else {
            System.out.println(
                    "Took you long enough. " + numOfGuesses + " guess.");
        }
    }

    // main 부분
    public class DotComBustLauncher {
        public static void main(String[] args) {
            DotComBust game = new DotComBust();
            game.setUpGame();
            game.startPlaying();
        }
    }


}
