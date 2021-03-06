package com.example.customernew.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.customernew.Model.Product;

import com.example.customernew.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class PayActivity extends AppCompatActivity {
    private TextView txtPrice, txtNameOder;
    private ImageView imgOder, txtBack;
    private RadioButton mcheckTTNH;
    private Button btnConfigOder;
    FirebaseAuth auth;
    DatabaseReference reference, databaseReference;
    Product product;
    TextInputEditText adress , note, numberOder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        anhXa();

        auth = FirebaseAuth.getInstance();

        product = (Product) getIntent().getSerializableExtra("product");
        txtNameOder.setText(product.getNameP());
        txtPrice.setText(product.getPrice()+"");
        Glide.with(this)
                .load(product.getAvatarP())
                .into(imgOder);
        txtBack.setOnClickListener(v -> {
            finish();
        });
        btnConfigOder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

    }


    private void register(){
        if (adress.getText().toString().isEmpty()){
            Toast.makeText(this,"Vui L??ng ??i???n th??ng tin ?????a ch??? nh???n h??ng",Toast.LENGTH_LONG).show();
        }
        else {
            FirebaseUser firebaseUser = auth.getCurrentUser();
            String userID = firebaseUser.getUid();
            String uniqueKey = FirebaseDatabase.getInstance().getReference("Users").child(userID).child("Order").push().getKey();
            reference = FirebaseDatabase.getInstance().getReference("Users").child(userID).child("Order").child(uniqueKey);
            databaseReference = FirebaseDatabase.getInstance().getReference("Order").child(uniqueKey);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("id", userID);
            hashMap.put("name", product.getNameP());
            String soLuong = numberOder.getText()+"";
            int a = Integer.parseInt(soLuong);
            int b = product.getPrice();
            int tongTien = a*b;
            hashMap.put("price", String.valueOf(tongTien));
            hashMap.put("image", product.getAvatarP());
            hashMap.put("cash", "ti???n m???t");
            hashMap.put("adress", adress.getText().toString());
            hashMap.put("note", note.getText().toString());
            hashMap.put("key", uniqueKey);
            hashMap.put("status", "?????t h??ng");
            hashMap.put("soLuong", soLuong);

            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(PayActivity.this,"L??n ????n h??ng th??nh c??ng",Toast.LENGTH_LONG).show();
                        finish();
                    }
                    else {
                    }
                }
            });
            databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                }
            });
        }
    }


    private void anhXa(){
        txtBack = findViewById(R.id.back);
        txtPrice = findViewById(R.id.txtPriceOder);
        txtNameOder = findViewById(R.id.txtNameOder);
        imgOder = findViewById(R.id.imgOderr);
        mcheckTTNH = findViewById(R.id.chekcTTNH);
        btnConfigOder = findViewById(R.id.btnConfigOder);
        adress = findViewById(R.id.adress);
        note = findViewById(R.id.note);
        numberOder = findViewById(R.id.oderNumber);
    }


}