package net.daum.www.havespot.views.login_test;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.daum.www.havespot.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by thswl on 2017-11-14.
 */

public class Sign_up extends AppCompatActivity{
    EditText one, two, three, four, five;

    Button submit;
    Button nop;

    loadJsp task;


    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, Sign_up.class);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        one = (EditText) findViewById(R.id.user_id);
        two = (EditText) findViewById(R.id.pw);
        three = (EditText) findViewById(R.id.user_name);
        four = (EditText) findViewById(R.id.phone);


        submit = (Button) findViewById(R.id.Button2);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userInfo test = new userInfo();
                test.setOne(one.getText().toString());
                test.setTwo(two.getText().toString());
                test.setThree(three.getText().toString());
                test.setFour(four.getText().toString());

                task = new loadJsp(test);
                task.execute();
            }
        });
        nop = (Button) findViewById(R.id.nop);
        nop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //취소 버튼
            }
        });
    }


    class loadJsp extends AsyncTask<Void, String, Void> {

        String one;
        String two;
        String three;
        String four;

        loadJsp(userInfo userInfo){
            this.one = userInfo.getOne();
            this.two = userInfo.getTwo();
            this.three = userInfo.getThree();
            this.four = userInfo.getFour();

        }

        @Override
        protected Void doInBackground(Void... param) {

            try {
                HttpClient client = new DefaultHttpClient();

                String postURL = "http://10.0.2.2:9012/android_test/android_test.jsp";

                HttpPost post = new HttpPost(postURL);
                ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();

                params.add(new BasicNameValuePair("one", one));
                params.add(new BasicNameValuePair("two", two));
                params.add(new BasicNameValuePair("three", three));
                params.add(new BasicNameValuePair("four", four));
                // params.add(new BasicNameValuePair("five", five));

                UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
                post.setEntity(ent);

                HttpResponse responsePOST = client.execute(post);
                HttpEntity resEntity = responsePOST.getEntity();
                if (resEntity != null) {
                    Log.i("RESPONSE0", EntityUtils.toString(resEntity));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;

        }

    }
}
