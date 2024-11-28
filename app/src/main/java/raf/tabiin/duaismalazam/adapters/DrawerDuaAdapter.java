package raf.tabiin.duaismalazam.adapters;

import static java.lang.String.format;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

import raf.tabiin.duaismalazam.R;
import raf.tabiin.duaismalazam.domain.models.DrawerDuaContent;


public class DrawerDuaAdapter extends RecyclerView.Adapter<DrawerDuaAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<DrawerDuaContent> duaDrawer;
    private RecyclerView recyclerView;

    public DrawerDuaAdapter(Context context, List<DrawerDuaContent> duaDrawer) {
        this.duaDrawer = duaDrawer;
        this.inflater = LayoutInflater.from(context);
    }

    public DrawerDuaAdapter(Context context, List<DrawerDuaContent> duaDrawer,
                              RecyclerView recyclerView) {
        this.duaDrawer = duaDrawer;
        this.recyclerView = recyclerView;
        this.inflater = LayoutInflater.from(context);
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_dua_item,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        DrawerDuaContent newDua = duaDrawer.get(position);

        holder.itemDrawerName.setText(format("%s", newDua.getDuaDrawer()));

        holder.cardDrawerNameItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.scrollToPosition(holder.getAdapterPosition());

            }
        });
    }

    @Override
    public int getItemCount() {
        return duaDrawer.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView itemDrawerName;
        final MaterialCardView cardDrawerNameItem;
        ViewHolder(View view){
            super(view);
            itemDrawerName = view.findViewById(R.id.itemDrawerDua);
            cardDrawerNameItem = view.findViewById(R.id.cardDrawerDuaItem);
        }
    }

}