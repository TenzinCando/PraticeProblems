/*
Author:         Tenzin Khando
Date:           2019-05-31
Description:    consolidate an array data to get the daily total amount for each paytype_id
*/

// why can't i use reduce? 
    // reduce just returns one value by going through each element in the array

// why can't i use filter?
    // filter returns an array that matches a condition but i need all the objects in the array

// why i didn't use map?
    // map returns the same array length as passed. We are reducing the size of the data which wouldn't work.

/*
@param  values    array type
@return array of objects that is total of all pay types for that day
*/
let totalPayTypePerDay = ( values = [] ) => {
    // check if values is empty
    if (values.length === 0) return [];

    // create a empty array and initialize first date
    let outputArray = [],
        payTypesPerDay = {date: values[0].date};

    // create an empty array to store each object
    for ( let value of values ) {
        if ( payTypesPerDay.date !== value.date ) {
            // then push the object into the array, set to empty object  
            outputArray.push(payTypesPerDay);
            payTypesPerDay = {date: value.date};
        }

        let { paytype_id: payType, amount } = value;
        
        // see if the key exists for the paytype_id value
        if ( payType in payTypesPerDay ) {
            // if the key exists, add this value with the existing value
            // round the amount to 2 decimal places
            amount = payTypesPerDay[payType] + amount + 0.00001;
            amount = Math.round( amount * 100) / 100;  
        }

        payTypesPerDay[payType] = amount;
    }
    // add the last value from the data
    outputArray.push( payTypesPerDay );

    return outputArray;
};

