package com.playtable.customer.domain.response;

import com.playtable.customer.domain.entity.Customer;
import lombok.Data;

import java.util.UUID;

@Data
public class CustomerResponse {
    private UUID userId;
    private String name;
    private String nickName;
    private String contact;
    private String profileUrl;
    public static CustomerResponse fromEntity(Customer customer) {
        CustomerResponse response = new CustomerResponse();
        response.userId = customer.getUserId();
        response.name = customer.getName();
        response.nickName = customer.getNickName();
        response.contact = customer.getContact();
        response.profileUrl = customer.getProfileUrl();
        return response;
    }
}
