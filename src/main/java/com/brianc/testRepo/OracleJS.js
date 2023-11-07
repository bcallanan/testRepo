/**
 * 
 */
process.stdin.resume();
process.stdin.setEncoding('ascii');

var input_stdin = "";
var input_stdin_array = "";
var input_currentline = 0;

process.stdin.on('data', function (data) {
    input_stdin += data;
});

process.stdin.on('end', function () {
    input_stdin_array = input_stdin.split("\n");
    main();    
});

function readLine() {
    return input_stdin_array[input_currentline++];
}

/*
Write a Copy function
For a given input return the eligible group for copy ?
 Document(s) can not be copied if it exists in the target group
 
 Input : [1,2]  Output: 3
 Input : [5]   Output: 1,2
*/

function copy( jsonMap ) {
	
	for (const [key, value] of jsonMap.entries()) {
		
	}
}

var jsonString = { "docList" : [ {
    "group" : 1,
    "documents" : [ {
      "id" : "1",
      "docStoreId" : "1000"
      },
      {
      "id" : "2",
      "docStoreId" : "1001"
      } ]
  }, {
    "group" : 2,
    "documents" : [ {
      "id" : "3",
      "docStoreId" : "1000"
      }, {
      "id" : "4",
      "docStoreId" : "1001"
      }]
  }, {
    "group" : 3,
    "documents" : [ {
      "id" : "5",
      "docStoreId" : "1003"
      }, {
      "id" : "6",
      "docStoreId" : "1004"
      }]
  }]
}

function main() {
    copy(jsonString)    
}

copy = () => {
    console.log("function implemention goes here")
}
