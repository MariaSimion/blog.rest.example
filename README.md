GET http://localhost:8080/blog.rest.example/articles

Pentru afisarea articolelor


Pentru inserare

POST http://localhost:8080/blog.rest.example/articles

Header: Content-Type : application/json

Body:

{
"id": "559ce3f37d9d1e4833344225",
"title": "title",
"content": "content",
"isbdn": null,
"authorsList": [ ]
}