package com.khalidabdul.response.getuser;


import lombok.Data;

@Data
public class GetListUserResponse {
    public String page;
    public String per_page;
    public String total;
    public String total_pages;
    public ListUserData[] data;
}
