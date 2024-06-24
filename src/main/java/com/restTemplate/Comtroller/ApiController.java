package com.restTemplate.Comtroller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.restTemplate.Entity.Cities;
import com.restTemplate.Entity.Country;
import com.restTemplate.Entity.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ApiController {
    @GetMapping("/cities")
    public List<Country> getCity() {
        RestTemplate rsttmp = new RestTemplate();
        String uri = "https://countriesnow.space/api/v0.1/countries";

        //List<ResponseData> rsda=  rsttmp.getForObject(uri, ResponseData.class);


        Object[] obj = new Object[]{rsttmp.getForObject(uri, ResponseData.class)};
        ObjectMapper objmap = new ObjectMapper();


        List<Country> countries = Arrays.stream(obj).map(o -> objmap.convertValue(o, ResponseData.class)).map(ResponseData::getData).collect(Collectors.toList()).get(0);


        //List<Country> countries = collect.stream().map(r -> objmap.convertValue(r, Country.class)).collect(Collectors.toList());


        return countries;
    }
    @GetMapping("/Country/{Country}")
    public List<Country> getCityByCountry(@PathVariable(name = "Country")  String Country) {
        RestTemplate rsttmp = new RestTemplate();
        String uri = "https://countriesnow.space/api/v0.1/countries";

        //List<ResponseData> rsda=  rsttmp.getForObject(uri, ResponseData.class);


        Object[] obj = new Object[]{rsttmp.getForObject(uri, ResponseData.class)};
        ObjectMapper objmap = new ObjectMapper();


        List<Country> countries = Arrays.stream(obj).map(o -> objmap.convertValue(o, ResponseData.class)).map(ResponseData::getData)
                .collect(Collectors.toList()).get(0);

        List<Country> cityByCountry = countries.stream().filter(country-> country.getCountry().equalsIgnoreCase(Country)).collect(Collectors.toList());

        //List<Country> countries = collect.stream().map(r -> objmap.convertValue(r, Country.class)).collect(Collectors.toList());


        return cityByCountry;
    }
}
