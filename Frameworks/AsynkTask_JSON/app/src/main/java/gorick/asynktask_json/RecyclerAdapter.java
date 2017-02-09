package gorick.asynktask_json;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sg-0036936 on 07/02/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private ArrayList<String> listas1;

    public RecyclerAdapter(ArrayList<String> listas1) {
        this.listas1 = listas1;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);

        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.lista1.setText(listas1.get(position).toString());
    }



    @Override
    public int getItemCount() {
        return  listas1 == null ? 0 : listas1.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView lista1;

        public RecyclerViewHolder(View view) {
            super(view);
            lista1 = (TextView) view.findViewById(R.id.text_recycler_view);
        }

    }

}