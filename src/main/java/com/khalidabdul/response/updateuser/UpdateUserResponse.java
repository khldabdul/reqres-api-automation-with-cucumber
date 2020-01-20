package com.khalidabdul.response.updateuser;

import lombok.Data;

@Data
public class UpdateUserResponse {
    public String name;
    private String job;
    private String updatedAt;
}