import java.util.*
import java.util.stream.Collectors

// Initialize Map to store last 180 transactions per user
def transactionHistory = [:]
def maxRecords = 180  // Simpan sebagai variabel agar fleksibel

// Process each record
for (record in records) {
    try {
        def userId = record.value['customer_id']
        if (!userId) continue  // Skip jika userId tidak valid

        def type = record.value['payment_type']
        def amount = record.value['payment_amount'] ?: 0
        def amountBoleto = 0, amountCreditCard = 0, amountVoucher = 0
        def countBoleto = 0, countCreditCard = 0, countVoucher = 0

        // Gunakan switch-case untuk pemetaan tipe pembayaran
        switch (type) {
            case 'boleto':
                amountBoleto = amount
                countBoleto = 1
                break
            case 'credit_card':
                amountCreditCard = amount
                countCreditCard = 1
                break
            case 'voucher':
                amountVoucher = amount
                countVoucher = 1
                break
        }

        // Initialize user's history if not exists
        def userTransactions = transactionHistory.getOrDefault(userId, new LinkedList<>())

        // Add new transaction
        userTransactions.add([
            amount: amount,
            amountBoleto: amountBoleto,
            amountCreditCard: amountCreditCard,
            amountVoucher: amountVoucher,
            countBoleto: countBoleto,
            countCreditCard: countCreditCard,
            countVoucher: countVoucher
        ])

        // Keep only the last 180 records
        if (userTransactions.size() > maxRecords) {
            userTransactions.removeFirst()
        }

        transactionHistory[userId] = userTransactions  // Simpan kembali ke map

        // Perform Aggregation
        def totalSpentBoleto = userTransactions.sum { it.amountBoleto }
        def totalSpentCreditCard = userTransactions.sum { it.amountCreditCard }
        def totalSpentVoucher = userTransactions.sum { it.amountVoucher }
        def totalCountBoleto = userTransactions.sum { it.countBoleto }
        def totalCountCreditCard = userTransactions.sum { it.countCreditCard }
        def totalCountVoucher = userTransactions.sum { it.countVoucher }

        // Menghindari pembagian dengan nol
        def divisor = Math.max(userTransactions.size(), 1)

        // Return aggregated data
        record.value['ORDER_COUNT_Sum_L6M'] = userTransactions.size()
        record.value['ORDER_COUNT_Mean_L6M'] = userTransactions.size() / divisor
        record.value['ORDER_COUNT_Median_L6M'] = userTransactions.size() / divisor
        record.value['PAYMENT_TYPE_boleto_PAYMENT_VALUE_Sum_L6M'] = totalSpentBoleto
        record.value['PAYMENT_TYPE_boleto_PAYMENT_VALUE_Mean_L6M'] = totalSpentBoleto / divisor
        record.value['PAYMENT_TYPE_boleto_PAYMENT_VALUE_Median_L6M'] = totalSpentBoleto / divisor
        record.value['PAYMENT_TYPE_credit_card_ORDER_COUNT_Sum_L6M'] = totalCountCreditCard
        record.value['PAYMENT_TYPE_credit_card_ORDER_COUNT_Mean_L6M'] = totalCountCreditCard / divisor
        record.value['PAYMENT_TYPE_credit_card_ORDER_COUNT_Median_L6M'] = totalCountCreditCard / divisor
        record.value['PAYMENT_TYPE_voucher_ORDER_COUNT_Sum_L6M'] = totalCountVoucher
        record.value['PAYMENT_TYPE_voucher_ORDER_COUNT_Mean_L6M'] = totalCountVoucher / divisor
        record.value['PAYMENT_TYPE_voucher_ORDER_COUNT_Median_L6M'] = totalCountVoucher / divisor

        sdc.output.write(record)

    } catch (Exception e) {
        sdc.error.write(record, e.toString())
    }
}