package dev.syafii.gojakarta.controller.pospemadam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.syafii.gojakarta.R;
import dev.syafii.gojakarta.model.pospemadam.PosPemadamData;
import dev.syafii.gojakarta.util.ItemClickListener;

public class PosPemadamAdapter extends RecyclerView.Adapter<PosPemadamAdapter.ViewHolder> {
    private Context context;
    private List<PosPemadamData> posPemadamDataList;
    private ItemClickListener<PosPemadamData> itemClickListener;

    public PosPemadamAdapter(Context context, List<PosPemadamData> posPemadamDataList) {
        this.context = context;
        this.posPemadamDataList = posPemadamDataList;
    }

    public void setItemClickListener(ItemClickListener<PosPemadamData> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
    public void setPosPemadamDataList(List<PosPemadamData> posPemadamDataList){
        this.posPemadamDataList = posPemadamDataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pospemadam, null);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PosPemadamData data = posPemadamDataList.get(position);
        holder.pemadamData = data;
        holder.namePosPemadam.setText(data.getPOSPEMADAM());
        holder.addressPosPemadam.setText(data.getALAMAT());

    }

    @Override
    public int getItemCount() {
        return posPemadamDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.tv_namePosPemadam)
        TextView namePosPemadam;
        @BindView(R.id.tv_almatPosPemadam)
        TextView addressPosPemadam;

        PosPemadamData pemadamData;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener !=null) itemClickListener.onItemClick(pemadamData);
        }
    }
}
