package tamas.ecse321.ca.tamas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class apply_for_job extends AppCompatActivity {
    Button apply_to_job;
    EditText cv_field;
    TextView feedback;

    //ToDO:
    // these information will be dynamically retrieved from database in later release
    String cv;
    String id="32103910";
    String job_posting_id="23127301";
    String applicant_fname="Mark";
    String applicant_lname="Young";
    String applicant_email="mark.young@mail.mcgill.ca";
    String status="UGRAD";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_for_job);
        cv_field=(EditText)findViewById(R.id.cv_field);
        feedback=(TextView) findViewById(R.id.personal_information_textview);

        apply_to_job=(Button)findViewById((R.id.submit_application_button));
        apply_to_job.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                submitJobApplication(v);
            }
        });
    }
    public void submitJobApplication(View v){
        String urlForID = "http://www.jamesgtang.com/tamas/submitJobAppplicationService.php";
        RequestQueue queue = Volley.newRequestQueue(this);
        cv=cv_field.getText().toString();
    StringRequest stringRequest = new StringRequest(Request.Method.POST, urlForID, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            feedback.setText(response);
        }
    }, new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {
            // Error handling
            System.out.println("Something went wrong!");
            error.printStackTrace();
        }
    }
    ) {
        @Override
        protected Map<String, String> getParams() {
            Map<String, String> params = new HashMap<>();
            // the POST parameters:
            params.put("APPLICANT_ID",id);
            params.put("JOB_POSTING_ID",job_posting_id);
            params.put("APPLICANT_FNAME", applicant_fname);
            params.put("APPLICANT_LNAME", applicant_lname);
            params.put("APPLICANT_EMAIL",applicant_email);
            params.put("STATUS", status);
            params.put("CV",cv);
            return params;
        }
    };
    queue.add(stringRequest);
}}

