Sekarang setelah Anda memiliki akun streamsets dan berhasil mengakses portal StreamSets Control Hub, langkah selanjutnya adalah melakukan deploy engine ke virtual machine (VM) Anda. Dalam workshop ini, Anda akan disediakan lingkungan VM TechZone untuk keperluan tersebut.

#### Streamsets Portal

1. **Buat deployment di streamsets**
  - Buka tab deployment dan buat deployment baru
  <img width="1280" alt="image" src="https://github.com/user-attachments/assets/5cb6727b-7f0f-40ff-a92e-c0d5c703b3c1" />

  - Masukkan deployment dengan nama `workshop_streamsets_deployment`
    <img width="1280" alt="image" src="https://github.com/user-attachments/assets/24d1563c-57ce-45ab-82eb-c49aad24d77c" />

  - Pada engine labels, masukkan `workshop_streamsets`
    <img width="1280" alt="image" src="https://github.com/user-attachments/assets/23181402-ed16-4691-a1ae-44b8654996a2" />

  - Di sini, Anda dapat membagikan deployment ke email tertentu yang sudah Anda atur di tab `Manage/Users`
    <img width="1280" alt="image" src="https://github.com/user-attachments/assets/7899cd84-122d-4ae5-9d50-96e36595ff38" />

  - Setelah direview, klik start dan generate install scripts
    <img width="1280" alt="image" src="https://github.com/user-attachments/assets/1d901333-95d7-4924-96fa-e4270d76544a" />

  - Simpan script instalasi tersebut, lalu keluar
    <img width="1280" alt="image" src="https://github.com/user-attachments/assets/4a22cb78-41a4-455a-9177-db5d39dcbca2" />

  - Pada tab Deployments, Anda dapat melihat deployment sudah siap. Namun, pada tab Engines, engine belum terdaftar.
    <img width="1280" alt="image" src="https://github.com/user-attachments/assets/c0471848-632e-4b03-b222-b56023c062d2" />

---
Untuk membuat engine, Anda membutuhkan VM sebagai tempat deploy. Dalam workshop ini, VM sudah disediakan oleh instruktur melalui TechZone.

#### Virtual Machine Portal

2. **Buat engine di streamsets**
  - Buka `https://techzone.ibm.com/my/reservations` dan pastikan reservation card Anda terlihat, lalu buka environment-nya
  <img width="1281" alt="image" src="https://github.com/user-attachments/assets/dc24a836-1708-4a1d-b526-06bc9752581e" />

  - Scroll ke bawah dan buka console
  <img width="1281" alt="image" src="https://github.com/user-attachments/assets/f0127fba-338a-447f-a5d9-5ccbe56bdf00" />

  - Login sebagai admin dan masukkan password `IBMDem0s`
  <img width="1281" alt="image" src="https://github.com/user-attachments/assets/788fc18d-6dd7-4be6-953e-be2269e2f69c" />

  - Masuk ke folder streamsets dan copy-paste script dari langkah 1 untuk deploy engine (menggunakan toggle)
  <img width="1281" alt="image" src="https://github.com/user-attachments/assets/fa498f46-3fe7-4326-b999-c1316b2804a0" />
  
  - Masukkan streamsets data collector download ke sdc-download dan streamsets data collector ke sdc
  <img width="1281" alt="image" src="https://github.com/user-attachments/assets/4b7bc6d0-53c8-40fa-b9e7-db0127221598" />
  
  - Tunggu beberapa menit hingga muncul pesan `Engine started successfully`
  <img width="1281" alt="image" src="https://github.com/user-attachments/assets/14b4d7dc-ea31-47c3-8b38-2a1d4479e5e3" />
  
---

#### Streamsets Portal
Kembali ke streamsets portal dan cek engine

3. **Cek engine**
  - Sebelum deployment di VM
  <img width="1281" alt="image" src="https://github.com/user-attachments/assets/8f052894-d096-4437-96b7-0ad2d50db254" />

  - Setelah deployment di VM
  <img width="1281" alt="image" src="https://github.com/user-attachments/assets/afd2bca7-af56-4344-ad80-8d1f941b674b" />

---