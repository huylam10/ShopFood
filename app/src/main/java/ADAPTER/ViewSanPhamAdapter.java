package ADAPTER;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import Tab_Fragment.LoaiSanPhamFragment;
import Tab_Fragment.SanPhamFragment;

public class ViewSanPhamAdapter extends FragmentStateAdapter {
    public ViewSanPhamAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:{
                return new LoaiSanPhamFragment();
            }
            case 1:{
                return new SanPhamFragment();
            }
        }
        return new LoaiSanPhamFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
