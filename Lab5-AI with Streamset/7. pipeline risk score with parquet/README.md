### Membuat Streaming Pipeline (Lanjutan)

Sebelumnya, Anda telah membuat stream pipeline yang memfilter data berdasarkan risk score—baik menyimpannya ke PostgreSQL atau membuangnya. Sekarang, sebagai Data Scientist, Anda perlu mengekspor data ini ke format Parquet untuk analisis lebih lanjut, biasanya untuk tugas prediksi machine learning. Pada pipeline yang diperbarui ini, kita akan menggunakan IBM Cloud Object Storage sebagai tujuan file Parquet.

---
### Koneksi sebagai parquet (Local file system/ Local FS)
Pipeline akhir akan terstruktur seperti berikut:

<img width="1020" alt="image" src="https://github.com/user-attachments/assets/1903e949-bba4-44d6-976f-36be0af783ea" />

- Tambahkan Stage
- Pilih Local FS
- Ubah nama menjadi **Datalake (Parquet)**
  
  <img width="1020" alt="image" src="https://github.com/user-attachments/assets/5570f5f8-2139-497d-8261-295a4ff6987b" />
  
- Copy dan Paste Directory Template
  ```text
  /tmp/transactions
  ```
- Masukkan **parquet** pada fFiles Suffix
  
<img width="1020" alt="image" src="https://github.com/user-attachments/assets/d9c10f13-2b5f-418b-8ee8-1c1944ae5cea" />

- Pada tab Data Format, ubah Data Format menjadi **Parquet**
- Ubah **Snappy** untuk Parquet Compression Codec
- Ubah **2.0** untuk Parquet Format Version
  
<img width="1020" alt="image" src="https://github.com/user-attachments/assets/a28b82a3-36d3-4269-977b-caaccadcc006" />

Jalankan pipeline:

<img width="1020" alt="image" src="https://github.com/user-attachments/assets/cd5d01ec-3c84-4dbd-99ee-a2852c429cf1" />

---

### Koneksi sebagai parquet (IBM COS)

<img width="1020" alt="image" src="https://github.com/user-attachments/assets/3f66e238-26dc-4b8f-bce0-c4d0421781cd" />

- Tambahkan Stage
- Pilih Amazon S3
- Masukkan kredensial **Access Key ID** dan **Secret Access Key** dari instruktur
- Centang Use Specific Region
- Masukkan Region sebagai **Other-Specify**
- Copy dan Paste Endpoint
  ```text
  s3.us-south.cloud-object-storage.appdomain.cloud
  ```
  
  <img width="1020" alt="image" src="https://github.com/user-attachments/assets/e00155e8-6672-4516-8c92-5c6428c6c6e2" />
  
- Centang Use Specific Region
- Masukkan Signin region sebagai **Other-Specify**
- Copy dan Paste Endpoint
  ```text
  us-south
  ```
- Masukkan bucket name sebagai **streamsets-demo**
  
<img width="1020" alt="image" src="https://github.com/user-attachments/assets/f4ef199c-d2d2-4800-8b87-288236d3ff55" />

Jalankan pipeline:

<img width="1020" alt="image" src="https://github.com/user-attachments/assets/c7af1635-3a63-4f88-9a52-621fc1877bc2" />


Setelah streaming pipeline Anda menulis ke IBM COS, Anda dapat menggunakan watsonx.data untuk memanfaatkan data tersebut untuk kebutuhan AI dan analitik:

<img width="1020" alt="image" src="https://github.com/user-attachments/assets/f7ac9838-0d64-47da-b968-754e04d9d243" />

---

### Validasi pipeline dan jalankan
### 1. Validasi Output Postgres
Buka Postgres:

```bash
sudo su - postgres
psql
```

Jalankan query berikut:

```sql
SELECT COUNT(*) FROM financial_transactions;
SELECT * FROM financial_transactions LIMIT 20;

SELECT state, AVG(risk_score) AS avg_risk_score, COUNT(*) AS num_transactions
FROM financial_transactions
GROUP BY state
ORDER BY avg_risk_score DESC
LIMIT 5;
```

### 2. Validasi Output Parquet

- Cek folder `/tmp/transactions` untuk output local FS
- Atau, cek bucket `streamsets-demo` di IBM COS untuk file `.parquet` yang di-upload
- Pastikan file dikompresi dengan `Snappy` dan mengikuti format Parquet 2.0

   Cek isi setiap parquet

