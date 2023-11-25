package Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.nhom11_pro1121_md18309.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import DAO.TaiKhoanDAO;

public class Sign_Up extends AppCompatActivity {

    TextInputEditText SU_edt_UserName, SU_edt_PassWord, SU_edt_RePassWord;
    TextInputLayout SU_til_UserName, SU_til_PassWord, SU_til_RePassWord;

    TaiKhoanDAO taiKhoanDAO;
    Toolbar toolbar;
    TextView txt_toLogin;
    AppCompatButton appCompatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        setSupportActionBar(toolbar);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(null);

        txt_toLogin.setOnClickListener(v -> {

        });

        appCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = SU_edt_UserName.getText().toString();
                String password = SU_edt_PassWord.getText().toString();
                String repass = SU_edt_RePassWord.getText().toString();

            }
        });
    }

    private void DangKy(String username, String password, String repass){
        SU_til_UserName.setErrorEnabled(false);
        SU_til_PassWord.setErrorEnabled(false);
        SU_til_RePassWord.setErrorEnabled(false);
        if(username.isEmpty()){
            SU_til_UserName.setError("Không  được để trống username");
            return;
        }
    }
}