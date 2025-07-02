# **_Watson Machine Learning_** with _**AutoAI**_
## 📖 Pendahuluan
Machine learning merupakan teknologi yang kini digunakan hampir di setiap aspek kehidupan kita. Contohnya, Netflix menggunakan machine learning untuk merekomendasikan film, sementara aplikasi seperti Waze memanfaatkannya untuk mengoptimalkan perjalanan kita.

Namun, kebutuhan terhadap data scientist yang memiliki berbagai keahlian seperti matematika, statistik, machine learning, database, visualisasi data, serta pemahaman domain masih sulit dipenuhi. Idealnya, data scientist seharusnya lebih banyak menghabiskan waktu pada tugas-tugas strategis yang berfokus pada wawasan dan analisis mendalam, bukan pada aktivitas teknis yang repetitif dan memakan waktu.

Untuk menjawab tantangan ini, IBM menghadirkan [AutoAI](https://www.ibm.com/products/watson-studio/autoai) sebagai bagian dari IBM Watson Studio. AutoAI adalah teknologi yang mengotomatisasi proses pembuatan model machine learning secara visual dan intuitif, baik untuk pengguna awam maupun ilmuwan data. Proses yang biasanya memerlukan waktu berhari-hari atau berminggu-minggu kini bisa diselesaikan dalam waktu yang jauh lebih singkat.

Fitur utama AutoAI antara lain:
- Pre-processing data
- Pemilihan model secara otomatis
- Optimisasi hyperparameter
- Integrasi pemantauan model (model monitoring)
- Dukungan validasi model 

## 🎯 Auto AI Workshop 
Workshop ini bertujuan untuk memperkenalkan cara menggunakan otomatisasi dalam pekerjaan sehari-hari di organisasi, dengan bantuan IBM Watson Studio dengan AutoAI.

Dalam workshop ini, peserta akan belajar:
- Mengimpor data ke dalam project
- Membersihkan dan menyiapkan data agar siap digunakan
- Membuat model machine learning secara otomatis dengan AutoAI
- Menghasilkan prediction model berdasarkan data yang ada

## Step 1: Membuat Project Watsonx
1. Buka halaman **IBM watsonx** di: https://dataplatform.cloud.ibm.com
2. Buka halaman **Projects** dengan membuka **Project > View all projects**
<img width="1440" alt="Screenshot 2025-07-02 at 12 45 29" src="https://github.com/user-attachments/assets/b5b63a84-c9c0-4613-9fd4-f5e546568505" />

3. Klik **New Project**

4. Isi **Detail Project**
- Masukkan nama project (contoh: `Auto AI - [Inisial]`) dan deskripsi project
- Pilih storage service yang tersedia
<img width="1440" alt="Screenshot 2025-07-02 at 12 47 53" src="https://github.com/user-attachments/assets/e5710e3a-5038-4589-9bfd-704dac3eab0f" />

5. Klik **Create** dan project Anda akan terbuat
<img width="1440" alt="Screenshot 2025-07-02 at 12 51 04" src="https://github.com/user-attachments/assets/ea07ed4d-df31-4b92-8e50-afa412d2e6ae" />


## Step 2: Menambahkan Datasource ke Project
1. **Download** file data source yang telah disediakan, yaitu file `telco_churn_data.csv` yang terdapat dalam folder `data`. 

**Tentang `telco_churn_data.csv`:**
Dataset ini berisi informasi pelanggan dari sebuah perusahaan telekomunikasi, termasuk layanan yang digunakan, lama berlangganan, biaya bulanan, dan status churn (apakah pelanggan berhenti atau tetap berlangganan). Dataset ini cocok digunakan untuk membangun model prediksi churn pelanggan.

2. **Buka halaman project** yang telah Anda buat pada langkah sebelumnya.
3. Klik tab **Assets** pada halaman project.
<img width="1440" alt="Screenshot 2025-07-02 at 12 52 14" src="https://github.com/user-attachments/assets/2ca00124-ce2b-4f8f-b913-095f503120ef" />

4. Klik **Import assets > Local file**, lalu pilih **Data Asset**. Kemudian, unggah file `telco_churn_data.csv` yang sudah Anda download sebelumnya. 
<img width="1440" alt="Screenshot 2025-07-02 at 12 52 44" src="https://github.com/user-attachments/assets/5b47bf20-5c5d-43b7-a28b-cdd448d3160f" />

5. Setelah upload selesai, klik **Done**. Sekarang data source Anda sudah berhasil ditambahkan sebagai asset dalam project.
<img width="1440" alt="Screenshot 2025-07-02 at 13 01 23" src="https://github.com/user-attachments/assets/3193b8e5-f233-42b2-875b-78371f405d4e" />


### (Opsional) Data Preprocessing dengan Data Refinery
Pada tahap ini, Anda juga bisa melakukan data preprocessing secara visual:
- Klik nama data asset (telco_churn_data.csv) untuk membuka preview.
- Klik tombol Prepare Data, dan Anda akan diarahkan ke fitur Data Refinery.

Namun, untuk keperluan lab ini, kita akan melewati tahap preprocessing, karena dataset yang disediakan sudah bersih dan siap digunakan.

Ingin tahu lebih lanjut tentang Data Refinery?
Baca dokumentasinya [disini](https://dataplatform.cloud.ibm.com/docs/content/wsj/refinery/refining_data.html?context=cpdaas) 


## Step 3: Membuat Machine Learning Model dengan AutoAI
1. Buka halaman utama project, lalu klik **New Asset**.
<img width="1440" alt="Screenshot 2025-07-02 at 13 21 05" src="https://github.com/user-attachments/assets/c14f32e4-c141-448b-9beb-c24ecae1652e" />

2. Klik **Build machine learning or RAG solutions automatically with AutoAI > Build a machine learning model**
<img width="1440" alt="Screenshot 2025-07-02 at 13 08 27" src="https://github.com/user-attachments/assets/1cfd49ed-bdaf-4000-8245-082da14a684a" />
<img width="1440" alt="Screenshot 2025-07-02 at 13 08 47" src="https://github.com/user-attachments/assets/4b0fda78-8af7-4211-b1e5-364c513d67e9" />

3. Isi formulir detail dan konfigurasi model AutoAI:
- Pada bagian **Define details**, masukkan nama dan deskripsi model AutoAI
<img width="1440" alt="Screenshot 2025-07-02 at 13 11 54" src="https://github.com/user-attachments/assets/ba5ed11e-1aa1-4e3e-bf39-f94e9114f09b" />

- Pada bagian **Define configuration**, klik **Associate a watsonx.ai Runtime service instance.**
- Pilih instance service yang tersedia untuk digunakan pada project ini.
<img width="1440" alt="Screenshot 2025-07-02 at 13 12 20" src="https://github.com/user-attachments/assets/3a1dd069-0cc2-4353-ad6a-e424411ae16d" />

4. Klik **Create** untuk membuat model.
<img width="1440" alt="Screenshot 2025-07-02 at 13 12 38" src="https://github.com/user-attachments/assets/605127fd-f695-41f4-9cd3-f48ee0c1d3d4" />

5. Klik **Done**. Sekarang, model Machine Learning sudah berhasil ditambahkan sebagai asset dalam project Anda.


## Step 4: Menggunakan Datasource untuk Run Experiment dengan AutoAI
1. Selanjutnya, Anda dapat menambahkan data source untuk machine learning model yang telah dibuat. Karena kita tadi sudah menambahkan data dalam project ini, klik **Select from project**
<img width="1440" alt="Screenshot 2025-07-02 at 13 12 56" src="https://github.com/user-attachments/assets/fb66f691-2b25-424f-9c3f-f0d8575a2809" />

2. Klik **Data asset** dan pilih **data source** 
<img width="1440" alt="Screenshot 2025-07-02 at 13 13 05" src="https://github.com/user-attachments/assets/fac2110f-5b7b-4d0c-adcc-dffff1bde4c9" />

3. **Configure details**
<img width="1440" alt="Screenshot 2025-07-02 at 13 24 25" src="https://github.com/user-attachments/assets/c252c09f-7e93-4376-8ba4-5ac345b7e983" />

Setelah memilih data, AutoAI akan membaca dataset Anda dan menampilkan opsi konfigurasi pada bagian Configuration Details...
### 🧠 Time Series Analysis (Opsional)
Jika Anda ingin melakukan prediksi berdasarkan data berurutan (misalnya berdasarkan waktu), Anda dapat mengaktifkan opsi Time Series Analysis.

Berikut penjelasan parameter untuk time series:
| Field             | Deskripsi                                                                 |
|-------------------|---------------------------------------------------------------------------|
| Prediction columns | Kolom yang ingin diprediksi berdasarkan nilai sebelumnya. Anda bisa menentukan satu atau lebih kolom untuk diprediksi. |
| Date/time column   | Kolom yang menunjukkan tanggal/waktu terjadinya nilai time series.       |
| Lookback window    | Parameter yang menunjukkan berapa banyak nilai time series sebelumnya yang digunakan untuk memprediksi titik waktu saat ini. |
| Forecast window    | Rentang waktu yang ingin diprediksi berdasarkan data dari lookback window. |

📌 Dalam lab ini, kita akan memilih **No** untuk Time Series Analysis, karena dataset tidak menyertakan kolom tanggal/waktu.

### 🏷️ Pilih Kolom Prediksi
Selanjutnya, pilih kolom target yang ingin diprediksi. Di lab ini, kita memilih kolom **Churn Value**. AutoAI akan secara otomatis memilih jenis model prediksi yang paling sesuai, berdasarkan tipe dan isi data. 

<img width="1440" alt="Screenshot 2025-07-02 at 13 14 26" src="https://github.com/user-attachments/assets/7236ba3b-962a-407e-8b30-c11c73620bbf" />


Dalam kasus ini, AutoAI memilih **Binary Classification**, yaitu jenis model yang digunakan ketika keputusan harus dibuat antara dua pilihan (misalnya: true/false), berdasarkan karakteristik lain yang tersedia.

Oleh karena itu, model ini akan memprediksi apakah seorang pelanggan akan:
- Churn (berhenti berlangganan), atau
- Tetap menjadi pelanggan aktif

Use case model ini yaitu:
- Mengidentifikasi pelanggan berisiko tinggi untuk churn
- Menyusun strategi retensi yang lebih proaktif dan tepat sasaran
- Menurunkan tingkat churn dan meningkatkan loyalitas pelanggan

4. **Experiment settings**
<img width="1440" alt="Screenshot 2025-07-02 at 13 27 47" src="https://github.com/user-attachments/assets/f1744f7a-e977-4e90-a5a5-7ddf67b2a8ca" />

Jika Anda seorang Data Scientist (atau ingin bereksperimen), Anda dapat memilih Experiment Settings untuk menyesuaikan sumber data, data pelatihan, metrik yang dioptimalkan, serta algoritma yang akan diuji oleh AutoAI.

**Namun, untuk sekarang kita akan menggunakan pengaturan default.**

5. Klik **Run experiment** untuk menjalankan model

AutoAI akan menampilkan tampilan dinamis saat mencoba mencari algoritma machine learning paling akurat berdasarkan kolom prediksi yang dipilih dan karakteristik dataset Anda. **Proses ini memakan waktu beberapa menit**, namun sebenarnya pekerjaan ini akan memakan waktu jauh lebih lama jika dilakukan oleh data scientist secara manual!

<img width="1440" alt="Screenshot 2025-07-02 at 13 31 08" src="https://github.com/user-attachments/assets/3fb13877-d2f4-4a35-9d1b-1471f1e1b050" />

AutoAI akan **memilih algoritma yang dianggap paling sesuai, menjalankan eksperimen dengan algoritma tersebut, lalu mengulangi eksperimen dengan penyesuaian seperti peningkatan fitur (feature engineering) dan pengoptimalan parameter.**
<img width="1440" alt="Screenshot 2025-07-02 at 13 32 19" src="https://github.com/user-attachments/assets/ce2351d1-4bd5-4b67-a66a-b0e531a55e1d" />
<img width="1440" alt="Screenshot 2025-07-02 at 13 34 32" src="https://github.com/user-attachments/assets/6bc1a198-7ef4-4e60-9385-4f1815953155" />

6. **Experiment Completed**
   
<img width="1440" alt="Screenshot 2025-07-02 at 13 35 21" src="https://github.com/user-attachments/assets/0b9538a4-2bb7-4c4f-8c21-773b63e127a1" />

Setelah beberapa menit, akan muncul pesan **"Experiment completed"**. AutoAI akan menampilkan berbagai informasi penting untuk membantu Anda memahami dan mengevaluasi performa model machine learning yang telah dibuat.

### 🏆 Pipeline Leaderboard
<img width="1440" alt="Screenshot 2025-07-02 at 15 06 12" src="https://github.com/user-attachments/assets/7c4209a2-e4e5-483f-951b-645fd60bf57d" />


AutoAI menampilkan daftar **pipeline** (rangkaian proses model) berdasarkan **peringkat akurasi terbaik**.

- Pipeline di urutan paling atas (Rank 1) adalah model dengan performa terbaik.
- Anda bisa mengeklik masing-masing pipeline untuk melihat pendekatan dan hasilnya secara detail.

### 📊 Metric Chart
<img width="1440" alt="Screenshot 2025-07-02 at 15 05 56" src="https://github.com/user-attachments/assets/f265c11c-a57a-4271-bab8-f74fa58e0aa7" />


Bagian ini menunjukkan grafik metrik evaluasi model seperti:

- **Accuracy** – seberapa sering prediksi model benar
- **Precision & Recall** – seberapa baik model mengenali churn
- **ROC AUC** – keseimbangan antara prediksi benar dan salah

Chart ini berguna untuk membandingkan performa beberapa pipeline secara visual.

### 🌟 Feature Importance
<img width="1440" alt="Screenshot 2025-07-02 at 15 06 41" src="https://github.com/user-attachments/assets/3b118496-576c-4b74-9817-6f5045c67bac" />

Analisis ini menunjukkan **variabel mana yang paling berpengaruh** dalam menentukan hasil prediksi.

### 🔢 Confusion Matrix
<img width="1440" alt="Screenshot 2025-07-02 at 15 06 31" src="https://github.com/user-attachments/assets/627726dc-2028-4aec-a8b9-6147a0bec289" />

Tabel ini menunjukkan seberapa banyak prediksi model yang benar dan salah. Gunanya adalah untuk melihat performa model secara lebih rinci, termasuk jenis kesalahan yang terjadi.

6. Untuk menyimpan sebagai model, klik **Save as** dan pilih **Model**. Setelah itu, model akan tersimpan sebagai asset di project Anda. 
<img width="1440" alt="Screenshot 2025-07-02 at 14 11 53" src="https://github.com/user-attachments/assets/f5144a86-3fad-43b0-a08d-15cf39569706" />

<img width="1440" alt="Screenshot 2025-07-02 at 14 12 22" src="https://github.com/user-attachments/assets/262ac871-1bd5-4524-bea3-cb33eaa2987d" />

<img width="1440" alt="Screenshot 2025-07-02 at 14 13 19" src="https://github.com/user-attachments/assets/6dd50abd-dfa1-479a-9241-269b73beb438" />


## Step 5: Deploy



