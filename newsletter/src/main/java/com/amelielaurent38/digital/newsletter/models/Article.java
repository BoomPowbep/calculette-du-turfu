package com.amelielaurent38.digital.newsletter.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Article implements Parcelable {

    //String image;
    String title;
    String description;

    public Article(String image, String title, String description) {
        //this.image = image;
        this.title = title;
        this.description = description;
    }

    /*public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        //dest.writeString(this.image);
        dest.writeString(this.title);
        dest.writeString(this.description);
    }

    protected Article(Parcel in) {
        //this.image = in.readString();
        this.title = in.readString();
        this.description = in.readString();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel source) {
            return new Article(source);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
