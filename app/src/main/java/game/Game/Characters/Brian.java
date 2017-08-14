package game.Game.Characters;

import game.Game.CharacterData;
import game.Main.Price;

public class Brian extends Character {
	
	public Brian() {
		super("Brian");
		setCellRate(CharacterData.Brian.getCellRate());
		setPrice(CharacterData.Brian.getPrice());
		setSpace(CharacterData.Brian.getSpace());
	}
}
