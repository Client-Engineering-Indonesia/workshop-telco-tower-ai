### Create a streaming Pipeline (Continue)

Previously, you set up a stream pipeline that filtered data based on risk scores—either storing them in PostgreSQL or discarding them. Now, as a Data Scientist, you need to export this data into Parquet format for further analysis, typically for machine learning prediction tasks. In this updated pipeline, we will use IBM Cloud Object Storage as the destination for the Parquet files. 

--- 
### Connect as parquet (Local file system/ Local FS)
The final pipeline will be structured as follows:

<img width="1020" alt="image" src="https://github.com/user-attachments/assets/1903e949-bba4-44d6-976f-36be0af783ea" />

- Add Stage
- Select Local FS
- Change name to **Datalake (Parquet)**
  
  <img width="1020" alt="image" src="https://github.com/user-attachments/assets/5570f5f8-2139-497d-8261-295a4ff6987b" />
  
- Copy and Paste the Directory Template
  ```text
  /tmp/transactions
  ```
- Put **parquet** in the fFiles Suffix
  
<img width="1020" alt="image" src="https://github.com/user-attachments/assets/d9c10f13-2b5f-418b-8ee8-1c1944ae5cea" />

- In the Data Format tab, change the Data Format to **Parquet**
- Change the **Snappy** for the Parquet Compression Codec
- Change the **2.0** for the Parquet Format Version
  
<img width="1020" alt="image" src="https://github.com/user-attachments/assets/a28b82a3-36d3-4269-977b-caaccadcc006" />

Run the pipeline:

<img width="1020" alt="image" src="https://github.com/user-attachments/assets/cd5d01ec-3c84-4dbd-99ee-a2852c429cf1" />

---

### Connect as parquet (IBM COS)

<img width="1020" alt="image" src="https://github.com/user-attachments/assets/3f66e238-26dc-4b8f-bce0-c4d0421781cd" />

- Add Stage
- Select Amazon S3
- Put the creds of **Access Key ID** and **Secret Access Key** from the instructors
- Check list Use Specific Region
- Put Region as **Other-Specify**
- Copy and Paste the Endpoint
  ```text
  s3.us-south.cloud-object-storage.appdomain.cloud
  ```
  
  <img width="1020" alt="image" src="https://github.com/user-attachments/assets/e00155e8-6672-4516-8c92-5c6428c6c6e2" />
  
- Check list Use Specific Region
- Put Signin region as **Other-Specify**
- Copy and Paste the Endpoint
  ```text
  us-south
  ```
- Put bucket name as **streamsets-demo**
  
<img width="1020" alt="image" src="https://github.com/user-attachments/assets/f4ef199c-d2d2-4800-8b87-288236d3ff55" />

Run the pipeline:

<img width="1020" alt="image" src="https://github.com/user-attachments/assets/c7af1635-3a63-4f88-9a52-621fc1877bc2" />


Once you have your streaming pipelines writing to IBM COS, you can use watsonx.data to leverage that data for AI and analytics workloads:

<img width="1020" alt="image" src="https://github.com/user-attachments/assets/f7ac9838-0d64-47da-b968-754e04d9d243" />

---

### Validate the pipeline and run
### 1. Validate Postgres Output
Open Postgres:

```bash
sudo su - postgres
psql
```

Run these queries:

```sql
SELECT COUNT(*) FROM financial_transactions;
SELECT * FROM financial_transactions LIMIT 20;

SELECT state, AVG(risk_score) AS avg_risk_score, COUNT(*) AS num_transactions
FROM financial_transactions
GROUP BY state
ORDER BY avg_risk_score DESC
LIMIT 5;
```

### 2. Validate Parquet Output

- Check the `/tmp/transactions` folder for local FS output
- Or, check the `streamsets-demo` bucket in IBM COS for uploaded `.parquet` files
- Ensure the files are compressed with `Snappy` and follow Parquet 2.0 format

   Check inside each parquet
