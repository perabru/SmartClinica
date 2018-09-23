package smcl.com.brunopera.smartclinica;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;





    // list of imagesk
    public int[] lst_images = {
            R.drawable.health256,
            R.drawable.exam256,
            R.drawable.medic256,
            R.drawable.care256
    };
    // list of titles
    public String[] lst_title = {
            "Lorem Ipsum",
            "Lorem Ipsum",
            "Lorem Ipsum",
            "Lorem Ipsum"
    }   ;
    // list of descriptions
    public String[] lst_description = {
            "Lorem ipsum dolor sit amet, ad quo etiam honestatis disputando, epicuri prodesset reprimique id ius. Te est debet nonumy. Id volutpat posidonium mea, eu pro pericula contentiones.",
            "Lorem ipsum dolor sit amet, ad quo etiam honestatis disputando, epicuri prodesset reprimique id ius. Te est debet nonumy. Id volutpat posidonium mea, eu pro pericula contentiones.",
            "Lorem ipsum dolor sit amet, ad quo etiam honestatis disputando, epicuri prodesset reprimique id ius. Te est debet nonumy. Id volutpat posidonium mea, eu pro pericula contentiones.",
            "Lorem ipsum dolor sit amet, ad quo etiam honestatis disputando, epicuri prodesset reprimique id ius. Te est debet nonumy. Id volutpat posidonium mea, eu pro pericula contentiones."
    };
    // list of background colors
    public int[]  lst_backgroundcolor = {
            Color.rgb(255,255,255),
            Color.rgb(255,255,255),
            Color.rgb(255,255,255),
            Color.rgb(255,255,255)
    };


    public SlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_title.length;

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = (ImageView)  view.findViewById(R.id.slideimg);
        TextView txttitle= (TextView) view.findViewById(R.id.txttitle);
        TextView description = (TextView) view.findViewById(R.id.txtdescription);
        layoutslide.setBackgroundColor(lst_backgroundcolor[position]);
        imgslide.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        description.setText(lst_description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
