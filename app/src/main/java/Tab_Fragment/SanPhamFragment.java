package Tab_Fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nhom11_pro1121_md18309.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ADAPTER.LoaiSanPhamSpinnerAdapter;
//import ADAPTER.ThemSanPhamAdapter;
import DAO.LoaiSanPhamDAO;
import DAO.SanPhamDAO;
import Model.LoaiSanPham;
import Model.SanPham;

public class SanPhamFragment extends Fragment {
    FloatingActionButton add_sp;
    RecyclerView list_sp;
//    ThemSanPhamAdapter phamAdapter;
    List<SanPham> list = new ArrayList<>();
    List<LoaiSanPham> list_loai_sp;
    SanPham sanPham;
    LoaiSanPhamDAO phamDAO;
    SanPhamDAO sanPhamDAO;
    LoaiSanPhamSpinnerAdapter spinnerAdapter;
    ActivityResultLauncher<Intent> activityResultLauncher;
    int position;
    String link;
    ImageView anh;
    int maLoaiSanPham;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_san_pham, container, false);
        add_sp = view.findViewById(R.id.add_sp);
        list_sp = view.findViewById(R.id.list_sp);
        sanPhamDAO = new SanPhamDAO(getContext());

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        list_sp.setLayoutManager(manager);
        list = sanPhamDAO.getDSSanPham();
//        phamAdapter = new ThemSanPhamAdapter(getContext(),list);
//        list_sp.setAdapter(phamAdapter);
        registerForContextMenu(list_sp);
        add_sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }

    public static Uri getImageUri(Context context, Bitmap bitmap){
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap,"IMG" + Calendar.getInstance().getTime(), null);
        return Uri.parse(path);
    }

    private void themSanPham() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_san_pham, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();
        LinearLayout them_anh = view.findViewById(R.id.them_anh);
        Spinner loai_sp = view.findViewById(R.id.spinner_loai_sp);
        EditText ten_sp = view.findViewById(R.id.edit_ten_sp);
        EditText gia_sp = view.findViewById(R.id.edit_gia_sp);
        Button them = view.findViewById(R.id.btn_add_sp);
        anh = view.findViewById(R.id.img_loai_sp);

        list_loai_sp = new ArrayList<>();
        phamDAO = new LoaiSanPhamDAO(getContext());

        them_anh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImage();
            }
        });
        list_loai_sp = phamDAO.getDSLoaiSanPham();
        spinnerAdapter = new LoaiSanPhamSpinnerAdapter(getContext(), list_loai_sp);
        loai_sp.setAdapter(spinnerAdapter);

        loai_sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                maLoaiSanPham = list_loai_sp.get(position).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sanPham = new SanPham();
                String name = ten_sp.getText().toString();
                String price = gia_sp.getText().toString();
                String image = anh.getResources().toString();
                sanPham.setLoaiSanPham(String.valueOf(maLoaiSanPham));
                sanPham.setNameSanPham(name);
                sanPham.setPriceSanPham(Integer.parseInt(price));
                sanPham.setImageSanPham(link);
                Calendar calendar = Calendar.getInstance();
                @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm dd/MM/yyyy");
                String text = simpleDateFormat.format(calendar.getTime());
                sanPham.setCreatedSanPham(text);
                sanPham.setUpdatedSanPham(text);
                if (sanPhamDAO.themSanPham(sanPham)) {
                    Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    list.clear();
                    list.addAll(sanPhamDAO.getDSSanPham());
//                    phamAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.option_sua_xoa, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 0:
                Toast.makeText(getContext(), "bạn đã xóa", Toast.LENGTH_SHORT).show();
                return true;
            case 1:
                Toast.makeText(getContext(), "bạn đã xóa", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void openImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            activityResultLauncher.launch(intent);
        } else {
            Toast.makeText(getContext(), "app ko ho tro action", Toast.LENGTH_SHORT).show();
        }
    }

}