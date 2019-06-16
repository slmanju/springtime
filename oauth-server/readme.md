### get access token
`curl -X POST \
   http://localhost:9090/oauth/token \
   -H 'Authorization: Basic bWFuanVsYTptYW5qdWxh' \
   -H 'Content-Type: application/x-www-form-urlencoded' \
   -d 'grant_type=password&username=user&password=secret'`
   
### access secured resource
`curl -X GET \
   http://localhost:9090/ \
   -H 'Authorization: Bearer 13571c0d-828f-4677-9dbe-151934f6261f'`
   
