import org.junit.Test;
import org.junit.Assert;

public class TestTexasPoker {
    @Test
    public void testIsStraightFlush(){
        TexasPoker texasPoker = new TexasPoker();
        boolean result;
        texasPoker.setCards("2D 3D 5D 4D 6D");
        result = texasPoker.isStraightFlush();
        Assert.assertEquals(true, result);
        texasPoker.setCards("2D 3D 5D 4D 6S");
        result = texasPoker.isStraightFlush();
        Assert.assertEquals(false, result);
        texasPoker.setCards("2D 3D 5D 4D 8D");
        result = texasPoker.isStraightFlush();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testIsFlush(){
        TexasPoker texasPoker = new TexasPoker();
        boolean result;
        texasPoker.setCards("2D 3D 5D 4D 6D");
        result = texasPoker.isFlush();
        Assert.assertEquals(false, result);
        texasPoker.setCards("2D 3D 8D 4D 6D");
        result = texasPoker.isFlush();
        Assert.assertEquals(true, result);
        texasPoker.setCards("2D 3D 5D 4D 6S");
        result = texasPoker.isFlush();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testIsStraight(){
        TexasPoker texasPoker = new TexasPoker();
        boolean result;
        texasPoker.setCards("2C 3C 4C 5C 6C");
        result = texasPoker.isStraight();
        Assert.assertEquals(false, result);
        texasPoker.setCards("2C 3H 4C 5D 6S");
        result = texasPoker.isStraight();
        Assert.assertEquals(true, result);
        texasPoker.setCards("2C 3H 4C 5D 9S");
        result = texasPoker.isStraight();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testIsThreeOfAKind(){
        TexasPoker texasPoker = new TexasPoker();
        boolean result;
        texasPoker.setCards("2D 2S 2C 5D 6C");
        result = texasPoker.isThreeOfAKind();
        Assert.assertEquals(true, result);
        texasPoker.setCards("2D 2S 2C 5D 2C");
        result = texasPoker.isThreeOfAKind();
        Assert.assertEquals(true, result);
        texasPoker.setCards("2D 3S 2C 5D 6C");
        result = texasPoker.isThreeOfAKind();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testIsTwoPairs(){
        TexasPoker texasPoker = new TexasPoker();
        boolean result;
        texasPoker.setCards("2D 3S 2H 3H 5S");
        result = texasPoker.isTwoPairs();
        Assert.assertEquals(true, result);
        texasPoker.setCards("2D 2S 2H 3H 5S");
        result = texasPoker.isTwoPairs();
        Assert.assertEquals(false, result);
        texasPoker.setCards("KD 3S 2H 3H 5S");
        result = texasPoker.isTwoPairs();
        Assert.assertEquals(false, result);
        texasPoker.setCards("2D 2S 2H 2C 5S");
        result = texasPoker.isTwoPairs();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testIsPairs(){
        TexasPoker texasPoker = new TexasPoker();
        boolean result;
        texasPoker.setCards("2D 3S 2H 3H 5S");
        result = texasPoker.isOnePair();
        Assert.assertEquals(false, result);
        texasPoker.setCards("2D 2S 2H 3H 5S");
        result = texasPoker.isOnePair();
        Assert.assertEquals(false, result);
        texasPoker.setCards("KD 3S 2H 3H 5S");
        result = texasPoker.isOnePair();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testIsOffsuit(){
        TexasPoker texasPoker = new TexasPoker();
        boolean result;
        texasPoker.setCards("2D 3C 5D 7H TS");
        result = texasPoker.isOffsuit();
        Assert.assertEquals(true, result);
        texasPoker.setCards("2D 3C 5D 2H TS");
        result = texasPoker.isOffsuit();
        Assert.assertEquals(false, result);
        texasPoker.setCards("2D 3C 3D 2H TS");
        result = texasPoker.isOffsuit();
        Assert.assertEquals(false, result);
        texasPoker.setCards("2D 2C 5D 7H 2S");
        result = texasPoker.isOffsuit();
        Assert.assertEquals(false, result);
        texasPoker.setCards("2D 3C 4D 5H 6S");
        result = texasPoker.isOffsuit();
        Assert.assertEquals(false, result);
        texasPoker.setCards("2D 3D 5D 7D TD");
        result = texasPoker.isOffsuit();
        Assert.assertEquals(false, result);
        texasPoker.setCards("2D 3D 5D 4D 6D");
        result = texasPoker.isOffsuit();
        Assert.assertEquals(false, result);
    }

    //对牌型判断的测试
    @Test
    public void testscore(){
        TexasPoker texasPoker = new TexasPoker();
        texasPoker.setCards("2S 3S 5S 6S 4S");
        Assert.assertEquals("StraightFlush", texasPoker.score());
        texasPoker.setCards("2S 3S 5S 6S QS");
        Assert.assertEquals("Flush", texasPoker.score());
        texasPoker.setCards("2S 3D 5C 6H 4S");
        Assert.assertEquals("Straight", texasPoker.score());
        texasPoker.setCards("3S 3H 3D 6S 4S");
        Assert.assertEquals("ThreeOfAKind", texasPoker.score());
        texasPoker.setCards("2S 2D 5S 5H 4S");
        Assert.assertEquals("TwoPairs", texasPoker.score());
        texasPoker.setCards("3H 3S 5S 6S 4S");
        Assert.assertEquals("OnePair", texasPoker.score());
        texasPoker.setCards("2D KS 5S AH 4S");
        Assert.assertEquals("Offsuit", texasPoker.score());
    }
}
