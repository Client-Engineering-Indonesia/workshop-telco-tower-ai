from random import randint

# Process records
for record in sdc.records:
    try:
        num = str(randint(1, 10000))
        customer_id = '000{}'.format(num)
        
        record.value['customer_id'] = customer_id
        sdc.output.write(record)

    except Exception as e:
        # Send record to error handling
        sdc.error.write(record, str(e))
