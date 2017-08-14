package game.Game.Characters;

import game.Game.CharacterData;
import game.Main.Price;

public class Garrett extends Character {
	
	public Garrett() {
		super("Garrett");
		setCellRate(CharacterData.Garrett.getCellRate());
		setPrice(CharacterData.Garrett.getPrice());
		setSpace(CharacterData.Garrett.getSpace());
	}
}
