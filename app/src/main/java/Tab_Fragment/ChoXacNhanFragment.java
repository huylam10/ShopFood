package Tab_Fragment;

import static com.example.nhom11_pro1121_md18309.MainActivity.account_all;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nhom11_pro1121_md18309.R;

import java.util.List;

import ADAPTER.OrderAdapter;
import DAO.DatHangDAO;
import Model.DatHang;


public class ChoXacNhanFragment extends Fragment {

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
        view = inflater.inflate(R.layout.fragment_cho_xac_nhan, container, false);

        Order_list = view.findViewById(R.id.Order_list);
        datHangDAO = new DatHangDAO(getContext());

        getData();

        return view;
    }

    private void getData() {
        Log.e("AccountID", "getData: "+account_all.getId() );
        list = datHangDAO.getCartStatus(account_all.getId(), 1,1);
        setList();
    }

    @Override
    public void onResume() {
        super.onResume( );
        getData();
    }

    private void setList() {
        OrderAdapter adapter = new OrderAdapter(list, getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        Order_list.setLayoutManager(linearLayoutManager);
        Order_list.setAdapter(adapter);
    }
}