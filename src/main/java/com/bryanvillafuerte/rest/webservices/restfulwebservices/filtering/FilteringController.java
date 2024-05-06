package com.bryanvillafuerte.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        SomeBean someBean = new SomeBean("value 1", "value 2", "value 3");
        return createFilteredMappingJacksonValue(someBean, "field1", "field3");
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList() {
        List<SomeBean> list = Arrays.asList(new SomeBean("value 1", "value 2", "value 3"), new SomeBean("value 4", "value 5", "value 6"));
        return createFilteredMappingJacksonValue(list, "field2", "field3");
    }

    private MappingJacksonValue createFilteredMappingJacksonValue(Object data, String... fieldsToInclude) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(data);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fieldsToInclude);
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

}
