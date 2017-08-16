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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import game.Game.Characters.Amine;
import game.Game.Characters.Andrew;
import game.Game.Characters.Brian;
import game.Game.Characters.Character;
import game.Game.Characters.Chris;
import game.Game.Characters.Daniel;
import game.Game.Characters.Garrett;
import game.Game.Characters.Noah;
import game.Game.Characters.Tinky;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CharactersFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CharactersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharactersFragment extends Fragment {
    private View view;

    private CharactersFragment.OnFragmentInteractionListener mListener;

    public CharactersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CharactersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharactersFragment newInstance(String param1, String param2) {
        CharactersFragment fragment = new CharactersFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public List<Character> getList() {
        List<Character> list = new ArrayList<Character>();
        list.add(new Brian());
        list.add(new Garrett());
        list.add(new Noah());
        list.add(new Andrew());
        list.add(new Daniel());
        list.add(new Amine());
        list.add(new Chris());
        list.add(new Tinky());
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
        list.add(R.drawable.pic_operation_school);
        list.add(R.drawable.pic_operation_school);
        return list;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_characters,container,false);
        view = v;
        RecyclerView recList = (RecyclerView) view.findViewById(R.id.cardList2);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this.getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        CharacterCardAdapter ca = new CharacterCardAdapter(getList(), getPics());
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
