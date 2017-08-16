package redtech.cancerclicker;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import game.Game.Characters.Character;
import game.Main.ShortNumber;

public class CharacterCardAdapter extends RecyclerView.Adapter<CharacterCardAdapter.ContactViewHolder> {

    private List<Character> characterList;
    private List<Integer> picId;
    private View view;

    public CharacterCardAdapter(List<Character> characterList, List<Integer> picId) {
        this.characterList = characterList;
        this.picId = picId;
    }


    @Override
    public int getItemCount() {
        return characterList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {

        Character character = characterList.get(i);
        int id = picId.get(i);
        contactViewHolder.title.setText(character.getType());
        contactViewHolder.space.setText(String.valueOf(character.getSpace()));
        contactViewHolder.cellCost.setText(new ShortNumber(character.getPrice().getCells(),true).toString());
        Log.i("PUPPPETTT", character.getPrice().getCells()+"");
        contactViewHolder.moneyCost.setText(new ShortNumber(character.getPrice().getMoney(),true).toString());
        contactViewHolder.picture.setImageResource(id);
        contactViewHolder.cellTick.setText(new ShortNumber(character.getCellRate(),true).toString()+"/t");
        contactViewHolder.moneyTick.setText(new ShortNumber(character.getMoneyRate(),true).toString()+"/t");
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_characters, viewGroup, false);
        view = itemView;

        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        protected TextView title;
        protected TextView space;
        protected TextView cellCost;
        protected TextView moneyCost;
        protected ImageView picture;
        protected TextView cellTick;
        protected TextView moneyTick;

        public ContactViewHolder(View v) {
            super(v);
            title =  (TextView) v.findViewById(R.id.labelTitle);
            space = (TextView)  v.findViewById(R.id.displaySpace);
            cellCost = (TextView)  v.findViewById(R.id.displayCellCost);
            moneyCost = (TextView) v.findViewById(R.id.displayMoneyCost);
            picture = (ImageView) v.findViewById(R.id.picture);
            cellTick = (TextView) v.findViewById(R.id.displayCellsTick);
            moneyTick = (TextView) v.findViewById(R.id.displayMoneyTick);
        }
    }
}