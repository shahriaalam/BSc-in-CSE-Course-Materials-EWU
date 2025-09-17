package tamas.ecse321.ca.tamas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class view_job extends AppCompatActivity {

    Button refresh_data_button;
    Button select_job_button;
    ListView listview;
    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ArrayList<String> jobitems=new ArrayList<String>();
    int selected_job_post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_job);
        listview=(ListView)findViewById(R.id.list_of_job);
        String preRefreshItem[]=new String[]{"Hello","Please Refresh One or two times to See list of Jobs Available"};
        listItems=new ArrayList<String>();
        for(int i=0;i<preRefreshItem.length;i++){
            listItems.add(preRefreshItem[i]);
        }
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems);
        listview.setAdapter(adapter);
        refresh_data_button=(Button)findViewById(R.id.refresh_data_button);
        refresh_data_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ArrayAdapter<String> new_adapter=refresh_view();
                listview.setAdapter(new_adapter);
            }
        });
        select_job_button=(Button)findViewById(R.id.select_job_button);
        select_job_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_apply_for_job);
                Intent intent=new Intent(view_job.this,apply_for_job.class);
                startActivity(intent);
            }
        });

    }
    public ArrayAdapter<String> refresh_view(){
        getAllJobPosting();
        ArrayAdapter<String> new_adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,jobitems);
        return new_adapter;

    }
    public ArrayList<String> getAllJobPosting(){
        RequestQueue queue= Volley.newRequestQueue(this);
        String urlForID="http://www.jamesgtang.com/tamas/jobPostingService.php";
        JSONObject json;
        final ArrayList<HashMap<String,String>> joblistings;
        StringRequest stringRequest=new StringRequest(Request.Method.GET,urlForID,new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                try {
                    // use JSON Parser to tokenize data
                    JSONArray listing=new JSONArray(response);
                    for(int i=0;i<listing.length();i++){
                        JSONObject c=listing.getJSONObject(i);
                        String instructor_name=c.getString("INSTRUCTOR_NAME");
                        String course_name=c.getString("COURSE");
                        String post_id=c.getString("POST_ID");
                        String hour=c.getString("HOUR");
                        jobitems.add("Post ID: "+post_id+" Course: "+course_name+ " Hour: "+hour
                                +" Instructor Name: "+instructor_name);

                        HashMap<String, String> map=new HashMap<String,String>();
                        map.put("INSTRUCTOR_NAME",instructor_name);
                        map.put("COURSE_NAME",course_name);
                        map.put("POST_ID",post_id);
                        map.put("HOUR",hour);

                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
                // handle response here
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // Error handling
                System.out.println("Something went wrong!");
                error.printStackTrace();
            }
        });
        queue.add(stringRequest);
        return jobitems;

    }
}
