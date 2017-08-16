package redtech.cancerclicker;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import game.Game.Operations.*;
import game.Game.Operations.Operation;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OperationsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OperationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OperationsFragment extends Fragment {
    private View view;

    private OnFragmentInteractionListener mListener;

    public OperationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OperationsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OperationsFragment newInstance(String param1, String param2) {
        OperationsFragment fragment = new OperationsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public List<Operation> getList() {
        List<Operation> list = new ArrayList<Operation>();
        list.add(new Box());
        list.add(new Garage());
        list.add(new Office());
        list.add(new Cole());
        list.add(new Nhan());
        list.add(new School());
        return list;
    }

    public List<Integer> getPics() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(R.drawable.pic_operation_box);
        list.add(R.drawable.pic_operation_garage);
        list.add(R.drawable.pic_operation_office);
        list.add(R.drawable.pic_operation_cole);
        list.add(R.drawable.pic_operation_nhan);
        list.add(R.drawable.pic_operation_school);
        return list;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_operations,container,false);
        view = v;
        RecyclerView recList = (RecyclerView) view.findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this.getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        OperationCardAdapter ca = new OperationCardAdapter(getList(), getPics());
        recList.setAdapter(ca);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
