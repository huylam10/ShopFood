//package ADAPTER;
//
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Color;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.nhom11_pro1121_md18309.R;
//
//import java.text.DecimalFormat;
//import java.util.List;
//
//import DAO.ChiTietDatHangDAO;
//import DAO.ThongTinNguoiDungDAO;
//import Model.DatHang;
//import Model.ThongTinNguoiDung;
//
//public class OderHistoryAdapter extends RecyclerView.Adapter<OderHistoryAdapter.OrderHistoryAdapterHolder> {
//
////    List<DatHang> list;
////    Context context;
////    ChiTietDatHangDAO chiTietDatHangDAO;
////    ThongTinNguoiDungDAO thongTinNguoiDungDAO;
////
////    public OderHistoryAdapter(List<DatHang> list, Context context) {
////        this.list = list;
////        this.context = context;
////        chiTietDatHangDAO = new ChiTietDatHangDAO(context);
////        thongTinNguoiDungDAO = new ThongTinNguoiDungDAO(context);
////    }
////
////    @NonNull
////    @Override
////    public OrderHistoryAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////        return new OrderHistoryAdapterHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.oder_history_item, parent, false));
////    }
////
////    @Override
////    public void onBindViewHolder(@NonNull OrderHistoryAdapterHolder holder, int position) {
////        DatHang datHang = list.get(position);
////        Log.e("ZZZZ", "onBindViewHolder: " + datHang.getIdtaikhoanDatHang());
////        ThongTinNguoiDung info = thongTinNguoiDungDAO.getInfo(datHang.getIdtaikhoanDatHang());
////        Log.e("Adapter", "onBindViewHolder: " + datHang);
////        String status = "";
////        holder.Order_History_items_ID.setText("Mã đơn: " + datHang.getId());
////        holder.Order_History_items_Buyer.setText("Khách hàng: " + info.getFullName());
////        holder.Order_History_items_Address.setText("Địa chỉ: " + info.getAdressNguoiDung());
////        holder.Order_History_items_Amount.setText(chiTietDatHangDAO.getSum(datHang.getId()) + "sản phẩm");
////        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
////
////        holder.Order_History_items_TotalPrice.setText(decimalFormat.format(datHang.getTotalpriceDatHang()) + "đ");
//////        holder.itemView.setOnClickListener(v -> {
//////            Intent intent = new Intent(context, OrerDetail.class);
//////            Bundle bundle = new Bundle();
//////            bundle.putSerializable("datHang", datHang);
//////            intent.putExtra("bundle", bundle);
//////            context.startActivity(intent);
//////        });
//////        switch (datHang.getStatusDatHang()) {
//////            case 1: {
//////                status = "Đang chờ xử lý";
//////                holder.Order_History_items_Status.setTextColor(Color.GREEN);
//////                break;
//////            }
//////            case 2: {
//////                status = "Đang giao";
//////                holder.Order_History_items_Status.setTextColor(Color.GREEN);
//////            }
//////            case 3: {
//////            }
//////            case 4: {
//////                status = "Đã hủy";
//////                holder.Order_History_items_Status.setTextColor(Color.RED);
//////                break;
//////            }
//////            case 5: {
//////                status = "Đã nhận";
//////                holder.Order_History_items_Status.setTextColor(Color.GREEN);
//////                break;
//////            }
//////        }
//////        holder.Order_History_items_Status.setText("Trạng thái :" + status);
//////    }
////
//////    @Override
//////    public int getItemCount() {
//////        return list.size();
//////    }
////
////    class OrderHistoryAdapterHolder extends RecyclerView.ViewHolder {
////
////        TextView Order_History_items_ID,Order_History_items_Buyer,Order_History_items_Address,Order_History_items_Amount,
////                Order_History_items_TotalPrice,Order_History_items_Status;
////
////        public OrderHistoryAdapterHolder(@NonNull View itemView) {
////            super(itemView);
////            Order_History_items_ID = itemView.findViewById(R.id.Order_History_items_ID);
////            Order_History_items_Buyer = itemView.findViewById(R.id.Order_History_items_Buyer);
////            Order_History_items_Address = itemView.findViewById(R.id.Order_History_items_Address);
////            Order_History_items_Amount = itemView.findViewById(R.id.Order_History_items_Amount);
////            Order_History_items_TotalPrice = itemView.findViewById(R.id.Order_History_items_TotalPrice);
////            Order_History_items_Status = itemView.findViewById(R.id.Order_History_items_Status);
////        }
////    }
//}
