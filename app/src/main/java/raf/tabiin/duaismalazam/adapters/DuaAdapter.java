package raf.tabiin.duaismalazam.adapters;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import raf.tabiin.duaismalazam.R;
import raf.tabiin.duaismalazam.databinding.DuaItemElementBinding;
import raf.tabiin.duaismalazam.domain.models.CounterItem;
import raf.tabiin.duaismalazam.domain.models.DuaItem;

public class DuaAdapter extends RecyclerView.Adapter<DuaAdapter.MyViewHolder>{
    private LayoutInflater inflater;
    private List<DuaItem> duaItemsList;

    public DuaAdapter(Context context, List<DuaItem> duaItemsList) {
        this.duaItemsList = duaItemsList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.dua_item_element, parent, false
        );
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.duaArabicText.setText(this.duaItemsList.get(position).duaArabicText);
        holder.binding.duaTranscriptText.setText(this.duaItemsList.get(position).duaTranscriptText);
        holder.binding.duaTranslateText.setText(this.duaItemsList.get(position).duaTranslateText);
        holder.binding.sepline.setText("");

        holder.itemView.setOnClickListener(v -> {
            ClipboardManager clipboard = (ClipboardManager)
                    v.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("",
                    holder.binding.duaArabicText.getText().toString() + "\n"
                            + holder.binding.duaTranscriptText.getText().toString() + "\n"
                            + holder.binding.duaTranslateText.getText().toString()  +
                            "\n \n Мусульманские приложения для Андроид в каталоге RuStore \n \n https://apps.rustore.ru/developer/ZPBnoCoBczpBFPZK0munW8NSpRTEayCj");

            clipboard.setPrimaryClip(clip);

            Snackbar.make(v, "ду'а скопировано в буфер обмена",
                    Snackbar.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return duaItemsList.size();
    }

    public void setDuaItemsList(List<DuaItem> duaItemsList) {
        this.duaItemsList = duaItemsList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        DuaItemElementBinding binding;
        final MaterialCardView duaCard;
        final TextView arabicText;
        final TextView transcriptText;
        final TextView translateText;
        final TextView sepLine;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DuaItemElementBinding.bind(itemView);
            duaCard = binding.duaItem;
            arabicText = binding.duaArabicText;
            transcriptText = binding.duaTranscriptText;
            translateText = binding.duaTranslateText;
            sepLine = binding.sepline;
        }
    }
}
