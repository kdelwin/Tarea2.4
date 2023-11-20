package com.example.tarea24;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class SignatureAdapter extends RecyclerView.Adapter<SignatureAdapter.SignViewHolder> {

    private List<Signatures> items;

    public SignatureAdapter(List<Signatures> items) {
        this.items = items;
    }

    @Override
    public SignViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.signature_card, viewGroup, false);
        return new SignViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SignViewHolder viewHolder, int i) {
        Bitmap BMP = BitmapFactory.decodeByteArray(items.get(i).getImage(), 0,items.get(i).getImage().length);

        viewHolder.firma.setImageBitmap(BMP);
        viewHolder.descripcion.setText(items.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class SignViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView firma;
        public TextView id, nombre, fecha, formato, bytes, descripcion;

        public SignViewHolder(View v) {
            super(v);
            firma = (ImageView) v.findViewById(R.id.viewSignature);
            descripcion = (TextView) v.findViewById(R.id.txt_Description);
        }
    }
}
