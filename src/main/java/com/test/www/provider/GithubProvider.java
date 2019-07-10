package com.test.www.provider;

import com.alibaba.fastjson.JSON;
import com.test.www.dto.AccessTokenDTO;
import com.test.www.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){

        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String backString = response.body().string();
            System.out.println(backString);
            //todo 用正则匹配出accesstoken
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.github.com/login/user?access_token" + accessToken)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String jsonString = response.body().string();
            GithubUser githubUser = JSON.parseObject(jsonString, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
        }
        return null;
    }

}
