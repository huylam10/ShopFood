package Admin;

import static com.example.nhom11_pro1121_md18309.MainActivity.account_all;
import static com.example.nhom11_pro1121_md18309.MainActivity.check_login;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.nhom11_pro1121_md18309.R;
import com.example.nhom11_pro1121_md18309.databinding.ActivityAdminBinding;

import Model.TaiKhoan;

public class AdminActivity extends AppCompatActivity {

    ActivityAdminBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());


        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        if (bundle != null) {
            account_all = (TaiKhoan) bundle.getSerializable("tk");
            check_login = true;
        }

        if(account_all.getRole()==2){
            replaceFragment(new SeingAdminFragment());
            mainBinding.bottomNavigationView.getMenu()
                    .findItem(R.id.order1).setChecked(true);
            mainBinding.bottomNavigationView.getMenu()
                    .findItem(R.id.home1).setVisible(false);
            mainBinding.bottomNavigationView.getMenu()
                    .findItem(R.id.setting1).setVisible(false);
        }else {
            replaceFragment(new HomeAdminFragment());
        }

        Log.e("ZZZZZ", "onCreate: " + account_all);

        mainBinding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home1) {
                replaceFragment(new HomeAdminFragment());
            } else if (itemId == R.id.order1) {
                replaceFragment(new SeingAdminFragment());
            } else if (itemId == R.id.Statistical1) {
                replaceFragment(new ThongKeFragment());
            } else if (itemId == R.id.setting1) {
                replaceFragment(new ManagerAccountFragment());
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_right_to_left,
                        R.anim.enter_left_to_right, R.anim.exit_left_to_right);
        fragmentTransaction.replace(R.id.frameLayout_admin, fragment);
        fragmentTransaction.commit();
    }
}