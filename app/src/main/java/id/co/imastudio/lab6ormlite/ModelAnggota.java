package id.co.imastudio.lab6ormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by idn on 1/24/2018.
 */

@DatabaseTable(tableName = "Anggota")
public class ModelAnggota implements Serializable {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String nama;

    @DatabaseField
    private String alamat;

    //constructor

    public ModelAnggota(int id, String nama, String alamat) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
    }

    public ModelAnggota() {
    }

    //getter setter

//    protected ModelAnggota(Parcel in) {
//        id = in.readInt();
//        nama = in.readString();
//        alamat = in.readString();
//    }
//
//    public static final Creator<ModelAnggota> CREATOR = new Creator<ModelAnggota>() {
//        @Override
//        public ModelAnggota createFromParcel(Parcel in) {
//            return new ModelAnggota(in);
//        }
//
//        @Override
//        public ModelAnggota[] newArray(int size) {
//            return new ModelAnggota[size];
//        }
//    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel parcel, int i) {
//        parcel.writeInt(id);
//        parcel.writeString(nama);
//        parcel.writeString(alamat);
//    }
}
