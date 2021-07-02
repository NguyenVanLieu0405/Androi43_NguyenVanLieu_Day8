package com.example.foodorder;

public class LoginPresenter {
    ILogin iLogin;

    public LoginPresenter(ILogin iLogin) {
        this.iLogin = iLogin;
    }
    public void onLogin(String username, String password){
        if (username.equals("lieu0405")&&password.equals("123456")) iLogin.onLoginSuccessful("Login thành công");
        else iLogin.onLoginError("Login thất bại");
    }
}
