package Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.nhom11_pro1121_md18309.R;
import com.google.android.material.textfield.TextInputEditText;

import DAO.TaiKhoanDAO;

public class PassWordChange extends AppCompatActivity {
    TextInputEditText edtOldPass, edtNewPass, edtReNewPass;
    Button btn_passchage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_word_change);

        btn_passchage = findViewById(R.id.btn_passchage);
        edtOldPass = findViewById(R.id.edtOldPass);
        edtNewPass = findViewById(R.id.edtNewPass);
        edtReNewPass = findViewById(R.id.edtReNewPass);


        btn_passchage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldPass = edtOldPass.getText().toString();
                String newPass = edtNewPass.getText().toString();
                String renewPass = edtReNewPass.getText().toString();
                if (oldPass.equals("") || newPass.equals("")|| renewPass.equals("")){
                    Toast.makeText(PassWordChange.this, "Nhập Đầy Đu Thông Tin Cần Thiết", Toast.LENGTH_SHORT).show();
                }else {
                    if (newPass.equals(renewPass)){
                        SharedPreferences sharedPreferences = getSharedPreferences("OKLuon",MODE_PRIVATE);
                        String Id = sharedPreferences.getString("Id","");
                        TaiKhoanDAO taikhoanDAO = new TaiKhoanDAO(PassWordChange.this);
                        int check = taikhoanDAO.capnhatMatKhau(Id,oldPass,newPass);
                        if (check ==1){
                            Toast.makeText(PassWordChange.this, "Cập Nhập Thành Công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(PassWordChange.this,Login.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }else if (check == 0){
                            Toast.makeText(PassWordChange.this, "Mật Khẩu Cũ Không Đúng", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(PassWordChange.this, "Cập Nhập Mật Khẩu Cũ Thất Bại", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(PassWordChange.this, "Mật Khẩu Không Trùng Khớp", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}