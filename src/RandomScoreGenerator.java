
public class RandomScoreGenerator {

	public String[] generate() {
		String[] randomScore = new String[10];
		for (int i=0 ; i < randomScore.length ; i++) {
			randomScore[i] = "" + (int)(Math.random() * 11);
		}
		return randomScore;
	}
}
