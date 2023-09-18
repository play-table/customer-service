package com.playtable.customer.domain.entity;

import com.playtable.customer.domain.request.CustomerRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "customers")
@Entity @AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @Getter
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    private String name;
    private String nickName;
    private String contact;
    private String profileUrl;

    public void update(CustomerRequest request) {
        this.name = request.getName();
        this.nickName = request.getNickName();
        this.contact = request.getContact();
        this.profileUrl = request.getProfileUrl();
    }
}
