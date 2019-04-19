package com.example.aplikasiskripsi.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aplikasiskripsi.Adapter.CardViewPahlawanAdapter;
import com.example.aplikasiskripsi.Adapter.GridPahlawanAdapter;
import com.example.aplikasiskripsi.Adapter.ListPahlawanAdapter;
import com.example.aplikasiskripsi.Model.ModelPahlawan;
import com.example.aplikasiskripsi.Model.PahlawanData;
import com.example.aplikasiskripsi.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Pahlawan extends Fragment {

    private RecyclerView rvCategory;
    private ArrayList<ModelPahlawan> pList = new ArrayList<>();

    public Pahlawan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pahlawan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvCategory = view.findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        pList.addAll(PahlawanData.getListData());
        String Recycler = this.getArguments().getString("KEY_RECYCLER").toString();
        if (Recycler.equals("List")){
            showRecyclerList();
        }else if(Recycler.equals("Grid")){
            showRecyclerGrid();
        }else if(Recycler.equals("CardView")){
            showRecyclerCardView();
        }else{
            Toast.makeText(getActivity(),"Data Error = "+Recycler,Toast.LENGTH_LONG).show();
        }

    }

    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        ListPahlawanAdapter listPahlawanAdapter = new ListPahlawanAdapter(getActivity());
        listPahlawanAdapter.setListPahlawan(pList);
        rvCategory.setAdapter(listPahlawanAdapter);
    }
    private void showRecyclerGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        GridPahlawanAdapter gridPahlawanAdapter = new GridPahlawanAdapter(getActivity());
        gridPahlawanAdapter.setListPahlawan(pList);
        rvCategory.setAdapter(gridPahlawanAdapter);
    }
    private void showRecyclerCardView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        CardViewPahlawanAdapter cardViewPresidentAdapter = new CardViewPahlawanAdapter(getActivity());
        cardViewPresidentAdapter.setListPahlawan(pList);
        rvCategory.setAdapter(cardViewPresidentAdapter);
    }
}
