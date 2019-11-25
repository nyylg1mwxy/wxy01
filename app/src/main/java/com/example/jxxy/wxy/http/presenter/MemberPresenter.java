package com.example.jxxy.wxy.http.presenter;




import com.example.jxxy.wxy.http.HttpMethods;
import com.example.jxxy.wxy.http.entity.MemberEntity;


import rx.Observable;
import rx.Subscriber;


public class MemberPresenter extends com.example.jxxy.wxy.http.HttpMethods {
    public static void register(Subscriber<MemberEntity> subscriber, String username, String email, String password){
        Observable observable = memberService.register(username, password, email)
                .map(new HttpResultFunc<MemberEntity>());
        toSubscribe(observable, subscriber);
    }
    public static void login(Subscriber<MemberEntity> subscriber, String username, String password){
        Observable observable = memberService.login2(username, password)
                .map(new HttpMethods.HttpResultFunc<MemberEntity>());
        toSubscribe(observable, subscriber);
    }
    public static void changePassword(Subscriber subscriber, String memberId, String old_pwd, String new_pwd){
        Observable observable = memberService.changePassword(memberId, old_pwd, new_pwd);
        toSubscribe(observable, subscriber);
    }
}
