package com.playtable.customer.domain.request;

import com.playtable.customer.domain.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class CustomerRequest {
    private UUID userId;
    private String name;
    private String nickName;
    private String contact;
    private String profileUrl;
    public Customer toEntity(){
        return Customer
                .builder()
                .userId(userId)
                .name(name)
                .nickName(nickName)
                .contact(contact)
                .profileUrl(profileUrl)
                .build();
    }
}
