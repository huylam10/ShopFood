package Activities;

import static com.example.nhom11_pro1121_md18309.MainActivity.cart_all;
import static com.example.nhom11_pro1121_md18309.MainActivity.check_login;
import static com.example.nhom11_pro1121_md18309.MainActivity.account_all;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nhom11_pro1121_md18309.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import ADAPTER.SanPhamAdapter;
import DAO.ChiTietDatHangDAO;
import DAO.SanPhamDAO;
import Model.ChiTietDatHang;
import Model.SanPham;

public class SanPhamDetail extends AppCompatActivity {
    Toolbar SPDetail_toolbar;
    ImageView SPDetail_Img;
    TextView SPDetail_Ten, SPDetail_Gia, SpDetail_Created, SPDetail_Status,sizeCart;
    ImageButton SPDetail_Buy;
    ChiTietDatHangDAO dao;
    RecyclerView SPDetail_List_Tuong_Tu, SPDetail_List_Goi_Y;
    List<SanPham> sanPhamListTT, sanPhamListGY;
    SanPhamDAO sanPhamDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham_detail);

        anhXa();

        setSupportActionBar(SPDetail_toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        SanPham sanPham = (SanPham) bundle.getSerializable("sp");
        setData(sanPham);
        setList(sanPham);

        Log.e("ZZZZZ", "onCreate: " + sanPham);

        SPDetail_Buy.setOnClickListener(v -> {
            if (check_login) {
                addToCart(sanPham);
            } else {
                Toast.makeText(this, "Bạn cần đăng nhập để sử dụng chức năng", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setList(SanPham sanPham) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        getDataList(sanPham);
        SPDetail_List_Tuong_Tu.setLayoutManager(linearLayoutManager);
        SanPhamAdapter adapterTT = new SanPhamAdapter(sanPhamListTT, getApplicationContext(),1);

        SPDetail_List_Tuong_Tu.setAdapter(adapterTT);
    }

    private void getDataList(SanPham sanPham) {
        sanPhamListTT = sanPhamDAO.getSpTT(Integer.parseInt(sanPham.getLoaiSanPham()), sanPham.getId());
    }


    private ChiTietDatHang CheckCart(SanPham sanPham) {
        List<ChiTietDatHang> list = new ArrayList<>();
        list = dao.checkCart(cart_all.getId(), sanPham.getId());
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private void addToCart(SanPham sanPham) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.dialog_add_to_cart, null);
        builder.setView(view);

        AlertDialog dialog;
        ImageButton dialog_atc_remove, dialog_atc_add;
        EditText dialog_atc_amount;
        Button dialog_atc_cancle, dialog_atc_ok;

        dialog_atc_amount = view.findViewById(R.id.dialog_atc_amount);
        dialog_atc_remove = view.findViewById(R.id.dialog_atc_remove);
        dialog_atc_add = view.findViewById(R.id.dialog_atc_add);
        dialog_atc_cancle = view.findViewById(R.id.dialog_atc_cancle);
        dialog_atc_ok = view.findViewById(R.id.dialog_atc_ok);

        dialog = builder.create();

        dialog_atc_add.setOnClickListener(v -> {
            dialog_atc_amount.setText(String.valueOf(Integer.parseInt(dialog_atc_amount.getText().toString()) + 1));
        });

        dialog_atc_remove.setOnClickListener(v -> {
            if (dialog_atc_amount.getText().toString().equals("1")) {
                Toast.makeText(this, "Số lượng phải lớn hơn hoặc bằng 1", Toast.LENGTH_SHORT).show();
                return;
            }
            dialog_atc_amount.setText(String.valueOf(Integer.parseInt(dialog_atc_amount.getText().toString()) - 1));
        });

        ChiTietDatHang checkCart = CheckCart(sanPham);

        dialog_atc_ok.setOnClickListener(v -> {
            if (checkCart == null) {
                ChiTietDatHang chiTietDatHang = new ChiTietDatHang();
                chiTietDatHang.setAmount(Integer.parseInt(dialog_atc_amount.getText().toString()));
                chiTietDatHang.setProductid(sanPham.getId());
                chiTietDatHang.setUnitprice(sanPham.getPriceSanPham());
                chiTietDatHang.setIdDatHang(cart_all.getId());
                dao.ThemChiTietDatHang(chiTietDatHang);
                Toast.makeText(this, "Đã đặt thành công", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            } else {
                checkCart.setAmount(checkCart.getAmount() + Integer.parseInt(dialog_atc_amount.getText().toString()));
                dao.CapNhapChiTietDatHang(checkCart);
                Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
            setCartSize();
        });

        dialog_atc_cancle.setOnClickListener(v -> {
            dialog.dismiss();
        });


        dialog.show();
    }

    private void setData(SanPham sanPham) {
        try{
            SPDetail_Img.setImageResource(Integer.parseInt(sanPham.getImageSanPham()));
        }catch (Exception e){
            Uri uri = Uri.parse(sanPham.getImageSanPham());
            SPDetail_Img.setImageURI(uri);
        }

        SPDetail_Ten.setText(sanPham.getNameSanPham());
//        SPDetail_Gia.setText(sanPham.getPriceSanpham() + " VND");
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        SPDetail_Gia.setText(decimalFormat.format(sanPham.getPriceSanPham()) + " đ");
        SpDetail_Created.setText(sanPham.getCreatedSanPham());
        if (sanPham.getStatusSanPham() == 1) {
            SPDetail_Status.setTextColor(Color.GREEN);
            SPDetail_Status.setText("Còn hàng");
        } else {
            SPDetail_Status.setTextColor(Color.RED);
            SPDetail_Status.setText("Hết hàng");
        }
    }

    private void setCartSize(){
        sizeCart.setText(String.valueOf(dao.getSum(cart_all.getId( ))));
    }

    private void anhXa() {
        SPDetail_toolbar = findViewById(R.id.SPDetail_toolbar);
        SPDetail_Img = findViewById(R.id.SPDetail_Img);
        SPDetail_Ten = findViewById(R.id.SPDetail_Ten);
        SPDetail_Gia = findViewById(R.id.SPDetail_Gia);
        SpDetail_Created = findViewById(R.id.SpDetail_Created);
        SPDetail_Status = findViewById(R.id.SPDetail_Status);
        SPDetail_Buy = findViewById(R.id.SPDetail_Buy);
        SPDetail_List_Tuong_Tu = findViewById(R.id.SPDetail_List_Tuong_Tu);
        SPDetail_List_Goi_Y = findViewById(R.id.SPDetail_List_Goi_Y);
        dao = new ChiTietDatHangDAO(getApplicationContext());
        sanPhamDAO = new SanPhamDAO(getApplicationContext());
        IntentFilter intentFilter = new IntentFilter("CheckSizeCart");
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver,intentFilter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == android.R.id.home) {
            onBackPressed();
        } else if (itemId == R.id.badge_cart) {
            startActivity(new Intent(SanPhamDetail.this, BadgeCart.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.badge_cart_menu,menu);

        MenuItem menuItem = menu.findItem(R.id.badge_cart);
        if (account_all.getRole()!=3){
            menuItem.setVisible(false);
        }
        View actionMenu = menuItem.getActionView();
        sizeCart = actionMenu.findViewById(R.id.number_size_cart);

        setCartSize();

        actionMenu.setOnClickListener(v -> {
            onOptionsItemSelected(menuItem);
        });

        return super.onCreateOptionsMenu(menu);
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver( ) {
        @Override
        public void onReceive(Context context, Intent intent) {
            setCartSize();
        }
    };

    @Override
    protected void onResume() {
        super.onResume( );
        if (sizeCart!=null){
            setCartSize();
        }
    }
}