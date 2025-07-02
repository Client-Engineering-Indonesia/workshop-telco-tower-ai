# prompt builder in watsonx ai
### watson studio
<img width="1728" alt="image" src="https://github.com/Client-Engineering-Indonesia/watsonx-incubation-2024/assets/20800128/7004936c-e438-465a-8aad-0655ce8b25ce">

watsonx.ai memudahkan kita untuk berinteraksi dengan model LLM dengan menyediakan layanan LLM-as-a-service.
Di watsonx.ai, kita dapat menggunakan Prompt Lab dan Python SDK. Dengan menggunakan Prompt Lab atau Prompt Builder, Anda dapat memberikan instruksi kepada model LLM yang tersedia melalui antarmuka web. Sementara itu, jika Anda lebih tertarik mengakses model LLM menggunakan bahasa pemrograman, Anda dapat menggunakan contoh SDK.

---

Dalam watsonx.ai, Prompt Lab menyediakan tiga mode: **Chat** untuk interaksi seperti percakapan, **Structured** untuk membuat prompt dengan format terkontrol (instruction, input, output), dan **Freeform** untuk eksplorasi bebas tanpa batasan format. Ketiganya dirancang agar pengguna bisa menyesuaikan gaya pembuatan prompt sesuai kebutuhan teknis dan kreativitas.

Pada worksho ini, kita akan menggunakan fitur **Chat Prompt Lab** yang memungkinkan Anda untuk berinteraksi langsung dengan model AI menggunakan dokumen yang diunggah. Fitur ini sangat bermanfaat untuk analisis, tanya-jawab berbasis dokumen, dan ekstraksi informasi. 

### Step 1: Buat Prompt Baru
- Klik **New Asset**
- Pilih opsi **Prompt**
- Lalu klik opsi **"Chat and build prompts with foundation models"**

![Langkah 1](https://github.com/user-attachments/assets/43b8182e-133b-43e7-9ebd-e7b411bdd5cc)

---

### Step 2: Pilih Mode Prompt
- Akan muncul pilihan antara:
  - **Chat**
  - **Structured**
  - **Freeform**
- Untuk panduan ini, pilih tab **Chat**
- Klik **Upload Files** untuk mengunggah dokumen referensi

![Langkah 2](https://github.com/user-attachments/assets/1dc0c5e9-5842-470e-bd6f-e34786996b66)

---

### Step 3: Unggah Dokumen Anda
- Unggah file yang relevan dari komputer Anda
- Contoh: `data/fundsheet/MDPU.pdf`
- Setelah itu, pilih:
  - **Model embedding** (untuk indexing dan pemahaman isi dokumen)
  - **Chunking setting** (berapa banyak teks dibaca per bagian)

![Langkah 3](https://github.com/user-attachments/assets/226c8658-583d-45e4-a805-da39667606c3)

---

### Step 4: Atur Parameter Model
- Setelah prompt dibuat, Anda bisa menyesuaikan parameter model
- Misalnya: model foundation, temperatur, max tokens, dsb.

![Langkah 4](https://github.com/user-attachments/assets/c5ae448e-f7df-4963-ae19-aeaed344247f)

---

### Step 5: Pilih Model Foundation yang Sesuai
- Di bagian pemilihan model, Anda bisa memilih model foundation (misal: Granite, Flan-T5, Mistral, dll.)
- Sesuaikan dengan kebutuhan dan kompleksitas dokumen Anda

![Langkah 5](https://github.com/user-attachments/assets/0d33ab0a-8441-46c9-895d-39be7f0fc481)

---

### Step 6: Mulai Tanya Jawab dengan Dokumen
- Setelah semuanya ter-set, Anda dapat memulai sesi tanya jawab langsung dengan dokumen yang telah diunggah
- Cukup ketikkan pertanyaan terkait isi dokumen tersebut

![Langkah 6](https://github.com/user-attachments/assets/4ec4cfde-9e72-49e9-9c2d-f84627a245d4)

---

### Step 7: Contoh Kasus: Ekstraksi Data dari PDF
- Anda dapat menggunakan Chat Prompt untuk membantu memproses dokumen PDF
- Contohnya: mengubah data PDF menjadi format JSON yang lebih terstruktur

![Langkah 7](https://github.com/user-attachments/assets/731cade9-a993-485f-a770-44e4bff7e3d5)

---

## 💡 Tips
- Gunakan dokumen yang jelas dan terstruktur agar hasil tanya-jawab lebih akurat
- Gunakan **model embedding** yang sesuai untuk hasil pencarian konteks yang optimal
- Simpan konfigurasi prompt Anda agar bisa digunakan ulang

---
