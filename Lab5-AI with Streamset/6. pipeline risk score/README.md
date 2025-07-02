### Create a streaming Pipeline
In this step, you will create a brand new pipeline that consumes a stream of financial transactions from Kafka, enriches each transaction with a call to a risk-scoring service, and routes high-risk transactions to PostgreSQL.

- Click Build
- Click Pipelines
- Click Create a pipeline

![image](https://github.com/user-attachments/assets/0e6674ff-f2ed-4429-9110-70e0142ef20d)

- Enter the name for the pipeline as Streaming. Leave the rest of the items as the defaults.
  **Note:** Put the name of your pipeline with your name at the end. For example, **Streaming Pipeline RA**, where RA is the abbreviation name
- Click Next

<img width="1280" alt="image" src="https://github.com/user-attachments/assets/16a7ec2b-5328-4822-82bd-e0a5a444dc08" />

- Make sure the Authoring Engine is set to your engine.
- Click Save & Open in Canvas

<img width="1280" alt="image" src="https://github.com/user-attachments/assets/f5e136a4-0488-4a8a-8509-2d56c4a8b7ca" />

---

### Step 1. Consume messages from Kafka
You will start the pipeline by consuming messages from Kafka.

- Click the Add Origin widget
- Type Kafka in the search bar to search for the word Kafka
- Click on the Kafka Multitopic Consumer

![image](https://github.com/user-attachments/assets/69dc5c89-a98a-4ea2-a1f2-f04c630d6867)

A Kafka Connector will be added to the canvas. Then click on the Kafka Connector:

![image](https://github.com/user-attachments/assets/9116b09e-69db-493b-a69b-f1512c23fa6a)

- Click on the General tab
- Change the name to Kafka
- Click on the Connection tab in the lower half of the browser window, set the following properties:
  - The Kafka Connection must be defined to connect to the Kafka broker running locally and the Kafka topic is txs.
  - Put the name of your consumer group with your name at the end. For example, **StreamingDataCollectorRA**, where RA is the abbreviation name
    
<img width="1280" alt="image" src="https://github.com/user-attachments/assets/69d059a7-f7f0-40b7-ab64-f15a54e1ba58" />

- Click on the Data Format tab
- Click on the drop-down for the data formats and select **JSON** from the list

![image](https://github.com/user-attachments/assets/6fb88f67-455e-4953-a458-7799350bf014)

- Click the Preview button at the top of the screen
- Click on Configure Preview to update your preview settings

![image](https://github.com/user-attachments/assets/9e067f94-2e74-4754-afbf-fb4916d81105)

- Select the boxes for “Execute Pipeline Lifecycle Events”, “Show Record/Field Header” and “Save Preview Record Schema”
- Click Run Preview

![image](https://github.com/user-attachments/assets/fdb811bf-3c9f-445f-859f-4f190a7a8df8)

You should see message payloads input and output for the stage that look like this.

![image](https://github.com/user-attachments/assets/92a65ef4-04f0-46df-9360-ff42475d14f1)

- Click Close Preview

---

#### Step 2. Call the risk-scoring service

You will now send each message consumed from Kafka to a risk-scoring microservice. For simplicity, you will use a Fragment that is preconfigured to call the risk-scoring microservice.
**Note:** The Fragment in this exercise is a client of the risk scoring service you created earlier and it only works if the risk scoring service is actively running. Ensure the pipeline created in prerequisite lab 3 “Start a Risk Scoring Microservice Pipeline” is still running. If that pipeline is not running, you will not get any results in this step.

- Click on the Add Stage widget
- Click on Fragments to filter the types of stages
- Click on the Risk Scoring Service to add it to the canvas

![image](https://github.com/user-attachments/assets/2a611fb9-dedd-4c8f-a45f-a24e1ae2ce61)

Accept the default parameter prefix:

![image](https://github.com/user-attachments/assets/0e52e24a-1758-466e-b310-c92d74a2cffa)

- Click Done and wait a moment until the fragment is added to the canvas.
- Click on the Risk Scoring Service fragment
- Click on the General Tab
- Change the name to Risk Scoring Service

![image](https://github.com/user-attachments/assets/c482e8ab-5785-43d2-8527-88553a5105ea)

- Click on the Risk Scoring Service again and hover over it
- Click the expand button once it appears


![image](https://github.com/user-attachments/assets/b433b37f-59f1-4af2-92b7-7ceb99d84a73)

- Click on the Risk Scoring Service again and inspect its configuration.
- Click the Request tab. You can see that it will make a POST request with a pre-configured request body.

![image](https://github.com/user-attachments/assets/bac2a18d-62da-4c6c-979c-de4e8eab2008)

- Click on the Output tab.

You can see that the response is written to a risk_score output field:

![image](https://github.com/user-attachments/assets/e81d41db-496b-4b60-8faf-e4b074502b37)

- Click the Risk Scoring Service again
- Click the collapse button

![image](https://github.com/user-attachments/assets/b450f36d-1b64-451c-a069-a501cf78b190)

- Preview the pipeline again by clicking on Preview
- Click Run Preview
- Click on the Risk Scoring Service stage, and confirm the service returns a risk score value.
- Click on the risk_score item to expand it’s details showing the risk score value and the version of the algorithm used.

![image](https://github.com/user-attachments/assets/9dbefded-d1d8-4014-8f82-87a241325200)

- Click on Close Preview

---

#### Step 3. Format the risk score
The result of the previous step outputs a nested and complex risk record, but all organizations need is the single risk_score_value field.

![image](https://github.com/user-attachments/assets/1c99a516-b1f2-4c7e-a9d1-dc877f26b851)

Next, you will use an Expression Evaluator to replace the complex object with the single desired value.

- Click on the Add Stage widget
- Click Processors
- Type exp
- Click on Expression Evaluator to ad it to the pipeline
- Click on the general tab
- Type the name for the stage as Format Risk Score

![image](https://github.com/user-attachments/assets/d5c66cca-49de-4228-a000-b3889abc265c)

- Click on the Expressions tab under the Field Expressions
- Change the value of the /risk_score field and type/copy and paste the expression below
  ```text
  ${record:value('/risk_score/risk_score_value')}
  ```

![image](https://github.com/user-attachments/assets/94d32804-aeac-4dfb-8bb4-76626ac04f29)

**Note:** Make sure there are no leading or trailing spaces in the Field Expression value. An extra space may convert your integer to a string and cause errors in subsequent steps in this lab

- Click Preview
- Click Run Preview to preview the data

![image](https://github.com/user-attachments/assets/d39c93ed-530e-4362-9639-b1c54e884fa2)

- Confirm that the risk score value in the output is now a top-level, flat integer field named risk_score

![image](https://github.com/user-attachments/assets/27fc79d0-f834-4c42-90f7-8782a6ce51ef)

**Note:** Your data will be different than what is shown in the screenshot

- Click Close Preview

---

#### Step 4. Filter high-risk transactions
Next, you will use a Stream Selector to route all transactions with a risk-score greater than a user-defined threshold to Postgres. The threshold is defined in an overall pipeline parameter with a default value of 50. You can view and create this parameter by clicking on the blank space of the pipeline canvas

![image](https://github.com/user-attachments/assets/19322ac7-a17a-454e-90fd-76209d176d87)

- Click General
- Click the Show Advanced Options dropdown

![image](https://github.com/user-attachments/assets/cd291983-c8f3-4fbc-a5a2-4272eae6957f)

- Click on the Parameters tab
- Click +ADD to add a parameter

![image](https://github.com/user-attachments/assets/db2c7f74-4d68-480e-a48f-7af768961523)

To add a Stream Selector to the pipeline
- Click on the Add Stage widget
- Type stream
- Click the Stream Selector to add the stage

![image](https://github.com/user-attachments/assets/da25859d-537a-4a6e-b0c8-562568af8772)

- The selector will be added to the canvas.
- Click the General tab
- Type the name for the stage to be Select High Risk Txs:

![image](https://github.com/user-attachments/assets/2e9da0cf-d255-492e-ada4-79ef9f208566)

- Click on the Conditions tab
- Click the Add Another button and type or copy/paste the text below for condition #1
  ```text
    ${record:value('/risk_score') > HIGH_RISK_THRESHOLD}
  ```

![image](https://github.com/user-attachments/assets/39dbad20-96be-4330-ada8-db40e307cdd3)

---

#### Step 5. Write high-risk transactions to PostgreSQL
On the Canvas, click the Add Stage widget Type jdbc in the search bar

- Click on JDBC Producer to add it to stream #1 of the Stream Selector

![image](https://github.com/user-attachments/assets/06bfb123-2159-44b8-a419-0eae8dba67c0)

- Click on the General tab
- Change the JDBC Producer stage name to Postgres

![image](https://github.com/user-attachments/assets/0a0c6aa3-fdaa-485c-9ac0-89c8f65ec88d)

- Click on the JDBC tab
- Select the predefined Postgres Connection
- Set (type) the schema to be public and the table name to be financial_transactions

![image](https://github.com/user-attachments/assets/fd8e5aa5-e3a0-45bd-8d28-3dbd8561e980)

---

#### Step 6. Discard low-risk transactions
Next, you will add a Trash stage to stream #2 of the Stream Selector so that low-risk transactions (the ones not sent to Postgres) are discarded:

- Click on Add Stage
- Click on Trash

![image](https://github.com/user-attachments/assets/3fd62f80-0e31-4c4f-8149-929d73532fa5)

The pipeline is now complete!

**Validate the Pipeline**
- Click the Validate button and make sure the validation is successful as shown below.

![image](https://github.com/user-attachments/assets/55a7faa0-3934-4f89-ba1b-5807412f5a50)

**Run the Streaming Pipeline**
- Click on Draft Run
- Click on Start with Click Start
- Parameters menu item and leave the default of 50.

**Note:** Using “Start with Parameters” is how you can change the value of a parameter at run-time if needed, and not have to hard code it in the stages. You should see metrics (that continue to grow) and statuses like below.

![image](https://github.com/user-attachments/assets/090989ba-d9c6-4a6d-b149-db0ffaaf97d3)

- Click on the Stream Selector (Select High Risk Txs) transactions to see the ratio of high-risk and low-risk
- Stream/output 1 represents high-risk transactions that are sent to Postgres and stream/output 2 represents low-risk transactions that are discarded to trash (i.e., not saved)

![image](https://github.com/user-attachments/assets/2185bdca-36ce-41dc-9a51-9aabb5a1a513)

- Snapshot data moving through the Streaming Pipeline. While the pipeline is running, click the Snapshot button

![image](https://github.com/user-attachments/assets/f054640e-180d-45e3-9d87-5388cd443e9a)

- Click the Capture Snapshot. Once a snapshot has been captured,
- Click the View button
  ![image](https://github.com/user-attachments/assets/65436e86-b186-4932-be36-1fc55836514a)

---

#### Check the data flow in the pipeline
- Click on each stage to inspect the data as it flows through the pipeline. For example, we can see the risk score returned by the Risk Scoring Service by clicking on the Risk Scoring Service stage, and looking at the output as shown below.

![image](https://github.com/user-attachments/assets/59574e59-e97b-44b1-aff4-654fc8246bcd)

- Click on the Postgres stage, and you can see that records written to Postgres have risk scores > 50, as shown in the input for this stage. (See below)

![image](https://github.com/user-attachments/assets/d4bb12b8-c8f8-4aef-884e-fcad06560822)

- Clicking on the trash / Discarded Low Risk Txs stage, you can see that the discarded messages have risk scores <= 50.

![image](https://github.com/user-attachments/assets/7d7699a9-793e-457e-a4da-f7f1e0d725ea)

- Click Close
- Click Stop
- Check in the completed pipeline for this step by clicking on the Check-in button

![image](https://github.com/user-attachments/assets/be40ce27-16f5-463d-8388-07748cdfe641)

- When prompted, click the Publish and Close button:

![image](https://github.com/user-attachments/assets/2c632269-8499-4752-bd8a-bc20a30ad9ce)
