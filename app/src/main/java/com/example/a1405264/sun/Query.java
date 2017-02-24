package com.example.a1405264.sun;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;


/**
 * A simple {@link Fragment} subclass.
 */
public class Query extends Fragment {

    Button b1;
    EditText roll , text ,sub;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_query, container, false);

        b1=(Button)view.findViewById(R.id.button2);
        roll=(EditText)view.findViewById(R.id.editext);
        text=(EditText)view.findViewById(R.id.editext2);
        sub=(EditText)view.findViewById(R.id.editext3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String s1=roll.getText().toString().trim();
//              s1=s1.concat("@kiit.ac.in").trim();
                String s2=text.getText().toString();
                StringBuilder sb = new StringBuilder();
                sb.append(s2+"\n"+"\n"+"Regards"+"\n"+s1);
                String s3="getsuraj96@gmail.com";
                String subject=sub.getText().toString().trim();


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ s3});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, (Serializable) sb);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });


        return view;
    }

}
