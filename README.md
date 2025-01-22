# Kitap Vadisi Test Projesi

Bu proje, Kitap Vadisi web sitesine yönelik manuel ve otomasyon test süreçlerini kapsamaktadır. Proje kapsamında, yazılım test süreçleriyle ilgili çeşitli teknikler ve araçlar kullanılmıştır.

## Proje İçeriği

1. **Manuel Test Süreci**  
   - **Fonksiyonel Testler**: Web sitesinin temel işlevlerinin doğruluğu test edilmiştir.  
   - **Kullanılabilirlik Testleri**: Kullanıcı deneyimi ve arayüz tasarımı analiz edilmiştir.  
   - **Hata Raporlama**: Tespit edilen hatalar detaylı bir şekilde raporlanmıştır.

2. **Otomasyon Test Süreci**  
   - **Araçlar ve Teknolojiler**:  
     - Java  
     - Selenium  
     - TestNG  
     - Allure Report  
   - **Test Senaryoları**:  
     - Giriş/çıkış işlemleri  
     - Ürün arama ve filtreleme  
     - Sepet yönetimi  
   - **Sonuçlar**: Otomasyon testleri ile belirlenen kritik senaryolar başarıyla doğrulanmıştır.

## Kullanılan Araçlar ve Teknolojiler

- **Java**: Test senaryolarının otomasyonu için kullanılmıştır.  
- **Selenium**: Web elementlerinin otomasyonu sağlanmıştır.  
- **TestNG**: Testlerin yönetimi ve yürütülmesi için kullanılmıştır.  
- **Allure Report**: Test sonuçlarının görselleştirilmesi ve raporlanması sağlanmıştır.  
- **Jira/Excel**: Manuel testler sırasında hata raporlaması yapılmıştır.  

## Kurulum ve Çalıştırma

1. **Gereksinimler**:  
   - Java 8 veya üzeri  
   - Selenium Kütüphanesi  
   - TestNG  
   - Allure Report Eklentisi  

2. **Projenin Çalıştırılması**:  
   ```bash
   git clone https://github.com/kullaniciadi/kitap-vadisi-test-projesi.git
   cd kitap-vadisi-test-projesi
   mvn clean test
   allure serve allure-results
