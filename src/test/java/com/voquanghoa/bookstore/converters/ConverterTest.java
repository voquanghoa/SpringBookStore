package com.voquanghoa.bookstore.converters;


import com.voquanghoa.bookstore.converters.bases.Converter;
import com.voquanghoa.bookstore.exceptions.BadRequestException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

class SampleConverter extends Converter<String, Integer> {

    @Override
    public Integer convert(String source) throws BadRequestException {
        return Integer.parseInt(source);
    }
}

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
public class ConverterTest {

    @Test
    public void test_convert_List(){

        String[] numbers = new String[]{"1", "2", "3"};

        List<Integer> result = new SampleConverter().convert(Arrays.asList(numbers));

        assertEquals(result, Arrays.asList(1, 2, 3));
    }

}
