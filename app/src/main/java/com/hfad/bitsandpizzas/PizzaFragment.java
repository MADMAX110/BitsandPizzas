package com.hfad.bitsandpizzas;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PizzaFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView pizzaRecycle = (RecyclerView) inflater.inflate(
                R.layout.fragment_pizza, container, false);
        String[] pizzaNames = new String[Pizza.pizzas.length];
        for (int i = 0; i < pizzaNames.length; i++){
            pizzaNames[i] = Pizza.pizzas[i].getName();
        }
        int[] pizzasImages = new int[Pizza.pizzas.length];
        for (int i = 0; i < pizzaNames.length; i++){
            pizzasImages[i] = Pizza.pizzas[i].getImageResourceId();
        }
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pizzaNames, pizzasImages);
        pizzaRecycle.setAdapter(adapter);
        //在一个两列的网格中显示卡片视图
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        pizzaRecycle.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onCLick(int position) {
                Intent intent = new Intent(getActivity(), PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZA_ID, position);
                getActivity().startActivity(intent);
            }
        });

        return pizzaRecycle;
    }
}