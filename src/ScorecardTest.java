
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ScorecardTest {
	private String[] playerScore;
	
	@Before
	public void setup() {
		RandomScoreGenerator randomScore = new RandomScoreGenerator();
		playerScore = randomScore.generate();
	}
	
	@Test
	public void perfectGameScoresThreeHundred() {
		String[] perfectGame = {"X", "X", "X", "X", "X",
							   "X", "X", "X", "X", "XXX"};
		Scorecard scorecard = new Scorecard (perfectGame);
		int score = scorecard.getScore();
		
		Assert.assertEquals("A perfect game should return 300", 300, score);
		}
	
	@Test
	public void tenEmptyFramesScoresZero() {
		String[] allGutters = {"00", "00", "00", "00", "00",
				   			  "00", "00", "00", "00", "00"};
		
		Scorecard scorecard = new Scorecard (allGutters);
		int score = scorecard.getScore();
		
		Assert.assertEquals("All Gutters should return 0", 0, score);
	}
	
	@Test
	public void allSparesEqualsOneHundredFifty() {
		String[] allSpares = {"5/", "5/", "5/", "5/", "5/",
				   		      "5/", "5/", "5/", "5/", "5/5"};
		
		Scorecard scorecard = new Scorecard (allSpares);
		int score = scorecard.getScore();
		
		Assert.assertEquals("All spares should return 150", 150, score);
	}
	@Test
	public void allNinesShouldReturnNinety() {
		String allNines[] = {"09", "09", "09", "09", "09",
				   		   "09", "09", "09", "09", "09"};
		
		Scorecard scorecard = new Scorecard (allNines);
		int score = scorecard.getScore();
		
		Assert.assertEquals("All nines should return 90", 90, score);
	}
	@Test
	public void noGuttersStrikesOrSpares() {
		String noGuttersStrikesOrSpares[] = {"12", "12", "12", "12", "12",
		   		   							"12", "12", "12", "12", "12"};
		
		Scorecard scorecard = new Scorecard(noGuttersStrikesOrSpares);
		int score = scorecard.getScore();
		
		Assert.assertEquals("If one rolls over three pins every frame with no gutters they will score 30", 30, score);
	}
	@Test 
	public void oneStrikeAndAllGuttersReturnTen() {
		String oneStrikeAndAllGutters[] = {"X", "00", "00", "00", "00",
	   			  							"00", "00", "00", "00", "00"};
		
		Scorecard scorecard = new Scorecard(oneStrikeAndAllGutters);
		int score = scorecard.getScore();
		
		Assert.assertEquals("One strike and all gutters should return 10", 10, score);
	}
	@Test
	public void oneSpareAndAllGuttersReturnsTen() {
		String oneSprareAndAllGutters[] = {"5/", "00", "00", "00", "00",
						"00", "00", "00", "00", "00"};
		
		Scorecard scorecard = new Scorecard(oneSprareAndAllGutters);
		int score = scorecard.getScore();
		
		Assert.assertEquals("One spare and all gutters should return 10", 10, score);
		
	}
	@Test
	public void oneStrikeOneSpareAndAllGuttersShouldReturnTwenty() {
		String oneStrikeOneSpare[] = {"X", "5/", "00", "00", "00",
										   "00", "00", "00", "00", "00"};

		Scorecard scorecard = new Scorecard(oneStrikeOneSpare);
		int score = scorecard.getScore();

		Assert.assertEquals("One strike one spare and all gutters should return 30", 30, score);
	}
	@Test
	public void oneSpareAndOneStrikeShouldReturnThirty() {
		String oneSpareAndOneStrike[] = {"5/", "X", "00", "00", "00",
										   "00", "00", "00", "00", "00"};

		Scorecard scorecard = new Scorecard(oneSpareAndOneStrike);
		int score = scorecard.getScore();

		Assert.assertEquals("One spare, one strike, and all gutters should return 30", 30, score);
	}
	@Test
	public void threeStrikesAndAllGuttersShouldReturnSixty() {
		String threeStrikesAndAllGutters[] = {"X", "X", "X", "00", "00",
											"00", "00", "00", "00", "00"};
		
		Scorecard scorecard = new Scorecard(threeStrikesAndAllGutters);
		int score = scorecard.getScore();
		
		Assert.assertEquals("Three strikes and all gutters should return 60", 60, score);
	}
	@Test
	public void threeSparesAndAllGuttersShouldReturnThirty() {
		String threeSparesAndAllGutters[] = {"5/", "5/", "5/", "00", "00",
				   							"00", "00", "00", "00", "00"};
		
		Scorecard scorecard = new Scorecard(threeSparesAndAllGutters);
		int score = scorecard.getScore();
		
		Assert.assertEquals("Three spares and all gutters should return 40", 40, score);
	}
	@Test
	public void scoreWithStrikesAndNoGuttersReturnsCorrectly() {
		String strikesAndNoGutters[] = {"X", "12", "34", "X", "X",
				   						"X", "X", "X", "12", "34"};
		
		Scorecard scorecard = new Scorecard(strikesAndNoGutters);
		int score = scorecard.getScore();
		
		Assert.assertEquals("This player should receive the score of 157", 157, score);
	}
	@Test
	public void scoreWithSparesAndNoGuttersReturnsCorrectly() {
		String sparesAndNoGutters[] = {"5/", "12", "34", "5/", "5/",
										"5/", "5/", "5/", "12", "34"};
		
		Scorecard scorecard = new Scorecard(sparesAndNoGutters);
		int score = scorecard.getScore();
		
		Assert.assertEquals("this player should receive the score of 102", 102, score);
	}
	@Test
	public void strikesSparesAndNoGuttersReturnsCorrectly() {
		String strikesSparesAndNoGutters[] = {"5/", "12", "34", "5/", "X",
											 "5/", "X", "5/", "12", "34"};
		
		Scorecard scorecard = new Scorecard(strikesSparesAndNoGutters);
		int score = scorecard.getScore();
		
		Assert.assertEquals("The score for this player should be 122", 122, score);
	}
	@Test
	public void strikesSparesAndGutters() {
		String strikesSparesAndGutters[] = {"5/", "10", "34", "5/", "X",
				 							  "5/", "X", "5/", "02", "34"};
		
		Scorecard scorecard = new Scorecard(strikesSparesAndGutters);
		int score = scorecard.getScore();
		
		Assert.assertEquals("This player should receive the score of 118", 118, score);
	}
	@Test
	public void tenthFrameContainsStrikeAndSpare() {
		String[] tenthFrameStrikeSpare = {"X", "X", "X", "X", "X",
				   						"X", "X", "X", "X", "X5/"};
		
		Scorecard scorecard = new Scorecard(tenthFrameStrikeSpare);
		int score = scorecard.getScore();
		
		Assert.assertEquals("This player should receive the score of 285", 285, score);
	}
	@Test
	public void tenthFrameContainsSpareAndNoStrike() {
		String[] tenthFrameSpareNoStrike = {"X", "X", "X", "X", "X",
										   "X", "X", "X", "X", "5/5"};
		
		Scorecard scorecard = new Scorecard (tenthFrameSpareNoStrike);
		int score = scorecard.getScore();
		
		Assert.assertEquals("This player should receive the score of 270", 270, score);
	}
	@Test
	public void randomScoreGeneratesTenStrings() {
		Assert.assertTrue("There should be ten strings in a generated array", playerScore.length == 10);
	}
	@Test
	public void radomScoreGeneratesTenStringsWithNumbersStrikesOrSparesInThem() {
		boolean badEntry = false;
		for (int i=0 ; i < playerScore.length; i++) {
			if (!playerScore[i].contains("X") && !playerScore[i].contains("/")) {
				try {
					badEntry = Integer.parseInt(playerScore[i]) <= 0;
					badEntry = Integer.parseInt(playerScore[i]) >= 10;
				} catch (NumberFormatException e) {
					badEntry = true;
				}
			}
		}
		Assert.assertFalse("There should be no bad entries in our randomly generated score", badEntry);
	}
}
