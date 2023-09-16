package com.playtable.customer.domain.entity;

import com.playtable.customer.domain.request.CustomerRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Table(name = "customers")
@Entity @AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @Getter
public class Customer {
    @Id
    private UUID userId;
    private String name;
    private String nickName;
    private String contact;
    private String profileUrl;

    public void update(CustomerRequest request) {
        this.name = name;
        this.nickName = nickName;
        this.contact = contact;
        this.profileUrl = profileUrl;
    }
}
