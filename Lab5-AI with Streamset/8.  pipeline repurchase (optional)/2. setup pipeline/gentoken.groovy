import groovy.json.JsonSlurper
import java.net.HttpURLConnection
import java.net.URL
import java.io.OutputStreamWriter
import groovy.json.JsonOutput

// Replace with your actual API key
def apiKey = "xxx"
def urlString = "https://iam.cloud.ibm.com/identity/token"
def url = new URL(urlString)
def connection = url.openConnection() as HttpURLConnection

// Configure request
connection.setRequestMethod("POST")
connection.setDoOutput(true)
connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
connection.setRequestProperty("Accept", "application/json")

// Request body
def requestBody = "grant_type=urn:ibm:params:oauth:grant-type:apikey&apikey=${apiKey}"
def writer = new OutputStreamWriter(connection.outputStream)
writer.write(requestBody)
writer.flush()
writer.close()

// Read response
def responseCode = connection.responseCode
def token = ""

if (responseCode == 200) {
    def responseText = connection.inputStream.text
    def jsonResponse = new JsonSlurper().parseText(responseText)
    token = jsonResponse.access_token
} else {
    println "Error: HTTP ${responseCode}"
    println connection.errorStream?.text
}

// Append token to each record and write to output (StreamSets context)
for (record in records) {
    record.value['token'] = token
    sdc.output.write(record)
}