package net.daum.www.havespot.views.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.daum.www.havespot.R;

/** 첫 번째 탭 화면
 *  구글 지도 API 받아오기 */
public class C10_MapFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.c10_fragment_map, container, false);
    }

}
