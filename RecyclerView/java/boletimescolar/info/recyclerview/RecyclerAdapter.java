package boletimescolar.info.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sg-0036936 on 08/09/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    //FAKE DATA PRO RECYCLER
    String[] listas1, listas2;

    public RecyclerAdapter(String[] listas1, String[] listas2) {
        this.listas1 = listas1;
        this.listas2 = listas2;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);

        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.lista1.setText(listas1[position]);
        holder.lista2.setText(listas2[position]);
    }



    @Override
    public int getItemCount() {
        return listas1.length;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView lista1, lista2;

        public RecyclerViewHolder(View view) {
            super(view);
            lista1 = (TextView) view.findViewById(R.id.lista1);
            lista2 = (TextView) view.findViewById(R.id.lista2);
        }

    }

}
