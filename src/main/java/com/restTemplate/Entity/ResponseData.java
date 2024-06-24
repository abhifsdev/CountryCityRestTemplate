package com.restTemplate.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {

    private boolean error;
    private String msg;
    private List<Country> data;


}
