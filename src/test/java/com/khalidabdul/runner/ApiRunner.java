package com.khalidabdul.runner;

import com.khalidabdul.api.UsersController;
import com.khalidabdul.data.UsersData;
import com.khalidabdul.response.deleteuser.DeleteUserResponse;
import com.khalidabdul.response.getresource.GetListResourceResponse;
import com.khalidabdul.response.getresource.GetSingleResourceResponse;
import com.khalidabdul.response.getuser.GetListUserResponse;
import com.khalidabdul.response.getuser.GetSingleUserResponse;
import com.khalidabdul.response.postregister.PostRegisterResponse;
import com.khalidabdul.response.updateuser.UpdateUserResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class ApiRunner {

    @Test
    public void getUser() {
        UsersData.id = "4";
        GetSingleUserResponse response = UsersController.getUser();
        assertThat(String.valueOf(response.getData().getId()), equalTo(UsersData.id));
        System.out.println(response.toString());
        System.out.println(response.getData().getAvatar());
    }

    @Test
    public void getListUser() {
        UsersData.page = "2";
        GetListUserResponse response = UsersController.getListUser();
        assertThat(String.valueOf(response.getPage()), equalTo(UsersData.page));
        System.out.println(response.toString());
    }

    @Test
    public void addUser() {
        UsersController.addUser();
    }

    @Test
    public void updateUser() {
        UsersData.name = "abdul";
        UsersData.job = "game maker";
        UpdateUserResponse response = UsersController.updateUser();
        assertThat(response.getName(), equalTo(UsersData.name));
        assertThat(response.getJob(), equalTo(UsersData.job));
        System.out.println(response.toString());
    }

    @Test
    public void deleteUser() {
        DeleteUserResponse response = UsersController.deleteUser();
        System.out.println(response);
    }

    @Test
    public void getResource() {
        UsersData.id = "2";
        GetSingleResourceResponse response = UsersController.getResource();
        assertThat(String.valueOf(response.getData().getId()), equalTo(UsersData.id));
        System.out.println(response);
    }

    @Test
    public void getListResource() {
        UsersData.page = "1";
        UsersData.per_page = "3";
        GetListResourceResponse response = UsersController.getListResource();
        assertThat(String.valueOf(response.getPage()), equalTo(UsersData.page));
        assertThat(String.valueOf(response.getPer_page()), equalTo(UsersData.per_page));
        System.out.println(response);
    }

    @Test
    public void postRegister() {
        PostRegisterResponse response = UsersController.postRegister();
        System.out.println(response);
    }
}
