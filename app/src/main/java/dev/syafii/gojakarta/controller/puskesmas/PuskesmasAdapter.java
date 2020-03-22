package dev.syafii.gojakarta.controller.puskesmas;

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
import dev.syafii.gojakarta.model.puskesmas.PuskesmasData;
import dev.syafii.gojakarta.util.ItemClickListener;

public class PuskesmasAdapter extends RecyclerView.Adapter<PuskesmasAdapter.ViewHolder> {
    private Context context;
    private List<PuskesmasData> puskesmasDataList;
    private ItemClickListener<PuskesmasData> itemClickListener;

    public PuskesmasAdapter(Context context, List<PuskesmasData> puskesmasDataList) {
        this.context = context;
        this.puskesmasDataList = puskesmasDataList;
    }

    public void setItemClickListener(ItemClickListener<PuskesmasData> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
    public void setPuskesmasDataList(List<PuskesmasData> puskesmasDataList){
        this.puskesmasDataList = puskesmasDataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_puskesmas, null);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PuskesmasData data = puskesmasDataList.get(position);
        holder.data = data;
        holder.tvNamePuskesmas.setText(data.getNamaPuskesmas());
    }

    @Override
    public int getItemCount() {
        return puskesmasDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        PuskesmasData data;
        @BindView(R.id.tv_namePuskesmas)
        TextView tvNamePuskesmas;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener !=null) itemClickListener.onItemClick(data);
        }
    }

}
