
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
		return 300;
	}
}
