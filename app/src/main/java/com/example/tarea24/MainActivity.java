package com.example.tarea24;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
public class MainActivity extends AppCompatActivity {

    EditText description;
    Button btnSave, btnGallery;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        description = (EditText) findViewById(R.id.txtDescripcion);
        view = (View) findViewById(R.id.firmas);

        btnSave = (Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSignature();
            }
        });

        btnGallery = (Button)findViewById(R.id.brnGallery);
        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GalleryActivity.class);
                startActivity(intent);
            }
        });
    }

    public void saveSignature(){

        SQLiteConexion conection = new SQLiteConexion(this, Config.NameDataBase, null, 1);
        SQLiteDatabase db = conection.getWritableDatabase();

        try{

            ContentValues signs = new ContentValues();

            signs.put(Config.image, Viewfirma(view));
            signs.put(Config.description, description.getText().toString());

            Toast.makeText(getApplicationContext(), "Firma Registrada", Toast.LENGTH_LONG).show();
            description.setText("");
            view.setDrawingCacheEnabled(false);

        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

    public static byte[]  Viewfirma(View view5) {
        view5.setDrawingCacheEnabled(true);
        Bitmap bitmap = view5.getDrawingCache();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);

        byte[] byteArray = stream.toByteArray();
        return byteArray;

    }

    private void ClearScreen() {
        description.setText("");
        view.setDrawingCacheEnabled(false);
    }
}