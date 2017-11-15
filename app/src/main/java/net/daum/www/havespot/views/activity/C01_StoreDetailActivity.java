package net.daum.www.havespot.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.daum.www.havespot.R;
import net.daum.www.havespot.utils.StoreDAO;

public class C01_StoreDetailActivity extends AppCompatActivity implements View.OnClickListener{
    private StoreDAO store;
    private String store_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c01_activity_storedetail);

        Intent intent = new Intent(this.getIntent());
        store_name = intent.getStringExtra("store_name");

        ImageView storeImg = (ImageView)findViewById(R.id.img_store_detail);
        TextView storeName = (TextView)findViewById(R.id.text_store_name);
        TextView storeAddr = (TextView)findViewById(R.id.text_store_addr);
        TextView storeTime = (TextView)findViewById(R.id.text_store_time);
        TextView storeLike = (TextView)findViewById(R.id.text_store_like);
        TextView storeTell = (TextView)findViewById(R.id.text_store_phone);
        TextView storeIntro = (TextView)findViewById(R.id.text_store_intro);
        Button submitBtn = (Button)findViewById(R.id.btn_submit);

        submitBtn.setOnClickListener(this);

        /** 서버에서 storeDAO 받아오기 */
        /* 테스트 코드 */
        store = new StoreDAO(
                ContextCompat.getDrawable(this, R.drawable.img_store_detail_sample),
                "Strike 500",
                "수지구 죽전로 168번길 7",
                128,
                "5 PM ~ 2 AM",
                "031-265-0892",
                "Strike 500은 펍과 볼링장이 합쳐진 Fusion Pub 입니다."
        );

        storeImg.setImageDrawable(store.getStoreDetail());
        storeName.setText(store.getStoreName());
        storeAddr.setText(store.getStoreAddress());
        storeLike.setText("" + store.getStoreLike());
        storeTime.setText(store.getStoreTime());
        storeTell.setText(store.getStoreTell());
        storeIntro.setText(store.getStoreIntro());

    }

    @Override
    public void onClick(View view) {

    }
}
