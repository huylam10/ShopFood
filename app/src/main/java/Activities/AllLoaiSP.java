package Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.nhom11_pro1121_md18309.R;

import java.util.List;

import ADAPTER.SanPhamAdapter;
import DAO.SanPhamDAO;
import Model.LoaiSanPham;
import Model.SanPham;

public class AllLoaiSP extends AppCompatActivity {

    RecyclerView loaiSP_List;
    SanPhamDAO sanPhamDAO;
    List<SanPham>sanPhamList;
    Toolbar loaiSP_ToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_loai_sp);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        LoaiSanPham loaiSanPham = (LoaiSanPham) bundle.getSerializable("loaiSP");

        anhxa();

        setSupportActionBar(loaiSP_ToolBar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getData(loaiSanPham);
    }

    private  void getData(LoaiSanPham loaiSanPham){
        sanPhamList = sanPhamDAO.getListLoaiSP(loaiSanPham.getId());
        Log.e("ALL", "getData: " + sanPhamList.get(0));
        setList();
    }

    private void setList(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        loaiSP_List.setLayoutManager(gridLayoutManager);
        SanPhamAdapter adapter = new SanPhamAdapter(sanPhamList, getApplicationContext(), 1);
        loaiSP_List.setAdapter(adapter);
    }

    private void anhxa(){
        loaiSP_List = findViewById(R.id.loaiSP_List);
        loaiSP_ToolBar = findViewById(R.id.loaiSP_Toolbar);
        sanPhamDAO = new SanPhamDAO(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                onBackPressed();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}