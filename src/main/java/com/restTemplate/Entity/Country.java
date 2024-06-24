package com.restTemplate.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.util.ViewMatcher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.View;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

//     private String iso2;
//     private String iso3;
    private String country;
    private String[] cities;
}
