package id.co.imastudio.lab6ormlite.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.List;

import id.co.imastudio.lab6ormlite.DbHelper;
import id.co.imastudio.lab6ormlite.ModelAnggota;
import id.co.imastudio.lab6ormlite.R;

public class EditAnggotaActivity extends AppCompatActivity {

    private static final String TAG = "EditAnggotaActivity";
    private MaterialEditText edNama;
    private MaterialEditText edAlamar;
    private Button btnUpdateAnggota;
    private Button btnHapusAnggota;
    private DbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_anggota);

        //cara 1
        final int dataId = getIntent().getIntExtra("DATA_ID", 0);
        String dataNama = getIntent().getStringExtra("DATA_NAMA");
        String dataAlamat = getIntent().getStringExtra("DATA_ALAMAT");

        //cara 2
        List<ModelAnggota> listdata = (List<ModelAnggota>) getIntent().getSerializableExtra("DATA_ANGGOTA");
        int posisi =  getIntent().getIntExtra("DATA_POSISI", 0);
        Log.d(TAG, "onCreate: " + listdata.get(posisi).getNama());

        initView();

        edNama.setText(dataNama);
        edAlamar.setText(dataAlamat);

        dbHelper = new DbHelper(this);

        btnUpdateAnggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataNamaBaru = edNama.getText().toString();
                String dataAlamatBaru = edAlamar.getText().toString();

                ModelAnggota anggota = new ModelAnggota();
                anggota.setId(dataId);
                anggota.setNama(dataNamaBaru);
                anggota.setAlamat(dataAlamatBaru);

                int hasil = dbHelper.editData(anggota);

                if (hasil > 0){
                    Toast.makeText(EditAnggotaActivity.this, "Berhasil Diubah", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditAnggotaActivity.this, "Gagal Diubah", Toast.LENGTH_SHORT).show();
                }

                finish();
            }
        });

        btnHapusAnggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int hasil = dbHelper.hapusData(dataId);

                if (hasil > 0){
                    Toast.makeText(EditAnggotaActivity.this, "Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditAnggotaActivity.this, "Gagal Dihapus", Toast.LENGTH_SHORT).show();
                }

                finish();
            }
        });



    }

    private void initView() {
        edNama = (MaterialEditText) findViewById(R.id.ed_nama);
        edAlamar = (MaterialEditText) findViewById(R.id.ed_alamar);
        btnUpdateAnggota = (Button) findViewById(R.id.btn_update_anggota);
        btnHapusAnggota = (Button) findViewById(R.id.btn_hapus_anggota);
    }
}
