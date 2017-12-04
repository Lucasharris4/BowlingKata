
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
}
