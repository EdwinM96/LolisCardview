package com.example.max00.loliscardview.Fragments;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.max00.loliscardview.Activities.OnCheckBoxClickListener;
import com.example.max00.loliscardview.Adapters.RecyclerViewAdapter_cardview;
import com.example.max00.loliscardview.R;
import com.example.max00.loliscardview.Classes.Lolis;

import java.util.ArrayList;
import java.util.logging.Handler;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TabFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_LIST = "LIST";
    private static final String ARG_FAV = "FAV";

    // TODO: Rename and change types of parameters
    private ArrayList<Lolis> lista;
    private ArrayList<Lolis> favorites;
    private boolean fav;
    private Context context;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter_cardview adapter;
    //private SwipeRefreshLayout swipeRefreshLayout;
    private OnFragmentInteractionListener mListener;
    //private OnCheckBoxClickListener listener;

    public TabFragment() {
        // Required empty public constructor
    }

    public RecyclerViewAdapter_cardview getAdapter() {
        return adapter;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TabFragment newInstance(ArrayList<Lolis> param1, Boolean param2) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_LIST, param1);
        args.putBoolean(ARG_FAV, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            lista = (ArrayList<Lolis>) getArguments().getSerializable(ARG_LIST);
            fav = getArguments().getBoolean(ARG_FAV);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab, container, false);
        //swipeRefreshLayout = v.findViewById(R.id.swiper);
        recyclerView = v.findViewById(R.id.recycler_view_tab2);
        if(!fav){
            adapter = new RecyclerViewAdapter_cardview(lista) {
                @Override
                public void onFavClick(boolean b, int position) {
                    mListener.onFragmentInteraction(b,position);
                    adapter.notifyDataSetChanged();
                }
            };
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(adapter);
        } if(fav){
            adapter = new RecyclerViewAdapter_cardview(lista) {
                @Override
                public void onFavClick(boolean b, int position) {
                    mListener.onFragmentInteraction(b,position);
                    adapter.notifyDataSetChanged();
                }
            };
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(adapter);
        }
        return v;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initiateRefresh();
            }
        });*/
    }


    // TODO: Rename method, update argument and hook method into UI event
    /*public void onButtonPressed(CompoundButton buttonView, boolean isChecked) {
        if (mListener != null) {
            mListener.onFragmentInteraction(CompoundButton buttonView, boolean isChecked);
        }
    }*/

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.context = context;
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
            //listener = (OnCheckBoxClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        //listener = null;
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
        void onFragmentInteraction(boolean a, int pos);
    }

    /*private void initiateRefresh() {
        newInstance(lista);
        lista.remove(0);


        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        },3000);
    }*/

    /*private void Lolis(final RecyclerView recyclerView){
        adapter = new RecyclerViewAdapter_cardview(lista) {
            @Override
            public void onFavClick(boolean b, int position) {
                mListener.onFragmentInteraction(b,position);
            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }*/
}
