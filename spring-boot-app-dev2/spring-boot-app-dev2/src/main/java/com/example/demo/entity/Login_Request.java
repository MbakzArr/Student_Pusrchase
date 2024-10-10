package com.example.demo.entity;

public class Login_Request
{
    private String email;
    private String password;

    public Login_Request()
    {}

    public Login_Request(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setpassword(String password)
    {
        this.password = password;
    }
}
