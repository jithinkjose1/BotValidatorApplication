# BotValidator
BotValidatorApplication provides apis to make sure our application is accessed by humans and not a by any computers or bot
When a user/client requests for a question, a question with random numbers will be created for that particular client request. So that while validating the answer, we will verify whether that question is previously given to that particular client.

1) GET of "http://localhost:8080/botValidator" can be used to get the question for validation
  Response format:
      {
      "id": 3,
      "question": "Please sum the numbers 87,55,15"
      }
2) POST of "http://localhost:8080/botValidator" can be used to validate the answer
  Request format:
      {
      "id": 28,
      "question": "Please sum the numbers 75,4,79",
      "answer": 158
      }
   Response will send HTTP 200 OK, if the sum of the numbers is correct  
   Response will send HTTP 400 Bad Request, if the sum of the numbers is wrong or if it’s an invalid request
   

