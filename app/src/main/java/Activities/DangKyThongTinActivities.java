package Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.nhom11_pro1121_md18309.R;

import DAO.TaiKhoanDAO;
import DAO.ThongTinNguoiDungDAO;
import Model.TaiKhoan;

public class DangKyThongTinActivities extends AppCompatActivity {

    ThongTinNguoiDungDAO nguoiDungDAO;
    Button hoantat;
    ImageView avatar;
    EditText sdt, email, dia_chi, name, ngay_sinh;
    RadioButton GT_nam, GT_nu;
    String userDK, passDK;
    TaiKhoanDAO taiKhoanDAO;
    TaiKhoan taiKhoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dang_ky_thong_tin_activities);
        Intent intent = new Intent();
        userDK = intent.getStringExtra("user");
        passDK = intent.getStringExtra("pass");

        hoantat = findViewById(R.id.btnDangkythongtin);
        sdt = findViewById(R.id.edtSdt);
        email = findViewById(R.id.edtEmail);
        dia_chi = findViewById(R.id.edtDiachi);
        name = findViewById(R.id.edtHoten);
        ngay_sinh = findViewById(R.id.edtNgaysinh);
        GT_nam = findViewById(R.id.rdo_GT_Nam);
        GT_nu = findViewById(R.id.rdo_BTN_Nu);
        avatar = findViewById(R.id.edtAvatar);
        nguoiDungDAO = new ThongTinNguoiDungDAO(this);
        taiKhoanDAO = new TaiKhoanDAO(this);
        if (taiKhoanDAO.getName(userDK).getPassword().equals(passDK)){
            taiKhoan = taiKhoanDAO.getName(userDK);
        }
        hoantat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = name.getText().toString();
                String phone = sdt.getText().toString();
                String mail = email.getText().toString();
                String address = dia_chi.getText().toString();
                String ngay = ngay_sinh.getText().toString();
                String anh = avatar.getResources().toString();
            }
        });
    }
}