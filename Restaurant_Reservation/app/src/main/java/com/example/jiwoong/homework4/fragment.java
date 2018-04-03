package com.example.jiwoong.homework4;


import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jiwoong on 2017. 3. 30..
 */

public class fragment extends Fragment implements View.OnCreateContextMenuListener{

    Button b1, b2, b3, b4, b5, b6, b7;
    TextView t1, t2, t3, t4, t5, t6;
    EditText e1,e2, e3, e4;
    RadioButton r1,r2,r3,f1,f2,f3,f4;

    boolean[] savedFlag = new boolean[4];
    A[] objectArray = new A[4];
    String[] tableName = {"사과 TABLE", "포도 TABLE", "키위 TABLE", "자몽TABLE"};
    String[] membership = {"없음", "기본멤버쉽", "vip멤버쉽"};

    int selectedNum;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.food, container, true);
        View view = inflater.inflate(R.layout.fragment, container, true);


        super.onCreate(savedInstanceState);


        e1 = (EditText) view.findViewById(R.id.editText);
        e2 = (EditText) view.findViewById(R.id.editText2);

        b1 = (Button) view.findViewById(R.id.button4);
        b2 = (Button) view.findViewById(R.id.button3);
        b3 = (Button) view.findViewById(R.id.button2);
        b4 = (Button) view.findViewById(R.id.button);
        b5 = (Button) view.findViewById(R.id.button7);
        b6 = (Button) view.findViewById(R.id.button6);
        b7 = (Button) view.findViewById(R.id.button5);

        t1 = (TextView) view.findViewById(R.id.t1);
        t2 = (TextView) view.findViewById(R.id.t2);
        t3 = (TextView) view.findViewById(R.id.t3);
        t4 = (TextView) view.findViewById(R.id.t4);
        t5 = (TextView) view.findViewById(R.id.t5);
        t6 = (TextView) view.findViewById(R.id.t6);






        b5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                View view = View.inflate(getActivity(), R.layout.food, null);

                r1=(RadioButton) view.findViewById(R.id.radioButton4);
                r2=(RadioButton) view.findViewById(R.id.radioButton3);
                r3=(RadioButton) view.findViewById(R.id.radioButton2);

                f1=(RadioButton) view.findViewById(R.id.radioButton);
                f2=(RadioButton) view.findViewById(R.id.radioButton5);
                f3=(RadioButton) view.findViewById(R.id.radioButton6);
                f4=(RadioButton) view.findViewById(R.id.radioButton7);

                if(f1.isChecked()){
                    f2.setChecked(false);
                    f3.setChecked(false);
                    f4.setChecked(false);
                }

                f1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        f1.setChecked(true);
                        f2.setChecked(false);
                        f3.setChecked(false);
                        f4.setChecked(false);
                    }
                });

                f2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        f1.setChecked(false);
                        f2.setChecked(true);
                        f3.setChecked(false);
                        f4.setChecked(false);
                    }
                });

                f3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        f1.setChecked(false);
                        f2.setChecked(false);
                        f3.setChecked(true);
                        f4.setChecked(false);
                    }
                });

                f4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        f1.setChecked(false);
                        f2.setChecked(false);
                        f3.setChecked(false);
                        f4.setChecked(true);
                    }
                });

                r1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        r1.setChecked(true);
                        r2.setChecked(false);
                        r3.setChecked(false);

                    }
                });
                r2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        r1.setChecked(false);
                        r2.setChecked(true);
                        r3.setChecked(false);
                    }
                });
                r3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        r1.setChecked(false);
                        r2.setChecked(false);
                        r3.setChecked(true);
                    }
                });


                final TextView et = (TextView) view.findViewById(R.id.textView7);

                e3 = (EditText) view.findViewById(R.id.editText);
                e4 = (EditText) view.findViewById(R.id.editText2);


                AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());
                dlg.setTitle("주문하기")
                        .setView(view)
                        .setIcon(R.mipmap.ic_launcher)

                        .setPositiveButton("닫기", null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String s = e3.getText().toString();
                                String p = e4.getText().toString();


                                int membershipType = getMembershipType();
                                int totalPrice = getPice(Integer.parseInt(s),Integer.parseInt(p),membershipType);

                                if(f1.isChecked()){
                                    savedFlag[0] =true;
                                    objectArray[0] = new A(Integer.parseInt(s), Integer.parseInt(p));
                                    objectArray[0].setTablename(tableName[0]);
                                    objectArray[0].setTime();
                                    objectArray[0].setMembershipType(membershipType);
                                    objectArray[0].setPrice(totalPrice);

                                    t1.setText(tableName[0]);
                                    t2.setText(objectArray[0].getTime());
                                    t3.setText(objectArray[0].getS()+"개");
                                    t4.setText(objectArray[0].getP()+"개");
                                    t5.setText(membership[objectArray[0].getMembershipType()]);
                                    t6.setText(Integer.toString(objectArray[0].getPrice()));

                                    b1.setText(tableName[0]);
                                    selectedNum = 0;
                                }

                                else if(f2.isChecked()){
                                    savedFlag[1] = true;
                                    objectArray[1] = new A(Integer.parseInt(s), Integer.parseInt(p));
                                    objectArray[1].setTablename(tableName[1]);
                                    objectArray[1].setTime();
                                    objectArray[1].setMembershipType(membershipType);
                                    objectArray[1].setPrice(totalPrice);

                                    t1.setText(tableName[1]);
                                    t2.setText(objectArray[1].getTime());

                                    t3.setText(objectArray[1].getS()+"개");
                                    t4.setText(objectArray[1].getP()+"개");
                                    t5.setText(membership[objectArray[1].getMembershipType()]);
                                    t6.setText(Integer.toString(objectArray[1].getPrice()));

                                    b2.setText(tableName[1]);
                                    selectedNum = 1;

                                }
                                else if(f3.isChecked()){
                                    savedFlag[2] = true;
                                    objectArray[2] = new A(Integer.parseInt(s), Integer.parseInt(p));
                                    objectArray[2].setTablename(tableName[2]);
                                    objectArray[2].setTime();
                                    objectArray[2].setMembershipType(membershipType);
                                    objectArray[2].setPrice(totalPrice);

                                    t1.setText(tableName[2]);
                                    t2.setText(objectArray[2].getTime());

                                    t3.setText(objectArray[2].getS()+"개");
                                    t4.setText(objectArray[2].getP()+"개");
                                    t5.setText(membership[objectArray[2].getMembershipType()]);
                                    t6.setText(Integer.toString(objectArray[2].getPrice()));

                                    b3.setText(tableName[2]);
                                    selectedNum = 2;

                                }
                                else if(f4.isChecked()){
                                    savedFlag[3] = true;
                                    objectArray[3] = new A(Integer.parseInt(s), Integer.parseInt(p));
                                    objectArray[3].setTablename(tableName[3]);
                                    objectArray[3].setTime();
                                    objectArray[3].setMembershipType(membershipType);
                                    objectArray[3].setPrice(totalPrice);

                                    t1.setText(tableName[3]);
                                    t2.setText(objectArray[3].getTime());

                                    t3.setText(objectArray[3].getS()+"개");
                                    t4.setText(objectArray[3].getP()+"개");
                                    t5.setText(membership[objectArray[3].getMembershipType()]);
                                    t6.setText(Integer.toString(objectArray[3].getPrice()));

                                    b4.setText(tableName[3]);
                                    selectedNum = 3;
                                }


                            }


                        })
                        .show();

            }

        });

        b6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                View view = View.inflate(getActivity(), R.layout.food, null);

                r1=(RadioButton) view.findViewById(R.id.radioButton4);
                r2=(RadioButton) view.findViewById(R.id.radioButton3);
                r3=(RadioButton) view.findViewById(R.id.radioButton2);

                f1=(RadioButton) view.findViewById(R.id.radioButton);
                f2=(RadioButton) view.findViewById(R.id.radioButton5);
                f3=(RadioButton) view.findViewById(R.id.radioButton6);
                f4=(RadioButton) view.findViewById(R.id.radioButton7);

                if(f1.isChecked()){
                    f2.setChecked(false);
                    f3.setChecked(false);
                    f4.setChecked(false);
                }

                f1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        f1.setChecked(true);
                        f2.setChecked(false);
                        f3.setChecked(false);
                        f4.setChecked(false);
                    }
                });

                f2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        f1.setChecked(false);
                        f2.setChecked(true);
                        f3.setChecked(false);
                        f4.setChecked(false);
                    }
                });

                f3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        f1.setChecked(false);
                        f2.setChecked(false);
                        f3.setChecked(true);
                        f4.setChecked(false);
                    }
                });

                f4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        f1.setChecked(false);
                        f2.setChecked(false);
                        f3.setChecked(false);
                        f4.setChecked(true);
                    }
                });

                r1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        r1.setChecked(true);
                        r2.setChecked(false);
                        r3.setChecked(false);

                    }
                });
                r2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        r1.setChecked(false);
                        r2.setChecked(true);
                        r3.setChecked(false);
                    }
                });
                r3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        r1.setChecked(false);
                        r2.setChecked(false);
                        r3.setChecked(true);
                    }
                });


                final TextView et = (TextView) view.findViewById(R.id.textView7);

                e3 = (EditText) view.findViewById(R.id.editText);
                e4 = (EditText) view.findViewById(R.id.editText2);

                A selectedObject = objectArray[selectedNum];

                e3.setText(Integer.toString(selectedObject.getS()));
                e4.setText(Integer.toString(selectedObject.getP()));

                if (selectedObject.getTablename().equals(tableName[0])) {
                    f1.setChecked(true);
                } else if(selectedObject.getTablename().equals(tableName[1])) {
                    f2.setChecked(true);
                } else if(selectedObject.getTablename().equals(tableName[2])) {
                    f3.setChecked(true);
                } else if(selectedObject.getTablename().equals(tableName[3])) {
                    f4.setChecked(true);
                }
                f1.setEnabled(false);
                f2.setEnabled(false);
                f3.setEnabled(false);
                f4.setEnabled(false);

                if(selectedObject.getMembershipType() == 0) {
                    r1.setChecked(true);
                } else if(selectedObject.getMembershipType() == 1) {
                    r2.setChecked(true);
                } else if(selectedObject.getMembershipType() == 2) {
                    r3.setChecked(true);
                }

                AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());
                dlg.setTitle("주문하기")
                        .setView(view)
                        .setIcon(R.mipmap.ic_launcher)

                        .setPositiveButton("닫기", null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String s = e3.getText().toString();
                                String p = e4.getText().toString();


                                int membershipType = getMembershipType();
                                int totalPrice = getPice(Integer.parseInt(s),Integer.parseInt(p),membershipType);

                                objectArray[selectedNum].setS(Integer.parseInt(s));
                                objectArray[selectedNum].setP(Integer.parseInt(p));

                                objectArray[selectedNum].setMembershipType(membershipType);
                                objectArray[selectedNum].setPrice(totalPrice);

                                t1.setText(objectArray[selectedNum].getTablename());
                                t2.setText(objectArray[selectedNum].getTime());

                                t3.setText(objectArray[selectedNum].getS()+"개");
                                t4.setText(objectArray[selectedNum].getP()+"개");
                                t5.setText(membership[objectArray[selectedNum].getMembershipType()]);
                                t6.setText(Integer.toString(objectArray[selectedNum].getPrice()));
                            }


                        })



                        .show();

            }

        });

        b7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                objectArray = new A[4];
                t1.setText("비어있음");
                t2.setText("비어있음");

                t3.setText("비어있음");
                t4.setText("비어있음");
                t5.setText("비어있음");
                t6.setText("비어있음");
                savedFlag[0] = false;
                savedFlag[1] = false;
                savedFlag[2] = false;
                savedFlag[3] = false;

                b1.setText(tableName[0]+"(비어있음)");
                b2.setText(tableName[1]+"(비어있음)");
                b3.setText(tableName[2]+"(비어있음)");
                b4.setText(tableName[3]+"(비어있음)");
            }
        });




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(savedFlag[0]) {
                    t1.setText(objectArray[0].getTablename());
                    t2.setText(objectArray[0].getTime());
                    t3.setText(Integer.toString(objectArray[0].getP())+"개");
                    t4.setText(Integer.toString(objectArray[0].getS())+"개");
                    t5.setText(membership[objectArray[0].getMembershipType()]);
                    t6.setText(Integer.toString(objectArray[0].getPrice()));
                    selectedNum = 0;
                } else {
                    Toast.makeText(getActivity(), "비어있습니다", Toast.LENGTH_SHORT).show();
                }



            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(savedFlag[1]) {
                    t1.setText(objectArray[1].getTablename());
                    t2.setText(objectArray[1].getTime());
                    t3.setText(Integer.toString(objectArray[1].getP())+"개");
                    t4.setText(Integer.toString(objectArray[1].getS())+"개");
                    t5.setText(membership[objectArray[1].getMembershipType()]);
                    t6.setText(Integer.toString(objectArray[1].getPrice()));
                    selectedNum = 1;
                } else {
                    Toast.makeText(getActivity(), "비어있습니다", Toast.LENGTH_SHORT).show();
                }


            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(savedFlag[2]) {
                    t1.setText(objectArray[2].getTablename());
                    t2.setText(objectArray[2].getTime());
                    t3.setText(Integer.toString(objectArray[2].getP())+"개");
                    t4.setText(Integer.toString(objectArray[2].getS())+"개");
                    t5.setText(membership[objectArray[2].getMembershipType()]);
                    t6.setText(Integer.toString(objectArray[2].getPrice()));
                    selectedNum = 2;
                } else {
                    Toast.makeText(getActivity(), "비어있습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(savedFlag[3]) {
                    t1.setText(objectArray[3].getTablename());
                    t2.setText(objectArray[3].getTime());
                    t3.setText(Integer.toString(objectArray[3].getP())+"개");
                    t4.setText(Integer.toString(objectArray[3].getS())+"개");
                    t5.setText(membership[objectArray[3].getMembershipType()]);
                    t6.setText(Integer.toString(objectArray[3].getPrice()));
                    selectedNum = 3;
                } else {
                    Toast.makeText(getActivity(), "비어있습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        b7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(savedFlag[0]) {
//                    t1.setText("비어있음");
//                    t2.setText("비어있음");
//                    t3.setText("비어있음");
//                    t4.setText("비워있음");
//                    t5.setText(membership[objectArray[0].getMembershipType()]);
//                    t6.setText(Integer.toString(objectArray[0].getPrice()));
//                } else {
//                    Toast.makeText(getActivity(), "비어있습니다", Toast.LENGTH_SHORT).show();
//                }
//
//
//
//            }
//        });






        return view;

    }

    private int getMembershipType() {
        if(r2.isChecked()) {
            return 1;
        } else if(r3.isChecked()){
            return 2;
        }
        return 0;
    }

    private int getPice(int s, int p, int membershipType) {
        double price;

        price = s*10000 + p*12000;

        if(membershipType == 1) {
            price = price*0.9;
        } else if(membershipType == 2) {
            price = price*0.7;
        }

        return (int) price;
    }

}
