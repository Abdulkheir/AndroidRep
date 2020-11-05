package com.example.zanzibar;

public class UserProfile {
    private String regname;
    private String address;
    private String username;
    private String pasword;
    private String useremail;


    public UserProfile (){}

    public UserProfile(String regname, String address, String username, String pasword, String useremail) {

        this.regname = regname;
        this.address = address;
        this.username = username;
        this.pasword = pasword;
        this.useremail = useremail;

    }


    public String getRegname() {
        return regname;
    }

    public void setRegname(String regname) {
        this.regname = regname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }
}
