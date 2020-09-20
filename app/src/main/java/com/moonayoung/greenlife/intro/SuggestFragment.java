package com.moonayoung.greenlife.intro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.moonayoung.greenlife.R;

public class SuggestFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_suggest, container, false);

        TextView textView = rootView.findViewById(R.id.makeAccountText);
        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) { // 계정 생성 터치이벤트 발생하면
                ((IntroActivity)getActivity()).setFinish(); //IntroActivity finish
                return true;
            }
        });
        return rootView;
    }
}
