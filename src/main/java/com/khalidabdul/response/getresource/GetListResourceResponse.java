package com.khalidabdul.response.getresource;

import lombok.Data;

@Data
public class GetListResourceResponse {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public ResourceData[] data;
}
