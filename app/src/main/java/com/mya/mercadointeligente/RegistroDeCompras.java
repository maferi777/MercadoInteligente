package com.mya.mercadointeligente;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegistroDeCompras extends AppCompatActivity {

    DatabaseReference myRef;
    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_de_compras);
        inicializacion();
        configuracionFirebase();
        leerFirebase();


    }

    private void configuracionFirebase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");
        

    }

    private void inicializacion(){
        editText = (EditText) findViewById(R.id.editTextMensaje);
        button = (Button) findViewById(R.id.buttonEnviar);
        textView = (TextView) findViewById(R.id.textViewMensaje);
    }

    public void escribirFirebase(View view){
        // Write a message to the database
        String mensaje = editText.getText().toString();
        myRef.setValue(mensaje);
        InputMethodManager tecladoVirtual = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE );
        tecladoVirtual.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

    private void leerFirebase(){
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                textView.setText(value);
                Log.i("TAG", "Value is: " + value);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.i("TAG", "Failed to read value.", error.toException());
            }
        });

    }
}
