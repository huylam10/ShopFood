package Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.nhom11_pro1121_md18309.R;

import java.text.SimpleDateFormat;

import DAO.TaiKhoanDAO;
import DAO.ThongTinNguoiDungDAO;
import Model.TaiKhoan;
import Model.ThongTinNguoiDung;

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

        hoantat = findViewById(R.id.btnDangkythongtin);
        sdt = findViewById(R.id.edtSdt);
        email = findViewById(R.id.edtEmail);
        dia_chi = findViewById(R.id.edtDiachi);
        name = findViewById(R.id.edtHoten);
        ngay_sinh = findViewById(R.id.edtNgaysinh);
        GT_nam = findViewById(R.id.rdo_GT_Nam);
        GT_nu = findViewById(R.id.rdo_BTN_Nu);
        avatar = findViewById(R.id.edtAvatar);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        userDK = bundle.getString("user");
        passDK = bundle.getString("pass");
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

                ThongTinNguoiDung nguoiDung = new ThongTinNguoiDung();
                nguoiDung.setEmailNguoiDung(mail);
                nguoiDung.setAvatarNguoiDung(anh);
                nguoiDung.setBirthdayNguoiDung(ngay);
                nguoiDung.setFullName(ten);
                nguoiDung.setSDTNguoiDung(phone);
                nguoiDung.setAdressNguoiDung(address);

                if (GT_nu.isChecked()){
                    nguoiDung.setGender(0);
                } else if (GT_nam.isChecked()) {
                    nguoiDung.setGender(1);
                }
                Calendar calendar = Calendar.getInstance();
                @SuppressLint("SimpleDateFormat")SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
                String text = simpleDateFormat.format(calendar.getTime());
                nguoiDung.setCreatedNguoiDung(text);
                nguoiDung.setAvatarNguoiDung(anh);
                nguoiDung.setUpdatedNguoiDung(text);
                nguoiDung.setIdTaiKhoan(taiKhoan.getId());
                if (nguoiDungDAO.themThongTinNguoiDung(nguoiDung)){
                    Toast.makeText(DangKyThongTinActivities.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(getApplicationContext(), Login.class));
                } else {
                    Toast.makeText(DangKyThongTinActivities.this, "Them thong tin that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}