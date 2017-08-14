package game.Game.Characters;

import java.util.ArrayList;
import java.util.List;


import game.Game.CharacterData;
import game.Game.Operations.Operation;

public class Trump extends Character {
	
	public Trump() {
		super("Trump");
		setPrice(CharacterData.Trump.getPrice());
		setSpace(CharacterData.Trump.getSpace());
		int i = game.Main.Game.getOperations().size();
		game.Main.Game.getOperations().add(new Operation("Mexico", 100));

		game.Main.Game.getOperations().get(i).add(new Character("Bad Hombre"));
		game.Main.Game.getOperations().get(i).add(new Character("Juan"));
		game.Main.Game.getOperations().get(i).add(new Character("Wall"));
			
	}
}
