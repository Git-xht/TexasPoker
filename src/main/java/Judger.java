import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Judger {
    private TexasPoker white;
    private TexasPoker black;

    //将同花顺、顺子等每一种牌型都映射为int类型,方便比较
    private static Map<String, Integer> scoreMapper =
            new HashMap<String, Integer>(){{
                put("StraightFlush", 7);
                put("Flush", 6);
                put("Straight", 5);
                put("ThreeOfAKind", 4);
                put("TwoPairs", 3);
                put("OnePair", 2);
                put("Offsuit", 1);
            }};

    public Judger(String whiteCards, String blackCards){
        this.white = new TexasPoker(whiteCards);
        this.black = new TexasPoker(blackCards);
    }
    public Judger(){
        this.white = new TexasPoker();
        this.black = new TexasPoker();
    }

    //        ---      获胜者判定      ---
    public String judge(){
        int whiteScore = scoreMapper.get(white.score());
        int blackScore = scoreMapper.get(black.score());
        String winner = "";
        if(whiteScore > blackScore) winner = "White";           //若一方的牌型优于另一方，则直接得出优胜者
        else if(whiteScore < blackScore) winner = "Black";
        else{                                                   //若两方牌型一样，继续按照各种牌型的规则判断
            if(whiteScore == 7)
                winner = judgeWinnerWithBothStraightFlush();
            else if(whiteScore == 6)
                winner = judgeWinnerWithBothFlush();
            else if(whiteScore == 5)
                winner = judgeWinnerWithBothStraight();
            else if(whiteScore == 4)
                winner = judgeWinnerWithBothThreeOfAKind();
            else if(whiteScore == 3)
                winner = judgeWinnerWithBothTwoPairs();
            else if(whiteScore == 2)
                winner = judgeWinnerWithBothOnePair();
            else if(whiteScore == 1)
                winner = judgeWinnerWithBothOffsuit();
        }
        return winner.equals("") ? "Tie" : winner + " wins";
    }





    public void setWhiteCards(String cards){
        this.white.setCards(cards);
    }

    public void setBlackCards(String cards){
        this.black.setCards(cards);
    }

    //在两方都是同花顺时判断获胜方
    private String judgeWinnerWithBothStraightFlush(){
        String winner = "";
        int whiteMax = white.getNthMaxNumber(1);
        int blackMax = black.getNthMaxNumber(1);
        if(whiteMax != blackMax)
            winner = whiteMax > blackMax ? "White" : "Black";
        return winner;
    }

    //在两方都是同花时判断获胜方
    private String judgeWinnerWithBothFlush(){
        return judgeWinnerWithBothOffsuit();
    }

    //在两方都是散牌时判断获胜方
    private String judgeWinnerWithBothOffsuit(){
        String winner = "";
        int N = 1;
        int whiteNthMax = 0, blackNthMax = 0;
        while (N <= white.getCardsLength() &&
                (whiteNthMax=white.getNthMaxNumber(N)) == (blackNthMax=black.getNthMaxNumber(N))){
            ++N;
        }
        if(whiteNthMax != blackNthMax)
            winner = whiteNthMax > blackNthMax ? "White" : "Black";
        return winner;
    }

    //在两方都是顺子时判断获胜方
    private String judgeWinnerWithBothStraight(){
        String winner = "";
        int whiteMax = white.getNthMaxNumber(1);
        int blackMax = black.getNthMaxNumber(1);
        if(blackMax != whiteMax)
            winner = whiteMax > blackMax ? "White" : "Black";
        return winner;
    }

    //在两方都是三条时判断获胜方
    private String judgeWinnerWithBothThreeOfAKind(){
        String winner = "";
        int whiteThree = white.getThreeOfAKindNumber();
        int blackThree = black.getThreeOfAKindNumber();
        if(whiteThree != blackThree)
            winner = whiteThree > blackThree ? "White" : "Black";
        return winner;
    }

    //在两方都是两对时判断获胜方
    private String judgeWinnerWithBothTwoPairs(){
        String winner = "";
        int[] whiteNumbers = white.getTwoPairsNumber();
        int[] blackNumbers = black.getTwoPairsNumber();
        for(int i = 0;i < whiteNumbers.length;++i){
            if(whiteNumbers[i] != blackNumbers[i]){
                winner = whiteNumbers[i] > blackNumbers[i] ? "White" : "Black";
                break;
            }
        }
        return winner;
    }

    //在两方都是一对时判断获胜方
    private String judgeWinnerWithBothOnePair(){
        String winner = "";
        int[] whiteNumber = white.getOnePairNumber();
        int[] blackNumber = black.getOnePairNumber();
        int[] whiteSingle = Arrays.copyOfRange(whiteNumber, 1, whiteNumber.length);
        int[] blackSingle = Arrays.copyOfRange(blackNumber, 1, blackNumber.length);
        Arrays.sort(whiteSingle);
        Arrays.sort(blackSingle);
        if(whiteNumber[0] != blackNumber[0])
            return whiteNumber[0] > blackNumber[0] ? "White" : "Black";
        for(int i = whiteSingle.length - 1;i >= 0;--i){
            if(whiteSingle[i] != blackSingle[i]){
                winner = whiteSingle[i] > blackSingle[i] ? "White" : "Black";
                break;
            }
        }
        return winner;
    }
}
