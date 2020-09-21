package com.moonayoung.greenlife.challenge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moonayoung.greenlife.intro.IntroActivity;
import com.moonayoung.greenlife.intro.LoadingActivity;
import com.moonayoung.greenlife.R;

public class MainActivity extends AppCompatActivity {

        RecyclerView challengeListView;
        ChallengeAdapter adapter;
        FragmentManager fragmentManager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            challengeListView = findViewById(R.id.challengListView); // 챌린지 목록 보여줄 리싸이클러뷰

            fragmentManager = getSupportFragmentManager();

            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false); //linearlayout으로 리싸이클러뷰 설정
            challengeListView.setLayoutManager(layoutManager);

            Intent intent = new Intent(this, LoadingActivity.class);
            startActivityForResult(intent, 101);

            ChallengeList challengeList = new ChallengeList();
            adapter = new ChallengeAdapter();
            adapter.setItems(challengeList.getChallengeLists()); // 데이터 저장되어 있음 Title, content, 세부 챌린지 배열
            challengeListView.setAdapter(adapter); // 어댑터에 설정 -> 리싸이클러뷰에 챌린지 목록 보임

            adapter.setOnItemClickListener(new onChallengeListClickListener() {
                @Override
                public void onItemClick(ChallengeAdapter.ViewHolder holder, View view, int position) { // 챌린지 목록 각각 눌렀을 때
                    ChallengeList item = adapter.getItem(position);
                    position ++;
                    //Toast.makeText(getApplicationContext(), position + "번째 목록 선택됨",Toast.LENGTH_LONG).show();

                    switch (position){
                        case 1: // 첫번째 click
                            fragmentManager.beginTransaction().replace(R.id.mainContainer,new ChallengeFragment1()).commit(); //1번째 챌린지 프래그먼트 띄움
                            break;
                        case 2:
                            fragmentManager.beginTransaction().replace(R.id.mainContainer,new ChallengeFragment2()).commit();
                            break;
                        case 3:
                            fragmentManager.beginTransaction().replace(R.id.mainContainer,new ChallengeFragment3()).commit();
                            break;
                        case 4:
                            fragmentManager.beginTransaction().replace(R.id.mainContainer,new ChallengeFragment4()).commit();
                            break;
                        case 5:
                            fragmentManager.beginTransaction().replace(R.id.mainContainer,new ChallengeFragment5()).commit();
                            break;
                    }

                }
            });

    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
                super.onActivityResult(requestCode, resultCode, data);

                if(requestCode == 101){ // 로딩액티비티 끝나고 올 때, IntroActivity 시작시키기
                        Intent intent2 = new Intent(this, IntroActivity.class);
                        startActivity(intent2);
                }
        }
}