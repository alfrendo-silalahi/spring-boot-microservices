package com.eazybytes.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "accounts")
public class Accounts extends BaseEntity {
    
    @Column(name = "customer_id")
    private Long customerId;

    @Id
    @Column(name = "account_number")
    private long accountNumber;

    @Column(name = "account_type", columnDefinition = "varchar(100) NOT NULL")
    private String accountType;

    @Column(name = "branch_address", columnDefinition = "varchar(200) NOT NULL")
    private String branchAddress;

}
