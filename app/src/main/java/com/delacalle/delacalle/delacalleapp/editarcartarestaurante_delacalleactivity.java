package com.delacalle.delacalle.delacalleapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.GetDataCallback;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseRole;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class editarcartarestaurante_delacalleactivity extends AppCompatActivity {

    private Toolbar mToolbar;

    String id;

    private ImageView fotocartaplato1;
    private TextView nombreplato1;
    private TextView  descripcionplato1;
    private TextView  precioplato1;

    private ImageView fotocartaplato2;
    private TextView  nombreplato2;
    private TextView  descripcionplato2;
    private TextView  precioplato2;

    private ImageView fotocartaplato3;
    private TextView  nombreplato3;
    private TextView  descripcionplato3;
    private TextView  precioplato3;

    private ImageView fotocartaplato4;
    private TextView  nombreplato4;
    private TextView  descripcionplato4;
    private TextView  precioplato4;

    private ImageView fotocartaplato5;
    private TextView  nombreplato5;
    private TextView  descripcionplato5;
    private TextView  precioplato5;

    private ImageView fotocartaplato6;
    private TextView  nombreplato6;
    private TextView  descripcionplato6;
    private TextView  precioplato6;

    private Button btneditarrcarta;


    View focusView;

    private String nombreplato1C;
    private String descripcionplato1C;
    private String precioplato1C;

    private String nombreplato2C;
    private String descripcionplato2C;
    private String precioplato2C;

    private String nombreplato3C;
    private String descripcionplato3C;
    private String precioplato3C;

    private String nombreplato4C;
    private String descripcionplato4C;
    private String precioplato4C;

    private String nombreplato5C;
    private String descripcionplato5C;
    private String precioplato5C;

    private String nombreplato6C;
    private String descripcionplato6C;
    private String precioplato6C;

    Bitmap pic;
    Bitmap pic2;
    Bitmap pic3;
    Bitmap pic4;
    Bitmap pic5;
    Bitmap pic6;

    Bitmap bitmaperror2;
    Bitmap bitmaperror3;
    Bitmap bitmaperror4;
    Bitmap bitmaperror5;
    Bitmap bitmaperror6;

    ParseFile fotocartafile1;
    ParseFile fotocartafile2;
    ParseFile fotocartafile3;
    ParseFile fotocartafile4;
    ParseFile fotocartafile5;
    ParseFile fotocartafile6;

    // Popup fotos
    RelativeLayout relativealbum;
    RelativeLayout relativefoto;


    // Seleccionar la foto
    public static final int IMAGEREQUESTCODE = 45535;
    public static final int IMAGEREQUESTCODE2 = 45536;
    public static final int IMAGEREQUESTCODE3 = 45537;
    public static final int IMAGEREQUESTCODE4 = 45538;
    public static final int IMAGEREQUESTCODE5 = 45539;
    public static final int IMAGEREQUESTCODE6 = 45540;

    Intent galleryIntent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editarcartarestaurante_delacalleactivity);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
        Tracker tracker = analytics.newTracker("UA-77841203-3");
        tracker.setScreenName("editarcartarestaurante");
        tracker.send(new HitBuilders.ScreenViewBuilder().build());

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        final Typeface primerfontcandara = Typeface.createFromAsset(getAssets(), "fonts/CandaraBold.ttf");
        final Typeface segundafontcaviar = Typeface.createFromAsset(getAssets(), "fonts/CaviarDreams.ttf");


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getString("id");

        }
        else
        {
            Log.d("delacalle", "Error al pasar el id " + id);
        }


        fotocartaplato1 = (ImageView) findViewById(R.id.imageViewAfotoplato1);
        nombreplato1 = (TextView) findViewById(R.id.editTextAnombreplato1);
        descripcionplato1 = (TextView) findViewById(R.id.editTextAdescripcionplato1);
        precioplato1 = (TextView) findViewById(R.id.editTextAprecioplato1);
        nombreplato1.setTypeface(segundafontcaviar);
        descripcionplato1.setTypeface(segundafontcaviar);
        precioplato1.setTypeface(segundafontcaviar);

        fotocartaplato2 = (ImageView) findViewById(R.id.imageViewAfotoplato2);
        nombreplato2 = (TextView) findViewById(R.id.editTextAnombreplato2);
        descripcionplato2 = (TextView) findViewById(R.id.editTextAdescripcionplato2);
        precioplato2 = (TextView) findViewById(R.id.editTextAprecioplato2);
        nombreplato2.setTypeface(segundafontcaviar);
        descripcionplato2.setTypeface(segundafontcaviar);
        precioplato2.setTypeface(segundafontcaviar);

        fotocartaplato3 = (ImageView) findViewById(R.id.imageViewAfotoplato3);
        nombreplato3 = (TextView) findViewById(R.id.editTextAnombreplato3);
        descripcionplato3 = (TextView) findViewById(R.id.editTextAdescripcionplato3);
        precioplato3 = (TextView) findViewById(R.id.editTextAprecioplato3);
        nombreplato3.setTypeface(segundafontcaviar);
        descripcionplato3.setTypeface(segundafontcaviar);
        precioplato3.setTypeface(segundafontcaviar);

        fotocartaplato4 = (ImageView) findViewById(R.id.imageViewAfotoplato4);
        nombreplato4 = (TextView) findViewById(R.id.editTextAnombreplato4);
        descripcionplato4 = (TextView) findViewById(R.id.editTextAdescripcionplato4);
        precioplato4 = (TextView) findViewById(R.id.editTextAprecioplato4);
        nombreplato4.setTypeface(segundafontcaviar);
        descripcionplato4.setTypeface(segundafontcaviar);
        precioplato4.setTypeface(segundafontcaviar);

        fotocartaplato5 = (ImageView) findViewById(R.id.imageViewAfotoplato5);
        nombreplato5 = (TextView) findViewById(R.id.editTextAnombreplato5);
        descripcionplato5 = (TextView) findViewById(R.id.editTextAdescripcionplato5);
        precioplato5 = (TextView) findViewById(R.id.editTextAprecioplato5);
        nombreplato5.setTypeface(segundafontcaviar);
        descripcionplato5.setTypeface(segundafontcaviar);
        precioplato5.setTypeface(segundafontcaviar);

        fotocartaplato6 = (ImageView) findViewById(R.id.imageViewAfotoplato6);
        nombreplato6 = (TextView) findViewById(R.id.editTextAnombreplato6);
        descripcionplato6 = (TextView) findViewById(R.id.editTextAdescripcionplato6);
        precioplato6 = (TextView) findViewById(R.id.editTextAprecioplato6);
        nombreplato6.setTypeface(segundafontcaviar);
        descripcionplato6.setTypeface(segundafontcaviar);
        precioplato6.setTypeface(segundafontcaviar);

    //    btneditarrcarta = (Button) findViewById(R.id.btnActualizarCarta);
    //    btneditarrcarta.setTypeface(primerfontcandara);

        bitmaperror2 = BitmapFactory.decodeResource(getResources(), R.drawable.agregar_foto);
        bitmaperror3 = BitmapFactory.decodeResource(getResources(), R.drawable.agregar_foto);
        bitmaperror4 = BitmapFactory.decodeResource(getResources(), R.drawable.agregar_foto);
        bitmaperror5 = BitmapFactory.decodeResource(getResources(), R.drawable.agregar_foto);
        bitmaperror6 = BitmapFactory.decodeResource(getResources(), R.drawable.agregar_foto);

        fotocartaplato1.setClickable(true);
        fotocartaplato2.setClickable(true);
        fotocartaplato3.setClickable(true);
        fotocartaplato4.setClickable(true);
        fotocartaplato5.setClickable(true);
        fotocartaplato6.setClickable(true);


try {
    // Query plato 1
    ParseQuery<ParseObject> cartaqplato1 = ParseQuery.getQuery("carta");
    cartaqplato1.whereEqualTo("restauranteId", id);
    cartaqplato1.getFirstInBackground(new GetCallback<ParseObject>() {
        @Override
        public void done(ParseObject carta, ParseException e) {
            if (e == null) {
                nombreplato1.setText(carta.getString("nombre"));
                descripcionplato1.setText(carta.getString("descripcion"));
                precioplato1.setText(carta.getString("precio"));
                fotocartafile1 = carta.getParseFile("fotoplato");
                fotocartafile1.getDataInBackground(new GetDataCallback() {
                    @Override
                    public void done(byte[] data, ParseException e) {
                        final BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = 2;
                        Bitmap  pic = BitmapFactory.decodeByteArray(data, 0, data.length,options);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        pic.compress(Bitmap.CompressFormat.JPEG, 70, stream);
                        fotocartaplato1.setImageBitmap(pic);
                    }
                });
            } else if (e.getCode() == ParseException.OBJECT_NOT_FOUND) {
                Log.d("delacalle", "No se ha encontrado la carta");
            }
        }
    });

    // Query plato 2
    ParseQuery<ParseObject> cartaqplato2 = ParseQuery.getQuery("carta");
    cartaqplato2.whereEqualTo("restauranteId", id);
    cartaqplato2.setSkip(1);
    cartaqplato2.getFirstInBackground(new GetCallback<ParseObject>() {
        @Override
        public void done(ParseObject carta, ParseException e) {
            if (e == null) {
                nombreplato2.setText(carta.getString("nombre"));
                descripcionplato2.setText(carta.getString("descripcion"));
                precioplato2.setText(carta.getString("precio"));
                fotocartafile2 = carta.getParseFile("fotoplato");
                fotocartafile2.getDataInBackground(new GetDataCallback() {
                    @Override
                    public void done(byte[] data, ParseException e) {
                        final BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = 2;
                        Bitmap  pic = BitmapFactory.decodeByteArray(data, 0, data.length,options);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        pic.compress(Bitmap.CompressFormat.JPEG, 70, stream);
                        fotocartaplato2.setImageBitmap(pic);
                    }
                });
            } else if (e.getCode() == ParseException.OBJECT_NOT_FOUND) {
                Log.d("delacalle", "No se ha encontrado la carta");
            }
        }
    });

    // Query plato 3
    ParseQuery<ParseObject> cartaqplato3 = ParseQuery.getQuery("carta");
    cartaqplato3.whereEqualTo("restauranteId", id);
    cartaqplato3.setSkip(2);
    cartaqplato3.getFirstInBackground(new GetCallback<ParseObject>() {
        @Override
        public void done(ParseObject carta, ParseException e) {
            if (e == null) {
                nombreplato3.setText(carta.getString("nombre"));
                descripcionplato3.setText(carta.getString("descripcion"));
                precioplato3.setText(carta.getString("precio"));
                fotocartafile3 = carta.getParseFile("fotoplato");
                fotocartafile3.getDataInBackground(new GetDataCallback() {
                    @Override
                    public void done(byte[] data, ParseException e) {
                        final BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = 2;
                        Bitmap  pic = BitmapFactory.decodeByteArray(data, 0, data.length,options);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        pic.compress(Bitmap.CompressFormat.JPEG, 70, stream);
                        fotocartaplato3.setImageBitmap(pic);
                    }
                });
            } else if (e.getCode() == ParseException.OBJECT_NOT_FOUND) {
                Log.d("delacalle", "No se ha encontrado la carta");
            }
        }
    });

    // Query plato 4
    ParseQuery<ParseObject> cartaqplato4 = ParseQuery.getQuery("carta");
    cartaqplato4.whereEqualTo("restauranteId", id);
    cartaqplato4.setSkip(3);
    cartaqplato4.getFirstInBackground(new GetCallback<ParseObject>() {
        @Override
        public void done(ParseObject carta, ParseException e) {
            if (e == null) {
                nombreplato4.setText(carta.getString("nombre"));
                descripcionplato4.setText(carta.getString("descripcion"));
                precioplato4.setText(carta.getString("precio"));
                fotocartafile4 = carta.getParseFile("fotoplato");
                fotocartafile4.getDataInBackground(new GetDataCallback() {
                    @Override
                    public void done(byte[] data, ParseException e) {
                        final BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = 2;
                        Bitmap  pic = BitmapFactory.decodeByteArray(data, 0, data.length,options);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        pic.compress(Bitmap.CompressFormat.JPEG, 70, stream);
                        fotocartaplato4.setImageBitmap(pic);
                    }
                });
            } else if (e.getCode() == ParseException.OBJECT_NOT_FOUND) {
                Log.d("delacalle", "No se ha encontrado la carta");
            }
        }
    });

    // Query plato 5
    ParseQuery<ParseObject> cartaqplato5 = ParseQuery.getQuery("carta");
    cartaqplato5.whereEqualTo("restauranteId", id);
    cartaqplato5.setSkip(4);
    cartaqplato5.getFirstInBackground(new GetCallback<ParseObject>() {
        @Override
        public void done(ParseObject carta, ParseException e) {
            if (e == null) {
                nombreplato5.setText(carta.getString("nombre"));
                descripcionplato5.setText(carta.getString("descripcion"));
                precioplato5.setText(carta.getString("precio"));
                fotocartafile5 = carta.getParseFile("fotoplato");
                fotocartafile5.getDataInBackground(new GetDataCallback() {
                    @Override
                    public void done(byte[] data, ParseException e) {
                        final BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = 2;
                        Bitmap  pic = BitmapFactory.decodeByteArray(data, 0, data.length,options);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        pic.compress(Bitmap.CompressFormat.JPEG, 70, stream);
                        fotocartaplato5.setImageBitmap(pic);
                    }
                });
            } else if (e.getCode() == ParseException.OBJECT_NOT_FOUND) {
                Log.d("delacalle", "No se ha encontrado la carta");
            }
        }
    });

    // Query plato 6
    ParseQuery<ParseObject> cartaqplato6 = ParseQuery.getQuery("carta");
    cartaqplato6.whereEqualTo("restauranteId", id);
    cartaqplato6.setSkip(5);
    cartaqplato6.getFirstInBackground(new GetCallback<ParseObject>() {
        @Override
        public void done(ParseObject carta, ParseException e) {
            if (e == null) {
                nombreplato6.setText(carta.getString("nombre"));
                descripcionplato6.setText(carta.getString("descripcion"));
                precioplato6.setText(carta.getString("precio"));
                fotocartafile6 = carta.getParseFile("fotoplato");
                fotocartafile6.getDataInBackground(new GetDataCallback() {
                    @Override
                    public void done(byte[] data, ParseException e) {
                        final BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = 2;
                        Bitmap  pic = BitmapFactory.decodeByteArray(data, 0, data.length,options);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        pic.compress(Bitmap.CompressFormat.JPEG, 70, stream);
                        fotocartaplato6.setImageBitmap(pic);
                    }
                });
            } else if (e.getCode() == ParseException.OBJECT_NOT_FOUND) {
                Log.d("delacalle", "No se ha encontrado la carta");
            }
        }
    });
}catch(Exception e)
{
    e.getStackTrace();
    Log.d("delacalle", "error en mostrar contenido carta");
}

        galleryIntent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.INTERNAL_CONTENT_URI);


   /*     btneditarrcarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseQuery<ParseRole> queryrol = ParseRole.getQuery();
                queryrol.whereEqualTo("name", "responsable");
                queryrol.whereEqualTo("users", ParseUser.getCurrentUser().getObjectId());
                queryrol.getFirstInBackground(new GetCallback<ParseRole>() {
                    @Override
                    public void done(ParseRole rol, ParseException e) {
                        if (e == null) {
                          //  ActualizarCarta();
                            errors();
                        } else {
                            Toast.makeText(getApplicationContext(), "No puedes editar una carta si no eres un responsable", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });*/

        fotocartaplato1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayPopupFotoPlato1(v);
            }
        });

        fotocartaplato2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayPopupFotoPlato2(v);
            }
        });

        fotocartaplato3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayPopupFotoPlato3(v);
            }
        });

        fotocartaplato4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayPopupFotoPlato4(v);
            }
        });

        fotocartaplato5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayPopupFotoPlato5(v);
            }
        });

        fotocartaplato6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayPopupFotoPlato6(v);
            }
        });
    }

    public void ActualizarCarta()
    {
        try {

            nombreplato1C = nombreplato1.getText().toString().toLowerCase();
            descripcionplato1C = descripcionplato1.getText().toString();
            precioplato1C = precioplato1.getText().toString();

            nombreplato2C = nombreplato2.getText().toString().toLowerCase();
            descripcionplato2C = descripcionplato2.getText().toString();
            precioplato2C = precioplato2.getText().toString();

            nombreplato3C = nombreplato3.getText().toString().toLowerCase();
            descripcionplato3C = descripcionplato3.getText().toString();
            precioplato3C = precioplato3.getText().toString();

            nombreplato4C = nombreplato4.getText().toString().toLowerCase();
            descripcionplato4C = descripcionplato4.getText().toString();
            precioplato4C = precioplato4.getText().toString();

            nombreplato5C = nombreplato5.getText().toString().toLowerCase();
            descripcionplato5C = descripcionplato5.getText().toString();
            precioplato5C = precioplato5.getText().toString();

            nombreplato6C = nombreplato6.getText().toString().toLowerCase();
            descripcionplato6C = descripcionplato6.getText().toString();
            precioplato6C = precioplato6.getText().toString();

            ParseQuery<ParseObject> carta1q = ParseQuery.getQuery("carta");
            carta1q.whereEqualTo("restauranteId",id);
            carta1q.getFirstInBackground(new GetCallback<ParseObject>() {
                @Override
                public void done(ParseObject carta1, ParseException e) {
                    if(e== null)
                    {
                        carta1.put("nombre", nombreplato1C);
                        carta1.put("descripcion", descripcionplato1C);
                        carta1.put("precio", precioplato1C);
                        carta1.put("fotoplato", fotocartafile1);
                        carta1.put("restauranteId", id);
//                        ProgressDialog.show(getApplication(), "Guardando", "Espera mientras actualiza la carta",true,true);
                        carta1.saveInBackground();
                        Log.d("delacalle","Plato actualizado");
                    }
                    else
                    {
                        Log.d("delacalle","Plato no actualizado");
                    }
                }
            });
          //  ParseObject carta1 = new ParseObject("carta");


            if (TextUtils.isEmpty(nombreplato2C)) {
                Log.d("delacalle", "nombre plato vacio");
            } else {
                ParseQuery<ParseObject> carta2q = ParseQuery.getQuery("carta");
                carta2q.whereEqualTo("restauranteId",id);
                carta2q.setSkip(1);
                carta2q.getFirstInBackground(new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject carta2, ParseException e) {
                        if(e==null)
                        {
                            carta2.put("nombre", nombreplato2C);
                            carta2.put("descripcion", descripcionplato2C);
                            carta2.put("precio", precioplato2C);
                            carta2.put("fotoplato", fotocartafile2);
                            carta2.put("restauranteId", id);
                            carta2.saveInBackground();
                        }
                        else
                            if(e.getCode()== ParseException.OBJECT_NOT_FOUND)
                            {
                                ParseObject carta2c = new ParseObject("carta");
                                carta2c.put("nombre", nombreplato2C);
                                carta2c.put("descripcion", descripcionplato2C);
                                carta2c.put("precio", precioplato2C);
                                carta2c.put("fotoplato", fotocartafile2);
                                carta2c.put("restauranteId", id);
                                carta2c.saveInBackground();
                            }
                    }
                });

            }

            if (TextUtils.isEmpty(nombreplato3C)) {
                Log.d("delacalle", "nombre plato vacio");
            } else {
                ParseQuery<ParseObject> carta3q = ParseQuery.getQuery("carta");
                carta3q.whereEqualTo("restauranteId",id);
                carta3q.setSkip(2);
                carta3q.getFirstInBackground(new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject carta3, ParseException e) {
                        if(e==null)
                        {
                            carta3.put("nombre", nombreplato3C);
                            carta3.put("descripcion", descripcionplato3C);
                            carta3.put("precio", precioplato3C);
                            carta3.put("fotoplato", fotocartafile3);
                            carta3.put("restauranteId", id);
                            carta3.saveInBackground();
                        }
                        else
                            if(e.getCode() == ParseException.OBJECT_NOT_FOUND)
                            {
                                ParseObject carta3c = new ParseObject("carta");
                                carta3c.put("nombre", nombreplato3C);
                                carta3c.put("descripcion", descripcionplato3C);
                                carta3c.put("precio", precioplato3C);
                                carta3c.put("fotoplato", fotocartafile3);
                                carta3c.put("restauranteId", id);
                                carta3c.saveInBackground();
                            }
                    }
                });


            }
            if (TextUtils.isEmpty(nombreplato4C)) {
                Log.d("delacalle", "nombre plato vacio");
            } else {
                ParseQuery<ParseObject> carta4q = ParseQuery.getQuery("carta");
                carta4q.whereEqualTo("restauranteId",id);
                carta4q.setSkip(3);
                carta4q.getFirstInBackground(new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject carta4, ParseException e) {
                        if(e==null)
                        {
                            carta4.put("nombre", nombreplato4C);
                            carta4.put("descripcion", descripcionplato4C);
                            carta4.put("precio", precioplato4C);
                            carta4.put("fotoplato", fotocartafile4);
                            carta4.put("restauranteId", id);
                            carta4.saveInBackground();

                        }
                        else if(e.getCode() == ParseException.OBJECT_NOT_FOUND)
                        {
                            ParseObject carta4c = new ParseObject("carta");
                            carta4c.put("nombre", nombreplato4C);
                            carta4c.put("descripcion", descripcionplato4C);
                            carta4c.put("precio", precioplato4C);
                            carta4c.put("fotoplato", fotocartafile4);
                            carta4c.put("restauranteId", id);
                            carta4c.saveInBackground();
                        }


                    }
                });


            }
            if (TextUtils.isEmpty(nombreplato5C)) {
                Log.d("delacalle", "nombre plato vacio");
            } else {
                ParseQuery<ParseObject> carta5q = ParseQuery.getQuery("carta");
                carta5q.whereEqualTo("restauranteId",id);
                carta5q.setSkip(4);
                carta5q.getFirstInBackground(new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject carta5, ParseException e) {
                        if(e == null)
                        {
                            carta5.put("nombre", nombreplato5C);
                            carta5.put("descripcion", descripcionplato5C);
                            carta5.put("precio", precioplato5C);
                            carta5.put("fotoplato", fotocartafile5);
                            carta5.put("restauranteId", id);
                            carta5.saveInBackground();
                        }
                        else if(e.getCode() == ParseException.OBJECT_NOT_FOUND)
                        {
                            ParseObject carta5c = new ParseObject("carta");
                            carta5c.put("nombre", nombreplato5C);
                            carta5c.put("descripcion", descripcionplato5C);
                            carta5c.put("precio", precioplato5C);
                            carta5c.put("fotoplato", fotocartafile5);
                            carta5c.put("restauranteId", id);
                            carta5c.saveInBackground();
                        }
                    }
                });

            }
            if (TextUtils.isEmpty(nombreplato6C)) {
                Log.d("delacalle", "nombre plato vacio");
            } else {
                ParseQuery<ParseObject> carta6q = ParseQuery.getQuery("carta");
                carta6q.whereEqualTo("restauranteId",id);
                carta6q.setSkip(5);
                carta6q.getFirstInBackground(new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject carta6, ParseException e) {
                        if(e==null)
                        {
                            carta6.put("nombre", nombreplato6C);
                            carta6.put("descripcion", descripcionplato6C);
                            carta6.put("precio", precioplato6C);
                            carta6.put("fotoplato", fotocartafile6);
                            carta6.put("restauranteId", id);
                            carta6.saveInBackground();
                        }
                        else if(e.getCode() == ParseException.OBJECT_NOT_FOUND)
                        {
                            ParseObject carta6c = new ParseObject("carta");
                            carta6c.put("nombre", nombreplato6C);
                            carta6c.put("descripcion", descripcionplato6C);
                            carta6c.put("precio", precioplato6C);
                            carta6c.put("fotoplato", fotocartafile6);
                            carta6c.put("restauranteId", id);
                            carta6c.saveInBackground();
                        }
                    }
                });


            }


            Toast.makeText(getApplicationContext(), "Guardado", Toast.LENGTH_SHORT).show();
            Log.d("delacalle", "Carta Actualizada");
            Intent intent = new Intent(editarcartarestaurante_delacalleactivity.this, menu_pestanas_delacalleactivity.class);
            startActivity(intent);

        }catch(Exception e)
        {
            e.getStackTrace();
            Log.d("delacalle", "error en guardar carta editar");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_editarcartarestaurante_delacalleactivity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

      /*  //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
*/

        if(id == R.id.action_actualizar)
        {
            ParseQuery<ParseRole> queryrol = ParseRole.getQuery();
            queryrol.whereEqualTo("name", "responsable");
            queryrol.whereEqualTo("users", ParseUser.getCurrentUser().getObjectId());
            queryrol.getFirstInBackground(new GetCallback<ParseRole>() {
                @Override
                public void done(ParseRole rol, ParseException e) {
                    if (e == null) {
                          ActualizarCarta();
                      //  errors();
                    } else {
                        Toast.makeText(getApplicationContext(), "No puedes editar una carta si no eres un responsable", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }

    private void displayPopupFotoPlato1(final View anchorView) {
        try
        {
        final PopupWindow popup = new PopupWindow(editarcartarestaurante_delacalleactivity.this);
        LayoutInflater inflater = (LayoutInflater) editarcartarestaurante_delacalleactivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.popupfotos, null);
        popup.setContentView(layout);


        relativealbum = (RelativeLayout) layout.findViewById(R.id.relativelayoutAlbum);
        relativefoto = (RelativeLayout) layout.findViewById(R.id.relativelayoutTomarFoto);
        relativealbum.setClickable(true);
        relativefoto.setClickable(true);


        relativealbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectpic();
                popup.dismiss();
            }
        });

        relativefoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takephoto1();
                popup.dismiss();
            }
        });





        // Set content width and height
        popup.setHeight(400);
        popup.setWidth(400);
        // Closes the popup window when touch outside of it - when looses focus
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);
        // Show anchored to button
        //   popup.setBackgroundDrawable(new BitmapDrawable());
        new Handler().postDelayed(new Runnable() {

            public void run() {
                popup.showAtLocation(anchorView, Gravity.TOP | Gravity.START | Gravity.CENTER_VERTICAL, 120, 300);
                popup.showAsDropDown(anchorView);
            }
        }, 100L);

        }catch(Exception e)
        {
            e.getStackTrace();
            Log.d("delacalle", "error en mostrar popup de fotos");
        }

    }

    private void displayPopupFotoPlato2(final View anchorView) {
        try
        {
        final PopupWindow popup = new PopupWindow(editarcartarestaurante_delacalleactivity.this);
        LayoutInflater inflater = (LayoutInflater) editarcartarestaurante_delacalleactivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.popupfotos, null);
        popup.setContentView(layout);


        relativealbum = (RelativeLayout) layout.findViewById(R.id.relativelayoutAlbum);
        relativefoto = (RelativeLayout) layout.findViewById(R.id.relativelayoutTomarFoto);
        relativealbum.setClickable(true);
        relativefoto.setClickable(true);


        relativealbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectpic2();
                popup.dismiss();
            }
        });

        relativefoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takephoto2();
                popup.dismiss();
            }
        });





        // Set content width and height
        popup.setHeight(400);
        popup.setWidth(400);
        // Closes the popup window when touch outside of it - when looses focus
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);
        // Show anchored to button
        //   popup.setBackgroundDrawable(new BitmapDrawable());
        new Handler().postDelayed(new Runnable() {

            public void run() {
                popup.showAtLocation(anchorView, Gravity.TOP | Gravity.START | Gravity.CENTER_VERTICAL, 120, 300);
                popup.showAsDropDown(anchorView);
            }
        }, 100L);

        }catch(Exception e)
        {
            e.getStackTrace();
            Log.d("delacalle", "error en mostrar popup de fotos");
        }

    }

    private void displayPopupFotoPlato3(final View anchorView) {
        try
        {
        final PopupWindow popup = new PopupWindow(editarcartarestaurante_delacalleactivity.this);
        LayoutInflater inflater = (LayoutInflater) editarcartarestaurante_delacalleactivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.popupfotos, null);
        popup.setContentView(layout);


        relativealbum = (RelativeLayout) layout.findViewById(R.id.relativelayoutAlbum);
        relativefoto = (RelativeLayout) layout.findViewById(R.id.relativelayoutTomarFoto);
        relativealbum.setClickable(true);
        relativefoto.setClickable(true);


        relativealbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectpic3();
                popup.dismiss();
            }
        });

        relativefoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takephoto3();
                popup.dismiss();
            }
        });





        // Set content width and height
        popup.setHeight(400);
        popup.setWidth(400);
        // Closes the popup window when touch outside of it - when looses focus
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);
        // Show anchored to button
        //   popup.setBackgroundDrawable(new BitmapDrawable());
        new Handler().postDelayed(new Runnable() {

            public void run() {
                popup.showAtLocation(anchorView, Gravity.TOP | Gravity.START | Gravity.CENTER_VERTICAL, 120, 300);
                popup.showAsDropDown(anchorView);
            }
        }, 100L);


        }catch(Exception e)
        {
            e.getStackTrace();
            Log.d("delacalle", "error en mostrar popup de fotos");
        }
    }

    private void displayPopupFotoPlato4(final View anchorView) {
        try
        {
        final PopupWindow popup = new PopupWindow(editarcartarestaurante_delacalleactivity.this);
        LayoutInflater inflater = (LayoutInflater) editarcartarestaurante_delacalleactivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.popupfotos, null);
        popup.setContentView(layout);


        relativealbum = (RelativeLayout) layout.findViewById(R.id.relativelayoutAlbum);
        relativefoto = (RelativeLayout) layout.findViewById(R.id.relativelayoutTomarFoto);
        relativealbum.setClickable(true);
        relativefoto.setClickable(true);


        relativealbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectpic4();
                popup.dismiss();
            }
        });

        relativefoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takephoto4();
                popup.dismiss();
            }
        });





        // Set content width and height
        popup.setHeight(400);
        popup.setWidth(400);
        // Closes the popup window when touch outside of it - when looses focus
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);
        // Show anchored to button
        //   popup.setBackgroundDrawable(new BitmapDrawable());
        new Handler().postDelayed(new Runnable() {

            public void run() {
                popup.showAtLocation(anchorView, Gravity.TOP | Gravity.START | Gravity.CENTER_VERTICAL, 120, 300);
                popup.showAsDropDown(anchorView);
            }
        }, 100L);

        }catch(Exception e)
        {
            e.getStackTrace();
            Log.d("delacalle", "error en mostrar popup de fotos");
        }
    }



    private void displayPopupFotoPlato5(final View anchorView) {
        try
        {
        final PopupWindow popup = new PopupWindow(editarcartarestaurante_delacalleactivity.this);
        LayoutInflater inflater = (LayoutInflater) editarcartarestaurante_delacalleactivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.popupfotos, null);
        popup.setContentView(layout);


        relativealbum = (RelativeLayout) layout.findViewById(R.id.relativelayoutAlbum);
        relativefoto = (RelativeLayout) layout.findViewById(R.id.relativelayoutTomarFoto);
        relativealbum.setClickable(true);
        relativefoto.setClickable(true);


        relativealbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectpic5();
                popup.dismiss();
            }
        });

        relativefoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takephoto5();
                popup.dismiss();
            }
        });





        // Set content width and height
        popup.setHeight(400);
        popup.setWidth(400);
        // Closes the popup window when touch outside of it - when looses focus
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);
        // Show anchored to button
        //   popup.setBackgroundDrawable(new BitmapDrawable());
        new Handler().postDelayed(new Runnable() {

            public void run() {
                popup.showAtLocation(anchorView, Gravity.TOP | Gravity.START | Gravity.CENTER_VERTICAL, 120, 300);
                popup.showAsDropDown(anchorView);
            }
        }, 100L);

        }catch(Exception e)
        {
            e.getStackTrace();
            Log.d("delacalle", "error en mostrar popup de fotos");
        }

    }

    private void displayPopupFotoPlato6(final View anchorView) {
        try
        {
        final PopupWindow popup = new PopupWindow(editarcartarestaurante_delacalleactivity.this);
        LayoutInflater inflater = (LayoutInflater) editarcartarestaurante_delacalleactivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.popupfotos, null);
        popup.setContentView(layout);


        relativealbum = (RelativeLayout) layout.findViewById(R.id.relativelayoutAlbum);
        relativefoto = (RelativeLayout) layout.findViewById(R.id.relativelayoutTomarFoto);
        relativealbum.setClickable(true);
        relativefoto.setClickable(true);


        relativealbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectpic6();
                popup.dismiss();
            }
        });

        relativefoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takephoto6();
                popup.dismiss();
            }
        });





        // Set content width and height
        popup.setHeight(400);
        popup.setWidth(400);
        // Closes the popup window when touch outside of it - when looses focus
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);
        // Show anchored to button
        //   popup.setBackgroundDrawable(new BitmapDrawable());
        new Handler().postDelayed(new Runnable() {

            public void run() {
                popup.showAtLocation(anchorView, Gravity.TOP | Gravity.START | Gravity.CENTER_VERTICAL, 120, 300);
                popup.showAsDropDown(anchorView);
            }
        }, 100L);

        }catch(Exception e)
        {
            e.getStackTrace();
            Log.d("delacalle", "error en mostrar popup de fotos");
        }

    }

    public void takephoto1()
    {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent, 1);
    }
    public void takephoto2()
    {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent, 2);
    }

    public void takephoto3()
    {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent, 3);
    }

    public void takephoto4()
    {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent, 4);
    }
    public void takephoto5()
    {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent, 5);
    }
    public void takephoto6()
    {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent, 6);
    }

    public void selectpic()
    {

        //select pic from gallery
        startActivityForResult(galleryIntent, IMAGEREQUESTCODE);
    }

    public void selectpic2()
    {

        //select pic from gallery
        startActivityForResult(galleryIntent, IMAGEREQUESTCODE2);
    }

    public void selectpic3()
    {

        //select pic from gallery
        startActivityForResult(galleryIntent, IMAGEREQUESTCODE3);
    }

    public void selectpic4()
    {

        //select pic from gallery
        startActivityForResult(galleryIntent, IMAGEREQUESTCODE4);
    }

    public void selectpic5()
    {

        //select pic from gallery
        startActivityForResult(galleryIntent, IMAGEREQUESTCODE5);
    }

    public void selectpic6()
    {

        //select pic from gallery
        startActivityForResult(galleryIntent, IMAGEREQUESTCODE6);
    }

    protected final void onActivityResult(final int requestCode,
                                          final int resultCode, final Intent i) {
        super.onActivityResult(requestCode, resultCode, i);


        // take pic

        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = i.getExtras();
            pic = (Bitmap) extras.get("data");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            pic.compress(Bitmap.CompressFormat.JPEG, 70, stream);

            byte[] data1 = stream.toByteArray();
            fotocartafile1 = new ParseFile("fotocartaplato1.jpg", data1);
            fotocartafile1.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {

                }
            });


            fotocartaplato1.setImageBitmap(pic);

        }

        if (requestCode == 2 && resultCode == RESULT_OK) {
            Bundle extras = i.getExtras();
            pic2 = (Bitmap) extras.get("data");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            pic2.compress(Bitmap.CompressFormat.JPEG, 70, stream);

            byte[] data1 = stream.toByteArray();
            fotocartafile2 = new ParseFile("fotocartaplato2.jpg", data1);
            fotocartafile2.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {

                }
            });


            fotocartaplato2.setImageBitmap(pic2);

        }

        if (requestCode == 3 && resultCode == RESULT_OK) {
            Bundle extras = i.getExtras();
            pic3 = (Bitmap) extras.get("data");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            pic3.compress(Bitmap.CompressFormat.JPEG, 70, stream);

            byte[] data1 = stream.toByteArray();
            fotocartafile3 = new ParseFile("fotocartaplato3.jpg", data1);
            fotocartafile3.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {

                }
            });


            fotocartaplato3.setImageBitmap(pic3);

        }

        if (requestCode == 4 && resultCode == RESULT_OK) {
            Bundle extras = i.getExtras();
            pic4 = (Bitmap) extras.get("data");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            pic4.compress(Bitmap.CompressFormat.JPEG, 70, stream);

            byte[] data1 = stream.toByteArray();
            fotocartafile4 = new ParseFile("fotocartaplato4.jpg", data1);
            fotocartafile4.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {

                }
            });


            fotocartaplato4.setImageBitmap(pic4);

        }

        if (requestCode == 5 && resultCode == RESULT_OK) {
            Bundle extras = i.getExtras();
            pic5 = (Bitmap) extras.get("data");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            pic5.compress(Bitmap.CompressFormat.JPEG, 70, stream);

            byte[] data1 = stream.toByteArray();
            fotocartafile5 = new ParseFile("fotocartaplato5.jpg", data1);
            fotocartafile5.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {

                }
            });


            fotocartaplato5.setImageBitmap(pic5);

        }

        if (requestCode == 6 && resultCode == RESULT_OK) {
            Bundle extras = i.getExtras();
            pic6 = (Bitmap) extras.get("data");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            pic6.compress(Bitmap.CompressFormat.JPEG, 70, stream);

            byte[] data1 = stream.toByteArray();
            fotocartafile6 = new ParseFile("fotocartaplato6.jpg", data1);
            fotocartafile6.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {

                }
            });


            fotocartaplato6.setImageBitmap(pic6);

        }

        if(requestCode == IMAGEREQUESTCODE && resultCode == RESULT_OK)
        {

            manageImageFromUri1(i.getData());

        }
        else
        {
            Log.d("DeLaCalle", "Error en seleccionar la foto");
        }

        if(requestCode == IMAGEREQUESTCODE2 && resultCode == RESULT_OK)
        {

            manageImageFromUri2(i.getData());

        }
        else
        {
            Log.d("DeLaCalle", "Error en seleccionar la foto");
        }

        if(requestCode == IMAGEREQUESTCODE3 && resultCode == RESULT_OK)
        {

            manageImageFromUri3(i.getData());

        }
        else
        {
            Log.d("DeLaCalle", "Error en seleccionar la foto");
        }

        if(requestCode == IMAGEREQUESTCODE4 && resultCode == RESULT_OK)
        {

            manageImageFromUri4(i.getData());

        }
        else
        {
            Log.d("DeLaCalle", "Error en seleccionar la foto");
        }

        if(requestCode == IMAGEREQUESTCODE5 && resultCode == RESULT_OK)
        {

            manageImageFromUri5(i.getData());

        }
        else
        {
            Log.d("DeLaCalle", "Error en seleccionar la foto");
        }

        if(requestCode == IMAGEREQUESTCODE6 && resultCode == RESULT_OK)
        {

            manageImageFromUri6(i.getData());

        }
        else
        {
            Log.d("DeLaCalle", "Error en seleccionar la foto");
        }
    }



    private void manageImageFromUri1(Uri imageUri) {
        Bitmap bitmap = null;

        try {
            bitmap = MediaStore.Images.Media.getBitmap(
                    this.getContentResolver(), imageUri);

        } catch (Exception e) {
            // Manage exception ...

        }

        if (bitmap != null) {
            // Here you can use bitmap in your application ...
            pic = bitmap;
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            pic.compress(Bitmap.CompressFormat.JPEG, 70, stream);

            byte[] data = stream.toByteArray();
            fotocartafile1 = new ParseFile("fotocartaplato1.jpg",data);
            fotocartafile1.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {


                }
            });
            fotocartaplato1.setImageBitmap(pic);


        }
        else
        {
            Log.d("Delacalle", "Error bitmap  null");
        }
    }

    private void manageImageFromUri2(Uri imageUri) {
        Bitmap bitmap = null;

        try {
            bitmap = MediaStore.Images.Media.getBitmap(
                    this.getContentResolver(), imageUri);

        } catch (Exception e) {
            // Manage exception ...

        }

        if (bitmap != null) {
            // Here you can use bitmap in your application ...
            pic2 = bitmap;
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            pic2.compress(Bitmap.CompressFormat.JPEG, 70, stream);

            byte[] data = stream.toByteArray();
            fotocartafile2 = new ParseFile("fotocartaplato2.jpg",data);
            fotocartafile2.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {


                }
            });
            fotocartaplato2.setImageBitmap(pic2);


        }
        else
        {
            Log.d("Delacalle", "Error bitmap  null");
        }
    }

    private void manageImageFromUri3(Uri imageUri) {
        Bitmap bitmap = null;

        try {
            bitmap = MediaStore.Images.Media.getBitmap(
                    this.getContentResolver(), imageUri);

        } catch (Exception e) {
            // Manage exception ...

        }

        if (bitmap != null) {
            // Here you can use bitmap in your application ...
            pic3 = bitmap;
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            pic3.compress(Bitmap.CompressFormat.JPEG, 70, stream);

            byte[] data = stream.toByteArray();
            fotocartafile3 = new ParseFile("fotocartaplato3.jpg",data);
            fotocartafile3.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {


                }
            });
            fotocartaplato3.setImageBitmap(pic3);


        }
        else
        {
            Log.d("Delacalle", "Error bitmap  null");
        }
    }

    private void manageImageFromUri4(Uri imageUri) {
        Bitmap bitmap = null;

        try {
            bitmap = MediaStore.Images.Media.getBitmap(
                    this.getContentResolver(), imageUri);

        } catch (Exception e) {
            // Manage exception ...

        }

        if (bitmap != null) {
            // Here you can use bitmap in your application ...
            pic4 = bitmap;
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            pic4.compress(Bitmap.CompressFormat.JPEG, 70, stream);

            byte[] data = stream.toByteArray();
            fotocartafile4 = new ParseFile("fotocartaplato4.jpg",data);
            fotocartafile4.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {


                }
            });
            fotocartaplato4.setImageBitmap(pic4);


        }
        else
        {
            Log.d("Delacalle", "Error bitmap  null");
        }
    }

    private void manageImageFromUri5(Uri imageUri) {
        Bitmap bitmap = null;

        try {
            bitmap = MediaStore.Images.Media.getBitmap(
                    this.getContentResolver(), imageUri);

        } catch (Exception e) {
            // Manage exception ...

        }

        if (bitmap != null) {
            // Here you can use bitmap in your application ...
            pic5 = bitmap;
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            pic5.compress(Bitmap.CompressFormat.JPEG, 70, stream);

            byte[] data = stream.toByteArray();
            fotocartafile5 = new ParseFile("fotocartaplato5.jpg",data);
            fotocartafile5.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {


                }
            });
            fotocartaplato5.setImageBitmap(pic5);


        }
        else
        {
            Log.d("Delacalle", "Error bitmap  null");
        }
    }

    private void manageImageFromUri6(Uri imageUri) {
        Bitmap bitmap = null;

        try {
            bitmap = MediaStore.Images.Media.getBitmap(
                    this.getContentResolver(), imageUri);

        } catch (Exception e) {
            // Manage exception ...

        }

        if (bitmap != null) {
            // Here you can use bitmap in your application ...
            pic6 = bitmap;
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            pic6.compress(Bitmap.CompressFormat.JPEG, 70, stream);

            byte[] data = stream.toByteArray();
            fotocartafile6 = new ParseFile("fotocartaplato6.jpg",data);
            fotocartafile6.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {


                }
            });
            fotocartaplato6.setImageBitmap(pic6);


        }
        else
        {
            Log.d("Delacalle", "Error bitmap  null");
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        // or call onBackPressed()
        return true;
    }

    // Ocultar el teclado
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

    public void errors()
    {
        boolean cancel = false;

        if((fotocartafile2 == null) && (nombreplato2 != null))
        {
            Toast.makeText(getApplicationContext(), "Es necesario guardar una foto del segundo plato", Toast.LENGTH_SHORT).show();
             cancel = true;
            focusView = nombreplato2;
        }

        if((fotocartafile3 == null) && (nombreplato3 != null))
        {
            Toast.makeText(getApplicationContext(), "Es necesario guardar una foto del tercero plato", Toast.LENGTH_SHORT).show();
            cancel = true;
            focusView = nombreplato3;
        }

        if((fotocartafile4 == null) && (nombreplato4 != null))
        {
            Toast.makeText(getApplicationContext(), "Es necesario guardar una foto del cuarto plato", Toast.LENGTH_SHORT).show();
            cancel = true;
            focusView = nombreplato4;
        }

        if((fotocartafile5 == null) && (nombreplato5 != null))
        {
            Toast.makeText(getApplicationContext(), "Es necesario guardar una foto del quinto plato", Toast.LENGTH_SHORT).show();
            cancel = true;
            focusView = nombreplato5;
        }

        if((fotocartafile6 == null) && (nombreplato6 != null))
        {
            Toast.makeText(getApplicationContext(), "Es necesario guardar una foto del sexto plato", Toast.LENGTH_SHORT).show();
            cancel = true;
            focusView = nombreplato6;
        }


        if(cancel)
        {
            focusView.requestFocus();
        }
        else
        {
            ActualizarCarta();
        }

    }


}



