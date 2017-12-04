
public class Scorecard {
	private String[] frames;

	public Scorecard(String[] perfectGame) {
		this.frames = perfectGame;
	}

	public String[] getFrames() {
		return frames;
	}

	public void setFrames(String[] frames) {
		this.frames = frames;
	}
	
	public int getScore() {
		int score = 0;
		for (int i = 0; i < 10; i++) {
			int frame = getFrame(frames[i]);
			score += frame;
			
		}
		return score;
	}

	private int getFrame(String currentFrame) {
		if (currentFrame.equals("X")) {
			return 30;
		}
		return 0;
	}
}
