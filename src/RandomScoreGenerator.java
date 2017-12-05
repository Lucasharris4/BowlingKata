
public class RandomScoreGenerator {

	public String[] generate() {
		String[] randomScore = new String[10];
		int rollOne = 0;
		int rollTwo = 0;
		for (int i=0 ; i < randomScore.length ; i++) {
			int pins = 11;
			rollOne = (int)(Math.random() * pins);
			if (rollOne == 10) {
				randomScore[i] = "X";
			} else {
				pins -= rollOne;
				rollTwo = (int)(Math.random() * pins);
				randomScore[i] = rollOne + rollTwo == 10 ? rollOne + "/" : "" + rollOne + rollTwo;
			}
			
		}
		return randomScore;
	}
}
