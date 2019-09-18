package com.example.lukasz_2.kurierai.Tools;

public class JSON  {
    private String url;
    private String localhost = "192.168.43.169";
    private String[] TabValue;
    private String[] TabParameter;
    public enum TYPE{
        Login,
        Register,
        Typ,
        Product
    }
    public enum OPERATION{
        Add,
        Delete,
        Edit
    }
    private void setURL(TYPE t){
       // System.out.println("Test1="+performanceOUT("Test#Test Test")+performanceIN("Test#Test Test") );
        switch(t){
            case Login:
                url = "http://"+localhost+":8080/RestServer/InterfaceSQLModerator?TypeOperation=Login";
                break;
            case Register:
                url = "http://"+localhost+":8080/RestServer/InterfaceSQLModerator?TypeOperation=Register";
                break;
            case Typ:
                url = "http://"+localhost+":8080/RestServer/InterfaceSQLProduct?";
                break;
            case Product:
                url = "http://"+localhost+":8080/RestServer/InterfaceSQLProduct?";
                break;
        }
    }

    public void GetLogin(String Login, String Password){
        TabValue = new String[2];
        TabValue[0] = Login;
        TabValue[1] = Password;
        TabParameter = new String[2];
        TabParameter[0] = "UID";
        TabParameter[1] = "PWD";
        setURL(TYPE.Login);
        getsend(TabValue,TabParameter,false);
    }
    private void getsend(String[] tabValue, String[] tabParameter, boolean b){
        int size = tabValue.length;
        if(tabValue.length==tabParameter.length){
            if(b == false) {
                for (int i = 0; i < size; i++) {
                    url += "&" + tabParameter[i] + "=" + tabValue[i];
                }
            }
            else{
                url += tabParameter[0] + "=" + tabValue[0];
                for (int i = 1; i < size; i++) {
                    url += "&" + tabParameter[i] + "=" + tabValue[i];
                }
            }
        }
        else{
            System.out.println("Problem z url!!");
        }
        System.out.println(url);
    }
    public void getType(OPERATION o, String Id, String Name, String Description, String size ){
        TabValue = new String[6];
        TabParameter = new String[6];
        TabValue[0] = performanceOUT(getOperation(o));
        TabValue[1] = "Type";
        TabValue[2] = performanceOUT(Id);
        TabValue[3] = performanceOUT(Name);
        TabValue[4] = performanceOUT(Description);
        TabValue[5] = size;
        TabParameter[0] = "TypeOperation";
        TabParameter[1] = "TypeObject";
        TabParameter[2] = "Id";
        TabParameter[3] = "Name";
        TabParameter[4] = "Description";
        TabParameter[5] = "ImgSize";
        setURL(TYPE.Typ);
        getsend(TabValue,TabParameter, true);
    }
    public void getProduct(OPERATION o, String Id, String Name, String Description,String Cost, String Type,String size ){
        TabValue = new String[8];
        TabParameter = new String[8];
        TabValue[0] = getOperation(o);
        TabValue[1] = "Product";
        TabValue[2] = performanceOUT(Id);
        TabValue[3] = performanceOUT(Name);
        TabValue[4] = performanceOUT(Description);
        TabValue[5] = performanceOUT(Cost);
        TabValue[6] = performanceOUT(Type);
        TabValue[7] = size;
        TabParameter[0] = "TypeOperation";
        TabParameter[1] = "TypeObject";
        TabParameter[2] = "Id";
        TabParameter[3] = "Name";
        TabParameter[4] = "Description";
        TabParameter[5] = "Cost";
        TabParameter[6] = "Type";
        TabParameter[7] = "ImgSize";
        setURL(TYPE.Product);
        getsend(TabValue,TabParameter, true);
    }
    private String getOperation(OPERATION o){
        switch(o){
            case Add:
                return "Add";
            case Edit:
                return "Edit";
            case Delete:
                return "Delete";
        }
        return "";
    }
    public void GetRegister(String firstName, String LastName, String login, String password) {
        TabValue = new String[4];
        TabValue[0] = performanceOUT(login);
        TabValue[1] = performanceOUT(password);
        TabValue[2] = performanceOUT(firstName);
        TabValue[3] = performanceOUT(LastName);
        TabParameter = new String[4];
        TabParameter[0] = "UID";
        TabParameter[1] = "PWD";
        TabParameter[2] = "FNA";
        TabParameter[3] = "LNA";
        setURL(TYPE.Register);
        getsend(TabValue,TabParameter, false);
    }
    public void getCellImageURL(int position, String tab){
        TabValue = new String[3];
        TabValue[0] = "Image";
        TabValue[1] = String.valueOf(position);
        TabValue[2] = tab;
        TabParameter = new String[3];
        TabParameter[0] = "TypeOperation";
        TabParameter[1] = "Par";
        TabParameter[2] = "Tab";
        setURL(TYPE.Product);
        getsend(TabValue,TabParameter,false);
    }
    public String getUrl() {
        return url;
    }
    private String performanceOUT(String data){
        return data.replace(' ','#');
    }
    private String performanceIN(String data){
        return data.replace('#',' ');
    }
}
