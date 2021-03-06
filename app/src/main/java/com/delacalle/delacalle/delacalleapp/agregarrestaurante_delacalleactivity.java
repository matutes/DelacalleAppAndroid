package com.delacalle.delacalle.delacalleapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
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
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
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

public class agregarrestaurante_delacalleactivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Toolbar mToolbar;



    private ImageView fotologoRestauranteA;
    private ImageView fotograndeRestauranteA;
    private TextView  nombreRestauranteA;
    private TextView  descripcionRestauranteA;
    private TextView  direccionRestauranteA;
    private TextView  telefonoRestauranteA;
    private TextView  webRestauranteA;
    private TextView  promocionRestauranteA;
    private TextView  horarioRestauranteA;
    private Spinner  spinnercategoria;
    private Spinner spinnercategoria2;
    private Spinner spinnerdomicilio;
    private Spinner spinnereventos;

    private Button btnGuardarRestaurante;
    private ImageView btnSeleccionarPaletaRestaurante;



    private ParseFile filefoto1;
    private ParseFile filefoto2;
    private ParseFile filefoto3;


    private String nombreR;
    private String descripcionR;
    private String direccionR;
    private String telefonoR;
    private String webR;
    private String categoriaR;
    private String categoria2R;
    private String domicilioR;
    private String eventoR;
    private String promocionR;
    private String horarioR;

    private Button btnpaleta;
    Bitmap bitmaperror2;
    Bitmap bitmaperror3;


    Bitmap pic;
    Bitmap pic2;
    Bitmap pic3;
    View focusView;

    //popup paleta
    private Button buttonColor1;
    private Button buttonColor2;
    private Button buttonColor3;
    private Button buttonColor4;
    private Button buttonColor5;
    private Button buttonColor6;
    private LinearLayout relativepaleta;
    String color;



    // Popup fotos
    RelativeLayout relativealbum;
    RelativeLayout relativefoto;


// Seleccionar la foto
    public static final int IMAGEREQUESTCODE = 45535;
    public static final int IMAGEREQUESTCODE2 = 45536;
    public static final int IMAGEREQUESTCODE3 = 45537;
    Intent galleryIntent;
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregarrestaurante_delacalleactivity);

        GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
        Tracker tracker = analytics.newTracker("UA-77841203-3");
        tracker.setScreenName("agregarrestaurante");
        tracker.send(new HitBuilders.ScreenViewBuilder().build());

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        final Typeface primerfontcandara = Typeface.createFromAsset(getAssets(), "fonts/CandaraBold.ttf");
        final Typeface segundafontcaviar = Typeface.createFromAsset(getAssets(), "fonts/CaviarDreams.ttf");


        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);

        galleryIntent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.INTERNAL_CONTENT_URI);

        bitmaperror2 = BitmapFactory.decodeResource(getResources(), R.drawable.agregar_foto);
        bitmaperror3 = BitmapFactory.decodeResource(getResources(), R.drawable.agregar_foto);

            relativepaleta = (LinearLayout) findViewById(R.id.relativelayoutPaletacambiar);

         fotologoRestauranteA = (ImageView) findViewById(R.id.imageViewfotoLogoA);
         fotograndeRestauranteA = (ImageView) findViewById(R.id.imageViewfotoRestauranteA);
         nombreRestauranteA = (TextView) findViewById(R.id.editTextNombreRestauranteA);
         descripcionRestauranteA = (TextView) findViewById(R.id.editTextDescripcionRestauranteA);
         direccionRestauranteA = (TextView) findViewById(R.id.editTextDireccionRestauranteA);
         telefonoRestauranteA = (TextView) findViewById(R.id.editTextTelefonoRestauranteA);
         webRestauranteA = (TextView) findViewById(R.id.editTextWebRestauranteA);
        promocionRestauranteA = (TextView) findViewById(R.id.editTextPromocionRestauranteA);
        horarioRestauranteA = (TextView) findViewById(R.id.editTextAbiertoRestauranteA);
        spinnercategoria = (Spinner) findViewById(R.id.spinnercategoria);
        spinnercategoria2 = (Spinner) findViewById(R.id.spinnercategoria2);
        spinnerdomicilio = (Spinner) findViewById(R.id.spinnerdomicilio);
        spinnereventos = (Spinner) findViewById(R.id.spinnereventos);

        nombreRestauranteA.setTypeface(segundafontcaviar);
        descripcionRestauranteA.setTypeface(segundafontcaviar);
        promocionRestauranteA.setTypeface(segundafontcaviar);
        direccionRestauranteA.setTypeface(segundafontcaviar);
        telefonoRestauranteA.setTypeface(segundafontcaviar);
        webRestauranteA.setTypeface(segundafontcaviar);
        horarioRestauranteA.setTypeface(segundafontcaviar);

    //    btnGuardarRestaurante = (Button) findViewById(R.id.btnGuardarRestaurante);
     //   btnGuardarRestaurante.setTypeface(primerfontcandara);
     //   btnSeleccionarPaletaRestaurante = (ImageView) findViewById(R.id.imageViewbtnPaletaRestaurante);
        fotologoRestauranteA.setClickable(true);
        fotograndeRestauranteA.setClickable(true);
  //      btnSeleccionarPaletaRestaurante.setClickable(true);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categoriasCrear, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnercategoria.setAdapter(adapter);
        spinnercategoria.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapterdomicilio = ArrayAdapter.createFromResource(this,
                R.array.domiciliosCrear, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerdomicilio.setAdapter(adapterdomicilio);
        spinnerdomicilio.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adaptercategoria2 = ArrayAdapter.createFromResource(this,
                R.array.categoriasCrear, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnercategoria2.setAdapter(adaptercategoria2);
        spinnercategoria2.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> adaptereventos = ArrayAdapter.createFromResource(this,
                R.array.eventosCrear, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnereventos.setAdapter(adaptereventos);
        spinnereventos.setOnItemSelectedListener(this);



     /*   final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
  //      frameLayout.getBackground().setAlpha(0);
        final FloatingActionsMenu fabMenu = (FloatingActionsMenu) findViewById(R.id.fabmenu);
        final FloatingActionButton fabeditar = (FloatingActionButton) findViewById(R.id.fabeditar);
        final FloatingActionButton  fabrestaurante = (FloatingActionButton) findViewById(R.id.fabagregar);
        final FloatingActionButton  fabperfil = (FloatingActionButton) findViewById(R.id.fabperfil);

        fabMenu.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {
        //        frameLayout.getBackground().setAlpha(240);
                frameLayout.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        fabMenu.collapse();
                        return true;
                    }
                });
            }

            @Override
            public void onMenuCollapsed() {
      //          frameLayout.getBackground().setAlpha(0);
                frameLayout.setOnTouchListener(null);
            }
        });

        fabeditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(agregarrestaurante_delacalleactivity.this, listarestaurantesresponsable_delacalleactivity.class);
                startActivity(intent);
            }
        });

        fabrestaurante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(agregarrestaurante_delacalleactivity.this, agregarrestaurante_delacalleactivity.class);
                startActivity(intent);
            }
        });

        fabperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(agregarrestaurante_delacalleactivity.this, perfilusuario_delacalleactivity.class);
                startActivity(intent);
            }
        });

        ParseQuery<ParseRole> roleuserusuario = ParseRole.getQuery();
        roleuserusuario.whereEqualTo("name", "usuario");
        roleuserusuario.whereEqualTo("users", ParseUser.getCurrentUser().getObjectId());
        roleuserusuario.getFirstInBackground(new GetCallback<ParseRole>() {
            @Override
            public void done(ParseRole object, ParseException e) {
                if (e == null) {
                    fabeditar.setVisibility(View.INVISIBLE);
                    fabrestaurante.setVisibility(View.INVISIBLE);
                } else if (e.getCode() == ParseException.OBJECT_NOT_FOUND) {
                    ParseQuery<ParseRole> roleuserresponsable = ParseRole.getQuery();
                    roleuserresponsable.whereEqualTo("name", "responsable");
                    roleuserresponsable.whereEqualTo("users", ParseUser.getCurrentUser().getObjectId());
                    roleuserresponsable.getFirstInBackground(new GetCallback<ParseRole>() {
                        @Override
                        public void done(ParseRole object, ParseException e) {
                            if (e == null) {
                                fabeditar.setVisibility(View.VISIBLE);
                                fabrestaurante.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                }

            }
        });*/




       /* btnSeleccionarPaletaRestaurante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayPopupPaleta();
            }
        });*/



      /*  btnGuardarRestaurante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                ParseQuery<ParseRole> queryrol = ParseRole.getQuery();
                queryrol.whereEqualTo("name", "responsable");
                queryrol.whereEqualTo("users", ParseUser.getCurrentUser().getObjectId());
                queryrol.getFirstInBackground(new GetCallback<ParseRole>() {
                    @Override
                    public void done(ParseRole rol, ParseException e) {
                        if (e == null)
                        {
                            errors();
                        } else {
                            Toast.makeText(getApplicationContext(), "No puedes guardar un restaurante si no eres un responsable", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });*/


        fotologoRestauranteA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
              //  takephoto1();
                displayPopupFotos1(v);

            }
        });

        fotograndeRestauranteA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
        //        takephoto2();
                displayPopupFotos2(v);

            }
        });





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
            filefoto1 = new ParseFile("fotologorestaurante.jpg", data1);
            filefoto1.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {

                }
            });


            fotologoRestauranteA.setImageBitmap(Bitmap.createScaledBitmap(pic, 578, 345, false));

        }

        if (requestCode == 2 && resultCode == RESULT_OK) {
            Bundle extras = i.getExtras();
            pic2 = (Bitmap) extras.get("data");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            pic2.compress(Bitmap.CompressFormat.JPEG, 70, stream);

            byte[] data1 = stream.toByteArray();
            filefoto2 = new ParseFile("fotogranderestaurante.jpg", data1);
            filefoto2.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {

                }
            });


            fotograndeRestauranteA.setImageBitmap(pic2);

        }

        if (requestCode == 3 && resultCode == RESULT_OK) {
            Bundle extras = i.getExtras();
            pic3 = (Bitmap) extras.get("data");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            pic3.compress(Bitmap.CompressFormat.JPEG, 70, stream);


            byte[] data1 = stream.toByteArray();
            filefoto3 = new ParseFile("fotorestaurantetres.jpg", data1);
            filefoto3.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {

                }
            });


        //    imageviewfoto3.setImageBitmap(Bitmap.createScaledBitmap(pic3,400,400,false));

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
            filefoto1 = new ParseFile("fotologorestaurante.jpg",data);
            filefoto1.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {


                }
            });
            fotologoRestauranteA.setImageBitmap(Bitmap.createScaledBitmap(pic, 578, 345, false));


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
            filefoto2 = new ParseFile("fotogranderestaurante.jpg",data);
            filefoto2.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {


                }
            });
            fotograndeRestauranteA.setImageBitmap(pic2);


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
            filefoto3 = new ParseFile("fotorestaurantetres.jpg",data);
            filefoto3.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {


                }
            });
      //      imageviewfoto3.setImageBitmap(Bitmap.createScaledBitmap(pic3,400,400,false));


        }
        else
        {
            Log.d("Delacalle", "Error bitmap  null");
        }
    }




    public void errors()
    {
        cleanerrors();
        boolean cancel = false;


        nombreR = nombreRestauranteA.getText().toString();
        descripcionR = descripcionRestauranteA.getText().toString();
        direccionR = direccionRestauranteA.getText().toString();
        telefonoR = telefonoRestauranteA.getText().toString();
        webR = webRestauranteA.getText().toString();
        promocionR = promocionRestauranteA.getText().toString();
        horarioR = horarioRestauranteA.getText().toString();

        if(TextUtils.isEmpty(nombreR))
        {
            nombreRestauranteA.setError("Es necesario escribir el nombre del restaurante");
            focusView = nombreRestauranteA;
            cancel = true;
        }

        if(TextUtils.isEmpty(descripcionR))
        {
            descripcionRestauranteA.setError("Es necesario escribir la descripción del restaurante");
            focusView = descripcionRestauranteA;
            cancel = true;
        }

        if(TextUtils.isEmpty(direccionR))
        {
            direccionRestauranteA.setError("Es necesario escribir la dirección del restaurante");
            focusView = direccionRestauranteA;
            cancel = true;
        }

        if(TextUtils.isEmpty(telefonoR))
        {
            telefonoRestauranteA.setError("Es necesario escribir el teléfono del restaurante");
            focusView = telefonoRestauranteA;
            cancel = true;
        }

        if(TextUtils.isEmpty(promocionR))
        {
            promocionRestauranteA.setError("Es necesario escribir la promoción de la membresia del club");
            focusView = promocionRestauranteA;
            cancel = true;
        }

        if(TextUtils.isEmpty(horarioR))
        {
            horarioRestauranteA.setError("Es necesario escribir el horario de atención del restaurante");
            focusView = horarioRestauranteA;
            cancel = true;
        }


       /* if(TextUtils.isEmpty(webR))
        {
            webRestauranteA.setError("Es necesario escribir la web");
            focusView = webRestauranteA;
            cancel = true;
        }*/



        if(filefoto1 == null)
        {
            Toast.makeText(getApplicationContext(), "Es necesario guardar una foto del logo del restaurante", Toast.LENGTH_SHORT).show();
            focusView = telefonoRestauranteA;
            cancel = true;
        }

        if(filefoto2 == null)
        {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmaperror2.compress(Bitmap.CompressFormat.JPEG, 70, stream);

            byte[] data = stream.toByteArray();
            filefoto2 = new ParseFile("fotogranderestaurante.jpg",data);
            filefoto2.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {


                }
            });
            fotograndeRestauranteA.setImageBitmap(bitmaperror2);
        }

        if(color == null)
        {
            /*Toast.makeText(getApplicationContext(), "Es necesario elegir un color", Toast.LENGTH_SHORT).show();
            focusView = telefonoRestauranteA;
            cancel = true;*/
            color = "#ffffff";
        }




        if(cancel)
        {
            focusView.requestFocus();
        }
        else
        {
            agregarRestaurante();
        }

    }

    public void cleanerrors()
    {
        nombreRestauranteA.setError(null);
        descripcionRestauranteA.setError(null);
        direccionRestauranteA.setError(null);
        telefonoRestauranteA.setError(null);
        webRestauranteA.setError(null);
        promocionRestauranteA.setError(null);
        horarioRestauranteA.setError(null);

    }

    public void agregarRestaurante()
    {

try
{

        ParseACL acl = new ParseACL();
        acl.setPublicWriteAccess(true);
        acl.setPublicReadAccess(true);


        final ParseObject  restauranteA = new ParseObject("restaurante");
        restauranteA.put("nombre",nombreR);
        restauranteA.put("descripcion",descripcionR);
        restauranteA.put("promo",promocionR);
        restauranteA.put("direccion",direccionR);
        restauranteA.put("telefono",telefonoR);
        restauranteA.put("web", webR);
        restauranteA.increment("rating", 0);
        restauranteA.put("fotologo", filefoto1);
        restauranteA.put("fotogrande", filefoto2);
        restauranteA.put("usuarioid", ParseUser.getCurrentUser());
        restauranteA.increment("votos", 0);
        restauranteA.put("color", color);
        restauranteA.put("categoria",categoriaR + "," + categoria2R);
        restauranteA.put("domicilio",domicilioR);
        restauranteA.put("eventos",eventoR);
        restauranteA.put("horario",horarioR);
        restauranteA.setACL(acl);
        ProgressDialog.show(this, "Guardando", "Espera mientras guarda el restaurante",true,true);

        restauranteA.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e== null) {
                    id = restauranteA.getObjectId().toString();
                    Intent intent = new Intent(agregarrestaurante_delacalleactivity.this, agregarcarta_delacalleactivity.class);
                    intent.putExtra("id", id);
                    agregarrestaurante_delacalleactivity.this.startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Guardado", Toast.LENGTH_SHORT).show();
                    Log.d("delacalle", "Restaurante creado");
                }
                else
                {
                    Log.d("delacalle", "Error al crear restaurante");
                }

            }
        });






      /*  Intent intent = new Intent(agregarrestaurante_delacalleactivity.this,agregarcarta_delacalleactivity.class);
        startActivity(intent);*/

}catch(Exception e)
{
    e.getStackTrace();
    Log.d("delacalle", "error en guardar restaurante");
}

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_agregarrestaurante_delacalleactivity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        if(id == R.id.action_mostrar)
        {
            Intent intent = new Intent(agregarrestaurante_delacalleactivity.this,mostrarrestaurante_delacalleactivity.class);
            startActivity(intent);
        }

        if(id == R.id.action_guardar)
        {
            ParseQuery<ParseRole> queryrol = ParseRole.getQuery();
            queryrol.whereEqualTo("name", "responsable");
            queryrol.whereEqualTo("users", ParseUser.getCurrentUser().getObjectId());
            queryrol.getFirstInBackground(new GetCallback<ParseRole>() {
                @Override
                public void done(ParseRole rol, ParseException e) {
                    if (e == null)
                    {
                        errors();
                    } else {
                        Toast.makeText(getApplicationContext(), "No puedes guardar un restaurante si no eres un responsable", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        if(id == R.id.action_color)
        {
            displayPopupPaleta();
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        // or call onBackPressed()
        return true;
    }





    private void displayPopupFotos1(final View anchorView) {
        try
        {
        final PopupWindow popup = new PopupWindow(agregarrestaurante_delacalleactivity.this);
        LayoutInflater inflater = (LayoutInflater) agregarrestaurante_delacalleactivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

    private void displayPopupFotos2(final View anchorView) {
        try
        {
        final PopupWindow popup = new PopupWindow(agregarrestaurante_delacalleactivity.this);
        LayoutInflater inflater = (LayoutInflater) agregarrestaurante_delacalleactivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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






    private void displayPopupPaleta() {
        try
        {
        final PopupWindow popup = new PopupWindow(agregarrestaurante_delacalleactivity.this);
        LayoutInflater inflater = (LayoutInflater) agregarrestaurante_delacalleactivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
   final     View layout = inflater.inflate(R.layout.popuppaleta, null);
        popup.setContentView(layout);


        buttonColor1 = (Button) layout.findViewById(R.id.btnColor1);
        buttonColor2 = (Button) layout.findViewById(R.id.btnColor2);
        buttonColor3 = (Button) layout.findViewById(R.id.btnColor3);
        buttonColor4 = (Button) layout.findViewById(R.id.btnColor4);
        buttonColor5 = (Button) layout.findViewById(R.id.btnColor5);
        buttonColor6 = (Button) layout.findViewById(R.id.btnColor6);





        buttonColor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativepaleta.setBackgroundColor(Color.parseColor("#b56497"));
                color = "#b56497";
                popup.dismiss();
            }
        });

        buttonColor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativepaleta.setBackgroundColor(Color.parseColor("#169c79"));
                color = "#169c79";
                popup.dismiss();
            }
        });

        buttonColor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativepaleta.setBackgroundColor(Color.parseColor("#f05543"));
                color = "#f05543";
                popup.dismiss();
            }
        });

        buttonColor4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativepaleta.setBackgroundColor(Color.parseColor("#da4f70"));
                color = "#da4f70";
                popup.dismiss();
            }
        });

        buttonColor5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativepaleta.setBackgroundColor(Color.parseColor("#41b7ab"));
                color = "#41b7ab";
                popup.dismiss();
            }
        });

        buttonColor6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               relativepaleta.setBackgroundColor(Color.parseColor("#f0bf59"));
                color = "#f0bf59";
                popup.dismiss();
            }
        });








        // Set content width and height
        popup.setHeight(600);
        popup.setWidth(400);
        // Closes the popup window when touch outside of it - when looses focus
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);
            popup.showAtLocation(layout, Gravity.TOP | Gravity.START | Gravity.CENTER_VERTICAL, 120, 300);
            popup.showAsDropDown(layout);
        // Show anchored to button
        //   popup.setBackgroundDrawable(new BitmapDrawable());
      /*  new Handler().postDelayed(new Runnable() {

            public void run() {


            }
        }, 100L);*/

        }catch(Exception e)
        {
            e.getStackTrace();
            Log.d("delacalle", "error en mostrar popup paleta de colores");
        }

    }

    // Ocultar el teclado
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
            Spinner spiner = (Spinner) parent;

        if(spiner.getId() == R.id.spinnercategoria)
        {
            categoriaR = spinnercategoria.getItemAtPosition(pos).toString();
        }

        if(spiner.getId() == R.id.spinnerdomicilio)
        {
            domicilioR = spinnerdomicilio.getItemAtPosition(pos).toString();
        }

        if(spiner.getId() == R.id.spinnercategoria2)
        {
            categoria2R = spinnercategoria2.getItemAtPosition(pos).toString();
        }

        if(spiner.getId() == R.id.spinnereventos)
        {
            eventoR = spinnereventos.getItemAtPosition(pos).toString();
        }

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
        View focusView = spinnercategoria;
        focusView.requestFocus();
        Toast.makeText(getApplicationContext(), "Selecciona una categoria por favor ", Toast.LENGTH_SHORT).show();
    }
}
