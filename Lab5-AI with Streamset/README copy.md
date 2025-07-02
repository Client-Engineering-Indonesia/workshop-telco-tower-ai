# Data Integration with StreamSets

This lab guides you through setting up a complete data integration flow using **StreamSets**, from environment setup to building a credit scoring machine learning pipeline.

### Key Features
1. **No-Code Data Integration**  
   IBM StreamSets provides a rich graphical interface for building pipelines using drag-and-drop connectors and processors—no coding required.

2. **Schema Flexibility**  
   StreamSets handles dynamic and evolving data schemas seamlessly. It automatically adapts to changes, ensuring pipelines remain functional even when data structures shift.

3. **Modular and Reusable Pipelines**  
   Build efficient and scalable pipelines using reusable fragments, parameterization, and job templates. This promotes maintainability and reduces duplication.

4. **Custom Data Transformations**  
   Add business-specific logic using embedded scripts (Groovy, Jython, and more), enabling highly customized data processing within pipelines.

5. **Real-Time Monitoring and Debugging**  
   Monitor pipelines with real-time metrics, snapshots, and previews. This visibility allows for quick issue identification and performance optimization.

6. **Broad Connectivity**  
   Connect seamlessly to a wide range of data sources and targets including databases, cloud storage, messaging systems, and more—across platforms and technologies.

---

### Step 1. Setup StreamSets Platform  
Begin by installing and configuring the StreamSets platform environment.  
📂 [1. setup streamsets](https://github.com/Client-Engineering-Indonesia/workshop-maybank-2025/tree/main/Lab%203%20-%20Data%20Integration%20with%20Streamsets/1.%20setup%20streamsets)


### Step 2. (Optional) Setup StreamSets Engine (Data Collector)  
If you're running a self-managed instance or want full control over your pipelines, set up your own StreamSets Data Collector engine.  
📂 [2. setup data collector](https://github.com/Client-Engineering-Indonesia/workshop-maybank-2025/tree/main/Laba%203%20-%20Data%20Integration%20with%20Streamsets/2.%20setup%20data%20collector)


### Step 3. Setup Pipeline: Data Generator  
This step walks you through creating a simulated data generator pipeline to feed downstream processing.  
📂 [3. data generator](https://github.com/Client-Engineering-Indonesia/workshop-maybank-2025/tree/main/Lab%203%20-%20Data%20Integration%20with%20Streamsets/3.%20data%20generator)


### Step 4. Setup Pipeline: Machine Learning (Credit Scoring)  
Finally, build and deploy a machine learning pipeline for credit scoring using the previously generated data.  
📂 [4. credit pipeline](https://github.com/Client-Engineering-Indonesia/workshop-maybank-2025/tree/main/Lab%203%20-%20Data%20Integration%20with%20Streamsets/4.%20credit%20pipeline)
