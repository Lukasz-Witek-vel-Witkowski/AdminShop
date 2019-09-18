package com.example.lukasz_2.kurierai.Model;

public class News {
    private Integer Id;
    private String Description;
    private Integer Status;

    public News(Integer id, String description, Integer status) {
        Id = id;
        Description = description;
        Status = status;
    }
    public static class Bulider_News{
    
        private Integer Id;
    					private String Description;
    					private Integer Status;
   
   						public Bulider_News(){
            Id = 0;
            Description = "";
            Status = 0;
        }
        
        public void setId(Integer id){
            Id = id;
        }
        
        public void setDescription(String desc){
            Description = desc;
        }
        
        public void setStatus(Integer status){
            Status = status;
        }
        
        public Integer getId(){
            return Id;
        }
        
        public Integer getStatus(){
            return Status;
        }
        
        public String getDescription(){
            return Description;
        }
        
        public News bulid(){
            return new News(getId(),
            getDescription(),
            getStatus());
        }
        
    }
}
