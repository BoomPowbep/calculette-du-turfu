package com.amelielaurent38.digital.testspinner.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Planete implements Parcelable {
    String image;
    String titre;
    String description;

    public Planete(String image, String titre, String description) {
        this.image = image;
        this.titre = titre;
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.image);
        dest.writeString(this.titre);
        dest.writeString(this.description);
    }

    protected Planete(Parcel in) {
        this.image = in.readString();
        this.titre = in.readString();
        this.description = in.readString();
    }

    public static final Parcelable.Creator<Planete> CREATOR = new Parcelable.Creator<Planete>() {
        @Override
        public Planete createFromParcel(Parcel source) {
            return new Planete(source);
        }

        @Override
        public Planete[] newArray(int size) {
            return new Planete[size];
        }
    };
}
