### Membuat Streaming Pipeline
Pada langkah ini, Anda akan membuat pipeline baru yang mengkonsumsi stream transaksi keuangan dari Kafka, memperkaya setiap transaksi dengan memanggil risk-scoring service, dan mengarahkan transaksi berisiko tinggi ke PostgreSQL.

- Klik Build
- Klik Pipelines
- Klik Create a pipeline

![image](https://github.com/user-attachments/assets/0e6674ff-f2ed-4429-9110-70e0142ef20d)

- Masukkan nama pipeline sebagai Streaming. Biarkan item lainnya default.
  **Catatan:** Tambahkan nama Anda di akhir nama pipeline. Contoh: **Streaming Pipeline RA**, di mana RA adalah singkatan nama Anda.
- Klik Next

<img width="1280" alt="image" src="https://github.com/user-attachments/assets/16a7ec2b-5328-4822-82bd-e0a5a444dc08" />

- Pastikan Authoring Engine diatur ke engine Anda.
- Klik Save & Open in Canvas

<img width="1280" alt="image" src="https://github.com/user-attachments/assets/f5e136a4-0488-4a8a-8509-2d56c4a8b7ca" />

---

### Langkah 1. Konsumsi pesan dari Kafka
Anda akan memulai pipeline dengan mengkonsumsi pesan dari Kafka.

- Klik Add Origin widget
- Ketik Kafka di search bar untuk mencari Kafka
- Klik Kafka Multitopic Consumer

![image](https://github.com/user-attachments/assets/69dc5c89-a98a-4ea2-a1f2-f04c630d6867)

Kafka Connector akan ditambahkan ke canvas. Kemudian klik Kafka Connector:

![image](https://github.com/user-attachments/assets/9116b09e-69db-493b-a69b-f1512c23fa6a)

- Klik tab General
- Ubah nama menjadi Kafka
- Klik tab Connection di bagian bawah browser, atur properti berikut:
  - Kafka Connection harus diatur untuk terhubung ke Kafka broker lokal dan Kafka topic adalah txs.
  - Tambahkan nama consumer group Anda dengan nama Anda di akhir. Contoh: **StreamingDataCollectorRA**, di mana RA adalah singkatan nama Anda.
    
<img width="1280" alt="image" src="https://github.com/user-attachments/assets/69d059a7-f7f0-40b7-ab64-f15a54e1ba58" />

- Klik tab Data Format
- Klik drop-down data formats dan pilih **JSON** dari daftar

![image](https://github.com/user-attachments/assets/6fb88f67-455e-4953-a458-7799350bf014)

- Klik tombol Preview di bagian atas layar
- Klik Configure Preview untuk mengatur preview settings

![image](https://github.com/user-attachments/assets/9e067f94-2e74-4754-afbf-fb4916d81105)

- Centang “Execute Pipeline Lifecycle Events”, “Show Record/Field Header” dan “Save Preview Record Schema”
- Klik Run Preview

![image](https://github.com/user-attachments/assets/fdb811bf-3c9f-445f-859f-4f190a7a8df8)

Anda akan melihat payload pesan input dan output untuk stage seperti berikut.

![image](https://github.com/user-attachments/assets/92a65ef4-04f0-46df-9360-ff42475d14f1)

- Klik Close Preview

---

#### Langkah 2. Memanggil risk-scoring service

Sekarang Anda akan mengirim setiap pesan yang dikonsumsi dari Kafka ke risk-scoring microservice. Untuk kemudahan, gunakan Fragment yang sudah dikonfigurasi untuk memanggil risk-scoring microservice.
**Catatan:** Fragment pada latihan ini adalah client dari risk scoring service yang Anda buat sebelumnya dan hanya berfungsi jika risk scoring service sedang berjalan. Pastikan pipeline pada lab 3 “Start a Risk Scoring Microservice Pipeline” masih berjalan. Jika pipeline tersebut tidak berjalan, Anda tidak akan mendapatkan hasil pada langkah ini.

- Klik Add Stage widget
- Klik Fragments untuk memfilter tipe stage
- Klik Risk Scoring Service untuk menambahkannya ke canvas

![image](https://github.com/user-attachments/assets/2a611fb9-dedd-4c8f-a45f-a24e1ae2ce61)

Terima default parameter prefix:

![image](https://github.com/user-attachments/assets/0e52e24a-1758-466e-b310-c92d74a2cffa)

- Klik Done dan tunggu hingga fragment ditambahkan ke canvas.
- Klik Risk Scoring Service fragment
- Klik tab General
- Ubah nama menjadi Risk Scoring Service

![image](https://github.com/user-attachments/assets/c482e8ab-5785-43d2-8527-88553a5105ea)

- Klik Risk Scoring Service lagi dan arahkan mouse ke atasnya
- Klik tombol expand saat muncul

![image](https://github.com/user-attachments/assets/b433b37f-59f1-4af2-92b7-7ceb99d84a73)

- Klik Risk Scoring Service lagi dan cek konfigurasinya.
- Klik tab Request. Anda bisa melihat bahwa ini akan melakukan POST request dengan request body yang sudah dikonfigurasi.

![image](https://github.com/user-attachments/assets/bac2a18d-62da-4c6c-979c-de4e8eab2008)

- Klik tab Output.

Anda bisa melihat respons ditulis ke field output risk_score:

![image](https://github.com/user-attachments/assets/e81d41db-496b-4b60-8faf-e4b074502b37)

- Klik Risk Scoring Service lagi
- Klik tombol collapse

![image](https://github.com/user-attachments/assets/b450f36d-1b64-451c-a069-a501cf78b190)

- Preview pipeline lagi dengan klik Preview
- Klik Run Preview
- Klik Risk Scoring Service stage, dan pastikan service mengembalikan risk score value.
- Klik item risk_score untuk melihat detail risk score value dan versi algoritma yang digunakan.

![image](https://github.com/user-attachments/assets/9dbefded-d1d8-4014-8f82-87a241325200)

- Klik Close Preview

---

#### Langkah 3. Format risk score
Hasil dari langkah sebelumnya menghasilkan risk record yang nested dan kompleks, namun yang dibutuhkan organisasi hanya field risk_score_value saja.

![image](https://github.com/user-attachments/assets/1c99a516-b1f2-4c7e-a9d1-dc877f26b851)

Selanjutnya, gunakan Expression Evaluator untuk mengganti object kompleks dengan value yang diinginkan.

- Klik Add Stage widget
- Klik Processors
- Ketik exp
- Klik Expression Evaluator untuk menambahkannya ke pipeline
- Klik tab general
- Ketik nama stage sebagai Format Risk Score

![image](https://github.com/user-attachments/assets/d5c66cca-49de-4228-a000-b3889abc265c)

- Klik tab Expressions di bawah Field Expressions
- Ubah value field /risk_score dan ketik/salin ekspresi berikut
  ```text
  ${record:value('/risk_score/risk_score_value')}
  ```

![image](https://github.com/user-attachments/assets/94d32804-aeac-4dfb-8bb4-76626ac04f29)

**Catatan:** Pastikan tidak ada spasi di awal/akhir pada Field Expression value. Spasi ekstra dapat mengubah integer menjadi string dan menyebabkan error di langkah berikutnya.

- Klik Preview
- Klik Run Preview untuk melihat data

![image](https://github.com/user-attachments/assets/d39c93ed-530e-4362-9639-b1c54e884fa2)

- Pastikan risk score value di output sekarang menjadi field integer top-level bernama risk_score

![image](https://github.com/user-attachments/assets/27fc79d0-f834-4c42-90f7-8782a6ce51ef)

**Catatan:** Data Anda mungkin berbeda dari screenshot

- Klik Close Preview

---

#### Langkah 4. Filter transaksi high-risk
Selanjutnya, gunakan Stream Selector untuk mengarahkan semua transaksi dengan risk-score lebih besar dari threshold ke Postgres. Threshold didefinisikan di parameter pipeline dengan default 50. Anda dapat melihat dan membuat parameter ini dengan klik area kosong di canvas pipeline.

![image](https://github.com/user-attachments/assets/19322ac7-a17a-454e-90fd-76209d176d87)

- Klik General
- Klik Show Advanced Options dropdown

![image](https://github.com/user-attachments/assets/cd291983-c8f3-4fbc-a5a2-4272eae6957f)

- Klik tab Parameters
- Klik +ADD untuk menambah parameter

![image](https://github.com/user-attachments/assets/db2c7f74-4d68-480e-a48f-7af768961523)

Untuk menambah Stream Selector ke pipeline:
- Klik Add Stage widget
- Ketik stream
- Klik Stream Selector untuk menambah stage

![image](https://github.com/user-attachments/assets/da25859d-537a-4a6e-b0c8-562568af8772)

- Selector akan ditambahkan ke canvas.
- Klik tab General
- Ketik nama stage menjadi Select High Risk Txs:

![image](https://github.com/user-attachments/assets/2e9da0cf-d255-492e-ada4-79ef9f208566)

- Klik tab Conditions
- Klik Add Another dan ketik/salin teks berikut untuk condition #1
  ```text
    ${record:value('/risk_score') > HIGH_RISK_THRESHOLD}
  ```

![image](https://github.com/user-attachments/assets/39dbad20-96be-4330-ada8-db40e307cdd3)

---

#### Langkah 5. Tulis transaksi high-risk ke PostgreSQL
Di Canvas, klik Add Stage widget, ketik jdbc di search bar

- Klik JDBC Producer untuk menambahkannya ke stream #1 dari Stream Selector

![image](https://github.com/user-attachments/assets/06bfb123-2159-44b8-a419-0eae8dba67c0)

- Klik tab General
- Ubah nama stage JDBC Producer menjadi Postgres

![image](https://github.com/user-attachments/assets/0a0c6aa3-fdaa-485c-9ac0-89c8f65ec88d)

- Klik tab JDBC
- Pilih predefined Postgres Connection
- Atur schema ke public dan table name ke financial_transactions

![image](https://github.com/user-attachments/assets/fd8e5aa5-e3a0-45bd-8d28-3dbd8561e980)

---

#### Langkah 6. Buang transaksi low-risk
Selanjutnya, tambahkan Trash stage ke stream #2 dari Stream Selector agar transaksi low-risk (yang tidak dikirim ke Postgres) dibuang:

- Klik Add Stage
- Klik Trash

![image](https://github.com/user-attachments/assets/3fd62f80-0e31-4c4f-8149-929d73532fa5)

Pipeline sekarang sudah lengkap!

**Validasi Pipeline**
- Klik tombol Validate dan pastikan validasi sukses seperti gambar berikut.

![image](https://github.com/user-attachments/assets/55a7faa0-3934-4f89-ba1b-5807412f5a50)

**Jalankan Streaming Pipeline**
- Klik Draft Run
- Klik Start lalu klik Start
- Menu Parameters dan biarkan default 50.

**Catatan:** Dengan “Start with Parameters” Anda bisa mengubah nilai parameter saat runtime tanpa harus hard code di stage. Anda akan melihat metrics (yang terus bertambah) dan status seperti berikut.

![image](https://github.com/user-attachments/assets/090989ba-d9c6-4a6d-b149-db0ffaaf97d3)

- Klik Stream Selector (Select High Risk Txs) untuk melihat rasio transaksi high-risk dan low-risk
- Stream/output 1 adalah transaksi high-risk yang dikirim ke Postgres dan stream/output 2 adalah transaksi low-risk yang dibuang ke trash (tidak disimpan)

![image](https://github.com/user-attachments/assets/2185bdca-36ce-41dc-9a51-9aabb5a1a513)

- Snapshot data yang mengalir di Streaming Pipeline. Saat pipeline berjalan, klik tombol Snapshot

![image](https://github.com/user-attachments/assets/f054640e-180d-45e3-9d87-5388cd443e9a)

- Klik Capture Snapshot. Setelah snapshot di-capture,
- Klik tombol View
  ![image](https://github.com/user-attachments/assets/65436e86-b186-4932-be36-1fc55836514a)

---

#### Cek data flow di pipeline
- Klik setiap stage untuk melihat data yang mengalir di pipeline. Misal, Anda bisa melihat risk score yang dikembalikan Risk Scoring Service dengan klik Risk Scoring Service stage, dan lihat output seperti di bawah.

![image](https://github.com/user-attachments/assets/59574e59-e97b-44b1-aff4-654fc8246bcd)

- Klik stage Postgres, Anda bisa melihat record yang ditulis ke Postgres memiliki risk score > 50, seperti input pada stage ini. (Lihat di bawah)

![image](https://github.com/user-attachments/assets/d4bb12b8-c8f8-4aef-884e-fcad06560822)

- Klik trash / Discarded Low Risk Txs stage, Anda bisa melihat pesan yang dibuang memiliki risk score <= 50.

![image](https://github.com/user-attachments/assets/7d7699a9-793e-457e-a4da-f7f1e0d725ea)

- Klik Close
- Klik Stop
- Check-in pipeline yang sudah selesai dengan klik tombol Check-in

![image](https://github.com/user-attachments/assets/be40ce27-16f5-463d-8388-07748cdfe641)

- Saat diminta, klik Publish and Close:

![image](https://github.com/user-attachments/assets/2c632269-8499-4752-bd8a-bc20a30ad9ce)

