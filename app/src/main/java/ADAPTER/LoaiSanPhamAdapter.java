package ADAPTER;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhom11_pro1121_md18309.R;

import java.util.List;

import Activities.AllLoaiSP;
import Model.LoaiSanPham;

public class LoaiSanPhamAdapter extends RecyclerView.Adapter<LoaiSanPhamAdapter.LoaiSanPhamHolder> {
    List<LoaiSanPham> list;
    Context context;

    public LoaiSanPhamAdapter(List<LoaiSanPham> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public LoaiSanPhamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LoaiSanPhamHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.loaisp_items, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull LoaiSanPhamHolder holder, int position) {
        LoaiSanPham loaiSanPham = list.get(position);
        try{
            holder.loaiSP_items_Img.setImageResource(Integer.parseInt(loaiSanPham.getImageLoaiSanPham()));
        }catch (Exception e){
            Uri uri = Uri.parse(loaiSanPham.getImageLoaiSanPham());
            holder.loaiSP_items_Img.setImageURI(uri);
        }
        holder.loaiSP_items_txt.setText(loaiSanPham.getNameLoaiSanPham());
        holder.loaiSP_items_View.setOnClickListener(v -> {
            Intent intent = new Intent(context, AllLoaiSP.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("loaiSP", loaiSanPham);
            intent.putExtra("bundle", bundle);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class LoaiSanPhamHolder extends RecyclerView.ViewHolder {
        ImageView loaiSP_items_Img;
        LinearLayout loaiSP_items_View;
        TextView loaiSP_items_txt;

        public LoaiSanPhamHolder(@NonNull View itemView) {
            super(itemView);
            loaiSP_items_txt = itemView.findViewById(R.id.loaiSP_items_txt);
            loaiSP_items_Img = itemView.findViewById(R.id.loaiSP_items_Img);
            loaiSP_items_View = itemView.findViewById(R.id.loaiSP_items_View);
        }
    }
}
