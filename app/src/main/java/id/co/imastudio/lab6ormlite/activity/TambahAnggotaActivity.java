package id.co.imastudio.lab6ormlite.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import id.co.imastudio.lab6ormlite.DbHelper;
import id.co.imastudio.lab6ormlite.ModelAnggota;
import id.co.imastudio.lab6ormlite.R;

public class TambahAnggotaActivity extends AppCompatActivity {


    private MaterialEditText edAlamar;
    private Button btnTambahAnggota;
    private MaterialEditText edNama;

    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_anggota);
        initView();

        dbHelper = new DbHelper(this);

        btnTambahAnggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataNama = edNama.getText().toString();
                String dataAlamat = edAlamar.getText().toString();

                ModelAnggota anggota = new ModelAnggota();
                anggota.setNama(dataNama);
                anggota.setAlamat(dataAlamat);

                int hasil = dbHelper.tambahData(anggota);

                if (hasil > 0){
                    Toast.makeText(TambahAnggotaActivity.this, "Berhasil Ditambah", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TambahAnggotaActivity.this, "Gagal Ditambah", Toast.LENGTH_SHORT).show();
                }

                finish();

            }
        });

    }

    private void initView() {
        edAlamar = (MaterialEditText) findViewById(R.id.ed_alamar);
        btnTambahAnggota = (Button) findViewById(R.id.btn_tambah_anggota);
        edNama = (MaterialEditText) findViewById(R.id.ed_nama);
    }
}
