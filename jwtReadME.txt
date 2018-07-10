# issues a GET request to retrieve tasks with no JWT
# HTTP 403 Forbidden status is expected
url:  http://localhost:8080/api/dashboard/data
--------------------------------------------------------------------------
# registers a new user
 "Content-Type: application/json" 
POST {
    "username": "admin",
    "password": "password"
}
http://localhost:8080/users/sign-up
--------------------------------------------------------------------------
# logs into the application (JWT is generated)
"Content-Type: application/json" 
POST {
    "username": "admin",
    "password": "password"
}
 http://localhost:8080/login
--------------------------------------------------------------------------
# Do a GET request, passing the JWT retrieved above
 "Content-Type: application/json" 
 "Authorization: Bearer xyz" (xyz is the token recveived above)
 GET 
 http://localhost:8080/api/dashboard/data

