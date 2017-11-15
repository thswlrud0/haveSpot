package net.daum.www.havespot.utils;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.daum.www.havespot.R;
import net.daum.www.havespot.views.activity.C01_StoreDetailActivity;

import java.util.ArrayList;

/**
 * Created by LYS on 2017-11-12.
 */

public class StoreListAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<StoreDAO> store_items = new ArrayList<>();
    LayoutInflater inflater;

    public StoreListAdapter(Context context, int layout, ArrayList<StoreDAO> store_items) {
        this.context = context;
        this.layout = layout;
        this.store_items = store_items;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return store_items.size();
    }

    @Override
    public Object getItem(int i) {
        return store_items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = inflater.inflate(layout, null);
        }

        ImageView img_store = (ImageView)view.findViewById(R.id.img_store);
        TextView txt_name = (TextView)view.findViewById(R.id.text_store_name);
        TextView txt_address = (TextView)view.findViewById(R.id.text_address);
        TextView txt_like = (TextView)view.findViewById(R.id.text_like);
        Button btn_next = (Button)view.findViewById(R.id.btn_next);

        StoreDAO item = store_items.get(i);

        img_store.setImageDrawable(item.getStoreImg());
        txt_name.setText(item.getStoreName());
        txt_address.setText(item.getStoreAddress());
        txt_like.setText(""+item.getStoreLike());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), C01_StoreDetailActivity.class);
                intent.putExtra("store_dao", store_items.get(i).getStoreName());
                view.getContext().startActivity(intent);
//                Toast.makeText(context, store_items.get(i).getStoreName(), Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
