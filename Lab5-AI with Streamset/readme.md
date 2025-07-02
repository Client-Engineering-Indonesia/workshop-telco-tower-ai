# Integrasi Data dengan StreamSets

Lab ini membimbing Anda melalui proses pengaturan alur integrasi data lengkap menggunakan **StreamSets**, mulai dari pengaturan lingkungan hingga membangun pipeline machine learning untuk credit scoring.

### Fitur Utama
1. **Integrasi Data Tanpa Kode**  
   StreamSets menyediakan antarmuka grafis yang kaya untuk membangun pipeline menggunakan konektor dan processor drag-and-drop—tanpa perlu menulis kode.

2. **Fleksibilitas Skema**  
   StreamSets mampu menangani skema data yang dinamis dan berubah-ubah secara otomatis, sehingga pipeline tetap berjalan meskipun struktur data berubah.

3. **Modular dan Reusable Pipelines**  
   Bangun pipeline yang efisien dan scalable dengan memanfaatkan reusable fragments, parameterization, dan job templates. Hal ini memudahkan pemeliharaan dan mengurangi duplikasi.

4. **Custom Data Transformations**  
   Tambahkan logika bisnis spesifik menggunakan embedded script (Groovy, Jython, dan lainnya), sehingga pemrosesan data dalam pipeline dapat disesuaikan sesuai kebutuhan.

5. **Real-Time Monitoring dan Debugging**  
   Pantau pipeline secara real-time dengan metrik, snapshot, dan preview. Fitur ini memudahkan identifikasi masalah dan optimasi performa.

6. **Broad Connectivity**  
   Terhubung dengan berbagai sumber dan target data seperti database, cloud storage, messaging system, dan lainnya—lintas platform dan teknologi.
   
   
### Langkah 1. Setup StreamSets Platform  
Mulailah dengan menginstal dan mengonfigurasi lingkungan StreamSets platform.  
📂 [1. setup streamsets]([https://github.com/Client-Engineering-Indonesia/workshop-maybank-2025/tree/main/Lab%203%20-%20Data%20Integration%20with%20Streamsets/1.%20setup%20streamsets](https://github.com/Client-Engineering-Indonesia/workshop-telco-tower-ai/tree/main/Lab5-AI%20with%20Streamset/1.%20setup%20streamsets))

### Langkah 2. (Opsional) Setup StreamSets Engine (Data Collector)  
Jika Anda menjalankan instance self-managed atau ingin kontrol penuh atas pipeline Anda, lakukan setup StreamSets Data Collector engine sendiri.  
📂 [2. setup data collector]([https://github.com/Client-Engineering-Indonesia/workshop-maybank-2025/tree/main/Laba%203%20-%20Data%20Integration%20with%20Streamsets/2.%20setup%20data%20collector](https://github.com/Client-Engineering-Indonesia/workshop-telco-tower-ai/tree/main/Lab5-AI%20with%20Streamset/2.%20setup%20streamsets%20engine))

### Langkah 3. Setup Pipeline: Data Generator  
Langkah ini membimbing Anda membuat pipeline data generator simulasi untuk kebutuhan pemrosesan selanjutnya.  
📂 [3. data generator]([https://github.com/Client-Engineering-Indonesia/workshop-maybank-2025/tree/main/Lab%203%20-%20Data%20Integration%20with%20Streamsets/3.%20data%20generator](https://github.com/Client-Engineering-Indonesia/workshop-telco-tower-ai/tree/main/Lab5-AI%20with%20Streamset/4.%20setup%20data%20generator))

### Langkah 4. Setup Pipeline: Machine Learning (Credit Scoring)  
Terakhir, bangun dan deploy pipeline machine learning untuk credit scoring menggunakan data yang telah dihasilkan sebelumnya.  
📂 [4. credit pipeline]([https://github.com/Client-Engineering-Indonesia/workshop-maybank-2025/tree/main/Lab%203%20-%20Data%20Integration%20with%20Streamsets/4.%20credit%20pipeline](https://github.com/Client-Engineering-Indonesia/workshop-telco-tower-ai/tree/main/Lab5-AI%20with%20Streamset/5.%20create%20Risk%20Scoring%20fragment))
