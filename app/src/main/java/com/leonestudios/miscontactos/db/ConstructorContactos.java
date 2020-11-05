package com.leonestudios.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;

import com.leonestudios.miscontactos.R;
import com.leonestudios.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class ConstructorContactos {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorContactos(Context context){
        this.context = context;

    }

    public ArrayList<Contacto> obtenerDatos(){
        /*ArrayList<Contacto> contactos = new ArrayList<>();
        return contactos;*/


        BaseDatos db = new BaseDatos(context);
        insetarCuatroContactos(db);
        return db.obtenerTodosLosContactos();
    }

    public void insetarCuatroContactos(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Eduardo Leon");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "04248587119");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "Eduleon78@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.rayo);

        db.insertarContactos(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Sonyram Acosta");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "04147941202");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "sonyracosta@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.rayo);

        db.insertarContactos(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Christiam Leon");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "04147941202");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "sonyracosta@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.rayo);

        db.insertarContactos(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Leander Leon");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "04147941202");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "sonyracosta@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.rayo);

        db.insertarContactos(contentValues);

    }

    public void darLikeContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);
    }
    public int obtenerLikesContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }
}
