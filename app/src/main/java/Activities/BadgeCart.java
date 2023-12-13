package Activities;

import static com.example.nhom11_pro1121_md18309.MainActivity.cart_all;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nhom11_pro1121_md18309.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import ADAPTER.CartAdapter;
import DAO.ChiTietDatHangDAO;
import DAO.DatHangDAO;
import Model.ChiTietDatHang;
import Service.CheckCartService;

public class BadgeCart extends AppCompatActivity {

    RecyclerView Cart_list;
    TextView Cart_TotalPrice;
    ChiTietDatHangDAO chiTietDatHangDAO;
    DatHangDAO datHangDAO;
    List<ChiTietDatHang> chiTietDatHangList;
    Button Cart_Dat_Hang;
    int totalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badge_cart);

        anhXa();

        getData();

        Cart_Dat_Hang.setOnClickListener(v -> {
            MuaHang();
        });

    }

    private void MuaHang() {
        if (!chiTietDatHangList.isEmpty()) {
            cart_all.setTotalpriceDatHang(totalPrice);
            cart_all.setStatusDatHang(1);
            datHangDAO.UpgradeDH(cart_all);

            startService(new Intent( this,CheckCartService.class ));
            finish();
            Toast.makeText(this, "Mua hàng thành công", Toast.LENGTH_SHORT).show();

        }
    }


    private int loadMoney() {
        int sum = 0;
        for (ChiTietDatHang x : chiTietDatHangList) {
            sum += x.getUnitprice()*x.getAmount();
        }

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");

        Cart_TotalPrice.setText("Tổng thanh toán : " + decimalFormat.format(sum) + "đ");
        return sum;
    }

    private void setAdapterToRCL() {
        CartAdapter cartAdapter = new CartAdapter(chiTietDatHangList, getApplicationContext(),chiTietDatHangDAO,1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        Cart_list.setLayoutManager(linearLayoutManager);
        Cart_list.setAdapter(cartAdapter);
    }

    private void getData() {
        chiTietDatHangList = chiTietDatHangDAO.getListCT(cart_all.getId());
        if (chiTietDatHangList.isEmpty()) {
            Cart_TotalPrice.setText("Bạn chưa có gì trong giỏ hàng");
            setAdapterToRCL();
            return;
        }
        totalPrice = loadMoney();
        setAdapterToRCL();
    }

    private void anhXa() {
        Cart_list = findViewById(R.id.Cart_list);
        Cart_TotalPrice = findViewById(R.id.Cart_TotalPrice);
        Cart_Dat_Hang = findViewById(R.id.Cart_Dat_Hang);
        chiTietDatHangList = new ArrayList<>();
        chiTietDatHangDAO = new ChiTietDatHangDAO(getApplicationContext());
        datHangDAO = new DatHangDAO(getApplicationContext());
        IntentFilter intentFilter = new IntentFilter("checkCart");
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(broadcastReceiver, intentFilter);
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int type = intent.getIntExtra("type",0);
            switch (type){
                case 1:{
                    chiTietDatHangList = chiTietDatHangDAO.getListCT(cart_all.getId());
                    totalPrice = loadMoney();
                    break;
                }
                default:
                    getData();
            }
        }
    };
}