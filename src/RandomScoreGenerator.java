
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
			if (i==9) {
				randomScore[9] = generateTenthFrame();
			}
			System.out.println("Frame " + i + ":  " + randomScore[i]);
		}
		return randomScore;
	}

	private String generateTenthFrame() {
		String firstRoll = getFirstRoll();
		String secondRoll = rollAgain(firstRoll);
		if (firstRoll.equals("X") || secondRoll.equals("/")) {
			String thirdRoll = rollAgain(secondRoll);
			return firstRoll + secondRoll + thirdRoll;
		}
		return firstRoll + secondRoll;
	}

	private String rollAgain(String firstRoll) {
		int roll = 0;
		try {
			roll = (int)(Math.random() * (11 - Integer.parseInt(firstRoll)));
			return roll + Integer.parseInt(firstRoll) == 10 ? "/" : "" + roll;
		} catch (NumberFormatException e) {
			return getFirstRoll();
		}
	}

	private String getFirstRoll() {
		int roll = (int)(Math.random() * 11);
		if (roll == 10) {
			return "X";
		}
		return "" + roll;
	}
}
