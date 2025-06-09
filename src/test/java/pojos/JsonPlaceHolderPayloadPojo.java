package pojos;

public class JsonPlaceHolderPayloadPojo {
    /*
    Icinde
    1) private variable (==>JSON datamizda key kısmı icin variable namei birebir ayni sekilde yazmaliyiz)
    2) parametreli ve parametresiz constructorlar
    3) getterlar ve setterlar
    4) toString() methodu
    barindiran classlara POJO class diyoruz
    POJO(Plain Old Java Object)
    Amacimiz => belirli bir cerceveye veya kısıtlamaya bağli kalmaksızın
    basit, ve yeniden kullanilabilir data tasıyıcı objectler olusturmaktir
     */

    // 1) private variable
    private Integer userId;
    private String title;
    private Boolean completed;

    //2) parametreli ve parametresiz constructorlar
    public JsonPlaceHolderPayloadPojo() {
        //Serialization ve De serialization islemleri icin arka planda ihtiyac duyuluyor
    }

    public JsonPlaceHolderPayloadPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    // 3) getterlar ve setterlar
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    // 4) toString() methodu
    @Override
    public String toString() {
        return "JsonPlaceHolderPayloadPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}