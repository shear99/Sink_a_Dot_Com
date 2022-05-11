package extdotcomgame;

import dotcomobservers.SurvivingCells;

import java.util.*;

public class DotComBust extends DotCom {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    // 게임 설정
    public void setUpGame() {

        ShortDotCom one = new ShortDotCom();
        one.setName("Pets.com");
        LongDotCom two = new LongDotCom();
        two.setName("eToys.com");
        HeavyDotCom three = new HeavyDotCom();
        three.setName("Go2.com");
        //SubmarineDotCom four = new SubmarineDotCom();
        //four.setName("Dolphin.com");

        one.attach(new SurvivingCells(one));
        two.attach(new SurvivingCells(two));
        three.attach(new SurvivingCells(three));
        //four.attach(new SurvivingCells(four));


        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        //dotComsList.add(four);


        ArrayList<String> newLocation;
        newLocation = helper.placeDotCom(one.size());
        one.setLocationCells(newLocation);
        newLocation = helper.placeDotCom(two.size());
        two.setLocationCells(newLocation);
        newLocation = helper.placeDotCom(three.size());
        three.setLocationCells(newLocation);
        //newLocation = helper.placeDotCom(four.size());
        //four.setLocationCells(newLocation);
    }

    // 게임 진행
    public void startPlaying() {
        while (!dotComsList.isEmpty()) {                                  // 모든 extdotcomgame.DotCom 파괴될 때까지 진행
            String userGuess = helper.getUserInputRandom("Enter a guess");    // 체크할때는 랜덤값으로 입력하기 위해 자동생성
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
                result += " " + dotComsList.get(x).getName();
                break;
            } else if (result.equals("kill")) {
                result += " " + dotComsList.get(x).getName();
                dotComsList.remove(x);
                break;
            }
        }
        if (!result.equals("miss"))
            System.out.println(result);
    }

    // 모든 extdotcomgame.DotCom 격파됨
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




}
