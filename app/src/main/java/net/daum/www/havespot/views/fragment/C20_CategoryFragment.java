package net.daum.www.havespot.views.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.daum.www.havespot.R;
import net.daum.www.havespot.views.activity.C21_StoreListActivity;

public class C20_CategoryFragment extends Fragment implements View.OnClickListener{
    private final int[] CATEGORY_IMGS = { // 카테고리 이미지
            R.drawable.img_category1_best,
            R.drawable.img_category2_culture,
            R.drawable.img_category3_sport,
            R.drawable.img_category4_entertain
    };
    private final int[] BUTTONS_LAYOUT = {
            R.id.btn_category1,
            R.id.btn_category2,
            R.id.btn_category3,
            R.id.btn_category4
    };
    private final String[] CATEGORY_NAME = {"", "best", "culture", "sport", "entertainment"};
    private final int NUM_OF_BUTTONS = 4;
    private Button[] cateButtons = new Button[NUM_OF_BUTTONS];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.c20_fragment_category, container, false);

        for(int i = 0 ; i < NUM_OF_BUTTONS ; i++){
            cateButtons[i] = (Button) view.findViewById(BUTTONS_LAYOUT[i]);
            cateButtons[i].setBackgroundResource(CATEGORY_IMGS[i]);
            cateButtons[i].setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onClick(View view) {
        int i = 0;
        switch (view.getId()){
            case R.id.btn_category1:
                i = 1;
                break;
            case R.id.btn_category2:
                i = 2;
                break;
            case R.id.btn_category3:
                i = 3;
                break;
            case R.id.btn_category4:
                i = 4;
                break;
        }

        Intent intent = new Intent(view.getContext(), C21_StoreListActivity.class);
        intent.putExtra("category", "" + CATEGORY_NAME[i]);
        startActivity(intent);
    }
}
