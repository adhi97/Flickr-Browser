package org.example.android.friends;

/**
 * Created by Adheesh on 6/26/16.
 */
public class Friend {
    private int _id;
    private String name;
    private String phone;
    private String email;
    private String facebook;
    private String github;

    public Friend(int _id, String name, String phone, String email, String facebook, String github) {
        this._id = _id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.facebook = facebook;
        this.github = github;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getFacebook() {

        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public int getId() {

        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
