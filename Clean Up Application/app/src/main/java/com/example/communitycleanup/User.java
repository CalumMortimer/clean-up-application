package com.example.communitycleanup;

public class User {
    private String username = " ";
    private String password = " ";
    private String email = " ";
    private String firstName = " ";
    private String lastName = " ";
    private int communityGroup = 0;

    public User()
    {
    }

    public User(String serial)
    {
        String[] split = serial.split("~");
        username = split[0];
        password = split[1];
        email = split[2];
        firstName = split[3];
        lastName = split[4];
        communityGroup = Integer.parseInt(split[5]);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCommunityGroup() {
        return communityGroup;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCommunityGroup(int communityGroup) {
        this.communityGroup = communityGroup;
    }

    public String getSerialData()
    {
        return username+"~"+password+"~"+email+"~"+firstName+"~"+lastName+"~"+communityGroup;
    }
}
