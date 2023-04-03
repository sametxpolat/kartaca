# KARTACA

## Case: Software Developer

---

### Author Information

```
{
  "type": "INFO",
  "name": "SAMET",
  "surname": "POLAT",
  "email": "sametxpolat@gmail.com",
  "registrationKey": "bc39aba5dfe399c3a18efa999e6f35a556a97c6acabe32ec8ca923aa88ed729f"
}
```

---

##### Not: Proje içerisinde frontend kısmı yoktur. Sadece backend yapılmıştır. Eğer test etmek isterseniz aşağıda pathler ve alacağı istek tipi yazılmıştır.

##### Not: docker-compose ayarlanmadığı için "kartaca@localhost" adında bir veri tabanı oluşturmanız gerekir. "application.properties" ve "RedisConfig.java" dökümanlarını düzenlemeniz gerekir.

##### Not: Otomatik olarak kullanıcı, kategori, ürünler, açık arttırmaya çıkarma ve teklif verilerini eklemek istiyorsanız: http://localhost:8080/optional pathine istek atmanız yeterli. Aşağıdaki örnekler veri isimlerinden oluşur.

---

Kayıt olmak için: http://localhost:8080/api/v1/user/set
```
{
  "name": "name01",
  "surname": "surname01",
  "email": "email01@ex.com",
  "nickname": "nickname01",
  "password": "pass01"
}
```

Giriş yapmak için: http://localhost:8080/api/v1/user/get
```
{
  "email": "email01@ex.com",
  "password": "pass01"
}

Geri dönüş olarak aşağıdaki JSON dönmektedir. "uniqueId" REDIS için benzersiz keydir. Bir sonraki istekte sadece bu key ile REDIS Cache'ten bilgileri gelmektedir.
{
  "id": 1,
  "uniqueId": "71031dc0-c29e-4a93-a353-7a3ccd9f0ae4",
  "name": "name01",
  "surname": "surname01",
  "nickname": "nickname01",
  "email": "email01@ex.com",
  "password": null
}
"password" hash algoritmasından geçerek kaydedilmektedir.
("password": "$2a$10$cwyLZ/GEuC24n/WQ82VMOeSKj6cCBrJt3787/HxOCJSgWmMmEZTaG")
```

Kullanıcıya ait ürünler eklemek için: http://localhost:8080/api/v1/product/set
```
{
  "name": "name01",
  "description": "desc01",
  "user": 1,
  "category": 1
}
"date" default eklenmektedir.
```

Kullanıcıya ait ürünleri listelemek için: http://localhost:8080/api/v1/product/user/{userId}
```
{
  "id": 1,
  "name": "prod01",
  "description": "desc01",
  "date": "2023-04-02T02:55:28.872869",
  "user": {
    "id": 1,
    "uniqueId": null,
    "nickname": "nickname01"
  },
  "category": {
    "id": 1,
    "name": "antique"
  }
}
```

Bir ürünü açık arttırmaya çıkarmak için: http://localhost:8080/api/v1/auction/set
```
{
  "startPrice": 500,
  "product": 1
}
İsterseniz "finishDate" ekleyebilirsiniz. "status" default olarak "true", "startDate" default eklenmektedir.
```

Açık arttırmadaki ürünleri görmek için: http://localhost:8080/api/v1/auction/get
```
{
  "id": 1,
  "startPrice": 500.00,
  "startDate": "2023-04-02T02:55:28.872869",
  "finishDate": "2023-04-02T02:55:28.872869",
  "status": true,
  "product": {
    "id": 1,
    "name": "prod01",
    "description": "desc01",
    "date": "2023-04-02T02:55:28.872869",
    "user": {
      "id": 1,
      "uniqueId": null,
      "nickname": "nickname01"
    },
    "category": {
      "id": 1,
      "name": "antique"
    }
  }
}
```

Bir ürüne teklif vermek için: http://localhost:8080/api/v1/bid/set
```
{
  "price": 800,
  "auction": 1,
  "user": 3
}
Sadece ürüne ait son tekliften yüksek teklifler geçerlidir. Diğer durumlarda hata mesajı döndürür.
```

---

#### Document Information
```
{
  "type": "INFO",
  "createDate": "21.03.2023",
  "format": "MarkDown (.md)"
}
```