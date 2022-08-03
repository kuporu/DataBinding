package com.hgc.databindingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.text.Editable;
import android.widget.Toast;

import com.hgc.databindingdemo.modle.Goods;
import com.hgc.databindingdemo.modle.User;
import com.hgc.databindingdemo.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Goods goods;
    private User user;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        goods = new Goods("code", "hi", 24);
        user = new User("hgc", "1234");
        binding.setUserInfo(user);
        binding.setGoodsInfo(goods);
        binding.setGoodsHandlerInfo(new GoodsHandler());
        binding.setUserPresenterInfo(new UserPresenter());
    }

    public class GoodsHandler {

        public void changeGoodsName() {
            goods.setName("code" + new Random().nextInt(100));
            goods.setPrice(new Random().nextInt(100));
        }

        public void changeGoodsDetails() {
            goods.setName("hgc");
            goods.setDetails("hi" + new Random().nextInt(100));
            goods.setPrice(new Random().nextInt(100));
        }

    }

    public class UserPresenter {

        public void onUserNameClick(User user) {
            Toast.makeText(MainActivity.this, "用户名：" + user.getName(), Toast.LENGTH_LONG).show();
        }

        public void afterTextChanged(Editable s) {
            user.setName(s.toString());
            binding.setUserInfo(user);
        }

        public void afterUserPasswordChanged(Editable s) {
            user.setPassword(s.toString());
            binding.setUserInfo(user);
        }

    }
}