package com.example.lukasz_2.kurierai.Model;

public class List {
    private Integer Id_List;
    private Integer Id_product;

    public List(Integer id_List, Integer id_product) {
        Id_List = id_List;
        Id_product = id_product;
    }
    public static class Bulider_List{
        private Integer Id_List;
        private Integer Id_product;

        public Bulider_List() {
            Id_List = 0;
            Id_product = 0;
        }
        public Integer getId_List() {
            return Id_List;
        }

        public void setId_List(Integer id_List) {
            Id_List = id_List;
        }

        public Integer getId_product() {
            return Id_product;
        }

        public void setId_product(Integer id_product) {
            Id_product = id_product;
        }

        public List bulid(){
            return new List(getId_List(),
                    getId_product());
        }
    }


}
