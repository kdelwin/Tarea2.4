package com.example.tarea24;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
public class GalleryActivity extends AppCompatActivity {

    RecyclerView recycler;

    ArrayList<Signatures> gallery;
    List<Signatures> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        gallery = new ArrayList<>();

        GetListGallery();

        recycler = (RecyclerView) findViewById(R.id.list);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        SignatureAdapter adapter = new SignatureAdapter(items);
        recycler.setAdapter(adapter);
    }


    private void GetListGallery() {
        SQLiteConexion conexion = new SQLiteConexion(this, Config.NameDataBase, null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();
        Signatures Items = null;
        gallery = new ArrayList<Signatures>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Config.signature_table, null);

        while (cursor.moveToNext()) {
            Items = new Signatures();
            Items.setId(cursor.getInt(0));
            Items.setImage(cursor.getBlob(1));
            Items.setDescription(cursor.getString(2));

            gallery.add(Items);
        }

        cursor.close();
        GalleryList();
    }

    private void GalleryList() {

        items = new ArrayList<>();

        for (int i = 0; i < gallery.size(); i++){

            items.add(new Signatures(
                    gallery.get(i).getId(),
                    gallery.get(i).getImage(),
                    gallery.get(i).getDescription()));
        }
    }
}