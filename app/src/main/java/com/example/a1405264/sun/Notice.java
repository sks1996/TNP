package com.example.a1405264.sun;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


//use of recycler view



public class Notice extends Fragment {


    private ArrayList<Detail> detail=new ArrayList<>();
    FirebaseAuth firebaseAuth;
    private RecyclerView rclist;
    DatabaseReference mDatabase;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_fragment_one, container, false);

  //      mDatabase= FirebaseDatabase.getInstance().getReference().child("Notice");

    //    mBolglist=(RecyclerView)view.findViewById(R.id.blog_list);
//        mBolglist.hasFixedSize();
      //  mBolglist.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        firebaseAuth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference().child("Notification");
        mDatabase.keepSynced(true);
        rclist=(RecyclerView)view.findViewById(R.id.blog_list);
        rclist.hasFixedSize();
        rclist.setLayoutManager(new LinearLayoutManager(this.getActivity()));


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Log.v("Data",dataSnapshot.toString());

             /*   for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                    New_Project_Details nw= ds.getValue(New_Project_Details.class);
                    new_project_detailses.add(nw);
                }
                recyclerViewAdapter= new RecyclerViewAdapter(new_project_detailses,Home.Main);
                rclist.setAdapter(recyclerViewAdapter);*/

                Detail nw= dataSnapshot.getValue(Detail.class);
                detail.add(nw);
                recyclerViewAdapter= new RecyclerViewAdapter(detail,MainActivity.Main);
                rclist.setAdapter(recyclerViewAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return  view;
        }

    }
