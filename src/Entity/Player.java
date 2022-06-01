package Entity;

public class Player {

	//Attributes
	private String name;
	
	private String nickname;

	
	//Constructor
	
	public Player(String name, String nickname) {
		this.name = name;
		this.nickname = nickname;
	}


//Methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	
}
