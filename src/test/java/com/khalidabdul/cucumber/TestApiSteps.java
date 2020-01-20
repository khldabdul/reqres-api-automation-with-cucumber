package com.khalidabdul.cucumber;

import com.khalidabdul.api.UsersController;
import com.khalidabdul.data.UsersData;
import com.khalidabdul.response.deleteuser.DeleteUserResponse;
import com.khalidabdul.response.getresource.GetListResourceResponse;
import com.khalidabdul.response.getresource.GetSingleResourceResponse;
import com.khalidabdul.response.getuser.GetListUserResponse;
import com.khalidabdul.response.getuser.GetSingleUserResponse;
import com.khalidabdul.response.postregister.PostRegisterResponse;
import com.khalidabdul.response.updateuser.UpdateUserResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestApiSteps extends ScenarioSteps {

    // GIVEN
    @Given("test api set id to '(.*)'")
    public void test_api_set_id_to (String value) {
        UsersData.id = value;
    }

    @Given("set name to '(.*)'")
    public void set_name_to (String value) {
        UsersData.name = value;
    }

    @Given("set job to '(.*)'")
    public void set_job_to (String value) {
        UsersData.job = value;
    }

    @Given("set page to '(.*)'")
    public void set_page_to (String value)  {
        UsersData.page = value;
    }

    @Given("set per_page to '(.*)'")
    public void set_per_page_to (String value) {
        UsersData.per_page = value;
    }

    @Given("set email to '(.*)'")
    public void set_email_to (String value) {
        UsersData.email = value;
    }

    @Given("set password to '(.*)'")
    public void set_password_to (String value) {
        UsersData.password = value;
    }

    // WHEN
    @When("send get all user api")
    public void send_get_all_user_api () {
        GetListUserResponse response = UsersController.getListUser();
        System.out.println(response);
    }

    @When("send get user api")
    public void send_get_user_api () {
        GetSingleUserResponse response = UsersController.getUser();
        System.out.println(response);
    }

    @When("send get single resource")
    public void send_get_single_resource () {
        GetSingleResourceResponse response = UsersController.getResource();
        System.out.println((response.toString()));
    }

    @When("send get list resource")
    public void set_get_list_resource () {
        GetListResourceResponse response = UsersController.getListResource();
        System.out.println(response);
    }

    @When("send delete user api")
    public void send_delete_user_api () {
        DeleteUserResponse response = UsersController.deleteUser();
        System.out.println(response);
    }

    @When("send update user api")
    public void send_update_user_api () {
        UpdateUserResponse response = UsersController.updateUser();
        System.out.println(response);
    }

    @When("send post register user api")
    public void send_post_register_user_api () {
        PostRegisterResponse response = UsersController.postRegister();
        System.out.println(response);
    }


    // THEN
    @Then("get user api response equals with request")
    public void get_user_api_response_equals_with_request () {
        GetSingleUserResponse response = UsersController.getUser();
        assertThat(String.valueOf(response.getData().getId()), equalTo(UsersData.id));
//        usersData.setId(response.getData().getId());
    }

    @Then("get list user api response equals with request")
    public void get_list_user_api_response_equals_with_request () {
        GetListUserResponse response = UsersController.getListUser();
        assertThat(String.valueOf(response.getPage()), equalTo(UsersData.page));
        assertThat(String.valueOf(response.getPer_page()), equalTo(UsersData.per_page));
    }

    @Then("get single resource api response equals with request")
    public void get_single_resource_api_response_equals_with_request () {
        GetSingleResourceResponse response = UsersController.getResource();
        assertThat(response.getData().getId(), equalTo(Integer.valueOf(UsersData.id)));
    }

    @Then("update user api response equals with name request")
    public void update_user_api_response_equals_with_name_request () {
        UpdateUserResponse response = UsersController.updateUser();
        assertThat(response.getName(), equalTo(UsersData.name));
        assertThat(response.getJob(), equalTo(UsersData.job));
        System.out.println(response);
    }

    @Then("post register user response equals with request")
    public void post_register_user_response_equals_with_request () {
        PostRegisterResponse response = UsersController.postRegister();
        System.out.println(response);
    }
}