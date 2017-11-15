package net.daum.www.havespot.views.login_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String a;
    String b;
    String [] getJson = new String[10];
    String [] getJson2 = new String[10];

    TextView set;
    Button c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        set = (TextView)findViewById(R.id.data);
        c = (Button)findViewById(R.id.button);


        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(){
                    public void run(){
                        http_test();
                    }
                }.start();

            }
        });




    }

    public void http_test(){
        HttpClient client = new DefaultHttpClient();
        String return_;

        try {
            final String URL = "http://10.0.2.2:9012/android_test/jsp_send.jsp"; // 주소
           // String simpleData = "?json=OK&hey=CanDoThis&really=haaa"; // 보낼 데이터

        //    return_ = URL + simpleData;
            HttpPost post = new HttpPost(URL);  // 주소 뒤에 데이터를 넣기

            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();

            params.add(new BasicNameValuePair("hey", "one"));
            params.add(new BasicNameValuePair("really", "two"));

            // params.add(new BasicNameValuePair("five", five));

            UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
            post.setEntity(ent);

            HttpResponse responsePOST = client.execute(post);
            HttpEntity resEntity = responsePOST.getEntity();
            if (resEntity != null) {
                Log.i("RESPONSE0", EntityUtils.toString(resEntity));
            }


            HttpResponse response = client.execute(post); // 보낸 뒤, 리턴 되는 결과값을 받음
	/* 위에 까진 안드로이드에서 보내기, 밑에서 부터는 서버에서 보낸 데이터 받기 */
            BufferedReader bufreader = new BufferedReader(
                    new InputStreamReader(
                            response.getEntity().getContent(), "utf-8"));

            String line = null;
            String page = "";

            // 버퍼의 웹문서 소스를 줄 단위로 읽어(line), page에 저장함
            while ((line = bufreader.readLine()) != null) {
                page += line;
            }

            // 읽어들인 내용을 json 객체에 담아 그 중 dataSend로 정의 된 내용을
            // 불어온다. 그럼 json 중 원하는 내용을 하나의 json 배열에 담게 된다.
            JSONObject json = new JSONObject(page);
            JSONArray jArr = json.getJSONArray("dataSend");

            int a_idx = 0;
            // JSON이 가진 크기만큼 데이터를 받아옴
            for (int i = 0; i < jArr.length(); i++) {
                //JSONObject returnS = (JSONObject) jArr.get(i);
                json = jArr.getJSONObject(i);


                getJson[i] = json.getString("hey");
                getJson2[i]= json.getString("really");
                //getJson[1] = json.getString("really");

            }
	/* 여기까지 서버가 보낸 데이터를 받아 왔다. 밑에는 확인을 위한 수행 */
	String data = "";

            if(getJson[0] =="user3") {
                data = getJson[0];
            }

            set.setText(data);

        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
