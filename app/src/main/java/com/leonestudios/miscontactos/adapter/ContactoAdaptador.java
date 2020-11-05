package com.leonestudios.miscontactos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.leonestudios.miscontactos.DetalleContacto;
import com.leonestudios.miscontactos.R;
import com.leonestudios.miscontactos.db.ConstructorContactos;
import com.leonestudios.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;
    public ImageButton btnLike;
    Activity activity;
    public Contacto contac;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
        this.btnLike = btnLike;
    }
    //inflar el layout y lo pasara al viewholder para que el obtenga los views
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    //asocia cada elemento de la vista con cada view
    @Override
    public void onBindViewHolder(@NonNull final ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto = contactos.get(position);
        //contactoViewHolder.imgFoto.setImageResource(contacto.getUrlFoto());
        //contactoViewHolder.tvNombre.setText(contacto.getNombre());
        //contactoViewHolder.tvTelefono.setText(contacto.getTelefono());
        contactoViewHolder.tvLikes.setText(String.valueOf(contacto.getLikes()) + "Likes");

        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("url", contacto.getUrlFoto());
                intent.putExtra("link", contacto.getLikes());
                //intent.putExtra("email", contacto.getEmail());
                activity.startActivity(intent);
            }
        });
        /*contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + contacto.getNombre(),
                        Toast.LENGTH_SHORT).show();

                ConstructorContactos constructorContacto = new ConstructorContactos(activity);
                constructorContacto.darLikeContacto(contacto);
                contactoViewHolder.tvLikes.setText(constructorContacto.obtenerLikesContacto(contacto));
            }
        });*/


    }

    @Override
    public int getItemCount() { //Cantidad de elementos que tiene la lista, devuelve la cantida de elementos
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        //private TextView tvNombre;
        //private TextView tvTelefono;
        //private ImageButton btnLike;
        private TextView tvLikes;

        public ContactoViewHolder(View itemView){
            super(itemView);
            imgFoto         = (ImageView)itemView.findViewById(R.id.imgFoto);
            /*tvNombre      = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefono    = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            btnLike         = (ImageButton) itemView.findViewById(R.id.btnLike);
            */
            tvLikes         = (TextView) itemView.findViewById(R.id.tvLikes);
        }

    }
}
