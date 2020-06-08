package com.dreamsense.menusyfragments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dreamsense.menusyfragments.R;
import com.dreamsense.menusyfragments.adaptador.MascotaAdaptador;
import com.dreamsense.menusyfragments.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRecycler extends Fragment {

    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;

    public FragmentRecycler() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_recycler, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
        respaldo();

        return v;
    }


    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.dog1, "Yayo", "0"));
        mascotas.add(new Mascota(R.drawable.dog2, "Pancho", "5"));
        mascotas.add(new Mascota(R.drawable.dog3, "Roger", "2"));
        mascotas.add(new Mascota(R.drawable.dog4, "Ari", "3"));
        mascotas.add(new Mascota(R.drawable.dog5, "Luna", "1"));
        mascotas.add(new Mascota(R.drawable.dog6, "Taco", "0"));
        mascotas.add(new Mascota(R.drawable.dog7, "Burguer", "6"));
        mascotas.add(new Mascota(R.drawable.dog8, "Mojo", "4"));
        mascotas.add(new Mascota(R.drawable.dog9, "Merlín", "2"));
        mascotas.add(new Mascota(R.drawable.dog10, "Fritanga", "1"));
        mascotas.add(new Mascota(R.drawable.dog11, "Boya", "0"));
    }


    public void respaldo() {
        if (!MascotaAdaptador.mascotasFavs.isEmpty()) {
            for (int x = 0, y = 0; x < mascotas.size() - 1 && y < MascotaAdaptador.mascotasFavs.size() - 1; x++) {
                if (mascotas.get(x).getNombre() == MascotaAdaptador.mascotasFavs.get(y).getNombre()) {
                    mascotas.get(x).setLikes(MascotaAdaptador.mascotasFavs.get(x).getLikes());
                    y++;
                }
            }
        }
    }

}
