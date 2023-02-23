# ONEiOFizzBuzz

Back-end for FizzBuzz assignment

## API

```http
GET /api/fizzbuzz?number=[NUMBER]
```
Number has to be positive

## Response

With `NUMBER` as 15, response would be a string 

```
1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz 
```

## Status Codes

Server returns the following status codes in its API:

| Status Code | Description             |
| :--- |:------------------------|
| 200 | `OK`                    |
| 400 | `BAD REQUEST`           |
| 500 | `INTERNAL SERVER ERROR` |