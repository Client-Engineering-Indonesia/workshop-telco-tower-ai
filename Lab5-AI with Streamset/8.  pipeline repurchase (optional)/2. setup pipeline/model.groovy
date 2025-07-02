import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import java.net.HttpURLConnection
import java.net.URL
import java.io.OutputStreamWriter

// Retrieve IAM token from record (already fetched in a prior Groovy Evaluator)
def token = records[0].value['token']

// Input field names expected by the ML model
def arrayOfInputFields = [
    "ORDER_COUNT_Sum_L6M",
    "ORDER_COUNT_Sum_L1M",
    "PAYMENT_TYPE_boleto_PAYMENT_VALUE_Sum_L1M",
    "PAYMENT_TYPE_credit_card_ORDER_COUNT_Sum_L1M",
    "PAYMENT_TYPE_voucher_ORDER_COUNT_Sum_L1M",
    "ORDER_COUNT_Sum_L3M",
    "ORDER_COUNT_Mean_L3M",
    "ORDER_COUNT_Median_L3M",
    "PAYMENT_TYPE_boleto_PAYMENT_VALUE_Sum_L3M",
    "PAYMENT_TYPE_boleto_PAYMENT_VALUE_Mean_L3M",
    "PAYMENT_TYPE_boleto_PAYMENT_VALUE_Median_L3M",
    "PAYMENT_TYPE_credit_card_PAYMENT_VALUE_Sum_L3M",
    "PAYMENT_TYPE_boleto_ORDER_COUNT_Sum_L3M",
    "PAYMENT_TYPE_boleto_ORDER_COUNT_Mean_L3M",
    "PAYMENT_TYPE_boleto_ORDER_COUNT_Median_L3M",
    "PAYMENT_TYPE_credit_card_ORDER_COUNT_Sum_L3M",
    "PAYMENT_TYPE_credit_card_ORDER_COUNT_Mean_L3M",
    "PAYMENT_TYPE_credit_card_ORDER_COUNT_Median_L3M",
    "PAYMENT_TYPE_voucher_ORDER_COUNT_Sum_L3M",
    "PAYMENT_TYPE_voucher_ORDER_COUNT_Mean_L3M",
    "PAYMENT_TYPE_voucher_ORDER_COUNT_Median_L3M",
    "ORDER_COUNT_Mean_L6M",
    "ORDER_COUNT_Median_L6M",
    "PAYMENT_TYPE_boleto_PAYMENT_VALUE_Sum_L6M",
    "PAYMENT_TYPE_boleto_PAYMENT_VALUE_Mean_L6M",
    "PAYMENT_TYPE_boleto_PAYMENT_VALUE_Median_L6M",
    "PAYMENT_TYPE_credit_card_ORDER_COUNT_Sum_L6M",
    "PAYMENT_TYPE_credit_card_ORDER_COUNT_Mean_L6M",
    "PAYMENT_TYPE_credit_card_ORDER_COUNT_Median_L6M",
    "DAYS_LAST_TRANSACT_PAYMENT_TYPE_voucher_ORDER",
    "PAYMENT_TYPE_voucher_ORDER_COUNT_Sum_L6M",
    "PAYMENT_TYPE_voucher_ORDER_COUNT_Mean_L6M",
    "PAYMENT_TYPE_voucher_ORDER_COUNT_Median_L6M"
]

if (!records || records.size() == 0) {
    throw new IllegalStateException("No records available for scoring")
}

def recordsToBeScored = arrayOfInputFields.collect { fieldName ->
    records[0].value[fieldName] ?: 0 // Default to 0 if field value is null
}

def requestBody = [
    input_data: [
        [
            fields: arrayOfInputFields,
            values: [recordsToBeScored] // one row of input, needs to be nested
        ]
    ]
]

// Convert to JSON
def jsonRequest = JsonOutput.toJson(requestBody)

// Define the deployment scoring URL
def scoringUrl = "https://us-south.ml.cloud.ibm.com/ml/v4/deployments/xxx/predictions?version=2021-05-01"

// Make the HTTP POST request
def url = new URL(scoringUrl)
HttpURLConnection connection = (HttpURLConnection) url.openConnection()
connection.setRequestMethod("POST")
connection.setRequestProperty("Content-Type", "application/json")
connection.setRequestProperty("Authorization", "Bearer ${token}")
connection.setDoOutput(true)

OutputStreamWriter writer = new OutputStreamWriter(connection.outputStream)
writer.write(jsonRequest)
writer.flush()
writer.close()

// Read and parse the response
def responseCode = connection.responseCode
def responseStream = connection.inputStream.text
def jsonSlurper = new JsonSlurper()
def parsedResponse = jsonSlurper.parseText(responseStream)

def prediction = parsedResponse.predictions[0].values[0][0]
def probability = parsedResponse.predictions[0].values[0][1]

for (record in records) {
    record.value['prediction'] = prediction
    record.value['probability'] = probability
    sdc.output.write(record)
}