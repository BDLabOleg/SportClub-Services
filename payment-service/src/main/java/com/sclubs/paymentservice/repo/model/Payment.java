package com.sclubs.paymentservice.repo.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public final class Payment {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String TransId;
        private String userId;
        private long amount;


        public Payment() {
        }

        public Payment(String TransId, String userId, long amount) {
            this.TransId = TransId;
            this.userId = userId;
            this.amount = amount;
        }

        public long getId() {
            return id;
        }

        public String getTransId() {
            return TransId;
        }

        public String getuserId() {
            return userId;
        }

        public long getAmount() {
            return amount;
        }

        public void setId(long id) {
            this.id = id;
        }

        public void setTransId(String TransId) {
            this.TransId = TransId;
        }

        public void setuserId(String userId) {
            this.userId = userId;
        }

        public void setAmount(long amount) {
            this.amount = amount;
        }

}



