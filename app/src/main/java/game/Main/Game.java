package game.Main;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import game.Game.CharacterData;
import game.Game.OperationData;
import game.Game.Characters.Character;
import game.Game.Operations.*;
import game.Game.Operations.Operation;
import redtech.cancerclicker.MainActivity;
import redtech.cancerclicker.R;

public class Game {

	private static List<Operation> operations = new ArrayList<Operation>();
	private static int cellRate = 0;
	private static int moneyRate = 0;
	private static int cells = 0;
	private static double money = 0;
	private static int superCells = 0;
	private static int capacity = 0;
	private static int space = 0;
	private static int time = 0;
	private static boolean cheats = true;
	private static MainActivity mainActivity;
	private static Handler handler;
	
	public static void start(MainActivity m) {
		mainActivity = m;
		Save.load();
		if(cheats) {
			cells = 10000;
			money = 10000.44;
			superCells = 10;
		}
		if(operations.isEmpty())
			operations.add(new Box());

		handler = new Handler();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				action();
				calcCellRate();
				calcMoneyRate();
				calcSuperCell();
				calcSpace();
				addValues();
				updateUI();
				handler.postDelayed(this, 100);
			}
		};

		runnable.run();
	}

	private static void action() {
		for(Operation o : operations)
			for(Character c : o.getCharacters())
				c.action();
	}

	private static void addValues() {
		cells += cellRate;
		money += moneyRate;
	}

	private static void updateUI() {
		if(mainActivity.getHomeFragment().getView() != null) {
			TextView textView = (TextView) mainActivity.getHomeFragment().getView().findViewById(R.id.disCells);
			textView.setText(new ShortNumber(cells,false).toString());
			textView = (TextView) mainActivity.getHomeFragment().getView().findViewById(R.id.disCellsPerTick);
			textView.setText(new ShortNumber(cellRate,false).toString());
			textView = (TextView) mainActivity.getHomeFragment().getView().findViewById(R.id.disMoney);
			textView.setText(new Double(money).toString());
			textView = (TextView) mainActivity.getHomeFragment().getView().findViewById(R.id.disSpace);
			textView.setText(new Integer(space).toString()+"/"+new Integer(capacity).toString());
		}
		//TextView textView = (TextView) ((Activity)context).findViewById(R.id.disCells);
		//textView.setText(new ShortNumber(cells,true).toString());
		//textView.setText("h");

		//game.Application.GameTab.setCellRate(cellRate);
		//game.Application.GameTab.setSpace(space,capacity);
		//game.Application.GameTab.setSuperCell(superCells);
		//game.Application.GameTab.setMoney(money);
	}

	private static void calcCellRate() {
		int sum = 0;
		for(Operation o : operations) {
			sum -= o.getCellCost();
			for(Character c : o.getCharacters()) {
				sum += c.getCellRate()*(c.getCellMult()+1);
			}
		}
		cellRate = sum;
	}
	
	private static void calcMoneyRate() {
		int sum = 0;
		for(Operation o : operations) {
			sum -= (o.getMoneyCost()*(o.getMoneyMult()+1));
			for(Character c : o.getCharacters())
				sum += c.getMoneyRate();
		}
		moneyRate = sum;
	}
	
	public static void calcSuperCell() {
		double sum = 0;
		Random rand = new Random();
		for(Operation o : operations)
			for(Character c : o.getCharacters())
				sum += c.getSuperCellMult();
		sum /= 1000;
		double outcome = rand.nextDouble() * 1;
		if(outcome <= sum)
			superCells++;
	}			
	
	public static void calcSpace() {
		int tSpace = 0;
		int tCapacity = 0;
		for(Operation o : operations) {
			o.calcSpace();
			tSpace += o.getSpace();
			tCapacity += o.getCapacity();
		}
		space = tSpace;
		capacity = tCapacity;
	}
	public static void buyCharacter(Character c, Operation o) {
		if(o != null) {
			Price p;
			p = CharacterData.valueOf(c.getType()).getPrice();
			if(canBuy(p) && o.getSpace() + c.getSpace() <= o.getCapacity()) {
				cells -= p.getCells();
				money -= p.getMoney();
				superCells -= p.getSuperCell();
				c.setOperation(o);
				calcSpace();
			} else if(canBuy(p) && capacity-space >= c.getSpace()) {
				//JOptionPane.showMessageDialog(Application.Application.getTabbedPane(), "You don't have enough space in one operation to hold a new " + c.getType() + "!");
			}
		}
	}
	
	public static void buyOperation(Operation o) {
		Price p;
		p = OperationData.valueOf(o.getType()).getPrice();
		if(canBuy(p)) {
			cells -= p.getCells();
			money -= p.getMoney();
			superCells -= p.getSuperCell();
			operations.add(o);
		}
	}

	public static boolean canBuy(Price p) {
		if(cells >= p.getCells() && money >= p.getMoney() && superCells >= p.getSuperCell())
			return true;
		return false;
	}
	
	public static void addCell(int i) {
		cells += i;
	}
	
	public static List<Operation> getOperations() {
		return operations;
	}

	public static void convert(int i) {
		if(canBuy(new Price(i,0,0))) {
			money += (double)i/100;
			cells -= i;
		}
			
	}
	
	public static int getTime() {
		return time;
	}

	public static void setStats(int c, double m, int sc, ArrayList<Operation> o) {
		cells = c;
		money = m;
		superCells = sc;
		operations = o;
	}
	
	public static int getCells() {
		return cells;
	}
	
	public static double getMoney() {
		return money;
	}
	
	public static int getSuperCells() {
		return superCells;
	}
}
