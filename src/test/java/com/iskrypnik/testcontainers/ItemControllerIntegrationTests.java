package com.iskrypnik.testcontainers;

import com.iskrypnik.testcontainers.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@AutoConfigureMockMvc
class ItemControllerIntegrationTests extends BaseIT {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Проверка на возвращаемый объект: по id = 1 возвращется объект с id = 1.")
    @Test
    void getItemById() throws Exception {
        MvcResult result = this.mockMvc.perform(get("/item/1"))
                .andReturn();
        String jsonResponse = result.getResponse().getContentAsString();

        Item expectedItem = new Item();
        expectedItem.setId(1);
        expectedItem.setDescription("this is first item");

        Item receivedItem = objectMapper.readValue(jsonResponse, Item.class);
        Assertions.assertEquals(expectedItem, receivedItem);
    }
}
