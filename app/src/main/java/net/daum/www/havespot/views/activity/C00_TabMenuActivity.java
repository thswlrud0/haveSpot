package net.daum.www.havespot.views.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.daum.www.havespot.R;
import net.daum.www.havespot.views.fragment.C10_MapFragment;
import net.daum.www.havespot.views.fragment.C20_CategoryFragment;
import net.daum.www.havespot.views.fragment.C30_FavoriteFragment;
import net.daum.www.havespot.views.fragment.C40_ProfileFragment;

public class C00_TabMenuActivity extends AppCompatActivity implements View.OnClickListener{
    private final int[] BUTTONS_LAYOUT = { // 탭 버튼 레이아웃
            R.id.btn_tab1,
            R.id.btn_tab2,
            R.id.btn_tab3,
            R.id.btn_tab4
    };
    private final int[] BUTTONS_IMG = { // 탭 버튼 이미지 url
            // png 파일 받으면 추가
    };
    private final int NUM_OF_BUTTONS = 4; // 탭 버튼 개수
    private Button[] tabButtons = new Button[NUM_OF_BUTTONS]; // 탭 버튼 배열
    private int current_tab; // 현재 탭
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c00_activity_tabmenu);

        for(int i = 0 ; i < NUM_OF_BUTTONS ; i++){
            tabButtons[i] = (Button) findViewById(BUTTONS_LAYOUT[i]);
            tabButtons[i].setOnClickListener(this);
        }

        callFragment(1);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_tab1:
                callFragment(1);
                break;
            case R.id.btn_tab2:
                callFragment(2);
                break;
            case R.id.btn_tab3:
                callFragment(3);
                break;
            case R.id.btn_tab4:
                callFragment(4);
                break;
        }
    }

    private void callFragment(int tab){
        transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = null;

        if(current_tab != tab) { // 현재 탭과 다른 탭이 눌렸을 때만 로직 실행
            switch (tab){
                case 1:
                    fragment = new C10_MapFragment();
                    break;
                case 2:
                    fragment = new C20_CategoryFragment();
                    break;
                case 3:
                    fragment = new C30_FavoriteFragment();
                    break;
                case 4:
                    fragment = new C40_ProfileFragment();
                    break;
            }
            setAnimation(transaction, tab - current_tab); // 에니메이션 효과 적용
            transaction.replace(R.id.fragment_container, fragment); // fragment 화면 교체
            transaction.commit(); // 변경사항 적용

            current_tab = tab;
        }
    }

    private void setAnimation(FragmentTransaction transaction, int i){
        if(i < 0){ // 현재 탭보다 왼쪽에 있는 버튼 클릭했을 때
            transaction.setCustomAnimations(R.anim.anim_left_in, R.anim.anim_left_out);
        }else{ // 현재 탭보다 오른쪽에 있는 버튼 클릭했을 때
            transaction.setCustomAnimations(R.anim.anim_right_in, R.anim.anim_right_out);
        }
    }
}
