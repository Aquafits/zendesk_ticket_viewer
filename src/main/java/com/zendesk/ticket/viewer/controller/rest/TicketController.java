package com.zendesk.ticket.viewer.controller.rest;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @GetMapping("")
    public Object getTickets(@RequestParam(name = "per_page") int perPage, @RequestParam int page, @RequestHeader("Authorization") String basicAuthString) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://zcc-haominqiu.zendesk.com/api/v2/tickets?per_page=%d&page=%d", perPage, page))
                .method("GET", null)
                .addHeader("Authorization", basicAuthString)
                .addHeader("Content-Type", "application/json")
                .build();

        Map<String, Object> map = new HashMap<>();
        try {
            Response response = client.newCall(request).execute();
            map.put("status", response.code());
            map.put("data", response.body().string());
        } catch (IOException e) {
            map.put("status", 500);
            map.put("data", e.getMessage());
        }
        return map;
    }
}
