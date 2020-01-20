package com.khalidabdul.api;
import com.khalidabdul.data.UsersData;
import com.khalidabdul.request.adduser.AddSingleUserRequest;
import com.khalidabdul.request.getresource.GetListResourceRequest;
import com.khalidabdul.request.postregister.PostRegisterRequest;
import com.khalidabdul.request.updateuser.UpdateUserRequest;
import com.khalidabdul.response.deleteuser.DeleteUserResponse;
import com.khalidabdul.response.adduser.AddSingleUserResponse;
import com.khalidabdul.response.getresource.GetListResourceResponse;
import com.khalidabdul.response.getresource.GetSingleResourceResponse;
import com.khalidabdul.response.getuser.GetListUserResponse;
import com.khalidabdul.response.getuser.GetSingleUserResponse;
import com.khalidabdul.response.postregister.PostRegisterResponse;
import com.khalidabdul.response.updateuser.UpdateUserResponse;
import net.serenitybdd.rest.SerenityRest;

public class UsersController {

  public static GetSingleUserResponse getUser () {
    GetSingleUserResponse response = SerenityRest.given()
            .get("https://reqres.in/api/users/" + UsersData.id)
            .getBody().as(GetSingleUserResponse.class);
    return response;
  }

  public static GetListUserResponse getListUser () {
    String pageURL = "page="+UsersData.page + "&";
    String per_pageURL = "per_page="+UsersData.per_page + "&";

    GetListUserResponse response = SerenityRest.given()
            .get("https://reqres.in/api/users?"+ pageURL + per_pageURL)
            .getBody().as(GetListUserResponse.class);
    return response;
  }

  public static AddSingleUserResponse addUser () {
    AddSingleUserRequest request = new AddSingleUserRequest();
    request.setName(UsersData.name);
    request.setJob(UsersData.job);

    AddSingleUserResponse response =  SerenityRest.given()
            .header("Content-Type", "application/json")
            .body(request)
            .post("https://reqres.in/api/users")
            .getBody().as(AddSingleUserResponse.class);
    return response;
  }

  public static DeleteUserResponse deleteUser () {
    try {
      DeleteUserResponse response = SerenityRest.given()
              .header("Content-Type", "application/json")
              .delete("https://reqres.in/api/users/" + UsersData.id)
              .getBody().as(DeleteUserResponse.class);
      return response;

    } catch (Exception e) {
      return null;
    }
  }

  public static UpdateUserResponse updateUser () {

    UpdateUserRequest request = new UpdateUserRequest();
    request.setName(UsersData.name);
    request.setJob(UsersData.job);

    UpdateUserResponse response = SerenityRest.given()
            .header("Content-Type", "application/json")
            .body(request)
            .put("https://reqres.in/api/users/"+ UsersData.id)
            .getBody().as(UpdateUserResponse.class);
    return response;
  }

  public static GetSingleResourceResponse getResource () {
    GetSingleResourceResponse response = SerenityRest.given()
            .get("https://reqres.in/api/unknown/"+ UsersData.id)
            .getBody().as(GetSingleResourceResponse.class);
    return response;
  }

  public static GetListResourceResponse getListResource () {

//    GetListResourceRequest request = new GetListResourceRequest();
//    request.setPage(page);
//    request.setPer_page(per_page);
    String pageURL = "page="+UsersData.page + "&";
    String per_pageURL = "per_page="+UsersData.per_page + "&";

    GetListResourceResponse response = SerenityRest.given()
            .header("Content-Type", "application/json")
            .get("https://reqres.in/api/unknown/?"+pageURL+per_pageURL)
            .getBody().as(GetListResourceResponse.class);
    return response;
  }

  public static PostRegisterResponse postRegister () {
    PostRegisterRequest request = new PostRegisterRequest();
    request.setEmail(UsersData.email);
    request.setPassword(UsersData.password);

    PostRegisterResponse response = SerenityRest.given()
            .header("Content-Type", "application/json")
            .body(request)
            .post("https://reqres.in/api/register")
            .getBody().as(PostRegisterResponse.class);
    return response;
  }

}