package com.mgstarlites.jobkaro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import org.w3c.dom.Text;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;

    int images[] = {
      R.drawable.v1,
      R.drawable.v2,
      R.drawable.v3,
      R.drawable.v4
    };

    int heading[] = {
      R.string.heading_one,
      R.string.heading_two,
      R.string.heading_three,
      R.string.heading_fourth
    };

    int Description[] = {
            R.string.desc_one,
            R.string.desc_fourth,
            R.string.desc_three,
            R.string.desc_two
    };

    public ViewPagerAdapter(Context context){
        this.context=context;
    }


    @Override
    public int getCount() {
        return heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout,container,false);

        ImageView slidetitleimage = (ImageView) view.findViewById(R.id.titleImage);
        TextView slideheading = (TextView) view.findViewById(R.id.texttitle);
        TextView slidedescription = (TextView) view.findViewById(R.id.textdeccription);

        slidetitleimage.setImageResource(images[position]);
        slideheading.setText(heading[position]);
        slidedescription.setText(Description[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}

