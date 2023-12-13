package ADAPTER;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.nhom11_pro1121_md18309.R;

import java.util.List;

import Model.Photo;

public class PhotoAdapter extends PagerAdapter {

    Context context;
    List<Photo> listPhoto;

    public PhotoAdapter(Context context, List<Photo> listPhoto) {
        this.context = context;
        this.listPhoto = listPhoto;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_image, container,false);
        ImageView anh = view.findViewById(R.id.image_banner);
        Photo photo = listPhoto.get(position);
        if (photo!=null){
            Glide.with(context).load(photo.getImage()).into(anh);
        }
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return listPhoto.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
