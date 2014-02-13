package net.saltfactory.tutorial.kakaodemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.kakao.*;

public class MyActivity extends Activity {

    private final String TAG = "saltfactory.net";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final MyActivity self = MyActivity.this;

        setContentView(R.layout.main);

        // 카카오링크 테스트 버튼
        Button buttonLink = (Button) findViewById(R.id.sf_button_kakao_link);
        buttonLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(self, SFKakaoLinkActivity.class);
                startActivity(intent);
            }
        });

        // 카카오스토리 프로파일 테스트 버튼
        Button buttonProfile = (Button) findViewById(R.id.sf_button_kakaostory_profile);
        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(self, SFKakaoStoryProfileActivity.class);
                startActivity(intent);
            }
        });

        // 카카오스토리 포스팅 테스트 버튼
        Button buttonPost = (Button) findViewById(R.id.sf_button_kakaostory_post);
        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(self, SFKakaoStoryPostActivity.class);
                startActivity(intent);
            }
        });

        // 카카오 SDK 로그아웃 버튼
        Button buttonLogout = (Button) findViewById(R.id.sf_button_kakao_logout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserManagement.requestLogout(new LogoutResponseCallback() {
                    @Override
                    protected void onSuccess(long userId) {
                        final Intent intent = new Intent(self, SFKakaoLoginActivity.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    protected void onFailure(APIErrorResult errorResult) {
                        Log.e(TAG, errorResult.toString());
                    }
                });
            }
        });


    }
}
