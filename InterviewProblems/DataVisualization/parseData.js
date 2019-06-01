/*
Author:         Tenzin Khando
Date:           2019-05-31
Description:    consilate a json data to get the total amount for each paytype_id daily
*/

// why can't i use reduce? 
    // reduce just returns one value by going through each element in the array

// why can't i use filter?
    // filter returns an array that matches a condition but i need all the objects in the array

// why i didn't use map?
    // map returns the same array length as passed. We are reducing the size of the data which wouldn't work.

/*
Author:         Tenzin Khando
Date:           2019-05-31
create a new array based on the data
@param  data    array type
@return array of objects that is total of all pay types for that day
*/
var totalPayTypePerDay = (data) => {
    // create a empty variable to save date
    var outputArray = [],
        payTypesPerDay = {};

    // create an empty array to store each object
    data.forEach(function(value) {
        // for the first occurance where the object is empty
        if ( !('date' in payTypesPerDay) ) {
            payTypesPerDay = {date: value.date};
        } else if (payTypesPerDay.date !== value.date) {
            // then push the object into the array, set to empty object  
            outputArray.push(payTypesPerDay);
            payTypesPerDay = {date: value.date};
        }

        // see if the key exists, for the paytype_id value
        var payType = value.paytype_id;
        if (payType in payTypesPerDay) {
            // if the key exists, add this value with the existing value
            // round the amount to 2 decimal places
            var newAmount = (payTypesPerDay[payType] + value.amount + 0.00001);
            payTypesPerDay[payType] = Math.round( newAmount * 100) / 100;  
        } else {
            // if the key doesn't exists, create a new key and set the amount as value
            payTypesPerDay[payType] = value.amount;
        }
        
    });
    // account for the last index
    outputArray.push(payTypesPerDay);
    return outputArray;
};

/*
Author:         Tenzin Khando
Date:           2019-05-31
@param  payTypesObject
@return array with list of pay type ids
*/
var payTypeList = (payTypesObject) => {
    var payTypes = [];
    for( var key in payTypesObject) {
        payTypes.push(key);
    }
    return payTypes;
};