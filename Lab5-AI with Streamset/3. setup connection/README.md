Now that you have a streamsets account and have successfully accessed the StreamSets Control Hub portal, the next step is to deploy your engine to your virtual machine (VM). In this workshop, you will be provided with a TechZone VM environment for this purpose.

#### Streamsets Portal

Create the modular connection in the connections tab
<img width="1285" alt="image" src="https://github.com/user-attachments/assets/3b3aebb7-0f31-4cd8-aa3e-f6c33f5901d5" />

1. **Kafka connection**
   - Put `kafka` as the name and the type
   <img width="1280" alt="image" src="https://github.com/user-attachments/assets/326154c0-9f60-4a88-9c68-3c94607cf1fe" />
   
   - Select None (Security Protocol=PLAINTEXT) in the security options
     <img width="1280" alt="image" src="https://github.com/user-attachments/assets/71df3f8c-24f0-4fdd-a305-ecf484393f5e" />
     
   - Copy and paste the JDBC Connection String
     ```text
     localhost:9092
     ```
     <img width="1280" alt="image" src="https://github.com/user-attachments/assets/a57a4c60-f312-425a-88f3-b3a44d5c532b" />

2. **Web client connection**
   - Put `Risk Scoring Microservice` as the name and `WebClient` as the type
     <img width="1280" alt="image" src="https://github.com/user-attachments/assets/b5262e9d-d97f-4f73-b185-d8aaf47a09f7" />

   - Put the URL `http://localhost:8000`, authentication scheme as `None` and Keystore `Automatic (for most HTTP and HTTPS requests). Then save
     <img width="1280" alt="image" src="https://github.com/user-attachments/assets/81c5867e-084f-4aa8-9c2c-d9a99c4d1eb7" />

3. **Postgres connection**
   - Put `Postgres` as the name and `JDBC` as the type
   <img width="1280" alt="image" src="https://github.com/user-attachments/assets/dcd3519e-db23-4756-9719-96380a297f37" />

   - Copy and paste the JDBC Connection String
     ```text
     jdbc:postgresql://localhost:5432/postgres
     ```
     <img width="1280" alt="image" src="https://github.com/user-attachments/assets/38aaa224-2d98-4365-85a0-8a22967169ba" />

   - Create a connection 
     <img width="1280" alt="image" src="https://github.com/user-attachments/assets/26328010-349c-4f84-b054-4239b253dada" />

All the connections dashboard now:
<img width="1722" alt="image" src="https://github.com/user-attachments/assets/2bf92350-dc4a-4150-8566-84a2365acced" />

---

#### Virtual Machine Portal
In this workshop, we will use PostgreSQL to store the data, so we will return to the VM portal to create the necessary table. Since Kafka has already been installed on the VM, there is no need to install it.

1. **Postgres - Create the table**
  - Go to the postgres folder, then copy and paste this script
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
