package Tab_Fragment;

import android.os.Bundle;
import static com.example.nhom11_pro1121_md18309.MainActivity.account_all;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nhom11_pro1121_md18309.R;

import java.util.List;

import ADAPTER.OrderAdapter;
import ADAPTER.ViewPager2Adapter;
import DAO.DatHangDAO;
import Model.DatHang;


public class GiaoHangFrangment extends Fragment {

    View view;
    RecyclerView Order_list;
    List<DatHang> list;
    DatHangDAO datHangDAO;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_giao_hang_frangment, container, false);

        Order_list = view.findViewById(R.id.Order_list);
        datHangDAO = new DatHangDAO(getContext());

        getData();

        return view;
    }

    private void getData() {
        list = datHangDAO.getCartStatus(account_all.getId( ), 2,2);
        setList( );
    }

    private void setList() {
        OrderAdapter adapter = new OrderAdapter(list, getContext( ));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext( ));
        Order_list.setLayoutManager(linearLayoutManager);
        Order_list.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume( );
        getData( );
    }
}