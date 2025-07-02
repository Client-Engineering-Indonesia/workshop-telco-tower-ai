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

Setelah model selesai dibuat, sekarang saatnya **men-deploy** model ke layanan **Watson Machine Learning** agar bisa digunakan untuk melakukan prediksi. Deployment adalah tahap akhir dari siklus model machine learning. Di tahap ini, model yang sudah dilatih siap dijalankan dan digunakan.  

Watson Machine Learning menggunakan **Deployment Spaces** untuk mengatur model dan aset yang diperlukan agar model bisa diuji dan digunakan.

1. **Buka halaman project** dan cari model Machine Learning yang telah Anda buat di tahap sebelumnya.
<img width="1440" alt="Screenshot 2025-07-02 at 14 13 19" src="https://github.com/user-attachments/assets/149dddba-9bcb-4634-b7a9-98d853772480" />

2. Klik tombol **tiga titik (⁝)** di bagian kanan model, lalu pilih **Promote to space**.
<img width="1440" alt="Screenshot 2025-07-02 at 14 43 48" src="https://github.com/user-attachments/assets/32c46cc7-4214-4b77-bdc0-127e56f43b98" />

4. Akan muncul formulir deployment.  Pada bagian **Target Deployment Space**, pilih deployment space yang sudah disediakan untuk Anda.
<img width="1440" alt="Screenshot 2025-07-02 at 14 43 54" src="https://github.com/user-attachments/assets/58b73110-6792-428c-bb94-e21862eeb313" />

5. Klik **Promote**. Setelah selesai, klik link **deployment space** yang ada di success message atau buka menu **deployment space** dari sidebar.
<img width="1440" alt="Screenshot 2025-07-02 at 14 44 16" src="https://github.com/user-attachments/assets/b1d0484f-7209-4cb8-9c49-5e07b11e955a" />

6. Pada Deployment Space, buka **Assets** dan klik tombol **tiga titik (⁝)** di bagian kanan ML Anda, lalu pilih **Deploy**.
<img width="1440" alt="Screenshot 2025-07-02 at 15 22 41" src="https://github.com/user-attachments/assets/5d3eee4b-649d-49c5-81c3-f8c2c053f5cf" />

7. Akan muncul formulir **Create a deployment**. Isi sesuai dengan foto dibawah dan klik **Create**
<img width="1440" alt="Screenshot 2025-07-02 at 15 24 03" src="https://github.com/user-attachments/assets/aa2269d6-8e0c-4a2d-ab47-3fa37c43de19" />


8. Deployment akan diproses. Setelah statusnya menjadi **Deployed**, klik **deployment name** tersebut
<img width="1440" alt="Screenshot 2025-07-02 at 15 24 34" src="https://github.com/user-attachments/assets/a5da82d2-66d9-4cea-a6b8-508c2964ebfb" />

9. Di halaman **Test**, Anda dapat menjalankan prediksi terhadap model yang sudah dibuat dengan memasukkan nilai untuk setiap variabel yang mungkin memengaruhi keputusan pelanggan untuk berhenti berlangganan.
<img width="1440" alt="Screenshot 2025-07-02 at 15 48 08" src="https://github.com/user-attachments/assets/3611031e-3c2b-4b7c-bb9e-90b16a5fbbfe" />

Anda bisa mengisi data satu per satu melalui form yang tersedia, atau langsung menggunakan format JSON. 

Klik tab **JSON**, lalu salin dan tempel data di bawah ini ke kolom input, kemudian klik **Predict**.
```
{
  "input_data": [
    {
      "fields": [
        "Customer ID", "Referred a Friend", "Number of Referrals", "Tenure in Months", "Offer",
        "Phone Service", "Avg Monthly Long Distance Charges", "Multiple Lines", "Internet Service",
        "Internet Type", "Avg Monthly GB Download", "Online Security", "Online Backup",
        "Device Protection Plan", "Premium Tech Support", "Streaming TV", "Streaming Movies",
        "Streaming Music", "Unlimited Data", "Contract", "Paperless Billing", "Payment Method",
        "Monthly Charge", "Total Regular Charges", "Total Refunds", "Total Extra Data Charges",
        "Total Long Distance Charges", "Gender", "Age", "Under 30", "Senior Citizen", "Married",
        "Dependents", "Number of Dependents", "City", "Zip Code", "Latitude", "Longitude",
        "Population", "CLTV", "Churn Category", "Churn Reason", "Total Customer Svc Requests",
        "Product/Service Issues Reported", "Customer Satisfaction"
      ],
      "values": [
        [
          "9000-TEST1", "Yes", 1, 24, "Offer B", "Yes", 15.5, "Yes", "Yes", "Fiber Optic", 30,
          "Yes", "No", "No", "Yes", "Yes", "Yes", "No", "Yes", "Two Year", "Yes", "Credit Card",
          95.75, 2300.00, 0, 0, 350.00, "F", 35, "No", "No", "Yes", "Yes", 2, "Jakarta", "12345",
          -6.2, 106.8, 50000, 4000, "", "", 2, 1, 4
        ]
      ]
    }
  ]
}
```
<img width="1440" alt="Screenshot 2025-07-02 at 16 06 29" src="https://github.com/user-attachments/assets/f78d109e-46e2-4ce3-b328-6f5c12b2a5f6" />


### 📈 Hasil Prediction
<img width="1440" alt="Screenshot 2025-07-02 at 16 01 51" src="https://github.com/user-attachments/assets/2143ecb1-e4ec-4948-a6b8-bd9719912504" />

Berdasarkan data JSON di atas:
- Usia 35 tahun, perempuan
- Menikah, memiliki 2 tanggungan
- Internet aktif dengan penggunaan layanan streaming
- Biaya bulanan cukup tinggi dan kepuasan pelanggan baik

Maka model memprediksi **0 (tidak churn)**, yang berarti pelanggan ini diperkirakan akan tetap berlangganan.

**Confidence**: 100% — artinya model sangat yakin terhadap prediksi ini.


10. Coba Kombinasi Input Lain untuk **Melihat Perubahan Prediksi**

Contoh:

- Ganti Churn Category menjadi "Competitor" dan Churn Reason menjadi "Competitor offered more data"
- Ganti "Gender" ke "F" → apakah hasil berubah?
- Ubah Total Long Distance Charges menjadi 300 dan Avg Monthly GB Download menjadi 345
- Ganti "Married" ke "No" untuk melihat apakah status pernikahan berpengaruh
- Turunkan Customer Satisfaction menjadi 1 → lihat apakah confidence prediksi berubah

🧠 Anda akan melihat bahwa mengubah beberapa parameter dapat memengaruhi:
- Nilai prediksi (0 = tidak churn, 1 = churn)
- Atau tingkat confidence dari model, walaupun prediksi tetap sama
<img width="1440" alt="Screenshot 2025-07-02 at 15 50 13" src="https://github.com/user-attachments/assets/a3c11ab1-4fc8-47f0-a164-450c1c56b88e" />

Dengan mencoba berbagai kombinasi input, kita bisa memahami lebih dalam bagaimana model machine learning bekerja dan apa saja faktor yang paling berpengaruh terhadap prediksi churn. Langkah ini juga mendemonstrasikan bagaimana model ML yang kita buat bisa langsung diaplikasikan dalam use case nyata perusahaan dengan pendekatan yang **fleksibel dan terkustomisasi.**

---

## 👋 Penutup

Selamat! Anda telah berhasil menyelesaikan Lab AutoAI! 🎉 Proses yang biasanya membutuhkan berhari-hari hingga berminggu-minggu, kini bisa diselesaikan dalam waktu singkat dan lebih insightful berkat bantuan AutoAI. Semoga lab ini bermanfaat dan bisa menjadi awal dari eksplorasi lebih lanjut di bidang AI dan data science.

Buka data di pagi hari,

Prediksi churn kini dimengerti.

AutoAI bantu proses cepat sekali,

Belajar AI jadi tak ngeri!

😁🙏
---





