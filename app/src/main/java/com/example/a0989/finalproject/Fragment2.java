package com.example.a0989.finalproject;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {


    public Fragment2() {
        // Required empty public constructor
    }

    private View view;
    private int i =0;
    String[] part = new String[]{"全\t身", "胸\t部", "背\t部", "腹\t部", "腿\t部"};


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragment2, container, false);

        final ArrayAdapter messageAdapter2 = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, part);


        ListView listView = (ListView) view.findViewById(R.id.listview2);
        listView.setAdapter(messageAdapter2);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        LayoutInflater inflater = LayoutInflater.from(getContext());
                        final View a = inflater.inflate(R.layout.movebody, null);
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());

                        alertDialogBuilder.setView(a);
                        alertDialogBuilder.setTitle("全身健身指南");
                        alertDialogBuilder.setPositiveButton("開始計時", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Fragment2.this.getContext(), MyService.class);
                                getContext().startService(intent);
                                i=0;
                                handler.postDelayed(runnable, 3000);


                            }
                        });
                        alertDialogBuilder.show();
                        break;
                    case 1:
                        LayoutInflater inflater1 = LayoutInflater.from(getContext());
                        final View b = inflater1.inflate(R.layout.movechest, null);
                        AlertDialog.Builder alertDialogBuilder1 = new AlertDialog.Builder(getContext());


                        alertDialogBuilder1.setView(b).setTitle("胸部健身指南").setPositiveButton("開始計時", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Fragment2.this.getContext(), MyService.class);
                                getContext().startService(intent);
                                i=0;
                                handler.postDelayed(runnable, 30000);

                            }
                        }).show();
                        break;
                    case 2:
                        LayoutInflater inflater2 = LayoutInflater.from(getContext());
                        final View c = inflater2.inflate(R.layout.moveback, null);
                        AlertDialog.Builder alertDialogBuilder2 = new AlertDialog.Builder(getContext());

                        alertDialogBuilder2.setView(c).setTitle("背部健身指南").setPositiveButton("開始計時", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Fragment2.this.getContext(), MyService.class);
                                getContext().startService(intent);
                                i=0;
                                handler.postDelayed(runnable, 30000);

                            }
                        }).show();
                        break;
                    case 3:
                        LayoutInflater inflater3 = LayoutInflater.from(getContext());
                        final View d = inflater3.inflate(R.layout.movebelly, null);
                        AlertDialog.Builder alertDialogBuilder3 = new AlertDialog.Builder(getContext());


                        alertDialogBuilder3.setView(d).setTitle("腹部健身指南").setPositiveButton("開始計時", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Fragment2.this.getContext(), MyService.class);
                                getContext().startService(intent);
                                i=0;
                                handler.postDelayed(runnable, 30000);

                            }
                        }).show();
                        break;
                    case 4:
                        LayoutInflater inflater4 = LayoutInflater.from(getContext());
                        final View e = inflater4.inflate(R.layout.moveleg, null);
                        AlertDialog.Builder alertDialogBuilder4 = new AlertDialog.Builder(getContext());


                        alertDialogBuilder4.setView(e).setTitle("腿部健身指南").setPositiveButton("開始計時", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Fragment2.this.getContext(), MyService.class);
                                getContext().startService(intent);
                                i=0;
                                handler.postDelayed(runnable, 30000);

                            }
                        }).show();
                        break;
                }
            }
        });

        return view;
    }



    Handler handler = new Handler(Looper.getMainLooper());
    Runnable runnable=new Runnable() {
        @Override
        public void run() {

            i++;
            if (i <=4) {
                Toast.makeText(getContext(), "30秒已到\n請換下個動作", Toast.LENGTH_SHORT).show();


            } else if(i==5) {
                Toast.makeText(getContext(), "恭喜你已完成一組動作\n請休息一下吧", Toast.LENGTH_SHORT).show();
                handler.removeCallbacks(runnable);

            }
            handler.postDelayed(this, 3000);


        }

    };

}
