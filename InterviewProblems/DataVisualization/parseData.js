// why can't i use reduce? 
    // reduce just returns one value

// why can't i use filter?
    // filter returns an array that matches a condition but i need all the objects in the array

//console.log(input);
// create a new array based on the data
var totalPayTypePerDay = function(data) {
    // create a empty variable to save date
    var outputArray = [],
        payTypesPerDay = {};
    // create an empty array to store each object
    data.values.forEach(function(value) {
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
            // if the key exists, accumlate this value and the existing value
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
}

// parse the json input
// console.log(totalPayTypePerDay(input));