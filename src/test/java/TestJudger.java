import org.junit.Assert;
import org.junit.Test;

public class TestJudger {
    //测试两方都是同花顺时的胜负判定
    @Test
    public void testTieWithBothStraightFlush(){
        Judger judger = new Judger();
        judger.setWhiteCards("2S 3S 4S 5S 6S");
        judger.setBlackCards("2D 3D 4D 5D 6D");
        Assert.assertEquals("Tie", judger.judge());
    }
    @Test
    public void testWhiteWinWithBothStraightFlush(){
        Judger judger = new Judger();
        judger.setWhiteCards("3S 4S 5S 6S 7S");
        judger.setBlackCards("2D 3D 4D 5D 6D");
        Assert.assertEquals("White wins", judger.judge());
    }

    //测试两方都是同花时的胜负判定
    @Test
    public void testTieWithBothFlush(){
        Judger judger = new Judger();
        judger.setWhiteCards("3S 4S QS 6S 7S");
        judger.setBlackCards("3D 4D QD 6D 7D");
        Assert.assertEquals("Tie", judger.judge());
    }
    @Test
    public void testWhiteWinWithBothFlush(){
        Judger judger = new Judger();
        judger.setWhiteCards("3S 4S KS 6S 7S");
        judger.setBlackCards("3D 4D QD 6D 7D");
        Assert.assertEquals("White wins", judger.judge());
    }

    //测试两方都是顺子时的胜负判定
    @Test
    public void testTieWithBothStraight(){
        Judger judger = new Judger();
        judger.setWhiteCards("5D 6S 7D 9H 8S");
        judger.setBlackCards("5H 6D 7H 8C 9D");
        Assert.assertEquals("Tie", judger.judge());
    }
    @Test
    public void testWhiteWinWithBothStraight(){
        Judger judger = new Judger();
        judger.setWhiteCards("5S 6D 7C 8S 9H");
        judger.setBlackCards("3D 4D 5C 6H 7D");
        Assert.assertEquals("White wins", judger.judge());
    }

    //测试两方都是三条时的胜负判定
    @Test
    public void testWhiteWinWithBothThreeOfAKind(){
        Judger judger = new Judger();
        judger.setWhiteCards("5S 5D 5H 6S 2D");
        judger.setBlackCards("4S 4D 4H 7D 2H");
        Assert.assertEquals("White wins", judger.judge());
    }

    //测试两方都是两对时的胜负判定
    @Test
    public void testTieWithBothTwoPairs(){
        Judger judger = new Judger();
        judger.setWhiteCards("5S 5D 6H 6S 2D");
        judger.setBlackCards("5C 5H 6C 6D 2H");
        Assert.assertEquals("Tie", judger.judge());
    }
    @Test
    public void testWhiteWinWithBothTwoPairs(){
        Judger judger = new Judger();
        judger.setWhiteCards("5S 5D 6H 6S 3D");
        judger.setBlackCards("5C 5H 4C 4D 3H");
        Assert.assertEquals("White wins", judger.judge());
        judger.setBlackCards("4C 4H 6C 6D 3H");
        Assert.assertEquals("White wins", judger.judge());
        judger.setBlackCards("5C 5H 6C 6D 2H");
        Assert.assertEquals("White wins", judger.judge());
    }

    //测试两方都是一对时的胜负判定
    @Test
    public void testTieWithBothOnePair(){
        Judger judger = new Judger();
        judger.setWhiteCards("5S 5D 8H 6S 2D");
        judger.setBlackCards("5C 5H 8C 6D 2H");
        Assert.assertEquals("Tie", judger.judge());
    }
    @Test
    public void testWhiteWinWithBothOnePair(){
        Judger judger = new Judger();
        judger.setWhiteCards("5S 5D 8H 6S 3D");

        judger.setBlackCards("5C 5H 7C 6D 3H");
        Assert.assertEquals("White wins", judger.judge());
        judger.setBlackCards("4C 4H 8C 6D 3H");
        Assert.assertEquals("White wins", judger.judge());
        judger.setBlackCards("5C 5H 8C 4D 3H");
        Assert.assertEquals("White wins", judger.judge());
        judger.setBlackCards("5C 5H 8C 6D 2H");
        Assert.assertEquals("White wins", judger.judge());
    }

    //测试两方都是散牌时的胜负判定
    @Test
    public void testTieWithBothOffsuit(){
        Judger judger = new Judger();
        judger.setWhiteCards("AH 2C 4D 6H 7S");
        judger.setBlackCards("7D 4S 6C AD 2S");
        Assert.assertEquals("Tie", judger.judge());
    }
    @Test
    public void testWhiteWinWithBothOffsuit(){
        Judger judger = new Judger();
        judger.setWhiteCards("AH 2C 4D 6H 7S");

        judger.setBlackCards("7D 4S 6C 9D 2S");
        Assert.assertEquals("White wins", judger.judge());
        judger.setBlackCards("3D 4S 6C AD 2S");
        Assert.assertEquals("White wins", judger.judge());
    }

    //-------------------------------------------
    //              题目描述中的测试用例
    @Test
    public void testGivenSample1(){
        Judger judger = new Judger();
        judger.setBlackCards("2H 3D 5S 9C KD");
        judger.setWhiteCards("2C 3H 4S 8C AH");
        Assert.assertEquals("White wins", judger.judge());
    }

    @Test
    public void testGivenSample2(){
        Judger judger = new Judger();
        judger.setBlackCards("2H 4S 4C 2D 4H");
        judger.setWhiteCards("2S 8S AS QS 3S");
        Assert.assertEquals("White wins", judger.judge());
    }

    @Test
    public void testGivenSample3(){
        Judger judger = new Judger();
        judger.setBlackCards("2H 3H 5H 9H KH");
        judger.setWhiteCards("2C 3H 4S 5C 6H");
        Assert.assertEquals("Black wins", judger.judge());
    }

    @Test
    public void testGivenSample4(){
        Judger judger = new Judger();
        judger.setBlackCards("2H 3D 5S 9C KD");
        judger.setWhiteCards("2D 3H 5C 9S KH");
        Assert.assertEquals("Tie", judger.judge());
    }
}
