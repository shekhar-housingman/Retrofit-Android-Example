package com.iamshekhargh.retrofitexample.Model.response;

import com.iamshekhargh.retrofitexample.Model.User;

/**
 * Created by <<-- iamShekharGH -->>
 * on 28 March 2017
 * at 2:35 PM.
 */

public class UserResponse {

    /**
     * {
     * "_id": "58d8aef6c03ecd7afd97c0ee",
     * "user0": {
     * "name": "ramesh",
     * "password": "password0",
     * "profession": "clerk",
     * "id": 3
     * }
     * }
     */

    String _id;
    User user;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
