package ADAPTER;

import static com.example.nhom11_pro1121_md18309.MainActivity.account_all;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhom11_pro1121_md18309.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import DAO.ThongTinNguoiDungDAO;
import Model.ThongTinNguoiDung;

public class ThongTinNguoiDungAdapter extends RecyclerView.Adapter<ThongTinNguoiDungAdapter.ViewHolder> {
    private Context context;
    SharedPreferences sharedPreferences;
    private List<ThongTinNguoiDung> list;
    private ThongTinNguoiDungDAO thongtinDao;
    String gioitinh = "";

    public ThongTinNguoiDungAdapter(Context context, List<ThongTinNguoiDung> list, ThongTinNguoiDungDAO thongtinDao) {
        this.context = context;
        this.list = list;
        this.thongtinDao = thongtinDao;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.thongtinnguoidung_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtAcId.setText("Id: " + list.get(position).getId());
        holder.txtAcId.setVisibility(View.GONE);
        if (account_all.getRole() == 3) {
            holder.idTaiKhoan.setText("Loại Tài Khoản: Khách Hàng");
        } else {
            holder.idTaiKhoan.setText("Loại Tài Khoản: Khách Hàng");
        }
        holder.txtName.setText("Họ và tên: " + list.get(position).getFullName());
        holder.txtEmail.setText("Email: " + list.get(position).getEmailNguoiDung());
        holder.txtSDT.setText("Số điện thoại: " + list.get(position).getSDTNguoiDung());
        holder.txtAddres.setText("Địa chỉ: " + list.get(position).getAdressNguoiDung());
        holder.txtBirthday.setText("Sinh nhật: " + list.get(position).getBirthdayNguoiDung());
        if (list.get(position).getGender() == 0) {
            holder.txtGender.setText("Giới tính: Nữ");
        } else if (list.get(position).getGender() == 1) {
            holder.txtGender.setText("Giới tính: Nam");
        }
        holder.txtCreated.setText("Created: " + list.get(position).getCreatedNguoiDung());
        holder.txtUpdated.setText("Updated: " + list.get(position).getUpdatedNguoiDung());
        holder.CapNhapThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(list.get(holder.getAdapterPosition()));
            }
        });


        if (account_all.getId() == list.get(position).getIdTaiKhoan()) {

        } else if (account_all.getId() != list.get(position).getIdTaiKhoan()) {

            holder.LayoutTT.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout LayoutTT;
        TextView txtAcId, idTaiKhoan, txtSDT;
        TextView txtName, txtEmail, txtAddres, txtBirthday, txtGender, txtCreated, txtUpdated;
        Button CapNhapThongTin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            txtAcId = itemView.findViewById(R.id.txtAcId);
            txtAcId = itemView.findViewById(R.id.txtAcId);
            idTaiKhoan = itemView.findViewById(R.id.idTK);
            txtName = itemView.findViewById(R.id.txtName);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtSDT = itemView.findViewById(R.id.txtSDT);
            txtAddres = itemView.findViewById(R.id.txtAddres);
            txtBirthday = itemView.findViewById(R.id.txtBirthday);
            txtGender = itemView.findViewById(R.id.txtGender);
            txtCreated = itemView.findViewById(R.id.txtCreated);
            txtCreated.setVisibility(View.GONE);
            txtUpdated = itemView.findViewById(R.id.txtUpdated);
            txtUpdated.setVisibility(View.GONE);
            CapNhapThongTin = itemView.findViewById(R.id.CapNhapThongTinNguoiDung);
            LayoutTT = itemView.findViewById(R.id.linearLayoutThongtin);


        }
    }

    private void showDialog(ThongTinNguoiDung thongTinNguoiDung) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context).setNegativeButton("Cập Nhập", null).setPositiveButton("Hủy", null);
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_sua_thong_tin_nguoi_dung, null);
        builder.setView(view);
        TextView txtAcId = view.findViewById(R.id.txtAcId);
        txtAcId.setVisibility(View.GONE);
        TextView idTaiKhoan = view.findViewById(R.id.idTaiKoan);
        idTaiKhoan.setVisibility(View.GONE);
        TextView txtCreated = view.findViewById(R.id.txtCreated);
        TextView txtUpdated = view.findViewById(R.id.txtUpdated);
        EditText edtName = view.findViewById(R.id.edtName);
        EditText edtEmail = view.findViewById(R.id.edtEmail);
        EditText edtSDT = view.findViewById(R.id.edtSDT);
        EditText edtAddres = view.findViewById(R.id.edtAddres);
        EditText edtBirthday = view.findViewById(R.id.edtBirthday);
        RadioButton GT_nam = view.findViewById(R.id.rdo_GT_Nam);
        RadioButton GT_nu = view.findViewById(R.id.rdo_BTN_Nu);
        txtAcId.setText("Id  :" + thongTinNguoiDung.getId());
        idTaiKhoan.setText("Id Tài Khoản:" + thongTinNguoiDung.getIdTaiKhoan());

        txtCreated.setText("Ngày tạo tài khoản:" + thongTinNguoiDung.getCreatedNguoiDung());
        txtUpdated.setText("Ngày cập nhập:" + thongTinNguoiDung.getUpdatedNguoiDung());
        txtCreated.setVisibility(View.GONE);
        txtUpdated.setVisibility(View.GONE);


        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences = context.getSharedPreferences("OKLuon", context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                String HoTen = edtName.getText().toString();
                String Email = edtEmail.getText().toString();
                String SDT = edtSDT.getText().toString();
                String Addres = edtAddres.getText().toString();
                String Birthday = edtBirthday.getText().toString();
                editor.putString("FullName", thongTinNguoiDung.setFullName(HoTen));
                if (HoTen.equals("")) {
                    Toast.makeText(context, "Không được để trống họ tên", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Email.equals("")) {
                    Toast.makeText(context, "Không được để trống Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (SDT.equals("")) {
                    Toast.makeText(context, "Không được để trống số điện thoại", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Addres.equals("")) {
                    Toast.makeText(context, "Không được để trống địa chỉ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Birthday.equals("")) {
                    Toast.makeText(context, "Không được để trống sinh nhật", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    thongTinNguoiDung.setEmailNguoiDung(Email);
                    thongTinNguoiDung.setSDTNguoiDung(SDT);
                    thongTinNguoiDung.setAdressNguoiDung(Addres);
                    thongTinNguoiDung.setBirthdayNguoiDung(Birthday);
                    editor.commit();
                    if (GT_nu.isChecked()) {
                        thongTinNguoiDung.setGender(1);
                    } else if (GT_nam.isChecked()) {
                        thongTinNguoiDung.setGender(0);
                    }
                    Calendar calendar = Calendar.getInstance();
                    @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String text = simpleDateFormat.format(calendar.getTime());
                    thongTinNguoiDung.setCreatedNguoiDung(text);

                    thongTinNguoiDung.setUpdatedNguoiDung(text);
                    boolean check = thongtinDao.capNhatThongTinNguoiDung(thongTinNguoiDung);
                    if (check) {
                        Toast.makeText(context, "Cập nhập thành công", Toast.LENGTH_SHORT).show();

                        loadData();
                    } else {
                        Toast.makeText(context, "Thất bại", Toast.LENGTH_SHORT).show();
                    }
                    dialog.dismiss();
                }
            }
        });
    }

    public void loadData() {
        list.clear();
        list = thongtinDao.getThongTinNguoiDungs();
        notifyDataSetChanged();
    }

}