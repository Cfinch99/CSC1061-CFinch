
public class Radio {
	private final int MAX_VOLUME = 10;
	
	private boolean hasAppleCarPlay;
	private boolean hasAndroidAuto;
	private int volume;
	
	
	public Radio(boolean hasAppleCarPlay, boolean hasAndroidAuto, int volume) {
		super();
		this.hasAppleCarPlay = hasAppleCarPlay;
		this.hasAndroidAuto = hasAndroidAuto;
		this.volume = volume;
	}


	public boolean isHasAppleCarPlay() {
		return hasAppleCarPlay;
	}


	public void setHasAppleCarPlay(boolean hasAppleCarPlay) {
		this.hasAppleCarPlay = hasAppleCarPlay;
	}


	public boolean isHasAndroidAuto() {
		return hasAndroidAuto;
	}


	public void setHasAndroidAuto(boolean hasAndroidAuto) {
		this.hasAndroidAuto = hasAndroidAuto;
	}


	public int getVolume() {
		return volume;
	}


	public void setVolume(int volume) {
		if (volume > MAX_VOLUME) {
			this.volume = MAX_VOLUME;
		}
		else {
			this.volume = volume;
		}
	}


	
	
	
	
	
	@Override
	public String toString() {
		return "Radio [hasAppleCarPlay=" + hasAppleCarPlay + 
				", hasAndroidAuto=" + hasAndroidAuto + ", volume=" + volume
				+ "]";
	}
}
