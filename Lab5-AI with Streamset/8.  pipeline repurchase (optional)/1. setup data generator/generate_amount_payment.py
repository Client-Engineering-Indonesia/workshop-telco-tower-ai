import random

# Mapping payment type
payment_type_map = {
    1: 'voucher',
    2: 'credit_card',
    3: 'boleto'
}

# Process records
for record in sdc.records:
    try:
        record.value['payment_amount'] = round(random.uniform(50, 100000.0), 2)
        record.value['payment_type'] = payment_type_map[random.randint(1, 3)]

        sdc.output.write(record)

    except Exception as e:
        # Send record to error handling
        sdc.error.write(record, str(e))
