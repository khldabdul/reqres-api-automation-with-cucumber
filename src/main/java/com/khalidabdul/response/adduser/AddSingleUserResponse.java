package com.khalidabdul.response.adduser;

import lombok.Data;

@Data

public class AddSingleUserResponse {
    private String name;
    private String job;
    private int id;
    private String createdAt;

}