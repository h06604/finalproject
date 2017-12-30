package com.example.a0989.finalproject;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {
    private View view;
    Button bt5;
    TextView tv1,tv2,tv3;
    Integer year=0;
    Double  BMI=0.0,BASE=0.0,RRE=0.0,weight=0.0,tall=0.0;
    String[] messageData1 = new String[]{"","","","","",""};

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_fragment1, container, false);
        final SharedPreferences preferences = this.getActivity().getSharedPreferences("data", MODE_PRIVATE);

        tv1=(TextView)view.findViewById(R.id.bmi);
        tv2=(TextView)view.findViewById(R.id.base);
        tv3=(TextView)view.findViewById(R.id.rre);

        tv1.setText(preferences.getString("BMI",""));
        tv2.setText(preferences.getString("BASE",""));
        tv3.setText(preferences.getString("RRE",""));
        for(int i=0;i<3;i++){
            if(i==0){
                messageData1[i]="BMI:"+preferences.getString("BMI","");
            }
            else if(i==1){
                messageData1[i]="每日基礎代謝:"+preferences.getString("BASE","");
            }
            else if(i==2){
                messageData1[i]="靜態能量消耗值:"+preferences.getString("RRE","");
            }
        }

        showList();


        bt5=(Button)view.findViewById(R.id.button5);
        bt5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                final View a=inflater.inflate(R.layout.input,null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                alertDialogBuilder.setView(a).setTitle("請輸入正確資訊").setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        EditText userInput1=(EditText) a.findViewById(R.id.editText1);
                        EditText userInput2=(EditText) a.findViewById(R.id.editText2);
                        EditText userInput3=(EditText) a.findViewById(R.id.editText3);
                        if(userInput1.getText().toString().equals("")||userInput2.getText().toString().equals("")||userInput3.getText().toString().equals("")){
                            Toast.makeText(getContext(),"資料輸入不完全",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            tall=Double.parseDouble(userInput1.getText().toString());
                            weight=Double.parseDouble(userInput2.getText().toString());
                            year=Integer.parseInt(userInput3.getText().toString());
                            BMI=weight/((tall/100)*(tall/100));
                            BASE=(13.7*weight)+(5*tall)-(6.8*year)+66;
                            RRE=(10*weight)+(6.5*tall)-(5*year)+5;
                            String  basetmp=BASE.toString();
                            String  bmitmp=BMI.toString();
                            String  rretmp=RRE.toString();
                            for(int i=0;i<3;i++){
                                if(i==0){
                                    messageData1[i]="BMI:"+bmitmp;
                                }
                                else if(i==1){
                                    messageData1[i]="每日基礎代謝:"+basetmp;
                                }
                                else if(i==2){
                                    messageData1[i]="靜態能量消耗值:"+rretmp;
                                }
                            }
                            tv2.setText(basetmp);
                            tv1.setText(bmitmp);
                            tv3.setText(rretmp);
                            preferences.edit().putString("BMI",bmitmp).putString("BASE",basetmp).putString("RRE",rretmp).apply();
                            showList();
                        }
                    }
                }).setNeutralButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which){
                        Toast.makeText(getContext(),"取消" , Toast.LENGTH_SHORT).show();

                    }
                }).show();
            }
        });



        return view;
    }
    public void showList(){
        ArrayAdapter<String> messageAdapter= new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,messageData1);
        ListView listView=(ListView)view.findViewById(R.id.listview);
        listView.setAdapter(messageAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position,long id){
                if(messageData1[position].equals("")){

                }
                else{
                    Toast.makeText(getContext(),"OOKK",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
