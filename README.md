Kütüphane Envanter Yönetim Sistemi (LibraryInventory)

Bu proje, Spring Boot kullanarak geliştirilen bir kütüphane yönetim sistemi uygulamasıdır. Bu uygulama, yazarlar ve kitaplar arasındaki ilişkileri yönetmek için tasarlanmıştır. Kullanıcılar, yazarları ve kitapları ekleyebilir, güncelleyebilir, silebilir ve bu bilgileri listeleyebilir.

-Projenin Amacı
Bu projenin amacı, bir kütüphane sistemini dijital ortamda yönetmek için gerekli olan temel fonksiyonları sağlamaktır. Kullanıcılar, yazarların bilgilerini ve bu yazarlara ait kitapları sistemde tutabilir, bu bilgileri çeşitli API istekleri ile görüntüleyebilir.

-Proje Mimarisi
Proje, aşağıdaki bileşenlerden oluşmaktadır:

*Entity'ler: Veritabanındaki tabloları temsil eder. Bu projede Author ve Book adında iki temel entity bulunmaktadır.

*DTO'lar (Data Transfer Objects): API istekleri sırasında veri taşımak için kullanılır. Bu projede AuthorDetailsRequest ve BookDetailsRequest DTO'ları bulunmaktadır.

*Service Katmanı: İş mantığının yer aldığı katmandır. AuthorService ve BookService sınıfları, yazar ve kitaplar üzerindeki işlemleri yönetir.

*Controller Katmanı: API isteklerini karşılar ve ilgili service katmanındaki metodları çağırır. AuthorController ve BookController bu işlemleri yönetir.

*Repository Katmanı: Veritabanı ile etkileşimi sağlar. AuthorRepository ve BookRepository, Spring Data JPA kullanılarak oluşturulmuştur.

-Yazar API'leri

*Tüm Yazarları Getir
GET /authors
Tüm yazarları ve onlara ait kitapları listeler.

*ID'ye Göre Yazar Getir
GET /authors/{id}
Belirtilen ID'ye sahip yazarı ve ona ait kitapları getirir.

*Yazar Ekle
POST /authors
Yeni bir yazar ekler.

*Yazar Sil
DELETE /authors/{id}
Belirtilen ID'ye sahip yazarı siler.

-Kitap API'leri

*Tüm Kitapları Getir
GET /books
Tüm kitapları listeler.

*ID'ye Göre Kitap Getir
GET /books/{id}
Belirtilen ID'ye sahip kitabı getirir.

*Kitap Ekle
POST /books
Yeni bir kitap ekler.

*Kitap Sil
DELETE /books/{id}

Postman Kullanımı
Uygulamayı Postman gibi bir API istemcisi ile test edebilirsiniz. API isteklerini göndererek yazar ve kitap bilgilerini ekleyebilir, güncelleyebilir ve silebilirsiniz.
Aşağıda proje ile alakalı Postman collectionlarını bulabilirsiniz.
[LibraryManagement.postman_collection.json](https://github.com/user-attachments/files/16602496/LibraryManagement.postman_collection.json)



