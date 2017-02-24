package com.example.a1405264.sun;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Founder_Message extends Fragment
{

    ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.founders_message, container, false);
        imageView=(ImageView)view.findViewById(R.id.image123);
      //  Picasso.with(this.getActivity()).load("gs://suntnp-57d55.appspot.com").into(imageView);
        return  view;
    }

}
