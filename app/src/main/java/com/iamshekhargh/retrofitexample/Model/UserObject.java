package com.iamshekhargh.retrofitexample.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by <<-- iamShekharGH -->>
 * on 24/03/17.
 */

/**
 * JSON object :
 * {
 * "_id": "58d8aef6c03ecd7afd97c0ee",
 *  "user0": {
 *  "name": "ramesh",
 *  "password": "password0",
 *  "profession": "clerk",
 *  "id": 3
 *  }
 * }
 */
public class UserObject implements Parcelable {

    String username;
    String password;
    String profession;
    String _id;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.username);
        dest.writeString(this.password);
        dest.writeString(this.profession);
    }

    public UserObject() {
    }

    protected UserObject(Parcel in) {
        this.username = in.readString();
        this.password = in.readString();
        this.profession = in.readString();
    }

    public static final Creator<UserObject> CREATOR = new Creator<UserObject>() {
        @Override
        public UserObject createFromParcel(Parcel source) {
            return new UserObject(source);
        }

        @Override
        public UserObject[] newArray(int size) {
            return new UserObject[size];
        }
    };
}
