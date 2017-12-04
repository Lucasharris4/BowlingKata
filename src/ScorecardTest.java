
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ScorecardTest {
	@Before
	public void setup() {
		;
	}
	
	@Test
	public void perfectGameScoresThreeHundred() {
		String[] perfectGame = {"X", "X", "X", "X", "X",
							   "X", "X", "X", "X", "X"};
		Scorecard scorecard = new Scorecard (perfectGame);
		int score = scorecard.getScore();
		
		Assert.assertEquals("A perfect game should return 300", 300, score);
		}
	
	@Test
	public void tenEmptyFramesScoresZero() {
		String[] allGutters = {"__", "__", "__", "__", "__",
				   			  "__", "__", "__", "__", "__"};
		
		Scorecard scorecard = new Scorecard (allGutters);
		int score = scorecard.getScore();
		
		Assert.assertEquals("All Gutters should return 0", 0, score);
	}
	
	@Test
	public void allSparesEqualsOneHundredFifty() {
		String[] allSpares = {"/", "/", "/", "/", "/",
				   "/", "/", "/", "/", "/"};
		
		Scorecard scorecard = new Scorecard (allSpares);
		int score = scorecard.getScore();
		
		Assert.assertEquals("All spares should return 150", 150, score);
	}
	@Test
	public void allNinesShouldReturnNinety() {
		String allNines[] = {"_9", "_9", "_9", "_9", "_9",
				   		   "_9", "_9", "_9", "_9", "_9"};
		
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
	public void oneStrikeAndAllGuttersReturn10() {
		String oneStrikeAndAllGutters[] = {"X", "__", "__", "__", "__",
	   			  							"__", "__", "__", "__", "__"};
		
		Scorecard scorecard = new Scorecard(oneStrikeAndAllGutters);
		int score = scorecard.getScore();
		
		Assert.assertEquals("One strike and all gutters should return 10", 10, score);
	}
}
