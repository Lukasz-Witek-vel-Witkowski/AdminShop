package com.example.lukasz_2.kurierai.Model;

public class Message_Iteam {
    private Integer Id;
    private String Description;
    private Integer Status;
    private Integer Order;

    public Message_Iteam(Integer id, String description, Integer status, Integer order) {
        Id = id;
        Description = description;
        Status = status;
        Order = order;
    }
    public static class Bulider_Message_Iteam{
        private Integer Id;
        private String Description;
        private Integer Status;
        private Integer Order;

        public Bulider_Message_Iteam() {
            Id = 0;
            Description = "";
            Status = 0;
            Order = 0;
        }

        public Integer getId() {
            return Id;
        }

        public void setId(Integer id) {
            Id = id;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String description) {
            Description = description;
        }

        public Integer getStatus() {
            return Status;
        }

        public void setStatus(Integer status) {
            Status = status;
        }

        public Integer getOrder() {
            return Order;
        }

        public void setOrder(Integer order) {
            Order = order;
        }
        
        public Message_Iteam bulid(){
            return new Message_Iteam(getId(),
            getDescription(),
            getStatus(),
            getOrder());
        }
        
    }
}
