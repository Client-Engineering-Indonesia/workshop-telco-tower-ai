Sekarang setelah Anda memiliki akun streamsets dan berhasil mengakses portal StreamSets Control Hub, langkah selanjutnya adalah melakukan deploy engine ke virtual machine (VM) Anda. Dalam workshop ini, Anda akan diberikan lingkungan VM TechZone untuk tujuan ini.

#### Streamsets Portal

Buat modular connection di tab connections
<img width="1285" alt="image" src="https://github.com/user-attachments/assets/3b3aebb7-0f31-4cd8-aa3e-f6c33f5901d5" />

1. **Kafka connection**
  - Masukkan `kafka` sebagai name dan type
  <img width="1280" alt="image" src="https://github.com/user-attachments/assets/326154c0-9f60-4a88-9c68-3c94607cf1fe" />
  
  - Pilih None (Security Protocol=PLAINTEXT) pada opsi security
    <img width="1280" alt="image" src="https://github.com/user-attachments/assets/71df3f8c-24f0-4fdd-a305-ecf484393f5e" />
    
  - Copy dan paste JDBC Connection String berikut
    ```text
    localhost:9092
    ```
    <img width="1280" alt="image" src="https://github.com/user-attachments/assets/a57a4c60-f312-425a-88f3-b3a44d5c532b" />

2. **Web client connection**
  - Masukkan `Risk Scoring Microservice` sebagai name dan `WebClient` sebagai type
    <img width="1280" alt="image" src="https://github.com/user-attachments/assets/b5262e9d-d97f-4f73-b185-d8aaf47a09f7" />

  - Masukkan URL `http://localhost:8000`, authentication scheme sebagai `None` dan Keystore `Automatic (for most HTTP and HTTPS requests)`. Lalu klik save
    <img width="1280" alt="image" src="https://github.com/user-attachments/assets/81c5867e-084f-4aa8-9c2c-d9a99c4d1eb7" />

3. **Postgres connection**
  - Masukkan `Postgres` sebagai name dan `JDBC` sebagai type
  <img width="1280" alt="image" src="https://github.com/user-attachments/assets/dcd3519e-db23-4756-9719-96380a297f37" />

  - Copy dan paste JDBC Connection String berikut
    ```text
    jdbc:postgresql://localhost:5432/postgres
    ```
    <img width="1280" alt="image" src="https://github.com/user-attachments/assets/38aaa224-2d98-4365-85a0-8a22967169ba" />

  - Buat connection
    <img width="1280" alt="image" src="https://github.com/user-attachments/assets/26328010-349c-4f84-b054-4239b253dada" />

Dashboard semua connections sekarang:
<img width="1722" alt="image" src="https://github.com/user-attachments/assets/2bf92350-dc4a-4150-8566-84a2365acced" />

---

#### Virtual Machine Portal
Pada workshop ini, kita akan menggunakan PostgreSQL untuk menyimpan data, jadi kita akan kembali ke VM portal untuk membuat tabel yang diperlukan. Karena Kafka sudah terinstall di VM, maka tidak perlu melakukan instalasi lagi.

1. **Postgres - Membuat tabel**
  - Masuk ke folder postgres, lalu copy dan paste script berikut
  ```python
  CREATE TABLE financial_transactions (
     transaction_id   VARCHAR(255),
     name             VARCHAR(255),
     address          VARCHAR(255),
     city             VARCHAR(255),
     state            VARCHAR(255),
     account_number   VARCHAR(255),
     account_type     VARCHAR(255),
     amount           DECIMAL(10, 2),
     risk_score       INTEGER,
     type             VARCHAR(255)
  );
  ```
  <img width="1281" alt="image" src="https://github.com/user-attachments/assets/e309c057-3083-4459-8087-ea2b30ab8792" />

