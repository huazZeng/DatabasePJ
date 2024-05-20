# Tabel
## book
* id
* user_id
* caterer_id
* time

## caterer
* id
* name
* password
* address

## collect
* user_id
* caterer_id 
* food_id

## food 
* id
* name
* price
* description

## food_type
* caterer_id
* food_id
* type

## order
* id
* time
* status
* order_food_id
* total_price

## order_food
* order_id
* caterer_id
* food_id
* real_price

## price
* caterer_id
* food_id
* time
* price

## root
* id
* password

## user
* id
* name
* is_student
* password
* s_id
* age
* gender