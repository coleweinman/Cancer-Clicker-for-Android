package game.Game.Characters;

import game.Game.CharacterData;
import game.Main.Price;

public class Noah extends Character {
	
	public Noah() {
		super("Noah");
		setCellRate(CharacterData.Noah.getCellRate());
		setPrice(CharacterData.Noah.getPrice());
		setSpace(CharacterData.Noah.getSpace());
	}
}
