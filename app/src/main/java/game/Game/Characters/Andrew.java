package game.Game.Characters;

import game.Game.CharacterData;
import game.Main.Price;

public class Andrew extends Character {
	
	public Andrew() {
		super("Andrew");
		setCellRate(CharacterData.Andrew.getCellRate());
		setPrice(CharacterData.Andrew.getPrice());
		setSpace(CharacterData.Andrew.getSpace());
	}
}
