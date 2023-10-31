package com.example.servletdemo.model;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class  Student {
    private static final Gson gson = new Gson();
    private long id;
    private String firstName;
    private String lastName;
    private String email;

    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
