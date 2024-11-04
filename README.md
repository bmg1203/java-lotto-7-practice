# java-lotto-precourse

## Overview

- this project is Korean Lotto machine service.
- you can play simple simulation Korean Lotto.

## function

### Lotto relation

- generate 6 numbers randomly , non-duplicated from 1 to 45 and sorted in ascending,
   - [x] sort numbers in ascending order
- manage Internal Lotto data
   - [x] verify duplicated numbers

- provide interface for Lotto Data
   - [x] return stored Lotto data
   - [x] return matched Prize Tier by comparing winning numbers
   - [x] create empty Lotto Data

- manage Lotto Prize Tier
   - [x] return matched Prize Tier


### Lotto Machine relation

- provide interface for Machine service logic
  - [x] create Lotto more than ones
  - [x] save win Lotto number and bonus number from user
  - [x] return winning info of created Lottos
  - [x] calculate rate of return

- provide user interface
  - [x] read input money from user 
  - [x] calculate a number of Lotto user buy
  - [x] read input winning number and **bonus number from user**
  - [x] print bought Lotto info that places ", " between numbers
  - [x] print winning Lotto info with the thousand separator from bought Lotto info
  - [x] repeat read input when input is invalid
  - [x] print rate of return
  - [x] validate money input
  - [x] validate winning numbers input
  - [x] validate bonus number input

- handle user request
  - [x] deliver user request and info 

### Validation relation

- provide validation logic
   - [x] validate string whether string is numeric or not
   - [x] validate string whether numeric string is out of Int type range or not
   - [x] validate string whether numeric string is positive or not
   - [x] validate string whether string is blank or not
   - [x] validate number whether number is divisible by specific number or not
   - [x] validate number whether number is out of specific range or not
   - [x] validate list whether list is equal to specific size or not
   - [x] validate list whether list has duplicated element

### Throwing Exception logic

- throw Exception with printing exception message
   - [x] print Exception Message
   - [x] throw IllegalArgumentException exception