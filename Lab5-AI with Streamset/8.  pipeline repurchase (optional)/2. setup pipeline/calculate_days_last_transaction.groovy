import java.util.*
import java.util.stream.Collectors
import java.util.Random
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

def formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
def random = new Random()

// Initialize Map to store last 2 voucher transactions per user
def transactionHistory = [:]

// Process each record
for (record in records) {
    try {
        def userId = record.value['customer_id']
        def type = record.value['payment_type']
        
        if (!userId || !type) continue  // Skip jika ada nilai null

        def timestampStr = record.value["purchase_datetime"]
        def localDateTime = LocalDateTime.parse(timestampStr, formatter)
        def epochMillis = localDateTime.atZone(ZoneId.of("UTC")).toInstant().toEpochMilli()

        // Initialize user's history if not exists
        transactionHistory.putIfAbsent(userId, new LinkedList<>())

        // Process only 'voucher' transactions
        if (type == 'voucher') {
            transactionHistory[userId].add([epochMillis: epochMillis])

            // Keep only the last 2 records
            if (transactionHistory[userId].size() > 2) {
                transactionHistory[userId].removeFirst()
            }
        }

        // Compute days since last voucher transaction
        def daysLastTransactVoucher = 999000  // Default jika tidak ada transaksi

        if (transactionHistory[userId].size() == 2) {
            daysLastTransactVoucher = (transactionHistory[userId][1].epochMillis - transactionHistory[userId][0].epochMillis) / 86400000
        } else if (transactionHistory[userId].size() == 1) {
            daysLastTransactVoucher = 0
        }

        // Return aggregated data
        record.value['DAYS_LAST_TRANSACT_PAYMENT_TYPE_voucher_ORDER'] = daysLastTransactVoucher

        sdc.output.write(record)
    } catch (Exception e) {
        sdc.error.write(record, e.toString())
    }
}