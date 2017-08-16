package redtech.cancerclicker;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import game.Game.Operations.Operation;
import game.Main.ShortNumber;

public class OperationCardAdapter extends RecyclerView.Adapter<OperationCardAdapter.ContactViewHolder> {

    private List<Operation> operationList;
    private List<Integer> picId;
    private View view;

    public OperationCardAdapter(List<Operation> operationList, List<Integer> picId) {
        this.operationList = operationList;
        this.picId = picId;
    }


    @Override
    public int getItemCount() {
        return operationList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        Operation operation = operationList.get(i);
        int id = picId.get(i);
        contactViewHolder.title.setText(operation.getType());
        contactViewHolder.space.setText(String.valueOf(operation.getCapacity()));
        contactViewHolder.cellCost.setText(new ShortNumber(operation.getPrice().getCells(),true).toString());
        contactViewHolder.moneyCost.setText(new ShortNumber(operation.getPrice().getMoney(),true).toString());
        contactViewHolder.picture.setImageResource(id);
        contactViewHolder.cellMult.setText(String.valueOf(operation.getCellMult()*100)+"%");
        contactViewHolder.moneyMult.setText(String.valueOf(operation.getMoneyMult()*100)+"%");
        contactViewHolder.cellTick.setText(new ShortNumber(operation.getCellCost(),true).toString()+"/t");
        contactViewHolder.moneyTick.setText(new ShortNumber(operation.getMoneyCost(),true).toString()+"/t");
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_operations, viewGroup, false);
        view = itemView;

        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        protected TextView title;
        protected TextView space;
        protected TextView cellCost;
        protected TextView moneyCost;
        protected ImageView picture;
        protected TextView cellMult;
        protected TextView moneyMult;
        protected TextView cellTick;
        protected TextView moneyTick;

        public ContactViewHolder(View v) {
            super(v);
            title =  (TextView) v.findViewById(R.id.labelTitle);
            space = (TextView)  v.findViewById(R.id.displaySpace);
            cellCost = (TextView)  v.findViewById(R.id.displayCellPrice);
            moneyCost = (TextView) v.findViewById(R.id.displayMoneyPrice);
            picture = (ImageView) v.findViewById(R.id.picture);
            cellMult = (TextView) v.findViewById(R.id.displayCellMult);
            moneyMult = (TextView) v.findViewById(R.id.displayMoneyMult);
            cellTick = (TextView) v.findViewById(R.id.displayCellsTick);
            moneyTick = (TextView) v.findViewById(R.id.displayMoneyTick);
        }
    }
}